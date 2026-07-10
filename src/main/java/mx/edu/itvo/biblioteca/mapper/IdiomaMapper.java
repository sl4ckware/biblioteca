package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.IdiomaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.IdiomaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Idioma;

/**
 * Clase encargada de convertir objetos entre la entidad Idioma
 * y sus diferentes DTO.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class IdiomaMapper {

    /**
     * Constructor privado para evitar instanciación.
     */
    private IdiomaMapper() {
    }

    /**
     * Convierte un RequestDTO en una entidad.
     *
     * @param dto DTO recibido desde la API.
     * @return Entidad Idioma.
     */
    public static Idioma toEntity(IdiomaRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Idioma idioma = new Idioma();

        idioma.setNombre(dto.getNombre());
        idioma.setCodigoIso(dto.getCodigoIso());

        return idioma;

    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param idioma Entidad.
     * @return ResponseDTO.
     */
    public static IdiomaResponseDTO toResponse(Idioma idioma) {

        if (idioma == null) {
            return null;
        }

        IdiomaResponseDTO dto = new IdiomaResponseDTO();

        dto.setIdIdioma(idioma.getIdIdioma());
        dto.setNombre(idioma.getNombre());
        dto.setCodigoIso(idioma.getCodigoIso());
        dto.setActivo(idioma.getActivo());
        dto.setFechaCreacion(idioma.getFechaCreacion());
        dto.setFechaActualizacion(idioma.getFechaActualizacion());

        return dto;

    }

    /**
     * Convierte una lista de entidades en una lista de ResponseDTO.
     *
     * @param idiomas Lista de entidades.
     * @return Lista de ResponseDTO.
     */
    public static List<IdiomaResponseDTO> toResponseList(
            List<Idioma> idiomas) {

        return idiomas.stream()
                .map(IdiomaMapper::toResponse)
                .collect(Collectors.toList());

    }

    /**
     * Actualiza una entidad existente utilizando un RequestDTO.
     *
     * @param dto DTO recibido.
     * @param idioma Entidad existente.
     */
    public static void updateEntity(
            IdiomaRequestDTO dto,
            Idioma idioma) {

        idioma.setNombre(dto.getNombre());
        idioma.setCodigoIso(dto.getCodigoIso());

    }

}