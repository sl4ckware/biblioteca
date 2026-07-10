package mx.edu.itvo.biblioteca.dataset.mapper;

import java.time.format.DateTimeFormatter;

import mx.edu.itvo.biblioteca.dataset.model.CategoriaData;

/**
 * Convierte objetos {@link CategoriaData} en sentencias SQL.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class CategoriaSqlMapper {

    /**
     * Formato utilizado para fechas DATETIME de MariaDB.
     */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor privado.
     */
    private CategoriaSqlMapper() {

    }

    /**
     * Convierte una categoría en una sentencia INSERT.
     *
     * @param categoria Categoría.
     * @return Sentencia SQL.
     */
    public static String toSql(CategoriaData categoria) {

        return """
                INSERT INTO categoria
                (
                    codigo,
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
                    '%s',
                    %d,
                    '%s',
                    '%s'
                );
                """.formatted(

                escape(categoria.getCodigo()),

                escape(categoria.getNombre()),

                escape(categoria.getDescripcion()),

                categoria.getActivo() ? 1 : 0,

                categoria.getFechaCreacion().format(FORMATTER),

                categoria.getFechaActualizacion().format(FORMATTER));

    }

    /**
     * Escapa comillas simples para SQL.
     *
     * @param value Texto original.
     * @return Texto escapado.
     */
    private static String escape(String value) {

        if (value == null) {
            return "";
        }

        return value.replace("'", "''");

    }

}