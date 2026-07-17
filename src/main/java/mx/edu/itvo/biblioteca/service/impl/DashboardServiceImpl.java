package mx.edu.itvo.biblioteca.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itvo.biblioteca.dto.response.DashboardResponseDTO;
import mx.edu.itvo.biblioteca.repository.EjemplarRepository;
import mx.edu.itvo.biblioteca.repository.LibroRepository;
import mx.edu.itvo.biblioteca.repository.MultaRepository;
import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import mx.edu.itvo.biblioteca.service.DashboardService;

/**
 * Implementación del servicio
 * del Dashboard.
 *
 * Obtiene indicadores generales
 * del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
@Service
@Transactional(readOnly = true)
public class DashboardServiceImpl
        implements DashboardService {

    /**
     * Repositorio de libros.
     */
    private final LibroRepository libroRepository;

    /**
     * Repositorio de ejemplares.
     */
    private final EjemplarRepository ejemplarRepository;

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Repositorio de préstamos.
     */
    private final PrestamoRepository prestamoRepository;

    /**
     * Repositorio de multas.
     */
    private final MultaRepository multaRepository;

    /**
     * Constructor.
     */
    public DashboardServiceImpl(
            LibroRepository libroRepository,
            EjemplarRepository ejemplarRepository,
            UsuarioRepository usuarioRepository,
            PrestamoRepository prestamoRepository,
            MultaRepository multaRepository) {

        this.libroRepository = libroRepository;
        this.ejemplarRepository = ejemplarRepository;
        this.usuarioRepository = usuarioRepository;
        this.prestamoRepository = prestamoRepository;
        this.multaRepository = multaRepository;

    }

    /**
     * Obtiene los indicadores
     * del Dashboard.
     *
     * @return Dashboard.
     */
    @Override
    public DashboardResponseDTO obtenerDashboard() {

        DashboardResponseDTO dashboard =
                new DashboardResponseDTO();
                /*
         * Indicadores generales.
         */
        dashboard.setTotalLibros(
                libroRepository.count());

        dashboard.setTotalEjemplares(
                ejemplarRepository.count());

        dashboard.setTotalUsuarios(
                usuarioRepository.count());

        dashboard.setTotalPrestamos(
                prestamoRepository.count());

        dashboard.setTotalMultas(
                multaRepository.count());

        /*
         * Los siguientes indicadores
         * requieren consultas específicas
         * en los repositorios. Como los
         * módulos están congelados, por
         * ahora se inicializan en cero.
         */
        dashboard.setEjemplaresDisponibles(0L);

        dashboard.setEjemplaresPrestados(0L);

        dashboard.setUsuariosActivos(0L);

        dashboard.setUsuariosInactivos(0L);

        dashboard.setPrestamosActivos(0L);

        /*
         * Fecha de consulta.
         */
        dashboard.setFechaConsulta(
                LocalDateTime.now());

        return dashboard;

    }

}