package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar un préstamo.
 *
 * <p>
 * Contiene la información mínima requerida para registrar
 * el préstamo de un ejemplar a un usuario.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
public class PrestamoRequestDTO {

    /**
     * Identificador del usuario.
     */
    @NotNull
    private Integer idUsuario;

    /**
     * Identificador del ejemplar.
     */
    @NotNull
    private Integer idEjemplar;

    /**
     * Identificador del bibliotecario.
     */
    @NotNull
    private Integer idBibliotecario;

    /**
     * Observaciones del préstamo.
     */
    @Size(max = 255)
    private String observaciones;

    /**
     * Constructor vacío.
     */
    public PrestamoRequestDTO() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param idUsuario Usuario.
     * @param idEjemplar Ejemplar.
     * @param idBibliotecario Bibliotecario.
     * @param observaciones Observaciones.
     */
    public PrestamoRequestDTO(
            Integer idUsuario,
            Integer idEjemplar,
            Integer idBibliotecario,
            String observaciones) {

        this.idUsuario = idUsuario;
        this.idEjemplar = idEjemplar;
        this.idBibliotecario = idBibliotecario;
        this.observaciones = observaciones;

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(
            Integer idUsuario) {

        this.idUsuario = idUsuario;

    }

    public Integer getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(
            Integer idEjemplar) {

        this.idEjemplar = idEjemplar;

    }

    public Integer getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(
            Integer idBibliotecario) {

        this.idBibliotecario = idBibliotecario;

    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(
            String observaciones) {

        this.observaciones = observaciones;

    }

}