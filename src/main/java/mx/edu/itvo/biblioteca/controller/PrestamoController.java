package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.service.PrestamoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controlador REST para la gestión de préstamos.
 *
 * <p>
 * Expone los endpoints para registrar,
 * consultar, actualizar, devolver
 * y renovar préstamos.
 * </p>
 *
 * @author Conce
 * @version 4.0
 * @since Sprint 17
 */
@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    /**
     * Servicio de préstamos.
     */
    private final PrestamoService prestamoService;

    /**
     * Constructor.
     *
     * @param prestamoService Servicio.
     */
    public PrestamoController(
            PrestamoService prestamoService) {

        this.prestamoService =
                prestamoService;

    }

    @Operation(
            summary = "Lista todos los préstamos",
            description = "Obtiene el listado completo de préstamos registrados.")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Listado obtenido correctamente")
    })
    @GetMapping
    public List<PrestamoResponseDTO> listar() {

        return prestamoService.listar();

    }

    /**
     * Lista los préstamos activos.
     *
     * @return Lista.
     */
    @GetMapping("/activos")
    public List<PrestamoResponseDTO>
            listarActivos() {

        return prestamoService
                .listarActivos();

    }

    /**
     * Lista préstamos pendientes
     * de devolución.
     *
     * @return Lista.
     */
    @GetMapping("/pendientes")
    public List<PrestamoResponseDTO>
            listarPendientes() {

        return prestamoService
                .listarPendientesDevolucion();

    }

    /**
     * Lista préstamos vencidos.
     *
     * @return Lista.
     */
    @GetMapping("/vencidos")
    public List<PrestamoResponseDTO>
            listarVencidos() {

        return prestamoService
                .buscarVencidos();

    }

    @Operation(
            summary = "Buscar préstamo por ID")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Préstamo encontrado"),
        @ApiResponse(
                responseCode = "404",
                description = "Préstamo no encontrado")
    })
    @GetMapping("/{id}")
    public PrestamoResponseDTO buscarPorId(
            @PathVariable Integer id) {

        return prestamoService
                .buscarPorId(id);

    }

    @Operation(
            summary = "Buscar préstamo por folio")
    @GetMapping("/folio/{folio}")
    public PrestamoResponseDTO buscarPorFolio(
            @PathVariable String folio) {

        return prestamoService
                .buscarPorFolio(folio);

    }

    @Operation(
        summary = "Historial de préstamos de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public List<PrestamoResponseDTO>
            buscarPorUsuario(
                    @PathVariable
                    Integer idUsuario) {

        return prestamoService
                .buscarPorUsuario(
                        idUsuario);

    }

    @Operation(
        summary = "Préstamos de un ejemplar")
    @GetMapping("/ejemplar/{idEjemplar}")
    public List<PrestamoResponseDTO>
            buscarPorEjemplar(
                    @PathVariable
                    Integer idEjemplar) {

        return prestamoService
                .buscarPorEjemplar(
                        idEjemplar);

    }

    @Operation(
            summary = "Registrar préstamo",
            description = "Registra un nuevo préstamo para un usuario.")
    @ApiResponses({
        @ApiResponse(
                responseCode = "201",
                description = "Préstamo registrado correctamente"),
        @ApiResponse(
                responseCode = "400",
                description = "Error de validación")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrestamoResponseDTO registrar(
            @Valid
            @RequestBody
            PrestamoRequestDTO request) {

        return prestamoService
                .registrarPrestamo(
                        request);

    }

    @Operation(
        summary = "Actualizar préstamo")
    @PutMapping("/{id}")
    public PrestamoResponseDTO actualizar(
            @PathVariable Integer id,
            @Valid
            @RequestBody
            PrestamoUpdateDTO request) {

        return prestamoService
                .actualizar(
                        id,
                        request);

    }

    /**
     * Registra la devolución
     * de un préstamo.
     *
     * @param id Identificador.
     * @return Préstamo.
     */
    @Operation(
        summary = "Registrar devolución")
    @PutMapping("/{id}/devolver")
    public PrestamoResponseDTO devolver(
            @PathVariable Integer id) {

        return prestamoService
                .devolver(id);

    }

    @Operation(
        summary = "Renovar préstamo")
    @PutMapping("/{id}/renovar")
    public PrestamoResponseDTO renovar(
            @PathVariable Integer id,
            @RequestParam Integer dias) {

        return prestamoService
                .renovar(
                        id,
                        dias);

    }

}