package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO que contiene las alertas
 * principales del Dashboard.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardAlertasDTO {

    /**
     * Total de préstamos vencidos.
     */
    private Long prestamosVencidos;

    /**
     * Total de préstamos que vencen hoy.
     */
    private Long prestamosVencenHoy;

    /**
     * Total de reservas activas.
     */
    private Long reservasActivas;

    /**
     * Total de multas pendientes.
     */
    private Long multasPendientes;

    /**
     * Monto pendiente por multas.
     */
    private BigDecimal montoPendiente;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public DashboardAlertasDTO() {
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
     * Obtiene los préstamos que vencen hoy.
     *
     * @return Préstamos que vencen hoy.
     */
    public Long getPrestamosVencenHoy() {
        return prestamosVencenHoy;
    }

    /**
     * Establece los préstamos que vencen hoy.
     *
     * @param prestamosVencenHoy Préstamos que vencen hoy.
     */
    public void setPrestamosVencenHoy(Long prestamosVencenHoy) {
        this.prestamosVencenHoy = prestamosVencenHoy;
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