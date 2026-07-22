package mx.edu.itvo.biblioteca.dataset.mapper;

import mx.edu.itvo.biblioteca.dataset.model.EjemplarData;
import mx.edu.itvo.biblioteca.dataset.util.SqlUtil;

/**
 * Convierte un EjemplarData en una sentencia SQL INSERT.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
public final class EjemplarSqlMapper {

    /**
     * Constructor privado.
     */
    private EjemplarSqlMapper() {
    }

    /**
     * Convierte un ejemplar en una sentencia SQL.
     *
     * @param ejemplar Ejemplar.
     * @return Sentencia SQL.
     */
    public static String toSql(
            EjemplarData ejemplar) {

        StringBuilder sql =
                new StringBuilder();

        sql.append("INSERT INTO ejemplar (");

        sql.append(
                "codigo_inventario, ");


        sql.append(
                "ubicacion, ");

        sql.append(
                "fecha_alta, ");

        sql.append(
                "observaciones, ");

        sql.append(
                "id_libro, ");

        sql.append(
                "id_estado_ejemplar, ");

        sql.append(
                "activo, ");

        sql.append(
                "fecha_creacion, ");

        sql.append(
                "fecha_actualizacion");

        sql.append(") VALUES (");

        sql.append(
                SqlUtil.string(
                        ejemplar.getCodigoInventario()));

        sql.append(", ");

        sql.append(
                SqlUtil.string(
                        ejemplar.getUbicacion()));

        sql.append(", ");

        sql.append(
                SqlUtil.date(
                        ejemplar.getFechaAlta()));

        sql.append(", ");

        sql.append(
                SqlUtil.string(
                        ejemplar.getObservaciones()));

        sql.append(", ");

        sql.append(
                ejemplar.getLibro()
                        .getSequence());

        sql.append(", ");

        sql.append(
                ejemplar.getEstado()
                        .getSequence());

        sql.append(", ");

        sql.append(
                SqlUtil.booleanValue(
                        ejemplar.getActivo()));

        sql.append(", ");

        sql.append(
                SqlUtil.dateTime(
                        ejemplar.getFechaCreacion()));

        sql.append(", ");

        sql.append(
                SqlUtil.dateTime(
                        ejemplar.getFechaActualizacion()));

        sql.append(");");

        return sql.toString();

    }

}