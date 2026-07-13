package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.UsuarioRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.UsuarioResponseDTO;
import mx.edu.itvo.biblioteca.service.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de usuarios.
 *
 * Expone los servicios CRUD de la entidad Usuario.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    /**
     * Servicio de usuarios.
     */
    private final UsuarioService usuarioService;

    /**
     * Constructor.
     *
     * @param usuarioService Servicio de usuarios.
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de usuarios.",
                        usuarioService.listar()));

    }

    /**
     * Obtiene únicamente los usuarios activos.
     *
     * @return Lista de usuarios activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de usuarios activos.",
                        usuarioService.listarActivos()));

    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id Identificador.
     * @return Usuario encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorId(id)));

    }

    /**
     * Busca un usuario por su matrícula.
     *
     * @param matricula Matrícula.
     * @return Usuario encontrado.
     */
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorMatricula(
            @PathVariable String matricula) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorMatricula(matricula)));

    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico.
     * @return Usuario encontrado.
     */
    @GetMapping("/correo/{correo}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorCorreo(
            @PathVariable String correo) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorCorreo(correo)));

    }

    /**
     * Busca usuarios por nombre.
     *
     * @param nombre Nombre.
     * @return Lista de usuarios.
     */
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> buscarPorNombre(
            @RequestParam String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        usuarioService.buscarPorNombre(nombre)));

    }

    /**
     * Registra un nuevo usuario.
     *
     * @param request Información recibida.
     * @return Usuario registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> guardar(
            @Valid @RequestBody UsuarioRequestDTO request) {

        UsuarioResponseDTO response =
                usuarioService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Usuario registrado correctamente.",
                        response));

    }

    /**
     * Actualiza un usuario.
     *
     * @param id Identificador.
     * @param request Información actualizada.
     * @return Usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody UsuarioRequestDTO request) {

        UsuarioResponseDTO response =
                usuarioService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario actualizado correctamente.",
                        response));

    }

    /**
     * Realiza la eliminación lógica de un usuario.
     *
     * @param id Identificador.
     * @return Confirmación de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        usuarioService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario eliminado correctamente.",
                        null));

    }

}