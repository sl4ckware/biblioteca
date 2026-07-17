package mx.edu.itvo.biblioteca.csv.util;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;

/**
 * Adaptador para convertir
 * libros a filas CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public final class LibroCsvAdapter {

    /**
     * Constructor privado.
     */
    private LibroCsvAdapter() {
    }

    /**
     * Encabezados del CSV.
     *
     * @return Encabezados.
     */
    public static String[] headers() {

        return new String[]{

                "ID",
                "ISBN-13",
                "Título",
                "Categoría",
                "Editorial",
                "Idioma"

        };

    }

    /**
     * Convierte la colección
     * de libros en filas CSV.
     *
     * @param libros Lista.
     * @return Filas.
     */
    public static List<List<String>> rows(
            List<LibroResponseDTO> libros) {

        List<List<String>> rows =
                new ArrayList<>();

        for (LibroResponseDTO libro : libros) {

            List<String> row =
                    new ArrayList<>();

            row.add(
                    String.valueOf(
                            libro.getIdLibro()));

            row.add(
                    libro.getIsbn13());

            row.add(
                    libro.getTitulo());

            row.add(
                    libro.getCategoria());

            row.add(
                    libro.getEditorial());

            row.add(
                    libro.getIdioma());

            rows.add(row);

        }

        return rows;

    }

}