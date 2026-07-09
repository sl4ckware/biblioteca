package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.AutorRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.AutorResponseDTO;

/**
 * Define el contrato de servicios para la administración de autores.
 *
 * <p>
 * Esta interfaz establece las operaciones disponibles para la gestión
 * del catálogo de autores dentro del Sistema Integral de Gestión
 * Bibliotecaria.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface AutorService {

    /**
     * Obtiene la lista de autores registrados.
     *
     * @return lista de autores.
     */
    List<AutorResponseDTO> listar();

    /**
     * Obtiene la lista de autores activos.
     *
     * @return lista de autores activos.
     */
    List<AutorResponseDTO> listarActivos();

    /**
     * Busca un autor mediante su identificador.
     *
     * @param id identificador del autor.
     * @return autor encontrado.
     */
    AutorResponseDTO buscarPorId(Integer id);

    /**
     * Busca un autor por su nombre.
     *
     * @param nombre nombre del autor.
     * @return autor encontrado.
     */
    AutorResponseDTO buscarPorNombre(String nombre);

    /**
     * Busca autores cuyo nombre coincida parcial o totalmente.
     *
     * @param nombre nombre o parte del nombre.
     * @return lista de autores encontrados.
     */
    List<AutorResponseDTO> buscarPorCoincidenciaNombre(String nombre);

    /**
     * Registra un nuevo autor.
     *
     * @param request información del autor.
     * @return autor registrado.
     */
    AutorResponseDTO guardar(AutorRequestDTO request);

    /**
     * Actualiza la información de un autor.
     *
     * @param id identificador del autor.
     * @param request nueva información.
     * @return autor actualizado.
     */
    AutorResponseDTO actualizar(Integer id,
                                AutorRequestDTO request);

    /**
     * Realiza la eliminación lógica de un autor.
     *
     * @param id identificador del autor.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe un autor con el nombre indicado.
     *
     * @param nombre nombre del autor.
     * @return true si existe; false en caso contrario.
     */
    boolean existeNombre(String nombre);

}