package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.TipoUsuarioData;

/**
 * Convierte un TipoUsuarioData en una sentencia SQL INSERT.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class TipoUsuarioSqlMapper {

    /**
     * Formato para fechas y horas.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private TipoUsuarioSqlMapper() {
    }

    /**
     * Convierte un tipo de usuario en una sentencia SQL.
     *
     * @param tipo Tipo de usuario.
     * @return Sentencia SQL.
     */
    public static String toSql(
            TipoUsuarioData tipo) {

        return """
            INSERT INTO tipo_usuario
            (
                nombre,
                descripcion,
                activo,
                fecha_creacion,
                fecha_actualizacion
            )
            VALUES
            (
                '%s',
                '%s',
                %d,
                '%s',
                '%s'
            );
            """.formatted(

                escape(
                        tipo.getNombre()),

                escape(
                        tipo.getDescripcion()),

                tipo.getActivo()
                        ? 1
                        : 0,

                tipo.getFechaCreacion()
                        .format(FORMATTER),

                tipo.getFechaActualizacion()
                        .format(FORMATTER));

    }

    /**
     * Escapa comillas simples.
     *
     * @param value Texto.
     * @return Texto escapado.
     */
    private static String escape(
            String value) {

        if (value == null) {
            return "";
        }

        return value.replace(
                "'",
                "''");

    }

}