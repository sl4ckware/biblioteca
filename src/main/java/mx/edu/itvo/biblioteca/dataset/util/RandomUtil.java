package mx.edu.itvo.biblioteca.dataset.util;

import java.util.List;
import java.util.Random;

/**
 * Proporciona métodos utilitarios para la generación de valores aleatorios.
 *
 * <p>
 * Esta clase centraliza el uso de un único objeto {@link Random} para todo
 * el Dataset Generator, garantizando consistencia y facilitando futuras
 * mejoras como el uso de semillas para generar datos reproducibles.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class RandomUtil {

    /**
     * Generador de números aleatorios utilizado por todo el proyecto.
     */
    private static final Random RANDOM = new Random();

    /**
     * Constructor privado para evitar instancias.
     */
    private RandomUtil() {
    }

    /**
     * Obtiene un número entero aleatorio entre cero (incluido) y el límite
     * indicado (excluido).
     *
     * @param limite Valor máximo exclusivo.
     * @return Número aleatorio.
     * @throws IllegalArgumentException Si el límite es menor o igual a cero.
     */
    public static int nextInt(int limite) {

        if (limite <= 0) {
            throw new IllegalArgumentException(
                    "El límite debe ser mayor que cero.");
        }

        return RANDOM.nextInt(limite);
    }

    /**
     * Obtiene un número entero aleatorio dentro de un rango.
     *
     * @param minimo Valor mínimo incluido.
     * @param maximo Valor máximo incluido.
     * @return Número aleatorio dentro del rango.
     * @throws IllegalArgumentException Si el rango es inválido.
     */
    public static int nextInt(
            int minimo,
            int maximo) {

        if (minimo > maximo) {
            throw new IllegalArgumentException(
                    "El valor mínimo no puede ser mayor que el máximo.");
        }

        return RANDOM.nextInt(maximo - minimo + 1) + minimo;
    }

    /**
     * Devuelve un valor booleano aleatorio.
     *
     * @return {@code true} o {@code false}.
     */
    public static boolean nextBoolean() {

        return RANDOM.nextBoolean();
    }

    /**
     * Selecciona un elemento aleatorio de una lista.
     *
     * @param <T> Tipo de los elementos.
     * @param elementos Lista de elementos.
     * @return Elemento seleccionado.
     * @throws IllegalArgumentException Si la lista es nula o está vacía.
     */
    public static <T> T randomElement(List<T> elementos) {

        if (elementos == null || elementos.isEmpty()) {
            throw new IllegalArgumentException(
                    "La lista no puede ser nula o vacía.");
        }

        return elementos.get(nextInt(elementos.size()));
    }

    /**
     * Selecciona un elemento aleatorio de un arreglo.
     *
     * @param <T> Tipo de los elementos.
     * @param elementos Arreglo de elementos.
     * @return Elemento seleccionado.
     * @throws IllegalArgumentException Si el arreglo es nulo o está vacío.
     */
    public static <T> T randomElement(T[] elementos) {

        if (elementos == null || elementos.length == 0) {
            throw new IllegalArgumentException(
                    "El arreglo no puede ser nulo o vacío.");
        }

        return elementos[nextInt(elementos.length)];
    }

}