package mx.edu.itvo.biblioteca.xml.service.impl;

import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import mx.edu.itvo.biblioteca.csv.builder.ImportReportBuilder;
import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;

import mx.edu.itvo.biblioteca.service.CategoriaService;
import mx.edu.itvo.biblioteca.service.EditorialService;
import mx.edu.itvo.biblioteca.service.LibroService;

import mx.edu.itvo.biblioteca.xml.parser.CategoriaXmlParser;
import mx.edu.itvo.biblioteca.xml.parser.EditorialXmlParser;
import mx.edu.itvo.biblioteca.xml.parser.LibroXmlParser;
import mx.edu.itvo.biblioteca.xml.parser.XmlParser;

import mx.edu.itvo.biblioteca.xml.service.XmlImportService;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Implementación del servicio de
 * importación de archivos XML.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
public class XmlImportServiceImpl
        implements XmlImportService {

    /**
     * Servicio de libros.
     */
    private final LibroService libroService;

    /**
     * Servicio de editoriales.
     */
    private final EditorialService editorialService;

    /**
     * Servicio de categorías.
     */
    private final CategoriaService categoriaService;

    /**
     * Parser de libros.
     */
    private final LibroXmlParser libroXmlParser;

    /**
     * Parser de editoriales.
     */
    private final EditorialXmlParser editorialXmlParser;

    /**
     * Parser de categorías.
     */
    private final CategoriaXmlParser categoriaXmlParser;

    /**
     * Constructor.
     *
     * @param libroService Servicio de libros.
     * @param editorialService Servicio de editoriales.
     * @param categoriaService Servicio de categorías.
     * @param libroXmlParser Parser de libros.
     * @param editorialXmlParser Parser de editoriales.
     * @param categoriaXmlParser Parser de categorías.
     */
    public XmlImportServiceImpl(
            LibroService libroService,
            EditorialService editorialService,
            CategoriaService categoriaService,
            LibroXmlParser libroXmlParser,
            EditorialXmlParser editorialXmlParser,
            CategoriaXmlParser categoriaXmlParser) {

        this.libroService = libroService;
        this.editorialService = editorialService;
        this.categoriaService = categoriaService;

        this.libroXmlParser = libroXmlParser;
        this.editorialXmlParser = editorialXmlParser;
        this.categoriaXmlParser = categoriaXmlParser;

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarLibros(
                    MultipartFile archivo) {

        return importar(

                archivo,

                "libro",

                libroXmlParser,

                libroService::guardar

        );

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarEditoriales(
                    MultipartFile archivo) {

        return importar(

                archivo,

                "editorial",

                editorialXmlParser,

                editorialService::guardar

        );

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarCategorias(
                    MultipartFile archivo) {

        return importar(

                archivo,

                "categoria",

                categoriaXmlParser,

                categoriaService::guardar

        );

    }
                /**
     * Importa los registros de un
     * archivo XML.
     *
     * @param <T> Tipo del DTO.
     * @param archivo Archivo XML.
     * @param nombreNodo Nodo principal.
     * @param parser Parser correspondiente.
     * @param guardar Función de guardado.
     * @return Reporte de importación.
     */
    private <T> ImportacionReporteDTO
            importar(
                    MultipartFile archivo,
                    String nombreNodo,
                    XmlParser<T> parser,
                    Function<T, ?> guardar) {

        ImportReportBuilder reporte =
                new ImportReportBuilder();

        Document document =
                XmlUtils.leerDocumento(
                        archivo);

        NodeList lista =
                XmlUtils.obtenerNodos(
                        document,
                        nombreNodo);

        reporte.registrosLeidos(
                lista.getLength());

        for (int i = 0;
                i < lista.getLength();
                i++) {

            try {

                Element element =
                        (Element) lista.item(i);

                T dto =
                        parser.convertir(
                                element);

                guardar.apply(dto);

                reporte.registroImportado();

            } catch (Exception ex) {

                reporte.error(

                        i + 1,

                        nombreNodo,

                        "",

                        ex.getMessage()

                );

            }

        }

        return reporte.build();

    }
}