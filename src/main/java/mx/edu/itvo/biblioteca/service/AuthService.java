package mx.edu.itvo.biblioteca.service;

import mx.edu.itvo.biblioteca.dto.request.LoginRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LoginResponseDTO;

/**
 * Servicio encargado de la autenticación
 * de usuarios mediante JWT.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface AuthService {

    /**
     * Autentica un usuario y genera
     * un token JWT.
     *
     * @param request Datos del login.
     * @return Respuesta con el token.
     */
    LoginResponseDTO login(
            LoginRequestDTO request);

}