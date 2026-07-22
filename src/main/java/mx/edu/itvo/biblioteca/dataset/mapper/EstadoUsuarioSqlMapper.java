package mx.edu.itvo.biblioteca.dataset.mapper;

import mx.edu.itvo.biblioteca.dataset.model.EstadoUsuarioData;

/**
 * Convierte un EstadoUsuarioData en una sentencia SQL INSERT.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoUsuarioSqlMapper {

    /**
     * Constructor privado.
     */
    private EstadoUsuarioSqlMapper() {
    }

    /**
     * Convierte un estado de usuario en una sentencia SQL.
     *
     * @param estado Estado de usuario.
     * @return Sentencia SQL.
     */
    public static String toSql(
            EstadoUsuarioData estado) {

        StringBuilder sql =
                new StringBuilder();

        sql.append("INSERT INTO estado_usuario (");

        sql.append(
                "nombre, descripcion, "
                + "fecha_creacion, fecha_actualizacion");

        sql.append(") VALUES (");

        sql.append("'")
                .append(
                        escape(
                                estado.getNombre()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                estado.getDescripcion()))
                .append("', ");

        sql.append("'")
                .append(
                        estado.getFechaCreacion())
                .append("', ");

        sql.append("'")
                .append(
                        estado.getFechaActualizacion())
                .append("'");

        sql.append(");");

        return sql.toString();

    }

    /**
     * Escapa comillas simples.
     *
     * @param texto Texto original.
     * @return Texto escapado.
     */
    private static String escape(
            String texto) {

        if (texto == null) {

            return "";

        }

        return texto.replace(
                "'",
                "''");

    }

}