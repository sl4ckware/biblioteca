package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

/**
 * DTO para actualizar una reserva.
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public class ReservaUpdateDTO {

    /**
     * Fecha límite.
     */
    private LocalDate fechaLimite;

    /**
     * Observaciones.
     */
    @Size(
            max = 255,
            message = "Las observaciones no pueden exceder 255 caracteres.")
    private String observaciones;

    public ReservaUpdateDTO() {

    }

    public LocalDate getFechaLimite() {

        return fechaLimite;

    }

    public void setFechaLimite(
            LocalDate fechaLimite) {

        this.fechaLimite =
                fechaLimite;

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