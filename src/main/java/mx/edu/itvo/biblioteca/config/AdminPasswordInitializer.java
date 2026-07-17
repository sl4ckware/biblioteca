package mx.edu.itvo.biblioteca.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;

/**
 * Inicializa la contraseña del usuario administrador
 * si aún se encuentra almacenada en texto plano.
 *
 * Esta clase solo cifra la contraseña una única vez.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Component
public class AdminPasswordInitializer
        implements CommandLineRunner {

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Codificador de contraseñas.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor.
     *
     * @param usuarioRepository Repositorio.
     * @param passwordEncoder Codificador.
     */
    public AdminPasswordInitializer(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository =
                usuarioRepository;

        this.passwordEncoder =
                passwordEncoder;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(
            String... args)
            throws Exception {

        usuarioRepository
                .findByCorreo("admin@biblioteca.local")
                .ifPresent(usuario -> {

                    String password =
                            usuario.getPassword();

                    if (!password.startsWith("$2")) {

                        usuario.setPassword(
                                passwordEncoder.encode(
                                        password));

                        usuarioRepository.save(
                                usuario);

                        System.out.println(
                                "Contraseña del administrador cifrada correctamente.");

                    }

                });

    }

}