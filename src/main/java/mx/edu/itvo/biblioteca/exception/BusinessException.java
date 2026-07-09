package mx.edu.itvo.biblioteca.exception;

/**
 * Excepción utilizada para representar errores de lógica
 * de negocio dentro del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class BusinessException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param message Mensaje de error.
     */
    public BusinessException(String message) {
        super(message);
    }

}