package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.projection.dashboard.DashboardAlertasProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardOperacionDiaProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardPrestamoProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardReservaProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardResumenProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardTopAutorProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardTopCategoriaProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardTopEditorialProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardTopIdiomaProjection;
import mx.edu.itvo.biblioteca.projection.dashboard.DashboardTopLibroProjection;
import java.util.List;

public interface DashboardRepository {

    DashboardResumenProjection obtenerResumen();

    DashboardAlertasProjection obtenerAlertas();

    DashboardOperacionDiaProjection obtenerOperacionDia();

    List<DashboardPrestamoProjection> obtenerPrestamos();

    List<DashboardReservaProjection> obtenerReservas();

    List<DashboardTopLibroProjection> obtenerTopLibros();

    List<DashboardTopCategoriaProjection> obtenerTopCategorias();

    List<DashboardTopAutorProjection> obtenerTopAutores();

    List<DashboardTopEditorialProjection> obtenerTopEditoriales();

    List<DashboardTopIdiomaProjection> obtenerTopIdiomas();

}