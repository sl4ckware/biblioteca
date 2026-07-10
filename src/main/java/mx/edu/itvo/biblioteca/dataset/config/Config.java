package mx.edu.itvo.biblioteca.dataset.config;

/**
 * Contiene la configuración general del Dataset Generator.
 *
 * Esta clase centraliza todos los parámetros utilizados durante la
 * generación de datos de prueba para la base de datos de la Biblioteca.
 *
 * Modificando estos valores es posible generar diferentes volúmenes de
 * información sin realizar cambios en el resto del código.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class Config {

    /**
     * Directorio donde se generarán los archivos SQL.
     */
    public static final String OUTPUT_DIRECTORY = "dataset";

    /**
     * Nombre del archivo SQL para las categorías.
     */
    public static final String FILE_CATEGORIAS = "01_categorias.sql";

    /**
     * Nombre del archivo SQL para las editoriales.
     */
    public static final String FILE_EDITORIALES = "02_editoriales.sql";

    /**
     * Nombre del archivo SQL para los idiomas.
     */
    public static final String FILE_IDIOMAS = "03_idiomas.sql";

    /**
     * Nombre del archivo SQL para los autores.
     */
    public static final String FILE_AUTORES = "04_autores.sql";

    /**
     * Nombre del archivo SQL para los libros.
     */
    public static final String FILE_LIBROS = "05_libros.sql";

    /**
     * Nombre del archivo SQL para la relación Libro-Autor.
     */
    public static final String FILE_LIBRO_AUTOR = "06_libro_autor.sql";

    /**
     * Cantidad predeterminada de categorías.
     */
    public static final int DEFAULT_TOTAL_CATEGORIAS = 15;

    /**
     * Cantidad predeterminada de editoriales.
     */
    public static final int DEFAULT_TOTAL_EDITORIALES = 20;

    /**
     * Cantidad predeterminada de idiomas.
     */
    public static final int DEFAULT_TOTAL_IDIOMAS = 8;

    /**
     * Cantidad predeterminada de autores.
     */
    public static final int DEFAULT_TOTAL_AUTORES = 250;

    /**
     * Cantidad predeterminada de libros.
     */
    public static final int DEFAULT_TOTAL_LIBROS = 500;

    /**
     * Constructor privado para evitar la creación de instancias.
     */
    private Config() {
    }

}