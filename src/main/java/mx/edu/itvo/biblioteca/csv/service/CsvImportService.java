package mx.edu.itvo.biblioteca.csv.service;

import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Servicio para la importación
 * de información desde archivos CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface CsvImportService {

    /**
     * Importa libros.
     *
     * @param archivo Archivo CSV.
     * @return Resultado.
     */
    ImportacionReporteDTO
    importarLibros(
            MultipartFile archivo);

    /**
     * Importa editoriales.
     *
     * @param archivo Archivo CSV.
     * @return Resultado.
     */
    ImportacionReporteDTO
    importarEditoriales(
            MultipartFile archivo);

    /**
     * Importa categorías.
     *
     * @param archivo Archivo CSV.
     * @return Resultado.
     */
    ImportacionReporteDTO
    importarCategorias(
            MultipartFile archivo);

}