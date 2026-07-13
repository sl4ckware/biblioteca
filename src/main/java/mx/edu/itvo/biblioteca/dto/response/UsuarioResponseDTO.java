package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver información de un usuario.
 *
 * Contiene la información expuesta por la API REST hacia
 * los clientes del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class UsuarioResponseDTO {

    /**
     * Identificador del usuario.
     */
    private Integer idUsuario;

    /**
     * Matrícula del usuario.
     */
    private String matricula;

    /**
     * Nombre del usuario.
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
     * Correo electrónico.
     */
    private String correo;

    /**
     * Teléfono.
     */
    private String telefono;

    /**
     * Identificador del tipo de usuario.
     */
    private Integer idTipoUsuario;

    /**
     * Nombre del tipo de usuario.
     */
    private String tipoUsuario;

    /**
     * Identificador del estado del usuario.
     */
    private Integer idEstadoUsuario;

    /**
     * Nombre del estado del usuario.
     */
    private String estadoUsuario;

    /**
     * Estado del usuario.
     */
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public UsuarioResponseDTO() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
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

}