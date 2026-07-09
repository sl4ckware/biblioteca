package mx.edu.itvo.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la entidad Categoria.
 *
 * Se utiliza para transportar la información de una categoría
 * entre el cliente y la API sin exponer la entidad JPA.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class CategoriaDTO {

    /**
     * Identificador único de la categoría.
     */
    private Integer idCategoria;

    /**
     * Código de la categoría.
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
     * Estado de la categoría.
     */
    private Boolean activo;

    /**
     * Constructor vacío.
     */
    public CategoriaDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param idCategoria Identificador.
     * @param codigo Código.
     * @param nombre Nombre.
     * @param descripcion Descripción.
     * @param activo Estado.
     */
    public CategoriaDTO(Integer idCategoria,
                        String codigo,
                        String nombre,
                        String descripcion,
                        Boolean activo) {

        this.idCategoria = idCategoria;
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

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "idCategoria=" + idCategoria +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                '}';
    }

}