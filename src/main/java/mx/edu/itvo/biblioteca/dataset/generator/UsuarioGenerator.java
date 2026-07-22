package mx.edu.itvo.biblioteca.dataset.generator;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itvo.biblioteca.dataset.catalog.EstadoUsuarioCatalog;
import mx.edu.itvo.biblioteca.dataset.catalog.TipoUsuarioCatalog;
import mx.edu.itvo.biblioteca.dataset.config.Config;
import mx.edu.itvo.biblioteca.dataset.factory.DataFactory;
import mx.edu.itvo.biblioteca.dataset.model.EstadoUsuarioData;
import mx.edu.itvo.biblioteca.dataset.model.TipoUsuarioData;
import mx.edu.itvo.biblioteca.dataset.model.UsuarioData;
import mx.edu.itvo.biblioteca.dataset.provider.PersonaProvider;
import mx.edu.itvo.biblioteca.dataset.util.PasswordUtil;
import mx.edu.itvo.biblioteca.dataset.util.UsuarioDataUtil;

/**
 * Genera los usuarios del Dataset Generator.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public final class UsuarioGenerator {

    /**
     * Constructor privado.
     */
    private UsuarioGenerator() {
    }

    /**
     * Genera los usuarios del sistema.
     *
     * @param tipos Tipos de usuario.
     * @param estados Estados de usuario.
     * @return Lista de usuarios.
     */
    public static List<UsuarioData> generar(
            List<TipoUsuarioData> tipos,
            List<EstadoUsuarioData> estados) {

        List<UsuarioData> usuarios =
                new ArrayList<>();

        for (int i = 1;
                i <= Config.DEFAULT_TOTAL_USUARIOS;
                i++) {

            usuarios.add(
                    crearUsuario(
                            i,
                            tipos,
                            estados));

        }

        return usuarios;

    }

    /**
     * Crea un usuario.
     *
     * @param sequence Consecutivo.
     * @param tipos Tipos disponibles.
     * @param estados Estados disponibles.
     * @return Usuario.
     */
    private static UsuarioData crearUsuario(
            int sequence,
            List<TipoUsuarioData> tipos,
            List<EstadoUsuarioData> estados) {

        UsuarioData usuario =
                DataFactory.createUsuario();

        usuario.setMatricula(
                UsuarioDataUtil.generateMatricula(
                        sequence));

        usuario.setNombre(
                PersonaProvider.randomNombre());

        usuario.setApellidoPaterno(
                PersonaProvider.randomApellido());

        usuario.setApellidoMaterno(
                PersonaProvider.randomApellido());

        usuario.setCorreo(
                UsuarioDataUtil.generateCorreo(
                        usuario.getMatricula()));

        usuario.setTelefono(
                UsuarioDataUtil.generateTelefono());

        usuario.setPassword(
                PasswordUtil.encode(
                        Config.DEFAULT_USER_PASSWORD));

        usuario.setTipoUsuario(
                seleccionarTipoUsuario(
                        sequence,
                        tipos));

        usuario.setEstadoUsuario(
                seleccionarEstadoUsuario(
                        sequence,
                        estados));

        return usuario;

    }
        /**
     * Selecciona un tipo de usuario utilizando una
     * distribución similar a una institución educativa.
     *
     * @param sequence Consecutivo.
     * @param tipos Tipos disponibles.
     * @return Tipo de usuario.
     */
    private static TipoUsuarioData seleccionarTipoUsuario(
            int sequence,
            List<TipoUsuarioData> tipos) {

        int porcentaje =
                (sequence - 1) % 100;

        if (porcentaje < 85) {

            return buscarTipoUsuario(
                    tipos,
                    TipoUsuarioCatalog.NOMBRE_ALUMNO);

        }

        if (porcentaje < 93) {

            return buscarTipoUsuario(
                    tipos,
                    TipoUsuarioCatalog.NOMBRE_DOCENTE);

        }

        if (porcentaje < 96) {

            return buscarTipoUsuario(
                    tipos,
                    TipoUsuarioCatalog.NOMBRE_BIBLIOTECARIO);

        }

        if (porcentaje < 98) {

            return buscarTipoUsuario(
                    tipos,
                    TipoUsuarioCatalog.NOMBRE_ADMINISTRADOR);

        }

        if (porcentaje < 99) {

            return buscarTipoUsuario(
                    tipos,
                    TipoUsuarioCatalog.NOMBRE_INVESTIGADOR);

        }

        return buscarTipoUsuario(
                tipos,
                TipoUsuarioCatalog.NOMBRE_USUARIO_EXTERNO);

    }
    
    /**
     * Busca un tipo de usuario por nombre.
     *
     * @param tipos Tipos disponibles.
     * @param nombre Nombre buscado.
     * @return Tipo de usuario.
     * @throws IllegalArgumentException Si el nombre no existe.
     */
    private static TipoUsuarioData buscarTipoUsuario(
            List<TipoUsuarioData> tipos,
            String nombre) {

        for (TipoUsuarioData tipo : tipos) {

            if (nombre.equals(
                    tipo.getNombre())) {

                return tipo;

            }

        }

        throw new IllegalArgumentException(
                "No existe el tipo de usuario: "
                + nombre);

    }
        /**
     * Selecciona un estado de usuario utilizando
     * una distribución realista.
     *
     * @param sequence Consecutivo.
     * @param estados Estados disponibles.
     * @return Estado del usuario.
     */
    private static EstadoUsuarioData seleccionarEstadoUsuario(
            int sequence,
            List<EstadoUsuarioData> estados) {

        int porcentaje =
                (sequence - 1) % 100;

        if (porcentaje < 93) {

            return buscarEstadoUsuario(
                    estados,
                    EstadoUsuarioCatalog.NOMBRE_ACTIVO);

        }

        if (porcentaje < 96) {

            return buscarEstadoUsuario(
                    estados,
                    EstadoUsuarioCatalog.NOMBRE_SUSPENDIDO);

        }

        if (porcentaje < 98) {

            return buscarEstadoUsuario(
                    estados,
                    EstadoUsuarioCatalog.NOMBRE_BLOQUEADO);

        }

        if (porcentaje < 99) {

            return buscarEstadoUsuario(
                    estados,
                    EstadoUsuarioCatalog.NOMBRE_INACTIVO);

        }

        return buscarEstadoUsuario(
                estados,
                EstadoUsuarioCatalog.NOMBRE_EGRESADO);

    }
    
    /**
     * Busca un estado de usuario por nombre.
     *
     * @param estados Estados disponibles.
     * @param nombre Nombre buscado.
     * @return Estado de usuario.
     * @throws IllegalArgumentException
     *         Si el nombre no existe.
     */
    private static EstadoUsuarioData buscarEstadoUsuario(
            List<EstadoUsuarioData> estados,
            String nombre) {

        for (EstadoUsuarioData estado : estados) {

            if (nombre.equals(
                    estado.getNombre())) {

                return estado;

            }

        }

        throw new IllegalArgumentException(
                "No existe el estado de usuario: "
                + nombre);

    }

}


