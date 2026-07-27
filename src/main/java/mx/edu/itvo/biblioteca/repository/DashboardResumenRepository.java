package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.entity.dashboard.DashboardResumenView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface DashboardResumenRepository
        extends JpaRepository<DashboardResumenView, Integer> {

}