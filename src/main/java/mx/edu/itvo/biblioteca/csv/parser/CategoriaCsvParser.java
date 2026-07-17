package mx.edu.itvo.biblioteca.csv.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;

/**
 * Parser encargado de convertir un archivo CSV
 * en una colección de CategoriaRequestDTO.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Component
public class CategoriaCsvParser
        implements CsvParser<CategoriaRequestDTO> {

    /**
     * Convierte un archivo CSV
     * en una lista de categorías.
     *
     * @param inputStream Archivo CSV.
     * @return Lista de categorías.
     * @throws IOException Error durante la lectura.
     */
    @Override
    public List<CategoriaRequestDTO> parse(
            InputStream inputStream)
            throws IOException {

        List<CategoriaRequestDTO> categorias =
                new ArrayList<>();

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                inputStream,
                                StandardCharsets.UTF_8));

        Iterable<CSVRecord> records =
                CSVFormat.DEFAULT
                        .builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .setTrim(true)
                        .build()
                        .parse(reader);

        for (CSVRecord record : records) {

            CategoriaRequestDTO dto =
                    new CategoriaRequestDTO();

            dto.setCodigo(
                    record.get("Código"));

            dto.setNombre(
                    record.get("Nombre"));

            dto.setDescripcion(
                    record.get("Descripción"));

            categorias.add(dto);

        }

        return categorias;

    }

}