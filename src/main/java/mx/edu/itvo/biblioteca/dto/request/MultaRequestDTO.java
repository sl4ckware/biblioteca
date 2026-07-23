package mx.edu.itvo.biblioteca.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * DTO utilizado para registrar
 * una nueva multa.
 * ============================================================
 *
 * <p>
 * Este DTO únicamente contiene la información
 * proporcionada por el cliente.
 * </p>
 *
 * <p>
 * Los datos de negocio como:
 * </p>
 *
 * <ul>
 *     <li>Estado.</li>
 *     <li>Fecha de generación.</li>
 *     <li>Fecha de pago.</li>
 *     <li>Activo.</li>
 *     <li>Folio.</li>
 * </ul>
 *
 * <p>
 * Son asignados automáticamente por el
 * servicio durante el registro de la multa.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 19
 */
public class MultaRequestDTO {

    /**
     * Identificador del préstamo.
     */
    @NotNull(
            message = "El préstamo es obligatorio.")
    private Integer idPrestamo;

    /**
     * Monto de la multa.
     */
    @NotNull(
            message = "El monto es obligatorio.")
    @DecimalMin(
            value = "0.01",
            inclusive = true,
            message = "El monto debe ser mayor que cero.")
    private BigDecimal monto;

    /**
     * Tipo de multa.
     */
    @NotBlank(
            message = "El tipo de multa es obligatorio.")
    @Size(
            max = 30,
            message = "El tipo no debe superar los 30 caracteres.")
    private String tipo;

    /**
     * Observaciones.
     */
    @Size(
            max = 255,
            message = "Las observaciones no deben superar los 255 caracteres.")
    private String observaciones;

    /**
     * Constructor.
     */
    public MultaRequestDTO() {

    }

    /**
     * Obtiene el identificador
     * del préstamo.
     *
     * @return Identificador.
     */
    public Integer getIdPrestamo() {

        return idPrestamo;

    }

    /**
     * Establece el identificador
     * del préstamo.
     *
     * @param idPrestamo Identificador.
     */
    public void setIdPrestamo(
            Integer idPrestamo) {

        this.idPrestamo = idPrestamo;

    }

    /**
     * Obtiene el monto.
     *
     * @return Monto.
     */
    public BigDecimal getMonto() {

        return monto;

    }

    /**
     * Establece el monto.
     *
     * @param monto Monto.
     */
    public void setMonto(
            BigDecimal monto) {

        this.monto = monto;

    }

    /**
     * Obtiene el tipo de multa.
     *
     * @return Tipo.
     */
    public String getTipo() {

        return tipo;

    }

    /**
     * Establece el tipo de multa.
     *
     * @param tipo Tipo.
     */
    public void setTipo(
            String tipo) {

        this.tipo = tipo;

    }

    /**
     * Obtiene las observaciones.
     *
     * @return Observaciones.
     */
    public String getObservaciones() {

        return observaciones;

    }

    /**
     * Establece las observaciones.
     *
     * @param observaciones Observaciones.
     */
    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }

    /**
     * Devuelve una representación textual
     * del DTO.
     *
     * @return Cadena representativa.
     */
    @Override
    public String toString() {

        return "MultaRequestDTO{"
                + "idPrestamo=" + idPrestamo
                + ", monto=" + monto
                + ", tipo='" + tipo + '\''
                + ", observaciones='" + observaciones + '\''
                + '}';

    }

}