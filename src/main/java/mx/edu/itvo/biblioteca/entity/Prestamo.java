package mx.edu.itvo.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa un préstamo de un ejemplar dentro del sistema.
 */
@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRESTAMO")
    private Integer idPrestamo;

    @NotBlank
    @Size(max = 30)
    @Column(name = "FOLIO", nullable = false, unique = true, length = 30)
    private String folio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EJEMPLAR", nullable = false)
    private Ejemplar ejemplar;

    @NotNull
    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private LocalDate fechaPrestamo;

    @NotNull
    @Column(name = "FECHA_DEVOLUCION_PROGRAMADA", nullable = false)
    private LocalDate fechaDevolucionProgramada;

    @Column(name = "FECHA_DEVOLUCION_REAL")
    private LocalDate fechaDevolucionReal;

    @Size(max = 255)
    @Column(name = "OBSERVACIONES", length = 255)
    private String observaciones;

    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo = true;

    @Column(name = "FECHA_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZACION")
    private LocalDateTime fechaActualizacion;

    public Prestamo() {}

    public Prestamo(String folio, Usuario usuario, Ejemplar ejemplar,
                    LocalDate fechaPrestamo,
                    LocalDate fechaDevolucionProgramada,
                    LocalDate fechaDevolucionReal,
                    String observaciones,
                    Boolean activo) {
        this.folio = folio;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionProgramada = fechaDevolucionProgramada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Integer getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(Integer idPrestamo) { this.idPrestamo = idPrestamo; }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Ejemplar getEjemplar() { return ejemplar; }
    public void setEjemplar(Ejemplar ejemplar) { this.ejemplar = ejemplar; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucionProgramada() { return fechaDevolucionProgramada; }
    public void setFechaDevolucionProgramada(LocalDate fechaDevolucionProgramada) { this.fechaDevolucionProgramada = fechaDevolucionProgramada; }

    public LocalDate getFechaDevolucionReal() { return fechaDevolucionReal; }
    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) { this.fechaDevolucionReal = fechaDevolucionReal; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", folio='" + folio + '\'' +
                ", activo=" + activo +
                '}';
    }
}
