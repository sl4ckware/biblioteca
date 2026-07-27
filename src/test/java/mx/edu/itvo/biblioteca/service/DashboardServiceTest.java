package mx.edu.itvo.biblioteca.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import mx.edu.itvo.biblioteca.dto.dashboard.DashboardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Pruebas de integración del servicio Dashboard.
 *
 * @author Conce
 */
@SpringBootTest
class DashboardServiceTest {

    @Autowired
    private DashboardService dashboardService;

    /**
     * Valida que el Dashboard sea generado correctamente.
     */
    @Test
    void obtenerDashboardDebeGenerarDatos() {

        DashboardDTO dashboard =
                dashboardService.obtenerDashboard();

        assertNotNull(dashboard);

    }

}