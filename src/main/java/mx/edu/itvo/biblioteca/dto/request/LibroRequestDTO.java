package mx.edu.itvo.biblioteca.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * DTO para registrar o actualizar libros.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class LibroRequestDTO {

    /**
     * ISBN-13 del libro.
     */
    @Size(min = 13, max = 13,
            message = "El ISBN debe contener exactamente 13 caracteres.")
    private String isbn13;

    /**
     * Título del libro.
     */
    @NotBlank(message = "El título es obligatorio.")
    @Size(min = 3, max = 250,
            message = "El título debe contener entre 3 y 250 caracteres.")
    private String titulo;

    /**
     * Subtítulo.
     */
    @Size(max = 250,
            message = "El subtítulo no puede exceder los 250 caracteres.")
    private String subtitulo;

    /**
     * Número de edición.
     */
    @NotNull(message = "La edición es obligatoria.")
    @Min(value = 1, message = "La edición mínima es 1.")
    private Byte numeroEdicion;

    /**
     * Fecha de publicación.
     */
    private LocalDate fechaPublicacion;

    /**
     * Número de páginas.
     */
    @Positive(message = "El número de páginas debe ser mayor que cero.")
    private Short numeroPaginas;

    /**
     * Clasificación bibliográfica.
     */
    @Size(max = 30)
    private String clasificacion;

    /**
     * Sinopsis.
     */
    private String sinopsis;

    /**
     * Ruta de la imagen de portada.
     */
    @Size(max = 500)
    private String imagenPortada;

    /**
     * Categoría.
     */
    @NotNull(message = "La categoría es obligatoria.")
    private Integer idCategoria;

    /**
     * Editorial.
     */
    @NotNull(message = "La editorial es obligatoria.")
    private Integer idEditorial;

    /**
     * Idioma.
     */
    @NotNull(message = "El idioma es obligatorio.")
    private Integer idIdioma;

    /**
     * Estado.
     */
    private Boolean activo = true;

    public LibroRequestDTO() {
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

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}