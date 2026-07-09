package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

    Optional<Categoria> findByCodigo(String codigo);

    Optional<Categoria> findByNombre(String nombre);

    boolean existsByCodigo(String codigo);

    boolean existsByNombre(String nombre);

    List<Categoria> findByActivoTrue();

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);

}