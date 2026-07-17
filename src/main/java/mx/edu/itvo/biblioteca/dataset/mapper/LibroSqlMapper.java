package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.LibroData;

/**
 * Convierte un libro del Dataset en una sentencia SQL.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class LibroSqlMapper {

    /**
     * Formato para fechas y horas.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(
                    "yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private LibroSqlMapper() {
    }

    /**
     * Convierte un libro en una sentencia INSERT.
     *
     * @param libro Libro.
     * @return Sentencia SQL.
     */
    public static String toSql(
            LibroData libro) {

        return """
            INSERT INTO LIBRO
            (
                ISBN13,
                TITULO,
                SUBTITULO,
                NUMERO_EDICION,
                FECHA_PUBLICACION,
                NUMERO_PAGINAS,
                CLASIFICACION,
                SINOPSIS,
                IMAGEN_PORTADA,
                ACTIVO,
                FECHA_CREACION,
                FECHA_ACTUALIZACION,
                ID_EDITORIAL,
                ID_CATEGORIA,
                ID_IDIOMA
            )
            VALUES
            (
                '%s',
                '%s',
                '%s',
                %d,
                '%s',
                %d,
                '%s',
                '%s',
                '%s',
                %d,
                '%s',
                '%s',
                %d,
                %d,
                %d
            );
            """.formatted(

                escape(libro.getIsbn13()),

                escape(libro.getTitulo()),

                escape(libro.getSubtitulo()),

                libro.getNumeroEdicion(),

                libro.getFechaPublicacion(),

                libro.getNumeroPaginas(),

                escape(libro.getClasificacion()),

                escape(libro.getSinopsis()),

                escape(libro.getImagenPortada()),

                libro.getActivo() ? 1 : 0,

                libro.getFechaCreacion()
                        .format(FORMATTER),

                libro.getFechaActualizacion()
                        .format(FORMATTER),

                libro.getEditorial()
                        .getSequence(),

                libro.getCategoria()
                        .getSequence(),

                libro.getIdioma()
                        .getSequence());

    }

    /**
     * Escapa comillas simples.
     *
     * @param value Valor.
     * @return Valor escapado.
     */
    private static String escape(
            String value) {

        if (value == null) {
            return "";
        }

        return value.replace("'", "''");

    }

}