package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.IdiomaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.IdiomaResponseDTO;

/**
 * Define las operaciones de negocio para la gestión de idiomas.
 *
 * Esta interfaz declara los servicios disponibles para administrar
 * los idiomas registrados en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public interface IdiomaService {

    /**
     * Obtiene todos los idiomas.
     *
     * @return Lista de idiomas.
     */
    List<IdiomaResponseDTO> listar();

    /**
     * Obtiene únicamente los idiomas activos.
     *
     * @return Lista de idiomas activos.
     */
    List<IdiomaResponseDTO> listarActivos();

    /**
     * Busca un idioma por su identificador.
     *
     * @param id Identificador.
     * @return Idioma encontrado.
     */
    IdiomaResponseDTO buscarPorId(Integer id);

    /**
     * Busca un idioma por su nombre.
     *
     * @param nombre Nombre del idioma.
     * @return Idioma encontrado.
     */
    IdiomaResponseDTO buscarPorNombre(String nombre);

    /**
     * Busca un idioma por su código ISO.
     *
     * @param codigoIso Código ISO.
     * @return Idioma encontrado.
     */
    IdiomaResponseDTO buscarPorCodigoIso(String codigoIso);

    /**
     * Guarda un nuevo idioma.
     *
     * @param request Información del idioma.
     * @return Idioma registrado.
     */
    IdiomaResponseDTO guardar(IdiomaRequestDTO request);

    /**
     * Actualiza un idioma existente.
     *
     * @param id Identificador.
     * @param request Información actualizada.
     * @return Idioma actualizado.
     */
    IdiomaResponseDTO actualizar(
            Integer id,
            IdiomaRequestDTO request);

    /**
     * Realiza la eliminación lógica de un idioma.
     *
     * @param id Identificador.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe un nombre registrado.
     *
     * @param nombre Nombre.
     * @return {@code true} si existe.
     */
    boolean existeNombre(String nombre);

    /**
     * Verifica si existe un código ISO registrado.
     *
     * @param codigoIso Código ISO.
     * @return {@code true} si existe.
     */
    boolean existeCodigoIso(String codigoIso);

}