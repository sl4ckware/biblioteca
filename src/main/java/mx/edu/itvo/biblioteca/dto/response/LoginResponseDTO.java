package mx.edu.itvo.biblioteca.dto.response;

/**
 * DTO utilizado para devolver
 * el token JWT al cliente.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LoginResponseDTO {

    /**
     * Token JWT.
     */
    private String token;

    /**
     * Tipo de autenticación.
     */
    private String type = "Bearer";

    /**
     * Constructor vacío.
     */
    public LoginResponseDTO() {

    }

    /**
     * Constructor.
     *
     * @param token Token JWT.
     */
    public LoginResponseDTO(
            String token) {

        this.token = token;

    }

    /**
     * Obtiene el token.
     *
     * @return Token.
     */
    public String getToken() {

        return token;

    }

    /**
     * Establece el token.
     *
     * @param token Token JWT.
     */
    public void setToken(
            String token) {

        this.token = token;

    }

    /**
     * Obtiene el tipo.
     *
     * @return Tipo.
     */
    public String getType() {

        return type;

    }

    /**
     * Establece el tipo.
     *
     * @param type Tipo.
     */
    public void setType(
            String type) {

        this.type = type;

    }

}