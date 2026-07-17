package mx.edu.itvo.biblioteca.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.LibroRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.LibroResponseDTO;
import mx.edu.itvo.biblioteca.service.LibroService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de libros.
 *
 * @author Conce
 * @version 1.0
 * @since 1.0
 */

@Tag(
    name = "📚 Libros",
    description = "Administración del catálogo bibliográfico."
)

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    /**
     * Servicio de libros.
     */
    private final LibroService libroService;

    /**
     * Constructor.
     *
     * @param libroService servicio de libros.
     */
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Obtiene el listado completo de libros.
     *
     * @return lista de libros.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de libros.",
                        libroService.listar()));

    }

    /**
     * Obtiene el listado de libros activos.
     *
     * @return lista de libros activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de libros activos.",
                        libroService.listarActivos()));

    }

    /**
     * Busca un libro por su identificador.
     *
     * @param id identificador del libro.
     * @return libro encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LibroResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libro encontrado.",
                        libroService.buscarPorId(id)));

    }

    /**
     * Busca un libro por ISBN.
     *
     * @param isbn13 ISBN del libro.
     * @return libro encontrado.
     */
    @GetMapping("/isbn/{isbn13}")
    public ResponseEntity<ApiResponse<LibroResponseDTO>> buscarPorIsbn(
            @PathVariable String isbn13) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libro encontrado.",
                        libroService.buscarPorIsbn(isbn13)));

    }

    /**
     * Busca libros por coincidencia de título.
     *
     * @param titulo título o parte del título.
     * @return lista de libros.
     */
    @GetMapping("/buscar")
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> buscarPorTitulo(
            @RequestParam String titulo) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Búsqueda realizada.",
                        libroService.buscarPorTitulo(titulo)));

    }

    /**
     * Busca libros por categoría.
     *
     * @param idCategoria identificador de la categoría.
     * @return lista de libros.
     */
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> buscarPorCategoria(
            @PathVariable Integer idCategoria) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libros encontrados.",
                        libroService.buscarPorCategoria(idCategoria)));

    }

    /**
     * Busca libros por editorial.
     *
     * @param idEditorial identificador de la editorial.
     * @return lista de libros.
     */
    @GetMapping("/editorial/{idEditorial}")
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> buscarPorEditorial(
            @PathVariable Integer idEditorial) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libros encontrados.",
                        libroService.buscarPorEditorial(idEditorial)));

    }

    /**
     * Busca libros por idioma.
     *
     * @param idIdioma identificador del idioma.
     * @return lista de libros.
     */
    @GetMapping("/idioma/{idIdioma}")
    public ResponseEntity<ApiResponse<List<LibroResponseDTO>>> buscarPorIdioma(
            @PathVariable Integer idIdioma) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libros encontrados.",
                        libroService.buscarPorIdioma(idIdioma)));

    }

    /**
     * Registra un nuevo libro.
     *
     * @param request información del libro.
     * @return libro registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<LibroResponseDTO>> guardar(
            @Valid @RequestBody LibroRequestDTO request) {

        LibroResponseDTO response = libroService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Libro registrado correctamente.",
                        response));

    }

    /**
     * Actualiza un libro existente.
     *
     * @param id identificador del libro.
     * @param request información actualizada.
     * @return libro actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LibroResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody LibroRequestDTO request) {

        LibroResponseDTO response =
                libroService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libro actualizado correctamente.",
                        response));

    }

    /**
     * Elimina lógicamente un libro.
     *
     * @param id identificador del libro.
     * @return respuesta de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        libroService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Libro eliminado correctamente.",
                        null));

    }

}