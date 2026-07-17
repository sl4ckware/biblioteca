package mx.edu.itvo.biblioteca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.CategoriaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.CategoriaResponseDTO;
import mx.edu.itvo.biblioteca.service.CategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de categorías.
 *
 * Expone los servicios CRUD de la entidad Categoria.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */

@Tag(
    name = "🏷️ Categorías",
    description = "Administración del catálogo de categorías."
)
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    /**
     * Servicio de categorías.
     */
    private final CategoriaService categoriaService;

    /**
     * Constructor.
     *
     * @param categoriaService Servicio de categorías.
     */
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Obtiene todas las categorías.
     *
     * @return Lista de categorías.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoriaResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de categorías.",
                        categoriaService.listar()));

    }

    /**
     * Obtiene únicamente las categorías activas.
     *
     * @return Lista de categorías activas.
     */
    @GetMapping("/activas")
    public ResponseEntity<ApiResponse<List<CategoriaResponseDTO>>> listarActivas() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de categorías activas.",
                        categoriaService.listarActivas()));

    }

    /**
     * Busca una categoría por su identificador.
     *
     * @param id Identificador.
     * @return Categoría encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoriaResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Categoría encontrada.",
                        categoriaService.buscarPorId(id)));

    }

    /**
     * Busca una categoría por su código.
     *
     * @param codigo Código.
     * @return Categoría encontrada.
     */
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ApiResponse<CategoriaResponseDTO>> buscarPorCodigo(
            @PathVariable String codigo) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Categoría encontrada.",
                        categoriaService.buscarPorCodigo(codigo)));

    }

    /**
     * Busca categorías por nombre.
     *
     * @param nombre Nombre.
     * @return Lista de categorías.
     */
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<CategoriaResponseDTO>>> buscarPorNombre(
            @RequestParam String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        categoriaService.buscarPorNombre(nombre)));

    }

    /**
     * Registra una nueva categoría.
     *
     * @param request Información recibida.
     * @return Categoría registrada.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<CategoriaResponseDTO>> guardar(
            @Valid @RequestBody CategoriaRequestDTO request) {

        CategoriaResponseDTO response =
                categoriaService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Categoría registrada correctamente.",
                        response));

    }

    /**
     * Actualiza una categoría.
     *
     * @param id Identificador.
     * @param request Información nueva.
     * @return Categoría actualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoriaResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody CategoriaRequestDTO request) {

        CategoriaResponseDTO response =
                categoriaService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Categoría actualizada correctamente.",
                        response));

    }

    /**
     * Elimina lógicamente una categoría.
     *
     * @param id Identificador.
     * @return Confirmación de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        categoriaService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Categoría eliminada correctamente.",
                        null));

    }

}