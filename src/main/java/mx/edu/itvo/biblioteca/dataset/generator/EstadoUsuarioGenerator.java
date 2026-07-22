package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.EstadoUsuarioCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EstadoUsuarioData;

/**
 * Genera los registros correspondientes a la tabla
 * estado_usuario.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoUsuarioGenerator {

    /**
     * Constructor privado.
     */
    private EstadoUsuarioGenerator() {
    }

    /**
     * Genera el catálogo de estados de usuario.
     *
     * @return Lista de estados de usuario.
     */
    public static List<EstadoUsuarioData> generar() {

        List<EstadoUsuarioData> estados =
                new ArrayList<>();

        int sequence = 1;

        for (EstadoUsuarioCatalog.EstadoUsuarioItem item
                : EstadoUsuarioCatalog.ITEMS) {

            EstadoUsuarioData estado =
                    DataFactory.createEstadoUsuario();

            estado.setSequence(
                    sequence++);

            estado.setNombre(
                    item.nombre());

            estado.setDescripcion(
                    item.descripcion());

            estados.add(
                    estado);

        }

        return estados;

    }

}