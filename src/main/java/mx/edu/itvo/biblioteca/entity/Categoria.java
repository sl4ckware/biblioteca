package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Representa una categoría dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena las categorías o áreas del conocimiento
 * a las que pertenecen los libros registrados en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    /**
     * Identificador único de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;

    /**
     * Código de la categoría.
     */
    @NotBlank(message = "El código de la categoría es obligatorio.")
    @Size(min = 2, max = 20,
            message = "El código debe contener entre 2 y 20 caracteres.")
    @Column(name = "CODIGO", nullable = false, unique = true, length = 20)
    private String codigo;

    /**
     * Nombre de la categoría.
     */
    @NotBlank(message = "El nombre de la categoría es obligatorio.")
    @Size(min = 3, max = 100,
            message = "El nombre debe contener entre 3 y 100 caracteres.")
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 100)
    private String nombre;

    /**
     * Descripción de la categoría.
     */
    @Size(max = 255,
            message = "La descripción no puede exceder los 255 caracteres.")
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;

    /**
     * Estado de la categoría.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación del registro.
     */
    @Column(name = "FECHA_CREACION", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de última actualización del registro.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Categoria() {
    }

    /**
     * Constructor para crear una categoría.
     *
     * @param codigo Código de la categoría.
     * @param nombre Nombre de la categoría.
     * @param descripcion Descripción de la categoría.
     * @param activo Estado de la categoría.
     */
    public Categoria(String codigo, String nombre,
                     String descripcion, Boolean activo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    /**
     * Devuelve una representación en texto del objeto Categoria.
     *
     * @return Información de la categoría.
     */
    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                '}';
    }

}