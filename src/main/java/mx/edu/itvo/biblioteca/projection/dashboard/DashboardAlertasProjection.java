package mx.edu.itvo.biblioteca.projection.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DashboardAlertasProjection {

    Integer getPrestamosVencidos();

    Integer getPrestamosVencenHoy();

    Integer getReservasActivas();

    Integer getMultasPendientes();

    BigDecimal getMontoPendiente();

    LocalDateTime getFechaActualizacion();

}