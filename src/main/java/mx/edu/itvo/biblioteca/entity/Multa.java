package mx.edu.itvo.biblioteca.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Representa una multa generada
 * por un préstamo.
 *
 * Una multa pertenece a un préstamo
 * y mantiene el historial de cobro.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Entity
@Table(name = "multa")
public class Multa {

    /**
     * Identificador.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MULTA")
    private Integer idMulta;

    /**
     * Folio.
     */
    @NotBlank
    @Size(max = 30)
    @Column(
            name = "FOLIO",
            nullable = false,
            unique = true,
            length = 30)
    private String folio;

    /**
     * Préstamo asociado.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ID_PRESTAMO",
            nullable = false)
    private Prestamo prestamo;

    /**
     * Importe.
     */
    @NotNull
    @DecimalMin("0.00")
    @Column(
            name = "MONTO",
            nullable = false,
            precision = 10,
            scale = 2)
    private BigDecimal monto;

    /**
     * Tipo de multa.
     *
     * ENTREGA_TARDIA
     * DANO
     * PERDIDA
     * OTRO
     */
    @NotBlank
    @Size(max = 30)
    @Column(
            name = "TIPO",
            nullable = false,
            length = 30)
    private String tipo;

    /**
     * Estado de la multa.
     *
     * PENDIENTE
     * PAGADA
     * CANCELADA
     */
    @NotBlank
    @Size(max = 20)
    @Column(
            name = "ESTADO",
            nullable = false,
            length = 20)
    private String estado;

    /**
     * Fecha de generación.
     */
    @NotNull
    @Column(
            name = "FECHA_GENERACION",
            nullable = false)
    private LocalDate fechaGeneracion;

    /**
     * Fecha de pago.
     */
    @Column(name = "FECHA_PAGO")
    private LocalDate fechaPago;

    /**
     * Observaciones.
     */
    @Size(max = 255)
    @Column(
            name = "OBSERVACIONES",
            length = 255)
    private String observaciones;

    /**
     * Estado del registro.
     */
    @NotNull
    @Column(
            name = "ACTIVO",
            nullable = false)
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    @Column(
            name = "FECHA_CREACION",
            updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public Multa() {

        this.activo = Boolean.TRUE;

    }

    /**
     * Constructor completo.
     */
    public Multa(
            String folio,
            Prestamo prestamo,
            BigDecimal monto,
            String tipo,
            String estado,
            LocalDate fechaGeneracion,
            LocalDate fechaPago,
            String observaciones,
            Boolean activo) {

        this.folio = folio;
        this.prestamo = prestamo;
        this.monto = monto;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaPago = fechaPago;
        this.observaciones = observaciones;
        this.activo = activo;

    }

    /**
     * Obtiene el identificador.
     *
     * @return Identificador.
     */
    public Integer getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(Integer idMulta) {
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

    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el préstamo.
     *
     * @return Préstamo.
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * Obtiene el monto.
     *
     * @return Monto.
     */
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el tipo de multa.
     *
     * @return Tipo.
     */
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de generación.
     *
     * @return Fecha.
     */
    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(
            LocalDate fechaGeneracion) {

        this.fechaGeneracion = fechaGeneracion;

    }

    /**
     * Obtiene la fecha de pago.
     *
     * @return Fecha.
     */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

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

    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }

    /**
     * Obtiene el estado del registro.
     *
     * @return Estado.
     */
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return Fecha.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(
            LocalDateTime fechaCreacion) {

        this.fechaCreacion = fechaCreacion;

    }

    /**
     * Obtiene la fecha de actualización.
     *
     * @return Fecha.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion = fechaActualizacion;

    }

    /**
     * Devuelve una representación
     * textual de la multa.
     *
     * @return Cadena representativa.
     */
    @Override
    public String toString() {

        return "Multa{" +
                "idMulta=" + idMulta +
                ", folio='" + folio + '\'' +
                ", monto=" + monto +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                ", fechaPago=" + fechaPago +
                ", activo=" + activo +
                '}';

    }

}