package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * DTO utilizado para actualizar un préstamo.
 *
 * No permite modificar el usuario
 * ni el ejemplar asociado.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class PrestamoUpdateDTO {

    /**
     * Fecha programada de devolución.
     */
    private LocalDate fechaDevolucionProgramada;

    /**
     * Observaciones.
     */
    @Size(max = 500)
    private String observaciones;


    public PrestamoUpdateDTO() {
    }

    public LocalDate getFechaDevolucionProgramada() {
        return fechaDevolucionProgramada;
    }

    public void setFechaDevolucionProgramada(
            LocalDate fechaDevolucionProgramada) {

        this.fechaDevolucionProgramada =
                fechaDevolucionProgramada;

    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }


}