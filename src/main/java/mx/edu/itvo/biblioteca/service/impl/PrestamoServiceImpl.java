package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.constant.EstadoEjemplarConstantes;
import mx.edu.itvo.biblioteca.constant.FolioConstantes;
import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.entity.Ejemplar;
import mx.edu.itvo.biblioteca.entity.EstadoEjemplar;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.exception.InvalidOperationException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.PrestamoMapper;
import mx.edu.itvo.biblioteca.repository.EjemplarRepository;
import mx.edu.itvo.biblioteca.repository.EstadoEjemplarRepository;
import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import mx.edu.itvo.biblioteca.service.PrestamoService;
import mx.edu.itvo.biblioteca.util.FolioGenerator;

/**
 * Implementación del servicio para la gestión
 * de préstamos.
 *
 * Contiene la lógica de negocio del módulo
 * de préstamos de la biblioteca.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Service
@Transactional
public class PrestamoServiceImpl
        implements PrestamoService {

    /**
     * Repositorio de préstamos.
     */
    private final PrestamoRepository prestamoRepository;

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Repositorio de ejemplares.
     */
    private final EjemplarRepository ejemplarRepository;

    /**
     * Repositorio de estados.
     */
    private final EstadoEjemplarRepository estadoEjemplarRepository;

    /**
     * Constructor.
     *
     * @param prestamoRepository Repositorio de préstamos.
     * @param usuarioRepository Repositorio de usuarios.
     * @param ejemplarRepository Repositorio de ejemplares.
     * @param estadoEjemplarRepository Repositorio de estados.
     */
    public PrestamoServiceImpl(
            PrestamoRepository prestamoRepository,
            UsuarioRepository usuarioRepository,
            EjemplarRepository ejemplarRepository,
            EstadoEjemplarRepository estadoEjemplarRepository) {

        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository = usuarioRepository;
        this.ejemplarRepository = ejemplarRepository;
        this.estadoEjemplarRepository =
                estadoEjemplarRepository;

    }

    /**
     * Obtiene todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> listar() {

        return PrestamoMapper.toResponseList(
                prestamoRepository.findAll());

    }

    /**
     * Obtiene los préstamos activos.
     *
     * @return Lista de préstamos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> listarActivos() {

        return PrestamoMapper.toResponseList(
                prestamoRepository.findByActivoTrue());

    }

    /**
     * Busca un préstamo por su ID.
     *
     * @param id Identificador.
     * @return Préstamo encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public PrestamoResponseDTO buscarPorId(
            Integer id) {

        return PrestamoMapper.toResponse(
                obtenerPrestamo(id));

    }

    /**
     * Busca un préstamo por folio.
     *
     * @param folio Folio.
     * @return Préstamo encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public PrestamoResponseDTO buscarPorFolio(
            String folio) {

        Prestamo prestamo =
                prestamoRepository
                        .findByFolio(folio)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Préstamo",
                                        "folio",
                                        folio));

        return PrestamoMapper.toResponse(
                prestamo);

    }

    /**
     * Busca los préstamos
     * de un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista de préstamos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarPorUsuario(
            Integer idUsuario) {

        return PrestamoMapper.toResponseList(
                prestamoRepository
                        .findByUsuarioIdUsuario(
                                idUsuario));

    }

    /**
     * Busca los préstamos
     * de un ejemplar.
     *
     * @param idEjemplar Identificador.
     * @return Lista de préstamos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarPorEjemplar(
            Integer idEjemplar) {

        return PrestamoMapper.toResponseList(
                prestamoRepository
                        .findByEjemplarIdEjemplar(
                                idEjemplar));

    }

    /**
     * Obtiene los préstamos vencidos.
     *
     * @return Lista de préstamos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarVencidos() {

        return PrestamoMapper.toResponseList(
                prestamoRepository
                        .findByFechaDevolucionProgramadaBefore(
                                LocalDate.now()));

    }
        /**
     * Registra un nuevo préstamo.
     *
     * @param request Información del préstamo.
     * @return Préstamo registrado.
     */
    @Override
    public PrestamoResponseDTO guardar(
            PrestamoRequestDTO request) {

        Usuario usuario = obtenerUsuario(
                request.getIdUsuario());

        validarUsuario(usuario);

        Ejemplar ejemplar = obtenerEjemplar(
                request.getIdEjemplar());

        validarEjemplarActivo(ejemplar);
        validarDisponibilidad(ejemplar);

        EstadoEjemplar estadoPrestado =
                obtenerEstado(
                        EstadoEjemplarConstantes.PRESTADO);

        Prestamo prestamo =
                PrestamoMapper.toEntity(request);

        prestamo.setUsuario(usuario);
        prestamo.setEjemplar(ejemplar);
        prestamo.setActivo(Boolean.TRUE);
        prestamo.setFechaCreacion(
                LocalDateTime.now());

        /*
         * Primer guardado para obtener
         * el identificador generado.
         */
        prestamo =
                prestamoRepository.save(prestamo);

        /*
         * Se genera el folio definitivo.
         */
        prestamo.setFolio(
                FolioGenerator.generar(
                        FolioConstantes.PRESTAMO,
                        prestamo.getIdPrestamo()));

        prestamo.setFechaActualizacion(
                LocalDateTime.now());

        prestamo =
                prestamoRepository.save(prestamo);

        /*
         * El ejemplar cambia a estado PRESTADO.
         */
        ejemplar.setEstadoEjemplar(
                estadoPrestado);

        ejemplar.setFechaActualizacion(
                LocalDateTime.now());

        ejemplarRepository.save(ejemplar);

        return PrestamoMapper.toResponse(
                prestamo);

    }
        /**
     * Actualiza la información editable
     * de un préstamo.
     *
     * @param id Identificador del préstamo.
     * @param request Información editable.
     * @return Préstamo actualizado.
     */
    @Override
    public PrestamoResponseDTO actualizar(
            Integer id,
            PrestamoUpdateDTO request) {

        Prestamo prestamo =
                obtenerPrestamo(id);

        prestamo.setFechaDevolucionProgramada(
                request.getFechaDevolucionProgramada());

        prestamo.setObservaciones(
                request.getObservaciones());

        prestamo.setFechaActualizacion(
                LocalDateTime.now());

        prestamo =
                prestamoRepository.save(prestamo);

        return PrestamoMapper.toResponse(
                prestamo);

    }

    /**
     * Registra la devolución de un préstamo.
     *
     * @param id Identificador del préstamo.
     * @return Préstamo actualizado.
     */
    @Override
    public PrestamoResponseDTO devolver(
            Integer id) {

        Prestamo prestamo =
                obtenerPrestamo(id);

        if (prestamo.getFechaDevolucionReal() != null) {

            throw new InvalidOperationException(
                    "El préstamo ya fue devuelto.");

        }

        EstadoEjemplar estadoDisponible =
                obtenerEstado(
                        EstadoEjemplarConstantes.DISPONIBLE);

        Ejemplar ejemplar =
                prestamo.getEjemplar();

        ejemplar.setEstadoEjemplar(
                estadoDisponible);

        ejemplar.setFechaActualizacion(
                LocalDateTime.now());

        ejemplarRepository.save(ejemplar);

        prestamo.setFechaDevolucionReal(
                LocalDate.now());

        prestamo.setFechaActualizacion(
                LocalDateTime.now());

        prestamo =
                prestamoRepository.save(prestamo);

        return PrestamoMapper.toResponse(
                prestamo);

    }

    /**
     * Renueva un préstamo.
     *
     * @param id Identificador del préstamo.
     * @param dias Días adicionales.
     * @return Préstamo actualizado.
     */
    @Override
    public PrestamoResponseDTO renovar(
            Integer id,
            Integer dias) {

        Prestamo prestamo =
                obtenerPrestamo(id);

        if (!Boolean.TRUE.equals(
                prestamo.getActivo())) {

            throw new InvalidOperationException(
                    "El préstamo se encuentra inactivo.");

        }

        if (prestamo.getFechaDevolucionReal() != null) {

            throw new InvalidOperationException(
                    "No es posible renovar un préstamo devuelto.");

        }

        if (dias == null || dias <= 0) {

            throw new InvalidOperationException(
                    "Los días de renovación deben ser mayores que cero.");

        }

        prestamo.setFechaDevolucionProgramada(
                prestamo.getFechaDevolucionProgramada()
                        .plusDays(dias));

        prestamo.setFechaActualizacion(
                LocalDateTime.now());

        prestamo =
                prestamoRepository.save(prestamo);

        return PrestamoMapper.toResponse(
                prestamo);

    }

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio del préstamo.
     * @return {@code true} si existe;
     *         {@code false} en caso contrario.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeFolio(
            String folio) {

        return prestamoRepository.existsByFolio(
                folio);

    }
    
    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id Identificador del usuario.
     * @return Usuario encontrado.
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
     * Obtiene un ejemplar por su identificador.
     *
     * @param id Identificador del ejemplar.
     * @return Ejemplar encontrado.
     */
    private Ejemplar obtenerEjemplar(
            Integer id) {

        return ejemplarRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ejemplar",
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

    /**
     * Obtiene un estado de ejemplar por nombre.
     *
     * @param nombre Nombre del estado.
     * @return Estado encontrado.
     */
    private EstadoEjemplar obtenerEstado(
            String nombre) {

        return estadoEjemplarRepository
                .findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EstadoEjemplar",
                                "nombre",
                                nombre));

    }

    /**
     * Valida que el usuario se encuentre activo.
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
     * Valida que el ejemplar se encuentre activo.
     *
     * @param ejemplar Ejemplar.
     */
    private void validarEjemplarActivo(
            Ejemplar ejemplar) {

        if (!Boolean.TRUE.equals(
                ejemplar.getActivo())) {

            throw new InvalidOperationException(
                    "El ejemplar se encuentra inactivo.");

        }

    }

    /**
     * Valida que el ejemplar no tenga
     * un préstamo activo.
     *
     * @param ejemplar Ejemplar.
     */
    private void validarDisponibilidad(
            Ejemplar ejemplar) {

        boolean prestado =
                prestamoRepository
                        .existsByEjemplarIdEjemplarAndFechaDevolucionRealIsNull(
                                ejemplar.getIdEjemplar());

        if (prestado) {

            throw new InvalidOperationException(
                    "El ejemplar ya se encuentra prestado.");

        }

    }

}