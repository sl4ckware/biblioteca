package mx.edu.itvo.biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.constant.EstadoMultaConstantes;
import mx.edu.itvo.biblioteca.constant.FolioConstantes;
import mx.edu.itvo.biblioteca.constant.TipoMultaConstantes;
import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Multa;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.exception.InvalidOperationException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.MultaMapper;
import mx.edu.itvo.biblioteca.repository.MultaRepository;
import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.service.MultaService;
import mx.edu.itvo.biblioteca.util.FolioGenerator;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * Implementación del servicio de multas.
 * ============================================================
 *
 * <p>
 * Centraliza las reglas de negocio para
 * el registro, consulta y actualización
 * de multas.
 * </p>
 *
 * @author Conce
 * @version 3.1
 * @since Sprint 19
 */
@Service
@Transactional
public class MultaServiceImpl
        implements MultaService {

    /**
     * Repositorio de multas.
     */
    private final MultaRepository
            multaRepository;

    /**
     * Repositorio de préstamos.
     */
    private final PrestamoRepository
            prestamoRepository;

    /**
     * Constructor.
     *
     * @param multaRepository Repositorio.
     * @param prestamoRepository Repositorio.
     */
    public MultaServiceImpl(
            MultaRepository multaRepository,
            PrestamoRepository prestamoRepository) {

        this.multaRepository =
                multaRepository;

        this.prestamoRepository =
                prestamoRepository;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> listar() {

        return MultaMapper.toResponseList(
                multaRepository.findAll());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO> listarActivas() {

        return MultaMapper.toResponseList(
                multaRepository.findByActivoTrue());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public MultaResponseDTO buscarPorId(
            Integer id) {

        return MultaMapper.toResponse(
                obtenerMulta(id));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public MultaResponseDTO buscarPorFolio(
            String folio) {

        Multa multa =
                multaRepository
                        .findByFolio(folio)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Multa",
                                        "folio",
                                        folio));

        return MultaMapper.toResponse(
                multa);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO>
            buscarPorPrestamo(
                    Integer idPrestamo) {

        return MultaMapper.toResponseList(

                multaRepository
                        .findByPrestamoIdPrestamo(
                                idPrestamo));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO>
            buscarPorUsuario(
                    Integer idUsuario) {

        return MultaMapper.toResponseList(

                multaRepository
                        .findByPrestamoUsuarioIdUsuario(
                                idUsuario));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<MultaResponseDTO>
            buscarPorEstado(
                    String estado) {

        return MultaMapper.toResponseList(

                multaRepository.findByEstado(
                        estado));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MultaResponseDTO guardar(
            MultaRequestDTO request) {

        Prestamo prestamo =
                obtenerPrestamo(
                        request.getIdPrestamo());

        validarRegistroMulta(
                request,
                prestamo);

        Multa multa =
                crearMulta(
                        request,
                        prestamo);

        multa =
                guardarConFolio(
                        multa);

        return MultaMapper.toResponse(
                multa);

    }

    /**
     * {@inheritDoc}
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

        multa =
                multaRepository.save(
                        multa);

        return MultaMapper.toResponse(
                multa);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeFolio(
            String folio) {

        return multaRepository.existsByFolio(
                folio);

    }
    
    /**
     * Obtiene una multa.
     *
     * @param id Identificador.
     * @return Multa.
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
     * Obtiene un préstamo.
     *
     * @param id Identificador.
     * @return Préstamo.
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

    /**
     * Construye una nueva entidad
     * Multa a partir del DTO recibido.
     *
     * @param request DTO de registro.
     * @param prestamo Préstamo asociado.
     * @return Entidad preparada para persistirse.
     */
    private Multa crearMulta(
            MultaRequestDTO request,
            Prestamo prestamo) {

        Multa multa =
                MultaMapper.toEntity(
                        request);

        multa.setPrestamo(
                prestamo);

        multa.setEstado(
                EstadoMultaConstantes.PENDIENTE);

        /*
         * La entidad asignará automáticamente:
         *
         * - fechaGeneracion
         * - activo
         * - fechaCreacion
         * - fechaActualizacion
         */

        multa.setFechaPago(
                null);

        /*
         * Folio temporal para cumplir
         * la restricción NOT NULL.
         */
        multa.setFolio(
                "TMP-"
                + System.currentTimeMillis());

        return multa;

    }

    /**
     * Persiste la multa y posteriormente
     * genera el folio definitivo.
     *
     * @param multa Entidad.
     * @return Multa persistida.
     */
    private Multa guardarConFolio(
            Multa multa) {

        multa =
                multaRepository.save(
                        multa);

        multa.setFolio(
                FolioGenerator.generar(
                        FolioConstantes.MULTA,
                        multa.getIdMulta()));

        return multaRepository.save(
                multa);

    }

    /**
     * Centraliza las validaciones
     * necesarias para registrar
     * una nueva multa.
     *
     * @param request Información recibida.
     * @param prestamo Préstamo asociado.
     */
    private void validarRegistroMulta(
            MultaRequestDTO request,
            Prestamo prestamo) {

        validarPrestamo(
                prestamo);

        validarMonto(
                request);

        validarTipo(
                request.getTipo());

    }

    /**
     * Valida que el préstamo
     * permanezca activo.
     *
     * @param prestamo Préstamo.
     */
    private void validarPrestamo(
            Prestamo prestamo) {

        if (!Boolean.TRUE.equals(
                prestamo.getActivo())) {

            throw new InvalidOperationException(
                    "El préstamo se encuentra inactivo.");

        }

    }

    /**
     * Valida el monto
     * de la multa.
     *
     * @param request Información.
     */
    private void validarMonto(
            MultaRequestDTO request) {

        if (request.getMonto() == null
                || request.getMonto()
                        .signum() <= 0) {

            throw new InvalidOperationException(
                    "El monto debe ser mayor que cero.");

        }

    }

    /**
     * Valida el tipo
     * de multa.
     *
     * @param tipo Tipo.
     */
    private void validarTipo(
            String tipo) {

        if (!TipoMultaConstantes.ENTREGA_TARDIA.equals(tipo)
                && !TipoMultaConstantes.DANO.equals(tipo)
                && !TipoMultaConstantes.PERDIDA.equals(tipo)
                && !TipoMultaConstantes.OTRO.equals(tipo)) {

            throw new InvalidOperationException(
                    "El tipo de multa no es válido.");

        }

    }

}