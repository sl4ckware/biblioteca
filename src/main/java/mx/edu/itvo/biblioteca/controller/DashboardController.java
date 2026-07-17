package mx.edu.itvo.biblioteca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.response.DashboardResponseDTO;
import mx.edu.itvo.biblioteca.service.DashboardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para el Dashboard.
 *
 * Expone los indicadores generales
 * del sistema bibliotecario.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */

@Tag(
    name = "📊 Dashboard",
    description = "Indicadores generales del Sistema Bibliotecario."
)

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    /**
     * Servicio del Dashboard.
     */
    private final DashboardService dashboardService;

    /**
     * Constructor.
     *
     * @param dashboardService Servicio.
     */
    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService = dashboardService;

    }

    /**
     * Obtiene los indicadores
     * generales del sistema.
     *
     * @return Dashboard.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<DashboardResponseDTO>>
            obtenerDashboard() {

        return ResponseEntity.ok(

                ApiResponse.success(

                        dashboardService.obtenerDashboard(),

                        "Información del Dashboard obtenida correctamente."

                )

        );

    }

}