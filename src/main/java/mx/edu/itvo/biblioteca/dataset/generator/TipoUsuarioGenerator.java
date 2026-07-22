package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.TipoUsuarioCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.TipoUsuarioData;

/**
 * Genera los registros correspondientes a la tabla
 * tipo_usuario.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class TipoUsuarioGenerator {

    /**
     * Constructor privado.
     */
    private TipoUsuarioGenerator() {
    }

    /**
     * Genera el catálogo de tipos de usuario.
     *
     * @return Lista de tipos de usuario.
     */
    public static List<TipoUsuarioData> generar() {

        List<TipoUsuarioData> tipos =
                new ArrayList<>();

        int sequence = 1;

        for (TipoUsuarioCatalog.TipoUsuarioItem item
                : TipoUsuarioCatalog.ITEMS) {

            TipoUsuarioData tipo =
                    DataFactory.createTipoUsuario();

            tipo.setSequence(
                    sequence++);

            tipo.setNombre(
                    item.nombre());

            tipo.setDescripcion(
                    item.descripcion());

            tipos.add(
                    tipo);

        }

        return tipos;

    }

}