package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.AutorRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.AutorResponseDTO;
import mx.edu.itvo.biblioteca.entity.Autor;

/**
 * Clase encargada de convertir objetos entre la entidad Autor
 * y sus DTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class AutorMapper {

    /**
     * Constructor privado para evitar la instanciación
     * de la clase utilitaria.
     */
    private AutorMapper() {
    }

    /**
     * Convierte un AutorRequestDTO en una entidad Autor.
     *
     * @param dto objeto que contiene la información recibida desde la API.
     * @return entidad Autor.
     */
    public static Autor toEntity(AutorRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Autor autor = new Autor();

        autor.setNombre(dto.getNombre());
        autor.setApellidoPaterno(dto.getApellidoPaterno());
        autor.setApellidoMaterno(dto.getApellidoMaterno());
        autor.setNacionalidad(dto.getNacionalidad());
        autor.setActivo(dto.getActivo());

        return autor;
    }

    /**
     * Convierte una entidad Autor en un AutorResponseDTO.
     *
     * @param autor entidad recuperada desde la base de datos.
     * @return DTO de respuesta.
     */
    public static AutorResponseDTO toResponse(Autor autor) {

        if (autor == null) {
            return null;
        }

        AutorResponseDTO dto = new AutorResponseDTO();

        dto.setIdAutor(autor.getIdAutor());
        dto.setNombre(autor.getNombre());
        dto.setApellidoPaterno(autor.getApellidoPaterno());
        dto.setApellidoMaterno(autor.getApellidoMaterno());
        dto.setNacionalidad(autor.getNacionalidad());
        dto.setActivo(autor.getActivo());
        dto.setFechaCreacion(autor.getFechaCreacion());
        dto.setFechaActualizacion(autor.getFechaActualizacion());

        return dto;
    }

    /**
     * Convierte una lista de entidades Autor en una lista
     * de AutorResponseDTO.
     *
     * @param autores lista de entidades Autor.
     * @return lista de DTO de respuesta.
     */
    public static List<AutorResponseDTO> toResponseList(
            List<Autor> autores) {

        return autores.stream()
                .map(AutorMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza una entidad Autor utilizando la información
     * contenida en un AutorRequestDTO.
     *
     * @param dto información recibida desde la API.
     * @param autor entidad que será actualizada.
     */
    public static void updateEntity(
            AutorRequestDTO dto,
            Autor autor) {

        autor.setNombre(dto.getNombre());
        autor.setApellidoPaterno(dto.getApellidoPaterno());
        autor.setApellidoMaterno(dto.getApellidoMaterno());
        autor.setNacionalidad(dto.getNacionalidad());
        autor.setActivo(dto.getActivo());

    }

}