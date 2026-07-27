package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.entity.dashboard.DashboardTopIdiomaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface DashboardTopIdiomaRepository
        extends JpaRepository<DashboardTopIdiomaView, Long> {

}