package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.LibroAutorData;

/**
 * Convierte una relación Libro-Autor en una sentencia SQL.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class LibroAutorSqlMapper {

    /**
     * Formato para fechas.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private LibroAutorSqlMapper() {
    }

    /**
     * Convierte una relación Libro-Autor en una sentencia INSERT.
     *
     * @param relacion Relación Libro-Autor.
     * @return Sentencia SQL.
     */
    public static String toSql(
            LibroAutorData relacion) {

        return """
            INSERT INTO LIBRO_AUTOR
            (
                ACTIVO,
                FECHA_CREACION,
                FECHA_ACTUALIZACION,
                ID_LIBRO,
                ID_AUTOR
            )
            VALUES
            (
                %d,
                '%s',
                '%s',
                %d,
                %d
            );
            """.formatted(

                relacion.getActivo() ? 1 : 0,

                relacion.getFechaCreacion()
                        .format(FORMATTER),

                relacion.getFechaActualizacion()
                        .format(FORMATTER),

                relacion.getLibro()
                        .getSequence(),

                relacion.getAutor()
                        .getSequence());

    }

}