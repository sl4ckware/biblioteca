package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DashboardAlertasDTO {

    private Integer prestamosVencidos;
    private Integer prestamosVencenHoy;
    private Integer reservasActivas;
    private Integer multasPendientes;
    private BigDecimal montoPendiente;
    private LocalDateTime fechaActualizacion;

    public DashboardAlertasDTO() {
    }

    public Integer getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(Integer prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

    public Integer getPrestamosVencenHoy() {
        return prestamosVencenHoy;
    }

    public void setPrestamosVencenHoy(Integer prestamosVencenHoy) {
        this.prestamosVencenHoy = prestamosVencenHoy;
    }

    public Integer getReservasActivas() {
        return reservasActivas;
    }

    public void setReservasActivas(Integer reservasActivas) {
        this.reservasActivas = reservasActivas;
    }

    public Integer getMultasPendientes() {
        return multasPendientes;
    }

    public void setMultasPendientes(Integer multasPendientes) {
        this.multasPendientes = multasPendientes;
    }

    public BigDecimal getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(BigDecimal montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}