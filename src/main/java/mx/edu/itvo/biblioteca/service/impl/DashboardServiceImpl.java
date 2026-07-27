package mx.edu.itvo.biblioteca.service.impl;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.dashboard.DashboardDTO;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardAlertasView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardOperacionDiaView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardPrestamoView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardReservaView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardResumenView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopAutorView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopCategoriaView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopEditorialView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopIdiomaView;
import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopLibroView;
import mx.edu.itvo.biblioteca.mapper.DashboardMapper;
import mx.edu.itvo.biblioteca.repository.DashboardAlertasRepository;
import mx.edu.itvo.biblioteca.repository.DashboardOperacionDiaRepository;
import mx.edu.itvo.biblioteca.repository.DashboardPrestamoRepository;
import mx.edu.itvo.biblioteca.repository.DashboardReservaRepository;
import mx.edu.itvo.biblioteca.repository.DashboardResumenRepository;
import mx.edu.itvo.biblioteca.repository.DashboardTopAutorRepository;
import mx.edu.itvo.biblioteca.repository.DashboardTopCategoriaRepository;
import mx.edu.itvo.biblioteca.repository.DashboardTopEditorialRepository;
import mx.edu.itvo.biblioteca.repository.DashboardTopIdiomaRepository;
import mx.edu.itvo.biblioteca.repository.DashboardTopLibroRepository;
import mx.edu.itvo.biblioteca.service.DashboardService;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio principal del Dashboard.
 *
 * <p>
 * Obtiene información estadística mediante las SQL Views del módulo Dashboard
 * y transforma los resultados utilizando DashboardMapper.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    private final DashboardResumenRepository dashboardResumenRepository;

    private final DashboardAlertasRepository dashboardAlertasRepository;

    private final DashboardOperacionDiaRepository dashboardOperacionDiaRepository;

    private final DashboardPrestamoRepository dashboardPrestamoRepository;

    private final DashboardReservaRepository dashboardReservaRepository;

    private final DashboardTopLibroRepository dashboardTopLibroRepository;

    private final DashboardTopCategoriaRepository dashboardTopCategoriaRepository;

    private final DashboardTopAutorRepository dashboardTopAutorRepository;

    private final DashboardTopEditorialRepository dashboardTopEditorialRepository;

    private final DashboardTopIdiomaRepository dashboardTopIdiomaRepository;

    private final DashboardMapper dashboardMapper;


    /**
     * Constructor con inyección de dependencias.
     *
     * @param dashboardResumenRepository repositorio resumen.
     * @param dashboardAlertasRepository repositorio alertas.
     * @param dashboardOperacionDiaRepository repositorio operación diaria.
     * @param dashboardPrestamoRepository repositorio préstamos.
     * @param dashboardReservaRepository repositorio reservas.
     * @param dashboardTopLibroRepository repositorio top libros.
     * @param dashboardTopCategoriaRepository repositorio top categorías.
     * @param dashboardTopAutorRepository repositorio top autores.
     * @param dashboardTopEditorialRepository repositorio top editoriales.
     * @param dashboardTopIdiomaRepository repositorio top idiomas.
     * @param dashboardMapper mapper del dashboard.
     */
    public DashboardServiceImpl(
            DashboardResumenRepository dashboardResumenRepository,
            DashboardAlertasRepository dashboardAlertasRepository,
            DashboardOperacionDiaRepository dashboardOperacionDiaRepository,
            DashboardPrestamoRepository dashboardPrestamoRepository,
            DashboardReservaRepository dashboardReservaRepository,
            DashboardTopLibroRepository dashboardTopLibroRepository,
            DashboardTopCategoriaRepository dashboardTopCategoriaRepository,
            DashboardTopAutorRepository dashboardTopAutorRepository,
            DashboardTopEditorialRepository dashboardTopEditorialRepository,
            DashboardTopIdiomaRepository dashboardTopIdiomaRepository,
            DashboardMapper dashboardMapper) {

        this.dashboardResumenRepository = dashboardResumenRepository;
        this.dashboardAlertasRepository = dashboardAlertasRepository;
        this.dashboardOperacionDiaRepository = dashboardOperacionDiaRepository;
        this.dashboardPrestamoRepository = dashboardPrestamoRepository;
        this.dashboardReservaRepository = dashboardReservaRepository;
        this.dashboardTopLibroRepository = dashboardTopLibroRepository;
        this.dashboardTopCategoriaRepository = dashboardTopCategoriaRepository;
        this.dashboardTopAutorRepository = dashboardTopAutorRepository;
        this.dashboardTopEditorialRepository = dashboardTopEditorialRepository;
        this.dashboardTopIdiomaRepository = dashboardTopIdiomaRepository;
        this.dashboardMapper = dashboardMapper;
    }


    /**
     * Obtiene la información completa del Dashboard.
     *
     * @return DashboardDTO con indicadores y estadísticas.
     */
    @Override
    public DashboardDTO obtenerDashboard() {

        DashboardDTO dashboardDTO = new DashboardDTO();

        dashboardDTO.setResumen(
                dashboardResumenRepository.findAll()
                        .stream()
                        .findFirst()
                        .map(dashboardMapper::toResumen)
                        .orElse(null));


        dashboardDTO.setAlertas(
                dashboardAlertasRepository.findAll()
                        .stream()
                        .findFirst()
                        .map(dashboardMapper::toAlertas)
                        .orElse(null));


        dashboardDTO.setOperacionDia(
                dashboardOperacionDiaRepository.findAll()
                        .stream()
                        .findFirst()
                        .map(dashboardMapper::toOperacionDia)
                        .orElse(null));


        dashboardDTO.setPrestamos(
                dashboardPrestamoRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toGrafica)
                        .toList());


        dashboardDTO.setReservas(
                dashboardReservaRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toGrafica)
                        .toList());


        dashboardDTO.setTopLibros(
                dashboardTopLibroRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toTop)
                        .toList());


        dashboardDTO.setTopCategorias(
                dashboardTopCategoriaRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toTop)
                        .toList());


        dashboardDTO.setTopAutores(
                dashboardTopAutorRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toTop)
                        .toList());


        dashboardDTO.setTopEditoriales(
                dashboardTopEditorialRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toTop)
                        .toList());


        dashboardDTO.setTopIdiomas(
                dashboardTopIdiomaRepository.findAll()
                        .stream()
                        .map(dashboardMapper::toTop)
                        .toList());


        return dashboardDTO;
    }

}