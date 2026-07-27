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
@Table(name = "vw_dashboard_top_categorias")
public class DashboardTopCategoriaView {

    @Id
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "total_prestamos")
    private Long totalPrestamos;

    public DashboardTopCategoriaView() {
    }

    public DashboardTopCategoriaView(
            Long idCategoria,
            String categoria,
            Long totalPrestamos) {

        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.totalPrestamos = totalPrestamos;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

}