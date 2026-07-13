package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import mx.edu.itvo.biblioteca.constant.FolioConstantes;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Multa;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.MultaMapper;
import mx.edu.itvo.biblioteca.repository.MultaRepository;
import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.service.MultaService;
import mx.edu.itvo.biblioteca.util.FolioGenerator;

/**
 * Implementación del servicio
 * para la gestión de multas.
 *
 * Contiene la lógica de negocio
 * del módulo de multas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Service
@Transactional
public class MultaServiceImpl
        implements MultaService {

    /**
     * Repositorio de multas.
     */
    private final MultaRepository multaRepository;

    /**
     * Repositorio de préstamos.
     */
    private final PrestamoRepository prestamoRepository;

    /**
     * Constructor.
     *
     * @param multaRepository Repositorio de multas.
     * @param prestamoRepository Repositorio de préstamos.
     */
    public MultaServiceImpl(
            MultaRepository multaRepository,
            PrestamoRepository prestamoRepository) {

        this.multaRepository = multaRepository;
        this.prestamoRepository = prestamoRepository;

    }

    /**
     * Obtiene todas las multas.
     *
     * @return Lista de multas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> listar() {

        return MultaMapper.toResponseList(
                multaRepository.findAll());

    }

    /**
     * Obtiene únicamente
     * las multas activas.
     *
     * @return Lista.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> listarActivas() {

        return MultaMapper.toResponseList(
                multaRepository.findByActivoTrue());

    }

    /**
     * Busca una multa por ID.
     *
     * @param id Identificador.
     * @return Multa.
     */
    @Override
    @Transactional(readOnly = true)
    public MultaResponseDTO buscarPorId(
            Integer id) {

        return MultaMapper.toResponse(
                obtenerMulta(id));

    }

    /**
     * Busca una multa por folio.
     *
     * @param folio Folio.
     * @return Multa.
     */
    @Override
    @Transactional(readOnly = true)
    public MultaResponseDTO buscarPorFolio(
            String folio) {

        Multa multa =
                multaRepository.findByFolio(folio)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Multa",
                                        "folio",
                                        folio));

        return MultaMapper.toResponse(
                multa);

    }

    /**
     * Obtiene las multas
     * de un préstamo.
     *
     * @param idPrestamo Identificador.
     * @return Lista.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> buscarPorPrestamo(
            Integer idPrestamo) {

        return MultaMapper.toResponseList(
                multaRepository
                        .findByPrestamoIdPrestamo(
                                idPrestamo));

    }

    /**
     * Obtiene las multas
     * de un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> buscarPorUsuario(
            Integer idUsuario) {

        return MultaMapper.toResponseList(
                multaRepository
                        .findByPrestamoUsuarioIdUsuario(
                                idUsuario));

    }

    /**
     * Obtiene las multas
     * por estado.
     *
     * @param estado Estado.
     * @return Lista.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> buscarPorEstado(
            String estado) {

        return MultaMapper.toResponseList(
                multaRepository.findByEstado(
                        estado));

    }
        /**
     * Registra una nueva multa.
     *
     * @param request Información de la multa.
     * @return Multa registrada.
     */
    @Override
    public MultaResponseDTO guardar(
            MultaRequestDTO request) {

        Prestamo prestamo =
                obtenerPrestamo(
                        request.getIdPrestamo());

        Multa multa =
                MultaMapper.toEntity(request);

        multa.setPrestamo(prestamo);

        multa.setActivo(Boolean.TRUE);

        multa.setFechaCreacion(
                LocalDateTime.now());

        /*
         * Primer guardado para obtener
         * el identificador generado.
         */
        multa =
                multaRepository.save(multa);

        /*
         * Generación del folio definitivo.
         */
        multa.setFolio(
                FolioGenerator.generar(
                        FolioConstantes.MULTA,
                        multa.getIdMulta()));

        multa.setFechaActualizacion(
                LocalDateTime.now());

        multa =
                multaRepository.save(multa);

        return MultaMapper.toResponse(
                multa);

    }
        /**
     * Actualiza la información editable
     * de una multa.
     *
     * @param id Identificador de la multa.
     * @param request Información editable.
     * @return Multa actualizada.
     */
    @Override
    public MultaResponseDTO actualizar(
            Integer id,
            MultaUpdateDTO request) {

        Multa multa =
                obtenerMulta(id);

        MultaMapper.updateEntity(
                request,
                multa);

        multa.setFechaActualizacion(
                LocalDateTime.now());

        multa =
                multaRepository.save(multa);

        return MultaMapper.toResponse(
                multa);

    }

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeFolio(
            String folio) {

        return multaRepository.existsByFolio(
                folio);

    }
        /**
     * Obtiene una multa por su identificador.
     *
     * @param id Identificador de la multa.
     * @return Multa encontrada.
     */
    private Multa obtenerMulta(
            Integer id) {

        return multaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Multa",
                                "id",
                                id));

    }

    /**
     * Obtiene un préstamo por su identificador.
     *
     * @param id Identificador del préstamo.
     * @return Préstamo encontrado.
     */
    private Prestamo obtenerPrestamo(
            Integer id) {

        return prestamoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Préstamo",
                                "id",
                                id));

    }

}