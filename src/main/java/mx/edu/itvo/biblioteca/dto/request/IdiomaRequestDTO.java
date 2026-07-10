package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para registrar y actualizar idiomas.
 *
 * Contiene la información recibida desde la API para la
 * creación y actualización de registros de la entidad Idioma.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class IdiomaRequestDTO {

    /**
     * Nombre del idioma.
     */
    @NotBlank(message = "El nombre del idioma es obligatorio.")
    @Size(min = 2, max = 100,
            message = "El nombre debe contener entre 2 y 100 caracteres.")
    private String nombre;

    /**
     * Código ISO del idioma.
     */
    @NotBlank(message = "El código ISO es obligatorio.")
    @Size(min = 2, max = 10,
            message = "El código ISO debe contener entre 2 y 10 caracteres.")
    private String codigoIso;

    /**
     * Constructor vacío.
     */
    public IdiomaRequestDTO() {
    }

    /**
     * Obtiene el nombre del idioma.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del idioma.
     *
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código ISO.
     *
     * @return Código ISO.
     */
    public String getCodigoIso() {
        return codigoIso;
    }

    /**
     * Establece el código ISO.
     *
     * @param codigoIso Código ISO.
     */
    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

}