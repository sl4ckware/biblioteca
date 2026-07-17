package mx.edu.itvo.biblioteca.csv.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import mx.edu.itvo.biblioteca.csv.facade.CsvFacade;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Controlador para la exportación
 * del catálogo de editoriales en
 * formato CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@RestController
@RequestMapping("/api/csv/editoriales")
@Tag(
        name = "📄 CSV - Editoriales",
        description = "Exportación e importación del catálogo de editoriales en formato CSV."
)
public class EditorialCsvController {

    /**
     * Fachada CSV.
     */
    private final CsvFacade csvFacade;

    /**
     * Constructor.
     *
     * @param csvFacade Fachada CSV.
     */
    public EditorialCsvController(
            CsvFacade csvFacade) {

        this.csvFacade = csvFacade;

    }

    /**
     * Exporta el catálogo
     * de editoriales.
     *
     * @return Archivo CSV.
     */
    @Operation(
            summary = "Exportar catálogo de editoriales",
            description = "Genera y descarga el catálogo de editoriales en formato CSV."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Archivo generado correctamente."
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error al generar el archivo."
            )
    })
    @GetMapping("/exportar")
    public ResponseEntity<ByteArrayResource>
            exportarEditoriales() {

        return csvFacade.exportarEditoriales();

    }

    /**
     * Importa un archivo CSV de editoriales.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    @Operation(
            summary = "Importar editoriales",
            description = "Importa el catálogo de editoriales desde un archivo CSV."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Importación realizada correctamente."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Archivo inválido."
            )
    })
    @PostMapping(
            value = "/importar",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ImportacionReporteDTO>
            importarEditoriales(

            @RequestPart("archivo")
            MultipartFile archivo) {

        return ResponseEntity.ok(

                csvFacade.importarEditoriales(
                        archivo)

        );

    }

}