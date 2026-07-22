package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de estados de usuario.
 *
 * <p>
 * Contiene la información base para generar los registros
 * de la tabla {@code estado_usuario}.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoUsuarioCatalog {

    /**
     * Nombre del estado Activo.
     */
    public static final String NOMBRE_ACTIVO =
            "Activo";

    /**
     * Nombre del estado Suspendido.
     */
    public static final String NOMBRE_SUSPENDIDO =
            "Suspendido";

    /**
     * Nombre del estado Bloqueado.
     */
    public static final String NOMBRE_BLOQUEADO =
            "Bloqueado";

    /**
     * Nombre del estado Inactivo.
     */
    public static final String NOMBRE_INACTIVO =
            "Inactivo";

    /**
     * Nombre del estado Egresado.
     */
    public static final String NOMBRE_EGRESADO =
            "Egresado";

    /**
     * Representa un estado del catálogo.
     *
     * @param nombre Nombre del estado.
     * @param descripcion Descripción del estado.
     */
    public record EstadoUsuarioItem(
            String nombre,
            String descripcion) {
    }

    /**
     * Estado: Activo.
     */
    public static final EstadoUsuarioItem ACTIVO =
            new EstadoUsuarioItem(
                    NOMBRE_ACTIVO,
                    "Usuario habilitado para utilizar la biblioteca.");

    /**
     * Estado: Suspendido.
     */
    public static final EstadoUsuarioItem SUSPENDIDO =
            new EstadoUsuarioItem(
                    NOMBRE_SUSPENDIDO,
                    "Usuario suspendido temporalmente.");

    /**
     * Estado: Bloqueado.
     */
    public static final EstadoUsuarioItem BLOQUEADO =
            new EstadoUsuarioItem(
                    NOMBRE_BLOQUEADO,
                    "Usuario bloqueado por adeudos o sanciones.");

    /**
     * Estado: Inactivo.
     */
    public static final EstadoUsuarioItem INACTIVO =
            new EstadoUsuarioItem(
                    NOMBRE_INACTIVO,
                    "Usuario sin actividad.");

    /**
     * Estado: Egresado.
     */
    public static final EstadoUsuarioItem EGRESADO =
            new EstadoUsuarioItem(
                    NOMBRE_EGRESADO,
                    "Usuario egresado de la institución.");

    /**
     * Catálogo oficial de estados.
     */
    public static final EstadoUsuarioItem[] ITEMS = {

            ACTIVO,
            SUSPENDIDO,
            BLOQUEADO,
            INACTIVO,
            EGRESADO

    };

    /**
     * Constructor privado.
     */
    private EstadoUsuarioCatalog() {
    }

}