package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de estados utilizados por los ejemplares
 * del Dataset Generator.
 *
 * <p>
 * Define los estados válidos que puede tener un ejemplar físico
 * dentro de la biblioteca.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoEjemplarCatalog {

    /**
     * Nombre del estado Disponible.
     */
    public static final String NOMBRE_DISPONIBLE =
            "Disponible";

    /**
     * Nombre del estado Prestado.
     */
    public static final String NOMBRE_PRESTADO =
            "Prestado";

    /**
     * Nombre del estado Reservado.
     */
    public static final String NOMBRE_RESERVADO =
            "Reservado";

    /**
     * Nombre del estado Mantenimiento.
     */
    public static final String NOMBRE_MANTENIMIENTO =
            "Mantenimiento";

    /**
     * Nombre del estado Extraviado.
     */
    public static final String NOMBRE_EXTRAVIADO =
            "Extraviado";

    /**
     * Nombre del estado Baja.
     */
    public static final String NOMBRE_BAJA =
            "Baja";

    /**
     * Representa un estado del ejemplar.
     *
     * @param nombre Nombre del estado.
     * @param descripcion Descripción del estado.
     */
    public record EstadoEjemplarItem(
            String nombre,
            String descripcion) {
    }

    /**
     * Estado: Disponible.
     */
    public static final EstadoEjemplarItem DISPONIBLE =
            new EstadoEjemplarItem(
                    NOMBRE_DISPONIBLE,
                    "Ejemplar disponible para préstamo.");

    /**
     * Estado: Prestado.
     */
    public static final EstadoEjemplarItem PRESTADO =
            new EstadoEjemplarItem(
                    NOMBRE_PRESTADO,
                    "Ejemplar actualmente prestado a un usuario.");

    /**
     * Estado: Reservado.
     */
    public static final EstadoEjemplarItem RESERVADO =
            new EstadoEjemplarItem(
                    NOMBRE_RESERVADO,
                    "Ejemplar reservado por un usuario.");

    /**
     * Estado: En mantenimiento.
     */
    public static final EstadoEjemplarItem MANTENIMIENTO =
            new EstadoEjemplarItem(
                    NOMBRE_MANTENIMIENTO,
                    "Ejemplar temporalmente fuera de servicio.");

    /**
     * Estado: Extraviado.
     */
    public static final EstadoEjemplarItem EXTRAVIADO =
            new EstadoEjemplarItem(
                    NOMBRE_EXTRAVIADO,
                    "Ejemplar reportado como extraviado.");

    /**
     * Estado: Baja definitiva.
     */
    public static final EstadoEjemplarItem BAJA =
            new EstadoEjemplarItem(
                    NOMBRE_BAJA,
                    "Ejemplar dado de baja definitivamente.");

    /**
     * Todos los estados disponibles.
     */
    public static final EstadoEjemplarItem[] ITEMS = {

            DISPONIBLE,
            PRESTADO,
            RESERVADO,
            MANTENIMIENTO,
            EXTRAVIADO,
            BAJA

    };

    /**
     * Constructor privado.
     */
    private EstadoEjemplarCatalog() {
    }

}