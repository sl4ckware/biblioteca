package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para actualizar
 * la información editable de una multa.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class MultaUpdateDTO {

    /**
     * Estado de la multa.
     */
    @Size(max = 20)
    private String estado;

    /**
     * Fecha de pago.
     */
    private LocalDate fechaPago;

    /**
     * Observaciones.
     */
    @Size(max = 255)
    private String observaciones;

    /**
     * Constructor vacío.
     */
    public MultaUpdateDTO() {
    }

    /**
     * Obtiene el estado.
     *
     * @return Estado.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado.
     *
     * @param estado Estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de pago.
     *
     * @return Fecha de pago.
     */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    /**
     * Establece la fecha de pago.
     *
     * @param fechaPago Fecha de pago.
     */
    public void setFechaPago(
            LocalDate fechaPago) {

        this.fechaPago = fechaPago;

    }

    /**
     * Obtiene las observaciones.
     *
     * @return Observaciones.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones.
     *
     * @param observaciones Observaciones.
     */
    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }

}