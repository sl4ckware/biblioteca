package mx.edu.itvo.biblioteca.dto.response;

import java.time.LocalDateTime;

/**
 * DTO utilizado para devolver información de un idioma.
 *
 * Contiene la información expuesta por la API REST hacia
 * los clientes del sistema.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class IdiomaResponseDTO {

    /**
     * Identificador del idioma.
     */
    private Integer idIdioma;

    /**
     * Nombre del idioma.
     */
    private String nombre;

    /**
     * Código ISO del idioma.
     */
    private String codigoIso;

    /**
     * Estado del idioma.
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

    /**
     * Constructor vacío.
     */
    public IdiomaResponseDTO() {
    }

    public Integer getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Integer idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
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