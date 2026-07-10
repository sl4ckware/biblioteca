package mx.edu.itvo.biblioteca.dataset.model;

import java.time.LocalDateTime;

/**
 * Clase base para todos los modelos utilizados por el Dataset Generator.
 *
 * <p>
 * Esta clase representa la información común compartida por los
 * Mirror Models del proyecto Biblioteca.
 * </p>
 *
 * <p>
 * No forma parte del modelo JPA ni depende de Spring Boot.
 * Su única responsabilidad consiste en centralizar los atributos
 * comunes utilizados durante la generación del dataset.
 * </p>
 *
 * <p>
 * El atributo {@code sequence} corresponde a un identificador interno
 * empleado únicamente por el Dataset Generator para establecer
 * relaciones entre objetos antes de generar las sentencias SQL.
 * No representa el identificador de la base de datos.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public abstract class AbstractData {

    // ---------------------------------------------------------------------
    // Identificación interna
    // ---------------------------------------------------------------------

    /**
     * Identificador interno utilizado por el Dataset Generator.
     *
     * <p>
     * Este valor permite relacionar objetos durante la generación
     * del dataset antes de que existan los identificadores reales
     * asignados por la base de datos.
     * </p>
     */
    private Integer sequence;

    // ---------------------------------------------------------------------
    // Auditoría
    // ---------------------------------------------------------------------

    /**
     * Indica si el registro se encuentra activo.
     */
    private Boolean activo;

    /**
     * Fecha de creación del registro.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de la última actualización del registro.
     */
    private LocalDateTime fechaActualizacion;

    // ---------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------

    /**
     * Constructor protegido.
     *
     * <p>
     * Evita la instanciación directa de la clase base.
     * </p>
     */
    protected AbstractData() {
    }

    // ---------------------------------------------------------------------
    // Métodos de acceso
    // ---------------------------------------------------------------------

    /**
     * Obtiene el identificador interno del Dataset Generator.
     *
     * @return Identificador interno.
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * Establece el identificador interno del Dataset Generator.
     *
     * @param sequence Identificador interno.
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * Obtiene el estado del registro.
     *
     * @return {@code true} si el registro se encuentra activo;
     *         en caso contrario {@code false}.
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * Establece el estado del registro.
     *
     * @param activo Estado del registro.
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return Fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación.
     *
     * @param fechaCreacion Fecha de creación.
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene la fecha de la última actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha de la última actualización.
     *
     * @param fechaActualizacion Fecha de actualización.
     */
    public void setFechaActualizacion(
            LocalDateTime fechaActualizacion) {

        this.fechaActualizacion = fechaActualizacion;

    }

    // ---------------------------------------------------------------------
    // Object
    // ---------------------------------------------------------------------

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Cadena representativa del objeto.
     */
    @Override
    public String toString() {

        return "AbstractData{" +
                "sequence=" + sequence +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';

    }

}