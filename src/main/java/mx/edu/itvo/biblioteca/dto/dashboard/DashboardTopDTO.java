package mx.edu.itvo.biblioteca.dto.dashboard;

/**
 * DTO utilizado para representar
 * los elementos del Top del Dashboard.
 *
 * Se utiliza para libros, autores,
 * categorías, editoriales e idiomas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public class DashboardTopDTO {

    /**
     * Identificador.
     */
    private Long id;

    /**
     * Nombre.
     */
    private String nombre;

    /**
     * Total de préstamos.
     */
    private Long totalPrestamos;

    /**
     * Constructor vacío.
     */
    public DashboardTopDTO() {
    }

    /**
     * Obtiene el identificador.
     *
     * @return Identificador.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador.
     *
     * @param id Identificador.
     */
    public void setId(Long id) {
        this.id = id;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el total de préstamos.
     *
     * @return Total de préstamos.
     */
    public Long getTotalPrestamos() {
        return totalPrestamos;
    }

    /**
     * Establece el total de préstamos.
     *
     * @param totalPrestamos Total de préstamos.
     */
    public void setTotalPrestamos(Long totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

}