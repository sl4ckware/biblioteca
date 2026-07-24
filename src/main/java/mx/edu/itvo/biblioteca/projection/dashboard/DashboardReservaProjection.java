package mx.edu.itvo.biblioteca.projection.dashboard;

public interface DashboardReservaProjection {

    Integer getAnio();

    Integer getMes();

    String getNombreMes();

    Integer getTotalReservas();

    Integer getReservasActivas();

    Integer getReservasAtendidas();

    Integer getReservasCanceladas();

    Integer getReservasExpiradas();

}