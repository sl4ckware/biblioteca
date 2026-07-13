package mx.edu.itvo.biblioteca.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar
 * una nueva multa.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class MultaRequestDTO {

    /**
     * Identificador del préstamo.
     */
    @NotNull(message = "El préstamo es obligatorio.")
    private Integer idPrestamo;

    /**
     * Importe de la multa.
     */
    @NotNull(message = "El monto es obligatorio.")
    @DecimalMin(value = "0.00",
            message = "El monto debe ser mayor o igual a cero.")
    private BigDecimal monto;

    /**
     * Tipo de multa.
     */
    @NotNull(message = "El tipo es obligatorio.")
    @Size(max = 30)
    private String tipo;

    /**
     * Estado de la multa.
     */
    @NotNull(message = "El estado es obligatorio.")
    @Size(max = 20)
    private String estado;

    /**
     * Fecha de generación.
     */
    @NotNull(message = "La fecha de generación es obligatoria.")
    private LocalDate fechaGeneracion;

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
    public MultaRequestDTO() {
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}