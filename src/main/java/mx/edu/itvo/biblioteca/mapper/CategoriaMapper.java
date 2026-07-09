package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Categoria;

/**
 * Clase encargada de convertir objetos entre la entidad Categoria
 * y sus diferentes DTO.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class CategoriaMapper {

    /**
     * Constructor privado para evitar instanciación.
     */
    private CategoriaMapper() {
    }

    /**
     * Convierte un RequestDTO en una entidad.
     *
     * @param dto DTO recibido desde la API.
     * @return Entidad Categoria.
     */
    public static Categoria toEntity(CategoriaRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setCodigo(dto.getCodigo());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        return categoria;
    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param categoria Entidad.
     * @return ResponseDTO.
     */
    public static CategoriaResponseDTO toResponse(Categoria categoria) {

        if (categoria == null) {
            return null;
        }

        CategoriaResponseDTO dto = new CategoriaResponseDTO();

        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setCodigo(categoria.getCodigo());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        dto.setActivo(categoria.getActivo());
        dto.setFechaCreacion(categoria.getFechaCreacion());
        dto.setFechaActualizacion(categoria.getFechaActualizacion());

        return dto;
    }

    /**
     * Convierte una lista de entidades en una lista de ResponseDTO.
     *
     * @param categorias Lista de entidades.
     * @return Lista de ResponseDTO.
     */
    public static List<CategoriaResponseDTO> toResponseList(
            List<Categoria> categorias) {

        return categorias.stream()
                .map(CategoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza una entidad existente utilizando un RequestDTO.
     *
     * @param dto DTO recibido.
     * @param categoria Entidad existente.
     */
    public static void updateEntity(
            CategoriaRequestDTO dto,
            Categoria categoria) {

        categoria.setCodigo(dto.getCodigo());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

    }

}