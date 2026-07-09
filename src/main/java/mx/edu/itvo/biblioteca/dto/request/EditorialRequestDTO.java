package mx.edu.itvo.biblioteca.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO utilizado para recibir la información de una editorial
 * desde el cliente hacia la API.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class EditorialRequestDTO {

    /**
     * Nombre de la editorial.
     */
    @NotBlank(message = "El nombre de la editorial es obligatorio.")
    @Size(min = 2, max = 150,
            message = "El nombre debe contener entre 2 y 150 caracteres.")
    private String nombre;

    /**
     * País de origen.
     */
    @Size(max = 100,
            message = "El país no puede exceder los 100 caracteres.")
    private String pais;

    /**
     * Ciudad de origen.
     */
    @Size(max = 100,
            message = "La ciudad no puede exceder los 100 caracteres.")
    private String ciudad;

    /**
     * Teléfono de contacto.
     */
    @Size(max = 20,
            message = "El teléfono no puede exceder los 20 caracteres.")
    private String telefono;

    /**
     * Correo electrónico de contacto.
     */
    @Email(message = "El correo electrónico no es válido.")
    @Size(max = 150,
            message = "El correo no puede exceder los 150 caracteres.")
    private String correo;

    /**
     * Sitio web oficial.
     */
    @Size(max = 255,
            message = "La URL no puede exceder los 255 caracteres.")
    private String sitioWeb;

    public EditorialRequestDTO() {
    }

    public EditorialRequestDTO(String nombre,
                               String pais,
                               String ciudad,
                               String telefono,
                               String correo,
                               String sitioWeb) {

        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.sitioWeb = sitioWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}
