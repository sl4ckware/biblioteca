package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.EstadoEjemplarData;

/**
 * Convierte un EstadoEjemplarData en una sentencia SQL INSERT.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoEjemplarSqlMapper {

    /**
     * Formato para fechas y horas.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private EstadoEjemplarSqlMapper() {
    }

    /**
     * Convierte un estado de ejemplar en una sentencia SQL.
     *
     * @param estado Estado de ejemplar.
     * @return Sentencia SQL.
     */
    public static String toSql(
            EstadoEjemplarData estado) {

        return """
            INSERT INTO estado_ejemplar
            (
                nombre,
                descripcion,
                fecha_creacion,
                fecha_actualizacion
            )
            VALUES
            (
                '%s',
                '%s',
                '%s',
                '%s'
            );
            """.formatted(

                escape(
                        estado.getNombre()),

                escape(
                        estado.getDescripcion()),

                estado.getFechaCreacion()
                        .format(FORMATTER),

                estado.getFechaActualizacion()
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