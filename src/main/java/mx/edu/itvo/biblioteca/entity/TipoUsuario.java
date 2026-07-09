package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Representa un tipo de usuario dentro del sistema de gestión de biblioteca.
 *
 * Define el rol que desempeña un usuario dentro del sistema.
 *
 * @author Conce
 * @version 1.1
 * @since 1.0
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_USUARIO")
    private Integer idTipoUsuario;

    @NotBlank(message = "El nombre del tipo de usuario es obligatorio.")
    @Size(min = 3, max = 100,
            message = "El nombre debe contener entre 3 y 100 caracteres.")
    @Column(name = "NOMBRE", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    public TipoUsuario() {
    }

    public TipoUsuario(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "idTipoUsuario=" + idTipoUsuario +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                '}';
    }
}