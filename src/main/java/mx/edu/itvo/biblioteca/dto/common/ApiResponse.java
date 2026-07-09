package mx.edu.itvo.biblioteca.dto.common;

import java.time.LocalDateTime;

/**
 * Clase genérica utilizada para estandarizar las respuestas
 * de la API REST.
 *
 * @param <T> Tipo de dato que contendrá la respuesta.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class ApiResponse<T> {

    /**
     * Indica si la operación fue exitosa.
     */
    private Boolean success;

    /**
     * Mensaje descriptivo.
     */
    private String message;

    /**
     * Datos devueltos por la operación.
     */
    private T data;

    /**
     * Fecha y hora de la respuesta.
     */
    private LocalDateTime timestamp;

    /**
     * Constructor vacío.
     */
    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Constructor con parámetros.
     *
     * @param success Estado de la operación.
     * @param message Mensaje.
     * @param data Información.
     */
    public ApiResponse(Boolean success,
                       String message,
                       T data) {

        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}