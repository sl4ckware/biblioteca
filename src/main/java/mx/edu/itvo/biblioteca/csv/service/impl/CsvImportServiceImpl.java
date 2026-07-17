package mx.edu.itvo.biblioteca.csv.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.itvo.biblioteca.csv.builder.ImportReportBuilder;
import mx.edu.itvo.biblioteca.csv.dto.ImportacionReporteDTO;
import mx.edu.itvo.biblioteca.csv.parser.CategoriaCsvParser;
import mx.edu.itvo.biblioteca.csv.parser.EditorialCsvParser;
import mx.edu.itvo.biblioteca.csv.parser.LibroCsvParser;
import mx.edu.itvo.biblioteca.csv.service.CsvImportService;
import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.service.CategoriaService;
import mx.edu.itvo.biblioteca.service.EditorialService;
import mx.edu.itvo.biblioteca.service.LibroService;

/**
 * Implementación del servicio de importación CSV.
 *
 * Coordina la lectura de archivos CSV,
 * el procesamiento de registros y la
 * persistencia de la información.
 *
 * @author Conce
 * @version 2.1
 * @since 2.0
 */
@Service
public class CsvImportServiceImpl
        implements CsvImportService {

    /**
     * Parser de libros.
     */
    private final LibroCsvParser libroCsvParser;

    /**
     * Parser de editoriales.
     */
    private final EditorialCsvParser editorialCsvParser;

    /**
     * Parser de categorías.
     */
    private final CategoriaCsvParser categoriaCsvParser;

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
     * Constructor.
     *
     * @param libroCsvParser Parser de libros.
     * @param editorialCsvParser Parser de editoriales.
     * @param categoriaCsvParser Parser de categorías.
     * @param libroService Servicio de libros.
     * @param editorialService Servicio de editoriales.
     * @param categoriaService Servicio de categorías.
     */
    public CsvImportServiceImpl(
            LibroCsvParser libroCsvParser,
            EditorialCsvParser editorialCsvParser,
            CategoriaCsvParser categoriaCsvParser,
            LibroService libroService,
            EditorialService editorialService,
            CategoriaService categoriaService) {

        this.libroCsvParser = libroCsvParser;
        this.editorialCsvParser = editorialCsvParser;
        this.categoriaCsvParser = categoriaCsvParser;

        this.libroService = libroService;
        this.editorialService = editorialService;
        this.categoriaService = categoriaService;

    }

    /**
     * Importa un archivo CSV de libros.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    @Override
    public ImportacionReporteDTO importarLibros(
            MultipartFile archivo) {

        ImportReportBuilder builder =
                new ImportReportBuilder();

        try {

            List<LibroRequestDTO> libros =
                    libroCsvParser.parse(
                            archivo.getInputStream());

            builder.registrosLeidos(
                    libros.size());

            procesarLibros(
                    libros,
                    builder);

        } catch (IOException ex) {

            builder.error(
                    0,
                    "Archivo",
                    archivo.getOriginalFilename(),
                    "No fue posible leer el archivo CSV.");

        }

        return builder.build();

    }
    
    /**
     * Importa un archivo CSV de editoriales.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    @Override
    public ImportacionReporteDTO importarEditoriales(
            MultipartFile archivo) {

        ImportReportBuilder builder =
                new ImportReportBuilder();

        try {

            List<EditorialRequestDTO> editoriales =
                    editorialCsvParser.parse(
                            archivo.getInputStream());

            builder.registrosLeidos(
                    editoriales.size());

            procesarEditoriales(
                    editoriales,
                    builder);

        } catch (IOException ex) {

            builder.error(
                    0,
                    "Archivo",
                    archivo.getOriginalFilename(),
                    "No fue posible leer el archivo CSV.");

        }

        return builder.build();

    }

    /**
     * Importa un archivo CSV de categorías.
     *
     * @param archivo Archivo CSV.
     * @return Resultado de la importación.
     */
    @Override
    public ImportacionReporteDTO importarCategorias(
            MultipartFile archivo) {

        ImportReportBuilder builder =
                new ImportReportBuilder();

        try {

            List<CategoriaRequestDTO> categorias =
                    categoriaCsvParser.parse(
                            archivo.getInputStream());

            builder.registrosLeidos(
                    categorias.size());

            procesarCategorias(
                    categorias,
                    builder);

        } catch (IOException ex) {

            builder.error(
                    0,
                    "Archivo",
                    archivo.getOriginalFilename(),
                    "No fue posible leer el archivo CSV.");

        }

        return builder.build();

    }
    
    /**
     * Procesa la lista de libros.
     *
     * @param libros Lista de libros.
     * @param builder Builder del reporte.
     */
    private void procesarLibros(
            List<LibroRequestDTO> libros,
            ImportReportBuilder builder) {

        int fila = 2;

        for (LibroRequestDTO libro : libros) {

            guardarLibro(
                    libro,
                    fila,
                    builder);

            fila++;

        }

    }

    /**
     * Procesa la lista de editoriales.
     *
     * @param editoriales Lista de editoriales.
     * @param builder Builder del reporte.
     */
    private void procesarEditoriales(
            List<EditorialRequestDTO> editoriales,
            ImportReportBuilder builder) {

        int fila = 2;

        for (EditorialRequestDTO editorial : editoriales) {

            guardarEditorial(
                    editorial,
                    fila,
                    builder);

            fila++;

        }

    }

    /**
     * Procesa la lista de categorías.
     *
     * @param categorias Lista de categorías.
     * @param builder Builder del reporte.
     */
    private void procesarCategorias(
            List<CategoriaRequestDTO> categorias,
            ImportReportBuilder builder) {

        int fila = 2;

        for (CategoriaRequestDTO categoria : categorias) {

            guardarCategoria(
                    categoria,
                    fila,
                    builder);

            fila++;

        }

    }

    /**
     * Guarda un libro.
     *
     * @param libro Libro.
     * @param fila Número de fila.
     * @param builder Builder.
     */
    private void guardarLibro(
            LibroRequestDTO libro,
            Integer fila,
            ImportReportBuilder builder) {

        try {

            libroService.guardar(libro);

            builder.registroImportado();

        } catch (Exception ex) {

            builder.error(
                    fila,
                    "Libro",
                    libro.getTitulo(),
                    ex.getMessage());

        }

    }

    /**
     * Guarda una editorial.
     *
     * @param editorial Editorial.
     * @param fila Número de fila.
     * @param builder Builder.
     */
    private void guardarEditorial(
            EditorialRequestDTO editorial,
            Integer fila,
            ImportReportBuilder builder) {

        try {

            editorialService.guardar(editorial);

            builder.registroImportado();

        } catch (Exception ex) {

            builder.error(
                    fila,
                    "Editorial",
                    editorial.getNombre(),
                    ex.getMessage());

        }

    }

    /**
     * Guarda una categoría.
     *
     * @param categoria Categoría.
     * @param fila Número de fila.
     * @param builder Builder.
     */
    private void guardarCategoria(
            CategoriaRequestDTO categoria,
            Integer fila,
            ImportReportBuilder builder) {

        try {

            categoriaService.guardar(categoria);

            builder.registroImportado();

        } catch (Exception ex) {

            builder.error(
                    fila,
                    "Categoría",
                    categoria.getNombre(),
                    ex.getMessage());

        }

    }

}