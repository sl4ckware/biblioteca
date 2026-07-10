package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * Representa un idioma dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena los idiomas en los que pueden estar
 * publicados los libros registrados en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "idioma")
public class Idioma {

    /**
     * Identificador único del idioma.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IDIOMA")
    private Integer idIdioma;

    /**
     * Nombre del idioma.
     */
    @NotBlank(message = "El nombre del idioma es obligatorio.")
    @Size(min = 2, max = 100,
            message = "El nombre debe contener entre 2 y 100 caracteres.")
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 100)
    private String nombre;

    /**
     * Código ISO del idioma.
     */
    @NotBlank(message = "El código ISO es obligatorio.")
    @Size(min = 2, max = 10,
            message = "El código ISO debe contener entre 2 y 10 caracteres.")
    @Column(name = "CODIGO_ISO", nullable = false, unique = true, length = 10)
    private String codigoIso;

    /**
     * Estado del idioma.
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
    public Idioma() {
    }

    /**
     * Constructor para crear un idioma.
     *
     * @param nombre Nombre del idioma.
     * @param codigoIso Código ISO.
     * @param activo Estado del idioma.
     */
    public Idioma(String nombre,
                  String codigoIso,
                  Boolean activo) {

        this.nombre = nombre;
        this.codigoIso = codigoIso;
        this.activo = activo;

    }

    /**
     * Obtiene el identificador del idioma.
     *
     * @return Identificador.
     */
    public Integer getIdIdioma() {
        return idIdioma;
    }

    /**
     * Establece el identificador del idioma.
     *
     * @param idIdioma Identificador.
     */
    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    /**
     * Obtiene el nombre del idioma.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del idioma.
     *
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código ISO.
     *
     * @return Código ISO.
     */
    public String getCodigoIso() {
        return codigoIso;
    }

    /**
     * Establece el código ISO.
     *
     * @param codigoIso Código ISO.
     */
    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    /**
     * Obtiene el estado del idioma.
     *
     * @return Estado.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado del idioma.
     *
     * @param activo Estado.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return Fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación.
     *
     * @param fechaCreacion Fecha de creación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene la fecha de última actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de última actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * Devuelve una representación en texto del objeto Idioma.
     *
     * @return Información del idioma.
     */
    @Override
    public String toString() {

        return "Idioma{" +
                "idIdioma=" + idIdioma +
                ", nombre='" + nombre + '\'' +
                ", codigoIso='" + codigoIso + '\'' +
                ", activo=" + activo +
                '}';

    }

}