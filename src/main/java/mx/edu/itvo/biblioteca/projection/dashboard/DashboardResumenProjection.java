package mx.edu.itvo.biblioteca.projection.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DashboardResumenProjection {

    Integer getTotalLibros();

    Integer getTotalUsuarios();

    Integer getTotalEjemplares();

    Integer getEjemplaresDisponibles();

    Integer getEjemplaresPrestados();

    Integer getEjemplaresMantenimiento();

    Integer getPrestamosActivos();

    Integer getPrestamosVencidos();

    Integer getReservasActivas();

    Integer getMultasPendientes();

    BigDecimal getMontoPendiente();

    LocalDateTime getFechaActualizacion();

}