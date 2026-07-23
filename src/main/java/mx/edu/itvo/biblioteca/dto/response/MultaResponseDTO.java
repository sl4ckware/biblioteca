package mx.edu.itvo.biblioteca.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * DTO utilizado para devolver
 * la información de una multa.
 * ============================================================
 *
 * <p>
 * Representa la información que el sistema
 * envía al cliente sobre una multa registrada.
 * </p>
 *
 * <p>
 * Contiene datos de identificación,
 * préstamo asociado, estado, auditoría
 * y demás información requerida para
 * consultas y reportes.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 19
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

    /**
     * Obtiene el identificador.
     *
     * @return Identificador.
     */
    public Integer getIdMulta() {

        return idMulta;

    }

    /**
     * Establece el identificador.
     *
     * @param idMulta Identificador.
     */
    public void setIdMulta(
            Integer idMulta) {

        this.idMulta = idMulta;

    }

    /**
     * Obtiene el folio.
     *
     * @return Folio.
     */
    public String getFolio() {

        return folio;

    }

    /**
     * Establece el folio.
     *
     * @param folio Folio.
     */
    public void setFolio(
            String folio) {

        this.folio = folio;

    }

    /**
     * Obtiene el identificador
     * del préstamo.
     *
     * @return Identificador.
     */
    public Integer getIdPrestamo() {

        return idPrestamo;

    }

    /**
     * Establece el identificador
     * del préstamo.
     *
     * @param idPrestamo Identificador.
     */
    public void setIdPrestamo(
            Integer idPrestamo) {

        this.idPrestamo = idPrestamo;

    }

    /**
     * Obtiene el folio
     * del préstamo.
     *
     * @return Folio.
     */
    public String getFolioPrestamo() {

        return folioPrestamo;

    }

    /**
     * Establece el folio
     * del préstamo.
     *
     * @param folioPrestamo Folio.
     */
    public void setFolioPrestamo(
            String folioPrestamo) {

        this.folioPrestamo = folioPrestamo;

    }

    /**
     * Obtiene el monto.
     *
     * @return Monto.
     */
    public BigDecimal getMonto() {

        return monto;

    }

    /**
     * Establece el monto.
     *
     * @param monto Monto.
     */
    public void setMonto(
            BigDecimal monto) {

        this.monto = monto;

    }

    /**
     * Obtiene el tipo.
     *
     * @return Tipo.
     */
    public String getTipo() {

        return tipo;

    }

    /**
     * Establece el tipo.
     *
     * @param tipo Tipo.
     */
    public void setTipo(
            String tipo) {

        this.tipo = tipo;

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
     * Obtiene la fecha de generación.
     *
     * @return Fecha de generación.
     */
    public LocalDate getFechaGeneracion() {

        return fechaGeneracion;

    }

    /**
     * Establece la fecha de generación.
     *
     * @param fechaGeneracion Fecha de generación.
     */
    public void setFechaGeneracion(
            LocalDate fechaGeneracion) {

        this.fechaGeneracion = fechaGeneracion;

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
     * Indica si el registro
     * está activo.
     *
     * @return Estado del registro.
     */
    public Boolean getActivo() {

        return activo;

    }

    /**
     * Establece el estado
     * del registro.
     *
     * @param activo Estado.
     */
    public void setActivo(
            Boolean activo) {

        this.activo = activo;

    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return Fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {

        return fechaCreacion;

    }

    /**
     * Establece la fecha de creación.
     *
     * @param fechaCreacion Fecha de creación.
     */
    public void setFechaCreacion(
            LocalDateTime fechaCreacion) {

        this.fechaCreacion = fechaCreacion;

    }

    /**
     * Obtiene la fecha de actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {

        return fechaActualizacion;

    }

    /**
     * Establece la fecha de actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion = fechaActualizacion;

    }

    /**
     * Devuelve una representación textual
     * del DTO.
     *
     * @return Cadena representativa.
     */
    @Override
    public String toString() {

        return "MultaResponseDTO{"
                + "idMulta=" + idMulta
                + ", folio='" + folio + '\''
                + ", idPrestamo=" + idPrestamo
                + ", folioPrestamo='" + folioPrestamo + '\''
                + ", monto=" + monto
                + ", tipo='" + tipo + '\''
                + ", estado='" + estado + '\''
                + ", fechaGeneracion=" + fechaGeneracion
                + ", fechaPago=" + fechaPago
                + ", observaciones='" + observaciones + '\''
                + ", activo=" + activo
                + ", fechaCreacion=" + fechaCreacion
                + ", fechaActualizacion=" + fechaActualizacion
                + '}';

    }

}