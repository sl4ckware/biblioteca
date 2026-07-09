package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO utilizado para enviar la información de una editorial
 * desde la API hacia el cliente.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class EditorialResponseDTO {

    /**
     * Identificador único de la editorial.
     */
    private Integer idEditorial;

    /**
     * Nombre de la editorial.
     */
    private String nombre;

    /**
     * País de origen.
     */
    private String pais;

    /**
     * Ciudad de origen.
     */
    private String ciudad;

    /**
     * Teléfono de contacto.
     */
    private String telefono;

    /**
     * Correo electrónico de contacto.
     */
    private String correo;

    /**
     * Sitio web oficial.
     */
    private String sitioWeb;

    /**
     * Estado lógico del registro.
     */
    private Boolean activo;

    /**
     * Fecha de creación.
     */
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de última actualización.
     */
    private LocalDateTime fechaActualizacion;

    public EditorialResponseDTO() {
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
