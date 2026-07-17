package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.AutorData;
import mx.edu.itvo.biblioteca.dataset.model.LibroAutorData;
import mx.edu.itvo.biblioteca.dataset.model.LibroData;
import mx.edu.itvo.biblioteca.dataset.util.RandomUtil;

/**
 * Genera las relaciones entre libros y autores.
 *
 * <p>
 * Cada libro tendrá entre uno y tres autores, evitando relaciones
 * duplicadas para un mismo libro.
 * </p>
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
public final class LibroAutorGenerator {

    /**
     * Constructor privado.
     */
    private LibroAutorGenerator() {
    }

    /**
     * Genera las relaciones Libro-Autor.
     *
     * @param libros Lista de libros.
     * @param autores Lista de autores.
     * @return Relaciones generadas.
     */
    public static List<LibroAutorData> generar(
            List<LibroData> libros,
            List<AutorData> autores) {

        List<LibroAutorData> relaciones =
                new ArrayList<>();

        if (libros == null
                || autores == null
                || autores.isEmpty()) {

            return relaciones;

        }

        for (LibroData libro : libros) {

            int totalAutores =
                    Math.min(
                            RandomUtil.nextInt(1, 3),
                            autores.size());

            Set<Integer> usados =
                    new HashSet<>();

            while (usados.size() < totalAutores) {

                int indice =
                        RandomUtil.nextInt(
                                autores.size());

                if (!usados.add(indice)) {
                    continue;
                }

                AutorData autor =
                        autores.get(indice);

                LibroAutorData relacion =
                        DataFactory.createLibroAutor();

                relacion.setLibro(libro);

                relacion.setAutor(autor);

                relaciones.add(relacion);

            }

        }

        return relaciones;

    }

}