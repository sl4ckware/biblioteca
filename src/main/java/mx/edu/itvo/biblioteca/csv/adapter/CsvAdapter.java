package mx.edu.itvo.biblioteca.csv.adapter;

import java.util.List;

/**
 * Contrato para los adaptadores CSV.
 *
 * Cada adaptador conoce cómo convertir
 * un tipo de objeto del sistema en una
 * representación tabular para un archivo CSV.
 *
 * @param <T> Tipo de dato.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface CsvAdapter<T> {

    /**
     * Devuelve los encabezados
     * del archivo CSV.
     *
     * @return Encabezados.
     */
    String[] headers();

    /**
     * Convierte una colección
     * de objetos a filas CSV.
     *
     * @param datos Datos.
     * @return Filas.
     */
    List<List<String>> rows(List<T> datos);

}