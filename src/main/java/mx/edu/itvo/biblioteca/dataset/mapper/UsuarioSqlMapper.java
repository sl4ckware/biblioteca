package mx.edu.itvo.biblioteca.dataset.mapper;

import mx.edu.itvo.biblioteca.dataset.model.UsuarioData;

/**
 * Convierte un UsuarioData en una sentencia SQL INSERT.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class UsuarioSqlMapper {

    /**
     * Constructor privado.
     */
    private UsuarioSqlMapper() {
    }

    /**
     * Convierte un usuario en una sentencia SQL.
     *
     * @param usuario Usuario.
     * @return Sentencia SQL.
     */
    public static String toSql(
            UsuarioData usuario) {

        StringBuilder sql =
                new StringBuilder();

        sql.append("INSERT INTO usuario (");

        sql.append(
                "matricula, ");
        sql.append(
                "nombre, ");
        sql.append(
                "apellido_paterno, ");
        sql.append(
                "apellido_materno, ");
        sql.append(
                "correo, ");
        sql.append(
                "telefono, ");
        sql.append(
                "password, ");
        sql.append(
                "id_tipo_usuario, ");
        sql.append(
                "id_estado_usuario, ");
        sql.append(
                "activo, ");
        sql.append(
                "fecha_creacion, ");
        sql.append(
                "fecha_actualizacion");

        sql.append(") VALUES (");

        sql.append("'")
                .append(
                        escape(
                                usuario.getMatricula()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getNombre()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getApellidoPaterno()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getApellidoMaterno()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getCorreo()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getTelefono()))
                .append("', ");

        sql.append("'")
                .append(
                        escape(
                                usuario.getPassword()))
                .append("', ");

        sql.append(
                usuario.getTipoUsuario()
                        .getSequence());

        sql.append(", ");

        sql.append(
                usuario.getEstadoUsuario()
                        .getSequence());

        sql.append(", ");

        sql.append(
                usuario.getActivo()
                        ? 1
                        : 0);

        sql.append(", '")
                .append(
                        usuario.getFechaCreacion())
                .append("'");

        sql.append(", '")
                .append(
                        usuario.getFechaActualizacion())
                .append("'");

        sql.append(");");

        return sql.toString();

    }

    /**
     * Escapa comillas simples.
     *
     * @param texto Texto.
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