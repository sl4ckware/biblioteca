package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.itvo.biblioteca.entity.Multa;

/**
 * Repositorio para la gestión
 * de multas.
 *
 * Proporciona operaciones CRUD
 * y consultas específicas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Repository
public interface MultaRepository
        extends JpaRepository<Multa, Integer> {

    /**
     * Busca una multa por su folio.
     *
     * @param folio Folio.
     * @return Multa encontrada.
     */
    Optional<Multa> findByFolio(
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
     * Obtiene las multas
     * de un préstamo.
     *
     * @param idPrestamo Identificador.
     * @return Lista de multas.
     */
    List<Multa> findByPrestamoIdPrestamo(
            Integer idPrestamo);

    /**
     * Obtiene las multas
     * de un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista de multas.
     */
    List<Multa> findByPrestamoUsuarioIdUsuario(
            Integer idUsuario);

    /**
     * Obtiene las multas
     * por estado.
     *
     * @param estado Estado.
     * @return Lista de multas.
     */
    List<Multa> findByEstado(
            String estado);

    /**
     * Obtiene las multas
     * generadas en una fecha.
     *
     * @param fecha Fecha.
     * @return Lista de multas.
     */
    List<Multa> findByFechaGeneracion(
            LocalDate fecha);

    /**
     * Obtiene las multas
     * pagadas en una fecha.
     *
     * @param fecha Fecha.
     * @return Lista de multas.
     */
    List<Multa> findByFechaPago(
            LocalDate fecha);

    /**
     * Obtiene únicamente
     * las multas activas.
     *
     * @return Lista de multas.
     */
    List<Multa> findByActivoTrue();

}