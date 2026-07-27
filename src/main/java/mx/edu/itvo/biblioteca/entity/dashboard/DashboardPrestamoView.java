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
@Table(name = "vw_dashboard_prestamos")
public class DashboardPrestamoView {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "nombre_mes")
    private String nombreMes;

    @Column(name = "total_prestamos")
    private Long totalPrestamos;

    @Column(name = "prestamos_activos")
    private Long prestamosActivos;

    @Column(name = "prestamos_devueltos")
    private Long prestamosDevueltos;

    @Column(name = "prestamos_vencidos")
    private Long prestamosVencidos;

    public DashboardPrestamoView() {
    }

    public DashboardPrestamoView(
            String id,
            Integer anio,
            Integer mes,
            String nombreMes,
            Long totalPrestamos,
            Long prestamosActivos,
            Long prestamosDevueltos,
            Long prestamosVencidos) {

        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.nombreMes = nombreMes;
        this.totalPrestamos = totalPrestamos;
        this.prestamosActivos = prestamosActivos;
        this.prestamosDevueltos = prestamosDevueltos;
        this.prestamosVencidos = prestamosVencidos;
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

    public Long getPrestamosDevueltos() {
        return prestamosDevueltos;
    }

    public void setPrestamosDevueltos(Long prestamosDevueltos) {
        this.prestamosDevueltos = prestamosDevueltos;
    }

    public Long getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(Long prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

}