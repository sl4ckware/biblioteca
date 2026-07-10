package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa una categoría utilizada por el Dataset Generator.
 *
 * <p>
 * Esta clase constituye un <strong>Mirror Model</strong> de la entidad
 * {@code Categoria} del backend.
 * </p>
 *
 * <p>
 * Su única responsabilidad consiste en representar la información
 * necesaria para generar registros de la tabla {@code categoria},
 * sin depender de Spring Boot, JPA o Jakarta Persistence.
 * </p>
 *
 * <p>
 * El identificador de la base de datos no forma parte de este modelo,
 * ya que será generado automáticamente por MariaDB. Para establecer
 * relaciones durante la construcción del dataset se utiliza el atributo
 * {@code sequence} heredado de {@link AbstractData}.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class CategoriaData extends AbstractData {

    // ---------------------------------------------------------------------
    // Información general
    // ---------------------------------------------------------------------

    /**
     * Código único de la categoría.
     */
    private String codigo;

    /**
     * Nombre de la categoría.
     */
    private String nombre;

    /**
     * Descripción de la categoría.
     */
    private String descripcion;

    // ---------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------

    /**
     * Constructor vacío.
     */
    public CategoriaData() {
    }

    // ---------------------------------------------------------------------
    // Métodos de acceso
    // ---------------------------------------------------------------------

    /**
     * Obtiene el código de la categoría.
     *
     * @return Código.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de la categoría.
     *
     * @param codigo Código.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la categoría.
     *
     * @return Descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     *
     * @param descripcion Descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // ---------------------------------------------------------------------
    // Object
    // ---------------------------------------------------------------------

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información de la categoría.
     */
    @Override
    public String toString() {

        return "CategoriaData{" +
                "sequence=" + getSequence() +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + getActivo() +
                '}';

    }

}