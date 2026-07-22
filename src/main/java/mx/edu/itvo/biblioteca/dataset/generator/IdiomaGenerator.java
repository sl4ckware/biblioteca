package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.IdiomaCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.IdiomaData;

/**
 * Genera los registros correspondientes a la tabla idioma.
 *
 * <p>
 * Esta clase transforma la información del {@link IdiomaCatalog}
 * en objetos {@link IdiomaData}, los cuales posteriormente serán
 * utilizados por el SqlWriter para construir el archivo SQL.
 * </p>
 *
 * @author Conce
 * @version 3.0
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

        int sequence = 1;

        for (IdiomaCatalog.IdiomaItem item
                : IdiomaCatalog.getItems()) {

            IdiomaData idioma =
                    DataFactory.createIdioma();

            idioma.setSequence(
                    sequence++);

            idioma.setCodigoIso(
                    item.codigoIso());

            idioma.setNombre(
                    item.nombre());

            idiomas.add(
                    idioma);

        }

        return idiomas;

    }

}