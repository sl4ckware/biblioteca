package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.EjemplarRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EjemplarResponseDTO;
import mx.edu.itvo.biblioteca.entity.Ejemplar;

/**
 * Clase encargada de convertir objetos entre la entidad Ejemplar
 * y sus diferentes DTO.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EjemplarMapper {

    /**
     * Constructor privado para evitar instanciación.
     */
    private EjemplarMapper() {
    }

    /**
     * Convierte un RequestDTO en una entidad.
     *
     * @param dto DTO recibido desde la API.
     * @return Entidad Ejemplar.
     */
    public static Ejemplar toEntity(EjemplarRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Ejemplar ejemplar = new Ejemplar();

        ejemplar.setCodigoInventario(dto.getCodigoInventario());
        ejemplar.setUbicacion(dto.getUbicacion());
        ejemplar.setFechaAlta(dto.getFechaAlta());
        ejemplar.setObservaciones(dto.getObservaciones());

        return ejemplar;

    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param ejemplar Entidad.
     * @return ResponseDTO.
     */
    public static EjemplarResponseDTO toResponse(Ejemplar ejemplar) {

        if (ejemplar == null) {
            return null;
        }

        EjemplarResponseDTO dto = new EjemplarResponseDTO();

        dto.setIdEjemplar(ejemplar.getIdEjemplar());
        dto.setCodigoInventario(ejemplar.getCodigoInventario());
        dto.setUbicacion(ejemplar.getUbicacion());
        dto.setFechaAlta(ejemplar.getFechaAlta());
        dto.setObservaciones(ejemplar.getObservaciones());

        dto.setActivo(ejemplar.getActivo());
        dto.setFechaCreacion(ejemplar.getFechaCreacion());
        dto.setFechaActualizacion(ejemplar.getFechaActualizacion());

        if (ejemplar.getLibro() != null) {

            dto.setIdLibro(
                    ejemplar.getLibro().getIdLibro());

            dto.setTituloLibro(
                    ejemplar.getLibro().getTitulo());

        }

        if (ejemplar.getEstadoEjemplar() != null) {

            dto.setIdEstadoEjemplar(
                    ejemplar.getEstadoEjemplar().getIdEstadoEjemplar());

            dto.setEstadoEjemplar(
                    ejemplar.getEstadoEjemplar().getNombre());

        }

        return dto;

    }

    /**
     * Convierte una lista de entidades en una lista de ResponseDTO.
     *
     * @param ejemplares Lista de entidades.
     * @return Lista de ResponseDTO.
     */
    public static List<EjemplarResponseDTO> toResponseList(
            List<Ejemplar> ejemplares) {

        return ejemplares.stream()
                .map(EjemplarMapper::toResponse)
                .collect(Collectors.toList());

    }

    /**
     * Actualiza una entidad existente utilizando un RequestDTO.
     *
     * @param dto DTO recibido.
     * @param ejemplar Entidad existente.
     */
    public static void updateEntity(
            EjemplarRequestDTO dto,
            Ejemplar ejemplar) {

        ejemplar.setCodigoInventario(dto.getCodigoInventario());
        ejemplar.setUbicacion(dto.getUbicacion());
        ejemplar.setFechaAlta(dto.getFechaAlta());
        ejemplar.setObservaciones(dto.getObservaciones());

    }

}