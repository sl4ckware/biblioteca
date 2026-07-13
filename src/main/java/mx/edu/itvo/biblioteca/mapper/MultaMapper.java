package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Multa;

/**
 * Clase utilitaria para convertir
 * entre entidades y DTO del módulo
 * de multas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public final class MultaMapper {

    /**
     * Constructor privado.
     */
    private MultaMapper() {
    }

    /**
     * Convierte un RequestDTO
     * en una entidad.
     *
     * @param dto DTO de entrada.
     * @return Entidad.
     */
    public static Multa toEntity(
            MultaRequestDTO dto) {

        if (dto == null) {
            return null;
        }

        Multa multa = new Multa();

        multa.setMonto(
                dto.getMonto());

        multa.setTipo(
                dto.getTipo());

        multa.setEstado(
                dto.getEstado());

        multa.setFechaGeneracion(
                dto.getFechaGeneracion());

        multa.setFechaPago(
                dto.getFechaPago());

        multa.setObservaciones(
                dto.getObservaciones());

        return multa;

    }

    /**
     * Convierte una entidad
     * en ResponseDTO.
     *
     * @param multa Entidad.
     * @return DTO.
     */
    public static MultaResponseDTO toResponse(
            Multa multa) {

        if (multa == null) {
            return null;
        }

        MultaResponseDTO dto =
                new MultaResponseDTO();

        dto.setIdMulta(
                multa.getIdMulta());

        dto.setFolio(
                multa.getFolio());

        if (multa.getPrestamo() != null) {

            dto.setIdPrestamo(
                    multa.getPrestamo().getIdPrestamo());

            dto.setFolioPrestamo(
                    multa.getPrestamo().getFolio());

        }

        dto.setMonto(
                multa.getMonto());

        dto.setTipo(
                multa.getTipo());

        dto.setEstado(
                multa.getEstado());

        dto.setFechaGeneracion(
                multa.getFechaGeneracion());

        dto.setFechaPago(
                multa.getFechaPago());

        dto.setObservaciones(
                multa.getObservaciones());

        dto.setActivo(
                multa.getActivo());

        dto.setFechaCreacion(
                multa.getFechaCreacion());

        dto.setFechaActualizacion(
                multa.getFechaActualizacion());

        return dto;

    }

    /**
     * Convierte una lista
     * de entidades.
     *
     * @param multas Lista.
     * @return Lista DTO.
     */
    public static List<MultaResponseDTO> toResponseList(
            List<Multa> multas) {

        return multas.stream()
                .map(MultaMapper::toResponse)
                .collect(Collectors.toList());

    }

    /**
     * Actualiza únicamente
     * los campos editables.
     *
     * @param dto DTO.
     * @param multa Entidad.
     */
    public static void updateEntity(
            MultaUpdateDTO dto,
            Multa multa) {

        multa.setEstado(
                dto.getEstado());

        multa.setFechaPago(
                dto.getFechaPago());

        multa.setObservaciones(
                dto.getObservaciones());

    }

}