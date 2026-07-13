package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.UsuarioRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.UsuarioResponseDTO;

/**
 * Define las operaciones de negocio para la gestión de usuarios.
 *
 * Esta interfaz declara los servicios disponibles para administrar
 * los usuarios registrados en el sistema de biblioteca.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public interface UsuarioService {

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return Lista de usuarios.
     */
    List<UsuarioResponseDTO> listar();

    /**
     * Obtiene únicamente los usuarios activos.
     *
     * @return Lista de usuarios activos.
     */
    List<UsuarioResponseDTO> listarActivos();

    /**
     * Busca un usuario por su identificador.
     *
     * @param id Identificador del usuario.
     * @return Usuario encontrado.
     */
    UsuarioResponseDTO buscarPorId(Integer id);

    /**
     * Busca un usuario por su matrícula.
     *
     * @param matricula Matrícula del usuario.
     * @return Usuario encontrado.
     */
    UsuarioResponseDTO buscarPorMatricula(String matricula);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico.
     * @return Usuario encontrado.
     */
    UsuarioResponseDTO buscarPorCorreo(String correo);

    /**
     * Busca usuarios cuyo nombre contenga el texto indicado.
     *
     * @param nombre Nombre del usuario.
     * @return Lista de usuarios.
     */
    List<UsuarioResponseDTO> buscarPorNombre(String nombre);

    /**
     * Registra un nuevo usuario.
     *
     * @param request Información recibida desde la API.
     * @return Usuario registrado.
     */
    UsuarioResponseDTO guardar(UsuarioRequestDTO request);

    /**
     * Actualiza un usuario existente.
     *
     * @param id Identificador del usuario.
     * @param request Información actualizada.
     * @return Usuario actualizado.
     */
    UsuarioResponseDTO actualizar(
            Integer id,
            UsuarioRequestDTO request);

    /**
     * Realiza la eliminación lógica de un usuario.
     *
     * @param id Identificador del usuario.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe una matrícula registrada.
     *
     * @param matricula Matrícula.
     * @return {@code true} si existe.
     */
    boolean existeMatricula(String matricula);

    /**
     * Verifica si existe un correo electrónico registrado.
     *
     * @param correo Correo electrónico.
     * @return {@code true} si existe.
     */
    boolean existeCorreo(String correo);

}