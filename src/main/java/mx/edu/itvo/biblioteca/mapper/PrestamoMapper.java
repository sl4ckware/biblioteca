package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.entity.Prestamo;

/**
 * Clase encargada de convertir objetos entre la entidad Prestamo
 * y sus diferentes DTO.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class PrestamoMapper {

    /**
     * Constructor privado para evitar instanciación.
     */
    private PrestamoMapper() {
    }

    /**
     * Convierte un RequestDTO en una entidad.
     *
     * @param dto DTO recibido desde la API.
     * @return Entidad Prestamo.
     */
    public static Prestamo toEntity(
            PrestamoRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Prestamo prestamo = new Prestamo();

        prestamo.setFechaPrestamo(
                dto.getFechaPrestamo());

        prestamo.setFechaDevolucionProgramada(
                dto.getFechaDevolucionProgramada());

        prestamo.setObservaciones(
                dto.getObservaciones());

        return prestamo;

    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param prestamo Entidad.
     * @return ResponseDTO.
     */
    public static PrestamoResponseDTO toResponse(
            Prestamo prestamo) {

        if (prestamo == null) {
            return null;
        }

        PrestamoResponseDTO dto =
                new PrestamoResponseDTO();

        dto.setIdPrestamo(
                prestamo.getIdPrestamo());

        dto.setFolio(
                prestamo.getFolio());

        dto.setFechaPrestamo(
                prestamo.getFechaPrestamo());

        dto.setFechaDevolucionProgramada(
                prestamo.getFechaDevolucionProgramada());

        dto.setFechaDevolucionReal(
                prestamo.getFechaDevolucionReal());

        dto.setObservaciones(
                prestamo.getObservaciones());

        dto.setActivo(
                prestamo.getActivo());

        dto.setFechaCreacion(
                prestamo.getFechaCreacion());

        dto.setFechaActualizacion(
                prestamo.getFechaActualizacion());

        /*
         * Usuario
         */
        if (prestamo.getUsuario() != null) {

            dto.setIdUsuario(
                    prestamo.getUsuario().getIdUsuario());

            dto.setMatricula(
                    prestamo.getUsuario().getMatricula());

            StringBuilder nombreCompleto =
                    new StringBuilder();

            nombreCompleto.append(
                    prestamo.getUsuario().getNombre());

            nombreCompleto.append(" ");

            nombreCompleto.append(
                    prestamo.getUsuario()
                            .getApellidoPaterno());

            if (prestamo.getUsuario()
                    .getApellidoMaterno() != null
                    && !prestamo.getUsuario()
                            .getApellidoMaterno()
                            .isBlank()) {

                nombreCompleto.append(" ");

                nombreCompleto.append(
                        prestamo.getUsuario()
                                .getApellidoMaterno());

            }

            dto.setNombreCompleto(
                    nombreCompleto.toString());

        }

        /*
         * Ejemplar
         */
        if (prestamo.getEjemplar() != null) {

            dto.setIdEjemplar(
                    prestamo.getEjemplar()
                            .getIdEjemplar());

            dto.setCodigoInventario(
                    prestamo.getEjemplar()
                            .getCodigoInventario());

            /*
             * Libro
             */
            if (prestamo.getEjemplar()
                    .getLibro() != null) {

                dto.setIdLibro(
                        prestamo.getEjemplar()
                                .getLibro()
                                .getIdLibro());

                dto.setTituloLibro(
                        prestamo.getEjemplar()
                                .getLibro()
                                .getTitulo());

            }

        }

        return dto;

    }

    /**
     * Convierte una lista de entidades
     * en una lista de ResponseDTO.
     *
     * @param prestamos Lista de entidades.
     * @return Lista de ResponseDTO.
     */
    public static List<PrestamoResponseDTO> toResponseList(
            List<Prestamo> prestamos) {

        return prestamos.stream()
                .map(PrestamoMapper::toResponse)
                .collect(Collectors.toList());

    }

    /**
     * Actualiza una entidad existente
     * utilizando un RequestDTO.
     *
     * @param dto DTO recibido.
     * @param prestamo Entidad existente.
     */
    public static void updateEntity(
            PrestamoRequestDTO dto,
            Prestamo prestamo) {

        prestamo.setFechaPrestamo(
                dto.getFechaPrestamo());

        prestamo.setFechaDevolucionProgramada(
                dto.getFechaDevolucionProgramada());

        prestamo.setObservaciones(
                dto.getObservaciones());

    }

}