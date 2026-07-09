package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.EstadoEjemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEjemplarRepository extends JpaRepository<EstadoEjemplar,Integer>{

    Optional<EstadoEjemplar> findByNombre(String nombre);


}