package mx.edu.itvo.biblioteca.dataset.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.CategoriaData;
import mx.edu.itvo.biblioteca.dataset.model.EditorialData;
import mx.edu.itvo.biblioteca.dataset.model.IdiomaData;
import mx.edu.itvo.biblioteca.dataset.model.LibroData;
import mx.edu.itvo.biblioteca.dataset.util.BookData;
import mx.edu.itvo.biblioteca.dataset.util.IsbnGenerator;
import mx.edu.itvo.biblioteca.dataset.util.RandomUtil;

/**
 * Genera libros para el Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class LibroGenerator {

    /**
     * Constructor privado.
     */
    private LibroGenerator() {
    }

    /**
     * Genera una colección de libros.
     *
     * @param categorias Categorías disponibles.
     * @param editoriales Editoriales disponibles.
     * @param idiomas Idiomas disponibles.
     *
     * @return Lista de libros.
     */
    public static List<LibroData> generar(
            List<CategoriaData> categorias,
            List<EditorialData> editoriales,
            List<IdiomaData> idiomas) {

        List<LibroData> libros = new ArrayList<>();

        IsbnGenerator.reset();

        for (int i = 1;
                i <= Config.DEFAULT_TOTAL_LIBROS;
                i++) {

            LibroData libro = crearLibro(
                    categorias,
                    editoriales,
                    idiomas);

            libros.add(libro);

        }

        return libros;

    }

    /**
     * Crea un libro aleatorio.
     *
     * @param categorias Categorías.
     * @param editoriales Editoriales.
     * @param idiomas Idiomas.
     *
     * @return Libro generado.
     */
    private static LibroData crearLibro(
            List<CategoriaData> categorias,
            List<EditorialData> editoriales,
            List<IdiomaData> idiomas) {

        LibroData libro =
                DataFactory.createLibro();

        libro.setIsbn13(
                IsbnGenerator.generar());

        libro.setTitulo(
                BookData.randomTitulo());

        libro.setSubtitulo(
                BookData.randomSubtitulo());

        libro.setNumeroEdicion(
                (byte) RandomUtil.nextInt(
                        1,
                        8));

        libro.setFechaPublicacion(
                generarFecha());

        libro.setNumeroPaginas(
                (short) RandomUtil.nextInt(
                        120,
                        900));

        libro.setClasificacion(
                BookData.randomClasificacion());

        libro.setSinopsis(
                BookData.randomSinopsis());

        libro.setImagenPortada(
                BookData.randomPortada());

        libro.setCategoria(
                RandomUtil.randomElement(
                        categorias));

        libro.setEditorial(
                RandomUtil.randomElement(
                        editoriales));

        libro.setIdioma(
                RandomUtil.randomElement(
                        idiomas));

        return libro;

    }

    /**
     * Genera una fecha de publicación.
     *
     * @return Fecha.
     */
    private static LocalDate generarFecha() {

        return LocalDate.of(

                RandomUtil.nextInt(
                        1995,
                        LocalDate.now().getYear()),

                RandomUtil.nextInt(
                        1,
                        12),

                RandomUtil.nextInt(
                        1,
                        28));

    }

}