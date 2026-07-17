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

import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;

/**
 * Parser encargado de convertir un archivo CSV
 * en una colección de EditorialRequestDTO.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Component
public class EditorialCsvParser
        implements CsvParser<EditorialRequestDTO> {

    /**
     * Convierte un archivo CSV en una lista
     * de EditorialRequestDTO.
     *
     * @param inputStream Flujo del archivo CSV.
     * @return Lista de editoriales.
     * @throws IOException Error durante la lectura.
     */
    @Override
    public List<EditorialRequestDTO> parse(
            InputStream inputStream)
            throws IOException {

        List<EditorialRequestDTO> editoriales =
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

            EditorialRequestDTO dto =
                    new EditorialRequestDTO();

            dto.setNombre(
                    record.get("Nombre"));

            dto.setPais(
                    record.get("País"));

            dto.setCiudad(
                    record.get("Ciudad"));

            dto.setTelefono(
                    record.get("Teléfono"));

            dto.setCorreo(
                    record.get("Correo"));

            dto.setSitioWeb(
                    record.get("Sitio Web"));

            editoriales.add(dto);

        }

        return editoriales;

    }

}