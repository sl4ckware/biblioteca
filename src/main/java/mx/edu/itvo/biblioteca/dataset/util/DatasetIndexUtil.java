package mx.edu.itvo.biblioteca.dataset.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.edu.itvo.biblioteca.dataset.model.EstadoEjemplarData;

/**
 * Proporciona índices para acceso rápido a los datos generados
 * por el Dataset Generator.
 *
 * <p>
 * Convierte listas de modelos en mapas para realizar búsquedas
 * en tiempo constante.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class DatasetIndexUtil {

    /**
     * Constructor privado.
     */
    private DatasetIndexUtil() {
    }

    /**
     * Genera un índice por nombre para los estados de ejemplar.
     *
     * @param estados Lista de estados.
     * @return Índice por nombre.
     */
    public static Map<String, EstadoEjemplarData>
            indexEstadoEjemplar(
                    List<EstadoEjemplarData> estados) {

        Map<String, EstadoEjemplarData> indice =
                new HashMap<>();

        for (EstadoEjemplarData estado : estados) {

            indice.put(
                    estado.getNombre(),
                    estado);

        }

        return indice;

    }

}