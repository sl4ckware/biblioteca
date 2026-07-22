package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.ReservaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.ReservaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.ReservaResponseDTO;

/**
 * Servicio para la gestión de reservas.
 *
 * <p>
 * Define las operaciones de negocio
 * relacionadas con el registro,
 * consulta, atención y cancelación
 * de reservas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public interface ReservaService {

    /**
     * Obtiene todas las reservas.
     *
     * @return Lista de reservas.
     */
    List<ReservaResponseDTO> listar();

    /**
     * Obtiene únicamente
     * las reservas activas.
     *
     * @return Lista.
     */
    List<ReservaResponseDTO> listarActivas();

    /**
     * Obtiene las reservas
     * pendientes de atención.
     *
     * @return Lista.
     */
    List<ReservaResponseDTO>
            listarPendientes();

    /**
     * Busca una reserva
     * por identificador.
     *
     * @param id Identificador.
     * @return Reserva.
     */
    ReservaResponseDTO buscarPorId(
            Integer id);

    /**
     * Busca una reserva
     * por folio.
     *
     * @param folio Folio.
     * @return Reserva.
     */
    ReservaResponseDTO buscarPorFolio(
            String folio);

    /**
     * Obtiene el historial
     * de reservas de un usuario.
     *
     * @param idUsuario Usuario.
     * @return Lista.
     */
    List<ReservaResponseDTO>
            buscarPorUsuario(
                    Integer idUsuario);

    /**
     * Obtiene las reservas
     * de un libro.
     *
     * @param idLibro Libro.
     * @return Lista.
     */
    List<ReservaResponseDTO>
            buscarPorLibro(
                    Integer idLibro);

    /**
     * Obtiene las reservas
     * expiradas.
     *
     * @return Lista.
     */
    List<ReservaResponseDTO>
            buscarExpiradas();

    /**
     * Registra una nueva reserva.
     *
     * @param request Información.
     * @return Reserva registrada.
     */
    ReservaResponseDTO registrarReserva(
            ReservaRequestDTO request);

    /**
     * Actualiza una reserva.
     *
     * @param id Identificador.
     * @param request Información.
     * @return Reserva actualizada.
     */
    ReservaResponseDTO actualizar(
            Integer id,
            ReservaUpdateDTO request);

    /**
     * Atiende una reserva.
     *
     * @param id Identificador.
     * @return Reserva atendida.
     */
    ReservaResponseDTO atender(
            Integer id);

    /**
     * Cancela una reserva.
     *
     * @param id Identificador.
     * @return Reserva cancelada.
     */
    ReservaResponseDTO cancelar(
            Integer id);

    /**
     * Verifica si existe
     * un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existeFolio(
            String folio);

}