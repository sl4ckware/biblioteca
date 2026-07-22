package mx.edu.itvo.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.itvo.biblioteca.entity.EstadoReserva;

/**
 * Repositorio para la gestión
 * de estados de reserva.
 *
 * <p>
 * Permite consultar los estados
 * utilizados por el módulo de
 * reservas.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 18
 */
public interface EstadoReservaRepository
        extends JpaRepository<
                EstadoReserva,
                Integer> {

    /**
     * Busca un estado por su nombre.
     *
     * @param nombre Nombre del estado.
     * @return Estado encontrado.
     */
    Optional<EstadoReserva> findByNombre(
            String nombre);

}