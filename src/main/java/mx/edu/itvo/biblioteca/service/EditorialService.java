package mx.edu.itvo.biblioteca.service;

import java.util.List;

import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;

/**
 * Servicio para la gestión de editoriales.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
public interface EditorialService {

    List<EditorialResponseDTO> listar();

    List<EditorialResponseDTO> listarActivas();

    EditorialResponseDTO buscarPorId(Integer id);

    EditorialResponseDTO buscarPorNombre(String nombre);

    List<EditorialResponseDTO> buscarPorCoincidenciaNombre(String nombre);

    EditorialResponseDTO guardar(EditorialRequestDTO request);

    EditorialResponseDTO actualizar(
            Integer id,
            EditorialRequestDTO request);

    void eliminar(Integer id);

    boolean existeNombre(String nombre);

}
