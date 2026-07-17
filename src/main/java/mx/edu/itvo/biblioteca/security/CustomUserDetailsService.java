package mx.edu.itvo.biblioteca.security;

import mx.edu.itvo.biblioteca.entity.Usuario;
import mx.edu.itvo.biblioteca.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Servicio encargado de cargar usuarios desde la base de datos.
 *
 * Utilizado por Spring Security durante el proceso de autenticación.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    /**
     * Repositorio de usuarios.
     */
    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor.
     *
     * @param usuarioRepository Repositorio.
     */
    public CustomUserDetailsService(
            UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;

    }

    /**
     * Carga un usuario mediante su correo electrónico.
     *
     * @param correo Correo del usuario.
     * @return Usuario autenticable.
     * @throws UsernameNotFoundException Si el usuario no existe.
     */
    @Override
    public UserDetails loadUserByUsername(
            String correo)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository
                .findByCorreo(correo)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado."));

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getPassword())
                .disabled(Boolean.FALSE.equals(usuario.getActivo()))
                .authorities(Collections.emptyList())
                .build();

    }

}