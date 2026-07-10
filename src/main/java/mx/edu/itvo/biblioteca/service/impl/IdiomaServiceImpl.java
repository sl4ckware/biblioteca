package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.IdiomaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.IdiomaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Idioma;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.IdiomaMapper;
import mx.edu.itvo.biblioteca.repository.IdiomaRepository;
import mx.edu.itvo.biblioteca.service.IdiomaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de idiomas.
 *
 * Contiene la lógica de negocio de la entidad Idioma.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Service
@Transactional
public class IdiomaServiceImpl implements IdiomaService {

    /**
     * Repositorio de idiomas.
     */
    private final IdiomaRepository idiomaRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param idiomaRepository Repositorio de idiomas.
     */
    public IdiomaServiceImpl(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }

    /**
     * Obtiene todos los idiomas.
     *
     * @return Lista de idiomas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<IdiomaResponseDTO> listar() {

        return IdiomaMapper.toResponseList(
                idiomaRepository.findAll());

    }

    /**
     * Obtiene únicamente los idiomas activos.
     *
     * @return Lista de idiomas activos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<IdiomaResponseDTO> listarActivos() {

        return IdiomaMapper.toResponseList(
                idiomaRepository.findByActivoTrue());

    }

    /**
     * Busca un idioma por su identificador.
     *
     * @param id Identificador.
     * @return Idioma encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public IdiomaResponseDTO buscarPorId(Integer id) {

        Idioma idioma = idiomaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "id",
                                id));

        return IdiomaMapper.toResponse(idioma);

    }

    /**
     * Busca un idioma por su nombre.
     *
     * @param nombre Nombre.
     * @return Idioma encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public IdiomaResponseDTO buscarPorNombre(String nombre) {

        Idioma idioma = idiomaRepository.findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "nombre",
                                nombre));

        return IdiomaMapper.toResponse(idioma);

    }

    /**
     * Busca un idioma por su código ISO.
     *
     * @param codigoIso Código ISO.
     * @return Idioma encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public IdiomaResponseDTO buscarPorCodigoIso(String codigoIso) {

        Idioma idioma = idiomaRepository.findByCodigoIso(codigoIso)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "código ISO",
                                codigoIso));

        return IdiomaMapper.toResponse(idioma);

    }

    /**
     * Guarda un nuevo idioma.
     *
     * @param request Información recibida desde la API.
     * @return Idioma creado.
     */
    @Override
    public IdiomaResponseDTO guardar(IdiomaRequestDTO request) {

        if (idiomaRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Idioma",
                    "nombre",
                    request.getNombre());

        }

        if (idiomaRepository.existsByCodigoIso(request.getCodigoIso())) {

            throw new DuplicateResourceException(
                    "Idioma",
                    "código ISO",
                    request.getCodigoIso());

        }

        Idioma idioma = IdiomaMapper.toEntity(request);

        idioma.setActivo(Boolean.TRUE);
        idioma.setFechaCreacion(LocalDateTime.now());

        idioma = idiomaRepository.save(idioma);

        return IdiomaMapper.toResponse(idioma);

    }

    /**
     * Actualiza un idioma existente.
     *
     * @param id Identificador.
     * @param request Datos actualizados.
     * @return Idioma actualizado.
     */
    @Override
    public IdiomaResponseDTO actualizar(
            Integer id,
            IdiomaRequestDTO request) {

        Idioma idioma = idiomaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "id",
                                id));

        if (!idioma.getNombre().equalsIgnoreCase(request.getNombre())
                && idiomaRepository.existsByNombre(request.getNombre())) {

            throw new DuplicateResourceException(
                    "Idioma",
                    "nombre",
                    request.getNombre());

        }

        if (!idioma.getCodigoIso().equalsIgnoreCase(request.getCodigoIso())
                && idiomaRepository.existsByCodigoIso(request.getCodigoIso())) {

            throw new DuplicateResourceException(
                    "Idioma",
                    "código ISO",
                    request.getCodigoIso());

        }

        IdiomaMapper.updateEntity(request, idioma);

        idioma.setFechaActualizacion(LocalDateTime.now());

        idioma = idiomaRepository.save(idioma);

        return IdiomaMapper.toResponse(idioma);

    }

    /**
     * Realiza la eliminación lógica de un idioma.
     *
     * @param id Identificador.
     */
    @Override
    public void eliminar(Integer id) {

        Idioma idioma = idiomaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Idioma",
                                "id",
                                id));

        idioma.setActivo(Boolean.FALSE);
        idioma.setFechaActualizacion(LocalDateTime.now());

        idiomaRepository.save(idioma);

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

        return idiomaRepository.existsByNombre(nombre);

    }

    /**
     * Verifica si existe un código ISO.
     *
     * @param codigoIso Código ISO.
     * @return true si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeCodigoIso(String codigoIso) {

        return idiomaRepository.existsByCodigoIso(codigoIso);

    }

}