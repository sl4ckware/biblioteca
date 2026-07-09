package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar,Integer>{

    Optional<Ejemplar> findByCodigoInventario(String codigo);

    boolean existsByCodigoInventario(String codigo);

    List<Ejemplar> findByLibroIdLibro(Integer idLibro);

    List<Ejemplar> findByEstadoEjemplarIdEstadoEjemplar(Integer idEstado);

 //   List<Ejemplar> findByActivoTrue();

}