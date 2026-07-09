package mx.edu.itvo.biblioteca.dto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Representa la estructura estándar de una respuesta de error
 * generada por la API REST.
 *
 * Esta clase se utiliza para devolver información detallada
 * cuando ocurre una excepción durante el procesamiento de una
 * petición HTTP.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public class ErrorResponse {

    /**
     * Fecha y hora en que ocurrió el error.
     */
    private LocalDateTime timestamp;

    /**
     * Código de estado HTTP.
     */
    private Integer status;

    /**
     * Nombre del error HTTP.
     */
    private String error;

    /**
     * Descripción del error.
     */
    private String mensaje;

    /**
     * Ruta (endpoint) donde ocurrió el error.
     */
    private String path;

    /**
     * Lista de errores de validación.
     * Solo se utiliza cuando ocurre un error de validación.
     */
    private Map<String, String> errores;

    /**
     * Constructor vacío.
     */
    public ErrorResponse() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param timestamp Fecha y hora del error.
     * @param status Código HTTP.
     * @param error Nombre del error.
     * @param mensaje Descripción del error.
     * @param path Ruta donde ocurrió el error.
     * @param errores Lista de errores de validación.
     */
    public ErrorResponse(LocalDateTime timestamp,
                         Integer status,
                         String error,
                         String mensaje,
                         String path,
                         Map<String, String> errores) {

        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.mensaje = mensaje;
        this.path = path;
        this.errores = errores;
    }

    /**
     * Obtiene la fecha y hora del error.
     *
     * @return Fecha y hora.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la fecha y hora del error.
     *
     * @param timestamp Fecha y hora.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtiene el código HTTP.
     *
     * @return Código HTTP.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Establece el código HTTP.
     *
     * @param status Código HTTP.
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Obtiene el nombre del error.
     *
     * @return Nombre del error.
     */
    public String getError() {
        return error;
    }

    /**
     * Establece el nombre del error.
     *
     * @param error Nombre del error.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Obtiene la descripción del error.
     *
     * @return Descripción del error.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece la descripción del error.
     *
     * @param mensaje Descripción del error.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene la ruta donde ocurrió el error.
     *
     * @return Ruta del endpoint.
     */
    public String getPath() {
        return path;
    }

    /**
     * Establece la ruta donde ocurrió el error.
     *
     * @param path Ruta del endpoint.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Obtiene la lista de errores de validación.
     *
     * @return Mapa con los errores encontrados.
     */
    public Map<String, String> getErrores() {
        return errores;
    }

    /**
     * Establece la lista de errores de validación.
     *
     * @param errores Mapa con los errores encontrados.
     */
    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    /**
     * Devuelve una representación en texto del objeto.
     *
     * @return Información del error.
     */
    @Override
    public String toString() {
        return "ErrorResponse{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", path='" + path + '\'' +
                ", errores=" + errores +
                '}';
    }

}