package mx.edu.itvo.biblioteca.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import mx.edu.itvo.biblioteca.service.ReporteService;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador encargado de la generación
 * de reportes del Sistema Integral de Biblioteca.
 *
 * <p>
 * Expone reportes ejecutivos y administrativos
 * en formatos PDF y Excel.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since Sprint 20
 */
@RestController
@RequestMapping("/api/reportes")
@Tag(
        name = "📊 Reportes Administrativos",
        description =
        "Generación de reportes ejecutivos y administrativos "
        + "del Sistema Integral de Biblioteca."
)
public class ReporteController {



    /**
     * Servicio de reportes.
     */
    private final ReporteService reporteService;



    /**
     * Constructor.
     *
     * @param reporteService servicio de reportes.
     */
    public ReporteController(
            ReporteService reporteService) {

        this.reporteService =
                reporteService;

    }





    /**
     * Genera reporte ejecutivo
     * del Dashboard en PDF.
     *
     * @return archivo PDF.
     */
    @Operation(
            summary = "Generar Dashboard PDF",
            description =
            "Genera un reporte ejecutivo "
            + "del Dashboard con indicadores generales."
    )
    @GetMapping(
            value = "/dashboard/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> dashboardPDF() {



        byte[] archivo =
                reporteService
                .generarDashboardPDF();



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=dashboard.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(
                        archivo
                );

    }







    /**
     * Genera reporte ejecutivo
     * del Dashboard en Excel.
     *
     * @return archivo Excel.
     */
    @Operation(
            summary = "Generar Dashboard Excel",
            description =
            "Genera un archivo Excel "
            + "con información del Dashboard."
    )
    @GetMapping(
            value = "/dashboard/excel",
            produces =
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public ResponseEntity<byte[]> dashboardExcel() {



        byte[] archivo =
                reporteService
                .generarDashboardExcel();



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=dashboard.xlsx"
                )
                .body(
                        archivo
                );

    }








    /**
     * Genera reporte administrativo general PDF.
     *
     * Incluye:
     * <ul>
     * <li>Usuarios</li>
     * <li>Inventario</li>
     * <li>Préstamos</li>
     * <li>Reservas</li>
     * </ul>
     *
     * @return archivo PDF.
     */
    @Operation(
            summary = "Generar reporte administrativo PDF",
            description =
            """
            Genera un reporte administrativo general.
            Incluye información consolidada
            de usuarios, inventario, préstamos
            y reservas.
            """
    )
    @GetMapping(
            value = "/administrativo/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> administrativoPDF() {



        byte[] archivo =
                reporteService
                .generarReporteAdministrativoPDF();



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=reporte-administrativo.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(
                        archivo
                );

    }








    /**
     * Genera reporte administrativo Excel.
     *
     * @return archivo Excel.
     */
    @Operation(
            summary = "Generar reporte administrativo Excel",
            description =
            "Genera reporte administrativo "
            + "en formato Excel."
    )
    @GetMapping(
            value = "/administrativo/excel",
            produces =
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public ResponseEntity<byte[]> administrativoExcel() {



        byte[] archivo =
                reporteService
                .generarReporteAdministrativoExcel();



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=reporte-administrativo.xlsx"
                )
                .body(
                        archivo
                );

    }








    /**
     * Reporte específico de préstamos.
     *
     * @return PDF.
     */
    @Operation(
            summary = "Reporte de préstamos PDF",
            description =
            "Genera reporte de préstamos activos, "
            + "vencidos y devueltos."
    )
    @GetMapping(
            value = "/prestamos/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> prestamosPDF() {



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=prestamos.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(
                        reporteService
                        .generarReportePrestamosPDF()
                );

    }








    /**
     * Reporte específico de reservas.
     *
     * @return PDF.
     */
    @Operation(
            summary = "Reporte de reservas PDF",
            description =
            "Genera reporte de reservas "
            + "por estado."
    )
    @GetMapping(
            value = "/reservas/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> reservasPDF() {



        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=reservas.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(
                        reporteService
                        .generarReporteReservasPDF()
                );

    }


}