package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa la relación entre un libro y un autor
 * dentro del sistema de gestión de biblioteca.
 *
 * Esta entidad implementa la relación muchos a muchos
 * entre las entidades Libro y Autor.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Entity
@Table(name = "libro_autor")
public class LibroAutor {

    /**
     * Identificador único de la relación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIBRO_AUTOR")
    private Integer idLibroAutor;

    /**
     * Libro asociado.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LIBRO", nullable = false)
    private Libro libro;

    /**
     * Autor asociado.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AUTOR", nullable = false)
    private Autor autor;

    /**
     * Fecha de creación del registro.
     */
    @Column(name = "FECHA_CREACION", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de última actualización del registro.
     */
    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public LibroAutor() {
    }

    /**
     * Constructor para crear una relación libro-autor.
     *
     * @param libro Libro relacionado.
     * @param autor Autor relacionado.
     */
    public LibroAutor(Libro libro, Autor autor) {
        this.libro = libro;
        this.autor = autor;
    }

    public Integer getIdLibroAutor() {
        return idLibroAutor;
    }

    public void setIdLibroAutor(Integer idLibroAutor) {
        this.idLibroAutor = idLibroAutor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    /**
     * Devuelve una representación en texto del objeto LibroAutor.
     *
     * No se incluyen las entidades relacionadas para evitar
     * recursividad y problemas con FetchType.LAZY.
     *
     * @return Información de la relación.
     */
    @Override
    public String toString() {
        return "LibroAutor{" +
                "idLibroAutor=" + idLibroAutor +
                '}';
    }

}