package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de idiomas utilizados por el Dataset Generator.
 *
 * <p>
 * Contiene la información base utilizada para generar registros
 * de la tabla {@code idioma}.
 * </p>
 *
 * <p>
 * Esta clase no genera información; únicamente expone un catálogo
 * predefinido de idiomas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class IdiomaCatalog {

    /**
     * Representa un idioma del catálogo.
     *
     * @param codigoIso Código ISO 639-1.
     * @param nombre Nombre del idioma.
     */
    public record IdiomaItem(
            String codigoIso,
            String nombre) {
    }

    /**
     * Catálogo oficial de idiomas.
     */
    public static final IdiomaItem[] ITEMS = {

            new IdiomaItem("es", "Español"),
            new IdiomaItem("en", "Inglés"),
            new IdiomaItem("fr", "Francés"),
            new IdiomaItem("de", "Alemán"),
            new IdiomaItem("it", "Italiano"),
            new IdiomaItem("pt", "Portugués"),
            new IdiomaItem("ja", "Japonés"),
            new IdiomaItem("ko", "Coreano"),
            new IdiomaItem("zh", "Chino"),
            new IdiomaItem("ru", "Ruso")

    };

    /**
     * Constructor privado.
     */
    private IdiomaCatalog() {
    }

}