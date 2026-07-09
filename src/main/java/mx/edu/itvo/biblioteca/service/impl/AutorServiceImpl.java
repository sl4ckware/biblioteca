package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.AutorRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.AutorResponseDTO;
import mx.edu.itvo.biblioteca.entity.Autor;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.AutorMapper;
import mx.edu.itvo.biblioteca.repository.AutorRepository;
import mx.edu.itvo.biblioteca.service.AutorService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de autores.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class AutorServiceImpl implements AutorService {

    /**
     * Repositorio de autores.
     */
    private final AutorRepository autorRepository;

    /**
     * Constructor que inyecta el repositorio de autores.
     *
     * @param autorRepository repositorio de autores.
     */
    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<AutorResponseDTO> listar() {

        return AutorMapper.toResponseList(
                autorRepository.findAll());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<AutorResponseDTO> listarActivos() {

        return AutorMapper.toResponseList(
                autorRepository.findByActivoTrue());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public AutorResponseDTO buscarPorId(Integer id) {

        Autor autor = autorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Autor",
                                "id",
                                id));

        return AutorMapper.toResponse(autor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public AutorResponseDTO buscarPorNombre(String nombre) {

        Autor autor = autorRepository.findByNombreIgnoreCase(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Autor",
                                "nombre",
                                nombre));

        return AutorMapper.toResponse(autor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<AutorResponseDTO> buscarPorCoincidenciaNombre(
            String nombre) {

        return AutorMapper.toResponseList(
                autorRepository.findByNombreContainingIgnoreCase(nombre));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutorResponseDTO guardar(AutorRequestDTO request) {

        if (autorRepository.existsByNombreIgnoreCase(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Autor",
                    "nombre",
                    request.getNombre());

        }

        Autor autor = AutorMapper.toEntity(request);

        autor.setActivo(Boolean.TRUE);
        autor.setFechaCreacion(LocalDateTime.now());

        autor = autorRepository.save(autor);

        return AutorMapper.toResponse(autor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutorResponseDTO actualizar(
            Integer id,
            AutorRequestDTO request) {

        Autor autor = autorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Autor",
                                "id",
                                id));

        if (!autor.getNombre().equalsIgnoreCase(request.getNombre())
                && autorRepository.existsByNombreIgnoreCase(
                        request.getNombre())) {

            throw new DuplicateResourceException(
                    "Autor",
                    "nombre",
                    request.getNombre());

        }

        AutorMapper.updateEntity(request, autor);

        autor.setFechaActualizacion(LocalDateTime.now());

        autor = autorRepository.save(autor);

        return AutorMapper.toResponse(autor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(Integer id) {

        Autor autor = autorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Autor",
                                "id",
                                id));

        autor.setActivo(Boolean.FALSE);
        autor.setFechaActualizacion(LocalDateTime.now());

        autorRepository.save(autor);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeNombre(String nombre) {

        return autorRepository.existsByNombreIgnoreCase(nombre);

    }

}