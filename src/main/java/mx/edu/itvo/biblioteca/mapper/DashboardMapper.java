package mx.edu.itvo.biblioteca.mapper;

import mx.edu.itvo.biblioteca.dto.dashboard.DashboardAlertasDTO;
import mx.edu.itvo.biblioteca.dto.dashboard.DashboardGraficaDTO;
import mx.edu.itvo.biblioteca.dto.dashboard.DashboardOperacionDiaDTO;
import mx.edu.itvo.biblioteca.dto.dashboard.DashboardResumenDTO;
import mx.edu.itvo.biblioteca.dto.dashboard.DashboardTopDTO;
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
import org.springframework.stereotype.Component;

/**
 * ============================================================================
 * DashboardMapper
 * ============================================================================
 *
 * Mapper encargado de transformar las vistas SQL del Dashboard
 * hacia los DTO utilizados por la API REST.
 *
 * Características:
 *
 * • Stateless
 * • Thread Safe
 * • Singleton administrado por Spring
 * • Sin estado interno
 * • Complejidad O(1)
 *
 * Todas las conversiones son mediante asignación directa.
 *
 * Complejidad temporal:
 *
 *      O(1)
 *
 * Complejidad espacial:
 *
 *      O(1)
 *
 * @author Conce
 * @version 2.1
 * @since 2.1
 */
@Component
public final class DashboardMapper {

    /**
     * Constructor.
     */
    public DashboardMapper() {
    }

    /**
     * ===========================================================
     * MÉTODOS PRIVADOS
     * ===========================================================
     */

    /**
     * Inicializa la información base de una gráfica.
     *
     * @param anio Año.
     * @param mes Mes.
     * @param nombreMes Nombre del mes.
     * @param total Total general.
     * @return DTO inicializado.
     */
    private DashboardGraficaDTO crearGraficaBase(
            Integer anio,
            Integer mes,
            String nombreMes,
            Long total) {

        DashboardGraficaDTO dto =
                new DashboardGraficaDTO();

        dto.setAnio(anio);
        dto.setMes(mes);
        dto.setNombreMes(nombreMes);
        dto.setTotal(total);

        return dto;

    }

    /**
     * Inicializa un DTO Top.
     *
     * @param id Identificador.
     * @param nombre Nombre.
     * @param totalPrestamos Total de préstamos.
     * @return DashboardTopDTO.
     */
    private DashboardTopDTO crearTop(
            Long id,
            String nombre,
            Long totalPrestamos) {

        DashboardTopDTO dto =
                new DashboardTopDTO();

        dto.setId(id);
        dto.setNombre(nombre);
        dto.setTotalPrestamos(totalPrestamos);

        return dto;

    }

    /**
     * Asigna los indicadores correspondientes
     * a la gráfica de préstamos.
     *
     * @param dto DTO destino.
     * @param entity Vista origen.
     */
    private void aplicarIndicadoresPrestamo(
            DashboardGraficaDTO dto,
            DashboardPrestamoView entity) {

        dto.setIndicador1(
                entity.getPrestamosActivos());

        dto.setIndicador2(
                entity.getPrestamosDevueltos());

        dto.setIndicador3(
                entity.getPrestamosVencidos());

    }

    /**
     * Asigna los indicadores correspondientes
     * a la gráfica de reservas.
     *
     * @param dto DTO destino.
     * @param entity Vista origen.
     */
    private void aplicarIndicadoresReserva(
            DashboardGraficaDTO dto,
            DashboardReservaView entity) {

        dto.setIndicador1(
                entity.getReservasActivas());

        dto.setIndicador2(
                entity.getReservasAtendidas());

        dto.setIndicador3(
                entity.getReservasCanceladas());

        dto.setIndicador4(
                entity.getReservasExpiradas());

    }
    
    /**
     * Convierte la vista resumen del Dashboard
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista resumen.
     * @return DashboardResumenDTO.
     */
    public final DashboardResumenDTO toResumen(
            DashboardResumenView entity) {

        if (entity == null) {
            return null;
        }

        DashboardResumenDTO dto =
                new DashboardResumenDTO();

        dto.setTotalLibros(
                entity.getTotalLibros());

        dto.setTotalUsuarios(
                entity.getTotalUsuarios());

        dto.setTotalEjemplares(
                entity.getTotalEjemplares());

        dto.setEjemplaresDisponibles(
                entity.getEjemplaresDisponibles());

        dto.setEjemplaresPrestados(
                entity.getEjemplaresPrestados());

        dto.setEjemplaresMantenimiento(
                entity.getEjemplaresMantenimiento());

        dto.setPrestamosActivos(
                entity.getPrestamosActivos());

        dto.setPrestamosVencidos(
                entity.getPrestamosVencidos());

        dto.setReservasActivas(
                entity.getReservasActivas());

        dto.setMultasPendientes(
                entity.getMultasPendientes());

        dto.setMontoPendiente(
                entity.getMontoPendiente());

        dto.setFechaActualizacion(
                entity.getFechaActualizacion());

        return dto;

    }

    /**
     * Convierte la vista de alertas
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista de alertas.
     * @return DashboardAlertasDTO.
     */
    public final DashboardAlertasDTO toAlertas(
            DashboardAlertasView entity) {

        if (entity == null) {
            return null;
        }

        DashboardAlertasDTO dto =
                new DashboardAlertasDTO();

        dto.setPrestamosVencidos(
                entity.getPrestamosVencidos());

        dto.setPrestamosVencenHoy(
                entity.getPrestamosVencenHoy());

        dto.setReservasActivas(
                entity.getReservasActivas());

        dto.setMultasPendientes(
                entity.getMultasPendientes());

        dto.setMontoPendiente(
                entity.getMontoPendiente());

        dto.setFechaActualizacion(
                entity.getFechaActualizacion());

        return dto;

    }

    /**
     * Convierte la vista de operación diaria
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista de operación diaria.
     * @return DashboardOperacionDiaDTO.
     */
    public final DashboardOperacionDiaDTO
            toOperacionDia(
                    DashboardOperacionDiaView entity) {

        if (entity == null) {
            return null;
        }

        DashboardOperacionDiaDTO dto =
                new DashboardOperacionDiaDTO();

        dto.setPrestamosHoy(
                entity.getPrestamosHoy());

        dto.setDevolucionesHoy(
                entity.getDevolucionesHoy());

        dto.setReservasHoy(
                entity.getReservasHoy());

        dto.setUsuariosRegistradosHoy(
                entity.getUsuariosRegistradosHoy());

        dto.setMultasGeneradasHoy(
                entity.getMultasGeneradasHoy());

        dto.setMontoMultasHoy(
                entity.getMontoMultasHoy());

        dto.setFechaActualizacion(
                entity.getFechaActualizacion());

        return dto;

    }
                /**
     * Convierte la vista de estadísticas de préstamos
     * al DTO utilizado por las gráficas.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista de préstamos.
     * @return DashboardGraficaDTO.
     */
    public final DashboardGraficaDTO toGrafica(
            DashboardPrestamoView entity) {

        if (entity == null) {
            return null;
        }

        DashboardGraficaDTO dto =
                crearGraficaBase(
                        entity.getAnio(),
                        entity.getMes(),
                        entity.getNombreMes(),
                        entity.getTotalPrestamos());

        aplicarIndicadoresPrestamo(
                dto,
                entity);

        return dto;

    }

    /**
     * Convierte la vista de estadísticas de reservas
     * al DTO utilizado por las gráficas.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista de reservas.
     * @return DashboardGraficaDTO.
     */
    public final DashboardGraficaDTO toGrafica(
            DashboardReservaView entity) {

        if (entity == null) {
            return null;
        }

        DashboardGraficaDTO dto =
                crearGraficaBase(
                        entity.getAnio(),
                        entity.getMes(),
                        entity.getNombreMes(),
                        entity.getTotalReservas());

        aplicarIndicadoresReserva(
                dto,
                entity);

        return dto;

    }
    
    /**
     * Convierte la vista Top Libros
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista origen.
     * @return DashboardTopDTO.
     */
    public final DashboardTopDTO toTop(
            DashboardTopLibroView entity) {

        if (entity == null) {
            return null;
        }

        return crearTop(
                entity.getIdLibro(),
                entity.getTitulo(),
                entity.getTotalPrestamos());

    }

    /**
     * Convierte la vista Top Categorías
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista origen.
     * @return DashboardTopDTO.
     */
    public final DashboardTopDTO toTop(
            DashboardTopCategoriaView entity) {

        if (entity == null) {
            return null;
        }

        return crearTop(
                entity.getIdCategoria(),
                entity.getCategoria(),
                entity.getTotalPrestamos());

    }

    /**
     * Convierte la vista Top Autores
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista origen.
     * @return DashboardTopDTO.
     */
    public final DashboardTopDTO toTop(
            DashboardTopAutorView entity) {

        if (entity == null) {
            return null;
        }

        return crearTop(
                entity.getIdAutor(),
                entity.getAutor(),
                entity.getTotalPrestamos());

    }

    /**
     * Convierte la vista Top Editoriales
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista origen.
     * @return DashboardTopDTO.
     */
    public final DashboardTopDTO toTop(
            DashboardTopEditorialView entity) {

        if (entity == null) {
            return null;
        }

        return crearTop(
                entity.getIdEditorial(),
                entity.getEditorial(),
                entity.getTotalPrestamos());

    }

    /**
     * Convierte la vista Top Idiomas
     * al DTO correspondiente.
     *
     * Complejidad:
     * Tiempo: O(1)
     * Espacio: O(1)
     *
     * @param entity Vista origen.
     * @return DashboardTopDTO.
     */
    public final DashboardTopDTO toTop(
            DashboardTopIdiomaView entity) {

        if (entity == null) {
            return null;
        }

        return crearTop(
                entity.getIdIdioma(),
                entity.getIdioma(),
                entity.getTotalPrestamos());

    }

}