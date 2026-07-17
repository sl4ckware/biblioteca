package mx.edu.itvo.biblioteca.service;

import mx.edu.itvo.biblioteca.dto.response.DashboardResponseDTO;

/**
 * Servicio para la obtención
 * de indicadores generales
 * del sistema bibliotecario.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface DashboardService {

    /**
     * Obtiene la información
     * general del Dashboard.
     *
     * @return Indicadores del Dashboard.
     */
    DashboardResponseDTO obtenerDashboard();

}