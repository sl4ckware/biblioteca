package mx.edu.itvo.biblioteca.csv.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * Utilidades para exportación
 * de archivos CSV.
 *
 * Centraliza la escritura de
 * archivos CSV para los distintos
 * módulos del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public final class CsvUtils {

    /**
     * Constructor privado.
     */
    private CsvUtils() {
    }

    /**
     * Exporta una colección de datos
     * a un arreglo de bytes en formato CSV.
     *
     * @param headers Encabezados.
     * @param rows Filas.
     * @return Archivo CSV.
     * @throws IOException Error de escritura.
     */
    public static byte[] exportar(

            String[] headers,

            List<List<String>> rows)

            throws IOException {

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        Writer writer =
                new OutputStreamWriter(
                        outputStream,
                        StandardCharsets.UTF_8);

        CSVPrinter printer =
                new CSVPrinter(
                        writer,
                        CSVFormat.DEFAULT);

        /*
         * Encabezados
         */
        printer.printRecord(
                (Object[]) headers);

        /*
         * Registros
         */
        for (List<String> row : rows) {

            printer.printRecord(row);

        }

        printer.flush();

        return outputStream.toByteArray();

    }

}