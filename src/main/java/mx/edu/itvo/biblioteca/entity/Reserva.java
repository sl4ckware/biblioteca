package mx.edu.itvo.biblioteca.entity;

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

/**
 * Entidad que representa una reserva
 * realizada por un usuario.
 *
 * <p>
 * Una reserva permite apartar un libro
 * cuando actualmente no existen
 * ejemplares disponibles.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    /**
     * Identificador.
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    /**
     * Usuario que realiza la reserva.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_usuario",
            nullable = false)
    private Usuario usuario;

    /**
     * Libro reservado.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_libro",
            nullable = false)
    private Libro libro;

    /**
     * Estado de la reserva.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_estado_reserva",
            nullable = false)
    private EstadoReserva estadoReserva;

    /**
     * Bibliotecario que atendió
     * la reserva.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_bibliotecario",
            nullable = false)
    private Usuario bibliotecario;

    /**
     * Fecha de la reserva.
     */
    @Column(
            name = "fecha_reserva",
            nullable = false)
    private LocalDate fechaReserva;

    /**
     * Fecha límite para recoger
     * el libro.
     */
    @Column(
            name = "fecha_limite")
    private LocalDate fechaLimite;

    /**
     * Fecha en que el usuario
     * recogió el libro.
     */
    @Column(
            name = "fecha_atencion")
    private LocalDate fechaAtencion;

    /**
     * Folio.
     */
    @Column(
            name = "folio",
            nullable = false,
            unique = true,
            length = 20)
    private String folio;

    /**
     * Observaciones.
     */
    @Column(
            name = "observaciones",
            length = 255)
    private String observaciones;

    /**
     * Activo.
     */
    @Column(
            name = "activo",
            nullable = false)
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    @Column(
            name = "fecha_creacion",
            nullable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    @Column(
            name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor.
     */
    public Reserva() {

    }

    public Integer getIdReserva() {

        return idReserva;

    }

    public void setIdReserva(
            Integer idReserva) {

        this.idReserva =
                idReserva;

    }

    public Usuario getUsuario() {

        return usuario;

    }

    public void setUsuario(
            Usuario usuario) {

        this.usuario =
                usuario;

    }

    public Libro getLibro() {

        return libro;

    }

    public void setLibro(
            Libro libro) {

        this.libro =
                libro;

    }

    public EstadoReserva getEstadoReserva() {

        return estadoReserva;

    }

    public void setEstadoReserva(
            EstadoReserva estadoReserva) {

        this.estadoReserva =
                estadoReserva;

    }

    public Usuario getBibliotecario() {

        return bibliotecario;

    }

    public void setBibliotecario(
            Usuario bibliotecario) {

        this.bibliotecario =
                bibliotecario;

    }

    public LocalDate getFechaReserva() {

        return fechaReserva;

    }

    public void setFechaReserva(
            LocalDate fechaReserva) {

        this.fechaReserva =
                fechaReserva;

    }

    public LocalDate getFechaLimite() {

        return fechaLimite;

    }

    public void setFechaLimite(
            LocalDate fechaLimite) {

        this.fechaLimite =
                fechaLimite;

    }

    public LocalDate getFechaAtencion() {

        return fechaAtencion;

    }

    public void setFechaAtencion(
            LocalDate fechaAtencion) {

        this.fechaAtencion =
                fechaAtencion;

    }

    public String getFolio() {

        return folio;

    }

    public void setFolio(
            String folio) {

        this.folio =
                folio;

    }

    public String getObservaciones() {

        return observaciones;

    }

    public void setObservaciones(
            String observaciones) {

        this.observaciones =
                observaciones;

    }

    public Boolean getActivo() {

        return activo;

    }

    public void setActivo(
            Boolean activo) {

        this.activo =
                activo;

    }

    public LocalDateTime getFechaCreacion() {

        return fechaCreacion;

    }

    public void setFechaCreacion(
            LocalDateTime fechaCreacion) {

        this.fechaCreacion =
                fechaCreacion;

    }

    public LocalDateTime getFechaActualizacion() {

        return fechaActualizacion;

    }

    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion =
                fechaActualizacion;

    }

    /**
     * Indica si la reserva
     * ya expiró.
     *
     * @return true si expiró.
     */
    public boolean estaExpirada() {

        return fechaLimite != null
                && fechaLimite.isBefore(
                        LocalDate.now());

    }

    /**
     * Indica si la reserva
     * ya fue atendida.
     *
     * @return true si fue atendida.
     */
    public boolean estaAtendida() {

        return fechaAtencion != null;

    }

}