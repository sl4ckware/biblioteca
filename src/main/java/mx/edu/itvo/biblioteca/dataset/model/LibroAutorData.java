package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa la relación entre un libro y un autor.
 *
 * <p>
 * Esta clase modela los registros que serán insertados en la tabla
 * libro_autor durante la generación del dataset.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LibroAutorData {

    /**
     * ISBN-13 del libro.
     */
    private String isbn13;

    /**
     * Identificador del autor.
     */
    private Integer idAutor;

    /**
     * Constructor vacío.
     */
    public LibroAutorData() {
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return ISBN.
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn13 ISBN.
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * Obtiene el identificador del autor.
     *
     * @return Identificador.
     */
    public Integer getIdAutor() {
        return idAutor;
    }

    /**
     * Establece el identificador del autor.
     *
     * @param idAutor Identificador.
     */
    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {

        return "LibroAutorData{" +
                "isbn13='" + isbn13 + '\'' +
                ", idAutor=" + idAutor +
                '}';

    }

}