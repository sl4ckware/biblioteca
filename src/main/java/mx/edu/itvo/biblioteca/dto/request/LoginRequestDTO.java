package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO utilizado para recibir la solicitud
 * de autenticación.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LoginRequestDTO {

    /**
     * Correo electrónico del usuario.
     */
    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo no tiene un formato válido.")
    private String correo;

    /**
     * Contraseña del usuario.
     */
    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;

    /**
     * Obtiene el correo.
     *
     * @return Correo.
     */
    public String getCorreo() {

        return correo;

    }

    /**
     * Establece el correo.
     *
     * @param correo Correo.
     */
    public void setCorreo(
            String correo) {

        this.correo = correo;

    }

    /**
     * Obtiene la contraseña.
     *
     * @return Contraseña.
     */
    public String getPassword() {

        return password;

    }

    /**
     * Establece la contraseña.
     *
     * @param password Contraseña.
     */
    public void setPassword(
            String password) {

        this.password = password;

    }

}