package mx.edu.itvo.biblioteca.service.impl;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


import java.io.ByteArrayOutputStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;



import mx.edu.itvo.biblioteca.dto.dashboard.DashboardDTO;
import mx.edu.itvo.biblioteca.dto.dashboard.DashboardTopDTO;


import mx.edu.itvo.biblioteca.entity.Prestamo;
import mx.edu.itvo.biblioteca.entity.Reserva;


import mx.edu.itvo.biblioteca.repository.PrestamoRepository;
import mx.edu.itvo.biblioteca.repository.ReservaRepository;


import mx.edu.itvo.biblioteca.service.DashboardService;
import mx.edu.itvo.biblioteca.service.ReporteService;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.springframework.stereotype.Service;



/**
 * Implementación del servicio encargado
 * de generar reportes ejecutivos y administrativos.
 *
 * <p>
 * Integra información del Dashboard,
 * préstamos y reservas.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 20
 */
@Service
public class ReporteServiceImpl
        implements ReporteService {



    /**
     * Servicio Dashboard.
     */
    private final DashboardService dashboardService;



    /**
     * Repositorio préstamos.
     */
    private final PrestamoRepository prestamoRepository;



    /**
     * Repositorio reservas.
     */
    private final ReservaRepository reservaRepository;





    /**
     * Constructor.
     *
     * @param dashboardService Servicio Dashboard.
     * @param prestamoRepository Repositorio préstamos.
     * @param reservaRepository Repositorio reservas.
     */
    public ReporteServiceImpl(
            DashboardService dashboardService,
            PrestamoRepository prestamoRepository,
            ReservaRepository reservaRepository) {


        this.dashboardService =
                dashboardService;


        this.prestamoRepository =
                prestamoRepository;


        this.reservaRepository =
                reservaRepository;

    }






    /**
     * Genera reporte Dashboard PDF.
     *
     * @return archivo PDF.
     */
    @Override
    public byte[] generarDashboardPDF() {



        DashboardDTO dashboard =
                dashboardService
                .obtenerDashboard();



        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();




        try {


            Document documento =
                    new Document();




            PdfWriter.getInstance(
                    documento,
                    salida
            );




            documento.open();




            agregarEncabezado(
                    documento
            );



            agregarResumen(
                    documento,
                    dashboard
            );



            agregarAlertas(
                    documento,
                    dashboard
            );



            agregarOperacion(
                    documento,
                    dashboard
            );

            agregarRanking(
                    documento,
                    "Top Libros",
                    dashboard.getTopLibros()
            );



            agregarRanking(
                    documento,
                    "Top Categorías",
                    dashboard.getTopCategorias()
            );



            agregarRanking(
                    documento,
                    "Top Autores",
                    dashboard.getTopAutores()
            );



            agregarRanking(
                    documento,
                    "Top Editoriales",
                    dashboard.getTopEditoriales()
            );



            agregarRanking(
                    documento,
                    "Top Idiomas",
                    dashboard.getTopIdiomas()
            );



            documento.close();



        }
        catch(DocumentException exception){


            throw new RuntimeException(
                    "Error generando PDF Dashboard.",
                    exception
            );


        }



        return salida.toByteArray();

    }









    /**
     * Agrega encabezado general
     * al documento PDF.
     *
     * @param documento Documento PDF.
     * @throws DocumentException error PDF.
     */
    private void agregarEncabezado(
            Document documento)
            throws DocumentException {



        Font titulo =
                new Font(
                        Font.HELVETICA,
                        18,
                        Font.BOLD
                );



        Paragraph encabezado =
                new Paragraph(
                        "Sistema Integral de Biblioteca",
                        titulo
                );



        encabezado.setAlignment(
                Element.ALIGN_CENTER
        );



        documento.add(
                encabezado
        );



        documento.add(
                new Paragraph(
                        "Reporte Ejecutivo Dashboard"
                )
        );



        documento.add(
                new Paragraph(
                        "Fecha generación: "
                        +
                        LocalDateTime.now()
                        .format(
                                DateTimeFormatter
                                .ofPattern(
                                "dd/MM/yyyy HH:mm"
                                )
                        )
                )
        );



        documento.add(
                new Paragraph(
                        " "
                )
        );

    }









    /**
     * Agrega resumen general.
     *
     * @param documento Documento PDF.
     * @param dashboard Información dashboard.
     * @throws DocumentException error PDF.
     */
    private void agregarResumen(
            Document documento,
            DashboardDTO dashboard)
            throws DocumentException {



        documento.add(
                new Paragraph(
                        "Indicadores Generales"
                )
        );



        PdfPTable tabla =
                new PdfPTable(
                        2
                );



        agregarCelda(
                tabla,
                "Indicador"
        );



        agregarCelda(
                tabla,
                "Valor"
        );



        if(dashboard.getResumen()!=null){



            agregarFila(
                    tabla,
                    "Total libros",
                    dashboard.getResumen()
                    .getTotalLibros()
            );



            agregarFila(
                    tabla,
                    "Total usuarios",
                    dashboard.getResumen()
                    .getTotalUsuarios()
            );



            agregarFila(
                    tabla,
                    "Total ejemplares",
                    dashboard.getResumen()
                    .getTotalEjemplares()
            );



            agregarFila(
                    tabla,
                    "Préstamos activos",
                    dashboard.getResumen()
                    .getPrestamosActivos()
            );



            agregarFila(
                    tabla,
                    "Reservas activas",
                    dashboard.getResumen()
                    .getReservasActivas()
            );


        }



        documento.add(
                tabla
        );



        documento.add(
                new Paragraph(
                        " "
                )
        );


    }
    
    /**
     * Agrega alertas del sistema.
     *
     * @param documento Documento PDF.
     * @param dashboard Información dashboard.
     * @throws DocumentException error PDF.
     */
    private void agregarAlertas(
            Document documento,
            DashboardDTO dashboard)
            throws DocumentException {


        documento.add(
                new Paragraph(
                        "Alertas del Sistema"
                )
        );



        if(dashboard.getAlertas()!=null){



            documento.add(
                    new Paragraph(
                            "Préstamos vencidos: "
                            +
                            dashboard.getAlertas()
                            .getPrestamosVencidos()
                    )
            );



            documento.add(
                    new Paragraph(
                            "Reservas activas: "
                            +
                            dashboard.getAlertas()
                            .getReservasActivas()
                    )
            );


        }



        documento.add(
                new Paragraph(
                        " "
                )
        );


    }








    /**
     * Agrega información operación diaria.
     *
     * @param documento Documento PDF.
     * @param dashboard Información dashboard.
     * @throws DocumentException error PDF.
     */
    private void agregarOperacion(
            Document documento,
            DashboardDTO dashboard)
            throws DocumentException {



        documento.add(
                new Paragraph(
                        "Operación del Día"
                )
        );



        if(dashboard.getOperacionDia()!=null){



            documento.add(
                    new Paragraph(
                            "Préstamos hoy: "
                            +
                            dashboard.getOperacionDia()
                            .getPrestamosHoy()
                    )
            );



            documento.add(
                    new Paragraph(
                            "Devoluciones hoy: "
                            +
                            dashboard.getOperacionDia()
                            .getDevolucionesHoy()
                    )
            );


        }



        documento.add(
                new Paragraph(
                        " "
                )
        );


    }









    /**
     * Genera tabla de ranking.
     *
     * @param documento Documento PDF.
     * @param titulo Nombre del ranking.
     * @param datos Lista de datos.
     * @throws DocumentException error PDF.
     */
    private void agregarRanking(
            Document documento,
            String titulo,
            List<DashboardTopDTO> datos)
            throws DocumentException {



        documento.add(
                new Paragraph(
                        titulo
                )
        );



        PdfPTable tabla =
                new PdfPTable(
                        2
                );



        agregarCelda(
                tabla,
                "Nombre"
        );



        agregarCelda(
                tabla,
                "Préstamos"
        );



        if(datos!=null){



            datos.forEach(
                    item -> {


                        agregarCelda(
                                tabla,
                                item.getNombre()
                        );


                        agregarCelda(
                                tabla,
                                item.getTotalPrestamos()
                        );


                    }
            );


        }



        documento.add(
                tabla
        );



        documento.add(
                new Paragraph(
                        " "
                )
        );


    }









    /**
     * Agrega una celda simple.
     *
     * @param tabla Tabla PDF.
     * @param valor Valor.
     */
    private void agregarCelda(
            PdfPTable tabla,
            Object valor) {



        tabla.addCell(
                new PdfPCell(
                        new Phrase(
                                String.valueOf(valor)
                        )
                )
        );


    }









    /**
     * Agrega fila de información.
     *
     * @param tabla Tabla PDF.
     * @param nombre Nombre indicador.
     * @param valor Valor indicador.
     */
    private void agregarFila(
            PdfPTable tabla,
            String nombre,
            Object valor) {



        agregarCelda(
                tabla,
                nombre
        );



        agregarCelda(
                tabla,
                valor
        );


    }
    /**
     * Genera reporte Dashboard
     * en formato Excel.
     *
     * @return archivo Excel.
     */
    @Override
    public byte[] generarDashboardExcel() {



        DashboardDTO dashboard =
                dashboardService
                .obtenerDashboard();



        try(
            Workbook workbook =
                    new XSSFWorkbook()
        ){



            Sheet resumen =
                    workbook.createSheet(
                            "Resumen"
                    );



            int fila = 0;



            Row encabezado =
                    resumen.createRow(
                            fila++
                    );



            encabezado.createCell(0)
                    .setCellValue(
                            "Indicador"
                    );



            encabezado.createCell(1)
                    .setCellValue(
                            "Valor"
                    );





            if(dashboard.getResumen()!=null){



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total libros",
                        dashboard.getResumen()
                        .getTotalLibros()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total usuarios",
                        dashboard.getResumen()
                        .getTotalUsuarios()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total ejemplares",
                        dashboard.getResumen()
                        .getTotalEjemplares()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Préstamos activos",
                        dashboard.getResumen()
                        .getPrestamosActivos()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Reservas activas",
                        dashboard.getResumen()
                        .getReservasActivas()
                );


            }





            resumen.autoSizeColumn(0);
            resumen.autoSizeColumn(1);





            Sheet libros =
                    workbook.createSheet(
                            "Top Libros"
                    );



            crearHojaRankingExcel(
                    libros,
                    dashboard.getTopLibros()
            );





            Sheet categorias =
                    workbook.createSheet(
                            "Top Categorias"
                    );



            crearHojaRankingExcel(
                    categorias,
                    dashboard.getTopCategorias()
            );





            Sheet autores =
                    workbook.createSheet(
                            "Top Autores"
                    );



            crearHojaRankingExcel(
                    autores,
                    dashboard.getTopAutores()
            );






            ByteArrayOutputStream salida =
                    new ByteArrayOutputStream();




            workbook.write(
                    salida
            );



            return salida.toByteArray();


        }
        catch(Exception exception){



            throw new RuntimeException(
                    "Error generando Excel Dashboard.",
                    exception
            );


        }


    }









    /**
     * Agrega fila en Excel.
     *
     * @param hoja Hoja Excel.
     * @param fila Número fila.
     * @param nombre Nombre indicador.
     * @param valor Valor.
     */
    private void agregarFilaExcel(
            Sheet hoja,
            int fila,
            String nombre,
            Object valor){



        Row row =
                hoja.createRow(
                        fila
                );



        row.createCell(0)
                .setCellValue(
                        nombre
                );



        row.createCell(1)
                .setCellValue(
                        String.valueOf(valor)
                );


    }









    /**
     * Crea hoja de ranking.
     *
     * @param hoja Hoja Excel.
     * @param datos Información.
     */
    private void crearHojaRankingExcel(
            Sheet hoja,
            List<DashboardTopDTO> datos){



        Row encabezado =
                hoja.createRow(
                        0
                );



        encabezado.createCell(0)
                .setCellValue(
                        "Nombre"
                );



        encabezado.createCell(1)
                .setCellValue(
                        "Préstamos"
                );



        int fila = 1;



        if(datos!=null){



            for(DashboardTopDTO item: datos){



                Row row =
                        hoja.createRow(
                                fila++
                        );



                row.createCell(0)
                        .setCellValue(
                                item.getNombre()
                        );



                row.createCell(1)
                        .setCellValue(
                                item.getTotalPrestamos()
                        );


            }


        }




        hoja.autoSizeColumn(0);
        hoja.autoSizeColumn(1);


    }
        /**
     * Genera reporte administrativo general
     * en formato PDF.
     *
     * @return archivo PDF.
     */
    @Override
    public byte[] generarReporteAdministrativoPDF() {



        DashboardDTO dashboard =
                dashboardService
                .obtenerDashboard();



        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();




        try {


            Document documento =
                    new Document();



            PdfWriter.getInstance(
                    documento,
                    salida
            );



            documento.open();




            agregarEncabezado(
                    documento
            );



            documento.add(
                    new Paragraph(
                            "REPORTE ADMINISTRATIVO GENERAL"
                    )
            );



            documento.add(
                    new Paragraph(
                            " "
                    )
            );




            if(dashboard.getResumen()!=null){



                documento.add(
                        new Paragraph(
                                "Resumen General"
                        )
                );



                documento.add(
                        new Paragraph(
                                "Total libros: "
                                +
                                dashboard.getResumen()
                                .getTotalLibros()
                        )
                );



                documento.add(
                        new Paragraph(
                                "Total usuarios: "
                                +
                                dashboard.getResumen()
                                .getTotalUsuarios()
                        )
                );



                documento.add(
                        new Paragraph(
                                "Total ejemplares: "
                                +
                                dashboard.getResumen()
                                .getTotalEjemplares()
                        )
                );



                documento.add(
                        new Paragraph(
                                "Préstamos activos: "
                                +
                                dashboard.getResumen()
                                .getPrestamosActivos()
                        )
                );



                documento.add(
                        new Paragraph(
                                "Reservas activas: "
                                +
                                dashboard.getResumen()
                                .getReservasActivas()
                        )
                );

            }





            documento.add(
                    new Paragraph(
                            " "
                    )
            );



            documento.add(
                    new Paragraph(
                            "Fecha generación: "
                            +
                            LocalDateTime.now()
                            .format(
                                    DateTimeFormatter
                                    .ofPattern(
                                    "dd/MM/yyyy HH:mm"
                                    )
                            )
                    )
            );



            documento.close();



        }
        catch(Exception exception){



            throw new RuntimeException(
                    "Error generando reporte administrativo PDF.",
                    exception
            );


        }




        return salida.toByteArray();

    }









    /**
     * Genera reporte administrativo
     * en formato Excel.
     *
     * @return archivo Excel.
     */
    @Override
    public byte[] generarReporteAdministrativoExcel() {



        DashboardDTO dashboard =
                dashboardService
                .obtenerDashboard();




        try(
                Workbook workbook =
                new XSSFWorkbook()
        ){



            Sheet resumen =
                    workbook.createSheet(
                            "Resumen Administrativo"
                    );



            int fila = 0;



            Row encabezado =
                    resumen.createRow(
                            fila++
                    );



            encabezado.createCell(0)
                    .setCellValue(
                            "Indicador"
                    );



            encabezado.createCell(1)
                    .setCellValue(
                            "Valor"
                    );





            if(dashboard.getResumen()!=null){



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total libros",
                        dashboard.getResumen()
                        .getTotalLibros()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total usuarios",
                        dashboard.getResumen()
                        .getTotalUsuarios()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Total ejemplares",
                        dashboard.getResumen()
                        .getTotalEjemplares()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Préstamos activos",
                        dashboard.getResumen()
                        .getPrestamosActivos()
                );



                agregarFilaExcel(
                        resumen,
                        fila++,
                        "Reservas activas",
                        dashboard.getResumen()
                        .getReservasActivas()
                );


            }



            resumen.autoSizeColumn(0);
            resumen.autoSizeColumn(1);




            Sheet prestamos =
                    workbook.createSheet(
                            "Préstamos"
                    );



            Row encabezadoPrestamos =
                    prestamos.createRow(
                            0
                    );



            encabezadoPrestamos
                    .createCell(0)
                    .setCellValue(
                            "Cantidad"
                    );



            encabezadoPrestamos
                    .createCell(1)
                    .setCellValue(
                            "Información"
                    );



            prestamos.createRow(1)
                    .createCell(0)
                    .setCellValue(
                            "Resumen generado"
                    );



            Sheet reservas =
                    workbook.createSheet(
                            "Reservas"
                    );



            reservas.createRow(0)
                    .createCell(0)
                    .setCellValue(
                            "Resumen de reservas"
                    );





            ByteArrayOutputStream salida =
                    new ByteArrayOutputStream();



            workbook.write(
                    salida
            );



            return salida.toByteArray();


        }
        catch(Exception exception){



            throw new RuntimeException(
                    "Error generando reporte administrativo Excel.",
                    exception
            );


        }

    }
    
    /**
     * Genera reporte de préstamos
     * en formato PDF.
     *
     * Incluye información:
     * - folio
     * - usuario
     * - ejemplar
     * - estado
     * - fechas
     *
     * @return archivo PDF.
     */
    @Override
    public byte[] generarReportePrestamosPDF() {


        List<Prestamo> prestamos =
                prestamoRepository.findAll();



        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();




        try {


            Document documento =
                    new Document();



            PdfWriter.getInstance(
                    documento,
                    salida
            );



            documento.open();



            agregarEncabezado(
                    documento
            );



            documento.add(
                    new Paragraph(
                            "REPORTE DE PRÉSTAMOS"
                    )
            );



            documento.add(
                    new Paragraph(
                            "Total registros: "
                            +
                            prestamos.size()
                    )
            );



            documento.add(
                    new Paragraph(
                            " "
                    )
            );




            PdfPTable tabla =
                    new PdfPTable(5);



            agregarCelda(
                    tabla,
                    "Folio"
            );


            agregarCelda(
                    tabla,
                    "Usuario"
            );


            agregarCelda(
                    tabla,
                    "Ejemplar"
            );


            agregarCelda(
                    tabla,
                    "Estado"
            );


            agregarCelda(
                    tabla,
                    "Fecha préstamo"
            );





            for(Prestamo prestamo : prestamos){



                agregarCelda(
                        tabla,
                        prestamo.getFolio()
                );



                agregarCelda(
                        tabla,
                        prestamo.getUsuario()
                        != null
                        ?
                        prestamo.getUsuario()
                        .getNombre()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        prestamo.getEjemplar()
                        != null
                        ?
                        prestamo.getEjemplar()
                        .getCodigoInventario()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        prestamo.getEstadoPrestamo()
                        != null
                        ?
                        prestamo.getEstadoPrestamo()
                        .getNombre()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        prestamo.getFechaPrestamo()
                );


            }



            documento.add(
                    tabla
            );



            documento.close();



        }
        catch(Exception exception){



            throw new RuntimeException(
                    "Error generando reporte de préstamos.",
                    exception
            );


        }



        return salida.toByteArray();


    }









    /**
     * Genera reporte de reservas
     * en formato PDF.
     *
     * @return archivo PDF.
     */
    @Override
    public byte[] generarReporteReservasPDF() {



        List<Reserva> reservas =
                reservaRepository.findAll();



        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();




        try {



            Document documento =
                    new Document();



            PdfWriter.getInstance(
                    documento,
                    salida
            );



            documento.open();



            agregarEncabezado(
                    documento
            );



            documento.add(
                    new Paragraph(
                            "REPORTE DE RESERVAS"
                    )
            );



            documento.add(
                    new Paragraph(
                            "Total registros: "
                            +
                            reservas.size()
                    )
            );



            documento.add(
                    new Paragraph(
                            " "
                    )
            );





            PdfPTable tabla =
                    new PdfPTable(5);



            agregarCelda(
                    tabla,
                    "Usuario"
            );



            agregarCelda(
                    tabla,
                    "Libro"
            );



            agregarCelda(
                    tabla,
                    "Estado"
            );



            agregarCelda(
                    tabla,
                    "Fecha reserva"
            );



            agregarCelda(
                    tabla,
                    "Observaciones"
            );





            for(Reserva reserva : reservas){



                agregarCelda(
                        tabla,
                        reserva.getUsuario()
                        != null
                        ?
                        reserva.getUsuario()
                        .getNombre()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        reserva.getLibro()
                        != null
                        ?
                        reserva.getLibro()
                        .getTitulo()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        reserva.getEstadoReserva()
                        != null
                        ?
                        reserva.getEstadoReserva()
                        .getNombre()
                        :
                        "N/D"
                );



                agregarCelda(
                        tabla,
                        reserva.getFechaReserva()
                );



                agregarCelda(
                        tabla,
                        reserva.getObservaciones()
                );


            }




            documento.add(
                    tabla
            );



            documento.close();



        }
        catch(Exception exception){



            throw new RuntimeException(
                    "Error generando reporte de reservas.",
                    exception
            );


        }




        return salida.toByteArray();


    }
    
    /**
     * Ajusta automáticamente
     * las columnas de una hoja Excel.
     *
     * @param hoja Hoja Excel.
     */
    private void ajustarColumnas(
            Sheet hoja) {


        hoja.autoSizeColumn(0);
        hoja.autoSizeColumn(1);
        hoja.autoSizeColumn(2);
        hoja.autoSizeColumn(3);
        hoja.autoSizeColumn(4);

    }







    /**
     * Valida texto nulo.
     *
     * @param valor Texto.
     * @return Texto seguro.
     */
    private String textoSeguro(
            String valor) {


        return valor != null
                ?
                valor
                :
                "N/D";

    }







    /**
     * Valida objeto nulo.
     *
     * @param valor Objeto.
     * @return Texto seguro.
     */
    private String objetoSeguro(
            Object valor) {


        return valor != null
                ?
                String.valueOf(valor)
                :
                "N/D";

    }







}