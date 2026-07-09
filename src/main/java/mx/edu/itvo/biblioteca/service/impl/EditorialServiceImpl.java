package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.entity.Editorial;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.EditorialMapper;
import mx.edu.itvo.biblioteca.repository.EditorialRepository;
import mx.edu.itvo.biblioteca.service.EditorialService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de editoriales.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
@Transactional
public class EditorialServiceImpl implements EditorialService {

    /**
     * Repositorio de editoriales.
     */
    private final EditorialRepository editorialRepository;

    public EditorialServiceImpl(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EditorialResponseDTO> listar() {

        return EditorialMapper.toResponseList(
                editorialRepository.findAll());

    }

    @Override
    @Transactional(readOnly = true)
    public List<EditorialResponseDTO> listarActivas() {

        return EditorialMapper.toResponseList(
                editorialRepository.findByActivoTrue());

    }

    @Override
    @Transactional(readOnly = true)
    public EditorialResponseDTO buscarPorId(Integer id) {

        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "id",
                                id));

        return EditorialMapper.toResponse(editorial);

    }

    @Override
    @Transactional(readOnly = true)
    public EditorialResponseDTO buscarPorNombre(String nombre) {

        Editorial editorial = editorialRepository.findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "nombre",
                                nombre));

        return EditorialMapper.toResponse(editorial);

    }

    @Override
    @Transactional(readOnly = true)
    public List<EditorialResponseDTO> buscarPorCoincidenciaNombre(
            String nombre) {

        return EditorialMapper.toResponseList(
                editorialRepository.findByNombreContainingIgnoreCase(nombre));

    }

    @Override
    public EditorialResponseDTO guardar(EditorialRequestDTO request) {

        if (editorialRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Editorial",
                    "nombre",
                    request.getNombre());

        }

        Editorial editorial = EditorialMapper.toEntity(request);

        editorial.setActivo(Boolean.TRUE);
        editorial.setFechaCreacion(LocalDateTime.now());

        editorial = editorialRepository.save(editorial);

        return EditorialMapper.toResponse(editorial);

    }

    @Override
    public EditorialResponseDTO actualizar(
            Integer id,
            EditorialRequestDTO request) {

        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "id",
                                id));

        if (!editorial.getNombre().equalsIgnoreCase(request.getNombre())
                && editorialRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Editorial",
                    "nombre",
                    request.getNombre());

        }

        EditorialMapper.updateEntity(request, editorial);

        editorial.setFechaActualizacion(LocalDateTime.now());

        editorial = editorialRepository.save(editorial);

        return EditorialMapper.toResponse(editorial);

    }

    @Override
    public void eliminar(Integer id) {

        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Editorial",
                                "id",
                                id));

        editorial.setActivo(Boolean.FALSE);
        editorial.setFechaActualizacion(LocalDateTime.now());

        editorialRepository.save(editorial);

    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeNombre(String nombre) {

        return editorialRepository.existsByNombre(nombre);

    }

}
