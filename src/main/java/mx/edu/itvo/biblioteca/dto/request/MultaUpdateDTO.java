package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * DTO utilizado para actualizar
 * la información editable de una multa.
 * ============================================================
 *
 * <p>
 * Este DTO contiene únicamente los datos
 * que pueden modificarse después del
 * registro de una multa.
 * </p>
 *
 * <p>
 * No permite modificar información de
 * identificación ni datos generados por
 * las reglas de negocio del sistema.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 19
 */
public class MultaUpdateDTO {

    /**
     * Estado de la multa.
     */
    @Size(
            max = 20,
            message = "El estado no debe superar los 20 caracteres.")
    private String estado;

    /**
     * Fecha de pago.
     */
    private LocalDate fechaPago;

    /**
     * Observaciones.
     */
    @Size(
            max = 255,
            message = "Las observaciones no deben superar los 255 caracteres.")
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
    public void setEstado(
            String estado) {

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

    /**
     * Devuelve una representación textual
     * del DTO.
     *
     * @return Cadena representativa.
     */
    @Override
    public String toString() {

        return "MultaUpdateDTO{"
                + "estado='" + estado + '\''
                + ", fechaPago=" + fechaPago
                + ", observaciones='" + observaciones + '\''
                + '}';

    }

}