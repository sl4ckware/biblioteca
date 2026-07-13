package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.EditorialCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EditorialData;

/**
 * Generador de editoriales.
 *
 * @author Conce
 * @version 1.0
 */
public final class EditorialGenerator {

    private EditorialGenerator() {
    }

    public static List<EditorialData> generar() {

        List<EditorialData> editoriales =
                new ArrayList<>();

        for (EditorialCatalog.EditorialItem item
                : EditorialCatalog.ITEMS) {

            var editorial = DataFactory.createEditorial();

            editorial.setNombre(item.nombre());
            editorial.setPais(item.pais());
            editorial.setCiudad(item.ciudad());
            editorial.setTelefono(item.telefono());
            editorial.setCorreo(item.correo());
            editorial.setSitioWeb(item.sitioWeb());

            editoriales.add(editorial);

        }

        return editoriales;

    }

}