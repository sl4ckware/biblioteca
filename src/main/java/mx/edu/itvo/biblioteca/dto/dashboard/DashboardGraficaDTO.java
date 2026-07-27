package mx.edu.itvo.biblioteca.dto.dashboard;

/**
 * DTO utilizado para representar la
 * información de las gráficas del Dashboard.
 *
 * Puede utilizarse para préstamos,
 * reservas y cualquier otra gráfica
 * estadística.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardGraficaDTO {

    /**
     * Año.
     */
    private Integer anio;

    /**
     * Mes.
     */
    private Integer mes;

    /**
     * Nombre del mes.
     */
    private String nombreMes;

    /**
     * Total general.
     */
    private Long total;

    /**
     * Primer indicador.
     */
    private Long indicador1;

    /**
     * Segundo indicador.
     */
    private Long indicador2;

    /**
     * Tercer indicador.
     */
    private Long indicador3;

    /**
     * Cuarto indicador.
     */
    private Long indicador4;

    /**
     * Constructor vacío.
     */
    public DashboardGraficaDTO() {
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getIndicador1() {
        return indicador1;
    }

    public void setIndicador1(Long indicador1) {
        this.indicador1 = indicador1;
    }

    public Long getIndicador2() {
        return indicador2;
    }

    public void setIndicador2(Long indicador2) {
        this.indicador2 = indicador2;
    }

    public Long getIndicador3() {
        return indicador3;
    }

    public void setIndicador3(Long indicador3) {
        this.indicador3 = indicador3;
    }

    public Long getIndicador4() {
        return indicador4;
    }

    public void setIndicador4(Long indicador4) {
        this.indicador4 = indicador4;
    }

}