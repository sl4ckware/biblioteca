package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa los estados
 * de una reserva.
 *
 * <p>
 * Permite identificar la situación
 * actual de una reserva dentro del
 * sistema.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
@Entity
@Table(name = "estado_reserva")
public class EstadoReserva {

    /**
     * Identificador del estado.
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_reserva")
    private Integer idEstadoReserva;

    /**
     * Nombre del estado.
     */
    @Column(
            name = "nombre",
            nullable = false,
            unique = true,
            length = 30)
    private String nombre;

    /**
     * Constructor vacío.
     */
    public EstadoReserva() {

    }

    /**
     * Obtiene el identificador.
     *
     * @return Identificador.
     */
    public Integer getIdEstadoReserva() {

        return idEstadoReserva;

    }

    /**
     * Establece el identificador.
     *
     * @param idEstadoReserva Identificador.
     */
    public void setIdEstadoReserva(
            Integer idEstadoReserva) {

        this.idEstadoReserva =
                idEstadoReserva;

    }

    /**
     * Obtiene el nombre.
     *
     * @return Nombre.
     */
    public String getNombre() {

        return nombre;

    }

    /**
     * Establece el nombre.
     *
     * @param nombre Nombre.
     */
    public void setNombre(
            String nombre) {

        this.nombre =
                nombre;

    }

}