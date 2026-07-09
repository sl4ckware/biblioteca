package mx.edu.itvo.biblioteca.exception;

/**
 * Excepción lanzada cuando un recurso solicitado
 * no existe dentro del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class ResourceNotFoundException extends BusinessException {

    /**
     * Constructor.
     *
     * @param resource Nombre del recurso.
     * @param field Campo utilizado para la búsqueda.
     * @param value Valor buscado.
     */
    public ResourceNotFoundException(
            String resource,
            String field,
            Object value) {

        super(String.format(
                "%s con %s '%s' no fue encontrado.",
                resource,
                field,
                value));

    }

}