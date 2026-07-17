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
 * del catálogo de libros en
 * formato CSV.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@RestController
@RequestMapping("/api/csv/libros")
@Tag(
        name = "📄 CSV - Libros",
        description = "Exportación e importación del catálogo de libros en formato CSV."
)
public class LibroCsvController {

    /**
     * Fachada CSV.
     */
    private final CsvFacade csvFacade;

    /**
     * Constructor.
     *
     * @param csvFacade Fachada CSV.
     */
    public LibroCsvController(
            CsvFacade csvFacade) {

        this.csvFacade = csvFacade;

    }

    /**
     * Exporta el catálogo
     * de libros.
     *
     * @return Archivo CSV.
     */
    @Operation(
            summary = "Exportar catálogo de libros",
            description = "Genera y descarga el catálogo de libros en formato CSV."
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
            exportarLibros() {

        return csvFacade.exportarLibros();

    }
            

/**
 * Importa un archivo CSV de libros.
 *
 * @param archivo Archivo CSV.
 * @return Resultado de la importación.
 */
@Operation(
        summary = "Importar libros",
        description = "Importa el catálogo de libros desde un archivo CSV."
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
        importarLibros(

        @RequestPart("archivo")
        MultipartFile archivo) {

    return ResponseEntity.ok(

            csvFacade.importarLibros(
                    archivo)

    );

}
        

}