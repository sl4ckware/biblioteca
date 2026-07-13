package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;
import mx.edu.itvo.biblioteca.service.MultaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión
 * de multas.
 *
 * Expone los endpoints para consultar,
 * registrar y actualizar multas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@RestController
@RequestMapping("/api/multas")
public class MultaController {

    /**
     * Servicio de multas.
     */
    private final MultaService multaService;

    /**
     * Constructor.
     *
     * @param multaService Servicio.
     */
    public MultaController(
            MultaService multaService) {

        this.multaService = multaService;

    }

    /**
     * Lista todas las multas.
     *
     * @return Lista.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<MultaResponseDTO>>> listar() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.listar(),
                        "Listado de multas obtenido correctamente."));

    }

    /**
     * Lista únicamente las multas activas.
     *
     * @return Lista.
     */
    @GetMapping("/activas")
    public ResponseEntity<ApiResponse<List<MultaResponseDTO>>> listarActivas() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.listarActivas(),
                        "Listado de multas activas obtenido correctamente."));

    }

    /**
     * Busca una multa por ID.
     *
     * @param id Identificador.
     * @return Multa.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MultaResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.buscarPorId(id),
                        "Multa encontrada correctamente."));

    }

    /**
     * Busca una multa por folio.
     *
     * @param folio Folio.
     * @return Multa.
     */
    @GetMapping("/folio/{folio}")
    public ResponseEntity<ApiResponse<MultaResponseDTO>> buscarPorFolio(
            @PathVariable String folio) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.buscarPorFolio(folio),
                        "Multa encontrada correctamente."));

    }

    /**
     * Busca multas por préstamo.
     *
     * @param idPrestamo Identificador.
     * @return Lista.
     */
    @GetMapping("/prestamo/{idPrestamo}")
    public ResponseEntity<ApiResponse<List<MultaResponseDTO>>> buscarPorPrestamo(
            @PathVariable Integer idPrestamo) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.buscarPorPrestamo(idPrestamo),
                        "Listado obtenido correctamente."));

    }

    /**
     * Busca multas por usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<ApiResponse<List<MultaResponseDTO>>> buscarPorUsuario(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.buscarPorUsuario(idUsuario),
                        "Listado obtenido correctamente."));

    }
        /**
     * Busca multas por estado.
     *
     * @param estado Estado de la multa.
     * @return Lista de multas.
     */
    @GetMapping("/estado/{estado}")
    public ResponseEntity<ApiResponse<List<MultaResponseDTO>>> buscarPorEstado(
            @PathVariable String estado) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.buscarPorEstado(
                                estado),
                        "Listado de multas obtenido correctamente."));

    }

    /**
     * Registra una nueva multa.
     *
     * @param request Información de la multa.
     * @return Multa registrada.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<MultaResponseDTO>> guardar(
            @Valid
            @RequestBody
            MultaRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                multaService.guardar(
                                        request),
                                "Multa registrada correctamente."));

    }

    /**
     * Actualiza la información
     * editable de una multa.
     *
     * @param id Identificador.
     * @param request Información.
     * @return Multa actualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MultaResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid
            @RequestBody
            MultaUpdateDTO request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        multaService.actualizar(
                                id,
                                request),
                        "Multa actualizada correctamente."));

    }

}