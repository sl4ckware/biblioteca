package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa un tipo de usuario utilizado por el
 * Dataset Generator.
 *
 * <p>
 * Esta clase constituye un <strong>Mirror Model</strong> de la
 * entidad {@code TipoUsuario} del backend.
 * </p>
 *
 * <p>
 * Su única responsabilidad consiste en representar la información
 * necesaria para generar registros de la tabla
 * {@code tipo_usuario}, sin depender de Spring Boot,
 * JPA o Jakarta Persistence.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class TipoUsuarioData extends AbstractData {

    /**
     * Nombre del tipo de usuario.
     */
    private String nombre;

    /**
     * Descripción del tipo de usuario.
     */
    private String descripcion;

    /**
     * Constructor vacío.
     */
    public TipoUsuarioData() {
    }

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
     * Obtiene la descripción.
     *
     * @return Descripción.
     */
    public String getDescripcion() {

        return descripcion;

    }

    /**
     * Establece la descripción.
     *
     * @param descripcion Descripción.
     */
    public void setDescripcion(
            String descripcion) {

        this.descripcion = descripcion;

    }

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información del tipo de usuario.
     */
    @Override
    public String toString() {

        return "TipoUsuarioData{"
                + "sequence=" + getSequence()
                + ", nombre='" + nombre + '\''
                + ", descripcion='" + descripcion + '\''
                + ", activo=" + getActivo()
                + '}';

    }

}