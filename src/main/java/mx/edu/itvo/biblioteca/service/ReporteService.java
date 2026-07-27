package mx.edu.itvo.biblioteca.service;


/**
 * Servicio encargado de la generación
 * de reportes ejecutivos del sistema.
 *
 * Utiliza la información consolidada
 * del Dashboard para generar documentos
 * de salida.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */

public interface ReporteService {


    /**
     * Genera reporte ejecutivo
     * del dashboard en PDF.
     *
     * @return archivo PDF.
     */
    byte[] generarDashboardPDF();



    /**
     * Genera reporte ejecutivo
     * del dashboard en Excel.
     *
     * @return archivo Excel.
     */
    byte[] generarDashboardExcel();




    /**
     * Genera reporte administrativo
     * general en PDF.
     *
     * Incluye información de:
     *
     * - usuarios
     * - libros
     * - ejemplares
     * - préstamos
     * - reservas
     *
     * @return archivo PDF.
     */
    byte[] generarReporteAdministrativoPDF();




    /**
     * Genera reporte administrativo
     * general en Excel.
     *
     * @return archivo Excel.
     */
    byte[] generarReporteAdministrativoExcel();



    /**
     * Genera reporte de préstamos.
     *
     * Incluye:
     *
     * - activos
     * - vencidos
     * - devueltos
     *
     * @return archivo PDF.
     */
    byte[] generarReportePrestamosPDF();




    /**
     * Genera reporte de reservas.
     *
     * Incluye estados:
     *
     * - pendientes
     * - atendidas
     * - canceladas
     *
     * @return archivo PDF.
     */
    byte[] generarReporteReservasPDF();
}