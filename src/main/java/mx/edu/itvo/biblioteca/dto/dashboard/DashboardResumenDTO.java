package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DashboardResumenDTO {

    private Integer totalLibros;
    private Integer totalUsuarios;
    private Integer totalEjemplares;
    private Integer ejemplaresDisponibles;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresMantenimiento;
    private Integer prestamosActivos;
    private Integer prestamosVencidos;
    private Integer reservasActivas;
    private Integer multasPendientes;
    private BigDecimal montoPendiente;
    private LocalDateTime fechaActualizacion;

    public DashboardResumenDTO() {
    }

    public Integer getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(Integer totalLibros) {
        this.totalLibros = totalLibros;
    }

    public Integer getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(Integer totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public Integer getTotalEjemplares() {
        return totalEjemplares;
    }

    public void setTotalEjemplares(Integer totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    public Integer getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(Integer ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresMantenimiento() {
        return ejemplaresMantenimiento;
    }

    public void setEjemplaresMantenimiento(Integer ejemplaresMantenimiento) {
        this.ejemplaresMantenimiento = ejemplaresMantenimiento;
    }

    public Integer getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(Integer prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public Integer getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(Integer prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
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