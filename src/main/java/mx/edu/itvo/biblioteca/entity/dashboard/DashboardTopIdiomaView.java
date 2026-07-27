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
@Table(name = "vw_dashboard_top_idiomas")
public class DashboardTopIdiomaView {

    @Id
    @Column(name = "id_idioma")
    private Long idIdioma;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "total_prestamos")
    private Long totalPrestamos;

    public DashboardTopIdiomaView() {
    }

    public DashboardTopIdiomaView(
            Long idIdioma,
            String idioma,
            Long totalPrestamos) {

        this.idIdioma = idIdioma;
        this.idioma = idioma;
        this.totalPrestamos = totalPrestamos;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

}