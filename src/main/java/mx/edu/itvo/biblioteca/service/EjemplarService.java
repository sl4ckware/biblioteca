package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.EjemplarRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EjemplarResponseDTO;

/**
 * Define las operaciones de negocio para la gestión de ejemplares.
 *
 * Esta interfaz declara los servicios disponibles para administrar
 * los ejemplares registrados en el sistema de biblioteca.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
public interface EjemplarService {

    /**
     * Obtiene todos los ejemplares.
     *
     * @return Lista de ejemplares.
     */
    List<EjemplarResponseDTO> listar();

    /**
     * Obtiene únicamente los ejemplares activos.
     *
     * @return Lista de ejemplares activos.
     */
    List<EjemplarResponseDTO> listarActivos();

    /**
     * Busca un ejemplar por su identificador.
     *
     * @param id Identificador del ejemplar.
     * @return Ejemplar encontrado.
     */
    EjemplarResponseDTO buscarPorId(Integer id);

    /**
     * Busca un ejemplar por su código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return Ejemplar encontrado.
     */
    EjemplarResponseDTO buscarPorCodigoInventario(
            String codigoInventario);

    /**
     * Obtiene los ejemplares pertenecientes a un libro.
     *
     * @param idLibro Identificador del libro.
     * @return Lista de ejemplares.
     */
    List<EjemplarResponseDTO> buscarPorLibro(Integer idLibro);

    /**
     * Obtiene los ejemplares por estado.
     *
     * @param idEstadoEjemplar Identificador del estado.
     * @return Lista de ejemplares.
     */
    List<EjemplarResponseDTO> buscarPorEstado(
            Integer idEstadoEjemplar);

    /**
     * Registra un nuevo ejemplar.
     *
     * @param request Información recibida desde la API.
     * @return Ejemplar registrado.
     */
    EjemplarResponseDTO guardar(EjemplarRequestDTO request);

    /**
     * Actualiza un ejemplar existente.
     *
     * @param id Identificador del ejemplar.
     * @param request Información actualizada.
     * @return Ejemplar actualizado.
     */
    EjemplarResponseDTO actualizar(
            Integer id,
            EjemplarRequestDTO request);

    /**
     * Realiza la eliminación lógica de un ejemplar.
     *
     * @param id Identificador del ejemplar.
     */
    void eliminar(Integer id);

    /**
     * Verifica si existe un código de inventario.
     *
     * @param codigoInventario Código de inventario.
     * @return {@code true} si existe.
     */
    boolean existeCodigoInventario(
            String codigoInventario);

}