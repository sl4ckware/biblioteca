package mx.edu.itvo.biblioteca.projection.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DashboardOperacionDiaProjection {

    Integer getPrestamosHoy();

    Integer getDevolucionesHoy();

    Integer getReservasHoy();

    Integer getUsuariosRegistradosHoy();

    Integer getMultasGeneradasHoy();

    BigDecimal getMontoMultasHoy();

    LocalDateTime getFechaActualizacion();

}