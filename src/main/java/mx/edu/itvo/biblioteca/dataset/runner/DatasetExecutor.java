package mx.edu.itvo.biblioteca.dataset.runner;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

import mx.edu.itvo.biblioteca.dataset.writer.SqlMapper;
import mx.edu.itvo.biblioteca.dataset.writer.SqlWriter;

/**
 * Ejecuta una etapa del Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class DatasetExecutor {

    /**
     * Constructor privado.
     */
    private DatasetExecutor() {
    }

    /**
     * Ejecuta una etapa del Dataset Generator.
     *
     * @param <T> Tipo de dato.
     * @param generator Generador.
     * @param fileName Archivo destino.
     * @param sqlMapper Conversor SQL.
     * @param description Texto mostrado en consola.
     * @return Datos generados.
     * @throws IOException Si ocurre un error.
     */
    public static <T> List<T> execute(
            Supplier<List<T>> generator,
            String fileName,
            SqlMapper<T> sqlMapper,
            String description)
            throws IOException {

        List<T> data =
                generator.get();

        SqlWriter.write(
                fileName,
                data,
                sqlMapper);

        System.out.println();
        System.out.println(
                description
                + data.size());

        return data;

    }

}