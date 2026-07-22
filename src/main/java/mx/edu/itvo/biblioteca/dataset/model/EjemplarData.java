package mx.edu.itvo.biblioteca.dataset.model;

import java.time.LocalDate;

/**
 * Representa un ejemplar físico de un libro utilizado por el
 * Dataset Generator.
 *
 * <p>
 * Un libro puede poseer uno o varios ejemplares físicos, cada uno
 * con un código de inventario, estado y ubicación propios.
 * </p>
 *
 * <p>
 * Esta clase constituye un <strong>Mirror Model</strong> de la
 * entidad {@code Ejemplar} del backend.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class EjemplarData extends AbstractData {

    /**
     * Código único del ejemplar.
     */
    private String codigoInventario;

    /**
     * Número consecutivo del ejemplar para un mismo libro.
     */
    private Integer numeroEjemplar;

    /**
     * Estado del ejemplar.
     */
    private EstadoEjemplarData estado;

    /**
     * Ubicación física dentro de la biblioteca.
     */
    private String ubicacion;

    /**
     * Fecha de incorporación al inventario.
     */
    private LocalDate fechaAlta;

    /**
     * Observaciones del ejemplar.
     */
    private String observaciones;

    /**
     * Libro al que pertenece el ejemplar.
     */
    private LibroData libro;

    /**
     * Constructor vacío.
     */
    public EjemplarData() {
    }

    /**
     * Obtiene el código de inventario.
     *
     * @return Código de inventario.
     */
    public String getCodigoInventario() {
        return codigoInventario;
    }

    /**
     * Establece el código de inventario.
     *
     * @param codigoInventario Código de inventario.
     */
    public void setCodigoInventario(
            String codigoInventario) {

        this.codigoInventario = codigoInventario;

    }

    /**
     * Obtiene el estado.
     *
     * @return Estado.
     */
    public EstadoEjemplarData getEstado() {
        return estado;
    }

    /**
     * Establece el estado.
     *
     * @param estado Estado.
     */
    public void setEstado(
            EstadoEjemplarData estado) {

        this.estado = estado;

    }

    /**
     * Obtiene la ubicación.
     *
     * @return Ubicación.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación.
     *
     * @param ubicacion Ubicación.
     */
    public void setUbicacion(
            String ubicacion) {

        this.ubicacion = ubicacion;

    }

    /**
     * Obtiene la fecha de alta.
     *
     * @return Fecha de alta.
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta.
     *
     * @param fechaAlta Fecha de alta.
     */
    public void setFechaAlta(
            LocalDate fechaAlta) {

        this.fechaAlta = fechaAlta;

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
     * Obtiene el libro.
     *
     * @return Libro.
     */
    public LibroData getLibro() {
        return libro;
    }

    /**
     * Establece el libro.
     *
     * @param libro Libro.
     */
    public void setLibro(
            LibroData libro) {

        this.libro = libro;

    }

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información del ejemplar.
     */
    @Override
    public String toString() {

        return "EjemplarData{"
                + "sequence=" + getSequence()
                + ", codigoInventario='" + codigoInventario + '\''
                + ", estado="
                + (estado != null
                        ? estado.getNombre()
                        : null)
                + ", libro="
                + (libro != null
                        ? libro.getTitulo()
                        : null)
                + '}';

    }

}