package mx.edu.itvo.biblioteca.constant;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * Constantes de los tipos de multa.
 * ============================================================
 *
 * Centraliza los tipos de multa utilizados
 * por el Sistema Integral de Biblioteca,
 * evitando el uso de cadenas de texto
 * distribuidas en el código fuente.
 *
 * <p>
 * Esta clase permite mantener consistencia
 * entre las reglas de negocio, el servicio
 * de multas y los registros almacenados
 * en la base de datos.
 * </p>
 *
 * <p>
 * Las constantes definidas en esta clase
 * deben coincidir exactamente con los
 * registros existentes en la tabla
 * <b>tipo_multa</b>.
 * </p>
 *
 * <p>
 * Es utilizada principalmente por:
 * </p>
 *
 * <ul>
 *     <li>MultaServiceImpl</li>
 *     <li>TipoMultaRepository</li>
 *     <li>Validaciones de negocio</li>
 * </ul>
 *
 * @author Conce
 * @version 2.0
 * @since Sprint 19
 */
public final class TipoMultaConstantes {

    /**
     * Multa generada por la devolución
     * fuera de la fecha establecida.
     */
    public static final String ENTREGA_TARDIA =
            "Entrega tardía";

    /**
     * Multa ocasionada por daños
     * físicos al ejemplar.
     */
    public static final String DANO =
            "Daño";

    /**
     * Multa ocasionada por la pérdida
     * total del ejemplar.
     */
    public static final String PERDIDA =
            "Pérdida";

    /**
     * Multa administrativa por un
     * concepto diferente a los
     * establecidos anteriormente.
     */
    public static final String OTRO =
            "Otro";

    /**
     * Constructor privado para impedir
     * la creación de instancias.
     */
    private TipoMultaConstantes() {

        throw new IllegalStateException(
                "Clase de constantes.");

    }

}