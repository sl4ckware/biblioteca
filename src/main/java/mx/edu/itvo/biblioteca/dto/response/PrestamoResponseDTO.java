package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDate;

/**
 * DTO utilizado para devolver la información de un préstamo.
 *
 * <p>
 * Contiene la información necesaria para mostrar un préstamo
 * completo en las consultas del sistema.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
public class PrestamoResponseDTO {

    /**
     * Identificador del préstamo.
     */
    private Integer idPrestamo;

    /**
     * Folio del préstamo.
     */
    private String folio;

    /**
     * Matrícula del usuario.
     */
    private String matriculaUsuario;

    /**
     * Nombre completo del usuario.
     */
    private String nombreUsuario;

    /**
     * Código del ejemplar.
     */
    private String codigoEjemplar;

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
     * Fecha del préstamo.
     */
    private LocalDate fechaPrestamo;

    /**
     * Fecha programada de devolución.
     */
    private LocalDate fechaDevolucionProgramada;

    /**
     * Fecha real de devolución.
     */
    private LocalDate fechaDevolucionReal;

    /**
     * Estado del préstamo.
     */
    private String estado;

    /**
     * Indica si fue devuelto.
     */
    private Boolean devuelto;

    /**
     * Indica si está vencido.
     */
    private Boolean vencido;

    /**
     * Constructor vacío.
     */
    public PrestamoResponseDTO() {
    }

    /**
     * Constructor completo.
     */
    public PrestamoResponseDTO(
            Integer idPrestamo,
            String folio,
            String matriculaUsuario,
            String nombreUsuario,
            String codigoEjemplar,
            String tituloLibro,
            String matriculaBibliotecario,
            String nombreBibliotecario,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucionProgramada,
            LocalDate fechaDevolucionReal,
            String estado,
            Boolean devuelto,
            Boolean vencido) {

        this.idPrestamo = idPrestamo;
        this.folio = folio;
        this.matriculaUsuario = matriculaUsuario;
        this.nombreUsuario = nombreUsuario;
        this.codigoEjemplar = codigoEjemplar;
        this.tituloLibro = tituloLibro;
        this.matriculaBibliotecario =
                matriculaBibliotecario;
        this.nombreBibliotecario =
                nombreBibliotecario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionProgramada =
                fechaDevolucionProgramada;
        this.fechaDevolucionReal =
                fechaDevolucionReal;
        this.estado = estado;
        this.devuelto = devuelto;
        this.vencido = vencido;

    }
        /**
     * Obtiene el identificador del préstamo.
     *
     * @return Identificador.
     */
    public Integer getIdPrestamo() {

        return idPrestamo;

    }

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

    public void setFolio(
            String folio) {

        this.folio = folio;

    }

    /**
     * Obtiene la matrícula del usuario.
     *
     * @return Matrícula.
     */
    public String getMatriculaUsuario() {

        return matriculaUsuario;

    }

    public void setMatriculaUsuario(
            String matriculaUsuario) {

        this.matriculaUsuario = matriculaUsuario;

    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre.
     */
    public String getNombreUsuario() {

        return nombreUsuario;

    }

    public void setNombreUsuario(
            String nombreUsuario) {

        this.nombreUsuario = nombreUsuario;

    }

    /**
     * Obtiene el código del ejemplar.
     *
     * @return Código del ejemplar.
     */
    public String getCodigoEjemplar() {

        return codigoEjemplar;

    }

    public void setCodigoEjemplar(
            String codigoEjemplar) {

        this.codigoEjemplar = codigoEjemplar;

    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título.
     */
    public String getTituloLibro() {

        return tituloLibro;

    }

    public void setTituloLibro(
            String tituloLibro) {

        this.tituloLibro = tituloLibro;

    }

    /**
     * Obtiene la matrícula del bibliotecario.
     *
     * @return Matrícula.
     */
    public String getMatriculaBibliotecario() {

        return matriculaBibliotecario;

    }

    public void setMatriculaBibliotecario(
            String matriculaBibliotecario) {

        this.matriculaBibliotecario =
                matriculaBibliotecario;

    }

    /**
     * Obtiene el nombre del bibliotecario.
     *
     * @return Nombre.
     */
    public String getNombreBibliotecario() {

        return nombreBibliotecario;

    }

    public void setNombreBibliotecario(
            String nombreBibliotecario) {

        this.nombreBibliotecario =
                nombreBibliotecario;

    }

    /**
     * Obtiene la fecha del préstamo.
     *
     * @return Fecha.
     */
    public LocalDate getFechaPrestamo() {

        return fechaPrestamo;

    }

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

    public void setFechaDevolucionReal(
            LocalDate fechaDevolucionReal) {

        this.fechaDevolucionReal =
                fechaDevolucionReal;

    }

    /**
     * Obtiene el estado del préstamo.
     *
     * @return Estado.
     */
    public String getEstado() {

        return estado;

    }

    public void setEstado(
            String estado) {

        this.estado = estado;

    }

    /**
     * Indica si el préstamo fue devuelto.
     *
     * @return true si fue devuelto.
     */
    public Boolean getDevuelto() {

        return devuelto;

    }

    public void setDevuelto(
            Boolean devuelto) {

        this.devuelto = devuelto;

    }

    /**
     * Indica si el préstamo está vencido.
     *
     * @return true si está vencido.
     */
    public Boolean getVencido() {

        return vencido;

    }

    public void setVencido(
            Boolean vencido) {

        this.vencido = vencido;

    }

}