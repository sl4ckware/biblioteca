package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar y actualizar ejemplares.
 *
 * Contiene la información recibida desde la API para la creación
 * y actualización de ejemplares.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class EjemplarRequestDTO {

    /**
     * Código único de inventario.
     */
    @NotBlank(message = "El código de inventario es obligatorio.")
    @Size(min = 3, max = 50,
            message = "El código de inventario debe contener entre 3 y 50 caracteres.")
    private String codigoInventario;

    /**
     * Identificador del libro.
     */
    @NotNull(message = "El libro es obligatorio.")
    private Integer idLibro;

    /**
     * Identificador del estado del ejemplar.
     */
    @NotNull(message = "El estado del ejemplar es obligatorio.")
    private Integer idEstadoEjemplar;

    /**
     * Ubicación física.
     */
    @Size(max = 100,
            message = "La ubicación no puede exceder los 100 caracteres.")
    private String ubicacion;

    /**
     * Fecha de alta.
     */
    @NotNull(message = "La fecha de alta es obligatoria.")
    private LocalDate fechaAlta;

    /**
     * Observaciones.
     */
    @Size(max = 255,
            message = "Las observaciones no pueden exceder los 255 caracteres.")
    private String observaciones;

    /**
     * Constructor vacío.
     */
    public EjemplarRequestDTO() {
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

    public Integer getIdEstadoEjemplar() {
        return idEstadoEjemplar;
    }

    public void setIdEstadoEjemplar(Integer idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
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

}