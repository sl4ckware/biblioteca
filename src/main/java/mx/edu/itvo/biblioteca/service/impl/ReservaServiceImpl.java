package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.constant.EstadoReservaConstantes;
import mx.edu.itvo.biblioteca.constant.FolioConstantes;
import mx.edu.itvo.biblioteca.dto.request.ReservaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.ReservaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.ReservaResponseDTO;
import mx.edu.itvo.biblioteca.entity.EstadoReserva;
import mx.edu.itvo.biblioteca.entity.Libro;
import mx.edu.itvo.biblioteca.entity.Reserva;
import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.exception.InvalidOperationException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.ReservaMapper;
import mx.edu.itvo.biblioteca.repository.EstadoReservaRepository;
import mx.edu.itvo.biblioteca.repository.LibroRepository;
import mx.edu.itvo.biblioteca.repository.ReservaRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import mx.edu.itvo.biblioteca.service.ReservaService;
import mx.edu.itvo.biblioteca.util.FolioGenerator;

/**
 * ============================================================
 * Sprint 18
 * Historia Técnica 18.10
 *
 * Implementación del servicio
 * de reservas.
 * ============================================================
 *
 * Implementa la lógica de negocio relacionada con el
 * registro, consulta, atención y cancelación de reservas.
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
@Service
@Transactional
public class ReservaServiceImpl
        implements ReservaService {

    /**
     * Repositorio de reservas.
     */
    private final ReservaRepository
            reservaRepository;

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository
            usuarioRepository;

    /**
     * Repositorio de libros.
     */
    private final LibroRepository
            libroRepository;

    /**
     * Repositorio de estados.
     */
    private final EstadoReservaRepository
            estadoReservaRepository;

    /**
     * Constructor.
     *
     * @param reservaRepository Repositorio.
     * @param usuarioRepository Repositorio.
     * @param libroRepository Repositorio.
     * @param estadoReservaRepository Repositorio.
     */
    public ReservaServiceImpl(
            ReservaRepository reservaRepository,
            UsuarioRepository usuarioRepository,
            LibroRepository libroRepository,
            EstadoReservaRepository estadoReservaRepository) {

        this.reservaRepository =
                reservaRepository;

        this.usuarioRepository =
                usuarioRepository;

        this.libroRepository =
                libroRepository;

        this.estadoReservaRepository =
                estadoReservaRepository;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            listar() {

        return ReservaMapper.toResponseList(
                reservaRepository.findAll());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            listarActivas() {

        return ReservaMapper.toResponseList(
                reservaRepository.findByActivoTrue());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            listarPendientes() {

        return ReservaMapper.toResponseList(

                reservaRepository
                        .findByFechaAtencionIsNull());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public ReservaResponseDTO
            buscarPorId(
                    Integer id) {

        return ReservaMapper.toResponseDTO(
                obtenerReserva(id));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public ReservaResponseDTO
            buscarPorFolio(
                    String folio) {

        Reserva reserva =
                reservaRepository
                        .findByFolio(folio)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Reserva",
                                        "folio",
                                        folio));

        return ReservaMapper.toResponseDTO(
                reserva);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            buscarPorUsuario(
                    Integer idUsuario) {

        return ReservaMapper.toResponseList(

                reservaRepository
                        .findByUsuarioIdUsuarioOrderByFechaReservaDesc(
                                idUsuario));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            buscarPorLibro(
                    Integer idLibro) {

        return ReservaMapper.toResponseList(

                reservaRepository
                        .findByLibroIdLibro(
                                idLibro));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponseDTO>
            buscarExpiradas() {

        return ReservaMapper.toResponseList(

                reservaRepository
                        .findByFechaLimiteBeforeAndFechaAtencionIsNull(
                                LocalDate.now()));

    }
                /**
     * {@inheritDoc}
     */
    @Override
    public ReservaResponseDTO registrarReserva(
            ReservaRequestDTO request) {

        Usuario usuario =
                obtenerUsuario(
                        request.getIdUsuario());

        validarUsuario(
                usuario);

        Libro libro =
                obtenerLibro(
                        request.getIdLibro());

        validarLibroActivo(
                libro);

        validarReservaExistente(
                usuario,
                libro);

        EstadoReserva estadoActiva =
                obtenerEstadoReserva(
                        EstadoReservaConstantes.ACTIVA);

        Reserva reserva =
                ReservaMapper.toEntity(
                        request);

        reserva.setUsuario(
                usuario);

        reserva.setLibro(
                libro);

        Usuario bibliotecario =
                obtenerUsuario(
                        request.getIdBibliotecario());

        reserva.setBibliotecario(
                bibliotecario);

        reserva.setEstadoReserva(
                estadoActiva);

        reserva.setActivo(
                Boolean.TRUE);

        reserva.setFechaReserva(
                LocalDate.now());

        /*
         * La reserva permanece vigente
         * durante tres días naturales.
         */
        reserva.setFechaLimite(
                LocalDate.now()
                        .plusDays(3));

        reserva.setFechaCreacion(
                LocalDateTime.now());

        /*
         * Se asigna un folio temporal para
         * cumplir la restricción NOT NULL.
         */
        reserva.setFolio(
                "TMP-"
                + System.currentTimeMillis());

        reserva =
                reservaRepository.save(
                        reserva);

        reserva.setFolio(
                FolioGenerator.generar(
                        FolioConstantes.RESERVA,
                        reserva.getIdReserva()));

        reserva =
                reservaRepository.save(
                        reserva);

        Reserva reservaCompleta =
                obtenerReserva(
                        reserva.getIdReserva());

        return ReservaMapper.toResponseDTO(
                reservaCompleta);

    }
        /**
     * {@inheritDoc}
     */
    @Override
    public ReservaResponseDTO actualizar(
            Integer id,
            ReservaUpdateDTO request) {

        Reserva reserva =
                obtenerReserva(id);

        reserva.setFechaLimite(
                request.getFechaLimite());

        reserva.setObservaciones(
                request.getObservaciones());

        reserva.setFechaActualizacion(
                LocalDateTime.now());

        reserva =
                reservaRepository.save(
                        reserva);

        return ReservaMapper.toResponseDTO(
                reserva);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservaResponseDTO atender(
            Integer id) {

        Reserva reserva =
                obtenerReserva(id);

        if (reserva.getFechaAtencion()
                != null) {

            throw new InvalidOperationException(
                    "La reserva ya fue atendida.");

        }

        EstadoReserva estadoAtendida =
                obtenerEstadoReserva(
                        EstadoReservaConstantes.ATENDIDA);

        reserva.setFechaAtencion(
                LocalDate.now());

        reserva.setEstadoReserva(
                estadoAtendida);

        reserva.setFechaActualizacion(
                LocalDateTime.now());

        reserva =
                reservaRepository.save(
                        reserva);

        return ReservaMapper.toResponseDTO(
                reserva);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservaResponseDTO cancelar(
            Integer id) {

        Reserva reserva =
                obtenerReserva(id);

        if (reserva.getFechaAtencion()
                != null) {

            throw new InvalidOperationException(
                    "No es posible cancelar "
                    + "una reserva atendida.");

        }

        EstadoReserva estadoCancelada =
                obtenerEstadoReserva(
                        EstadoReservaConstantes.CANCELADA);

        reserva.setEstadoReserva(
                estadoCancelada);

        reserva.setActivo(
                Boolean.FALSE);

        reserva.setFechaActualizacion(
                LocalDateTime.now());

        reserva =
                reservaRepository.save(
                        reserva);

        return ReservaMapper.toResponseDTO(
                reserva);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeFolio(
            String folio) {

        return reservaRepository
                .existsByFolio(
                        folio);

    }
        /**
     * Obtiene un usuario por su identificador.
     *
     * @param id Identificador.
     * @return Usuario.
     */
    private Usuario obtenerUsuario(
            Integer id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "id",
                                id));

    }

    /**
     * Obtiene un libro por su identificador.
     *
     * @param id Identificador.
     * @return Libro.
     */
    private Libro obtenerLibro(
            Integer id) {

        return libroRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Libro",
                                "id",
                                id));

    }

    /**
     * Obtiene una reserva por su identificador.
     *
     * @param id Identificador.
     * @return Reserva.
     */
    private Reserva obtenerReserva(
            Integer id) {

        return reservaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reserva",
                                "id",
                                id));

    }

    /**
     * Obtiene un estado de reserva.
     *
     * @param nombre Nombre del estado.
     * @return Estado de reserva.
     */
    private EstadoReserva obtenerEstadoReserva(
            String nombre) {

        return estadoReservaRepository
                .findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EstadoReserva",
                                "nombre",
                                nombre));

    }

    /**
     * Valida que el usuario
     * se encuentre activo.
     *
     * @param usuario Usuario.
     */
    private void validarUsuario(
            Usuario usuario) {

        if (!Boolean.TRUE.equals(
                usuario.getActivo())) {

            throw new InvalidOperationException(
                    "El usuario se encuentra inactivo.");

        }

    }

    /**
     * Valida que el libro
     * se encuentre activo.
     *
     * @param libro Libro.
     */
    private void validarLibroActivo(
            Libro libro) {

        if (!Boolean.TRUE.equals(
                libro.getActivo())) {

            throw new InvalidOperationException(
                    "El libro se encuentra inactivo.");

        }

    }

    /**
     * Valida que el usuario
     * no tenga una reserva activa
     * para el mismo libro.
     *
     * @param usuario Usuario.
     * @param libro Libro.
     */
    private void validarReservaExistente(
            Usuario usuario,
            Libro libro) {

        boolean existe =
                reservaRepository
                        .existsByUsuarioIdUsuarioAndLibroIdLibroAndFechaAtencionIsNull(
                                usuario.getIdUsuario(),
                                libro.getIdLibro());

        if (existe) {

            throw new InvalidOperationException(
                    "El usuario ya tiene una reserva activa para este libro.");

        }

    }

}