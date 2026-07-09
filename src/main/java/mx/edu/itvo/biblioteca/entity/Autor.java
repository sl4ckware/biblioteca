package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Representa un autor dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena la información de los autores
 * de los libros registrados en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "autor")
public class Autor {

    /**
     * Identificador único del autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUTOR")
    private Integer idAutor;

    /**
     * Nombre(s) del autor.
     */
    @NotBlank(message = "El nombre del autor es obligatorio.")
    @Size(min = 2, max = 100,
            message = "El nombre debe contener entre 2 y 100 caracteres.")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    /**
     * Apellido paterno del autor.
     */
    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(min = 2, max = 100,
            message = "El apellido paterno debe contener entre 2 y 100 caracteres.")
    @Column(name = "APELLIDO_PATERNO", nullable = false, length = 100)
    private String apellidoPaterno;

    /**
     * Apellido materno del autor.
     */
    @Size(max = 100,
            message = "El apellido materno no puede exceder los 100 caracteres.")
    @Column(name = "APELLIDO_MATERNO", length = 100)
    private String apellidoMaterno;

    /**
     * Nacionalidad del autor.
     */
    @Size(max = 100,
            message = "La nacionalidad no puede exceder los 100 caracteres.")
    @Column(name = "NACIONALIDAD", length = 100)
    private String nacionalidad;

    /**
     * Estado del autor.
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
    public Autor() {
    }

    /**
     * Constructor para crear un autor.
     *
     * @param nombre Nombre del autor.
     * @param apellidoPaterno Apellido paterno.
     * @param apellidoMaterno Apellido materno.
     * @param nacionalidad Nacionalidad.
     * @param activo Estado del autor.
     */
    public Autor(String nombre,
                 String apellidoPaterno,
                 String apellidoMaterno,
                 String nacionalidad,
                 Boolean activo) {

        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nacionalidad = nacionalidad;
        this.activo = activo;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
     * Devuelve una representación en texto del objeto Autor.
     *
     * @return Información del autor.
     */
    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", activo=" + activo +
                '}';
    }

}