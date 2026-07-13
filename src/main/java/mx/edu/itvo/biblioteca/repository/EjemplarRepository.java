package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import mx.edu.itvo.biblioteca.entity.Ejemplar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de ejemplares.
 *
 * Proporciona las operaciones de acceso a datos para la entidad
 * {@link Ejemplar}.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Repository
public interface EjemplarRepository
        extends JpaRepository<Ejemplar, Integer> {

    /**
     * Busca un ejemplar por su código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return Ejemplar encontrado.
     */
    Optional<Ejemplar> findByCodigoInventario(
            String codigoInventario);

    /**
     * Obtiene únicamente los ejemplares activos.
     *
     * @return Lista de ejemplares activos.
     */
    List<Ejemplar> findByActivoTrue();

    /**
     * Obtiene los ejemplares pertenecientes a un libro.
     *
     * @param idLibro Identificador del libro.
     * @return Lista de ejemplares.
     */
    List<Ejemplar> findByLibroIdLibro(Integer idLibro);

    /**
     * Obtiene los ejemplares por estado.
     *
     * @param idEstadoEjemplar Identificador del estado.
     * @return Lista de ejemplares.
     */
    List<Ejemplar> findByEstadoEjemplarIdEstadoEjemplar(
            Integer idEstadoEjemplar);

    /**
     * Verifica si existe un código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return {@code true} si existe.
     */
    boolean existsByCodigoInventario(
            String codigoInventario);

}