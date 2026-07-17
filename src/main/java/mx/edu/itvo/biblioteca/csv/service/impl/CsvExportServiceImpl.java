package mx.edu.itvo.biblioteca.csv.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.edu.itvo.biblioteca.csv.adapter.CategoriaCsvAdapter;
import mx.edu.itvo.biblioteca.csv.adapter.EditorialCsvAdapter;
import mx.edu.itvo.biblioteca.csv.adapter.LibroCsvAdapter;
import mx.edu.itvo.biblioteca.csv.service.CsvExportService;
import mx.edu.itvo.biblioteca.csv.util.CsvUtils;
import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;
import mx.edu.itvo.biblioteca.service.CategoriaService;
import mx.edu.itvo.biblioteca.service.EditorialService;
import mx.edu.itvo.biblioteca.service.LibroService;

/**
 * Implementación del servicio de exportación CSV.
 *
 * Centraliza la generación de archivos CSV
 * para los diferentes catálogos del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Service
public class CsvExportServiceImpl
        implements CsvExportService {

    /**
     * Servicio de libros.
     */
    private final LibroService libroService;

    /**
     * Servicio de editoriales.
     */
    private final EditorialService editorialService;

    /**
     * Servicio de categorías.
     */
    private final CategoriaService categoriaService;

    /**
     * Adaptador CSV de libros.
     */
    private final LibroCsvAdapter libroCsvAdapter;

    /**
     * Adaptador CSV de editoriales.
     */
    private final EditorialCsvAdapter editorialCsvAdapter;

    /**
     * Adaptador CSV de categorías.
     */
    private final CategoriaCsvAdapter categoriaCsvAdapter;

    /**
     * Constructor.
     *
     * @param libroService Servicio de libros.
     * @param editorialService Servicio de editoriales.
     * @param categoriaService Servicio de categorías.
     * @param libroCsvAdapter Adaptador de libros.
     * @param editorialCsvAdapter Adaptador de editoriales.
     * @param categoriaCsvAdapter Adaptador de categorías.
     */
    public CsvExportServiceImpl(

            LibroService libroService,

            EditorialService editorialService,

            CategoriaService categoriaService,

            LibroCsvAdapter libroCsvAdapter,

            EditorialCsvAdapter editorialCsvAdapter,

            CategoriaCsvAdapter categoriaCsvAdapter) {

        this.libroService = libroService;
        this.editorialService = editorialService;
        this.categoriaService = categoriaService;

        this.libroCsvAdapter = libroCsvAdapter;
        this.editorialCsvAdapter = editorialCsvAdapter;
        this.categoriaCsvAdapter = categoriaCsvAdapter;

    }

    /**
     * Exporta el catálogo de libros.
     *
     * @return Archivo CSV.
     */
    @Override
    public ResponseEntity<ByteArrayResource>
            exportarLibros() {

        List<LibroResponseDTO> libros =
                libroService.listar();

        return crearRespuestaCsv(

                libroCsvAdapter.headers(),

                libroCsvAdapter.rows(libros),

                "libros.csv"

        );

    }

    /**
     * Exporta el catálogo de editoriales.
     *
     * @return Archivo CSV.
     */
    @Override
    public ResponseEntity<ByteArrayResource>
            exportarEditoriales() {

        List<EditorialResponseDTO> editoriales =
                editorialService.listar();

        return crearRespuestaCsv(

                editorialCsvAdapter.headers(),

                editorialCsvAdapter.rows(editoriales),

                "editoriales.csv"

        );

    }

    /**
     * Exporta el catálogo de categorías.
     *
     * @return Archivo CSV.
     */
    @Override
    public ResponseEntity<ByteArrayResource>
            exportarCategorias() {

        List<CategoriaResponseDTO> categorias =
                categoriaService.listar();

        return crearRespuestaCsv(

                categoriaCsvAdapter.headers(),

                categoriaCsvAdapter.rows(categorias),

                "categorias.csv"

        );

    }

    /**
     * Genera la respuesta HTTP para la descarga
     * de un archivo CSV.
     *
     * @param headers Encabezados.
     * @param rows Filas.
     * @param nombreArchivo Nombre del archivo.
     *
     * @return Archivo CSV descargable.
     */
    private ResponseEntity<ByteArrayResource>
            crearRespuestaCsv(

                    String[] headers,

                    List<List<String>> rows,

                    String nombreArchivo) {

        try {

            byte[] csv =
                    CsvUtils.exportar(
                            headers,
                            rows);

            ByteArrayResource recurso =
                    new ByteArrayResource(csv);

            return ResponseEntity.ok()

                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\""
                                    + nombreArchivo
                                    + "\"")

                    .contentLength(csv.length)

                    .contentType(
                            MediaType.parseMediaType(
                                    "text/csv"))

                    .body(recurso);

        } catch (IOException ex) {

            throw new RuntimeException(

                    "Error al generar el archivo CSV.",

                    ex

            );

        }

    }

}