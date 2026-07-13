package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;

/**
 * Servicio para la gestión
 * de multas.
 *
 * Define las operaciones de negocio
 * del módulo de multas.
 *
 * @author Conce
 * @version 2.0
 * @since 2.0
 */
public interface MultaService {

    /**
     * Obtiene todas las multas.
     *
     * @return Lista de multas.
     */
    List<MultaResponseDTO> listar();

    /**
     * Obtiene únicamente
     * las multas activas.
     *
     * @return Lista de multas.
     */
    List<MultaResponseDTO> listarActivas();

    /**
     * Busca una multa por ID.
     *
     * @param id Identificador.
     * @return Multa encontrada.
     */
    MultaResponseDTO buscarPorId(
            Integer id);

    /**
     * Busca una multa por folio.
     *
     * @param folio Folio.
     * @return Multa encontrada.
     */
    MultaResponseDTO buscarPorFolio(
            String folio);

    /**
     * Obtiene las multas
     * de un préstamo.
     *
     * @param idPrestamo Identificador.
     * @return Lista.
     */
    List<MultaResponseDTO> buscarPorPrestamo(
            Integer idPrestamo);

    /**
     * Obtiene las multas
     * de un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista.
     */
    List<MultaResponseDTO> buscarPorUsuario(
            Integer idUsuario);

    /**
     * Obtiene las multas
     * por estado.
     *
     * @param estado Estado.
     * @return Lista.
     */
    List<MultaResponseDTO> buscarPorEstado(
            String estado);

    /**
     * Registra una nueva multa.
     *
     * @param request Información.
     * @return Multa registrada.
     */
    MultaResponseDTO guardar(
            MultaRequestDTO request);

    /**
     * Actualiza la información
     * editable de una multa.
     *
     * @param id Identificador.
     * @param request Información.
     * @return Multa actualizada.
     */
    MultaResponseDTO actualizar(
            Integer id,
            MultaUpdateDTO request);

    /**
     * Verifica si existe un folio.
     *
     * @param folio Folio.
     * @return true si existe.
     */
    boolean existeFolio(
            String folio);

}