package mx.edu.itvo.biblioteca.xml.facade;

import java.io.ByteArrayInputStream;

import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Fachada para las operaciones
 * de exportación e importación XML.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public interface XmlFacade {

    /**
     * Exporta los libros.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarLibros();

    /**
     * Exporta las editoriales.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarEditoriales();

    /**
     * Exporta las categorías.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarCategorias();

    /**
     * Importa libros desde XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    ImportacionReporteDTO importarLibros(
            MultipartFile archivo);

    /**
     * Importa editoriales desde XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    ImportacionReporteDTO importarEditoriales(
            MultipartFile archivo);

    /**
     * Importa categorías desde XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    ImportacionReporteDTO importarCategorias(
            MultipartFile archivo);

}