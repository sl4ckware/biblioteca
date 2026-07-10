package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import mx.edu.itvo.biblioteca.entity.Idioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de idiomas.
 *
 * Proporciona operaciones de acceso a datos para la entidad
 * {@link Idioma}.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {

    /**
     * Busca un idioma por su identificador.
     *
     * @param id Identificador.
     * @return Idioma encontrado.
     */
    @Override
    Optional<Idioma> findById(Integer id);

    /**
     * Busca un idioma por su nombre.
     *
     * @param nombre Nombre del idioma.
     * @return Idioma encontrado.
     */
    Optional<Idioma> findByNombre(String nombre);

    /**
     * Busca un idioma por su código ISO.
     *
     * @param codigoIso Código ISO.
     * @return Idioma encontrado.
     */
    Optional<Idioma> findByCodigoIso(String codigoIso);

    /**
     * Obtiene únicamente los idiomas activos.
     *
     * @return Lista de idiomas activos.
     */
    List<Idioma> findByActivoTrue();

    /**
     * Busca idiomas cuyo nombre contenga el texto indicado.
     *
     * @param nombre Nombre del idioma.
     * @return Lista de idiomas.
     */
    List<Idioma> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Verifica si existe un idioma con el nombre indicado.
     *
     * @param nombre Nombre.
     * @return {@code true} si existe.
     */
    boolean existsByNombre(String nombre);

    /**
     * Verifica si existe un idioma con el código ISO indicado.
     *
     * @param codigoIso Código ISO.
     * @return {@code true} si existe.
     */
    boolean existsByCodigoIso(String codigoIso);

}