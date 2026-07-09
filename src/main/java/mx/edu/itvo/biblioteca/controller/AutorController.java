package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.AutorRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.AutorResponseDTO;
import mx.edu.itvo.biblioteca.service.AutorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de autores.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "*")
public class AutorController {

    /**
     * Servicio de autores.
     */
    private final AutorService autorService;

    /**
     * Constructor que inicializa el servicio de autores.
     *
     * @param autorService servicio de autores.
     */
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    /**
     * Obtiene el listado completo de autores.
     *
     * @return listado de autores.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<AutorResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de autores.",
                        autorService.listar()));

    }

    /**
     * Obtiene el listado de autores activos.
     *
     * @return listado de autores activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<AutorResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de autores activos.",
                        autorService.listarActivos()));

    }

    /**
     * Busca un autor por su identificador.
     *
     * @param id identificador del autor.
     * @return autor encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AutorResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Autor encontrado.",
                        autorService.buscarPorId(id)));

    }

    /**
     * Busca un autor por su nombre.
     *
     * @param nombre nombre del autor.
     * @return autor encontrado.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ApiResponse<AutorResponseDTO>> buscarPorNombre(
            @PathVariable String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Autor encontrado.",
                        autorService.buscarPorNombre(nombre)));

    }

    /**
     * Busca autores por coincidencia de nombre.
     *
     * @param nombre nombre o parte del nombre.
     * @return lista de autores encontrados.
     */
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<AutorResponseDTO>>> buscarPorCoincidenciaNombre(
            @RequestParam String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        autorService.buscarPorCoincidenciaNombre(nombre)));

    }

    /**
     * Registra un nuevo autor.
     *
     * @param request información del autor.
     * @return autor registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<AutorResponseDTO>> guardar(
            @Valid @RequestBody AutorRequestDTO request) {

        AutorResponseDTO response = autorService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Autor registrado correctamente.",
                        response));

    }

    /**
     * Actualiza un autor existente.
     *
     * @param id identificador del autor.
     * @param request información actualizada.
     * @return autor actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AutorResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody AutorRequestDTO request) {

        AutorResponseDTO response =
                autorService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Autor actualizado correctamente.",
                        response));

    }

    /**
     * Realiza la eliminación lógica de un autor.
     *
     * @param id identificador del autor.
     * @return resultado de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        autorService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Autor eliminado correctamente.",
                        null));

    }

}