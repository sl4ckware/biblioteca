package mx.edu.itvo.biblioteca.csv.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Contrato para los analizadores CSV.
 *
 * Convierte un archivo CSV
 * en una colección de objetos.
 *
 * @param <T> Tipo de dato.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface CsvParser<T> {

    /**
     * Convierte un archivo CSV
     * en una lista de objetos.
     *
     * @param inputStream Flujo del archivo.
     * @return Objetos obtenidos.
     * @throws IOException Error de lectura.
     */
    List<T> parse(
            InputStream inputStream)
            throws IOException;

}