package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Representa un usuario dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena la información de los usuarios
 * registrados para realizar préstamos de libros.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    /**
     * Matrícula del usuario.
     */
    @NotBlank(message = "La matrícula es obligatoria.")
    @Size(min = 5, max = 20,
            message = "La matrícula debe contener entre 5 y 20 caracteres.")
    @Column(name = "MATRICULA", nullable = false, unique = true, length = 20)
    private String matricula;

    /**
     * Nombre del usuario.
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    /**
     * Apellido paterno.
     */
    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(min = 2, max = 100)
    @Column(name = "APELLIDO_PATERNO", nullable = false, length = 100)
    private String apellidoPaterno;

    /**
     * Apellido materno.
     */
    @Size(max = 100)
    @Column(name = "APELLIDO_MATERNO", length = 100)
    private String apellidoMaterno;

    /**
     * Correo electrónico.
     */
    @Email(message = "Correo electrónico no válido.")
    @Size(max = 150)
    @Column(name = "CORREO", unique = true, length = 150)
    private String correo;
    
    /**
     * Contraseña cifrada del usuario.
     */
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    /**
     * Teléfono de contacto.
     */
    @Pattern(regexp = "^[0-9]{10}$",
            message = "El teléfono debe contener 10 dígitos.")
    @Column(name = "TELEFONO", length = 10)
    private String telefono;

    /**
     * Estado del usuario.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación.
     */
    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Tipo de usuario.
     */
    @NotNull(message = "El tipo de usuario es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_USUARIO", nullable = false)
    private TipoUsuario tipoUsuario;

    /**
     * Estado del usuario.
     */
    @NotNull(message = "El estado del usuario es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO_USUARIO", nullable = false)
    private EstadoUsuario estadoUsuario;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Usuario() {
    }

    /**
     * Constructor principal.
     */
    public Usuario(String matricula,
                   String nombre,
                   String apellidoPaterno,
                   String apellidoMaterno,
                   String correo,
                   String telefono,
                   TipoUsuario tipoUsuario,
                   EstadoUsuario estadoUsuario,
                   Boolean activo) {

        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.estadoUsuario = estadoUsuario;
        this.activo = activo;
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
    
    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
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
     * Establece la fecha de actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", activo=" + activo +
                '}';
    }

}