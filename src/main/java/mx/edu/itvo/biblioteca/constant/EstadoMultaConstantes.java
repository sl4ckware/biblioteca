package mx.edu.itvo.biblioteca.constant;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * Constantes de los estados de una multa.
 * ============================================================
 *
 * Centraliza los nombres de los estados utilizados
 * por el módulo de multas, evitando el uso de
 * cadenas de texto distribuidas en el código
 * fuente y reduciendo errores por diferencias
 * de escritura.
 *
 * <p>
 * Estas constantes son utilizadas por:
 * </p>
 *
 * <ul>
 *     <li>MultaServiceImpl</li>
 *     <li>EstadoMultaRepository</li>
 *     <li>MultaController</li>
 *     <li>Validaciones de negocio</li>
 * </ul>
 *
 * <p>
 * Los valores definidos en esta clase deben
 * coincidir exactamente con los registros
 * almacenados en la tabla:
 * <b>estado_multa</b>.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since Sprint 19
 */
public final class EstadoMultaConstantes {

    /**
     * Estado inicial de una multa.
     *
     * Indica que la multa fue generada
     * y aún no ha sido liquidada.
     */
    public static final String PENDIENTE =
            "Pendiente";

    /**
     * Estado de una multa liquidada.
     *
     * Indica que el usuario realizó
     * el pago correspondiente.
     */
    public static final String PAGADA =
            "Pagada";

    /**
     * Estado de una multa cancelada.
     *
     * Indica que la multa fue anulada
     * por una decisión administrativa
     * o por una corrección del sistema.
     */
    public static final String CANCELADA =
            "Cancelada";

    /**
     * Constructor privado para impedir
     * la creación de instancias.
     */
    private EstadoMultaConstantes() {

        throw new IllegalStateException(
                "Clase de constantes.");

    }

}