package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.itvo.biblioteca.entity.Reserva;

/**
 * Repositorio para la gestión
 * de reservas.
 *
 * <p>
 * Proporciona operaciones de consulta
 * utilizadas por el módulo de reservas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public interface ReservaRepository
        extends JpaRepository<
                Reserva,
                Integer> {

    /**
     * Obtiene las reservas activas.
     *
     * @return Lista de reservas.
     */
    List<Reserva> findByActivoTrue();

    /**
     * Busca una reserva por folio.
     *
     * @param folio Folio.
     * @return Reserva.
     */
    Optional<Reserva> findByFolio(
            String folio);

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existsByFolio(
            String folio);

    /**
     * Obtiene el historial
     * de reservas de un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista.
     */
    List<Reserva>
            findByUsuarioIdUsuarioOrderByFechaReservaDesc(
                    Integer idUsuario);

    /**
     * Obtiene las reservas
     * de un libro.
     *
     * @param idLibro Identificador.
     * @return Lista.
     */
    List<Reserva>
            findByLibroIdLibro(
                    Integer idLibro);

    /**
     * Obtiene las reservas
     * pendientes de atención.
     *
     * @return Lista.
     */
    List<Reserva>
            findByFechaAtencionIsNull();

    /**
     * Obtiene las reservas
     * vencidas.
     *
     * @param fecha Fecha.
     * @return Lista.
     */
    List<Reserva>
            findByFechaLimiteBeforeAndFechaAtencionIsNull(
                    LocalDate fecha);

    /**
     * Verifica si un usuario
     * ya tiene una reserva activa
     * para el mismo libro.
     *
     * @param idUsuario Usuario.
     * @param idLibro Libro.
     * @return true si existe.
     */
    boolean
            existsByUsuarioIdUsuarioAndLibroIdLibroAndFechaAtencionIsNull(
                    Integer idUsuario,
                    Integer idLibro);

}