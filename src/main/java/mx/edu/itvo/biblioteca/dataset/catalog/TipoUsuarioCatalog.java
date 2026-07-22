package mx.edu.itvo.biblioteca.dataset.catalog;

/**
 * Catálogo oficial de tipos de usuario utilizados por el
 * Dataset Generator.
 *
 * <p>
 * Contiene la información base para generar los registros
 * de la tabla {@code tipo_usuario}.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class TipoUsuarioCatalog {

    /**
     * Nombre del tipo de usuario Administrador.
     */
    public static final String NOMBRE_ADMINISTRADOR =
            "Administrador";

    /**
     * Nombre del tipo de usuario Bibliotecario.
     */
    public static final String NOMBRE_BIBLIOTECARIO =
            "Bibliotecario";

    /**
     * Nombre del tipo de usuario Docente.
     */
    public static final String NOMBRE_DOCENTE =
            "Docente";

    /**
     * Nombre del tipo de usuario Alumno.
     */
    public static final String NOMBRE_ALUMNO =
            "Alumno";

    /**
     * Nombre del tipo de usuario Investigador.
     */
    public static final String NOMBRE_INVESTIGADOR =
            "Investigador";

    /**
     * Nombre del tipo de usuario Externo.
     */
    public static final String NOMBRE_USUARIO_EXTERNO =
            "Usuario Externo";

    /**
     * Representa un tipo de usuario del catálogo.
     *
     * @param nombre Nombre del tipo de usuario.
     * @param descripcion Descripción del tipo de usuario.
     */
    public record TipoUsuarioItem(
            String nombre,
            String descripcion) {
    }

    /**
     * Tipo: Administrador.
     */
    public static final TipoUsuarioItem ADMINISTRADOR =
            new TipoUsuarioItem(
                    NOMBRE_ADMINISTRADOR,
                    "Administrador del sistema.");

    /**
     * Tipo: Bibliotecario.
     */
    public static final TipoUsuarioItem BIBLIOTECARIO =
            new TipoUsuarioItem(
                    NOMBRE_BIBLIOTECARIO,
                    "Responsable de la gestión de préstamos.");

    /**
     * Tipo: Docente.
     */
    public static final TipoUsuarioItem DOCENTE =
            new TipoUsuarioItem(
                    NOMBRE_DOCENTE,
                    "Profesor registrado en la biblioteca.");

    /**
     * Tipo: Alumno.
     */
    public static final TipoUsuarioItem ALUMNO =
            new TipoUsuarioItem(
                    NOMBRE_ALUMNO,
                    "Estudiante registrado en la biblioteca.");

    /**
     * Tipo: Investigador.
     */
    public static final TipoUsuarioItem INVESTIGADOR =
            new TipoUsuarioItem(
                    NOMBRE_INVESTIGADOR,
                    "Investigador con acceso especializado.");

    /**
     * Tipo: Usuario Externo.
     */
    public static final TipoUsuarioItem USUARIO_EXTERNO =
            new TipoUsuarioItem(
                    NOMBRE_USUARIO_EXTERNO,
                    "Usuario autorizado externo a la institución.");

    /**
     * Catálogo oficial de tipos de usuario.
     */
    public static final TipoUsuarioItem[] ITEMS = {

            ADMINISTRADOR,
            BIBLIOTECARIO,
            DOCENTE,
            ALUMNO,
            INVESTIGADOR,
            USUARIO_EXTERNO

    };

    /**
     * Constructor privado.
     */
    private TipoUsuarioCatalog() {
    }

}