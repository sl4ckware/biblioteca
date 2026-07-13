package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import mx.edu.itvo.biblioteca.entity.Prestamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de préstamos.
 *
 * Permite realizar operaciones de acceso a datos
 * sobre la entidad Prestamo.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Repository
public interface PrestamoRepository
        extends JpaRepository<Prestamo, Integer> {

    /**
     * Busca un préstamo por su folio.
     *
     * @param folio Folio del préstamo.
     * @return Préstamo encontrado.
     */
    Optional<Prestamo> findByFolio(String folio);

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existsByFolio(String folio);

    /**
     * Obtiene únicamente los préstamos activos.
     *
     * @return Lista de préstamos.
     */
    List<Prestamo> findByActivoTrue();

    /**
     * Obtiene los préstamos de un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByUsuarioIdUsuario(
            Integer idUsuario);

    /**
     * Obtiene los préstamos de un ejemplar.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByEjemplarIdEjemplar(
            Integer idEjemplar);

    /**
     * Obtiene los préstamos realizados en una fecha.
     *
     * @param fecha Fecha del préstamo.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByFechaPrestamo(
            LocalDate fecha);

    /**
     * Obtiene los préstamos vencidos.
     *
     * @param fecha Fecha de comparación.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByFechaDevolucionProgramadaBefore(
            LocalDate fecha);

    /**
     * Obtiene los préstamos pendientes de devolución.
     *
     * @return Lista de préstamos activos.
     */
    List<Prestamo> findByFechaDevolucionRealIsNull();

    /**
     * Verifica si un ejemplar tiene un préstamo activo.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return true si existe.
     */
    boolean existsByEjemplarIdEjemplarAndFechaDevolucionRealIsNull(
            Integer idEjemplar);

}