package mx.edu.itvo.biblioteca.dto.dashboard;

import java.util.List;

public class DashboardDTO {

    private DashboardResumenDTO resumen;

    private DashboardAlertasDTO alertas;

    private DashboardOperacionDiaDTO operacionDia;

    private List<DashboardGraficaDTO> prestamos;

    private List<DashboardGraficaDTO> reservas;

    private List<DashboardTopDTO> topLibros;

    private List<DashboardTopDTO> topCategorias;

    private List<DashboardTopDTO> topAutores;

    private List<DashboardTopDTO> topEditoriales;

    private List<DashboardTopDTO> topIdiomas;

    public DashboardDTO() {
    }

    /* getters y setters */

}