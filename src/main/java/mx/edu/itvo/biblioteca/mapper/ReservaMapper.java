package mx.edu.itvo.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import mx.edu.itvo.biblioteca.dto.request.ReservaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.ReservaResponseDTO;
import mx.edu.itvo.biblioteca.entity.Libro;
import mx.edu.itvo.biblioteca.entity.Reserva;
import mx.edu.itvo.biblioteca.entity.Usuario;

/**
 * Mapper de la entidad Reserva.
 *
 * <p>
 * Convierte entre la entidad Reserva
 * y los DTO utilizados por la API.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public final class ReservaMapper {

    /**
     * Constructor privado.
     */
    private ReservaMapper() {

    }

    /**
     * Convierte un RequestDTO
     * en entidad.
     *
     * @param request DTO recibido.
     * @return Reserva.
     */
    public static Reserva toEntity(
            ReservaRequestDTO request) {

        Reserva reserva =
                new Reserva();

        Usuario usuario =
                new Usuario();

        usuario.setIdUsuario(
                request.getIdUsuario());

        Libro libro =
                new Libro();

        libro.setIdLibro(
                request.getIdLibro());

        Usuario bibliotecario =
                new Usuario();

        bibliotecario.setIdUsuario(
                request.getIdBibliotecario());

        reserva.setUsuario(
                usuario);

        reserva.setLibro(
                libro);

        reserva.setBibliotecario(
                bibliotecario);

        reserva.setObservaciones(
                request.getObservaciones());

        return reserva;

    }

    /**
     * Convierte una entidad
     * en ResponseDTO.
     *
     * @param reserva Entidad.
     * @return DTO.
     */
    public static ReservaResponseDTO
            toResponseDTO(
                    Reserva reserva) {

        ReservaResponseDTO response =
                new ReservaResponseDTO();

        response.setIdReserva(
                reserva.getIdReserva());

        response.setFolio(
                reserva.getFolio());

        response.setMatriculaUsuario(
                reserva.getUsuario()
                        .getMatricula());

        response.setNombreUsuario(

                reserva.getUsuario()
                        .getNombre()

                + " "

                + reserva.getUsuario()
                        .getApellidoPaterno()

                + " "

                + reserva.getUsuario()
                        .getApellidoMaterno());

        response.setTituloLibro(

                reserva.getLibro()
                        .getTitulo());

        response.setMatriculaBibliotecario(

                reserva.getBibliotecario()
                        .getMatricula());

        response.setNombreBibliotecario(

                reserva.getBibliotecario()
                        .getNombre()

                + " "

                + reserva.getBibliotecario()
                        .getApellidoPaterno()

                + " "

                + reserva.getBibliotecario()
                        .getApellidoMaterno());

        response.setFechaReserva(
                reserva.getFechaReserva());

        response.setFechaLimite(
                reserva.getFechaLimite());

        response.setFechaAtencion(
                reserva.getFechaAtencion());

        response.setEstado(

                reserva.getEstadoReserva()
                        .getNombre());

        response.setExpirada(
                reserva.estaExpirada());

        response.setAtendida(
                reserva.estaAtendida());

        return response;

    }

    /**
     * Convierte una lista
     * de entidades en DTOs.
     *
     * @param reservas Lista.
     * @return Lista DTO.
     */
    public static List<
            ReservaResponseDTO>
            toResponseList(
                    List<Reserva> reservas) {

        return reservas.stream()
                .map(
                        ReservaMapper::toResponseDTO)
                .collect(
                        Collectors.toList());

    }

}