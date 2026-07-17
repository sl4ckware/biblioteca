package mx.edu.itvo.biblioteca.dataset.model;

import java.time.LocalDate;

/**
 * Modelo de datos para la entidad Autor.
 *
 * <p>
 * Representa la información utilizada por el Dataset Generator para
 * generar registros de la tabla {@code autor}.
 * </p>
 *
 * <p>
 * Hereda de {@link AbstractData} para reutilizar los campos comunes
 * del Dataset.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class AutorData extends AbstractData {

    /**
     * Nombre del autor.
     */
    private String nombre;

    /**
     * Apellido paterno.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno.
     */
    private String apellidoMaterno;

    /**
     * Nacionalidad.
     */
    private String nacionalidad;

    /**
     * Fecha de nacimiento.
     */
    private LocalDate fechaNacimiento;

    /**
     * Obtiene el nombre.
     *
     * @return Nombre.
     */
    public String getNombre() {

        return nombre;

    }

    /**
     * Establece el nombre.
     *
     * @param nombre Nombre.
     */
    public void setNombre(
            String nombre) {

        this.nombre = nombre;

    }

    /**
     * Obtiene el apellido paterno.
     *
     * @return Apellido paterno.
     */
    public String getApellidoPaterno() {

        return apellidoPaterno;

    }

    /**
     * Establece el apellido paterno.
     *
     * @param apellidoPaterno Apellido paterno.
     */
    public void setApellidoPaterno(
            String apellidoPaterno) {

        this.apellidoPaterno = apellidoPaterno;

    }

    /**
     * Obtiene el apellido materno.
     *
     * @return Apellido materno.
     */
    public String getApellidoMaterno() {

        return apellidoMaterno;

    }

    /**
     * Establece el apellido materno.
     *
     * @param apellidoMaterno Apellido materno.
     */
    public void setApellidoMaterno(
            String apellidoMaterno) {

        this.apellidoMaterno = apellidoMaterno;

    }

    /**
     * Obtiene la nacionalidad.
     *
     * @return Nacionalidad.
     */
    public String getNacionalidad() {

        return nacionalidad;

    }

    /**
     * Establece la nacionalidad.
     *
     * @param nacionalidad Nacionalidad.
     */
    public void setNacionalidad(
            String nacionalidad) {

        this.nacionalidad = nacionalidad;

    }

    /**
     * Obtiene la fecha de nacimiento.
     *
     * @return Fecha de nacimiento.
     */
    public LocalDate getFechaNacimiento() {

        return fechaNacimiento;

    }

    /**
     * Establece la fecha de nacimiento.
     *
     * @param fechaNacimiento Fecha de nacimiento.
     */
    public void setFechaNacimiento(
            LocalDate fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;

    }

}