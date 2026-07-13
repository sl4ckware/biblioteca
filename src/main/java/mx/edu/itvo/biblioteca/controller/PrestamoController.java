package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoUpdateDTO;
import mx.edu.itvo.biblioteca.service.PrestamoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión
 * de préstamos.
 *
 * Expone los servicios del módulo
 * de préstamos.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    /**
     * Servicio de préstamos.
     */
    private final PrestamoService prestamoService;

    /**
     * Constructor.
     *
     * @param prestamoService Servicio de préstamos.
     */
    public PrestamoController(
            PrestamoService prestamoService) {

        this.prestamoService = prestamoService;

    }

    /**
     * Obtiene todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<PrestamoResponseDTO>>> listar() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.listar(),
                        "Listado de préstamos obtenido correctamente."));

    }

    /**
     * Obtiene únicamente los préstamos activos.
     *
     * @return Lista de préstamos activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<PrestamoResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.listarActivos(),
                        "Listado de préstamos activos obtenido correctamente."));

    }

    /**
     * Busca un préstamo por ID.
     *
     * @param id Identificador.
     * @return Préstamo encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.buscarPorId(id),
                        "Préstamo encontrado correctamente."));

    }

    /**
     * Busca un préstamo por folio.
     *
     * @param folio Folio.
     * @return Préstamo encontrado.
     */
    @GetMapping("/folio/{folio}")
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> buscarPorFolio(
            @PathVariable String folio) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.buscarPorFolio(folio),
                        "Préstamo encontrado correctamente."));

    }

    /**
     * Obtiene los préstamos
     * de un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de préstamos.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<ApiResponse<List<PrestamoResponseDTO>>> buscarPorUsuario(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.buscarPorUsuario(idUsuario),
                        "Préstamos del usuario obtenidos correctamente."));

    }

    /**
     * Obtiene los préstamos
     * de un ejemplar.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return Lista de préstamos.
     */
    @GetMapping("/ejemplar/{idEjemplar}")
    public ResponseEntity<ApiResponse<List<PrestamoResponseDTO>>> buscarPorEjemplar(
            @PathVariable Integer idEjemplar) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.buscarPorEjemplar(idEjemplar),
                        "Préstamos del ejemplar obtenidos correctamente."));

    }

    /**
     * Obtiene los préstamos vencidos.
     *
     * @return Lista de préstamos.
     */
    @GetMapping("/vencidos")
    public ResponseEntity<ApiResponse<List<PrestamoResponseDTO>>> buscarVencidos() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        prestamoService.buscarVencidos(),
                        "Préstamos vencidos obtenidos correctamente."));

    }
        /**
     * Registra un nuevo préstamo.
     *
     * @param request Información del préstamo.
     * @return Préstamo registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> guardar(
            @Valid
            @RequestBody
            PrestamoRequestDTO request) {

        PrestamoResponseDTO response =
                prestamoService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                response,
                                "Préstamo registrado correctamente."));

    }

    /**
     * Actualiza la información editable
     * de un préstamo.
     *
     * @param id Identificador.
     * @param request Información editable.
     * @return Préstamo actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> actualizar(
            @PathVariable
            Integer id,

            @Valid
            @RequestBody
            PrestamoUpdateDTO request) {

        PrestamoResponseDTO response =
                prestamoService.actualizar(
                        id,
                        request);

        return ResponseEntity.ok(
                ApiResponse.success(
                        response,
                        "Préstamo actualizado correctamente."));

    }

    /**
     * Registra la devolución
     * de un préstamo.
     *
     * @param id Identificador.
     * @return Préstamo actualizado.
     */
    @PatchMapping("/{id}/devolver")
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> devolver(
            @PathVariable
            Integer id) {

        PrestamoResponseDTO response =
                prestamoService.devolver(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        response,
                        "Devolución registrada correctamente."));

    }

    /**
     * Renueva un préstamo.
     *
     * @param id Identificador.
     * @param dias Días adicionales.
     * @return Préstamo actualizado.
     */
    @PatchMapping("/{id}/renovar/{dias}")
    public ResponseEntity<ApiResponse<PrestamoResponseDTO>> renovar(
            @PathVariable
            Integer id,

            @PathVariable
            Integer dias) {

        PrestamoResponseDTO response =
                prestamoService.renovar(
                        id,
                        dias);

        return ResponseEntity.ok(
                ApiResponse.success(
                        response,
                        "Préstamo renovado correctamente."));

    }
    
    /**
     * Verifica si existe un folio de préstamo.
     *
     * @param folio Folio del préstamo.
     * @return true si existe.
     */
    @GetMapping("/existe/{folio}")
    public ResponseEntity<ApiResponse<Boolean>> existeFolio(
            @PathVariable
            String folio) {

        Boolean existe =
                prestamoService.existeFolio(folio);

        return ResponseEntity.ok(
                ApiResponse.success(
                        existe,
                        "Consulta realizada correctamente."));

    }

}