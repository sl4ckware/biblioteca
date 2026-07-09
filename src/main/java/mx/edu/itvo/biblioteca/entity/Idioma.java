package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa un idioma dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena los idiomas en los que pueden estar
 * publicados los libros registrados en el sistema.
 *
 * @author Conce
 * @version 1.1
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
     * Constructor vacío requerido por JPA.
     */
    public Idioma() {
    }

    /**
     * Constructor para crear un idioma sin especificar el identificador.
     *
     * @param nombre Nombre del idioma.
     * @param codigoIso Código ISO del idioma.
     * @param activo Estado del idioma.
     */
    public Idioma(String nombre, String codigoIso, Boolean activo) {
        this.nombre = nombre;
        this.codigoIso = codigoIso;
        this.activo = activo;
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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