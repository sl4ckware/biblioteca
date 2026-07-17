package mx.edu.itvo.biblioteca.csv.dto;

/**
 * Representa un error ocurrido
 * durante la importación.
 *
 * @author Conce
 * @version 2.1
 * @since 2.0
 */
public class ErrorImportacionDTO {

    /**
     * Número de fila.
     */
    private Integer fila;

    /**
     * Columna.
     */
    private String columna;

    /**
     * Valor recibido.
     */
    private String valor;

    /**
     * Mensaje.
     */
    private String mensaje;

    public ErrorImportacionDTO() {
    }

    public ErrorImportacionDTO(

            Integer fila,

            String columna,

            String valor,

            String mensaje) {

        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.mensaje = mensaje;

    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}