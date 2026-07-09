package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;
import mx.edu.itvo.biblioteca.entity.Libro;

/**
 * Mapper para la conversión entre la entidad Libro y sus DTO.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class LibroMapper {

    /**
     * Constructor privado.
     */
    private LibroMapper() {
    }

    /**
     * Convierte un Libro a LibroResponseDTO.
     *
     * @param libro entidad.
     * @return DTO.
     */
    public static LibroResponseDTO toResponse(Libro libro) {

        if (libro == null) {
            return null;
        }

        LibroResponseDTO dto = new LibroResponseDTO();

        dto.setIdLibro(libro.getIdLibro());
        dto.setIsbn13(libro.getIsbn13());
        dto.setTitulo(libro.getTitulo());
        dto.setSubtitulo(libro.getSubtitulo());
        dto.setNumeroEdicion(libro.getNumeroEdicion());
        dto.setFechaPublicacion(libro.getFechaPublicacion());
        dto.setNumeroPaginas(libro.getNumeroPaginas());
        dto.setClasificacion(libro.getClasificacion());
        dto.setSinopsis(libro.getSinopsis());
        dto.setImagenPortada(libro.getImagenPortada());

        dto.setActivo(libro.getActivo());
        dto.setFechaCreacion(libro.getFechaCreacion());
        dto.setFechaActualizacion(libro.getFechaActualizacion());

        if (libro.getCategoria() != null) {
            dto.setIdCategoria(libro.getCategoria().getIdCategoria());
            dto.setCategoria(libro.getCategoria().getNombre());
        }

        if (libro.getEditorial() != null) {
            dto.setIdEditorial(libro.getEditorial().getIdEditorial());
            dto.setEditorial(libro.getEditorial().getNombre());
        }

        if (libro.getIdioma() != null) {
            dto.setIdIdioma(libro.getIdioma().getIdIdioma());
            dto.setIdioma(libro.getIdioma().getNombre());
        }

        return dto;

    }

    /**
     * Convierte un RequestDTO a entidad.
     *
     * Las relaciones se asignan posteriormente en el Service.
     *
     * @param request DTO.
     * @return entidad.
     */
    public static Libro toEntity(LibroRequestDTO request) {

        if (request == null) {
            return null;
        }

        Libro libro = new Libro();

        libro.setIsbn13(request.getIsbn13());
        libro.setTitulo(request.getTitulo());
        libro.setSubtitulo(request.getSubtitulo());
        libro.setNumeroEdicion(request.getNumeroEdicion());
        libro.setFechaPublicacion(request.getFechaPublicacion());
        libro.setNumeroPaginas(request.getNumeroPaginas());
        libro.setClasificacion(request.getClasificacion());
        libro.setSinopsis(request.getSinopsis());
        libro.setImagenPortada(request.getImagenPortada());
        libro.setActivo(request.getActivo());

        return libro;

    }

    /**
     * Actualiza una entidad existente.
     *
     * @param request DTO.
     * @param libro entidad.
     */
    public static void updateEntity(
            LibroRequestDTO request,
            Libro libro) {

        libro.setIsbn13(request.getIsbn13());
        libro.setTitulo(request.getTitulo());
        libro.setSubtitulo(request.getSubtitulo());
        libro.setNumeroEdicion(request.getNumeroEdicion());
        libro.setFechaPublicacion(request.getFechaPublicacion());
        libro.setNumeroPaginas(request.getNumeroPaginas());
        libro.setClasificacion(request.getClasificacion());
        libro.setSinopsis(request.getSinopsis());
        libro.setImagenPortada(request.getImagenPortada());
        libro.setActivo(request.getActivo());

    }

    /**
     * Convierte una lista de entidades.
     *
     * @param lista lista de libros.
     * @return lista de DTO.
     */
    public static List<LibroResponseDTO> toResponseList(
            List<Libro> lista) {

        return lista.stream()
                .map(LibroMapper::toResponse)
                .collect(Collectors.toList());

    }

}