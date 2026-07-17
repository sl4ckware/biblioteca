package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.AutorData;

/**
 * Convierte un autor a una sentencia SQL.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class AutorSqlMapper {

    /**
     * Formato de fecha.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private AutorSqlMapper() {
    }

    /**
     * Convierte un autor en una sentencia INSERT.
     *
     * @param autor Autor.
     * @return Sentencia SQL.
     */
    public static String toSql(
            AutorData autor) {

        return """
            INSERT INTO autor
            (
                nombre,
                apellido_paterno,
                apellido_materno,
                nacionalidad,
                fecha_nacimiento,
                activo,
                fecha_creacion,
                fecha_actualizacion
            )
            VALUES
            (
                '%s',
                '%s',
                '%s',
                '%s',
                '%s',
                %d,
                '%s',
                '%s'
            );
            """.formatted(

                escape(
                        autor.getNombre()),

                escape(
                        autor.getApellidoPaterno()),

                escape(
                        autor.getApellidoMaterno()),

                escape(
                        autor.getNacionalidad()),

                autor.getFechaNacimiento(),

                autor.getActivo()
                        ? 1
                        : 0,

                autor.getFechaCreacion()
                        .format(FORMATTER),

                autor.getFechaActualizacion()
                        .format(FORMATTER));

    }

    /**
     * Escapa comillas simples.
     *
     * @param value Valor.
     * @return Valor escapado.
     */
    private static String escape(
            String value) {

        return value == null
                ? ""
                : value.replace(
                        "'",
                        "''");

    }

}