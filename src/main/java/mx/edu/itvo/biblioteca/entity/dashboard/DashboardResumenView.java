package mx.edu.itvo.biblioteca.entity.dashboard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad de solo lectura para la vista
 * vw_dashboard_resumen.
 *
 * Contiene los principales indicadores
 * generales del Dashboard.
 *
 * @author 
 */
@Entity
@Immutable
@Table(name = "vw_dashboard_resumen")
public class DashboardResumenView {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "total_libros")
    private Long totalLibros;

    @Column(name = "total_usuarios")
    private Long totalUsuarios;

    @Column(name = "total_ejemplares")
    private Long totalEjemplares;

    @Column(name = "ejemplares_disponibles")
    private Long ejemplaresDisponibles;

    @Column(name = "ejemplares_prestados")
    private Long ejemplaresPrestados;

    @Column(name = "ejemplares_mantenimiento")
    private Long ejemplaresMantenimiento;

    @Column(name = "prestamos_activos")
    private Long prestamosActivos;

    @Column(name = "prestamos_vencidos")
    private Long prestamosVencidos;

    @Column(name = "reservas_activas")
    private Long reservasActivas;

    @Column(name = "multas_pendientes")
    private Long multasPendientes;

    @Column(name = "monto_pendiente")
    private BigDecimal montoPendiente;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public DashboardResumenView() {
    }

    public DashboardResumenView(
            Integer id,
            Long totalLibros,
            Long totalUsuarios,
            Long totalEjemplares,
            Long ejemplaresDisponibles,
            Long ejemplaresPrestados,
            Long ejemplaresMantenimiento,
            Long prestamosActivos,
            Long prestamosVencidos,
            Long reservasActivas,
            Long multasPendientes,
            BigDecimal montoPendiente,
            LocalDateTime fechaActualizacion) {

        this.id = id;
        this.totalLibros = totalLibros;
        this.totalUsuarios = totalUsuarios;
        this.totalEjemplares = totalEjemplares;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresMantenimiento = ejemplaresMantenimiento;
        this.prestamosActivos = prestamosActivos;
        this.prestamosVencidos = prestamosVencidos;
        this.reservasActivas = reservasActivas;
        this.multasPendientes = multasPendientes;
        this.montoPendiente = montoPendiente;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(Long totalLibros) {
        this.totalLibros = totalLibros;
    }

    public Long getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(Long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
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

    public Long getEjemplaresMantenimiento() {
        return ejemplaresMantenimiento;
    }

    public void setEjemplaresMantenimiento(Long ejemplaresMantenimiento) {
        this.ejemplaresMantenimiento = ejemplaresMantenimiento;
    }

    public Long getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(Long prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public Long getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(Long prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

    public Long getReservasActivas() {
        return reservasActivas;
    }

    public void setReservasActivas(Long reservasActivas) {
        this.reservasActivas = reservasActivas;
    }

    public Long getMultasPendientes() {
        return multasPendientes;
    }

    public void setMultasPendientes(Long multasPendientes) {
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