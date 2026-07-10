package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.EditorialData;

/**
 * Convierte EditorialData en SQL.
 *
 * @author Conce
 * @version 1.0
 */
public final class EditorialSqlMapper {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private EditorialSqlMapper() {
    }

    public static String toSql(EditorialData editorial) {

        return """
            INSERT INTO editorial
            (
                nombre,
                pais,
                ciudad,
                telefono,
                correo,
                sitio_web,
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
                '%s',
                %d,
                '%s',
                '%s'
            );
            """.formatted(

                escape(editorial.getNombre()),
                escape(editorial.getPais()),
                escape(editorial.getCiudad()),
                escape(editorial.getTelefono()),
                escape(editorial.getCorreo()),
                escape(editorial.getSitioWeb()),
                editorial.getActivo() ? 1 : 0,
                editorial.getFechaCreacion().format(FORMATTER),
                editorial.getFechaActualizacion().format(FORMATTER));

    }

    private static String escape(String value) {

        return value == null
                ? ""
                : value.replace("'", "''");

    }

}