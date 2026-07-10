package mx.edu.itvo.biblioteca.controller;

import java.util.List;

import jakarta.validation.Valid;

import mx.edu.itvo.biblioteca.dto.common.ApiResponse;
import mx.edu.itvo.biblioteca.dto.request.IdiomaRequestDTO;
import mx.edu.itvo.biblioteca.dto.response.IdiomaResponseDTO;
import mx.edu.itvo.biblioteca.service.IdiomaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de idiomas.
 *
 * Expone los servicios CRUD de la entidad Idioma.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/idiomas")
@CrossOrigin(origins = "*")
public class IdiomaController {

    /**
     * Servicio de idiomas.
     */
    private final IdiomaService idiomaService;

    /**
     * Constructor.
     *
     * @param idiomaService Servicio de idiomas.
     */
    public IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    /**
     * Obtiene todos los idiomas.
     *
     * @return Lista de idiomas.
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<IdiomaResponseDTO>>> listar() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de idiomas.",
                        idiomaService.listar()));

    }

    /**
     * Obtiene únicamente los idiomas activos.
     *
     * @return Lista de idiomas activos.
     */
    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<IdiomaResponseDTO>>> listarActivos() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Listado de idiomas activos.",
                        idiomaService.listarActivos()));

    }

    /**
     * Busca un idioma por su identificador.
     *
     * @param id Identificador.
     * @return Idioma encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<IdiomaResponseDTO>> buscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Idioma encontrado.",
                        idiomaService.buscarPorId(id)));

    }

    /**
     * Busca un idioma por su nombre.
     *
     * @param nombre Nombre del idioma.
     * @return Idioma encontrado.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ApiResponse<IdiomaResponseDTO>> buscarPorNombre(
            @PathVariable String nombre) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Idioma encontrado.",
                        idiomaService.buscarPorNombre(nombre)));

    }

    /**
     * Busca un idioma por su código ISO.
     *
     * @param codigoIso Código ISO.
     * @return Idioma encontrado.
     */
    @GetMapping("/codigo/{codigoIso}")
    public ResponseEntity<ApiResponse<IdiomaResponseDTO>> buscarPorCodigoIso(
            @PathVariable String codigoIso) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Idioma encontrado.",
                        idiomaService.buscarPorCodigoIso(codigoIso)));

    }

    /**
     * Registra un nuevo idioma.
     *
     * @param request Información recibida.
     * @return Idioma registrado.
     */
    @PostMapping
    public ResponseEntity<ApiResponse<IdiomaResponseDTO>> guardar(
            @Valid @RequestBody IdiomaRequestDTO request) {

        IdiomaResponseDTO response =
                idiomaService.guardar(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "Idioma registrado correctamente.",
                        response));

    }

    /**
     * Actualiza un idioma.
     *
     * @param id Identificador.
     * @param request Información nueva.
     * @return Idioma actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<IdiomaResponseDTO>> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody IdiomaRequestDTO request) {

        IdiomaResponseDTO response =
                idiomaService.actualizar(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Idioma actualizado correctamente.",
                        response));

    }

    /**
     * Elimina lógicamente un idioma.
     *
     * @param id Identificador.
     * @return Confirmación de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(
            @PathVariable Integer id) {

        idiomaService.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Idioma eliminado correctamente.",
                        null));

    }

}