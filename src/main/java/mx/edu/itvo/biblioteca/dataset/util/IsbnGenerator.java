package mx.edu.itvo.biblioteca.dataset.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generador de códigos ISBN-13 para el Dataset Generator.
 *
 * <p>
 * Produce identificadores ISBN ficticios y únicos durante
 * la ejecución del Dataset.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class IsbnGenerator {

    /**
     * Prefijo ISBN utilizado por el Dataset.
     */
    private static final String PREFIX = "978030";

    /**
     * Consecutivo interno.
     */
    private static final AtomicInteger SEQUENCE =
            new AtomicInteger(1);

    /**
     * Constructor privado.
     */
    private IsbnGenerator() {
    }

    /**
     * Genera un ISBN-13 ficticio.
     *
     * @return ISBN-13.
     */
    public static String generar() {

        return PREFIX
                + String.format(
                        "%07d",
                        SEQUENCE.getAndIncrement());

    }

    /**
     * Reinicia el consecutivo.
     */
    public static void reset() {

        SEQUENCE.set(1);

    }

}