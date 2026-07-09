package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer>{

    Optional<TipoUsuario> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    List<TipoUsuario> findByActivoTrue();

}