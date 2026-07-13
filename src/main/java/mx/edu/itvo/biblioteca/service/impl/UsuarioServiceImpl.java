package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.UsuarioRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.UsuarioResponseDTO;
import mx.edu.itvo.biblioteca.entity.EstadoUsuario;
import mx.edu.itvo.biblioteca.entity.TipoUsuario;
import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.exception.DuplicateResourceException;
import mx.edu.itvo.biblioteca.exception.ResourceNotFoundException;
import mx.edu.itvo.biblioteca.mapper.UsuarioMapper;
import mx.edu.itvo.biblioteca.repository.EstadoUsuarioRepository;
import mx.edu.itvo.biblioteca.repository.TipoUsuarioRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import mx.edu.itvo.biblioteca.service.UsuarioService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de usuarios.
 *
 * Contiene la lógica de negocio de la entidad Usuario.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Repositorio de tipos de usuario.
     */
    private final TipoUsuarioRepository tipoUsuarioRepository;

    /**
     * Repositorio de estados de usuario.
     */
    private final EstadoUsuarioRepository estadoUsuarioRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param usuarioRepository Repositorio de usuarios.
     * @param tipoUsuarioRepository Repositorio de tipos de usuario.
     * @param estadoUsuarioRepository Repositorio de estados de usuario.
     */
    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            TipoUsuarioRepository tipoUsuarioRepository,
            EstadoUsuarioRepository estadoUsuarioRepository) {

        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;

    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return Lista de usuarios.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listar() {

        return UsuarioMapper.toResponseList(
                usuarioRepository.findAll());

    }

    /**
     * Obtiene únicamente los usuarios activos.
     *
     * @return Lista de usuarios activos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarActivos() {

        return UsuarioMapper.toResponseList(
                usuarioRepository.findByActivoTrue());

    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id Identificador.
     * @return Usuario encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "id",
                                id));

        return UsuarioMapper.toResponse(usuario);

    }

    /**
     * Busca un usuario por su matrícula.
     *
     * @param matricula Matrícula.
     * @return Usuario encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorMatricula(String matricula) {

        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "matrícula",
                                matricula));

        return UsuarioMapper.toResponse(usuario);

    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico.
     * @return Usuario encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorCorreo(String correo) {

        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "correo",
                                correo));

        return UsuarioMapper.toResponse(usuario);

    }

    /**
     * Busca usuarios por nombre.
     *
     * @param nombre Nombre.
     * @return Lista de usuarios.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> buscarPorNombre(String nombre) {

        return UsuarioMapper.toResponseList(
                usuarioRepository.findByNombreContainingIgnoreCase(nombre));

    }

    /**
     * Guarda un nuevo usuario.
     *
     * @param request Información recibida desde la API.
     * @return Usuario registrado.
     */
    @Override
    public UsuarioResponseDTO guardar(UsuarioRequestDTO request) {

        if (usuarioRepository.existsByMatricula(request.getMatricula())) {

            throw new DuplicateResourceException(
                    "Usuario",
                    "matrícula",
                    request.getMatricula());

        }

        if (usuarioRepository.existsByCorreo(request.getCorreo())) {

            throw new DuplicateResourceException(
                    "Usuario",
                    "correo",
                    request.getCorreo());

        }

        TipoUsuario tipoUsuario = tipoUsuarioRepository
                .findById(request.getIdTipoUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tipo de usuario",
                                "id",
                                request.getIdTipoUsuario()));

        EstadoUsuario estadoUsuario = estadoUsuarioRepository
                .findById(request.getIdEstadoUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estado de usuario",
                                "id",
                                request.getIdEstadoUsuario()));

        Usuario usuario = UsuarioMapper.toEntity(request);

        usuario.setTipoUsuario(tipoUsuario);
        usuario.setEstadoUsuario(estadoUsuario);
        usuario.setActivo(Boolean.TRUE);
        usuario.setFechaCreacion(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);

    }

    /**
     * Actualiza un usuario existente.
     *
     * @param id Identificador del usuario.
     * @param request Información actualizada.
     * @return Usuario actualizado.
     */
    @Override
    public UsuarioResponseDTO actualizar(
            Integer id,
            UsuarioRequestDTO request) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "id",
                                id));

        if (!usuario.getMatricula().equals(request.getMatricula())
                && usuarioRepository.existsByMatricula(
                        request.getMatricula())) {

            throw new DuplicateResourceException(
                    "Usuario",
                    "matrícula",
                    request.getMatricula());

        }

        if (request.getCorreo() != null
                && !request.getCorreo().equalsIgnoreCase(usuario.getCorreo())
                && usuarioRepository.existsByCorreo(request.getCorreo())) {

            throw new DuplicateResourceException(
                    "Usuario",
                    "correo",
                    request.getCorreo());

        }

        TipoUsuario tipoUsuario = tipoUsuarioRepository
                .findById(request.getIdTipoUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tipo de usuario",
                                "id",
                                request.getIdTipoUsuario()));

        EstadoUsuario estadoUsuario = estadoUsuarioRepository
                .findById(request.getIdEstadoUsuario())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Estado de usuario",
                                "id",
                                request.getIdEstadoUsuario()));

        UsuarioMapper.updateEntity(request, usuario);

        usuario.setTipoUsuario(tipoUsuario);
        usuario.setEstadoUsuario(estadoUsuario);
        usuario.setFechaActualizacion(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);

    }
    
    /**
     * Realiza la eliminación lógica de un usuario.
     *
     * @param id Identificador del usuario.
     */
    @Override
    public void eliminar(Integer id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario",
                                "id",
                                id));

        usuario.setActivo(Boolean.FALSE);
        usuario.setFechaActualizacion(LocalDateTime.now());

        usuarioRepository.save(usuario);

    }

    /**
     * Verifica si existe una matrícula registrada.
     *
     * @param matricula Matrícula.
     * @return {@code true} si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeMatricula(String matricula) {

        return usuarioRepository.existsByMatricula(matricula);

    }

    /**
     * Verifica si existe un correo electrónico registrado.
     *
     * @param correo Correo electrónico.
     * @return {@code true} si existe.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean existeCorreo(String correo) {

        return usuarioRepository.existsByCorreo(correo);

    }

}