package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import mx.edu.itvo.biblioteca.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio encargado de la gestión de persistencia de la entidad Autor.
 *
 * <p>
 * Proporciona operaciones de consulta específicas para la administración
 * del catálogo de autores.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    /**
     * Busca autores cuyo nombre contenga el texto indicado,
     * ignorando mayúsculas y minúsculas.
     *
     * @param nombre nombre o parte del nombre.
     * @return lista de autores.
     */
    List<Autor> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Busca autores por coincidencia en el apellido paterno.
     *
     * @param apellido apellido paterno.
     * @return lista de autores.
     */
    List<Autor> findByApellidoPaternoContainingIgnoreCase(String apellido);

    /**
     * Obtiene únicamente los autores activos.
     *
     * @return lista de autores activos.
     */
    List<Autor> findByActivoTrue();

    /**
     * Busca un autor por su nombre exacto ignorando mayúsculas
     * y minúsculas.
     *
     * @param nombre nombre del autor.
     * @return autor encontrado.
     */
    Optional<Autor> findByNombreIgnoreCase(String nombre);

    /**
     * Verifica si existe un autor registrado con el nombre indicado.
     *
     * @param nombre nombre del autor.
     * @return {@code true} si existe; {@code false} en caso contrario.
     */
    boolean existsByNombreIgnoreCase(String nombre);

}