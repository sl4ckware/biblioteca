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
@Table(name = "vw_dashboard_operacion_dia")
public class DashboardOperacionDiaView {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "prestamos_hoy")
    private Long prestamosHoy;

    @Column(name = "devoluciones_hoy")
    private Long devolucionesHoy;

    @Column(name = "reservas_hoy")
    private Long reservasHoy;

    @Column(name = "usuarios_registrados_hoy")
    private Long usuariosRegistradosHoy;

    @Column(name = "multas_generadas_hoy")
    private Long multasGeneradasHoy;

    @Column(name = "monto_multas_hoy")
    private BigDecimal montoMultasHoy;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public DashboardOperacionDiaView() {
    }

    public DashboardOperacionDiaView(
            Integer id,
            Long prestamosHoy,
            Long devolucionesHoy,
            Long reservasHoy,
            Long usuariosRegistradosHoy,
            Long multasGeneradasHoy,
            BigDecimal montoMultasHoy,
            LocalDateTime fechaActualizacion) {

        this.id = id;
        this.prestamosHoy = prestamosHoy;
        this.devolucionesHoy = devolucionesHoy;
        this.reservasHoy = reservasHoy;
        this.usuariosRegistradosHoy = usuariosRegistradosHoy;
        this.multasGeneradasHoy = multasGeneradasHoy;
        this.montoMultasHoy = montoMultasHoy;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrestamosHoy() {
        return prestamosHoy;
    }

    public void setPrestamosHoy(Long prestamosHoy) {
        this.prestamosHoy = prestamosHoy;
    }

    public Long getDevolucionesHoy() {
        return devolucionesHoy;
    }

    public void setDevolucionesHoy(Long devolucionesHoy) {
        this.devolucionesHoy = devolucionesHoy;
    }

    public Long getReservasHoy() {
        return reservasHoy;
    }

    public void setReservasHoy(Long reservasHoy) {
        this.reservasHoy = reservasHoy;
    }

    public Long getUsuariosRegistradosHoy() {
        return usuariosRegistradosHoy;
    }

    public void setUsuariosRegistradosHoy(Long usuariosRegistradosHoy) {
        this.usuariosRegistradosHoy = usuariosRegistradosHoy;
    }

    public Long getMultasGeneradasHoy() {
        return multasGeneradasHoy;
    }

    public void setMultasGeneradasHoy(Long multasGeneradasHoy) {
        this.multasGeneradasHoy = multasGeneradasHoy;
    }

    public BigDecimal getMontoMultasHoy() {
        return montoMultasHoy;
    }

    public void setMontoMultasHoy(BigDecimal montoMultasHoy) {
        this.montoMultasHoy = montoMultasHoy;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}