package mx.edu.itvo.biblioteca.service;

import mx.edu.itvo.biblioteca.dto.dashboard.DashboardDTO;

/**
 *
 */
public interface DashboardService {

    /**
     * Obtiene la información completa del Dashboard.
     *
     * @return DashboardDTO con todos los indicadores y estadísticas.
     */
    DashboardDTO obtenerDashboard();

}