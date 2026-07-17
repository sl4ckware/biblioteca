package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.IdiomaData;

/**
 * Convierte IdiomaData en SQL.
 *
 * @author Conce
 * @version 1.0
 */
public final class IdiomaSqlMapper {

    /**
     * Formato de fecha para SQL.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private IdiomaSqlMapper() {
    }

    /**
     * Convierte un idioma en una sentencia SQL.
     *
     * @param idioma Idioma.
     * @return Sentencia INSERT.
     */
    public static String toSql(
            IdiomaData idioma) {

        return """
            INSERT INTO idioma
            (
                codigo_iso,
                nombre,
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

                escape(idioma.getCodigoIso()),
                escape(idioma.getNombre()),
                idioma.getActivo() ? 1 : 0,
                idioma.getFechaCreacion().format(FORMATTER),
                idioma.getFechaActualizacion().format(FORMATTER));

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
                : value.replace("'", "''");

    }

}