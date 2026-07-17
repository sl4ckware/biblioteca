package mx.edu.itvo.biblioteca.dataset;

import java.io.IOException;

import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.generator.AutorGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.CategoriaGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.EditorialGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.IdiomaGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.LibroAutorGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.LibroGenerator;
import mx.edu.itvo.biblioteca.dataset.mapper.AutorSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.CategoriaSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.EditorialSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.IdiomaSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.LibroAutorSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.LibroSqlMapper;
import mx.edu.itvo.biblioteca.dataset.writer.SqlWriter;

/**
 * Punto de entrada del Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class DatasetRunner {

    /**
     * Punto de entrada del Dataset Generator.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        System.out.println("-------------------------------------");
        System.out.println(" Biblioteca Dataset Generator");
        System.out.println("-------------------------------------");

        try {

            /*
             * ==========================================
             * Categorías
             * ==========================================
             */
            var categorias =
                    CategoriaGenerator.generar();

            SqlWriter.write(
                    Config.FILE_CATEGORIAS,
                    categorias,
                    CategoriaSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Categorías generadas: "
                    + categorias.size());

            /*
             * ==========================================
             * Editoriales
             * ==========================================
             */
            var editoriales =
                    EditorialGenerator.generar();

            SqlWriter.write(
                    Config.FILE_EDITORIALES,
                    editoriales,
                    EditorialSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Editoriales generadas: "
                    + editoriales.size());

            /*
             * ==========================================
             * Idiomas
             * ==========================================
             */
            var idiomas =
                    IdiomaGenerator.generar();

            SqlWriter.write(
                    Config.FILE_IDIOMAS,
                    idiomas,
                    IdiomaSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Idiomas generados: "
                    + idiomas.size());

            /*
             * ==========================================
             * Autores
             * ==========================================
             */
            var autores =
                    AutorGenerator.generar();

            SqlWriter.write(
                    Config.FILE_AUTORES,
                    autores,
                    AutorSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Autores generados: "
                    + autores.size());

            /*
             * ==========================================
             * Libros
             * ==========================================
             */
            var libros =
                    LibroGenerator.generar(
                            categorias,
                            editoriales,
                            idiomas);

            SqlWriter.write(
                    Config.FILE_LIBROS,
                    libros,
                    LibroSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Libros generados: "
                    + libros.size());

            /*
             * ==========================================
             * Libro - Autor
             * ==========================================
             */
            var libroAutores =
                    LibroAutorGenerator.generar(
                            libros,
                            autores);

            SqlWriter.write(
                    Config.FILE_LIBRO_AUTOR,
                    libroAutores,
                    LibroAutorSqlMapper::toSql);

            System.out.println();
            System.out.println(
                    "Relaciones Libro-Autor generadas: "
                    + libroAutores.size());

            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println(
                    "Proceso finalizado correctamente.");
            System.out.println("-------------------------------------");

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}