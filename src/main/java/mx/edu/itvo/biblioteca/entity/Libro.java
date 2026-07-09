package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un libro dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad almacena la información bibliográfica de cada libro
 * registrado en el sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "libro")
public class Libro {

    /**
     * Identificador único del libro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIBRO")
    private Integer idLibro;

    /**
     * Código ISBN-13.
     */
    @Size(min = 13, max = 13,
            message = "El ISBN debe contener exactamente 13 caracteres.")
    @Column(name = "ISBN13", unique = true, length = 13)
    private String isbn13;

    /**
     * Título del libro.
     */
    @NotBlank(message = "El título es obligatorio.")
    @Size(min = 3, max = 250,
            message = "El título debe contener entre 3 y 250 caracteres.")
    @Column(name = "TITULO", nullable = false, length = 250)
    private String titulo;

    /**
     * Subtítulo del libro.
     */
    @Size(max = 250,
            message = "El subtítulo no puede exceder los 250 caracteres.")
    @Column(name = "SUBTITULO", length = 250)
    private String subtitulo;

    /**
     * Número de edición.
     */
    @NotNull(message = "El número de edición es obligatorio.")
    @Min(value = 1, message = "La edición mínima es 1.")
    @Column(name = "NUMERO_EDICION")
    private Byte numeroEdicion;

    /**
     * Fecha de publicación.
     */
    @Column(name = "FECHA_PUBLICACION")
    private LocalDate fechaPublicacion;

    /**
     * Número de páginas.
     */
    @Positive(message = "El número de páginas debe ser mayor que cero.")
    @Column(name = "NUMERO_PAGINAS")
    private Short numeroPaginas;

    /**
     * Clasificación bibliográfica.
     */
    @Size(max = 30)
    @Column(name = "CLASIFICACION", length = 30)
    private String clasificacion;

    /**
     * Sinopsis del libro.
     */
    @Column(name = "SINOPSIS", columnDefinition = "TEXT")
    private String sinopsis;

    /**
     * Imagen de portada.
     */
    @Size(max = 500)
    @Column(name = "IMAGEN_PORTADA", length = 500)
    private String imagenPortada;

    /**
     * Estado del libro.
     */
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación.
     */
    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de actualización.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Editorial del libro.
     */
    @NotNull(message = "La editorial es obligatoria.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EDITORIAL", nullable = false)
    private Editorial editorial;

    /**
     * Categoría del libro.
     */
    @NotNull(message = "La categoría es obligatoria.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    /**
     * Idioma del libro.
     */
    @NotNull(message = "El idioma es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_IDIOMA", nullable = false)
    private Idioma idioma;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Libro() {
    }

    /**
     * Constructor para crear un libro.
     */
    public Libro(String isbn13, String titulo, String subtitulo,
                 Byte numeroEdicion, LocalDate fechaPublicacion,
                 Short numeroPaginas, String clasificacion,
                 String sinopsis, String imagenPortada,
                 Editorial editorial, Categoria categoria,
                 Idioma idioma, Boolean activo) {

        this.isbn13 = isbn13;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.numeroEdicion = numeroEdicion;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.imagenPortada = imagenPortada;
        this.editorial = editorial;
        this.categoria = categoria;
        this.idioma = idioma;
        this.activo = activo;
    }

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    /**
 * Establece la fecha de creación.
 *
 * @param fechaCreacion fecha de creación.
 */
public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
}

/**
 * Establece la fecha de actualización.
 *
 * @param fechaActualizacion fecha de actualización.
 */
public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
}

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", isbn13='" + isbn13 + '\'' +
                ", titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", numeroEdicion=" + numeroEdicion +
                ", fechaPublicacion=" + fechaPublicacion +
                ", numeroPaginas=" + numeroPaginas +
                ", clasificacion='" + clasificacion + '\'' +
                ", activo=" + activo +
                '}';
    }
}