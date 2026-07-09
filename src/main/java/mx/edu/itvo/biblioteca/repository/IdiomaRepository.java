package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma,Integer>{

    Optional<Idioma> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    List<Idioma> findByActivoTrue();

}