package mx.edu.itvo.biblioteca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.EjemplarRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EjemplarResponseDTO;
import mx.edu.itvo.biblioteca.service.EjemplarService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de ejemplares.
 *
 * Expone los servicios CRUD de la entidad Ejemplar.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */

@Tag(
    name = "📦 Ejemplares",
    description = "Administración de ejemplares físicos."
)

@RestController
@RequestMapping("/api/ejemplares")
@CrossOrigin(origins = "*")
public class EjemplarController {

    /**
     * Servicio de ejemplares.
     */
    private final EjemplarService ejemplarService;

    /**
     * Constructor.
     *
     * @param ejemplarService Servicio de ejemplares.
     */
    public EjemplarController(
            EjemplarService ejemplarService) {

        this.ejemplarService = ejemplarService;

    }

    /**
     * Obtiene todos los ejemplares.
     *
     * @return Lista de ejemplares.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<EjemplarResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de ejemplares.",
                        ejemplarService.listar()));

    }

    /**
     * Obtiene únicamente los ejemplares activos.
     *
     * @return Lista de ejemplares activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<EjemplarResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de ejemplares activos.",
                        ejemplarService.listarActivos()));

    }

    /**
     * Busca un ejemplar por su identificador.
     *
     * @param id Identificador.
     * @return Ejemplar encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EjemplarResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Ejemplar encontrado.",
                        ejemplarService.buscarPorId(id)));

    }

    /**
     * Busca un ejemplar por su código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return Ejemplar encontrado.
     */
    @GetMapping("/codigo/{codigoInventario}")
    public ResponseEntity<ApiResponse<EjemplarResponseDTO>>
            buscarPorCodigoInventario(
                    @PathVariable String codigoInventario) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Ejemplar encontrado.",
                        ejemplarService.buscarPorCodigoInventario(
                                codigoInventario)));

    }
                /**
     * Busca los ejemplares pertenecientes a un libro.
     *
     * @param idLibro Identificador del libro.
     * @return Lista de ejemplares.
     */
    @GetMapping("/libro/{idLibro}")
    public ResponseEntity<ApiResponse<List<EjemplarResponseDTO>>> buscarPorLibro(
            @PathVariable Integer idLibro) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de ejemplares del libro.",
                        ejemplarService.buscarPorLibro(idLibro)));

    }

    /**
     * Busca los ejemplares por estado.
     *
     * @param idEstadoEjemplar Identificador del estado.
     * @return Lista de ejemplares.
     */
    @GetMapping("/estado/{idEstadoEjemplar}")
    public ResponseEntity<ApiResponse<List<EjemplarResponseDTO>>> buscarPorEstado(
            @PathVariable Integer idEstadoEjemplar) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de ejemplares por estado.",
                        ejemplarService.buscarPorEstado(
                                idEstadoEjemplar)));

    }

    /**
     * Registra un nuevo ejemplar.
     *
     * @param request Información recibida.
     * @return Ejemplar registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<EjemplarResponseDTO>> guardar(
            @Valid @RequestBody EjemplarRequestDTO request) {

        EjemplarResponseDTO response =
                ejemplarService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Ejemplar registrado correctamente.",
                        response));

    }

    /**
     * Actualiza un ejemplar.
     *
     * @param id Identificador.
     * @param request Información actualizada.
     * @return Ejemplar actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EjemplarResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody EjemplarRequestDTO request) {

        EjemplarResponseDTO response =
                ejemplarService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Ejemplar actualizado correctamente.",
                        response));

    }

    /**
     * Realiza la eliminación lógica de un ejemplar.
     *
     * @param id Identificador.
     * @return Confirmación de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        ejemplarService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Ejemplar eliminado correctamente.",
                        null));

    }

}