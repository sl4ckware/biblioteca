package mx.edu.itvo.biblioteca.xml.service.impl;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;

import mx.edu.itvo.biblioteca.service.CategoriaService;
import mx.edu.itvo.biblioteca.service.EditorialService;
import mx.edu.itvo.biblioteca.service.LibroService;

import mx.edu.itvo.biblioteca.xml.adapter.CategoriaXmlAdapter;
import mx.edu.itvo.biblioteca.xml.adapter.EditorialXmlAdapter;
import mx.edu.itvo.biblioteca.xml.adapter.LibroXmlAdapter;
import mx.edu.itvo.biblioteca.xml.adapter.XmlAdapter;
import mx.edu.itvo.biblioteca.xml.service.XmlExportService;
import mx.edu.itvo.biblioteca.xml.util.XmlUtils;

/**
 * Implementación del servicio de exportación XML.
 *
 * Coordina la generación de documentos XML
 * para las diferentes entidades del sistema.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
public class XmlExportServiceImpl
        implements XmlExportService {

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
     * Adapter de libros.
     */
    private final LibroXmlAdapter libroXmlAdapter;

    /**
     * Adapter de editoriales.
     */
    private final EditorialXmlAdapter editorialXmlAdapter;

    /**
     * Adapter de categorías.
     */
    private final CategoriaXmlAdapter categoriaXmlAdapter;

    /**
     * Constructor.
     *
     * @param libroService Servicio.
     * @param editorialService Servicio.
     * @param categoriaService Servicio.
     * @param libroXmlAdapter Adapter.
     * @param editorialXmlAdapter Adapter.
     * @param categoriaXmlAdapter Adapter.
     */
    public XmlExportServiceImpl(

            LibroService libroService,

            EditorialService editorialService,

            CategoriaService categoriaService,

            LibroXmlAdapter libroXmlAdapter,

            EditorialXmlAdapter editorialXmlAdapter,

            CategoriaXmlAdapter categoriaXmlAdapter) {

        this.libroService = libroService;
        this.editorialService = editorialService;
        this.categoriaService = categoriaService;

        this.libroXmlAdapter = libroXmlAdapter;
        this.editorialXmlAdapter = editorialXmlAdapter;
        this.categoriaXmlAdapter = categoriaXmlAdapter;

    }

    /**
     * Exporta los libros.
     *
     * @return Archivo XML.
     */
    @Override
    public ByteArrayInputStream
            exportarLibros() {

        return exportar(

                libroService.listar(),

                libroXmlAdapter,

                "libros"

        );

    }

    /**
     * Exporta las editoriales.
     *
     * @return Archivo XML.
     */
    @Override
    public ByteArrayInputStream
            exportarEditoriales() {

        return exportar(

                editorialService.listar(),

                editorialXmlAdapter,

                "editoriales"

        );

    }

    /**
     * Exporta las categorías.
     *
     * @return Archivo XML.
     */
    @Override
    public ByteArrayInputStream
            exportarCategorias() {

        return exportar(

                categoriaService.listar(),

                categoriaXmlAdapter,

                "categorias"

        );

    }

    /**
     * Exporta una colección
     * de objetos a XML.
     *
     * @param datos Información.
     * @param adapter Adapter.
     * @param nodoRaiz Nodo raíz.
     * @param <T> Tipo.
     * @return Archivo XML.
     */
    private <T> ByteArrayInputStream
            exportar(

                    List<T> datos,

                    XmlAdapter<T> adapter,

                    String nodoRaiz) {

        Document document =
                XmlUtils.crearDocumento(
                        nodoRaiz);

        Element raiz =
                document.getDocumentElement();

        for (T dato : datos) {

            raiz.appendChild(

                    adapter.convertir(

                            document,

                            dato

                    )

            );

        }

        return XmlUtils
                .documentoAByteArray(
                        document);

    }

}