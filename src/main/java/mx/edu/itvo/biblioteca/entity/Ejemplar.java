package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un ejemplar físico de un libro dentro del sistema
 * de gestión de biblioteca.
 *
 * Cada ejemplar corresponde a una copia física de un libro y
 * posee un código de inventario único.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "ejemplar")
public class Ejemplar {

    /**
     * Identificador único del ejemplar.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EJEMPLAR")
    private Integer idEjemplar;

    /**
     * Código único de inventario.
     */
    @NotBlank(message = "El código de inventario es obligatorio.")
    @Size(min = 3, max = 50,
            message = "El código de inventario debe contener entre 3 y 50 caracteres.")
    @Column(name = "CODIGO_INVENTARIO", nullable = false, unique = true, length = 50)
    private String codigoInventario;

    /**
     * Libro al que pertenece el ejemplar.
     */
    @NotNull(message = "El libro es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LIBRO", nullable = false)
    private Libro libro;

    /**
     * Estado actual del ejemplar.
     */
    @NotNull(message = "El estado del ejemplar es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO_EJEMPLAR", nullable = false)
    private EstadoEjemplar estadoEjemplar;

    /**
     * Ubicación física del ejemplar.
     */
    @Size(max = 100)
    @Column(name = "UBICACION", length = 100)
    private String ubicacion;

    /**
     * Fecha de alta del ejemplar.
     */
    @NotNull(message = "La fecha de alta es obligatoria.")
    @Column(name = "FECHA_ALTA", nullable = false)
    private LocalDate fechaAlta;

    /**
     * Observaciones del ejemplar.
     */
    @Size(max = 255)
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
     * Fecha de última actualización.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Ejemplar() {
    }

    /**
     * Constructor principal.
     *
     * @param codigoInventario Código de inventario.
     * @param libro Libro asociado.
     * @param estadoEjemplar Estado del ejemplar.
     * @param ubicacion Ubicación física.
     * @param fechaAlta Fecha de alta.
     * @param observaciones Observaciones.
     * @param activo Estado lógico.
     */
    public Ejemplar(String codigoInventario,
                     Libro libro,
                     EstadoEjemplar estadoEjemplar,
                     String ubicacion,
                     LocalDate fechaAlta,
                     String observaciones,
                     Boolean activo) {

        this.codigoInventario = codigoInventario;
        this.libro = libro;
        this.estadoEjemplar = estadoEjemplar;
        this.ubicacion = ubicacion;
        this.fechaAlta = fechaAlta;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoEjemplar getEstadoEjemplar() {
        return estadoEjemplar;
    }

    public void setEstadoEjemplar(EstadoEjemplar estadoEjemplar) {
        this.estadoEjemplar = estadoEjemplar;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
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
        return "Ejemplar{" +
                "idEjemplar=" + idEjemplar +
                ", codigoInventario='" + codigoInventario + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", activo=" + activo +
                '}';
    }

}