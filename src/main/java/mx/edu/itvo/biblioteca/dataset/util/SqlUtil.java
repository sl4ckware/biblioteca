package mx.edu.itvo.biblioteca.dataset.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Proporciona métodos utilitarios para construir sentencias SQL.
 *
 * <p>
 * Centraliza la conversión de tipos Java a representaciones SQL,
 * evitando duplicación de código en los distintos SqlMapper.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class SqlUtil {

    /**
     * Constructor privado.
     */
    private SqlUtil() {
    }

    /**
     * Convierte un texto a un literal SQL.
     *
     * @param valor Texto.
     * @return Literal SQL.
     */
    public static String string(
            String valor) {

        if (valor == null) {
            return "NULL";
        }

        return "'"
                + escape(valor)
                + "'";

    }

    /**
     * Convierte un booleano a su representación SQL.
     *
     * @param valor Valor booleano.
     * @return 1 o 0.
     */
    public static String booleanValue(
            Boolean valor) {

        return Boolean.TRUE.equals(valor)
                ? "1"
                : "0";

    }

    /**
     * Convierte una fecha a un literal SQL.
     *
     * @param fecha Fecha.
     * @return Literal SQL.
     */
    public static String date(
            LocalDate fecha) {

        if (fecha == null) {
            return "NULL";
        }

        return "'"
                + fecha
                + "'";

    }

    /**
     * Convierte una fecha y hora a un literal SQL.
     *
     * @param fecha Fecha y hora.
     * @return Literal SQL.
     */
    public static String dateTime(
            LocalDateTime fecha) {

        if (fecha == null) {
            return "NULL";
        }

        return "'"
                + fecha
                + "'";

    }

    /**
     * Escapa comillas simples.
     *
     * @param texto Texto.
     * @return Texto escapado.
     */
    public static String escape(
            String texto) {

        if (texto == null) {
            return "";
        }

        return texto.replace(
                "'",
                "''");

    }

}