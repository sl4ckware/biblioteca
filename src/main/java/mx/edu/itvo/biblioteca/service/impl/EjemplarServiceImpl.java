package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.EjemplarRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EjemplarResponseDTO;

import mx.edu.itvo.biblioteca.entity.Ejemplar;
import mx.edu.itvo.biblioteca.entity.EstadoEjemplar;
import mx.edu.itvo.biblioteca.entity.Libro;

import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;

import mx.edu.itvo.biblioteca.mapper.EjemplarMapper;

import mx.edu.itvo.biblioteca.repository.EjemplarRepository;
import mx.edu.itvo.biblioteca.repository.EstadoEjemplarRepository;
import mx.edu.itvo.biblioteca.repository.LibroRepository;

import mx.edu.itvo.biblioteca.service.EjemplarService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de ejemplares.
 *
 * Contiene la lógica de negocio de la entidad Ejemplar.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Service
@Transactional
public class EjemplarServiceImpl implements EjemplarService {

    /**
     * Repositorio de ejemplares.
     */
    private final EjemplarRepository ejemplarRepository;

    /**
     * Repositorio de libros.
     */
    private final LibroRepository libroRepository;

    /**
     * Repositorio de estados del ejemplar.
     */
    private final EstadoEjemplarRepository estadoEjemplarRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param ejemplarRepository Repositorio de ejemplares.
     * @param libroRepository Repositorio de libros.
     * @param estadoEjemplarRepository Repositorio de estados.
     */
    public EjemplarServiceImpl(
            EjemplarRepository ejemplarRepository,
            LibroRepository libroRepository,
            EstadoEjemplarRepository estadoEjemplarRepository) {

        this.ejemplarRepository = ejemplarRepository;
        this.libroRepository = libroRepository;
        this.estadoEjemplarRepository = estadoEjemplarRepository;

    }

    /**
     * Obtiene todos los ejemplares.
     *
     * @return Lista de ejemplares.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EjemplarResponseDTO> listar() {

        return EjemplarMapper.toResponseList(
                ejemplarRepository.findAll());

    }

    /**
     * Obtiene únicamente los ejemplares activos.
     *
     * @return Lista de ejemplares activos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EjemplarResponseDTO> listarActivos() {

        return EjemplarMapper.toResponseList(
                ejemplarRepository.findByActivoTrue());

    }

    /**
     * Busca un ejemplar por su identificador.
     *
     * @param id Identificador.
     * @return Ejemplar encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public EjemplarResponseDTO buscarPorId(Integer id) {

        Ejemplar ejemplar = ejemplarRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ejemplar",
                                "id",
                                id));

        return EjemplarMapper.toResponse(ejemplar);

    }

    /**
     * Busca un ejemplar por su código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return Ejemplar encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public EjemplarResponseDTO buscarPorCodigoInventario(
            String codigoInventario) {

        Ejemplar ejemplar = ejemplarRepository
                .findByCodigoInventario(codigoInventario)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ejemplar",
                                "código de inventario",
                                codigoInventario));

        return EjemplarMapper.toResponse(ejemplar);

    }

    /**
     * Obtiene los ejemplares pertenecientes a un libro.
     *
     * @param idLibro Identificador del libro.
     * @return Lista de ejemplares.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EjemplarResponseDTO> buscarPorLibro(
            Integer idLibro) {

        return EjemplarMapper.toResponseList(
                ejemplarRepository.findByLibroIdLibro(idLibro));

    }

    /**
     * Obtiene los ejemplares por estado.
     *
     * @param idEstadoEjemplar Identificador del estado.
     * @return Lista de ejemplares.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EjemplarResponseDTO> buscarPorEstado(
            Integer idEstadoEjemplar) {

        return EjemplarMapper.toResponseList(
                ejemplarRepository
                        .findByEstadoEjemplarIdEstadoEjemplar(
                                idEstadoEjemplar));

    }
    
    /**
     * Guarda un nuevo ejemplar.
     *
     * @param request Información recibida desde la API.
     * @return Ejemplar registrado.
     */
    @Override
    public EjemplarResponseDTO guardar(
            EjemplarRequestDTO request) {

        if (ejemplarRepository.existsByCodigoInventario(
                request.getCodigoInventario())) {

            throw new DuplicateResourceException(
                    "Ejemplar",
                    "código de inventario",
                    request.getCodigoInventario());

        }

        Libro libro = libroRepository.findById(
                request.getIdLibro())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                request.getIdLibro()));

        EstadoEjemplar estadoEjemplar =
                estadoEjemplarRepository.findById(
                        request.getIdEstadoEjemplar())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "EstadoEjemplar",
                                        "id",
                                        request.getIdEstadoEjemplar()));

        Ejemplar ejemplar = EjemplarMapper.toEntity(request);

        ejemplar.setLibro(libro);
        ejemplar.setEstadoEjemplar(estadoEjemplar);
        ejemplar.setActivo(Boolean.TRUE);
        ejemplar.setFechaCreacion(LocalDateTime.now());

        ejemplar = ejemplarRepository.save(ejemplar);

        return EjemplarMapper.toResponse(ejemplar);

    }

    /**
     * Actualiza un ejemplar existente.
     *
     * @param id Identificador del ejemplar.
     * @param request Información actualizada.
     * @return Ejemplar actualizado.
     */
    @Override
    public EjemplarResponseDTO actualizar(
            Integer id,
            EjemplarRequestDTO request) {

        Ejemplar ejemplar = ejemplarRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ejemplar",
                                "id",
                                id));

        if (!ejemplar.getCodigoInventario()
                .equals(request.getCodigoInventario())
                && ejemplarRepository.existsByCodigoInventario(
                        request.getCodigoInventario())) {

            throw new DuplicateResourceException(
                    "Ejemplar",
                    "código de inventario",
                    request.getCodigoInventario());

        }

        Libro libro = libroRepository.findById(
                request.getIdLibro())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                request.getIdLibro()));

        EstadoEjemplar estadoEjemplar =
                estadoEjemplarRepository.findById(
                        request.getIdEstadoEjemplar())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "EstadoEjemplar",
                                        "id",
                                        request.getIdEstadoEjemplar()));

        EjemplarMapper.updateEntity(
                request,
                ejemplar);

        ejemplar.setLibro(libro);
        ejemplar.setEstadoEjemplar(estadoEjemplar);
        ejemplar.setFechaActualizacion(LocalDateTime.now());

        ejemplar = ejemplarRepository.save(ejemplar);

        return EjemplarMapper.toResponse(ejemplar);

    }
    
    /**
     * Realiza la eliminación lógica de un ejemplar.
     *
     * @param id Identificador del ejemplar.
     */
    @Override
    public void eliminar(Integer id) {

        Ejemplar ejemplar = ejemplarRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ejemplar",
                                "id",
                                id));

        ejemplar.setActivo(Boolean.FALSE);
        ejemplar.setFechaActualizacion(LocalDateTime.now());

        ejemplarRepository.save(ejemplar);

    }

    /**
     * Verifica si existe un código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return {@code true} si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeCodigoInventario(
            String codigoInventario) {

        return ejemplarRepository.existsByCodigoInventario(
                codigoInventario);

    }

}