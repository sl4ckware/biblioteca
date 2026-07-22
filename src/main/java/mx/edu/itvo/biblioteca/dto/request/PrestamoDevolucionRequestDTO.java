package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO para registrar la devolución
 * de un préstamo.
 *
 * <p>
 * Contiene el identificador del préstamo
 * que será devuelto.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
public class PrestamoDevolucionRequestDTO {

    /**
     * Identificador del préstamo.
     */
    @NotNull(
            message = "El id del préstamo es obligatorio.")
    private Integer idPrestamo;

    /**
     * Obtiene el identificador
     * del préstamo.
     *
     * @return Identificador.
     */
    public Integer getIdPrestamo() {

        return idPrestamo;

    }

    /**
     * Establece el identificador
     * del préstamo.
     *
     * @param idPrestamo Identificador.
     */
    public void setIdPrestamo(
            Integer idPrestamo) {

        this.idPrestamo = idPrestamo;

    }
    
    

}