package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDate;

/**
 * DTO de respuesta para reservas.
 *
 * <p>
 * Contiene la información mostrada
 * al consumidor de la API.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public class ReservaResponseDTO {

    /**
     * Identificador.
     */
    private Integer idReserva;

    /**
     * Folio.
     */
    private String folio;

    /**
     * Matrícula del usuario.
     */
    private String matriculaUsuario;

    /**
     * Nombre del usuario.
     */
    private String nombreUsuario;

    /**
     * Título del libro.
     */
    private String tituloLibro;

    /**
     * Matrícula del bibliotecario.
     */
    private String matriculaBibliotecario;

    /**
     * Nombre del bibliotecario.
     */
    private String nombreBibliotecario;

    /**
     * Fecha de reserva.
     */
    private LocalDate fechaReserva;

    /**
     * Fecha límite.
     */
    private LocalDate fechaLimite;

    /**
     * Fecha de atención.
     */
    private LocalDate fechaAtencion;

    /**
     * Estado.
     */
    private String estado;

    /**
     * Indica si expiró.
     */
    private boolean expirada;

    /**
     * Indica si fue atendida.
     */
    private boolean atendida;

    public ReservaResponseDTO() {

    }

    public Integer getIdReserva() {

        return idReserva;

    }

    public void setIdReserva(
            Integer idReserva) {

        this.idReserva =
                idReserva;

    }

    public String getFolio() {

        return folio;

    }

    public void setFolio(
            String folio) {

        this.folio =
                folio;

    }

    public String getMatriculaUsuario() {

        return matriculaUsuario;

    }

    public void setMatriculaUsuario(
            String matriculaUsuario) {

        this.matriculaUsuario =
                matriculaUsuario;

    }

    public String getNombreUsuario() {

        return nombreUsuario;

    }

    public void setNombreUsuario(
            String nombreUsuario) {

        this.nombreUsuario =
                nombreUsuario;

    }

    public String getTituloLibro() {

        return tituloLibro;

    }

    public void setTituloLibro(
            String tituloLibro) {

        this.tituloLibro =
                tituloLibro;

    }

    public String getMatriculaBibliotecario() {

        return matriculaBibliotecario;

    }

    public void setMatriculaBibliotecario(
            String matriculaBibliotecario) {

        this.matriculaBibliotecario =
                matriculaBibliotecario;

    }

    public String getNombreBibliotecario() {

        return nombreBibliotecario;

    }

    public void setNombreBibliotecario(
            String nombreBibliotecario) {

        this.nombreBibliotecario =
                nombreBibliotecario;

    }

    public LocalDate getFechaReserva() {

        return fechaReserva;

    }

    public void setFechaReserva(
            LocalDate fechaReserva) {

        this.fechaReserva =
                fechaReserva;

    }

    public LocalDate getFechaLimite() {

        return fechaLimite;

    }

    public void setFechaLimite(
            LocalDate fechaLimite) {

        this.fechaLimite =
                fechaLimite;

    }

    public LocalDate getFechaAtencion() {

        return fechaAtencion;

    }

    public void setFechaAtencion(
            LocalDate fechaAtencion) {

        this.fechaAtencion =
                fechaAtencion;

    }

    public String getEstado() {

        return estado;

    }

    public void setEstado(
            String estado) {

        this.estado =
                estado;

    }

    public boolean isExpirada() {

        return expirada;

    }

    public void setExpirada(
            boolean expirada) {

        this.expirada =
                expirada;

    }

    public boolean isAtendida() {

        return atendida;

    }

    public void setAtendida(
            boolean atendida) {

        this.atendida =
                atendida;

    }

}