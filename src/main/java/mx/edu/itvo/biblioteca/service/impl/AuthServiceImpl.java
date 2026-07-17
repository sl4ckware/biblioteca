package mx.edu.itvo.biblioteca.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mx.edu.itvo.biblioteca.dto.request.LoginRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LoginResponseDTO;
import mx.edu.itvo.biblioteca.exception.BusinessException;
import mx.edu.itvo.biblioteca.security.CustomUserDetailsService;
import mx.edu.itvo.biblioteca.security.JwtService;
import mx.edu.itvo.biblioteca.service.AuthService;

/**
 * Implementación del servicio de autenticación.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    /**
     * AuthenticationManager.
     */
    private final AuthenticationManager
            authenticationManager;

    /**
     * Servicio JWT.
     */
    private final JwtService
            jwtService;

    /**
     * Servicio de usuarios.
     */
    private final CustomUserDetailsService
            userDetailsService;

    /**
     * {@inheritDoc}
     */
    @Override
    public LoginResponseDTO login(
            LoginRequestDTO request) {

        try {

            authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(

                            request.getCorreo(),

                            request.getPassword()));

        } catch (BadCredentialsException ex) {

            throw new BusinessException(
                    "Correo o contraseña incorrectos.");

        }

        UserDetails userDetails =
                userDetailsService
                        .loadUserByUsername(
                                request.getCorreo());

        String token =
                jwtService.generateToken(
                        userDetails);

        return new LoginResponseDTO(
                token);

    }

}