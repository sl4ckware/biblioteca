package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopAutorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface DashboardTopAutorRepository
        extends JpaRepository<DashboardTopAutorView, Long> {

}