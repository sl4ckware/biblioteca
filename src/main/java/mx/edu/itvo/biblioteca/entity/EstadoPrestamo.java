package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa el estado de un préstamo dentro del sistema.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
@Entity
@Table(name = "estado_prestamo")
public class EstadoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_PRESTAMO")
    private Integer idEstadoPrestamo;

    @NotBlank(message = "El nombre del estado es obligatorio.")
    @Size(min = 3, max = 50)
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 50)
    private String nombre;

    public EstadoPrestamo() {
    }

    public EstadoPrestamo(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEstadoPrestamo() {
        return idEstadoPrestamo;
    }

    public void setIdEstadoPrestamo(Integer idEstadoPrestamo) {
        this.idEstadoPrestamo = idEstadoPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoPrestamo{" +
                "idEstadoPrestamo=" + idEstadoPrestamo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}