package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa el estado de un usuario dentro del sistema.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
@Entity
@Table(name = "estado_usuario")
public class EstadoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_USUARIO")
    private Integer idEstadoUsuario;

    @NotBlank(message = "El nombre del estado es obligatorio.")
    @Size(min = 3, max = 50)
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 50)
    private String nombre;

    public EstadoUsuario() {
    }

    public EstadoUsuario(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoUsuario{" +
                "idEstadoUsuario=" + idEstadoUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}