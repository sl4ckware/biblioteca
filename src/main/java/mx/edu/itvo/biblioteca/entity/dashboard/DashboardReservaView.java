package mx.edu.itvo.biblioteca.entity.dashboard;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 *
 */
@Entity
@Immutable
@Table(name = "vw_dashboard_reservas")
public class DashboardReservaView {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "nombre_mes")
    private String nombreMes;

    @Column(name = "total_reservas")
    private Long totalReservas;

    @Column(name = "reservas_activas")
    private Long reservasActivas;

    @Column(name = "reservas_atendidas")
    private Long reservasAtendidas;

    @Column(name = "reservas_canceladas")
    private Long reservasCanceladas;

    @Column(name = "reservas_expiradas")
    private Long reservasExpiradas;

    public DashboardReservaView() {
    }

    public DashboardReservaView(
            String id,
            Integer anio,
            Integer mes,
            String nombreMes,
            Long totalReservas,
            Long reservasActivas,
            Long reservasAtendidas,
            Long reservasCanceladas,
            Long reservasExpiradas) {

        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.nombreMes = nombreMes;
        this.totalReservas = totalReservas;
        this.reservasActivas = reservasActivas;
        this.reservasAtendidas = reservasAtendidas;
        this.reservasCanceladas = reservasCanceladas;
        this.reservasExpiradas = reservasExpiradas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public Long getTotalReservas() {
        return totalReservas;
    }

    public void setTotalReservas(Long totalReservas) {
        this.totalReservas = totalReservas;
    }

    public Long getReservasActivas() {
        return reservasActivas;
    }

    public void setReservasActivas(Long reservasActivas) {
        this.reservasActivas = reservasActivas;
    }

    public Long getReservasAtendidas() {
        return reservasAtendidas;
    }

    public void setReservasAtendidas(Long reservasAtendidas) {
        this.reservasAtendidas = reservasAtendidas;
    }

    public Long getReservasCanceladas() {
        return reservasCanceladas;
    }

    public void setReservasCanceladas(Long reservasCanceladas) {
        this.reservasCanceladas = reservasCanceladas;
    }

    public Long getReservasExpiradas() {
        return reservasExpiradas;
    }

    public void setReservasExpiradas(Long reservasExpiradas) {
        this.reservasExpiradas = reservasExpiradas;
    }

}