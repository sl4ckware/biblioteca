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
 * @version 2.1
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
    @Column(name = "CODIGO_INVENTARIO",
            nullable = false,
            unique = true,
            length = 50)
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
     * Fecha de alta.
     */
    @NotNull(message = "La fecha de alta es obligatoria.")
    @Column(name = "FECHA_ALTA", nullable = false)
    private LocalDate fechaAlta;

    /**
     * Observaciones.
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
     * Fecha de creación.
     */
    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
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
    public Ejemplar(
            String codigoInventario,
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
    
    /**
     * Obtiene el identificador del ejemplar.
     *
     * @return Identificador.
     */
    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    /**
     * Establece el identificador del ejemplar.
     *
     * @param idEjemplar Identificador.
     */
    public void setIdEjemplar(Integer idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    /**
     * Obtiene el código de inventario.
     *
     * @return Código de inventario.
     */
    public String getCodigoInventario() {
        return codigoInventario;
    }

    /**
     * Establece el código de inventario.
     *
     * @param codigoInventario Código de inventario.
     */
    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    /**
     * Obtiene el libro asociado.
     *
     * @return Libro.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Establece el libro asociado.
     *
     * @param libro Libro.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Obtiene el estado del ejemplar.
     *
     * @return Estado del ejemplar.
     */
    public EstadoEjemplar getEstadoEjemplar() {
        return estadoEjemplar;
    }

    /**
     * Establece el estado del ejemplar.
     *
     * @param estadoEjemplar Estado del ejemplar.
     */
    public void setEstadoEjemplar(EstadoEjemplar estadoEjemplar) {
        this.estadoEjemplar = estadoEjemplar;
    }

    /**
     * Obtiene la ubicación física.
     *
     * @return Ubicación.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación física.
     *
     * @param ubicacion Ubicación.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene la fecha de alta.
     *
     * @return Fecha de alta.
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta.
     *
     * @param fechaAlta Fecha de alta.
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
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
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene el estado lógico del registro.
     *
     * @return Estado lógico.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado lógico del registro.
     *
     * @param activo Estado lógico.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
        /**
     * Obtiene la fecha de creación del registro.
     *
     * @return Fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del registro.
     *
     * @param fechaCreacion Fecha de creación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene la fecha de última actualización del registro.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de última actualización del registro.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * Devuelve una representación en texto del objeto Ejemplar.
     *
     * @return Información del ejemplar.
     */
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