package mx.edu.itvo.biblioteca.xml.service;

import java.io.ByteArrayInputStream;

/**
 * Servicio encargado de exportar
 * información en formato XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface XmlExportService {

    /**
     * Exporta el catálogo de libros.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarLibros();

    /**
     * Exporta el catálogo de editoriales.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarEditoriales();

    /**
     * Exporta el catálogo de categorías.
     *
     * @return Archivo XML.
     */
    ByteArrayInputStream exportarCategorias();

}