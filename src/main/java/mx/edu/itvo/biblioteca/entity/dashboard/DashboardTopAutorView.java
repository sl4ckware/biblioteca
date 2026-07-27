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
@Table(name = "vw_dashboard_top_autores")
public class DashboardTopAutorView {

    @Id
    @Column(name = "id_autor")
    private Long idAutor;

    @Column(name = "autor")
    private String autor;

    @Column(name = "total_prestamos")
    private Long totalPrestamos;

    public DashboardTopAutorView() {
    }

    public DashboardTopAutorView(
            Long idAutor,
            String autor,
            Long totalPrestamos) {

        this.idAutor = idAutor;
        this.autor = autor;
        this.totalPrestamos = totalPrestamos;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

}