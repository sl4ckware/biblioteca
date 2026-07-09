package mx.edu.itvo.biblioteca.exception;

/**
 * Excepción lanzada cuando se intenta registrar
 * un recurso que ya existe en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class DuplicateResourceException extends BusinessException {

    /**
     * Constructor.
     *
     * @param resource Nombre del recurso.
     * @param field Campo duplicado.
     * @param value Valor duplicado.
     */
    public DuplicateResourceException(
            String resource,
            String field,
            Object value) {

        super(String.format(
                "%s con %s '%s' ya existe.",
                resource,
                field,
                value));

    }

}