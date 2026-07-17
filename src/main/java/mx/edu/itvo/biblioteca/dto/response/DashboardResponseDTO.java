package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver
 * la información del Dashboard.
 *
 * Contiene indicadores generales
 * del sistema bibliotecario.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardResponseDTO {

    /**
     * Total de libros.
     */
    private Long totalLibros;

    /**
     * Total de ejemplares.
     */
    private Long totalEjemplares;

    /**
     * Ejemplares disponibles.
     */
    private Long ejemplaresDisponibles;

    /**
     * Ejemplares prestados.
     */
    private Long ejemplaresPrestados;

    /**
     * Total de usuarios.
     */
    private Long totalUsuarios;

    /**
     * Usuarios activos.
     */
    private Long usuariosActivos;

    /**
     * Usuarios inactivos.
     */
    private Long usuariosInactivos;

    /**
     * Total de préstamos.
     */
    private Long totalPrestamos;

    /**
     * Préstamos activos.
     */
    private Long prestamosActivos;

    /**
     * Total de multas.
     */
    private Long totalMultas;

    /**
     * Fecha y hora de consulta.
     */
    private LocalDateTime fechaConsulta;

    /**
     * Constructor vacío.
     */
    public DashboardResponseDTO() {
    }

    public Long getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(Long totalLibros) {
        this.totalLibros = totalLibros;
    }

    public Long getTotalEjemplares() {
        return totalEjemplares;
    }

    public void setTotalEjemplares(Long totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    public Long getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(Long ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public Long getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Long ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Long getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(Long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public Long getUsuariosActivos() {
        return usuariosActivos;
    }

    public void setUsuariosActivos(Long usuariosActivos) {
        this.usuariosActivos = usuariosActivos;
    }

    public Long getUsuariosInactivos() {
        return usuariosInactivos;
    }

    public void setUsuariosInactivos(Long usuariosInactivos) {
        this.usuariosInactivos = usuariosInactivos;
    }

    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

    public Long getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(Long prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public Long getTotalMultas() {
        return totalMultas;
    }

    public void setTotalMultas(Long totalMultas) {
        this.totalMultas = totalMultas;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

}