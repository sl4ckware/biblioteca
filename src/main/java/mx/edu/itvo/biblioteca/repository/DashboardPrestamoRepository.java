package mx.edu.itvo.biblioteca.repository;

import mx.edu.itvo.biblioteca.entity.dashboard.DashboardPrestamoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface DashboardPrestamoRepository
        extends JpaRepository<DashboardPrestamoView, String> {

}