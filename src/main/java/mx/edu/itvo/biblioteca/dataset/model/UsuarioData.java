package mx.edu.itvo.biblioteca.dataset.model;

/**
 * Representa un usuario utilizado por el
 * Dataset Generator.
 *
 * <p>
 * Mirror Model de la entidad {@code Usuario}.
 * </p>
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public class UsuarioData extends AbstractData {

    /**
     * Matrícula institucional.
     */
    private String matricula;

    /**
     * Nombre.
     */
    private String nombre;

    /**
     * Apellido paterno.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno.
     */
    private String apellidoMaterno;

    /**
     * Correo institucional.
     */
    private String correo;

    /**
     * Teléfono.
     */
    private String telefono;

    /**
     * Contraseña cifrada con BCrypt.
     */
    private String password;

    /**
     * Tipo de usuario.
     */
    private TipoUsuarioData tipoUsuario;

    /**
     * Estado del usuario.
     */
    private EstadoUsuarioData estadoUsuario;

    /**
     * Constructor vacío.
     */
    public UsuarioData() {
    }

    /**
     * Obtiene la matrícula.
     *
     * @return Matrícula.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula.
     *
     * @param matricula Matrícula.
     */
    public void setMatricula(
            String matricula) {

        this.matricula = matricula;

    }

    /**
     * Obtiene el nombre.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     *
     * @param nombre Nombre.
     */
    public void setNombre(
            String nombre) {

        this.nombre = nombre;

    }

    /**
     * Obtiene el apellido paterno.
     *
     * @return Apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno.
     *
     * @param apellidoPaterno Apellido paterno.
     */
    public void setApellidoPaterno(
            String apellidoPaterno) {

        this.apellidoPaterno = apellidoPaterno;

    }

    /**
     * Obtiene el apellido materno.
     *
     * @return Apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno.
     *
     * @param apellidoMaterno Apellido materno.
     */
    public void setApellidoMaterno(
            String apellidoMaterno) {

        this.apellidoMaterno = apellidoMaterno;

    }

    /**
     * Obtiene el correo.
     *
     * @return Correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo.
     *
     * @param correo Correo.
     */
    public void setCorreo(
            String correo) {

        this.correo = correo;

    }

    /**
     * Obtiene el teléfono.
     *
     * @return Teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono.
     *
     * @param telefono Teléfono.
     */
    public void setTelefono(
            String telefono) {

        this.telefono = telefono;

    }

    /**
     * Obtiene la contraseña.
     *
     * @return Contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña.
     *
     * @param password Contraseña.
     */
    public void setPassword(
            String password) {

        this.password = password;

    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return Tipo de usuario.
     */
    public TipoUsuarioData getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario Tipo de usuario.
     */
    public void setTipoUsuario(
            TipoUsuarioData tipoUsuario) {

        this.tipoUsuario = tipoUsuario;

    }

    /**
     * Obtiene el estado del usuario.
     *
     * @return Estado del usuario.
     */
    public EstadoUsuarioData getEstadoUsuario() {
        return estadoUsuario;
    }

    /**
     * Establece el estado del usuario.
     *
     * @param estadoUsuario Estado del usuario.
     */
    public void setEstadoUsuario(
            EstadoUsuarioData estadoUsuario) {

        this.estadoUsuario = estadoUsuario;

    }

    /**
     * Devuelve una representación textual del objeto.
     *
     * @return Información del usuario.
     */
    @Override
    public String toString() {

        return "UsuarioData{"
                + "sequence=" + getSequence()
                + ", matricula='" + matricula + '\''
                + ", nombre='" + nombre + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", correo='" + correo + '\''
                + ", tipoUsuario="
                + (tipoUsuario != null
                        ? tipoUsuario.getNombre()
                        : null)
                + ", estadoUsuario="
                + (estadoUsuario != null
                        ? estadoUsuario.getNombre()
                        : null)
                + '}';

    }

}