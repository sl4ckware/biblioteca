package mx.edu.itvo.biblioteca.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filtro encargado de validar el JWT enviado
 * en cada petición HTTP.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    /**
     * Servicio JWT.
     */
    private final JwtService jwtService;

    /**
     * Servicio de usuarios.
     */
    private final CustomUserDetailsService
            userDetailsService;

    /**
     * Constructor.
     *
     * @param jwtService Servicio JWT.
     * @param userDetailsService Servicio de usuarios.
     */
    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");

        if (authHeader == null
                || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(
                    request,
                    response);

            return;

        }

        String jwt =
                authHeader.substring(7);

        String correo =
                jwtService.extractUsername(jwt);

        if (correo != null
                && SecurityContextHolder
                .getContext()
                .getAuthentication() == null) {

            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(
                                    correo);

            if (jwtService.isTokenValid(
                    jwt,
                    userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

                authToken.setDetails(

                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);

            }

        }

        filterChain.doFilter(
                request,
                response);

    }

}