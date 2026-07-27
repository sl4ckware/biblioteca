package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO que contiene el resumen general
 * del Dashboard.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardResumenDTO {

    /**
     * Total de libros.
     */
    private Long totalLibros;

    /**
     * Total de usuarios.
     */
    private Long totalUsuarios;

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
     * Ejemplares en mantenimiento.
     */
    private Long ejemplaresMantenimiento;

    /**
     * Préstamos activos.
     */
    private Long prestamosActivos;

    /**
     * Préstamos vencidos.
     */
    private Long prestamosVencidos;

    /**
     * Reservas activas.
     */
    private Long reservasActivas;

    /**
     * Multas pendientes.
     */
    private Long multasPendientes;

    /**
     * Monto pendiente de multas.
     */
    private BigDecimal montoPendiente;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public DashboardResumenDTO() {
    }

    /**
     * Obtiene el total de libros.
     *
     * @return Total de libros.
     */
    public Long getTotalLibros() {
        return totalLibros;
    }

    /**
     * Establece el total de libros.
     *
     * @param totalLibros Total de libros.
     */
    public void setTotalLibros(Long totalLibros) {
        this.totalLibros = totalLibros;
    }

    /**
     * Obtiene el total de usuarios.
     *
     * @return Total de usuarios.
     */
    public Long getTotalUsuarios() {
        return totalUsuarios;
    }

    /**
     * Establece el total de usuarios.
     *
     * @param totalUsuarios Total de usuarios.
     */
    public void setTotalUsuarios(Long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    /**
     * Obtiene el total de ejemplares.
     *
     * @return Total de ejemplares.
     */
    public Long getTotalEjemplares() {
        return totalEjemplares;
    }

    /**
     * Establece el total de ejemplares.
     *
     * @param totalEjemplares Total de ejemplares.
     */
    public void setTotalEjemplares(Long totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    /**
     * Obtiene los ejemplares disponibles.
     *
     * @return Ejemplares disponibles.
     */
    public Long getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    /**
     * Establece los ejemplares disponibles.
     *
     * @param ejemplaresDisponibles Ejemplares disponibles.
     */
    public void setEjemplaresDisponibles(Long ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    /**
     * Obtiene los ejemplares prestados.
     *
     * @return Ejemplares prestados.
     */
    public Long getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    /**
     * Establece los ejemplares prestados.
     *
     * @param ejemplaresPrestados Ejemplares prestados.
     */
    public void setEjemplaresPrestados(Long ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    /**
     * Obtiene los ejemplares en mantenimiento.
     *
     * @return Ejemplares en mantenimiento.
     */
    public Long getEjemplaresMantenimiento() {
        return ejemplaresMantenimiento;
    }

    /**
     * Establece los ejemplares en mantenimiento.
     *
     * @param ejemplaresMantenimiento Ejemplares en mantenimiento.
     */
    public void setEjemplaresMantenimiento(Long ejemplaresMantenimiento) {
        this.ejemplaresMantenimiento = ejemplaresMantenimiento;
    }

    /**
     * Obtiene los préstamos activos.
     *
     * @return Préstamos activos.
     */
    public Long getPrestamosActivos() {
        return prestamosActivos;
    }

    /**
     * Establece los préstamos activos.
     *
     * @param prestamosActivos Préstamos activos.
     */
    public void setPrestamosActivos(Long prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    /**
     * Obtiene los préstamos vencidos.
     *
     * @return Préstamos vencidos.
     */
    public Long getPrestamosVencidos() {
        return prestamosVencidos;
    }

    /**
     * Establece los préstamos vencidos.
     *
     * @param prestamosVencidos Préstamos vencidos.
     */
    public void setPrestamosVencidos(Long prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

    /**
     * Obtiene las reservas activas.
     *
     * @return Reservas activas.
     */
    public Long getReservasActivas() {
        return reservasActivas;
    }

    /**
     * Establece las reservas activas.
     *
     * @param reservasActivas Reservas activas.
     */
    public void setReservasActivas(Long reservasActivas) {
        this.reservasActivas = reservasActivas;
    }

    /**
     * Obtiene las multas pendientes.
     *
     * @return Multas pendientes.
     */
    public Long getMultasPendientes() {
        return multasPendientes;
    }

    /**
     * Establece las multas pendientes.
     *
     * @param multasPendientes Multas pendientes.
     */
    public void setMultasPendientes(Long multasPendientes) {
        this.multasPendientes = multasPendientes;
    }

    /**
     * Obtiene el monto pendiente.
     *
     * @return Monto pendiente.
     */
    public BigDecimal getMontoPendiente() {
        return montoPendiente;
    }

    /**
     * Establece el monto pendiente.
     *
     * @param montoPendiente Monto pendiente.
     */
    public void setMontoPendiente(BigDecimal montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    /**
     * Obtiene la fecha de actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion = fechaActualizacion;

    }

}