package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para recibir la información de una categoría
 * desde el cliente hacia la API.
 *
 * Este objeto se utiliza en las operaciones de creación y
 * actualización de categorías.
 *
 * No incluye campos generados por el sistema como:
 * idCategoria, activo, fechaCreacion y fechaActualizacion.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class CategoriaRequestDTO {

    /**
     * Código único de la categoría.
     */
    @NotBlank(message = "El código es obligatorio.")
    @Size(min = 2, max = 20,
            message = "El código debe contener entre 2 y 20 caracteres.")
    private String codigo;

    /**
     * Nombre de la categoría.
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 100,
            message = "El nombre debe contener entre 3 y 100 caracteres.")
    private String nombre;

    /**
     * Descripción de la categoría.
     */
    @Size(max = 255,
            message = "La descripción no puede exceder los 255 caracteres.")
    private String descripcion;

    /**
     * Constructor vacío.
     */
    public CategoriaRequestDTO() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param codigo Código de la categoría.
     * @param nombre Nombre de la categoría.
     * @param descripcion Descripción.
     */
    public CategoriaRequestDTO(String codigo,
                               String nombre,
                               String descripcion) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "CategoriaRequestDTO{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}