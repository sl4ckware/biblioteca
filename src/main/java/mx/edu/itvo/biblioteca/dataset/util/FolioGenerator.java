package mx.edu.itvo.biblioteca.util;

import java.time.LocalDate;

/**
 * Utilidad para la generación de folios únicos
 * utilizados por los distintos módulos del sistema.
 *
 * <p>Formato generado:</p>
 *
 * <pre>
 * PRE-2026-000001
 * MUL-2026-000001
 * RES-2026-000001
 * </pre>
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public final class FolioGenerator {

    /**
     * Constructor privado.
     */
    private FolioGenerator() {
    }

    /**
     * Genera un folio utilizando un prefijo
     * y un identificador consecutivo.
     *
     * @param prefijo Prefijo del módulo.
     * @param id Identificador del registro.
     * @return Folio generado.
     */
    public static String generar(
            String prefijo,
            Integer id) {

        return String.format(
                "%s-%d-%06d",
                prefijo,
                LocalDate.now().getYear(),
                id);

    }

}