package mx.edu.itvo.biblioteca.csv.builder;

import mx.edu.itvo.biblioteca.csv.dto.ErrorImportacionDTO;
import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

/**
 * Builder para la construcción
 * del reporte de importación.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class ImportReportBuilder {

    /**
     * Reporte.
     */
    private final ImportacionReporteDTO reporte;

    /**
     * Constructor.
     */
    public ImportReportBuilder() {

        this.reporte =
                new ImportacionReporteDTO();

    }

    /**
     * Total de registros leídos.
     */
    public ImportReportBuilder
            registrosLeidos(
                    Integer total) {

        reporte.setRegistrosLeidos(total);

        return this;

    }

    /**
     * Incrementa importados.
     */
    public ImportReportBuilder
            registroImportado() {

        reporte.setRegistrosImportados(

                reporte.getRegistrosImportados()+1

        );

        return this;

    }

    /**
     * Incrementa errores.
     */
    public ImportReportBuilder
            error(

                    Integer fila,

                    String columna,

                    String valor,

                    String mensaje) {

        reporte.setRegistrosError(

                reporte.getRegistrosError()+1

        );

        reporte.getErrores().add(

                new ErrorImportacionDTO(

                        fila,

                        columna,

                        valor,

                        mensaje

                )

        );

        return this;

    }

    /**
     * Obtiene el reporte.
     */
    public ImportacionReporteDTO
            build() {

        return reporte;

    }

}