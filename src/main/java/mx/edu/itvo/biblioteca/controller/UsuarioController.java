package mx.edu.itvo.biblioteca.controller;


import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import jakarta.validation.Valid;


import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.UsuarioRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.UsuarioResponseDTO;
import mx.edu.itvo.biblioteca.service.UsuarioService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.web.bind.annotation.*;



/**
 * Controlador REST para la gestión de usuarios.
 *
 * Expone servicios CRUD y consulta
 * del usuario autenticado.
 *
 * @author Conce
 * @version 2.1
 * @since 1.0
 */

@Tag(
    name = "👥 Usuarios",
    description = "Administración de usuarios de la biblioteca."
)


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {



    /**
     * Servicio usuarios.
     */
    private final UsuarioService usuarioService;





    /**
     * Constructor.
     *
     * @param usuarioService Servicio usuarios.
     */
    public UsuarioController(
            UsuarioService usuarioService) {


        this.usuarioService =
                usuarioService;

    }






    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista usuarios.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listar() {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de usuarios.",
                        usuarioService.listar()
                )
        );

    }







    /**
     * Obtiene usuarios activos.
     *
     * @return Usuarios activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listarActivos() {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de usuarios activos.",
                        usuarioService.listarActivos()
                )
        );

    }







    /**
     * Obtiene usuario autenticado actualmente.
     *
     * Endpoint utilizado por Dashboard.
     *
     * GET /api/usuarios/me
     *
     * @return Información usuario actual.
     */
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> usuarioActual() {


        Authentication authentication =
                SecurityContextHolder
                .getContext()
                .getAuthentication();




        String correo =
                authentication.getName();




        UsuarioResponseDTO usuario =
                usuarioService.buscarPorCorreo(
                        correo
                );




        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario autenticado.",
                        usuario
                )
        );

    }







    /**
     * Busca usuario por ID.
     *
     * @param id Identificador.
     * @return Usuario.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorId(
            @PathVariable Integer id) {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorId(id)
                )
        );

    }







    /**
     * Busca usuario por matrícula.
     *
     * @param matricula Matrícula.
     * @return Usuario.
     */
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorMatricula(
            @PathVariable String matricula) {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorMatricula(
                                matricula
                        )
                )
        );

    }







    /**
     * Busca usuario por correo.
     *
     * @param correo Correo.
     * @return Usuario.
     */
    @GetMapping("/correo/{correo}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> buscarPorCorreo(
            @PathVariable String correo) {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario encontrado.",
                        usuarioService.buscarPorCorreo(
                                correo
                        )
                )
        );

    }







    /**
     * Busca usuarios por nombre.
     *
     * @param nombre Nombre.
     * @return Usuarios.
     */
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> buscarPorNombre(
            @RequestParam String nombre) {


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        usuarioService.buscarPorNombre(
                                nombre
                        )
                )
        );

    }







    /**
     * Guarda usuario.
     *
     * @param request Datos usuario.
     * @return Usuario creado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> guardar(
            @Valid
            @RequestBody
            UsuarioRequestDTO request) {


        UsuarioResponseDTO response =
                usuarioService.guardar(
                        request
                );


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new ApiResponse<>(
                                true,
                                "Usuario registrado correctamente.",
                                response
                        )
                );

    }







    /**
     * Actualiza usuario.
     *
     * @param id Identificador.
     * @param request Datos.
     * @return Usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid
            @RequestBody
            UsuarioRequestDTO request) {


        UsuarioResponseDTO response =
                usuarioService.actualizar(
                        id,
                        request
                );


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario actualizado correctamente.",
                        response
                )
        );

    }







    /**
     * Eliminación lógica usuario.
     *
     * @param id Identificador.
     * @return Confirmación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {


        usuarioService.eliminar(
                id
        );


        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario eliminado correctamente.",
                        null
                )
        );

    }

}