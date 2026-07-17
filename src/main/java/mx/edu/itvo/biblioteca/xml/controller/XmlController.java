package mx.edu.itvo.biblioteca.xml.controller;

import java.io.ByteArrayInputStream;

import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

import mx.edu.itvo.biblioteca.xml.facade.XmlFacade;

/**
 * Controlador para las operaciones
 * de importación y exportación XML.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/xml")
public class XmlController {

    /**
     * Fachada XML.
     */
    private final XmlFacade xmlFacade;

    /**
     * Constructor.
     *
     * @param xmlFacade Fachada XML.
     */
    public XmlController(
            XmlFacade xmlFacade) {

        this.xmlFacade = xmlFacade;

    }
    
    /**
     * Exporta los libros en formato XML.
     *
     * @return Archivo XML.
     */
    @GetMapping(
            "/exportar/libros")
    public ResponseEntity<InputStreamResource>
            exportarLibros() {

        return construirRespuesta(

                xmlFacade.exportarLibros(),

                "libros.xml"

        );

    }

    /**
     * Exporta las editoriales en formato XML.
     *
     * @return Archivo XML.
     */
    @GetMapping(
            "/exportar/editoriales")
    public ResponseEntity<InputStreamResource>
            exportarEditoriales() {

        return construirRespuesta(

                xmlFacade.exportarEditoriales(),

                "editoriales.xml"

        );

    }

    /**
     * Exporta las categorías en formato XML.
     *
     * @return Archivo XML.
     */
    @GetMapping(
            "/exportar/categorias")
    public ResponseEntity<InputStreamResource>
            exportarCategorias() {

        return construirRespuesta(

                xmlFacade.exportarCategorias(),

                "categorias.xml"

        );

    }
    
    /**
     * Importa libros desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    @PostMapping(
            value = "/importar/libros",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImportacionReporteDTO>
            importarLibros(
                    @RequestParam("archivo")
                    MultipartFile archivo) {

        return construirRespuestaImportacion(

                xmlFacade.importarLibros(
                        archivo)

        );

    }

    /**
     * Importa editoriales desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    @PostMapping(
            value = "/importar/editoriales",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImportacionReporteDTO>
            importarEditoriales(
                    @RequestParam("archivo")
                    MultipartFile archivo) {

        return construirRespuestaImportacion(

                xmlFacade.importarEditoriales(
                        archivo)

        );

    }

    /**
     * Importa categorías desde un archivo XML.
     *
     * @param archivo Archivo XML.
     * @return Reporte de importación.
     */
    @PostMapping(
            value = "/importar/categorias",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImportacionReporteDTO>
            importarCategorias(
                    @RequestParam("archivo")
                    MultipartFile archivo) {

        return construirRespuestaImportacion(

                xmlFacade.importarCategorias(
                        archivo)

        );

    }
            
    /**
     * Construye la respuesta para
     * la descarga de un archivo XML.
     *
     * @param input Archivo XML.
     * @param nombreArchivo Nombre del archivo.
     * @return Respuesta HTTP.
     */
    private ResponseEntity<InputStreamResource>
            construirRespuesta(
                    ByteArrayInputStream input,
                    String nombreArchivo) {

        InputStreamResource resource =
                new InputStreamResource(
                        input);

        return ResponseEntity
                .ok()
                .header(

                        HttpHeaders.CONTENT_DISPOSITION,

                        "attachment; filename="
                                + nombreArchivo

                )
                .contentType(
                        MediaType.APPLICATION_XML)
                .body(resource);

    }

    /**
     * Construye la respuesta para
     * una importación XML.
     *
     * @param reporte Reporte generado.
     * @return Respuesta HTTP.
     */
    private ResponseEntity<ImportacionReporteDTO>
            construirRespuestaImportacion(
                    ImportacionReporteDTO reporte) {

        return ResponseEntity
                .ok(reporte);

    }

}