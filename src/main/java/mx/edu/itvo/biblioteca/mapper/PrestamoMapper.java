package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;
import mx.edu.itvo.biblioteca.entity.Ejemplar;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.entity.Usuario;

/**
 * Mapper de la entidad Prestamo.
 *
 * <p>
 * Convierte entre la entidad Prestamo y los DTO
 * utilizados por la API REST.
 * </p>
 *
 * @author Conce
 * @version 4.0
 * @since Sprint 17
 */
public final class PrestamoMapper {

    /**
     * Constructor privado.
     */
    private PrestamoMapper() {
    }

    /**
     * Convierte un RequestDTO en entidad.
     *
     * @param request DTO recibido.
     * @return Entidad Prestamo.
     */
    public static Prestamo toEntity(
            PrestamoRequestDTO request) {

        Prestamo prestamo =
                new Prestamo();

        Usuario usuario =
                new Usuario();

        usuario.setIdUsuario(
                request.getIdUsuario());

        Ejemplar ejemplar =
                new Ejemplar();

        ejemplar.setIdEjemplar(
                request.getIdEjemplar());

        Usuario bibliotecario =
                new Usuario();

        bibliotecario.setIdUsuario(
                request.getIdBibliotecario());

        prestamo.setUsuario(
                usuario);

        prestamo.setEjemplar(
                ejemplar);

        prestamo.setBibliotecario(
                bibliotecario);

        prestamo.setObservaciones(
                request.getObservaciones());

        return prestamo;

    }

    /**
     * Convierte una entidad en un ResponseDTO.
     *
     * @param prestamo Entidad.
     * @return DTO.
     */
    public static PrestamoResponseDTO toResponseDTO(
            Prestamo prestamo) {

        PrestamoResponseDTO response =
                new PrestamoResponseDTO();

        response.setIdPrestamo(
                prestamo.getIdPrestamo());

        response.setFolio(
                prestamo.getFolio());

        response.setMatriculaUsuario(
                prestamo.getUsuario()
                        .getMatricula());

        response.setNombreUsuario(

                prestamo.getUsuario()
                        .getNombre()

                + " "

                + prestamo.getUsuario()
                        .getApellidoPaterno()

                + " "

                + prestamo.getUsuario()
                        .getApellidoMaterno());

        response.setCodigoEjemplar(

                prestamo.getEjemplar()
                        .getCodigoInventario());

        response.setTituloLibro(

                prestamo.getEjemplar()
                        .getLibro()
                        .getTitulo());

        response.setMatriculaBibliotecario(

                prestamo.getBibliotecario()
                        .getMatricula());

        response.setNombreBibliotecario(

                prestamo.getBibliotecario()
                        .getNombre()

                + " "

                + prestamo.getBibliotecario()
                        .getApellidoPaterno()

                + " "

                + prestamo.getBibliotecario()
                        .getApellidoMaterno());

        response.setFechaPrestamo(
                prestamo.getFechaPrestamo());

        response.setFechaDevolucionProgramada(
                prestamo.getFechaDevolucionProgramada());

        response.setFechaDevolucionReal(
                prestamo.getFechaDevolucionReal());

        response.setEstado(

                prestamo.getEstadoPrestamo()
                        .getNombre());

        response.setDevuelto(
                prestamo.isDevuelto());

        response.setVencido(
                prestamo.estaVencido());

        return response;

    }

    /**
     * Convierte una lista de entidades
     * en una lista de DTOs.
     *
     * @param prestamos Lista de préstamos.
     * @return Lista de DTOs.
     */
    public static List<PrestamoResponseDTO>
            toResponseList(
                    List<Prestamo> prestamos) {

        return prestamos.stream()
                .map(
                        PrestamoMapper::toResponseDTO)
                .collect(
                        Collectors.toList());

    }

}