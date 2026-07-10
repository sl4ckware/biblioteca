package mx.edu.itvo.biblioteca.dataset.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Utilidad para generar fechas utilizadas por el Dataset Generator.
 *
 * Centraliza toda la generación de fechas para mantener consistencia
 * entre los diferentes generadores.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class DateUtil {

    /**
     * Constructor privado.
     */
    private DateUtil() {
    }

    /**
     * Obtiene la fecha y hora actual.
     *
     * @return Fecha y hora actual.
     */
    public static LocalDateTime now() {

        return LocalDateTime.now();

    }

    /**
     * Genera una fecha de publicación aleatoria.
     *
     * @return Fecha entre 1998 y 2026.
     */
    public static LocalDate randomPublicationDate() {

        return LocalDate.of(
                RandomUtil.nextInt(1998, 2026),
                RandomUtil.nextInt(1, 12),
                RandomUtil.nextInt(1, 28));

    }

    /**
     * Genera una fecha de nacimiento aleatoria.
     *
     * @return Fecha entre 1950 y 2000.
     */
    public static LocalDate randomBirthDate() {

        return LocalDate.of(
                RandomUtil.nextInt(1950, 2000),
                RandomUtil.nextInt(1, 12),
                RandomUtil.nextInt(1, 28));

    }

}