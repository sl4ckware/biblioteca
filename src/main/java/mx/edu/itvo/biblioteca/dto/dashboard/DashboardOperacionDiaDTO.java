package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DashboardOperacionDiaDTO {

    private Integer prestamosHoy;
    private Integer devolucionesHoy;
    private Integer reservasHoy;
    private Integer usuariosRegistradosHoy;
    private Integer multasGeneradasHoy;
    private BigDecimal montoMultasHoy;
    private LocalDateTime fechaActualizacion;

    public DashboardOperacionDiaDTO() {
    }

    /* getters y setters */
}