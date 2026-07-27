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
@Table(name = "vw_dashboard_top_editoriales")
public class DashboardTopEditorialView {

    @Id
    @Column(name = "id_editorial")
    private Long idEditorial;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "total_prestamos")
    private Long totalPrestamos;

    public DashboardTopEditorialView() {
    }

    public DashboardTopEditorialView(
            Long idEditorial,
            String editorial,
            Long totalPrestamos) {

        this.idEditorial = idEditorial;
        this.editorial = editorial;
        this.totalPrestamos = totalPrestamos;
    }

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

}