package mx.edu.itvo.biblioteca.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver
 * la información de una multa.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class MultaResponseDTO {

    /**
     * Identificador.
     */
    private Integer idMulta;

    /**
     * Folio.
     */
    private String folio;

    /**
     * Identificador del préstamo.
     */
    private Integer idPrestamo;

    /**
     * Folio del préstamo.
     */
    private String folioPrestamo;

    /**
     * Monto.
     */
    private BigDecimal monto;

    /**
     * Tipo de multa.
     */
    private String tipo;

    /**
     * Estado.
     */
    private String estado;

    /**
     * Fecha de generación.
     */
    private LocalDate fechaGeneracion;

    /**
     * Fecha de pago.
     */
    private LocalDate fechaPago;

    /**
     * Observaciones.
     */
    private String observaciones;

    /**
     * Estado del registro.
     */
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public MultaResponseDTO() {
    }

    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
        this.idMulta = idMulta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFolioPrestamo() {
        return folioPrestamo;
    }

    public void setFolioPrestamo(String folioPrestamo) {
        this.folioPrestamo = folioPrestamo;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}