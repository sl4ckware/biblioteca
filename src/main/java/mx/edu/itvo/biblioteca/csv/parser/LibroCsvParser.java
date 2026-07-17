package mx.edu.itvo.biblioteca.csv.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;

/**
 * Parser encargado de convertir
 * un archivo CSV en una colección
 * de LibroRequestDTO.
 *
 * @author Conce
 * @version 2.1
 * @since 2.0
 */
@Component
public class LibroCsvParser
        implements CsvParser<LibroRequestDTO> {

    /**
     * Convierte un archivo CSV
     * en objetos LibroRequestDTO.
     *
     * @param inputStream Archivo CSV.
     * @return Lista de libros.
     * @throws IOException Error de lectura.
     */
    @Override
    public List<LibroRequestDTO> parse(
            InputStream inputStream)
            throws IOException {

        List<LibroRequestDTO> libros =
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

            LibroRequestDTO dto =
                    new LibroRequestDTO();

            dto.setIsbn13(
                    record.get("ISBN-13"));

            dto.setTitulo(
                    record.get("Título"));

            dto.setSubtitulo(
                    record.get("Subtítulo"));

            dto.setNumeroEdicion(
                    Byte.valueOf(
                            record.get("Edición")));

            if (!record.get("Fecha Publicación").isBlank()) {

                dto.setFechaPublicacion(
                        LocalDate.parse(
                                record.get("Fecha Publicación")));

            }

            if (!record.get("Páginas").isBlank()) {

                dto.setNumeroPaginas(
                        Short.valueOf(
                                record.get("Páginas")));

            }

            dto.setClasificacion(
                    record.get("Clasificación"));

            dto.setSinopsis(
                    record.get("Sinopsis"));

            dto.setImagenPortada(
                    record.get("Imagen Portada"));

            dto.setIdCategoria(
                    Integer.valueOf(
                            record.get("ID Categoría")));

            dto.setIdEditorial(
                    Integer.valueOf(
                            record.get("ID Editorial")));

            dto.setIdIdioma(
                    Integer.valueOf(
                            record.get("ID Idioma")));

            if (!record.get("Activo").isBlank()) {

                dto.setActivo(
                        Boolean.valueOf(
                                record.get("Activo")));

            }

            libros.add(dto);

        }

        return libros;

    }

}