package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Representa una editorial dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena la información de las editoriales
 * responsables de la publicación de los libros registrados
 * en el sistema.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
@Entity
@Table(name = "editorial")
public class Editorial {

    /**
     * Identificador único de la editorial.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EDITORIAL")
    private Integer idEditorial;

    /**
     * Nombre de la editorial.
     */
    @NotBlank(message = "El nombre de la editorial es obligatorio.")
    @Size(min = 2, max = 150,
            message = "El nombre debe contener entre 2 y 150 caracteres.")
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 150)
    private String nombre;

    /**
     * País de origen de la editorial.
     */
    @Size(max = 100,
            message = "El país no puede exceder los 100 caracteres.")
    @Column(name = "PAIS", length = 100)
    private String pais;

    /**
     * Ciudad donde se ubica la editorial.
     */
    @Size(max = 100,
            message = "La ciudad no puede exceder los 100 caracteres.")
    @Column(name = "CIUDAD", length = 100)
    private String ciudad;

    /**
     * Teléfono de contacto.
     */
    @Size(max = 20,
            message = "El teléfono no puede exceder los 20 caracteres.")
    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    /**
     * Correo electrónico de contacto.
     */
    @Email(message = "El correo electrónico no es válido.")
    @Size(max = 150,
            message = "El correo no puede exceder los 150 caracteres.")
    @Column(name = "CORREO", length = 150)
    private String correo;

    /**
     * Sitio web oficial.
     */
    @Size(max = 255,
            message = "La URL no puede exceder los 255 caracteres.")
    @Column(name = "SITIO_WEB", length = 255)
    private String sitioWeb;

    /**
     * Estado de la editorial.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación del registro.
     */
    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de última actualización del registro.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Editorial() {
    }

    /**
     * Constructor para crear una editorial sin especificar el identificador.
     *
     * @param nombre Nombre de la editorial.
     * @param pais País.
     * @param ciudad Ciudad.
     * @param telefono Teléfono.
     * @param correo Correo electrónico.
     * @param sitioWeb Sitio web.
     * @param activo Estado de la editorial.
     */
    public Editorial(String nombre, String pais, String ciudad,
                     String telefono, String correo,
                     String sitioWeb, Boolean activo) {

        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.sitioWeb = sitioWeb;
        this.activo = activo;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
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
     * Devuelve una representación en texto del objeto Editorial.
     *
     * @return Información de la editorial.
     */
    @Override
    public String toString() {
        return "Editorial{" +
                "idEditorial=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", sitioWeb='" + sitioWeb + '\'' +
                ", activo=" + activo +
                '}';
    }

}
