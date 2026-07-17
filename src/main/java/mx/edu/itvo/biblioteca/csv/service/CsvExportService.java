package mx.edu.itvo.biblioteca.csv.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

/**
 * Servicio para la exportación
 * de información en formato CSV.
 *
 * Centraliza las operaciones de
 * exportación de las entidades
 * del Sistema Bibliotecario.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface CsvExportService {

    /**
     * Exporta el catálogo
     * de libros.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource>
    exportarLibros();

    /**
     * Exporta el catálogo
     * de editoriales.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource>
    exportarEditoriales();

    /**
     * Exporta el catálogo
     * de categorías.
     *
     * @return Archivo CSV.
     */
    ResponseEntity<ByteArrayResource>
    exportarCategorias();

}