package mx.edu.itvo.biblioteca.dataset.util;

import java.util.Random;

/**
 * Contiene catálogos de nombres, apellidos y nacionalidades utilizados
 * por el Dataset Generator.
 *
 * La finalidad de esta clase es centralizar los datos utilizados durante
 * la generación de autores y usuarios ficticios.
 *
 * @author Conce
 * @version 1.0
 */
public final class NameData {

    /**
     * Generador de números aleatorios.
     */
    private static final Random RANDOM = new Random();

    /**
     * Catálogo de nombres.
     */
    private static final String[] NOMBRES = {

        "Carlos",
        "Juan",
        "Luis",
        "Fernando",
        "Miguel",
        "Daniel",
        "Alejandro",
        "Eduardo",
        "Roberto",
        "Santiago",
        "Javier",
        "Ricardo",
        "Francisco",
        "Jesús",
        "Jorge",
        "Oscar",
        "Héctor",
        "Iván",
        "Raúl",
        "Arturo",

        "María",
        "Ana",
        "Patricia",
        "Fernanda",
        "Gabriela",
        "Daniela",
        "Alejandra",
        "Lucía",
        "Carolina",
        "Valeria",
        "Diana",
        "Adriana",
        "Mónica",
        "Verónica",
        "Paola",
        "Laura",
        "Andrea",
        "Sofía",
        "Natalia",
        "Karla"

    };

    /**
     * Catálogo de apellidos.
     */
    private static final String[] APELLIDOS = {

        "García",
        "Hernández",
        "López",
        "Martínez",
        "Rodríguez",
        "González",
        "Pérez",
        "Sánchez",
        "Ramírez",
        "Torres",
        "Flores",
        "Rivera",
        "Morales",
        "Castillo",
        "Ortiz",
        "Cruz",
        "Reyes",
        "Vargas",
        "Mendoza",
        "Domínguez"

    };

    /**
     * Catálogo de nacionalidades.
     */
    private static final String[] NACIONALIDADES = {

        "Mexicana",
        "Española",
        "Argentina",
        "Colombiana",
        "Chilena",
        "Peruana",
        "Uruguaya",
        "Brasileña",
        "Canadiense",
        "Estadounidense"

    };

    /**
     * Constructor privado.
     */
    private NameData() {

    }

    /**
     * Obtiene un nombre aleatorio.
     *
     * @return Nombre.
     */
    public static String nombre() {

        return NOMBRES[RANDOM.nextInt(NOMBRES.length)];

    }

    /**
     * Obtiene un apellido aleatorio.
     *
     * @return Apellido.
     */
    public static String apellido() {

        return APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];

    }

    /**
     * Obtiene una nacionalidad aleatoria.
     *
     * @return Nacionalidad.
     */
    public static String nacionalidad() {

        return NACIONALIDADES[RANDOM.nextInt(NACIONALIDADES.length)];

    }

}