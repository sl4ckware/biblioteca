package mx.edu.itvo.biblioteca.dataset.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utilería para generar contraseñas cifradas
 * mediante BCrypt.
 *
 * <p>
 * Esta clase centraliza la generación de hashes
 * utilizados por el Dataset Generator.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public final class PasswordUtil {

    /**
     * Codificador BCrypt reutilizable.
     */
    private static final BCryptPasswordEncoder ENCODER =
            new BCryptPasswordEncoder();

    /**
     * Constructor privado.
     */
    private PasswordUtil() {
    }

    /**
     * Genera un hash BCrypt.
     *
     * @param password Contraseña en texto plano.
     * @return Contraseña cifrada.
     */
    public static String encode(
            String password) {

        return ENCODER.encode(password);

    }

}