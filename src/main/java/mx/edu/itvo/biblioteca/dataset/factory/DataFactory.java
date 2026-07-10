package mx.edu.itvo.biblioteca.dataset.factory;

import mx.edu.itvo.biblioteca.dataset.model.CategoriaData;
import mx.edu.itvo.biblioteca.dataset.util.DateUtil;

/**
 * Fábrica de modelos utilizados por el Dataset Generator.
 *
 * Se encarga de inicializar los atributos comunes compartidos por
 * todos los registros.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class DataFactory {

    /**
     * Constructor privado.
     */
    private DataFactory() {
    }

    /**
     * Crea una categoría inicializada.
     *
     * @return Categoría.
     */
    public static CategoriaData createCategoria() {

        var categoria = new CategoriaData();

        categoria.setActivo(Boolean.TRUE);
        categoria.setFechaCreacion(DateUtil.now());
        categoria.setFechaActualizacion(DateUtil.now());

        return categoria;

    }

}