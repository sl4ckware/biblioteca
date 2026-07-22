package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO para registrar una reserva.
 *
 * <p>
 * Contiene la información necesaria
 * para crear una nueva reserva.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public class ReservaRequestDTO {

    /**
     * Usuario que realiza la reserva.
     */
    @NotNull(
            message = "El usuario es obligatorio.")
    private Integer idUsuario;

    /**
     * Libro que será reservado.
     */
    @NotNull(
            message = "El libro es obligatorio.")
    private Integer idLibro;

    /**
     * Bibliotecario que registra
     * la reserva.
     */
    @NotNull(
            message = "El bibliotecario es obligatorio.")
    private Integer idBibliotecario;

    /**
     * Observaciones.
     */
    @Size(
            max = 255,
            message = "Las observaciones no pueden exceder 255 caracteres.")
    private String observaciones;

    public ReservaRequestDTO() {

    }

    public Integer getIdUsuario() {

        return idUsuario;

    }

    public void setIdUsuario(
            Integer idUsuario) {

        this.idUsuario =
                idUsuario;

    }

    public Integer getIdLibro() {

        return idLibro;

    }

    public void setIdLibro(
            Integer idLibro) {

        this.idLibro =
                idLibro;

    }

    public Integer getIdBibliotecario() {

        return idBibliotecario;

    }

    public void setIdBibliotecario(
            Integer idBibliotecario) {

        this.idBibliotecario =
                idBibliotecario;

    }

    public String getObservaciones() {

        return observaciones;

    }

    public void setObservaciones(
            String observaciones) {

        this.observaciones =
                observaciones;

    }

}