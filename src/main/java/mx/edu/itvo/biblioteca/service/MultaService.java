package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.MultaRequestDTO;
import mx.edu.itvo.biblioteca.dto.request.MultaUpdateDTO;
import mx.edu.itvo.biblioteca.dto.response.MultaResponseDTO;

/**
 * ============================================================
 * Sprint 19
 * Historia Técnica 19.2
 *
 * Servicio de la entidad Multa.
 * ============================================================
 *
 * <p>
 * Define las operaciones de negocio
 * correspondientes al módulo de multas.
 * </p>
 *
 * <p>
 * Esta interfaz establece el contrato que
 * deberá implementar la capa de servicio,
 * centralizando las reglas de negocio y
 * coordinando la interacción entre los
 * repositorios, entidades y DTO utilizados
 * por el módulo.
 * </p>
 *
 * @author Conce
 * @version 3.0
 * @since Sprint 19
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
     * Busca una multa por
     * su identificador.
     *
     * @param id Identificador.
     * @return Multa encontrada.
     */
    MultaResponseDTO buscarPorId(
            Integer id);

    /**
     * Busca una multa por
     * su folio.
     *
     * @param folio Folio.
     * @return Multa encontrada.
     */
    MultaResponseDTO buscarPorFolio(
            String folio);

    /**
     * Obtiene las multas
     * asociadas a un préstamo.
     *
     * @param idPrestamo Identificador.
     * @return Lista de multas.
     */
    List<MultaResponseDTO> buscarPorPrestamo(
            Integer idPrestamo);

    /**
     * Obtiene las multas
     * asociadas a un usuario.
     *
     * @param idUsuario Identificador.
     * @return Lista de multas.
     */
    List<MultaResponseDTO> buscarPorUsuario(
            Integer idUsuario);

    /**
     * Obtiene las multas
     * por estado.
     *
     * @param estado Estado.
     * @return Lista de multas.
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
     * Verifica si existe
     * un folio registrado.
     *
     * @param folio Folio.
     * @return {@code true} si existe;
     *         {@code false} en caso contrario.
     */
    boolean existeFolio(
            String folio);

}