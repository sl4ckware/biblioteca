package mx.edu.itvo.biblioteca.dataset;

import java.io.IOException;

import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.generator.CategoriaGenerator;
import mx.edu.itvo.biblioteca.dataset.mapper.CategoriaSqlMapper;
import mx.edu.itvo.biblioteca.dataset.writer.SqlWriter;

/**
 * Punto de entrada del Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 */
public class DatasetRunner {

    public static void main(String[] args) {

        System.out.println("-------------------------------------");
        System.out.println(" Biblioteca Dataset Generator");
        System.out.println("-------------------------------------");

        try {

            var categorias =
                    CategoriaGenerator.generar();

            SqlWriter.write(

                    Config.FILE_CATEGORIAS,

                    categorias,

                    CategoriaSqlMapper::toSql);

            System.out.println();

            System.out.println("Categorías generadas: "
                    + categorias.size());

            System.out.println("Proceso finalizado correctamente.");

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}