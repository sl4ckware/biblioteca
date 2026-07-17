package mx.edu.itvo.biblioteca.csv.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Resultado generado durante
 * una importación CSV.
 *
 * @author Conce
 * @version 2.1
 * @since 2.0
 */
public class ImportacionReporteDTO {

    /**
     * Registros leídos.
     */
    private Integer registrosLeidos = 0;

    /**
     * Registros importados.
     */
    private Integer registrosImportados = 0;

    /**
     * Registros con error.
     */
    private Integer registrosError = 0;

    /**
     * Detalle de errores.
     */
    private List<ErrorImportacionDTO> errores =
            new ArrayList<>();

    public ImportacionReporteDTO() {
    }

    public Integer getRegistrosLeidos() {
        return registrosLeidos;
    }

    public void setRegistrosLeidos(
            Integer registrosLeidos) {

        this.registrosLeidos =
                registrosLeidos;

    }

    public Integer getRegistrosImportados() {
        return registrosImportados;
    }

    public void setRegistrosImportados(
            Integer registrosImportados) {

        this.registrosImportados =
                registrosImportados;

    }

    public Integer getRegistrosError() {
        return registrosError;
    }

    public void setRegistrosError(
            Integer registrosError) {

        this.registrosError =
                registrosError;

    }

    public List<ErrorImportacionDTO> getErrores() {
        return errores;
    }

    public void setErrores(
            List<ErrorImportacionDTO> errores) {

        this.errores = errores;

    }

}