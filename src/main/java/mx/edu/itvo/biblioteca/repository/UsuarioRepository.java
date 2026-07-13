package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import mx.edu.itvo.biblioteca.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de usuarios.
 *
 * Proporciona operaciones de acceso a datos para la entidad
 * {@link Usuario}.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un usuario por su matrícula.
     *
     * @param matricula Matrícula.
     * @return Usuario encontrado.
     */
    Optional<Usuario> findByMatricula(String matricula);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico.
     * @return Usuario encontrado.
     */
    Optional<Usuario> findByCorreo(String correo);

    /**
     * Obtiene únicamente los usuarios activos.
     *
     * @return Lista de usuarios activos.
     */
    List<Usuario> findByActivoTrue();

    /**
     * Busca usuarios cuyo nombre contenga el texto indicado.
     *
     * @param nombre Nombre del usuario.
     * @return Lista de usuarios.
     */
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Verifica si existe una matrícula.
     *
     * @param matricula Matrícula.
     * @return {@code true} si existe.
     */
    boolean existsByMatricula(String matricula);

    /**
     * Verifica si existe un correo electrónico.
     *
     * @param correo Correo electrónico.
     * @return {@code true} si existe.
     */
    boolean existsByCorreo(String correo);

}