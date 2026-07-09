package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.EstadoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo,Integer>{

    Optional<EstadoPrestamo> findByNombre(String nombre);

    //List<EstadoPrestamo> findByActivoTrue();

}