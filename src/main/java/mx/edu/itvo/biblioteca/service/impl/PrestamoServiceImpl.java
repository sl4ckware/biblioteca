package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.constant.EstadoEjemplarConstantes;
import mx.edu.itvo.biblioteca.constant.EstadoPrestamoConstantes;
import mx.edu.itvo.biblioteca.constant.FolioConstantes;
import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.entity.Ejemplar;
import mx.edu.itvo.biblioteca.entity.EstadoEjemplar;
import mx.edu.itvo.biblioteca.entity.EstadoPrestamo;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.exception.InvalidOperationException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.PrestamoMapper;
import mx.edu.itvo.biblioteca.repository.EjemplarRepository;
import mx.edu.itvo.biblioteca.repository.EstadoEjemplarRepository;
import mx.edu.itvo.biblioteca.repository.EstadoPrestamoRepository;
import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import mx.edu.itvo.biblioteca.service.PrestamoService;
import mx.edu.itvo.biblioteca.util.FolioGenerator;

/**
 * Implementación del servicio de préstamos.
 *
 * @author Conce
 * @version 4.0
 * @since Sprint 17
 */
@Service
@Transactional
public class PrestamoServiceImpl
        implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    private final UsuarioRepository usuarioRepository;

    private final EjemplarRepository ejemplarRepository;

    private final EstadoEjemplarRepository
            estadoEjemplarRepository;

    private final EstadoPrestamoRepository
            estadoPrestamoRepository;

    public PrestamoServiceImpl(
            PrestamoRepository prestamoRepository,
            UsuarioRepository usuarioRepository,
            EjemplarRepository ejemplarRepository,
            EstadoEjemplarRepository estadoEjemplarRepository,
            EstadoPrestamoRepository estadoPrestamoRepository) {

        this.prestamoRepository =
                prestamoRepository;

        this.usuarioRepository =
                usuarioRepository;

        this.ejemplarRepository =
                ejemplarRepository;

        this.estadoEjemplarRepository =
                estadoEjemplarRepository;

        this.estadoPrestamoRepository =
                estadoPrestamoRepository;

    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> listar() {

        return PrestamoMapper.toResponseList(
                prestamoRepository.findAll());

    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> listarActivos() {

        return PrestamoMapper.toResponseList(
                prestamoRepository.findByActivoTrue());

    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO>
            listarPendientesDevolucion() {

        return PrestamoMapper.toResponseList(
                prestamoRepository
                        .findByFechaDevolucionRealIsNull());

    }

    @Override
    @Transactional(readOnly = true)
    public PrestamoResponseDTO buscarPorId(
            Integer id) {

        return PrestamoMapper.toResponseDTO(
                obtenerPrestamo(id));

    }

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

        return PrestamoMapper.toResponseDTO(
                prestamo);

    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarPorUsuario(
            Integer idUsuario) {

        return PrestamoMapper.toResponseList(

                prestamoRepository
                        .findByUsuarioIdUsuarioOrderByFechaPrestamoDesc(
                                idUsuario));

    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarPorEjemplar(
            Integer idEjemplar) {

        return PrestamoMapper.toResponseList(

                prestamoRepository
                        .findByEjemplarIdEjemplar(
                                idEjemplar));

    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoResponseDTO> buscarVencidos() {

        return PrestamoMapper.toResponseList(

                prestamoRepository
                        .findByFechaDevolucionProgramadaBeforeAndFechaDevolucionRealIsNull(
                                LocalDate.now()));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PrestamoResponseDTO registrarPrestamo(
            PrestamoRequestDTO request) {

        Usuario usuario =
                obtenerUsuario(
                        request.getIdUsuario());

        validarUsuario(
                usuario);

        validarLimitePrestamos(
                usuario);

        Ejemplar ejemplar =
                obtenerEjemplar(
                        request.getIdEjemplar());

        validarEjemplarActivo(
                ejemplar);

        validarEstadoDisponible(
                ejemplar);

        validarDisponibilidad(
                ejemplar);

        EstadoEjemplar estadoEjemplarPrestado =
                obtenerEstadoEjemplar(
                        EstadoEjemplarConstantes.PRESTADO);

        EstadoPrestamo estadoPrestamoActivo =
                obtenerEstadoPrestamo(
                        EstadoPrestamoConstantes.ACTIVO);

        Prestamo prestamo =
                PrestamoMapper.toEntity(
                        request);

        prestamo.setUsuario(
                usuario);

        prestamo.setEjemplar(
                ejemplar);

        prestamo.setActivo(
                Boolean.TRUE);
        
        Usuario bibliotecario =
        obtenerUsuario(
                request.getIdBibliotecario());

        prestamo.setBibliotecario(
                bibliotecario);
        

        prestamo.setEstadoPrestamo(
                estadoPrestamoActivo);

        prestamo.setFechaPrestamo(
                LocalDate.now());

        prestamo.setFechaDevolucionProgramada(
                calcularFechaDevolucion(
                        usuario));

        /*
         * Se genera un folio temporal para cumplir
         * con la restricción NOT NULL.
         */
        prestamo.setFolio(
                "TMP-"
                + System.currentTimeMillis());

        prestamo =
                prestamoRepository.save(
                        prestamo);

        prestamo.setFolio(
                FolioGenerator.generar(
                        FolioConstantes.PRESTAMO,
                        prestamo.getIdPrestamo()));

        prestamo =
                prestamoRepository.save(
                        prestamo);

        ejemplar.setEstadoEjemplar(
                estadoEjemplarPrestado);

        ejemplar.setFechaActualizacion(
                LocalDateTime.now());

        ejemplarRepository.save(
                ejemplar);

Prestamo prestamoCompleto =

        obtenerPrestamo(

                prestamo.getIdPrestamo());

return PrestamoMapper.toResponseDTO(

        prestamoCompleto);
    }
        /**
     * {@inheritDoc}
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

        prestamo =
                prestamoRepository.save(
                        prestamo);

       Prestamo prestamoCompleto =

        obtenerPrestamo(

                prestamo.getIdPrestamo());
       return PrestamoMapper.toResponseDTO(

        prestamoCompleto);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PrestamoResponseDTO devolver(
            Integer id) {

        Prestamo prestamo =
                obtenerPrestamo(id);

        if (prestamo.getFechaDevolucionReal()
                != null) {

            throw new InvalidOperationException(
                    "El préstamo ya fue devuelto.");

        }

        EstadoEjemplar estadoDisponible =
                obtenerEstadoEjemplar(
                        EstadoEjemplarConstantes.DISPONIBLE);

        EstadoPrestamo estadoDevuelto =
                obtenerEstadoPrestamo(
                        EstadoPrestamoConstantes.DEVUELTO);

        Ejemplar ejemplar =
                prestamo.getEjemplar();

        ejemplar.setEstadoEjemplar(
                estadoDisponible);

        ejemplar.setFechaActualizacion(
                LocalDateTime.now());

        ejemplarRepository.save(
                ejemplar);

        prestamo.setFechaDevolucionReal(
                LocalDate.now());

        prestamo.setEstadoPrestamo(
                estadoDevuelto);

        prestamo =
                prestamoRepository.save(
                        prestamo);

Prestamo prestamoCompleto =

        obtenerPrestamo(

                prestamo.getIdPrestamo());

return PrestamoMapper.toResponseDTO(

        prestamoCompleto);

    }

    /**
     * {@inheritDoc}
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

        if (prestamo.getFechaDevolucionReal()
                != null) {

            throw new InvalidOperationException(
                    "No es posible renovar "
                    + "un préstamo devuelto.");

        }

        if (dias == null
                || dias <= 0) {

            throw new InvalidOperationException(
                    "Los días de renovación "
                    + "deben ser mayores que cero.");

        }

        prestamo.setFechaDevolucionProgramada(

                prestamo
                        .getFechaDevolucionProgramada()
                        .plusDays(
                                dias));

prestamo =
        prestamoRepository.save(
                prestamo);

Prestamo prestamoCompleto =
        obtenerPrestamo(
                prestamo.getIdPrestamo());

return PrestamoMapper.toResponseDTO(
        prestamoCompleto);



    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeFolio(
            String folio) {

        return prestamoRepository
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
     * Obtiene un ejemplar.
     *
     * @param id Identificador.
     * @return Ejemplar.
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
     * Obtiene un estado de ejemplar.
     *
     * @param nombre Nombre.
     * @return Estado.
     */
    private EstadoEjemplar obtenerEstadoEjemplar(
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
     * Obtiene un estado de préstamo.
     *
     * @param nombre Nombre.
     * @return Estado.
     */
    private EstadoPrestamo obtenerEstadoPrestamo(
            String nombre) {

        return estadoPrestamoRepository
                .findByNombre(nombre)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EstadoPrestamo",
                                "nombre",
                                nombre));

    }

    /**
     * Valida que el usuario esté activo.
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
     * Valida que el ejemplar esté activo.
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
     * Valida que el ejemplar esté disponible.
     *
     * @param ejemplar Ejemplar.
     */
    private void validarEstadoDisponible(
            Ejemplar ejemplar) {

        if (ejemplar.getEstadoEjemplar() == null) {

            throw new InvalidOperationException(
                    "El ejemplar no tiene un estado asignado.");

        }

        if (!EstadoEjemplarConstantes.DISPONIBLE.equals(
                ejemplar.getEstadoEjemplar()
                        .getNombre())) {

            throw new InvalidOperationException(
                    "El ejemplar no se encuentra disponible.");

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

    /**
     * Valida el límite de préstamos.
     *
     * @param usuario Usuario.
     */
    private void validarLimitePrestamos(
            Usuario usuario) {

        int prestamosActivos =
                prestamoRepository
                        .findByUsuarioIdUsuarioAndFechaDevolucionRealIsNull(
                                usuario.getIdUsuario())
                        .size();

        if (prestamosActivos >= 3) {

            throw new InvalidOperationException(
                    "El usuario ha alcanzado el límite "
                    + "de préstamos activos.");

        }

    }

    /**
     * Calcula la fecha de devolución.
     *
     * @param usuario Usuario.
     * @return Fecha.
     */
    private LocalDate calcularFechaDevolucion(
            Usuario usuario) {

        return LocalDate.now()
                .plusDays(7);

    }

}