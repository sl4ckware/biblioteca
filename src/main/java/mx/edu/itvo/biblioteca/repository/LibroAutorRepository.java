package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import mx.edu.itvo.biblioteca.entity.LibroAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroAutorRepository extends JpaRepository<LibroAutor,Integer>{

    List<LibroAutor> findByLibroIdLibro(Integer idLibro);

    List<LibroAutor> findByAutorIdAutor(Integer idAutor);

    boolean existsByLibroIdLibroAndAutorIdAutor(Integer idLibro,
                                                Integer idAutor);

}