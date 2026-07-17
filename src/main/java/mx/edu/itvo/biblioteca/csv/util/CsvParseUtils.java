package mx.edu.itvo.biblioteca.csv.util;

import java.time.LocalDate;

/**
 * Utilidades para la conversión de
 * valores obtenidos desde archivos CSV.
 *
 * Centraliza la conversión de tipos
 * primitivos y objetos para evitar
 * duplicación de código en los parsers.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public final class CsvParseUtils {

    /**
     * Constructor privado.
     */
    private CsvParseUtils() {
    }

    /**
     * Convierte a Integer.
     *
     * @param value Valor.
     * @return Integer o null.
     */
    public static Integer toInteger(String value) {

        return value == null || value.isBlank()
                ? null
                : Integer.valueOf(value);

    }

    /**
     * Convierte a Short.
     *
     * @param value Valor.
     * @return Short o null.
     */
    public static Short toShort(String value) {

        return value == null || value.isBlank()
                ? null
                : Short.valueOf(value);

    }

    /**
     * Convierte a Byte.
     *
     * @param value Valor.
     * @return Byte o null.
     */
    public static Byte toByte(String value) {

        return value == null || value.isBlank()
                ? null
                : Byte.valueOf(value);

    }

    /**
     * Convierte a Boolean.
     *
     * @param value Valor.
     * @return Boolean.
     */
    public static Boolean toBoolean(String value) {

        return value == null || value.isBlank()
                ? Boolean.FALSE
                : Boolean.valueOf(value);

    }

    /**
     * Convierte a LocalDate.
     *
     * @param value Valor.
     * @return LocalDate o null.
     */
    public static LocalDate toLocalDate(
            String value) {

        return value == null || value.isBlank()
                ? null
                : LocalDate.parse(value);

    }

}