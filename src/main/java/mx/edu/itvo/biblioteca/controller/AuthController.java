package mx.edu.itvo.biblioteca.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itvo.biblioteca.dto.request.LoginRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LoginResponseDTO;
import mx.edu.itvo.biblioteca.service.AuthService;

/**
 * Controlador encargado de la autenticación
 * de usuarios.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /**
     * Servicio de autenticación.
     */
    private final AuthService authService;

    /**
     * Constructor.
     *
     * @param authService Servicio de autenticación.
     */
    public AuthController(
            AuthService authService) {

        this.authService = authService;

    }

    /**
     * Autentica un usuario y devuelve
     * un token JWT.
     *
     * @param request Datos del login.
     * @return Token JWT.
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid
            @RequestBody
            LoginRequestDTO request) {

        LoginResponseDTO response =
                authService.login(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

}