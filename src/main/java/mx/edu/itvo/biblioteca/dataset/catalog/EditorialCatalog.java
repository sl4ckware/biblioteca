package mx.edu.itvo.biblioteca.dataset.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;

/**
 * Catálogo oficial de editoriales utilizadas por el Dataset Generator.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EditorialCatalog {

    /**
     * Registro que representa una editorial.
     *
     * @param nombre Nombre de la editorial.
     * @param pais País de origen.
     * @param ciudad Ciudad principal.
     * @param telefono Teléfono.
     * @param correo Correo electrónico.
     * @param sitioWeb Sitio web.
     */
    public record EditorialItem(
            String nombre,
            String pais,
            String ciudad,
            String telefono,
            String correo,
            String sitioWeb) {
    }

    /**
     * Catálogo oficial.
     */
    public static final EditorialItem[] ITEMS = {

            new EditorialItem(
                    "NovaTech Press",
                    "México",
                    "Ciudad de México",
                    "5551000001",
                    "contacto@novatechpress.com",
                    "https://www.novatechpress.com"),

            new EditorialItem(
                    "Digital Knowledge",
                    "España",
                    "Madrid",
                    "34911000001",
                    "info@digitalknowledge.es",
                    "https://www.digitalknowledge.es"),

            new EditorialItem(
                    "Future Books",
                    "Argentina",
                    "Buenos Aires",
                    "54111000001",
                    "contacto@futurebooks.ar",
                    "https://www.futurebooks.ar"),

            new EditorialItem(
                    "Innovate Publishing",
                    "Colombia",
                    "Bogotá",
                    "5716000001",
                    "info@innovate.co",
                    "https://www.innovate.co"),

            new EditorialItem(
                    "Code Academy Press",
                    "Estados Unidos",
                    "Austin",
                    "15125550001",
                    "support@codeacademy.com",
                    "https://www.codeacademy.com")

    };

    /**
     * Obtiene el catálogo de editoriales.
     *
     * <p>
     * Si la cantidad solicitada en la configuración es mayor al catálogo
     * base, se generan editoriales adicionales automáticamente.
     * </p>
     *
     * @return Lista de editoriales.
     */
    public static List<EditorialItem> getItems() {

        List<EditorialItem> editoriales =
                new ArrayList<>(Arrays.asList(ITEMS));

        int total =
                Math.max(
                        Config.DEFAULT_TOTAL_EDITORIALES,
                        ITEMS.length);

        for (int i = ITEMS.length + 1;
                i <= total;
                i++) {

            editoriales.add(

                    new EditorialItem(

                            "Editorial " + i,

                            "México",

                            "Ciudad " + i,

                            String.format(
                                    "555%07d",
                                    i),

                            "editorial" + i
                                    + "@dataset.com",

                            "https://www.editorial"
                                    + i
                                    + ".com"));

        }

        return editoriales;

    }

    /**
     * Constructor privado.
     */
    private EditorialCatalog() {
    }

}