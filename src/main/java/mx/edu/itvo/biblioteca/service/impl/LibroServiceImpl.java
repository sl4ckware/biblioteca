package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;
import mx.edu.itvo.biblioteca.entity.Categoria;
import mx.edu.itvo.biblioteca.entity.Editorial;
import mx.edu.itvo.biblioteca.entity.Idioma;
import mx.edu.itvo.biblioteca.entity.Libro;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.LibroMapper;
import mx.edu.itvo.biblioteca.repository.CategoriaRepository;
import mx.edu.itvo.biblioteca.repository.EditorialRepository;
import mx.edu.itvo.biblioteca.repository.IdiomaRepository;
import mx.edu.itvo.biblioteca.repository.LibroRepository;
import mx.edu.itvo.biblioteca.service.LibroService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de libros.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class LibroServiceImpl implements LibroService {

    /**
     * Repositorio de libros.
     */
    private final LibroRepository libroRepository;

    /**
     * Repositorio de categorías.
     */
    private final CategoriaRepository categoriaRepository;

    /**
     * Repositorio de editoriales.
     */
    private final EditorialRepository editorialRepository;

    /**
     * Repositorio de idiomas.
     */
    private final IdiomaRepository idiomaRepository;

    /**
     * Constructor.
     *
     * @param libroRepository repositorio de libros.
     * @param categoriaRepository repositorio de categorías.
     * @param editorialRepository repositorio de editoriales.
     * @param idiomaRepository repositorio de idiomas.
     */
    public LibroServiceImpl(
            LibroRepository libroRepository,
            CategoriaRepository categoriaRepository,
            EditorialRepository editorialRepository,
            IdiomaRepository idiomaRepository) {

        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
        this.editorialRepository = editorialRepository;
        this.idiomaRepository = idiomaRepository;

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> listar() {

        return LibroMapper.toResponseList(
                libroRepository.findAll());

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> listarActivos() {

        return LibroMapper.toResponseList(
                libroRepository.findByActivoTrue());

    }

    @Override
    @Transactional(readOnly = true)
    public LibroResponseDTO buscarPorId(Integer id) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                id));

        return LibroMapper.toResponse(libro);

    }

    @Override
    @Transactional(readOnly = true)
    public LibroResponseDTO buscarPorIsbn(String isbn13) {

        Libro libro = libroRepository.findByIsbn13(isbn13)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "ISBN",
                                isbn13));

        return LibroMapper.toResponse(libro);

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> buscarPorTitulo(String titulo) {

        return LibroMapper.toResponseList(
                libroRepository.findByTituloContainingIgnoreCase(titulo));

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> buscarPorCategoria(Integer idCategoria) {

        return LibroMapper.toResponseList(
                libroRepository.findByCategoriaIdCategoria(idCategoria));

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> buscarPorEditorial(Integer idEditorial) {

        return LibroMapper.toResponseList(
                libroRepository.findByEditorialIdEditorial(idEditorial));

    }

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> buscarPorIdioma(Integer idIdioma) {

        return LibroMapper.toResponseList(
                libroRepository.findByIdiomaIdIdioma(idIdioma));

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeIsbn(String isbn13) {

        return libroRepository.existsByIsbn13(isbn13);

    }
    
    @Override
    public LibroResponseDTO guardar(LibroRequestDTO request) {

        if (libroRepository.existsByIsbn13(request.getIsbn13())) {

            throw new DuplicateResourceException(
                    "Libro",
                    "ISBN",
                    request.getIsbn13());

        }

        Categoria categoria = categoriaRepository.findById(
                request.getIdCategoria())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "id",
                                request.getIdCategoria()));

        Editorial editorial = editorialRepository.findById(
                request.getIdEditorial())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "id",
                                request.getIdEditorial()));

        Idioma idioma = idiomaRepository.findById(
                request.getIdIdioma())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "id",
                                request.getIdIdioma()));

        Libro libro = LibroMapper.toEntity(request);

        libro.setCategoria(categoria);
        libro.setEditorial(editorial);
        libro.setIdioma(idioma);

        libro.setActivo(Boolean.TRUE);
        libro.setFechaCreacion(LocalDateTime.now());

        libro = libroRepository.save(libro);

        return LibroMapper.toResponse(libro);

    }

    @Override
    public LibroResponseDTO actualizar(
            Integer id,
            LibroRequestDTO request) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                id));

        if (!libro.getIsbn13().equals(request.getIsbn13())
                && libroRepository.existsByIsbn13(
                        request.getIsbn13())) {

            throw new DuplicateResourceException(
                    "Libro",
                    "ISBN",
                    request.getIsbn13());

        }

        Categoria categoria = categoriaRepository.findById(
                request.getIdCategoria())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "id",
                                request.getIdCategoria()));

        Editorial editorial = editorialRepository.findById(
                request.getIdEditorial())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "id",
                                request.getIdEditorial()));

        Idioma idioma = idiomaRepository.findById(
                request.getIdIdioma())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "id",
                                request.getIdIdioma()));

        LibroMapper.updateEntity(request, libro);

        libro.setCategoria(categoria);
        libro.setEditorial(editorial);
        libro.setIdioma(idioma);

        libro.setFechaActualizacion(LocalDateTime.now());

        libro = libroRepository.save(libro);

        return LibroMapper.toResponse(libro);

    }

    @Override
    public void eliminar(Integer id) {

        Libro libro = libroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                id));

        libro.setActivo(Boolean.FALSE);
        libro.setFechaActualizacion(LocalDateTime.now());

        libroRepository.save(libro);

    }

}