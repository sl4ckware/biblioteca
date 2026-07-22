package mx.edu.itvo.biblioteca.constant;

/**
 * Constantes de los estados de préstamo.
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
public final class EstadoPrestamoConstantes {

    /**
     * Constructor privado.
     */
    private EstadoPrestamoConstantes() {
    }

    /**
     * Préstamo activo.
     */
    public static final String ACTIVO =
            "Activo";

    /**
     * Préstamo devuelto.
     */
    public static final String DEVUELTO =
            "Devuelto";

    /**
     * Préstamo vencido.
     */
    public static final String VENCIDO =
            "Vencido";

}