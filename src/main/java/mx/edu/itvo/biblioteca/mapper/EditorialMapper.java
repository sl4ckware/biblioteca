package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.entity.Editorial;

/**
 * Clase encargada de convertir objetos entre la entidad Editorial
 * y sus DTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class EditorialMapper {

    private EditorialMapper() {
    }

    public static Editorial toEntity(EditorialRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Editorial editorial = new Editorial();

        editorial.setNombre(dto.getNombre());
        editorial.setPais(dto.getPais());
        editorial.setCiudad(dto.getCiudad());
        editorial.setTelefono(dto.getTelefono());
        editorial.setCorreo(dto.getCorreo());
        editorial.setSitioWeb(dto.getSitioWeb());

        return editorial;
    }

    public static EditorialResponseDTO toResponse(Editorial editorial) {

        if (editorial == null) {
            return null;
        }

        EditorialResponseDTO dto = new EditorialResponseDTO();

        dto.setIdEditorial(editorial.getIdEditorial());
        dto.setNombre(editorial.getNombre());
        dto.setPais(editorial.getPais());
        dto.setCiudad(editorial.getCiudad());
        dto.setTelefono(editorial.getTelefono());
        dto.setCorreo(editorial.getCorreo());
        dto.setSitioWeb(editorial.getSitioWeb());
        dto.setActivo(editorial.getActivo());
        dto.setFechaCreacion(editorial.getFechaCreacion());
        dto.setFechaActualizacion(editorial.getFechaActualizacion());

        return dto;
    }

    public static List<EditorialResponseDTO> toResponseList(
            List<Editorial> editoriales) {

        return editoriales.stream()
                .map(EditorialMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static void updateEntity(
            EditorialRequestDTO dto,
            Editorial editorial) {

        editorial.setNombre(dto.getNombre());
        editorial.setPais(dto.getPais());
        editorial.setCiudad(dto.getCiudad());
        editorial.setTelefono(dto.getTelefono());
        editorial.setCorreo(dto.getCorreo());
        editorial.setSitioWeb(dto.getSitioWeb());

    }

}
