package mx.edu.itvo.biblioteca.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Representa un préstamo realizado dentro del
 * Sistema Integral de Biblioteca.
 *
 * <p>
 * Cada préstamo registra la entrega de un ejemplar
 * a un usuario y el bibliotecario responsable del
 * movimiento.
 * </p>
 *
 * @author Conce
 * @version 4.0
 * @since Sprint 17
 */
@Entity
@EntityListeners(
        AuditingEntityListener.class)
@Table(
        name = "prestamo",
        uniqueConstraints = {

            @UniqueConstraint(
                    name = "uk_prestamo_folio",
                    columnNames = "folio")

        },
        indexes = {

            @Index(
                    name = "idx_prestamo_folio",
                    columnList = "folio"),

            @Index(
                    name = "idx_prestamo_usuario",
                    columnList = "id_usuario"),

            @Index(
                    name = "idx_prestamo_ejemplar",
                    columnList = "id_ejemplar")

        })
public class Prestamo
        extends AuditableEntity {

    /**
     * Identificador del préstamo.
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    /**
     * Folio único.
     */
    @NotBlank
    @Size(max = 20)
    @Column(
            name = "folio",
            nullable = false,
            length = 20)
    private String folio;

    /**
     * Usuario que solicita el préstamo.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_prestamo_usuario"))
    private Usuario usuario;

    /**
     * Ejemplar prestado.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_ejemplar",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_prestamo_ejemplar"))
    private Ejemplar ejemplar;

    /**
     * Estado del préstamo.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_estado_prestamo",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_prestamo_estado"))
    private EstadoPrestamo estadoPrestamo;

    /**
     * Bibliotecario responsable.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_bibliotecario",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_prestamo_bibliotecario"))
    private Usuario bibliotecario;

    /**
     * Fecha del préstamo.
     */
    @NotNull
    @Column(
            name = "fecha_prestamo",
            nullable = false)
    private LocalDate fechaPrestamo;

    /**
     * Fecha programada de devolución.
     */
    @NotNull
    @Column(
            name = "fecha_devolucion_programada",
            nullable = false)
    private LocalDate fechaDevolucionProgramada;

    /**
     * Fecha real de devolución.
     */
    @Column(name = "fecha_devolucion_real")
    private LocalDate fechaDevolucionReal;

    /**
     * Observaciones.
     */
    @Size(max = 255)
    @Column(
            name = "observaciones",
            length = 255)
    private String observaciones;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Prestamo() {
    }

    /**
     * Constructor completo.
     *
     * @param folio Folio.
     * @param usuario Usuario.
     * @param ejemplar Ejemplar.
     * @param estadoPrestamo Estado.
     * @param bibliotecario Bibliotecario.
     * @param fechaPrestamo Fecha préstamo.
     * @param fechaDevolucionProgramada Fecha devolución.
     * @param fechaDevolucionReal Fecha devolución real.
     * @param observaciones Observaciones.
     */
    public Prestamo(
            String folio,
            Usuario usuario,
            Ejemplar ejemplar,
            EstadoPrestamo estadoPrestamo,
            Usuario bibliotecario,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucionProgramada,
            LocalDate fechaDevolucionReal,
            String observaciones) {

        this.folio = folio;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.estadoPrestamo = estadoPrestamo;
        this.bibliotecario = bibliotecario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionProgramada =
                fechaDevolucionProgramada;
        this.fechaDevolucionReal =
                fechaDevolucionReal;
        this.observaciones = observaciones;

    }
        /**
     * Obtiene el identificador.
     *
     * @return Identificador.
     */
    public Integer getIdPrestamo() {

        return idPrestamo;

    }

    /**
     * Establece el identificador.
     *
     * @param idPrestamo Identificador.
     */
    public void setIdPrestamo(
            Integer idPrestamo) {

        this.idPrestamo = idPrestamo;

    }

    /**
     * Obtiene el folio.
     *
     * @return Folio.
     */
    public String getFolio() {

        return folio;

    }

    /**
     * Establece el folio.
     *
     * @param folio Folio.
     */
    public void setFolio(
            String folio) {

        this.folio = folio;

    }

    /**
     * Obtiene el usuario.
     *
     * @return Usuario.
     */
    public Usuario getUsuario() {

        return usuario;

    }

    /**
     * Establece el usuario.
     *
     * @param usuario Usuario.
     */
    public void setUsuario(
            Usuario usuario) {

        this.usuario = usuario;

    }

    /**
     * Obtiene el ejemplar.
     *
     * @return Ejemplar.
     */
    public Ejemplar getEjemplar() {

        return ejemplar;

    }

    /**
     * Establece el ejemplar.
     *
     * @param ejemplar Ejemplar.
     */
    public void setEjemplar(
            Ejemplar ejemplar) {

        this.ejemplar = ejemplar;

    }

    /**
     * Obtiene el estado del préstamo.
     *
     * @return Estado.
     */
    public EstadoPrestamo getEstadoPrestamo() {

        return estadoPrestamo;

    }

    /**
     * Establece el estado del préstamo.
     *
     * @param estadoPrestamo Estado.
     */
    public void setEstadoPrestamo(
            EstadoPrestamo estadoPrestamo) {

        this.estadoPrestamo = estadoPrestamo;

    }

    /**
     * Obtiene el bibliotecario.
     *
     * @return Bibliotecario.
     */
    public Usuario getBibliotecario() {

        return bibliotecario;

    }

    /**
     * Establece el bibliotecario.
     *
     * @param bibliotecario Bibliotecario.
     */
    public void setBibliotecario(
            Usuario bibliotecario) {

        this.bibliotecario = bibliotecario;

    }
    

    /**
     * Obtiene la fecha del préstamo.
     *
     * @return Fecha.
     */
    public LocalDate getFechaPrestamo() {

        return fechaPrestamo;

    }

    /**
     * Establece la fecha del préstamo.
     *
     * @param fechaPrestamo Fecha.
     */
    public void setFechaPrestamo(
            LocalDate fechaPrestamo) {

        this.fechaPrestamo = fechaPrestamo;

    }

    /**
     * Obtiene la fecha programada de devolución.
     *
     * @return Fecha.
     */
    public LocalDate getFechaDevolucionProgramada() {

        return fechaDevolucionProgramada;

    }

    /**
     * Establece la fecha programada de devolución.
     *
     * @param fechaDevolucionProgramada Fecha.
     */
    public void setFechaDevolucionProgramada(
            LocalDate fechaDevolucionProgramada) {

        this.fechaDevolucionProgramada =
                fechaDevolucionProgramada;

    }

    /**
     * Obtiene la fecha real de devolución.
     *
     * @return Fecha.
     */
    public LocalDate getFechaDevolucionReal() {

        return fechaDevolucionReal;

    }

    /**
     * Establece la fecha real de devolución.
     *
     * @param fechaDevolucionReal Fecha.
     */
    public void setFechaDevolucionReal(
            LocalDate fechaDevolucionReal) {

        this.fechaDevolucionReal =
                fechaDevolucionReal;

    }

    /**
     * Obtiene las observaciones.
     *
     * @return Observaciones.
     */
    public String getObservaciones() {

        return observaciones;

    }

    /**
     * Establece las observaciones.
     *
     * @param observaciones Observaciones.
     */
    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }
        /**
     * Indica si el préstamo ya fue devuelto.
     *
     * @return true si existe una fecha de devolución.
     */
    @Transient
    public boolean isDevuelto() {

        return fechaDevolucionReal != null;

    }

    /**
     * Indica si el préstamo se encuentra vencido.
     *
     * @return true si está vencido.
     */
    @Transient
    public boolean estaVencido() {

        return !isDevuelto()
                && LocalDate.now().isAfter(
                        fechaDevolucionProgramada);

    }

    /**
     * Devuelve una representación textual del préstamo.
     *
     * @return Información del préstamo.
     */
    @Override
    public String toString() {

        return "Prestamo{"
                + "idPrestamo=" + idPrestamo
                + ", folio='" + folio + '\''
                + ", usuario="
                + (usuario != null
                        ? usuario.getMatricula()
                        : null)
                + ", ejemplar="
                + (ejemplar != null
                        ? ejemplar.getCodigoInventario()
                        : null)
                + ", estado="
                + (estadoPrestamo != null
                        ? estadoPrestamo.getNombre()
                        : null)
                + ", bibliotecario="
                + (bibliotecario != null
                        ? bibliotecario.getMatricula()
                        : null)
                + ", fechaPrestamo="
                + fechaPrestamo
                + ", fechaDevolucionProgramada="
                + fechaDevolucionProgramada
                + ", fechaDevolucionReal="
                + fechaDevolucionReal
                + ", activo="
                + getActivo()
                + '}';

    }

}