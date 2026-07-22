package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.EstadoEjemplarCatalog;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EstadoEjemplarData;

/**
 * Genera los registros correspondientes a la tabla
 * estado_ejemplar.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class EstadoEjemplarGenerator {

    /**
     * Constructor privado.
     */
    private EstadoEjemplarGenerator() {
    }

    /**
     * Genera el catálogo de estados de ejemplar.
     *
     * @return Lista de estados.
     */
    public static List<EstadoEjemplarData> generar() {

        List<EstadoEjemplarData> estados =
                new ArrayList<>();

        int sequence = 1;

        for (EstadoEjemplarCatalog.EstadoEjemplarItem item
                : EstadoEjemplarCatalog.ITEMS) {

            EstadoEjemplarData estado =
                    DataFactory.createEstadoEjemplar();

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