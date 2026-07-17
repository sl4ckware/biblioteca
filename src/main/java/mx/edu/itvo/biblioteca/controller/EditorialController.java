package mx.edu.itvo.biblioteca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.EditorialRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.EditorialResponseDTO;
import mx.edu.itvo.biblioteca.service.EditorialService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de editoriales.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */

@Tag(
    name = "🏛️ Editoriales",
    description = "Administración de editoriales."
)
@RestController
@RequestMapping("/api/editoriales")
@CrossOrigin(origins = "*")
public class EditorialController {

    /**
     * Servicio de editoriales.
     */
    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EditorialResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de editoriales.",
                        editorialService.listar()));

    }

    @GetMapping("/activas")
    public ResponseEntity<ApiResponse<List<EditorialResponseDTO>>> listarActivas() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de editoriales activas.",
                        editorialService.listarActivas()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EditorialResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Editorial encontrada.",
                        editorialService.buscarPorId(id)));

    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ApiResponse<EditorialResponseDTO>> buscarPorNombre(
            @PathVariable String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Editorial encontrada.",
                        editorialService.buscarPorNombre(nombre)));

    }

    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<EditorialResponseDTO>>> buscarPorCoincidenciaNombre(
            @RequestParam String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        editorialService.buscarPorCoincidenciaNombre(nombre)));

    }

    @PostMapping
    public ResponseEntity<ApiResponse<EditorialResponseDTO>> guardar(
            @Valid @RequestBody EditorialRequestDTO request) {

        EditorialResponseDTO response =
                editorialService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Editorial registrada correctamente.",
                        response));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EditorialResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody EditorialRequestDTO request) {

        EditorialResponseDTO response =
                editorialService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Editorial actualizada correctamente.",
                        response));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        editorialService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Editorial eliminada correctamente.",
                        null));

    }

}
