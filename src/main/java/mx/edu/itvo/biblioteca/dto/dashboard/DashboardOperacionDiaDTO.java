package mx.edu.itvo.biblioteca.dto.dashboard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO que contiene los indicadores
 * de operación del día.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardOperacionDiaDTO {

    /**
     * Total de préstamos realizados hoy.
     */
    private Long prestamosHoy;

    /**
     * Total de devoluciones realizadas hoy.
     */
    private Long devolucionesHoy;

    /**
     * Total de reservas realizadas hoy.
     */
    private Long reservasHoy;

    /**
     * Total de usuarios registrados hoy.
     */
    private Long usuariosRegistradosHoy;

    /**
     * Total de multas generadas hoy.
     */
    private Long multasGeneradasHoy;

    /**
     * Monto generado por multas hoy.
     */
    private BigDecimal montoMultasHoy;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío.
     */
    public DashboardOperacionDiaDTO() {
    }

    /**
     * Obtiene los préstamos realizados hoy.
     *
     * @return Préstamos de hoy.
     */
    public Long getPrestamosHoy() {
        return prestamosHoy;
    }

    /**
     * Establece los préstamos realizados hoy.
     *
     * @param prestamosHoy Préstamos de hoy.
     */
    public void setPrestamosHoy(Long prestamosHoy) {
        this.prestamosHoy = prestamosHoy;
    }

    /**
     * Obtiene las devoluciones realizadas hoy.
     *
     * @return Devoluciones de hoy.
     */
    public Long getDevolucionesHoy() {
        return devolucionesHoy;
    }

    /**
     * Establece las devoluciones realizadas hoy.
     *
     * @param devolucionesHoy Devoluciones de hoy.
     */
    public void setDevolucionesHoy(Long devolucionesHoy) {
        this.devolucionesHoy = devolucionesHoy;
    }

    /**
     * Obtiene las reservas realizadas hoy.
     *
     * @return Reservas de hoy.
     */
    public Long getReservasHoy() {
        return reservasHoy;
    }

    /**
     * Establece las reservas realizadas hoy.
     *
     * @param reservasHoy Reservas de hoy.
     */
    public void setReservasHoy(Long reservasHoy) {
        this.reservasHoy = reservasHoy;
    }

    /**
     * Obtiene los usuarios registrados hoy.
     *
     * @return Usuarios registrados hoy.
     */
    public Long getUsuariosRegistradosHoy() {
        return usuariosRegistradosHoy;
    }

    /**
     * Establece los usuarios registrados hoy.
     *
     * @param usuariosRegistradosHoy Usuarios registrados hoy.
     */
    public void setUsuariosRegistradosHoy(
            Long usuariosRegistradosHoy) {

        this.usuariosRegistradosHoy = usuariosRegistradosHoy;

    }

    /**
     * Obtiene las multas generadas hoy.
     *
     * @return Multas generadas hoy.
     */
    public Long getMultasGeneradasHoy() {
        return multasGeneradasHoy;
    }

    /**
     * Establece las multas generadas hoy.
     *
     * @param multasGeneradasHoy Multas generadas hoy.
     */
    public void setMultasGeneradasHoy(
            Long multasGeneradasHoy) {

        this.multasGeneradasHoy = multasGeneradasHoy;

    }

    /**
     * Obtiene el monto de multas generado hoy.
     *
     * @return Monto de multas.
     */
    public BigDecimal getMontoMultasHoy() {
        return montoMultasHoy;
    }

    /**
     * Establece el monto de multas generado hoy.
     *
     * @param montoMultasHoy Monto de multas.
     */
    public void setMontoMultasHoy(
            BigDecimal montoMultasHoy) {

        this.montoMultasHoy = montoMultasHoy;

    }

    /**
     * Obtiene la fecha de actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion = fechaActualizacion;

    }

}