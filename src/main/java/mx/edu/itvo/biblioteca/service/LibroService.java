package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;

/**
 * Define las operaciones para la gestión de libros.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface LibroService {

    /**
     * Obtiene el listado completo de libros.
     *
     * @return lista de libros.
     */
    List<LibroResponseDTO> listar();

    /**
     * Obtiene el listado de libros activos.
     *
     * @return lista de libros activos.
     */
    List<LibroResponseDTO> listarActivos();

    /**
     * Busca un libro por su identificador.
     *
     * @param id identificador del libro.
     * @return libro encontrado.
     */
    LibroResponseDTO buscarPorId(Integer id);

    /**
     * Busca un libro por su ISBN-13.
     *
     * @param isbn13 ISBN del libro.
     * @return libro encontrado.
     */
    LibroResponseDTO buscarPorIsbn(String isbn13);

    /**
     * Busca libros por coincidencia de título.
     *
     * @param titulo título o parte del título.
     * @return lista de libros.
     */
    List<LibroResponseDTO> buscarPorTitulo(String titulo);

    /**
     * Busca libros por categoría.
     *
     * @param idCategoria identificador de la categoría.
     * @return lista de libros.
     */
    List<LibroResponseDTO> buscarPorCategoria(Integer idCategoria);

    /**
     * Busca libros por editorial.
     *
     * @param idEditorial identificador de la editorial.
     * @return lista de libros.
     */
    List<LibroResponseDTO> buscarPorEditorial(Integer idEditorial);

    /**
     * Busca libros por idioma.
     *
     * @param idIdioma identificador del idioma.
     * @return lista de libros.
     */
    List<LibroResponseDTO> buscarPorIdioma(Integer idIdioma);

    /**
     * Registra un nuevo libro.
     *
     * @param request información del libro.
     * @return libro registrado.
     */
    LibroResponseDTO guardar(LibroRequestDTO request);

    /**
     * Actualiza un libro existente.
     *
     * @param id identificador del libro.
     * @param request información actualizada.
     * @return libro actualizado.
     */
    LibroResponseDTO actualizar(
            Integer id,
            LibroRequestDTO request);

    /**
     * Realiza la eliminación lógica de un libro.
     *
     * @param id identificador del libro.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe un ISBN registrado.
     *
     * @param isbn13 ISBN del libro.
     * @return true si existe.
     */
    boolean existeIsbn(String isbn13);

}