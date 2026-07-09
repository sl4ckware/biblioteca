package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un préstamo dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena la información de los préstamos realizados
 * a los usuarios del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "prestamo")
public class Prestamo {

    /**
     * Identificador único del préstamo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRESTAMO")
    private Integer idPrestamo;

    /**
     * Usuario que realiza el préstamo.
     */
    @NotNull(message = "El usuario es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    /**
     * Ejemplar prestado.
     */
    @NotNull(message = "El ejemplar es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EJEMPLAR", nullable = false)
    private Ejemplar ejemplar;

    /**
     * Estado del préstamo.
     */
    @NotNull(message = "El estado del préstamo es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO_PRESTAMO", nullable = false)
    private EstadoPrestamo estadoPrestamo;

    /**
     * Fecha en que se realiza el préstamo.
     */
    @NotNull(message = "La fecha del préstamo es obligatoria.")
    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private LocalDate fechaPrestamo;

    /**
     * Fecha límite para la devolución.
     */
    @NotNull(message = "La fecha límite es obligatoria.")
    @Column(name = "FECHA_LIMITE", nullable = false)
    private LocalDate fechaLimite;

    /**
     * Fecha en que se devuelve el ejemplar.
     */
    @Column(name = "FECHA_DEVOLUCION")
    private LocalDate fechaDevolucion;

    /**
     * Observaciones del préstamo.
     */
    @Size(max = 255,
            message = "Las observaciones no pueden exceder los 255 caracteres.")
    @Column(name = "OBSERVACIONES", length = 255)
    private String observaciones;

    /**
     * Estado lógico del registro.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación del registro.
     */
    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de última actualización del registro.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Prestamo() {
    }

    /**
     * Constructor principal.
     *
     * @param usuario Usuario.
     * @param ejemplar Ejemplar.
     * @param estadoPrestamo Estado del préstamo.
     * @param fechaPrestamo Fecha del préstamo.
     * @param fechaLimite Fecha límite.
     * @param fechaDevolucion Fecha de devolución.
     * @param observaciones Observaciones.
     * @param activo Estado lógico.
     */
    public Prestamo(Usuario usuario,
                    Ejemplar ejemplar,
                    EstadoPrestamo estadoPrestamo,
                    LocalDate fechaPrestamo,
                    LocalDate fechaLimite,
                    LocalDate fechaDevolucion,
                    String observaciones,
                    Boolean activo) {

        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.estadoPrestamo = estadoPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = fechaDevolucion;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaLimite=" + fechaLimite +
                ", fechaDevolucion=" + fechaDevolucion +
                ", activo=" + activo +
                '}';
    }

}