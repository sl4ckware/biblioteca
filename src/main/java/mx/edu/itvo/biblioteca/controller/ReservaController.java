package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import mx.edu.itvo.biblioteca.dto.request.ReservaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.ReservaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.ReservaResponseDTO;
import mx.edu.itvo.biblioteca.service.ReservaService;
import org.springframework.http.ResponseEntity;

/**
 * ============================================================
 * Sprint 18
 * Historia Técnica 18.11
 *
 * Controlador REST para la gestión
 * de reservas.
 * ============================================================
 *
 * Expone los endpoints utilizados
 * para registrar, consultar,
 * actualizar, cancelar y atender
 * reservas.
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    /**
     * Servicio.
     */
    private final ReservaService
            reservaService;

    /**
     * Constructor.
     *
     * @param reservaService Servicio.
     */
    public ReservaController(
            ReservaService reservaService) {

        this.reservaService =
                reservaService;

    }

    /**
     * Lista todas las reservas.
     *
     * @return Lista.
     */
    @GetMapping
    public List<ReservaResponseDTO>
            listar() {

        return reservaService.listar();

    }

    /**
     * Lista únicamente
     * las reservas activas.
     *
     * @return Lista.
     */
    @GetMapping("/activas")
    public List<ReservaResponseDTO>
            listarActivas() {

        return reservaService
                .listarActivas();

    }

    /**
     * Lista las reservas
     * pendientes de atención.
     *
     * @return Lista.
     */
    @GetMapping("/pendientes")
    public List<ReservaResponseDTO>
            listarPendientes() {

        return reservaService
                .listarPendientes();

    }

    /**
     * Busca una reserva
     * por identificador.
     *
     * @param id Identificador.
     * @return Reserva.
     */
    @GetMapping("/{id}")
    public ReservaResponseDTO
            buscarPorId(
                    @PathVariable
                    Integer id) {

        return reservaService
                .buscarPorId(id);

    }

    /**
     * Busca una reserva
     * por folio.
     *
     * @param folio Folio.
     * @return Reserva.
     */
    @GetMapping("/folio/{folio}")
    public ReservaResponseDTO
            buscarPorFolio(
                    @PathVariable
                    String folio) {

        return reservaService
                .buscarPorFolio(
                        folio);

    }

    /**
     * Obtiene las reservas
     * de un usuario.
     *
     * @param idUsuario Usuario.
     * @return Lista.
     */
    @GetMapping("/usuario/{idUsuario}")
    public List<ReservaResponseDTO>
            buscarPorUsuario(
                    @PathVariable
                    Integer idUsuario) {

        return reservaService
                .buscarPorUsuario(
                        idUsuario);

    }

    /**
     * Obtiene las reservas
     * de un libro.
     *
     * @param idLibro Libro.
     * @return Lista.
     */
    @GetMapping("/libro/{idLibro}")
    public List<ReservaResponseDTO>
            buscarPorLibro(
                    @PathVariable
                    Integer idLibro) {

        return reservaService
                .buscarPorLibro(
                        idLibro);

    }

    /**
     * Obtiene las reservas
     * vencidas.
     *
     * @return Lista.
     */
/**
 * Obtiene las reservas expiradas.
 *
 * @return Lista de reservas expiradas.
 */
@GetMapping("/expiradas")
public ResponseEntity<
        List<ReservaResponseDTO>>
        buscarExpiradas() {

    return ResponseEntity.ok(
            reservaService.buscarExpiradas());

}

    /**
     * Registra una reserva.
     *
     * @param request Información.
     * @return Reserva.
     */
    @PostMapping
    @ResponseStatus(
            HttpStatus.CREATED)
    public ReservaResponseDTO
            registrar(
                    @Valid
                    @RequestBody
                    ReservaRequestDTO request) {
System.out.println(">>> Entró al registrarReserva");
        return reservaService
                .registrarReserva(
                        request);

    }

    /**
     * Actualiza una reserva.
     *
     * @param id Identificador.
     * @param request Información.
     * @return Reserva.
     */
    @PutMapping("/{id}")
    public ReservaResponseDTO
            actualizar(
                    @PathVariable
                    Integer id,

                    @Valid
                    @RequestBody
                    ReservaUpdateDTO request) {

        return reservaService
                .actualizar(
                        id,
                        request);

    }

    /**
     * Cancela una reserva.
     *
     * @param id Identificador.
     * @return Reserva.
     */
    @PatchMapping("/{id}/cancelar")
    public ReservaResponseDTO
            cancelar(
                    @PathVariable
                    Integer id) {

        return reservaService
                .cancelar(id);

    }

    /**
     * Atiende una reserva.
     *
     * @param id Identificador.
     * @return Reserva.
     */
    @PatchMapping("/{id}/atender")
    public ReservaResponseDTO
            atender(
                    @PathVariable
                    Integer id) {

        return reservaService
                .atender(id);

    }

}