package mx.edu.itvo.biblioteca.dataset.writer;

/**
 * Convierte un objeto del Dataset Generator
 * en una sentencia SQL.
 *
 * @param <T> Tipo de dato.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface SqlMapper<T> {

    /**
     * Convierte un objeto en una sentencia SQL.
     *
     * @param data Objeto.
     * @return Sentencia SQL.
     */
    String toSql(T data);

}
