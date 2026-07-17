package mx.edu.itvo.biblioteca.dataset.util;

import java.util.List;

/**
 * Datos bibliográficos utilizados por el Dataset Generator.
 *
 * <p>
 * Centraliza la información utilizada para generar libros
 * aleatorios sin depender del generador.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class BookData {

    /**
     * Constructor privado.
     */
    private BookData() {
    }

    /**
     * Títulos.
     */
    private static final List<String> TITULOS = List.of(
            "Introducción a Java",
            "Programación Orientada a Objetos",
            "Estructuras de Datos",
            "Algoritmos Modernos",
            "Bases de Datos",
            "Ingeniería de Software",
            "Arquitectura de Software",
            "Programación Web",
            "Spring Boot",
            "Microservicios",
            "Docker para Desarrolladores",
            "Git Profesional",
            "Clean Code",
            "Patrones de Diseño",
            "UML Aplicado",
            "Inteligencia Artificial",
            "Machine Learning",
            "Redes de Computadoras",
            "Sistemas Operativos",
            "Desarrollo Backend"
    );

    /**
     * Subtítulos.
     */
    private static final List<String> SUBTITULOS = List.of(
            "Fundamentos",
            "Guía práctica",
            "Casos de estudio",
            "Conceptos esenciales",
            "Edición profesional",
            "Manual completo",
            "Curso avanzado",
            "Aplicaciones reales"
    );

    /**
     * Clasificaciones.
     */
    private static final List<String> CLASIFICACIONES = List.of(
            "005.13",
            "005.74",
            "004",
            "004.6",
            "006.3",
            "025",
            "001"
    );

    /**
     * Sinopsis.
     */
    private static final List<String> SINOPSIS = List.of(
            "Obra introductoria para estudiantes universitarios.",
            "Presenta conceptos fundamentales con ejemplos.",
            "Incluye ejercicios prácticos y casos reales.",
            "Material de apoyo para cursos de ingeniería.",
            "Texto recomendado para aprendizaje autónomo.",
            "Explica técnicas modernas de desarrollo.",
            "Desarrolla habilidades para resolver problemas.",
            "Referencia para proyectos profesionales."
    );

    /**
     * Portadas.
     */
    private static final List<String> PORTADAS = List.of(
            "default-01.jpg",
            "default-02.jpg",
            "default-03.jpg",
            "default-04.jpg",
            "default-05.jpg"
    );

    /**
     * Obtiene un título aleatorio.
     *
     * @return Título.
     */
    public static String randomTitulo() {
        return RandomUtil.randomElement(TITULOS);
    }

    /**
     * Obtiene un subtítulo aleatorio.
     *
     * @return Subtítulo.
     */
    public static String randomSubtitulo() {
        return RandomUtil.randomElement(SUBTITULOS);
    }

    /**
     * Obtiene una clasificación aleatoria.
     *
     * @return Clasificación.
     */
    public static String randomClasificacion() {
        return RandomUtil.randomElement(CLASIFICACIONES);
    }

    /**
     * Obtiene una sinopsis aleatoria.
     *
     * @return Sinopsis.
     */
    public static String randomSinopsis() {
        return RandomUtil.randomElement(SINOPSIS);
    }

    /**
     * Obtiene una portada aleatoria.
     *
     * @return Nombre del archivo de portada.
     */
    public static String randomPortada() {
        return RandomUtil.randomElement(PORTADAS);
    }

}