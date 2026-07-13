package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar y actualizar usuarios.
 *
 * Contiene la información recibida desde la API para la creación
 * y actualización de usuarios del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class UsuarioRequestDTO {

    /**
     * Matrícula del usuario.
     */
    @NotBlank(message = "La matrícula es obligatoria.")
    @Size(min = 5, max = 20,
            message = "La matrícula debe contener entre 5 y 20 caracteres.")
    private String matricula;

    /**
     * Nombre del usuario.
     */
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 100)
    private String nombre;

    /**
     * Apellido paterno.
     */
    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(min = 2, max = 100)
    private String apellidoPaterno;

    /**
     * Apellido materno.
     */
    @Size(max = 100)
    private String apellidoMaterno;

    /**
     * Correo electrónico.
     */
    @Email(message = "Correo electrónico no válido.")
    @Size(max = 150)
    private String correo;

    /**
     * Teléfono.
     */
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "El teléfono debe contener 10 dígitos.")
    private String telefono;

    /**
     * Identificador del tipo de usuario.
     */
    @NotNull(message = "El tipo de usuario es obligatorio.")
    private Integer idTipoUsuario;

    /**
     * Identificador del estado del usuario.
     */
    @NotNull(message = "El estado del usuario es obligatorio.")
    private Integer idEstadoUsuario;

    /**
     * Constructor vacío.
     */
    public UsuarioRequestDTO() {
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

    public Integer getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

}