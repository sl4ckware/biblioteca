package mx.edu.itvo.biblioteca.csv.facade;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;
import mx.edu.itvo.biblioteca.csv.service.CsvExportService;
import mx.edu.itvo.biblioteca.csv.service.CsvImportService;

/**
 * Implementación de la fachada CSV.
 *
 * Coordina las operaciones de exportación
 * e importación del Framework CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Component
public class CsvFacadeImpl
        implements CsvFacade {

    /**
     * Servicio de exportación.
     */
    private final CsvExportService csvExportService;

    /**
     * Servicio de importación.
     */
    private final CsvImportService csvImportService;

    /**
     * Constructor.
     *
     * @param csvExportService Servicio de exportación.
     * @param csvImportService Servicio de importación.
     */
    public CsvFacadeImpl(
            CsvExportService csvExportService,
            CsvImportService csvImportService) {

        this.csvExportService = csvExportService;
        this.csvImportService = csvImportService;

    }

    /*
     * ==========================================
     * EXPORTACIÓN
     * ==========================================
     */

    @Override
    public ResponseEntity<ByteArrayResource>
            exportarLibros() {

        return csvExportService.exportarLibros();

    }

    @Override
    public ResponseEntity<ByteArrayResource>
            exportarEditoriales() {

        return csvExportService.exportarEditoriales();

    }

    @Override
    public ResponseEntity<ByteArrayResource>
            exportarCategorias() {

        return csvExportService.exportarCategorias();

    }

    /*
     * ==========================================
     * IMPORTACIÓN
     * ==========================================
     */

    @Override
    public ImportacionReporteDTO importarLibros(
            MultipartFile archivo) {

        return csvImportService.importarLibros(archivo);

    }

    @Override
    public ImportacionReporteDTO importarEditoriales(
            MultipartFile archivo) {

        return csvImportService.importarEditoriales(archivo);

    }

    @Override
    public ImportacionReporteDTO importarCategorias(
            MultipartFile archivo) {

        return csvImportService.importarCategorias(archivo);

    }

}