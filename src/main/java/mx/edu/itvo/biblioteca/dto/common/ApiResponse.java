package mx.edu.itvo.biblioteca.dto.common;

import java.time.LocalDateTime;

/**
 * Clase genérica utilizada para estandarizar
 * las respuestas de la API REST.
 *
 * @param <T> Tipo de dato contenido en la respuesta.
 *
 * @author Conce
 * @version 2.1
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
     * Información devuelta por la operación.
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
     * @param message Mensaje descriptivo.
     * @param data Información devuelta.
     */
    public ApiResponse(
            Boolean success,
            String message,
            T data) {

        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();

    }

    /**
     * Crea una respuesta exitosa.
     *
     * @param data Información.
     * @param message Mensaje descriptivo.
     * @param <T> Tipo de dato.
     * @return Respuesta exitosa.
     */
    public static <T> ApiResponse<T> success(
            T data,
            String message) {

        return new ApiResponse<>(
                Boolean.TRUE,
                message,
                data);

    }

    /**
     * Crea una respuesta de error.
     *
     * @param message Mensaje descriptivo.
     * @param <T> Tipo de dato.
     * @return Respuesta de error.
     */
    public static <T> ApiResponse<T> error(
            String message) {

        return new ApiResponse<>(
                Boolean.FALSE,
                message,
                null);

    }

    /**
     * Obtiene el estado de la operación.
     *
     * @return Estado.
     */
    public Boolean getSuccess() {

        return success;

    }

    /**
     * Establece el estado de la operación.
     *
     * @param success Estado.
     */
    public void setSuccess(
            Boolean success) {

        this.success = success;

    }

    /**
     * Obtiene el mensaje.
     *
     * @return Mensaje.
     */
    public String getMessage() {

        return message;

    }

    /**
     * Establece el mensaje.
     *
     * @param message Mensaje.
     */
    public void setMessage(
            String message) {

        this.message = message;

    }

    /**
     * Obtiene la información.
     *
     * @return Información.
     */
    public T getData() {

        return data;

    }

    /**
     * Establece la información.
     *
     * @param data Información.
     */
    public void setData(
            T data) {

        this.data = data;

    }

    /**
     * Obtiene la fecha y hora
     * de la respuesta.
     *
     * @return Fecha y hora.
     */
    public LocalDateTime getTimestamp() {

        return timestamp;

    }

    /**
     * Establece la fecha y hora.
     *
     * @param timestamp Fecha y hora.
     */
    public void setTimestamp(
            LocalDateTime timestamp) {

        this.timestamp = timestamp;

    }

}