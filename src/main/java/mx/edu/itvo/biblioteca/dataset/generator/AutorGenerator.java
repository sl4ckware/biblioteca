package mx.edu.itvo.biblioteca.dataset.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.AutorData;
import mx.edu.itvo.biblioteca.dataset.util.NameData;
import mx.edu.itvo.biblioteca.dataset.util.RandomUtil;

/**
 * Generador de autores.
 *
 * Genera autores aleatorios para el Dataset Generator.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class AutorGenerator {

    /**
     * Constructor privado.
     */
    private AutorGenerator() {
    }

    /**
     * Genera la lista de autores.
     *
     * @return Lista de autores.
     */
    public static List<AutorData> generar() {

        List<AutorData> autores =
                new ArrayList<>();

        for (int i = 0;
                i < Config.DEFAULT_TOTAL_AUTORES;
                i++) {

            AutorData autor =
                    DataFactory.createAutor();

            autor.setNombre(
                    NameData.nombre());

            autor.setApellidoPaterno(
                    NameData.apellido());

            autor.setApellidoMaterno(
                    NameData.apellido());

            autor.setNacionalidad(
                    NameData.nacionalidad());

            autor.setFechaNacimiento(

                    LocalDate.of(

                            RandomUtil.nextInt(
                                    1940,
                                    2005),

                            RandomUtil.nextInt(
                                    1,
                                    12),

                            RandomUtil.nextInt(
                                    1,
                                    28)));

            autores.add(autor);

        }

        return autores;

    }

}