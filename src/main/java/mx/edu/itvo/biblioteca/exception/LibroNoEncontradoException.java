package mx.edu.itvo.biblioteca.exception;

/**
 * Excepción lanzada cuando un libro solicitado no existe
 * en la base de datos.
 *
 * Esta excepción es utilizada por la capa de servicio para
 * indicar que no fue posible localizar un libro mediante
 * su identificador.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LibroNoEncontradoException extends RuntimeException {

    /**
     * Crea una nueva excepción con el mensaje especificado.
     *
     * @param mensaje Descripción del error.
     */
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}