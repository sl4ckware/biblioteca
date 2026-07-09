package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) utilizado para enviar la información
 * de un autor como respuesta a las solicitudes realizadas por el cliente.
 *
 * <p>
 * Este objeto encapsula únicamente los datos que serán expuestos por la
 * API REST, evitando el acceso directo a la entidad de persistencia.
 * </p>
 *
 * <p>
 * Es utilizado principalmente en las operaciones de:
 * </p>
 * <ul>
 *     <li>Consulta de autores.</li>
 *     <li>Registro de autores.</li>
 *     <li>Actualización de autores.</li>
 * </ul>
 *
 * @author Conce
 * @version 1.0
 * @since 2026
 */
public class AutorResponseDTO {

    /**
     * Identificador único del autor.
     */
    private Integer idAutor;

    /**
     * Nombre(s) del autor.
     */
    private String nombre;

    /**
     * Apellido paterno del autor.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del autor.
     */
    private String apellidoMaterno;

    /**
     * Nacionalidad del autor.
     */
    private String nacionalidad;

    /**
     * Estado lógico del registro.
     */
    private Boolean activo;

    /**
     * Fecha y hora en que fue creado el registro.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha y hora de la última actualización del registro.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido para la serialización y deserialización
     * del objeto.
     */
    public AutorResponseDTO() {
    }

    /**
     * Obtiene el identificador del autor.
     *
     * @return identificador del autor.
     */
    public Integer getIdAutor() {
        return idAutor;
    }

    /**
     * Establece el identificador del autor.
     *
     * @param idAutor identificador del autor.
     */
    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
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
     * Establece el nombre del autor.
     *
     * @param nombre nombre del autor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del autor.
     *
     * @return apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del autor.
     *
     * @param apellidoPaterno apellido paterno del autor.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del autor.
     *
     * @return apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del autor.
     *
     * @param apellidoMaterno apellido materno del autor.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la nacionalidad del autor.
     *
     * @return nacionalidad.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del autor.
     *
     * @param nacionalidad nacionalidad del autor.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Indica si el autor se encuentra activo.
     *
     * @return {@code true} si está activo; {@code false} en caso contrario.
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

    /**
     * Obtiene la fecha de creación del registro.
     *
     * @return fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del registro.
     *
     * @param fechaCreacion fecha de creación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene la fecha de la última actualización.
     *
     * @return fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de la última actualización.
     *
     * @param fechaActualizacion fecha de actualización.
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}