package mx.edu.itvo.biblioteca.csv.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;

/**
 * Adaptador para la conversión de categorías
 * al formato CSV.
 *
 * Implementa el contrato CsvAdapter para
 * transformar objetos CategoriaResponseDTO
 * en una representación tabular.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Component
public class CategoriaCsvAdapter
        implements CsvAdapter<CategoriaResponseDTO> {

    /**
     * Obtiene los encabezados del archivo CSV.
     *
     * @return Encabezados.
     */
    @Override
    public String[] headers() {

        return new String[]{

                "ID",
                "Código",
                "Nombre",
                "Descripción",
                "Estado"

        };

    }

    /**
     * Convierte la lista de categorías
     * a filas CSV.
     *
     * @param datos Lista de categorías.
     * @return Filas CSV.
     */
    @Override
    public List<List<String>> rows(
            List<CategoriaResponseDTO> datos) {

        List<List<String>> rows =
                new ArrayList<>();

        for (CategoriaResponseDTO categoria : datos) {

            List<String> row =
                    new ArrayList<>();

            row.add(
                    String.valueOf(
                            categoria.getIdCategoria()));

            row.add(
                    categoria.getCodigo());

            row.add(
                    categoria.getNombre());

            row.add(
                    categoria.getDescripcion());

            row.add(
                    Boolean.TRUE.equals(
                            categoria.getActivo())
                            ? "Activa"
                            : "Inactiva");

            rows.add(row);

        }

        return rows;

    }

}