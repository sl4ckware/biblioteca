package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.CategoriaCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.CategoriaData;

/**
 * Genera los registros correspondientes a la tabla categoria.
 *
 * <p>
 * Esta clase transforma la información del {@link CategoriaCatalog}
 * en objetos {@link CategoriaData}, los cuales posteriormente serán
 * utilizados por el SqlWriter para construir el archivo SQL.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since 1.0
 */
public final class CategoriaGenerator {

    /**
     * Constructor privado.
     */
    private CategoriaGenerator() {
    }

    /**
     * Genera el catálogo de categorías.
     *
     * @return Lista de categorías.
     */
    public static List<CategoriaData> generar() {

        List<CategoriaData> categorias =
                new ArrayList<>();

        int sequence = 1;

        for (CategoriaCatalog.CategoriaItem item
                : CategoriaCatalog.getItems()) {

            CategoriaData categoria =
                    DataFactory.createCategoria();

            categoria.setSequence(
                    sequence++);

            categoria.setCodigo(
                    item.codigo());

            categoria.setNombre(
                    item.nombre());

            categoria.setDescripcion(
                    item.descripcion());

            categorias.add(
                    categoria);

        }

        return categorias;

    }

}