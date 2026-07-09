package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;

/**
 * Servicio para la gestión de categorías.
 *
 * Define las operaciones de negocio para la entidad Categoría.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public interface CategoriaService {

    /**
     * Obtiene todas las categorías.
     *
     * @return Lista de categorías.
     */
    List<CategoriaResponseDTO> listar();

    /**
     * Obtiene únicamente las categorías activas.
     *
     * @return Lista de categorías activas.
     */
    List<CategoriaResponseDTO> listarActivas();

    /**
     * Busca una categoría por su identificador.
     *
     * @param id Identificador.
     * @return Categoría encontrada.
     */
    CategoriaResponseDTO buscarPorId(Integer id);

    /**
     * Busca una categoría por su código.
     *
     * @param codigo Código de la categoría.
     * @return Categoría encontrada.
     */
    CategoriaResponseDTO buscarPorCodigo(String codigo);

    /**
     * Busca categorías por nombre.
     *
     * @param nombre Nombre de la categoría.
     * @return Lista de categorías.
     */
    List<CategoriaResponseDTO> buscarPorNombre(String nombre);

    /**
     * Guarda una nueva categoría.
     *
     * @param request Datos recibidos desde la API.
     * @return Categoría creada.
     */
    CategoriaResponseDTO guardar(CategoriaRequestDTO request);

    /**
     * Actualiza una categoría existente.
     *
     * @param id Identificador.
     * @param request Datos nuevos.
     * @return Categoría actualizada.
     */
    CategoriaResponseDTO actualizar(
            Integer id,
            CategoriaRequestDTO request);

    /**
     * Realiza la eliminación lógica de una categoría.
     *
     * @param id Identificador.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe un código.
     *
     * @param codigo Código.
     * @return true si existe.
     */
    boolean existeCodigo(String codigo);

    /**
     * Verifica si existe un nombre.
     *
     * @param nombre Nombre.
     * @return true si existe.
     */
    boolean existeNombre(String nombre);

}