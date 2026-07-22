package mx.edu.itvo.biblioteca.constant;

/**
 * Constantes de los estados
 * de una reserva.
 *
 * <p>
 * Centraliza los nombres de los
 * estados utilizados por el módulo
 * de reservas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public final class EstadoReservaConstantes {

    /**
     * Reserva activa.
     */
    public static final String ACTIVA =
            "Activa";

    /**
     * Reserva atendida.
     */
    public static final String ATENDIDA =
            "Atendida";

    /**
     * Reserva cancelada.
     */
    public static final String CANCELADA =
            "Cancelada";

    /**
     * Reserva expirada.
     */
    public static final String EXPIRADA =
            "Expirada";

    /**
     * Constructor privado.
     */
    private EstadoReservaConstantes() {

    }

}