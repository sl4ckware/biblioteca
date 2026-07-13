package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.PrestamoRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.PrestamoUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.PrestamoResponseDTO;

/**
 * Servicio para la gestión de préstamos.
 *
 * Define las operaciones de negocio
 * relacionadas con los préstamos.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface PrestamoService {

    /**
     * Obtiene todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    List<PrestamoResponseDTO> listar();

    /**
     * Obtiene únicamente los préstamos activos.
     *
     * @return Lista de préstamos activos.
     */
    List<PrestamoResponseDTO> listarActivos();

    /**
     * Busca un préstamo por su identificador.
     *
     * @param id Identificador.
     * @return Préstamo encontrado.
     */
    PrestamoResponseDTO buscarPorId(Integer id);

    /**
     * Busca un préstamo por folio.
     *
     * @param folio Folio.
     * @return Préstamo encontrado.
     */
    PrestamoResponseDTO buscarPorFolio(String folio);

    /**
     * Obtiene los préstamos de un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Lista de préstamos.
     */
    List<PrestamoResponseDTO> buscarPorUsuario(
            Integer idUsuario);

    /**
     * Obtiene los préstamos de un ejemplar.
     *
     * @param idEjemplar Identificador del ejemplar.
     * @return Lista de préstamos.
     */
    List<PrestamoResponseDTO> buscarPorEjemplar(
            Integer idEjemplar);

    /**
     * Obtiene los préstamos vencidos.
     *
     * @return Lista de préstamos vencidos.
     */
    List<PrestamoResponseDTO> buscarVencidos();

    /**
     * Registra un préstamo.
     *
     * @param request Información del préstamo.
     * @return Préstamo registrado.
     */
    PrestamoResponseDTO guardar(
            PrestamoRequestDTO request);

    /**
     * Actualiza la información editable
     * de un préstamo.
     *
     * @param id Identificador.
     * @param request Información editable.
     * @return Préstamo actualizado.
     */
    PrestamoResponseDTO actualizar(
            Integer id,
            PrestamoUpdateDTO request);

    /**
     * Registra la devolución.
     *
     * @param id Identificador.
     * @return Préstamo actualizado.
     */
    PrestamoResponseDTO devolver(
            Integer id);

    /**
     * Renueva un préstamo.
     *
     * @param id Identificador.
     * @param dias Días adicionales.
     * @return Préstamo actualizado.
     */
    PrestamoResponseDTO renovar(
            Integer id,
            Integer dias);

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existeFolio(
            String folio);

}