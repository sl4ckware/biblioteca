package mx.edu.itvo.biblioteca.csv.facade;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Fachada del Framework CSV.
 *
 * Centraliza las operaciones de importación
 * y exportación de información en formato CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface CsvFacade {

    /*
     * ==========================================
     * EXPORTACIÓN
     * ==========================================
     */

    /**
     * Exporta el catálogo de libros.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource> exportarLibros();

    /**
     * Exporta el catálogo de editoriales.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource> exportarEditoriales();

    /**
     * Exporta el catálogo de categorías.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource> exportarCategorias();

    /*
     * ==========================================
     * IMPORTACIÓN
     * ==========================================
     */

    /**
     * Importa libros desde un archivo CSV.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarLibros(
            MultipartFile archivo);

    /**
     * Importa editoriales desde un archivo CSV.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarEditoriales(
            MultipartFile archivo);

    /**
     * Importa categorías desde un archivo CSV.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarCategorias(
            MultipartFile archivo);

}