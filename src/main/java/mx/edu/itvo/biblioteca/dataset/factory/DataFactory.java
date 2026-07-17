package mx.edu.itvo.biblioteca.dataset.factory;

import mx.edu.itvo.biblioteca.dataset.model.AbstractData;
import mx.edu.itvo.biblioteca.dataset.model.AutorData;
import mx.edu.itvo.biblioteca.dataset.model.CategoriaData;
import mx.edu.itvo.biblioteca.dataset.model.EditorialData;
import mx.edu.itvo.biblioteca.dataset.model.IdiomaData;
import mx.edu.itvo.biblioteca.dataset.model.LibroAutorData;
import mx.edu.itvo.biblioteca.dataset.model.LibroData;
import mx.edu.itvo.biblioteca.dataset.util.DateUtil;

/**
 * Fábrica de modelos utilizados por el Dataset Generator.
 *
 * Se encarga de inicializar los atributos comunes compartidos por
 * todos los registros del dataset.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class DataFactory {

    /**
     * Constructor privado.
     */
    private DataFactory() {
    }

    /**
     * Inicializa los atributos comunes de un modelo del dataset.
     *
     * @param <T> Tipo del modelo.
     * @param data Modelo a inicializar.
     * @return Modelo inicializado.
     */
    private static <T extends AbstractData> T initialize(T data) {

        data.setActivo(Boolean.TRUE);
        data.setFechaCreacion(DateUtil.now());
        data.setFechaActualizacion(DateUtil.now());

        return data;

    }

    /**
     * Crea una categoría inicializada.
     *
     * @return Categoría.
     */
    public static CategoriaData createCategoria() {

        return initialize(new CategoriaData());

    }

    /**
     * Crea una editorial inicializada.
     *
     * @return Editorial.
     */
    public static EditorialData createEditorial() {

        return initialize(new EditorialData());

    }

    /**
     * Crea un idioma inicializado.
     *
     * @return Idioma.
     */
    public static IdiomaData createIdioma() {

        return initialize(new IdiomaData());

    }

    /**
     * Crea un autor inicializado.
     *
     * @return Autor.
     */
    public static AutorData createAutor() {

        return initialize(new AutorData());

    }

    /**
     * Crea un libro inicializado.
     *
     * @return Libro.
     */
    public static LibroData createLibro() {

        return initialize(new LibroData());

    }

    /**
     * Crea una relación Libro-Autor inicializada.
     *
     * @return Relación Libro-Autor.
     */
    public static LibroAutorData createLibroAutor() {

        return initialize(new LibroAutorData());

    }

}