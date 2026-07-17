package mx.edu.itvo.biblioteca.csv.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;

/**
 * Adaptador para la conversión de editoriales
 * al formato CSV.
 *
 * Implementa el contrato CsvAdapter para
 * transformar objetos EditorialResponseDTO
 * en una representación tabular.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Component
public class EditorialCsvAdapter
        implements CsvAdapter<EditorialResponseDTO> {

    /**
     * Obtiene los encabezados del archivo CSV.
     *
     * @return Encabezados.
     */
    @Override
    public String[] headers() {

        return new String[]{

                "ID",
                "Nombre",
                "País",
                "Ciudad",
                "Teléfono",
                "Correo",
                "Sitio Web",
                "Estado"

        };

    }

    /**
     * Convierte la lista de editoriales
     * a filas CSV.
     *
     * @param datos Lista de editoriales.
     * @return Filas CSV.
     */
    @Override
    public List<List<String>> rows(
            List<EditorialResponseDTO> datos) {

        List<List<String>> rows =
                new ArrayList<>();

        for (EditorialResponseDTO editorial : datos) {

            List<String> row =
                    new ArrayList<>();

            row.add(
                    String.valueOf(
                            editorial.getIdEditorial()));

            row.add(
                    editorial.getNombre());

            row.add(
                    editorial.getPais());

            row.add(
                    editorial.getCiudad());

            row.add(
                    editorial.getTelefono());

            row.add(
                    editorial.getCorreo());

            row.add(
                    editorial.getSitioWeb());

            row.add(
                    Boolean.TRUE.equals(
                            editorial.getActivo())
                            ? "Activa"
                            : "Inactiva");

            rows.add(row);

        }

        return rows;

    }

}