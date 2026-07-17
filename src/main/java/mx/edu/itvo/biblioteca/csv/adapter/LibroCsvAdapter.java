package mx.edu.itvo.biblioteca.csv.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;

/**
 * Adaptador para la conversión de libros
 * al formato CSV.
 *
 * Implementa el contrato CsvAdapter para
 * transformar objetos LibroResponseDTO
 * en una representación tabular.
 *
 * El formato generado es reversible,
 * permitiendo posteriormente importar
 * nuevamente la información al sistema.
 *
 * @author Conce
 * @version 2.1
 * @since 2.0
 */
@Component
public class LibroCsvAdapter
        implements CsvAdapter<LibroResponseDTO> {

    /**
     * Obtiene los encabezados del archivo CSV.
     *
     * @return Encabezados.
     */
    @Override
    public String[] headers() {

        return new String[]{

                "ID",
                "ISBN-13",
                "Título",
                "Subtítulo",
                "Edición",
                "Fecha Publicación",
                "Páginas",
                "Clasificación",
                "Sinopsis",
                "Imagen Portada",

                "ID Categoría",
                "Categoría",

                "ID Editorial",
                "Editorial",

                "ID Idioma",
                "Idioma",

                "Activo"

        };

    }

    /**
     * Convierte la lista de libros
     * a filas CSV.
     *
     * @param datos Lista de libros.
     * @return Filas CSV.
     */
    @Override
    public List<List<String>> rows(
            List<LibroResponseDTO> datos) {

        List<List<String>> rows =
                new ArrayList<>();

        for (LibroResponseDTO libro : datos) {

            List<String> row =
                    new ArrayList<>();

            row.add(String.valueOf(libro.getIdLibro()));

            row.add(libro.getIsbn13());

            row.add(libro.getTitulo());

            row.add(libro.getSubtitulo());

            row.add(
                    libro.getNumeroEdicion() != null
                            ? libro.getNumeroEdicion().toString()
                            : "");

            row.add(
                    libro.getFechaPublicacion() != null
                            ? libro.getFechaPublicacion().toString()
                            : "");

            row.add(
                    libro.getNumeroPaginas() != null
                            ? libro.getNumeroPaginas().toString()
                            : "");

            row.add(libro.getClasificacion());

            row.add(libro.getSinopsis());

            row.add(libro.getImagenPortada());

            row.add(
                    libro.getIdCategoria() != null
                            ? libro.getIdCategoria().toString()
                            : "");

            row.add(libro.getCategoria());

            row.add(
                    libro.getIdEditorial() != null
                            ? libro.getIdEditorial().toString()
                            : "");

            row.add(libro.getEditorial());

            row.add(
                    libro.getIdIdioma() != null
                            ? libro.getIdIdioma().toString()
                            : "");

            row.add(libro.getIdioma());

            row.add(
                    Boolean.TRUE.equals(libro.getActivo())
                            ? "true"
                            : "false");

            rows.add(row);

        }

        return rows;

    }

}