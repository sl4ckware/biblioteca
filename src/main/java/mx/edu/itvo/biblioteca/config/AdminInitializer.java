package mx.edu.itvo.biblioteca.config;

import mx.edu.itvo.biblioteca.entity.EstadoUsuario;
import mx.edu.itvo.biblioteca.entity.TipoUsuario;
import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.repository.EstadoUsuarioRepository;
import mx.edu.itvo.biblioteca.repository.TipoUsuarioRepository;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Inicializa el usuario administrador del sistema.
 *
 * Si el administrador no existe en la base de datos,
 * se crea automáticamente con una contraseña cifrada.
 *
 * @author Conce
 * @version 1.0
 * @since 2.0
 */
@Component
public class AdminInitializer implements CommandLineRunner {

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Repositorio de tipos de usuario.
     */
    private final TipoUsuarioRepository tipoUsuarioRepository;

    /**
     * Repositorio de estados de usuario.
     */
    private final EstadoUsuarioRepository estadoUsuarioRepository;

    /**
     * Codificador de contraseñas.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor.
     *
     * @param usuarioRepository Repositorio de usuarios.
     * @param tipoUsuarioRepository Repositorio de tipos.
     * @param estadoUsuarioRepository Repositorio de estados.
     * @param passwordEncoder Codificador BCrypt.
     */
    public AdminInitializer(
            UsuarioRepository usuarioRepository,
            TipoUsuarioRepository tipoUsuarioRepository,
            EstadoUsuarioRepository estadoUsuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Crea el usuario administrador si no existe.
     *
     * @param args Argumentos de inicio.
     */
    @Override
    public void run(String... args) {

        if (usuarioRepository.existsByCorreo("admin@biblioteca.local")) {

            System.out.println(
                    "El usuario administrador ya existe.");

            return;
        }

        TipoUsuario tipoAdministrador =
                tipoUsuarioRepository
                        .findByNombre("Administrador")
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "No existe el tipo de usuario 'Administrador'."));

        EstadoUsuario estadoActivo =
                estadoUsuarioRepository
                        .findByNombre("Activo")
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "No existe el estado de usuario 'Activo'."));

        Usuario administrador = new Usuario();

        administrador.setMatricula("ADM000001");
        administrador.setNombre("Administrador");
        administrador.setApellidoPaterno("Sistema");
        administrador.setApellidoMaterno(null);
        administrador.setCorreo("admin@biblioteca.local");
        administrador.setPassword(
                passwordEncoder.encode("Admin123*"));
        administrador.setTelefono("0000000000");
        administrador.setActivo(true);
        administrador.setTipoUsuario(tipoAdministrador);
        administrador.setEstadoUsuario(estadoActivo);

        usuarioRepository.save(administrador);

        System.out.println("""
                
==================================================
   ADMINISTRADOR CREADO CORRECTAMENTE
==================================================
Correo      : admin@biblioteca.local
Contraseña  : Admin123*
==================================================
""");
    }

}