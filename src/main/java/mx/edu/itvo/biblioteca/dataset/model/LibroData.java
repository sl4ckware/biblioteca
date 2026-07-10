package mx.edu.itvo.biblioteca.dataset.model;

import java.time.LocalDate;

/**
 * Representa un libro utilizado por el Dataset Generator.
 *
 * <p>
 * Esta clase constituye un <strong>Mirror Model</strong> de la entidad
 * {@code Libro} del backend.
 * </p>
 *
 * <p>
 * Su única responsabilidad consiste en representar la información
 * necesaria para generar registros de la tabla {@code libro},
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
public class LibroData extends AbstractData {

    // ---------------------------------------------------------------------
    // Información bibliográfica
    // ---------------------------------------------------------------------

    /**
     * Código ISBN-13 del libro.
     */
    private String isbn13;

    /**
     * Título del libro.
     */
    private String titulo;

    /**
     * Subtítulo del libro.
     */
    private String subtitulo;

    /**
     * Número de edición.
     */
    private Byte numeroEdicion;

    /**
     * Fecha de publicación.
     */
    private LocalDate fechaPublicacion;

    /**
     * Número de páginas.
     */
    private Short numeroPaginas;

    /**
     * Clasificación bibliográfica.
     */
    private String clasificacion;

    /**
     * Sinopsis del libro.
     */
    private String sinopsis;

    /**
     * Imagen de portada.
     */
    private String imagenPortada;

    // ---------------------------------------------------------------------
    // Relaciones del dominio
    // ---------------------------------------------------------------------

    /**
     * Editorial del libro.
     */
    private EditorialData editorial;

    /**
     * Categoría del libro.
     */
    private CategoriaData categoria;

    /**
     * Idioma del libro.
     */
    private IdiomaData idioma;

    // ---------------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------------

    /**
     * Constructor vacío.
     */
    public LibroData() {
    }

    // ---------------------------------------------------------------------
    // Métodos de acceso
    // ---------------------------------------------------------------------

    /**
     * Obtiene el ISBN-13.
     *
     * @return ISBN-13.
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * Establece el ISBN-13.
     *
     * @param isbn13 ISBN-13.
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * Obtiene el título.
     *
     * @return Título.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título.
     *
     * @param titulo Título.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el subtítulo.
     *
     * @return Subtítulo.
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * Establece el subtítulo.
     *
     * @param subtitulo Subtítulo.
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * Obtiene el número de edición.
     *
     * @return Número de edición.
     */
    public Byte getNumeroEdicion() {
        return numeroEdicion;
    }

    /**
     * Establece el número de edición.
     *
     * @param numeroEdicion Número de edición.
     */
    public void setNumeroEdicion(Byte numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    /**
     * Obtiene la fecha de publicación.
     *
     * @return Fecha de publicación.
     */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Establece la fecha de publicación.
     *
     * @param fechaPublicacion Fecha de publicación.
     */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Obtiene el número de páginas.
     *
     * @return Número de páginas.
     */
    public Short getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * Establece el número de páginas.
     *
     * @param numeroPaginas Número de páginas.
     */
    public void setNumeroPaginas(Short numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * Obtiene la clasificación bibliográfica.
     *
     * @return Clasificación.
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Establece la clasificación bibliográfica.
     *
     * @param clasificacion Clasificación.
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Obtiene la sinopsis.
     *
     * @return Sinopsis.
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * Establece la sinopsis.
     *
     * @param sinopsis Sinopsis.
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * Obtiene la imagen de portada.
     *
     * @return Imagen de portada.
     */
    public String getImagenPortada() {
        return imagenPortada;
    }

    /**
     * Establece la imagen de portada.
     *
     * @param imagenPortada Imagen de portada.
     */
    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    /**
     * Obtiene la editorial.
     *
     * @return Editorial.
     */
    public EditorialData getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial.
     *
     * @param editorial Editorial.
     */
    public void setEditorial(EditorialData editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene la categoría.
     *
     * @return Categoría.
     */
    public CategoriaData getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría.
     *
     * @param categoria Categoría.
     */
    public void setCategoria(CategoriaData categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el idioma.
     *
     * @return Idioma.
     */
    public IdiomaData getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma.
     *
     * @param idioma Idioma.
     */
    public void setIdioma(IdiomaData idioma) {
        this.idioma = idioma;
    }

    // ---------------------------------------------------------------------
    // Object
    // ---------------------------------------------------------------------

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información del libro.
     */
    @Override
    public String toString() {

        return "LibroData{" +
                "sequence=" + getSequence() +
                ", isbn13='" + isbn13 + '\'' +
                ", titulo='" + titulo + '\'' +
                ", numeroEdicion=" + numeroEdicion +
                ", fechaPublicacion=" + fechaPublicacion +
                ", numeroPaginas=" + numeroPaginas +
                ", activo=" + getActivo() +
                '}';

    }

}