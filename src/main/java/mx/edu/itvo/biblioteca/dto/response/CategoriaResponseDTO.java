package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO utilizado para enviar la información de una categoría
 * desde la API hacia el cliente.
 *
 * Contiene únicamente los datos que la aplicación necesita
 * mostrar, evitando exponer directamente la entidad JPA.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class CategoriaResponseDTO {

    /**
     * Identificador único de la categoría.
     */
    private Integer idCategoria;

    /**
     * Código de la categoría.
     */
    private String codigo;

    /**
     * Nombre de la categoría.
     */
    private String nombre;

    /**
     * Descripción de la categoría.
     */
    private String descripcion;

    /**
     * Estado lógico del registro.
     */
    private Boolean activo;

    /**
     * Fecha de creación del registro.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de la última actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public CategoriaResponseDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param idCategoria Identificador.
     * @param codigo Código.
     * @param nombre Nombre.
     * @param descripcion Descripción.
     * @param activo Estado.
     * @param fechaCreacion Fecha de creación.
     * @param fechaActualizacion Fecha de actualización.
     */
    public CategoriaResponseDTO(
            Integer idCategoria,
            String codigo,
            String nombre,
            String descripcion,
            Boolean activo,
            LocalDateTime fechaCreacion,
            LocalDateTime fechaActualizacion) {

        this.idCategoria = idCategoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
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

    @Override
    public String toString() {
        return "CategoriaResponseDTO{" +
                "idCategoria=" + idCategoria +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }

}