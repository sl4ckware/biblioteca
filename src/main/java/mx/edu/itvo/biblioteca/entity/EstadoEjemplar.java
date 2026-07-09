package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa el estado físico de un ejemplar.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
@Entity
@Table(name = "estado_ejemplar")
public class EstadoEjemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_EJEMPLAR")
    private Integer idEstadoEjemplar;

    @NotBlank(message = "El nombre del estado es obligatorio.")
    @Size(min = 3, max = 50)
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 50)
    private String nombre;

    public EstadoEjemplar() {
    }

    public EstadoEjemplar(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEstadoEjemplar() {
        return idEstadoEjemplar;
    }

    public void setIdEstadoEjemplar(Integer idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoEjemplar{" +
                "idEstadoEjemplar=" + idEstadoEjemplar +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}