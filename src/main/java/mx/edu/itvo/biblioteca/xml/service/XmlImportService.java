package mx.edu.itvo.biblioteca.xml.service;

import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Servicio para la importación de
 * información desde archivos XML.
 *
 * Define las operaciones necesarias
 * para importar las entidades del
 * sistema utilizando archivos XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface XmlImportService {

    /**
     * Importa libros desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarLibros(
            MultipartFile archivo);

    /**
     * Importa editoriales desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarEditoriales(
            MultipartFile archivo);

    /**
     * Importa categorías desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Resultado de la importación.
     */
    ImportacionReporteDTO importarCategorias(
            MultipartFile archivo);

}