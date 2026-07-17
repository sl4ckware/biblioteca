package mx.edu.itvo.biblioteca.xml.facade.impl;

import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;

import mx.edu.itvo.biblioteca.xml.facade.XmlFacade;
import mx.edu.itvo.biblioteca.xml.service.XmlExportService;
import mx.edu.itvo.biblioteca.xml.service.XmlImportService;

/**
 * Implementación de la fachada XML.
 *
 * Centraliza las operaciones de
 * exportación e importación
 * del Framework XML.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Component
public class XmlFacadeImpl
        implements XmlFacade {

    /**
     * Servicio de exportación XML.
     */
    private final XmlExportService
            xmlExportService;

    /**
     * Servicio de importación XML.
     */
    private final XmlImportService
            xmlImportService;

    /**
     * Constructor.
     *
     * @param xmlExportService Servicio de exportación.
     * @param xmlImportService Servicio de importación.
     */
    public XmlFacadeImpl(
            XmlExportService xmlExportService,
            XmlImportService xmlImportService) {

        this.xmlExportService =
                xmlExportService;

        this.xmlImportService =
                xmlImportService;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ByteArrayInputStream
            exportarLibros() {

        return xmlExportService
                .exportarLibros();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ByteArrayInputStream
            exportarEditoriales() {

        return xmlExportService
                .exportarEditoriales();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ByteArrayInputStream
            exportarCategorias() {

        return xmlExportService
                .exportarCategorias();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarLibros(
                    MultipartFile archivo) {

        return xmlImportService
                .importarLibros(
                        archivo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarEditoriales(
                    MultipartFile archivo) {

        return xmlImportService
                .importarEditoriales(
                        archivo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportacionReporteDTO
            importarCategorias(
                    MultipartFile archivo) {

        return xmlImportService
                .importarCategorias(
                        archivo);

    }

}