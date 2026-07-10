package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa una editorial utilizada por el Dataset Generator.
 *
 * <p>
 * Esta clase constituye un <strong>Mirror Model</strong> de la entidad
 * {@code Editorial} del backend.
 * </p>
 *
 * <p>
 * Su única responsabilidad consiste en representar la información
 * necesaria para generar registros de la tabla {@code editorial},
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
public class EditorialData extends AbstractData {

    // ---------------------------------------------------------------------
    // Información general
    // ---------------------------------------------------------------------

    /**
     * Nombre de la editorial.
     */
    private String nombre;

    /**
     * País de origen.
     */
    private String pais;

    /**
     * Ciudad donde se ubica la editorial.
     */
    private String ciudad;

    /**
     * Número telefónico de contacto.
     */
    private String telefono;

    /**
     * Correo electrónico.
     */
    private String correo;

    /**
     * Sitio web oficial.
     */
    private String sitioWeb;

    // ---------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------

    /**
     * Constructor vacío.
     */
    public EditorialData() {
    }

    // ---------------------------------------------------------------------
    // Métodos de acceso
    // ---------------------------------------------------------------------

    /**
     * Obtiene el nombre de la editorial.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la editorial.
     *
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el país.
     *
     * @return País.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país.
     *
     * @param pais País.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la ciudad.
     *
     * @return Ciudad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad.
     *
     * @param ciudad Ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el teléfono.
     *
     * @return Teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono.
     *
     * @param telefono Teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico.
     *
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico.
     *
     * @param correo Correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el sitio web oficial.
     *
     * @return Sitio web.
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Establece el sitio web oficial.
     *
     * @param sitioWeb Sitio web.
     */
    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    // ---------------------------------------------------------------------
    // Object
    // ---------------------------------------------------------------------

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información de la editorial.
     */
    @Override
    public String toString() {

        return "EditorialData{" +
                "sequence=" + getSequence() +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", sitioWeb='" + sitioWeb + '\'' +
                ", activo=" + getActivo() +
                '}';

    }

}