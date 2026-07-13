package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.UsuarioRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.UsuarioResponseDTO;
import mx.edu.itvo.biblioteca.entity.Usuario;

/**
 * Clase encargada de convertir objetos entre la entidad Usuario
 * y sus diferentes DTO.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class UsuarioMapper {

    /**
     * Constructor privado para evitar instanciación.
     */
    private UsuarioMapper() {
    }

    /**
     * Convierte un RequestDTO en una entidad.
     *
     * @param dto DTO recibido desde la API.
     * @return Entidad Usuario.
     */
    public static Usuario toEntity(UsuarioRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setMatricula(dto.getMatricula());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setTelefono(dto.getTelefono());

        return usuario;

    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param usuario Entidad.
     * @return ResponseDTO.
     */
    public static UsuarioResponseDTO toResponse(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setMatricula(usuario.getMatricula());
        dto.setNombre(usuario.getNombre());
        dto.setApellidoPaterno(usuario.getApellidoPaterno());
        dto.setApellidoMaterno(usuario.getApellidoMaterno());
        dto.setCorreo(usuario.getCorreo());
        dto.setTelefono(usuario.getTelefono());

        dto.setActivo(usuario.getActivo());

        dto.setFechaCreacion(usuario.getFechaCreacion());
        dto.setFechaActualizacion(usuario.getFechaActualizacion());

        if (usuario.getTipoUsuario() != null) {

            dto.setIdTipoUsuario(
                    usuario.getTipoUsuario().getIdTipoUsuario());

            dto.setTipoUsuario(
                    usuario.getTipoUsuario().getNombre());

        }

        if (usuario.getEstadoUsuario() != null) {

            dto.setIdEstadoUsuario(
                    usuario.getEstadoUsuario().getIdEstadoUsuario());

            dto.setEstadoUsuario(
                    usuario.getEstadoUsuario().getNombre());

        }

        return dto;

    }

    /**
     * Convierte una lista de entidades en una lista de ResponseDTO.
     *
     * @param usuarios Lista de entidades.
     * @return Lista de ResponseDTO.
     */
    public static List<UsuarioResponseDTO> toResponseList(
            List<Usuario> usuarios) {

        return usuarios.stream()
                .map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());

    }

    /**
     * Actualiza una entidad existente utilizando un RequestDTO.
     *
     * @param dto DTO recibido.
     * @param usuario Entidad existente.
     */
    public static void updateEntity(
            UsuarioRequestDTO dto,
            Usuario usuario) {

        usuario.setMatricula(dto.getMatricula());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setTelefono(dto.getTelefono());

    }

}