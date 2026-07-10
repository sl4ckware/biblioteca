package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;
import mx.edu.itvo.biblioteca.entity.Libro;

/**
 * Clase utilitaria encargada de realizar la conversión entre la entidad
 * {@link Libro} y sus objetos de transferencia de datos (DTO).
 *
 * <p>
 * Esta clase únicamente realiza conversiones de información y no contiene
 * lógica de negocio ni acceso a la base de datos.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class LibroMapper {

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private LibroMapper() {
    }

    /**
     * Convierte una entidad {@link Libro} en un {@link LibroResponseDTO}.
     *
     * @param libro Entidad a convertir.
     * @return DTO con la información del libro o {@code null} si la entidad es
     *         nula.
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

        // Información de la categoría.
        if (libro.getCategoria() != null) {
            dto.setIdCategoria(libro.getCategoria().getIdCategoria());
            dto.setCategoria(libro.getCategoria().getNombre());
        }

        // Información de la editorial.
        if (libro.getEditorial() != null) {
            dto.setIdEditorial(libro.getEditorial().getIdEditorial());
            dto.setEditorial(libro.getEditorial().getNombre());
        }

        // Información del idioma.
        if (libro.getIdioma() != null) {
            dto.setIdIdioma(libro.getIdioma().getIdIdioma());
            dto.setIdioma(libro.getIdioma().getNombre());
        }

        return dto;
    }

    /**
     * Convierte un {@link LibroRequestDTO} en una entidad {@link Libro}.
     *
     * <p>
     * Las relaciones con Categoría, Editorial e Idioma no son establecidas en
     * este método, ya que son responsabilidad de la capa de servicio.
     * </p>
     *
     * @param request DTO con la información del libro.
     * @return Entidad Libro.
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
     * Actualiza una entidad {@link Libro} con la información recibida desde el
     * {@link LibroRequestDTO}.
     *
     * <p>
     * Las relaciones con otras entidades son administradas por la capa de
     * servicio.
     * </p>
     *
     * @param request DTO con la nueva información.
     * @param libro   Entidad que será actualizada.
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
     * Convierte una lista de entidades {@link Libro} en una lista de
     * {@link LibroResponseDTO}.
     *
     * @param lista Lista de entidades.
     * @return Lista de DTO convertidos.
     */
    public static List<LibroResponseDTO> toResponseList(
            List<Libro> lista) {

        return lista.stream()
                .map(LibroMapper::toResponse)
                .collect(Collectors.toList());

    }

}