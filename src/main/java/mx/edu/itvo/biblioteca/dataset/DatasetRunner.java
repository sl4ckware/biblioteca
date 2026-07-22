package mx.edu.itvo.biblioteca.dataset;

import java.io.IOException;

import mx.edu.itvo.biblioteca.dataset.catalog.EstadoEjemplarCatalog;
import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.generator.AutorGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.CategoriaGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.EditorialGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.EjemplarGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.EstadoEjemplarGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.EstadoUsuarioGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.IdiomaGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.LibroAutorGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.LibroGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.TipoUsuarioGenerator;
import mx.edu.itvo.biblioteca.dataset.generator.UsuarioGenerator;
import mx.edu.itvo.biblioteca.dataset.mapper.AutorSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.CategoriaSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.EditorialSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.EjemplarSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.EstadoEjemplarSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.EstadoUsuarioSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.IdiomaSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.LibroAutorSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.LibroSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.TipoUsuarioSqlMapper;
import mx.edu.itvo.biblioteca.dataset.mapper.UsuarioSqlMapper;
import mx.edu.itvo.biblioteca.dataset.runner.DatasetExecutor;
import mx.edu.itvo.biblioteca.dataset.util.DatasetIndexUtil;

/**
 * Punto de entrada del Dataset Generator.
 *
 * @author Conce
 * @version 3.1
 * @since 1.0
 */
public final class DatasetRunner {

    /**
     * Constructor privado.
     */
    private DatasetRunner() {
    }

    /**
     * Punto de entrada.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(
            String[] args) {

        System.out.println("-------------------------------------");
        System.out.println(" Biblioteca Dataset Generator");
        System.out.println("-------------------------------------");

        try {

            /*
             * ==========================================
             * Categorías
             * ==========================================
             */
            var categorias =
                    DatasetExecutor.execute(
                            CategoriaGenerator::generar,
                            Config.FILE_CATEGORIAS,
                            CategoriaSqlMapper::toSql,
                            "Categorías generadas: ");

            /*
             * ==========================================
             * Editoriales
             * ==========================================
             */
            var editoriales =
                    DatasetExecutor.execute(
                            EditorialGenerator::generar,
                            Config.FILE_EDITORIALES,
                            EditorialSqlMapper::toSql,
                            "Editoriales generadas: ");

            /*
             * ==========================================
             * Idiomas
             * ==========================================
             */
            var idiomas =
                    DatasetExecutor.execute(
                            IdiomaGenerator::generar,
                            Config.FILE_IDIOMAS,
                            IdiomaSqlMapper::toSql,
                            "Idiomas generados: ");

            /*
             * ==========================================
             * Autores
             * ==========================================
             */
            var autores =
                    DatasetExecutor.execute(
                            AutorGenerator::generar,
                            Config.FILE_AUTORES,
                            AutorSqlMapper::toSql,
                            "Autores generados: ");

            /*
             * ==========================================
             * Libros
             * ==========================================
             */
            var libros =
                    DatasetExecutor.execute(
                            () -> LibroGenerator.generar(
                                    categorias,
                                    editoriales,
                                    idiomas),
                            Config.FILE_LIBROS,
                            LibroSqlMapper::toSql,
                            "Libros generados: ");

            /*
             * ==========================================
             * Libro - Autor
             * ==========================================
             */
            DatasetExecutor.execute(
                    () -> LibroAutorGenerator.generar(
                            libros,
                            autores),
                    Config.FILE_LIBRO_AUTOR,
                    LibroAutorSqlMapper::toSql,
                    "Relaciones Libro-Autor generadas: ");

            /*
             * ==========================================
             * Estados de Ejemplar
             * ==========================================
             */
            var estadosEjemplar =
                    DatasetExecutor.execute(
                            EstadoEjemplarGenerator::generar,
                            Config.FILE_ESTADO_EJEMPLAR,
                            EstadoEjemplarSqlMapper::toSql,
                            "Estados de ejemplar generados: ");

            var indiceEstados =
                    DatasetIndexUtil.indexEstadoEjemplar(
                            estadosEjemplar);

            /*
             * ==========================================
             * Ejemplares
             * ==========================================
             */
            DatasetExecutor.execute(
                    () -> EjemplarGenerator.generar(
                            libros,
                            indiceEstados.get(
                                    EstadoEjemplarCatalog
                                            .NOMBRE_DISPONIBLE)),
                    Config.FILE_EJEMPLARES,
                    EjemplarSqlMapper::toSql,
                    "Ejemplares generados: ");

            /*
             * ==========================================
             * Tipos de Usuario
             * ==========================================
             */
            var tiposUsuario =
                    DatasetExecutor.execute(
                            TipoUsuarioGenerator::generar,
                            Config.FILE_TIPO_USUARIO,
                            TipoUsuarioSqlMapper::toSql,
                            "Tipos de usuario generados: ");

            /*
             * ==========================================
             * Estados de Usuario
             * ==========================================
             */
            var estadosUsuario =
                    DatasetExecutor.execute(
                            EstadoUsuarioGenerator::generar,
                            Config.FILE_ESTADO_USUARIO,
                            EstadoUsuarioSqlMapper::toSql,
                            "Estados de usuario generados: ");

            /*
             * ==========================================
             * Usuarios
             * ==========================================
             */
            DatasetExecutor.execute(
                    () -> UsuarioGenerator.generar(
                            tiposUsuario,
                            estadosUsuario),
                    Config.FILE_USUARIOS,
                    UsuarioSqlMapper::toSql,
                    "Usuarios generados: ");

            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println(
                    "Proceso finalizado correctamente.");
            System.out.println("-------------------------------------");

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}