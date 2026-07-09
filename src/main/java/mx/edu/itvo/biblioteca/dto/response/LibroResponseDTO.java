package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver la información de un libro.
 *
 * Contiene la información bibliográfica y descriptiva necesaria
 * para su visualización en el sistema.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LibroResponseDTO {

    /**
     * Identificador del libro.
     */
    private Integer idLibro;

    /**
     * Código ISBN-13.
     */
    private String isbn13;

    /**
     * Título.
     */
    private String titulo;

    /**
     * Subtítulo.
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
     * Clasificación.
     */
    private String clasificacion;

    /**
     * Sinopsis.
     */
    private String sinopsis;

    /**
     * URL de la imagen de portada.
     */
    private String imagenPortada;

    /**
     * Identificador de la categoría.
     */
    private Integer idCategoria;

    /**
     * Nombre de la categoría.
     */
    private String categoria;

    /**
     * Identificador de la editorial.
     */
    private Integer idEditorial;

    /**
     * Nombre de la editorial.
     */
    private String editorial;

    /**
     * Identificador del idioma.
     */
    private Integer idIdioma;

    /**
     * Nombre del idioma.
     */
    private String idioma;

    /**
     * Estado del libro.
     */
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    private LocalDateTime fechaActualizacion;

    public LibroResponseDTO() {
    }

    // ======== Getters y Setters ========

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public Byte getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(Byte numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Short getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Short numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}