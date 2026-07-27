package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopCategoriaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface DashboardTopCategoriaRepository
        extends JpaRepository<DashboardTopCategoriaView, Long> {

}