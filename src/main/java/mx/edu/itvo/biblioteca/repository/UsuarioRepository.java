package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    Optional<Usuario> findByMatricula(String matricula);

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByMatricula(String matricula);

    boolean existsByCorreo(String correo);

    List<Usuario> findByApellidoPaternoContainingIgnoreCase(String apellido);

    List<Usuario> findByActivoTrue();

}