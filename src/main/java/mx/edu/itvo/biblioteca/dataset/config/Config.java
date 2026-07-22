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
 * @version 3.0
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
    public static final String FILE_CATEGORIAS =
            "01_categorias.sql";

    /**
     * Nombre del archivo SQL para las editoriales.
     */
    public static final String FILE_EDITORIALES =
            "02_editoriales.sql";

    /**
     * Nombre del archivo SQL para los idiomas.
     */
    public static final String FILE_IDIOMAS =
            "03_idiomas.sql";

    /**
     * Nombre del archivo SQL para los autores.
     */
    public static final String FILE_AUTORES =
            "04_autores.sql";

    /**
     * Nombre del archivo SQL para los libros.
     */
    public static final String FILE_LIBROS =
            "05_libros.sql";

    /**
     * Nombre del archivo SQL para la relación Libro-Autor.
     */
    public static final String FILE_LIBRO_AUTOR =
            "06_libro_autor.sql";

    /**
     * Nombre del archivo SQL para los estados de ejemplar.
     */
    public static final String FILE_ESTADO_EJEMPLAR =
            "07_estado_ejemplar.sql";

    /**
     * Nombre del archivo SQL para los ejemplares.
     */
    public static final String FILE_EJEMPLARES =
            "08_ejemplares.sql";

    /**
     * Nombre del archivo SQL para los tipos de usuario.
     */
    public static final String FILE_TIPO_USUARIO =
            "09_tipo_usuario.sql";

    /**
     * Nombre del archivo SQL para los estados de usuario.
     */
    public static final String FILE_ESTADO_USUARIO =
            "10_estado_usuario.sql";

    /**
     * Nombre del archivo SQL para los usuarios.
     */
    public static final String FILE_USUARIOS =
            "11_usuarios.sql";

    /**
     * Cantidad predeterminada de categorías.
     */
    public static final int DEFAULT_TOTAL_CATEGORIAS = 50;

    /**
     * Cantidad predeterminada de editoriales.
     */
    public static final int DEFAULT_TOTAL_EDITORIALES = 100;

    /**
     * Cantidad predeterminada de idiomas.
     */
    public static final int DEFAULT_TOTAL_IDIOMAS = 15;

    /**
     * Cantidad predeterminada de autores.
     */
    public static final int DEFAULT_TOTAL_AUTORES = 600;

    /**
     * Cantidad predeterminada de libros.
     */
    public static final int DEFAULT_TOTAL_LIBROS = 600;

    /**
     * Cantidad mínima de ejemplares por libro.
     */
    public static final int DEFAULT_MIN_EJEMPLARES_POR_LIBRO = 1;

    /**
     * Cantidad máxima de ejemplares por libro.
     */
    public static final int DEFAULT_MAX_EJEMPLARES_POR_LIBRO = 5;

    /**
     * Cantidad predeterminada de tipos de usuario.
     */
    public static final int DEFAULT_TOTAL_TIPO_USUARIO = 6;

    /**
     * Cantidad predeterminada de estados de usuario.
     */
    public static final int DEFAULT_TOTAL_ESTADO_USUARIO = 5;

    /**
     * Cantidad predeterminada de usuarios.
     */
    public static final int DEFAULT_TOTAL_USUARIOS = 600;

    /**
     * Prefijo utilizado para los códigos de inventario.
     */
    public static final String INVENTORY_PREFIX = "EJ";

    /**
     * Contraseña utilizada para todos los usuarios
     * generados por el Dataset.
     */
    public static final String DEFAULT_USER_PASSWORD =
            "Biblioteca2026!";

    /**
     * Constructor privado para evitar la creación de instancias.
     */
    private Config() {
    }

}