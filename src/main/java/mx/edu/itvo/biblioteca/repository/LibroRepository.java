package mx.edu.itvo.biblioteca.repository;

import java.util.List;
import java.util.Optional;
import mx.edu.itvo.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Integer>{

    Optional<Libro> findByIsbn13(String isbn13);

    boolean existsByIsbn13(String isbn13);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    List<Libro> findByCategoriaIdCategoria(Integer idCategoria);

    List<Libro> findByEditorialIdEditorial(Integer idEditorial);

    List<Libro> findByIdiomaIdIdioma(Integer idIdioma);

    List<Libro> findByActivoTrue();

}