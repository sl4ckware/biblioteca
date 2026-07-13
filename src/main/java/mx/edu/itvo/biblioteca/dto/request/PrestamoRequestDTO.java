package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar un préstamo.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class PrestamoRequestDTO {

    /**
     * Usuario que realiza el préstamo.
     */
    @NotNull(message = "El usuario es obligatorio.")
    private Integer idUsuario;

    /**
     * Ejemplar solicitado.
     */
    @NotNull(message = "El ejemplar es obligatorio.")
    private Integer idEjemplar;

    /**
     * Fecha del préstamo.
     */
    @NotNull(message = "La fecha del préstamo es obligatoria.")
    private LocalDate fechaPrestamo;

    /**
     * Fecha programada de devolución.
     */
    @NotNull(message = "La fecha de devolución es obligatoria.")
    private LocalDate fechaDevolucionProgramada;

    /**
     * Observaciones.
     */
    @Size(max = 255)
    private String observaciones;

    public PrestamoRequestDTO() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucionProgramada() {
        return fechaDevolucionProgramada;
    }

    public void setFechaDevolucionProgramada(
            LocalDate fechaDevolucionProgramada) {

        this.fechaDevolucionProgramada = fechaDevolucionProgramada;

    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}