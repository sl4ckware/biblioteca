package mx.edu.itvo.biblioteca.dataset.provider;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Proporciona información base para la generación
 * de personas del Dataset Generator.
 *
 * <p>
 * Esta información será reutilizada para generar
 * usuarios, bibliotecarios, administradores y otros
 * actores del sistema.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class PersonaProvider {

    /**
     * Nombres.
     */
    private static final String[] NOMBRES = {

            "Juan",
            "José",
            "Carlos",
            "Luis",
            "Miguel",
            "Pedro",
            "Jorge",
            "Fernando",
            "Roberto",
            "Ricardo",
            "Alejandro",
            "Daniel",
            "David",
            "Eduardo",
            "Francisco",
            "María",
            "Guadalupe",
            "Ana",
            "Laura",
            "Patricia",
            "Fernanda",
            "Gabriela",
            "Sofía",
            "Andrea",
            "Alejandra",
            "Valeria",
            "Daniela",
            "Carolina",
            "Natalia",
            "Paola"

    };

    /**
     * Apellidos.
     */
    private static final String[] APELLIDOS = {

            "Hernández",
            "García",
            "Martínez",
            "López",
            "González",
            "Pérez",
            "Rodríguez",
            "Sánchez",
            "Ramírez",
            "Flores",
            "Torres",
            "Vargas",
            "Morales",
            "Jiménez",
            "Cruz",
            "Castillo",
            "Ortiz",
            "Reyes",
            "Mendoza",
            "Ruiz"

    };

    /**
     * Dominios de correo.
     */
    private static final String[] DOMINIOS = {

            "itvo.edu.mx",
            "alumno.itvo.edu.mx",
            "correo.itvo.edu.mx"

    };

    /**
     * Constructor privado.
     */
    private PersonaProvider() {
    }

    /**
     * Obtiene un nombre aleatorio.
     *
     * @return Nombre.
     */
    public static String randomNombre() {

        return NOMBRES[
                ThreadLocalRandom.current()
                        .nextInt(NOMBRES.length)];

    }

    /**
     * Obtiene un apellido aleatorio.
     *
     * @return Apellido.
     */
    public static String randomApellido() {

        return APELLIDOS[
                ThreadLocalRandom.current()
                        .nextInt(APELLIDOS.length)];

    }

    /**
     * Obtiene un dominio aleatorio.
     *
     * @return Dominio.
     */
    public static String randomDominio() {

        return DOMINIOS[
                ThreadLocalRandom.current()
                        .nextInt(DOMINIOS.length)];

    }

}