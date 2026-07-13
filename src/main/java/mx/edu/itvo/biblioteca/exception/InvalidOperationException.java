package mx.edu.itvo.biblioteca.exception;

/**
 * Excepción lanzada cuando se intenta realizar
 * una operación que no está permitida por las
 * reglas de negocio del sistema.
 *
 * Ejemplos:
 * - Prestar un ejemplar ya prestado.
 * - Renovar un préstamo devuelto.
 * - Devolver un préstamo ya devuelto.
 * - Operar sobre registros inactivos.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class InvalidOperationException
        extends BusinessException {

    /**
     * Constructor.
     *
     * @param message Mensaje de la excepción.
     */
    public InvalidOperationException(String message) {

        super(message);

    }

}