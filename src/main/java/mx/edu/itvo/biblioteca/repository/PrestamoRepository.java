package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.itvo.biblioteca.entity.Prestamo;

/**
 * Repositorio para la gestión de préstamos.
 *
 * <p>
 * Permite realizar operaciones de acceso a datos sobre la
 * entidad {@link Prestamo}, incluyendo consultas para
 * préstamos activos, historial de usuarios, devoluciones
 * y préstamos vencidos.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 17
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
    Optional<Prestamo> findByFolio(
            String folio);

    /**
     * Verifica si existe un folio registrado.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existsByFolio(
            String folio);

    /**
     * Obtiene únicamente los préstamos activos
     * administrativamente.
     *
     * @return Lista de préstamos.
     */
    List<Prestamo> findByActivoTrue();

    /**
     * Obtiene el historial de préstamos de un usuario,
     * ordenado del más reciente al más antiguo.
     *
     * @param idUsuario Identificador del usuario.
     * @return Historial de préstamos.
     */
    List<Prestamo> findByUsuarioIdUsuarioOrderByFechaPrestamoDesc(
            Integer idUsuario);

    /**
     * Obtiene únicamente los préstamos activos
     * de un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de préstamos activos.
     */
    List<Prestamo> findByUsuarioIdUsuarioAndFechaDevolucionRealIsNull(
            Integer idUsuario);

    /**
     * Obtiene todos los préstamos registrados para un
     * ejemplar.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByEjemplarIdEjemplar(
            Integer idEjemplar);

    /**
     * Obtiene el préstamo activo de un ejemplar.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return Préstamo activo.
     */
    Optional<Prestamo>
            findByEjemplarIdEjemplarAndFechaDevolucionRealIsNull(
                    Integer idEjemplar);

    /**
     * Obtiene los préstamos registrados por un
     * bibliotecario.
     *
     * @param idUsuario Identificador del bibliotecario.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByBibliotecarioIdUsuario(
            Integer idUsuario);

    /**
     * Obtiene los préstamos realizados en una fecha.
     *
     * @param fecha Fecha del préstamo.
     * @return Lista de préstamos.
     */
    List<Prestamo> findByFechaPrestamo(
            LocalDate fecha);

    /**
     * Obtiene los préstamos vencidos que aún
     * no han sido devueltos.
     *
     * @param fecha Fecha de comparación.
     * @return Lista de préstamos vencidos.
     */
    List<Prestamo>
            findByFechaDevolucionProgramadaBeforeAndFechaDevolucionRealIsNull(
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
     * @return true si existe un préstamo activo.
     */
    boolean existsByEjemplarIdEjemplarAndFechaDevolucionRealIsNull(
            Integer idEjemplar);

}