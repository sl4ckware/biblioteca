package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Categoria;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.CategoriaMapper;
import mx.edu.itvo.biblioteca.repository.CategoriaRepository;
import mx.edu.itvo.biblioteca.service.CategoriaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de categorías.
 *
 * Contiene la lógica de negocio de la entidad Categoria.
 *
 * @author Conce
 * @version 2.1
 * @since 1.0
 */
@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    /**
     * Repositorio de categorías.
     */
    private final CategoriaRepository categoriaRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param categoriaRepository Repositorio de categorías.
     */
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Obtiene todas las categorías.
     *
     * @return Lista de categorías.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> listar() {

        return CategoriaMapper.toResponseList(
                categoriaRepository.findAll());

    }

    /**
     * Obtiene únicamente las categorías activas.
     *
     * @return Lista de categorías activas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> listarActivas() {

        return CategoriaMapper.toResponseList(
                categoriaRepository.findByActivoTrue());

    }

    /**
     * Busca una categoría por su identificador.
     *
     * @param id Identificador.
     * @return Categoría encontrada.
     */
    @Override
    @Transactional(readOnly = true)
    public CategoriaResponseDTO buscarPorId(Integer id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "id",
                                id));

        return CategoriaMapper.toResponse(categoria);

    }

    /**
     * Busca una categoría por su código.
     *
     * @param codigo Código de la categoría.
     * @return Categoría encontrada.
     */
    @Override
    @Transactional(readOnly = true)
    public CategoriaResponseDTO buscarPorCodigo(String codigo) {

        Categoria categoria = categoriaRepository.findByCodigo(codigo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "código",
                                codigo));

        return CategoriaMapper.toResponse(categoria);

    }

    /**
     * Busca categorías por nombre.
     *
     * @param nombre Nombre de la categoría.
     * @return Lista de categorías.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> buscarPorNombre(String nombre) {

        return CategoriaMapper.toResponseList(
                categoriaRepository.findByNombreContainingIgnoreCase(nombre));

    }

    /**
     * Guarda una nueva categoría.
     *
     * @param request Información recibida desde la API.
     * @return Categoría creada.
     */
    @Override
    public CategoriaResponseDTO guardar(CategoriaRequestDTO request) {

        if (categoriaRepository.existsByCodigo(request.getCodigo())) {

            throw new DuplicateResourceException(
                    "Categoría",
                    "código",
                    request.getCodigo());

        }

        if (categoriaRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Categoría",
                    "nombre",
                    request.getNombre());

        }

        Categoria categoria = CategoriaMapper.toEntity(request);

        categoria.setActivo(Boolean.TRUE);
        categoria.setFechaCreacion(LocalDateTime.now());

        categoria = categoriaRepository.save(categoria);

        return CategoriaMapper.toResponse(categoria);

    }

    /**
     * Actualiza una categoría.
     *
     * @param id Identificador.
     * @param request Datos nuevos.
     * @return Categoría actualizada.
     */
    @Override
    public CategoriaResponseDTO actualizar(
            Integer id,
            CategoriaRequestDTO request) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "id",
                                id));

        if (!categoria.getCodigo().equals(request.getCodigo())
                && categoriaRepository.existsByCodigo(request.getCodigo())) {

            throw new DuplicateResourceException(
                    "Categoría",
                    "código",
                    request.getCodigo());

        }

        if (!categoria.getNombre().equalsIgnoreCase(request.getNombre())
                && categoriaRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Categoría",
                    "nombre",
                    request.getNombre());

        }

        CategoriaMapper.updateEntity(request, categoria);

        categoria.setFechaActualizacion(LocalDateTime.now());

        categoria = categoriaRepository.save(categoria);

        return CategoriaMapper.toResponse(categoria);

    }

    /**
     * Realiza la eliminación lógica de una categoría.
     *
     * @param id Identificador.
     */
    @Override
    public void eliminar(Integer id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Categoría",
                                "id",
                                id));

        categoria.setActivo(Boolean.FALSE);
        categoria.setFechaActualizacion(LocalDateTime.now());

        categoriaRepository.save(categoria);

    }

    /**
     * Verifica si existe un código.
     *
     * @param codigo Código.
     * @return true si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeCodigo(String codigo) {

        return categoriaRepository.existsByCodigo(codigo);

    }

    /**
     * Verifica si existe un nombre.
     *
     * @param nombre Nombre.
     * @return true si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeNombre(String nombre) {

        return categoriaRepository.existsByNombre(nombre);

    }

}