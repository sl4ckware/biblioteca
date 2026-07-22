package mx.edu.itvo.biblioteca.dataset.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;

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
 * @version 2.0
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
     * Obtiene el catálogo de idiomas.
     *
     * <p>
     * Si la cantidad solicitada en la configuración es mayor al catálogo
     * base, se generan idiomas adicionales automáticamente.
     * </p>
     *
     * @return Lista de idiomas.
     */
    public static List<IdiomaItem> getItems() {

        List<IdiomaItem> idiomas =
                new ArrayList<>(Arrays.asList(ITEMS));

        int total =
                Math.max(
                        Config.DEFAULT_TOTAL_IDIOMAS,
                        ITEMS.length);

        for (int i = ITEMS.length + 1;
                i <= total;
                i++) {

            idiomas.add(

                    new IdiomaItem(

                            String.format(
                                    "x%02d",
                                    i),

                            "Idioma " + i));

        }

        return idiomas;

    }

    /**
     * Constructor privado.
     */
    private IdiomaCatalog() {
    }

}