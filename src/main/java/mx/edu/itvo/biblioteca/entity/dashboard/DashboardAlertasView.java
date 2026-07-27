package mx.edu.itvo.biblioteca.entity.dashboard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 */
@Entity
@Immutable
@Table(name = "vw_dashboard_alertas")
public class DashboardAlertasView {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "prestamos_vencidos")
    private Long prestamosVencidos;

    @Column(name = "prestamos_vencen_hoy")
    private Long prestamosVencenHoy;

    @Column(name = "reservas_activas")
    private Long reservasActivas;

    @Column(name = "multas_pendientes")
    private Long multasPendientes;

    @Column(name = "monto_pendiente")
    private BigDecimal montoPendiente;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public DashboardAlertasView() {
    }

    public DashboardAlertasView(
            Integer id,
            Long prestamosVencidos,
            Long prestamosVencenHoy,
            Long reservasActivas,
            Long multasPendientes,
            BigDecimal montoPendiente,
            LocalDateTime fechaActualizacion) {

        this.id = id;
        this.prestamosVencidos = prestamosVencidos;
        this.prestamosVencenHoy = prestamosVencenHoy;
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

    public Long getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(Long prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

    public Long getPrestamosVencenHoy() {
        return prestamosVencenHoy;
    }

    public void setPrestamosVencenHoy(Long prestamosVencenHoy) {
        this.prestamosVencenHoy = prestamosVencenHoy;
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