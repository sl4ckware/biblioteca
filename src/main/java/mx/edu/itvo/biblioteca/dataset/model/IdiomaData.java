package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa un idioma utilizado por el Dataset Generator.
 *
 * <p>
 * Esta clase modela la información necesaria para generar registros
 * de la tabla idioma.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class IdiomaData extends AbstractData {

    /**
     * Código ISO del idioma.
     */
    private String codigoIso;

    /**
     * Nombre del idioma.
     */
    private String nombre;

    /**
     * Constructor vacío.
     */
    public IdiomaData() {
    }

    /**
     * Obtiene el código ISO.
     *
     * @return Código ISO.
     */
    public String getCodigoIso() {
        return codigoIso;
    }

    /**
     * Establece el código ISO.
     *
     * @param codigoIso Código ISO.
     */
    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    /**
     * Obtiene el nombre del idioma.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del idioma.
     *
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {

        return "IdiomaData{" +
                "codigoIso='" + codigoIso + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';

    }

}