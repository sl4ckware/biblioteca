package mx.edu.itvo.biblioteca.dataset.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;

/**
 * Escribe archivos SQL generados por el Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class SqlWriter {

    /**
     * Constructor privado.
     */
    private SqlWriter() {
    }

    /**
     * Escribe un archivo SQL.
     *
     * @param <T> Tipo de dato.
     * @param fileName Nombre del archivo.
     * @param data Datos.
     * @param mapper Conversor a SQL.
     * @throws IOException Si ocurre un error de escritura.
     */
    public static <T> void write(
            String fileName,
            List<T> data,
            SqlMapper<T> mapper)
            throws IOException {

        Path outputDirectory =
                Path.of(Config.OUTPUT_DIRECTORY);

        Files.createDirectories(outputDirectory);

        Path file =
                outputDirectory.resolve(fileName);

        StringBuilder builder = new StringBuilder();

        for (T item : data) {

            builder.append(mapper.toSql(item))
                   .append(System.lineSeparator());

        }

        Files.writeString(file, builder.toString());

    }

}