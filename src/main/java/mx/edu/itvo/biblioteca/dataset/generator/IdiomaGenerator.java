package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.IdiomaCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.IdiomaData;

/**
 * Generador de idiomas.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class IdiomaGenerator {

    /**
     * Constructor privado.
     */
    private IdiomaGenerator() {
    }

    /**
     * Genera el catálogo de idiomas.
     *
     * @return Lista de idiomas.
     */
    public static List<IdiomaData> generar() {

        List<IdiomaData> idiomas =
                new ArrayList<>();

        for (IdiomaCatalog.IdiomaItem item
                : IdiomaCatalog.ITEMS) {

            var idioma = DataFactory.createIdioma();

            idioma.setCodigoIso(
                    item.codigoIso());

            idioma.setNombre(
                    item.nombre());

            idiomas.add(idioma);

        }

        return idiomas;

    }

}