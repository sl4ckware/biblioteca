package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa la relación entre un libro y un autor utilizada por el
 * Dataset Generator.
 *
 * <p>
 * Esta clase constituye un Mirror Model de la entidad LibroAutor del
 * backend y permite generar los registros de la tabla intermedia
 * libro_autor sin depender de JPA.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LibroAutorData extends AbstractData {

    /**
     * Libro asociado.
     */
    private LibroData libro;

    /**
     * Autor asociado.
     */
    private AutorData autor;

    /**
     * Constructor vacío.
     */
    public LibroAutorData() {
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
     * Obtiene el autor.
     *
     * @return Autor.
     */
    public AutorData getAutor() {
        return autor;
    }

    /**
     * Establece el autor.
     *
     * @param autor Autor.
     */
    public void setAutor(
            AutorData autor) {

        this.autor = autor;

    }

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información de la relación.
     */
    @Override
    public String toString() {

        return "LibroAutorData{"
                + "sequence=" + getSequence()
                + ", libro="
                + (libro != null
                        ? libro.getSequence()
                        : null)
                + ", autor="
                + (autor != null
                        ? autor.getSequence()
                        : null)
                + ", activo="
                + getActivo()
                + '}';

    }

}