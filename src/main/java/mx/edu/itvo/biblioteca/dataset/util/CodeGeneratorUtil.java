package mx.edu.itvo.biblioteca.dataset.util;

/**
 * Genera códigos consecutivos para las entidades del
 * Dataset Generator.
 *
 * <p>
 * Esta clase centraliza el formato de los identificadores
 * utilizados por las distintas entidades del sistema.
 * </p>
 *
 * <p>
 * Ejemplos:
 * </p>
 *
 * <pre>
 * EJ-000001
 * US-000001
 * PR-000001
 * </pre>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class CodeGeneratorUtil {

    /**
     * Constructor privado.
     */
    private CodeGeneratorUtil() {
    }

    /**
     * Genera un código consecutivo.
     *
     * @param prefijo Prefijo del código.
     * @param secuencia Número consecutivo.
     * @return Código generado.
     */
    public static String generateCode(
            String prefijo,
            int secuencia) {

        return String.format(
                "%s-%06d",
                prefijo,
                secuencia);

    }

}