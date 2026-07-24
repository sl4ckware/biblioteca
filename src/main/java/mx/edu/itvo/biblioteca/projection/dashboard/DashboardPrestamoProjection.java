package mx.edu.itvo.biblioteca.projection.dashboard;

public interface DashboardPrestamoProjection {

    Integer getAnio();

    Integer getMes();

    String getNombreMes();

    Integer getTotalPrestamos();

    Integer getPrestamosActivos();

    Integer getPrestamosDevueltos();

    Integer getPrestamosVencidos();

}