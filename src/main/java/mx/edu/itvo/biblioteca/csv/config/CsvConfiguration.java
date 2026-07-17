package mx.edu.itvo.biblioteca.csv.config;

import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración central para la
 * interoperabilidad mediante CSV.
 *
 * Centraliza el formato utilizado
 * para importar y exportar archivos.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Configuration
public class CsvConfiguration {

    /**
     * Charset utilizado por el framework.
     */
    public static final String CHARSET =
            StandardCharsets.UTF_8.name();

    /**
     * Formato CSV estándar.
     *
     * @return Configuración CSV.
     */
    @Bean
    public CSVFormat csvFormat() {

        return CSVFormat.DEFAULT
                .builder()
                .setDelimiter(',')
                .setQuote('"')
                .setIgnoreEmptyLines(true)
                .setTrim(true)
                .setHeader()
                .setSkipHeaderRecord(false)
                .build();

    }

}