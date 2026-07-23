package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.itvo.biblioteca.entity.Multa;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * Repositorio de la entidad Multa.
 * ============================================================
 *
 * <p>
 * Define las operaciones de acceso a datos
 * para la entidad {@link Multa}, utilizando
 * Spring Data JPA.
 * </p>
 *
 * <p>
 * Además de las operaciones CRUD heredadas de
 * {@link JpaRepository}, proporciona consultas
 * específicas para la administración del módulo
 * de multas.
 * </p>
 *
 * <ul>
 *     <li>Búsqueda por folio.</li>
 *     <li>Validación de folios existentes.</li>
 *     <li>Consulta por préstamo.</li>
 *     <li>Consulta por usuario.</li>
 *     <li>Consulta por estado.</li>
 *     <li>Consulta por fecha de generación.</li>
 *     <li>Consulta por fecha de pago.</li>
 *     <li>Obtención de multas activas.</li>
 * </ul>
 *
 * <p>
 * Todas las consultas utilizan los métodos
 * derivados de Spring Data JPA, evitando la
 * definición de consultas JPQL cuando no son
 * necesarias.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 19
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
