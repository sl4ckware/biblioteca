package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO (Data Transfer Object) utilizado para la recepción de información
 * correspondiente a un autor desde las solicitudes realizadas por el cliente.
 *
 * <p>
 * Esta clase forma parte de la capa de transferencia de datos (DTO) y tiene
 * como finalidad desacoplar la entidad {@code Autor} de la API REST,
 * evitando exponer directamente el modelo de persistencia.
 * </p>
 *
 * <p>
 * El objeto es utilizado principalmente en las operaciones de:
 * </p>
 * <ul>
 *     <li>Registro de un nuevo autor.</li>
 *     <li>Actualización de la información de un autor existente.</li>
 * </ul>
 *
 * <p>
 * Se incorporan validaciones mediante Jakarta Validation para garantizar
 * la integridad de los datos antes de llegar a la capa de negocio.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 2026
 */
public class AutorRequestDTO {

    /**
     * Nombre(s) del autor.
     *
     * <p>Campo obligatorio.</p>
     *
     * <p>Restricciones:</p>
     * <ul>
     *     <li>No puede ser nulo.</li>
     *     <li>No puede estar vacío.</li>
     *     <li>Longitud máxima de 100 caracteres.</li>
     * </ul>
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String nombre;

    /**
     * Apellido paterno del autor.
     *
     * <p>Campo obligatorio.</p>
     *
     * <p>Restricciones:</p>
     * <ul>
     *     <li>No puede ser nulo.</li>
     *     <li>No puede estar vacío.</li>
     *     <li>Longitud máxima de 100 caracteres.</li>
     * </ul>
     */
    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(max = 100, message = "El apellido paterno no puede exceder los 100 caracteres.")
    private String apellidoPaterno;

    /**
     * Apellido materno del autor.
     *
     * <p>Campo opcional.</p>
     *
     * <p>Restricción:</p>
     * <ul>
     *     <li>Longitud máxima de 100 caracteres.</li>
     * </ul>
     */
    @Size(max = 100, message = "El apellido materno no puede exceder los 100 caracteres.")
    private String apellidoMaterno;

    /**
     * Nacionalidad del autor.
     *
     * <p>Campo opcional.</p>
     *
     * <p>Restricción:</p>
     * <ul>
     *     <li>Longitud máxima de 100 caracteres.</li>
     * </ul>
     */
    @Size(max = 100, message = "La nacionalidad no puede exceder los 100 caracteres.")
    private String nacionalidad;

    /**
     * Estado lógico del autor dentro del sistema.
     *
     * <p>
     * Un valor {@code true} indica que el autor se encuentra activo,
     * mientras que {@code false} indica que ha sido deshabilitado.
     * </p>
     */
    private Boolean activo;

    /**
     * Constructor vacío requerido para la creación del objeto
     * durante el proceso de deserialización de solicitudes JSON.
     */
    public AutorRequestDTO() {
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del autor.
     *
     * @param nombre nombre del autor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno.
     *
     * @return apellido paterno del autor.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Asigna el apellido paterno.
     *
     * @param apellidoPaterno apellido paterno del autor.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno.
     *
     * @return apellido materno del autor.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Asigna el apellido materno.
     *
     * @param apellidoMaterno apellido materno del autor.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la nacionalidad del autor.
     *
     * @return nacionalidad del autor.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Asigna la nacionalidad del autor.
     *
     * @param nacionalidad nacionalidad del autor.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el estado lógico del autor.
     *
     * @return {@code true} si el autor está activo;
     *         {@code false} en caso contrario.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado lógico del autor.
     *
     * @param activo estado del autor.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}