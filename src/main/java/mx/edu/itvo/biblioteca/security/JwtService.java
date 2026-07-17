package mx.edu.itvo.biblioteca.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Servicio encargado de generar y validar
 * los tokens JWT del Sistema Integral de Biblioteca.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
public class JwtService {

    /**
     * Clave secreta utilizada para firmar los JWT.
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * Tiempo de expiración del token en milisegundos.
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Obtiene la llave utilizada para firmar
     * y validar los tokens.
     *
     * @return Llave secreta.
     */
    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));

    }

    /**
     * Genera un token para un usuario autenticado.
     *
     * @param userDetails Usuario autenticado.
     * @return Token JWT.
     */
    public String generateToken(
            UserDetails userDetails) {

        return generateToken(
                new HashMap<>(),
                userDetails);

    }

    /**
     * Genera un token con claims adicionales.
     *
     * @param extraClaims Claims personalizados.
     * @param userDetails Usuario autenticado.
     * @return Token JWT.
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {

        Date now = new Date();

        Date expirationDate =
                new Date(now.getTime() + expiration);

        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getSigningKey())
                .compact();

    }

    /**
     * Obtiene el usuario contenido en el token.
     *
     * @param token Token JWT.
     * @return Correo del usuario.
     */
    public String extractUsername(
            String token) {

        return extractClaim(
                token,
                Claims::getSubject);

    }

    /**
     * Obtiene la fecha de expiración.
     *
     * @param token Token JWT.
     * @return Fecha.
     */
    public Date extractExpiration(
            String token) {

        return extractClaim(
                token,
                Claims::getExpiration);

    }

    /**
     * Extrae un claim específico.
     *
     * @param <T> Tipo del claim.
     * @param token Token JWT.
     * @param claimsResolver Resolver.
     * @return Claim solicitado.
     */
    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);

    }

    /**
     * Obtiene todos los claims del token.
     *
     * @param token Token JWT.
     * @return Claims.
     */
    private Claims extractAllClaims(
            String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    /**
     * Indica si el token ha expirado.
     *
     * @param token Token JWT.
     * @return true si expiró.
     */
    private boolean isTokenExpired(
            String token) {

        return extractExpiration(token)
                .before(new Date());

    }

    /**
     * Valida el token.
     *
     * @param token Token JWT.
     * @param userDetails Usuario autenticado.
     * @return true si es válido.
     */
    public boolean isTokenValid(
            String token,
            UserDetails userDetails) {

        String username =
                extractUsername(token);

        return username.equals(
                userDetails.getUsername())
                && !isTokenExpired(token);

    }

}