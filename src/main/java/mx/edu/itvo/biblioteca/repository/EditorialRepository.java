package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,Integer>{

    Optional<Editorial> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    List<Editorial> findByActivoTrue();

    List<Editorial> findByNombreContainingIgnoreCase(String nombre);

}