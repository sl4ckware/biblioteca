package mx.edu.itvo.biblioteca.dataset.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EjemplarData;
import mx.edu.itvo.biblioteca.dataset.model.EstadoEjemplarData;
import mx.edu.itvo.biblioteca.dataset.model.LibroData;
import mx.edu.itvo.biblioteca.dataset.util.CodeGeneratorUtil;
import mx.edu.itvo.biblioteca.dataset.util.RandomUtil;

/**
 * Genera los ejemplares físicos de los libros.
 *
 * <p>
 * Cada libro puede tener entre un mínimo y un máximo de ejemplares
 * configurables mediante {@link Config}.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class EjemplarGenerator {

    /**
     * Constructor privado.
     */
    private EjemplarGenerator() {
    }

    /**
     * Genera los ejemplares físicos.
     *
     * @param libros Lista de libros.
     * @param estadoDisponible Estado disponible.
     * @return Lista de ejemplares.
     */
    public static List<EjemplarData> generar(
            List<LibroData> libros,
            EstadoEjemplarData estadoDisponible) {

        List<EjemplarData> ejemplares =
                new ArrayList<>();

        int consecutivo = 1;

        for (LibroData libro : libros) {

            int cantidad =
                    RandomUtil.nextInt(
                            Config.DEFAULT_MIN_EJEMPLARES_POR_LIBRO,
                            Config.DEFAULT_MAX_EJEMPLARES_POR_LIBRO);

            for (int numero = 1;
                    numero <= cantidad;
                    numero++) {

                EjemplarData ejemplar =
                        DataFactory.createEjemplar();

                ejemplar.setCodigoInventario(

                        CodeGeneratorUtil.generateCode(

                                Config.INVENTORY_PREFIX,

                                consecutivo++));

                ejemplar.setLibro(
                        libro);

                ejemplar.setEstado(
                        estadoDisponible);

                ejemplar.setFechaAlta(
                        LocalDate.now());

                ejemplar.setUbicacion(
                        "Biblioteca General");

                ejemplar.setObservaciones(
                        null);

                ejemplares.add(
                        ejemplar);

            }

        }

        return ejemplares;

    }

}