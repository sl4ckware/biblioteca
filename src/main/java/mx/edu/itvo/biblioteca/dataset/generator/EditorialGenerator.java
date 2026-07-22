package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.EditorialCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EditorialData;

/**
 * Genera los registros correspondientes a la tabla editorial.
 *
 * <p>
 * Esta clase transforma la información del {@link EditorialCatalog}
 * en objetos {@link EditorialData}, los cuales posteriormente serán
 * utilizados por el SqlWriter para construir el archivo SQL.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since 1.0
 */
public final class EditorialGenerator {

    /**
     * Constructor privado.
     */
    private EditorialGenerator() {
    }

    /**
     * Genera el catálogo de editoriales.
     *
     * @return Lista de editoriales.
     */
    public static List<EditorialData> generar() {

        List<EditorialData> editoriales =
                new ArrayList<>();

        int sequence = 1;

        for (EditorialCatalog.EditorialItem item
                : EditorialCatalog.getItems()) {

            EditorialData editorial =
                    DataFactory.createEditorial();

            editorial.setSequence(
                    sequence++);

            editorial.setNombre(
                    item.nombre());

            editorial.setPais(
                    item.pais());

            editorial.setCiudad(
                    item.ciudad());

            editorial.setTelefono(
                    item.telefono());

            editorial.setCorreo(
                    item.correo());

            editorial.setSitioWeb(
                    item.sitioWeb());

            editoriales.add(
                    editorial);

        }

        return editoriales;

    }

}