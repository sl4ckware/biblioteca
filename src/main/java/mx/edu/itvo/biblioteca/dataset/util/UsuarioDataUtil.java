package mx.edu.itvo.biblioteca.dataset.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Utilería para la generación de datos de usuarios.
 *
 * <p>
 * Centraliza la creación de matrículas, correos y teléfonos
 * utilizados por el Dataset Generator.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class UsuarioDataUtil {

    /**
     * Prefijo utilizado para las matrículas.
     */
    private static final String MATRICULA_PREFIX = "A";

    /**
     * Constructor privado.
     */
    private UsuarioDataUtil() {
    }

    /**
     * Genera una matrícula institucional.
     *
     * <p>
     * Formato:
     *
     * <pre>
     * A240001
     * </pre>
     *
     * </p>
     *
     * @param sequence Consecutivo.
     * @return Matrícula.
     */
    public static String generateMatricula(
            long sequence) {

        return MATRICULA_PREFIX
                + "24"
                + String.format(
                        "%04d",
                        sequence);

    }

    /**
     * Genera un correo institucional.
     *
     * @param matricula Matrícula.
     * @return Correo.
     */
    public static String generateCorreo(
            String matricula) {

        return matricula.toLowerCase()
                + "@alumno.itvo.edu.mx";

    }

    /**
     * Genera un número telefónico mexicano.
     *
     * @return Teléfono.
     */
    public static String generateTelefono() {

        ThreadLocalRandom random =
                ThreadLocalRandom.current();

        StringBuilder telefono =
                new StringBuilder("951");

        for (int i = 0; i < 7; i++) {

            telefono.append(
                    random.nextInt(10));

        }

        return telefono.toString();

    }

}