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

        /**
     * Obtiene el resumen general del dashboard.
     *
     * @return resumen del dashboard.
     */
    public DashboardResumenDTO getResumen() {
        return resumen;
    }

    /**
     * Asigna el resumen general del dashboard.
     *
     * @param resumen resumen del dashboard.
     */
    public void setResumen(DashboardResumenDTO resumen) {
        this.resumen = resumen;
    }

    /**
     * Obtiene las alertas del dashboard.
     *
     * @return alertas del dashboard.
     */
    public DashboardAlertasDTO getAlertas() {
        return alertas;
    }

    /**
     * Asigna las alertas del dashboard.
     *
     * @param alertas alertas del dashboard.
     */
    public void setAlertas(DashboardAlertasDTO alertas) {
        this.alertas = alertas;
    }

    /**
     * Obtiene la operación del día.
     *
     * @return operación diaria.
     */
    public DashboardOperacionDiaDTO getOperacionDia() {
        return operacionDia;
    }

    /**
     * Asigna la operación del día.
     *
     * @param operacionDia operación diaria.
     */
    public void setOperacionDia(
            DashboardOperacionDiaDTO operacionDia) {

        this.operacionDia = operacionDia;
    }

    /**
     * Obtiene la lista de estadísticas de préstamos.
     *
     * @return lista de préstamos.
     */
    public List<DashboardGraficaDTO> getPrestamos() {
        return prestamos;
    }

    /**
     * Asigna la lista de estadísticas de préstamos.
     *
     * @param prestamos lista de préstamos.
     */
    public void setPrestamos(
            List<DashboardGraficaDTO> prestamos) {

        this.prestamos = prestamos;
    }

    /**
     * Obtiene la lista de estadísticas de reservas.
     *
     * @return lista de reservas.
     */
    public List<DashboardGraficaDTO> getReservas() {
        return reservas;
    }

    /**
     * Asigna la lista de estadísticas de reservas.
     *
     * @param reservas lista de reservas.
     */
    public void setReservas(
            List<DashboardGraficaDTO> reservas) {

        this.reservas = reservas;
    }

    /**
     * Obtiene el top de libros.
     *
     * @return lista de libros destacados.
     */
    public List<DashboardTopDTO> getTopLibros() {
        return topLibros;
    }

    /**
     * Asigna el top de libros.
     *
     * @param topLibros lista de libros destacados.
     */
    public void setTopLibros(
            List<DashboardTopDTO> topLibros) {

        this.topLibros = topLibros;
    }

    /**
     * Obtiene el top de categorías.
     *
     * @return lista de categorías destacadas.
     */
    public List<DashboardTopDTO> getTopCategorias() {
        return topCategorias;
    }

    /**
     * Asigna el top de categorías.
     *
     * @param topCategorias lista de categorías destacadas.
     */
    public void setTopCategorias(
            List<DashboardTopDTO> topCategorias) {

        this.topCategorias = topCategorias;
    }

    /**
     * Obtiene el top de autores.
     *
     * @return lista de autores destacados.
     */
    public List<DashboardTopDTO> getTopAutores() {
        return topAutores;
    }

    /**
     * Asigna el top de autores.
     *
     * @param topAutores lista de autores destacados.
     */
    public void setTopAutores(
            List<DashboardTopDTO> topAutores) {

        this.topAutores = topAutores;
    }

    /**
     * Obtiene el top de editoriales.
     *
     * @return lista de editoriales destacadas.
     */
    public List<DashboardTopDTO> getTopEditoriales() {
        return topEditoriales;
    }

    /**
     * Asigna el top de editoriales.
     *
     * @param topEditoriales lista de editoriales destacadas.
     */
    public void setTopEditoriales(
            List<DashboardTopDTO> topEditoriales) {

        this.topEditoriales = topEditoriales;
    }

    /**
     * Obtiene el top de idiomas.
     *
     * @return lista de idiomas destacados.
     */
    public List<DashboardTopDTO> getTopIdiomas() {
        return topIdiomas;
    }

    /**
     * Asigna el top de idiomas.
     *
     * @param topIdiomas lista de idiomas destacados.
     */
    public void setTopIdiomas(
            List<DashboardTopDTO> topIdiomas) {

        this.topIdiomas = topIdiomas;
    }

}