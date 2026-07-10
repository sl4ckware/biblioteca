package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de editoriales utilizadas por el Dataset Generator.
 *
 * @author Conce
 * @version 1.0
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

            // Continúa hasta completar las 20 editoriales.

    };

    /**
     * Constructor privado.
     */
    private EditorialCatalog() {
    }

}