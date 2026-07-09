package mx.edu.itvo.biblioteca.repository;

import java.time.LocalDate;
import java.util.List;
import mx.edu.itvo.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer>{

    List<Prestamo> findByUsuarioIdUsuario(Integer idUsuario);

    List<Prestamo> findByEjemplarIdEjemplar(Integer idEjemplar);

    List<Prestamo> findByEstadoPrestamoIdEstadoPrestamo(Integer idEstado);

    List<Prestamo> findByFechaPrestamoBetween(LocalDate inicio,
                                             LocalDate fin);

    List<Prestamo> findByFechaLimiteBefore(LocalDate fecha);

    List<Prestamo> findByFechaDevolucionIsNull();

    List<Prestamo> findByActivoTrue();

    boolean existsByEjemplarIdEjemplarAndFechaDevolucionIsNull(Integer idEjemplar);

}