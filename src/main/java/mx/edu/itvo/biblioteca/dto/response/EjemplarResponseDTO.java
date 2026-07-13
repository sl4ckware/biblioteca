package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver información de un ejemplar.
 *
 * Contiene la información expuesta por la API REST hacia
 * los clientes del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class EjemplarResponseDTO {

    /**
     * Identificador del ejemplar.
     */
    private Integer idEjemplar;

    /**
     * Código de inventario.
     */
    private String codigoInventario;

    /**
     * Identificador del libro.
     */
    private Integer idLibro;

    /**
     * ISBN del libro.
     */
    private String isbn13;

    /**
     * Título del libro.
     */
    private String tituloLibro;

    /**
     * Identificador del estado del ejemplar.
     */
    private Integer idEstadoEjemplar;

    /**
     * Nombre del estado del ejemplar.
     */
    private String estadoEjemplar;

    /**
     * Ubicación física.
     */
    private String ubicacion;

    /**
     * Fecha de alta.
     */
    private LocalDate fechaAlta;

    /**
     * Observaciones.
     */
    private String observaciones;

    /**
     * Estado lógico.
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
    public EjemplarResponseDTO() {
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

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Integer getIdEstadoEjemplar() {
        return idEstadoEjemplar;
    }

    public void setIdEstadoEjemplar(Integer idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
    }

    public String getEstadoEjemplar() {
        return estadoEjemplar;
    }

    public void setEstadoEjemplar(String estadoEjemplar) {
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