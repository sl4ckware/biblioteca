package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de categorías utilizadas por el Dataset Generator.
 *
 * <p>
 * Contiene información estática que servirá como base para generar
 * los registros de la tabla {@code categoria}.
 * </p>
 *
 * <p>
 * Esta clase no genera información; únicamente expone un catálogo
 * de categorías predefinidas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class CategoriaCatalog {

    /**
     * Representa una categoría del catálogo.
     *
     * @param codigo Código único.
     * @param nombre Nombre de la categoría.
     * @param descripcion Descripción.
     */
    public record CategoriaItem(
            String codigo,
            String nombre,
            String descripcion) {
    }

    /**
     * Catálogo oficial de categorías.
     */
    public static final CategoriaItem[] ITEMS = {

            new CategoriaItem(
                    "ARQ",
                    "Arquitectura de Software",
                    "Libros relacionados con arquitectura y diseño de software."),

            new CategoriaItem(
                    "BIG",
                    "Big Data",
                    "Procesamiento y análisis masivo de datos."),

            new CategoriaItem(
                    "CIB",
                    "Ciberseguridad",
                    "Seguridad informática y protección de sistemas."),

            new CategoriaItem(
                    "MOV",
                    "Desarrollo Móvil",
                    "Desarrollo de aplicaciones Android e iOS."),

            new CategoriaItem(
                    "NUB",
                    "Computación en la Nube",
                    "Cloud Computing y plataformas distribuidas."),

            new CategoriaItem(
                    "ROB",
                    "Robótica",
                    "Programación y diseño de sistemas robóticos."),

            new CategoriaItem(
                    "IOT",
                    "Internet de las Cosas",
                    "Dispositivos inteligentes y comunicación entre sensores."),

            new CategoriaItem(
                    "ANA",
                    "Analítica de Datos",
                    "Minería y análisis de información."),

            new CategoriaItem(
                    "UX",
                    "Experiencia de Usuario",
                    "Diseño de interfaces y experiencia de usuario."),

            new CategoriaItem(
                    "BLO",
                    "Blockchain",
                    "Tecnologías blockchain y contratos inteligentes."),

            new CategoriaItem(
                    "DEV",
                    "DevOps",
                    "Automatización, integración y entrega continua."),

            new CategoriaItem(
                    "MIC",
                    "Microservicios",
                    "Arquitecturas basadas en microservicios."),

            new CategoriaItem(
                    "API",
                    "Desarrollo de APIs",
                    "Diseño e implementación de servicios REST."),

            new CategoriaItem(
                    "TES",
                    "Pruebas de Software",
                    "Pruebas funcionales, automatizadas y de integración."),

            new CategoriaItem(
                    "CCD",
                    "Computación Científica",
                    "Modelado matemático y simulación computacional.")

    };

    /**
     * Constructor privado para evitar instancias.
     */
    private CategoriaCatalog() {
    }

}