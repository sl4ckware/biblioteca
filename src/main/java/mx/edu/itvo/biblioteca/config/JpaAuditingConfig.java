package mx.edu.itvo.biblioteca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Habilita la auditoría automática de Spring Data JPA.
 *
 * <p>
 * Permite gestionar automáticamente los campos de auditoría
 * como fecha de creación y fecha de actualización mediante
 * las anotaciones correspondientes.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {

}