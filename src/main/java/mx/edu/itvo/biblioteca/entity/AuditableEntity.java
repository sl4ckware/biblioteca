package mx.edu.itvo.biblioteca.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

/**
 * Clase base que proporciona los campos de auditoría para
 * las entidades del Sistema Integral de Biblioteca.
 *
 * <p>
 * Todas las entidades que hereden de esta clase dispondrán
 * automáticamente de:
 * </p>
 *
 * <ul>
 *     <li>Estado lógico (activo).</li>
 *     <li>Fecha de creación.</li>
 *     <li>Fecha de actualización.</li>
 * </ul>
 *
 * <p>
 * Las fechas son administradas automáticamente por
 * Spring Data JPA Auditing.
 * </p>
 *
 * @author Conce
 * @version 1.0
 * @since Sprint 17
 */
@MappedSuperclass
@EntityListeners(
        AuditingEntityListener.class)
public abstract class AuditableEntity {

    /**
     * Indica si el registro permanece activo.
     */
    @Column(
            name = "activo",
            nullable = false)
    private Boolean activo = true;

    /**
     * Fecha de creación del registro.
     */
    @CreatedDate
    @Column(
            name = "fecha_creacion",
            nullable = false,
            updatable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de la última actualización.
     */
    @LastModifiedDate
    @Column(
            name = "fecha_actualizacion",
            nullable = false)
    private LocalDateTime fechaActualizacion;

    /**
     * Constructor protegido.
     */
    protected AuditableEntity() {
    }

    /**
     * Obtiene el estado del registro.
     *
     * @return Estado activo.
     */
    public Boolean getActivo() {

        return activo;

    }

    /**
     * Establece el estado del registro.
     *
     * @param activo Estado.
     */
    public void setActivo(
            Boolean activo) {

        this.activo = activo;

    }

    /**
     * Obtiene la fecha de creación.
     *
     * @return Fecha de creación.
     */
    public LocalDateTime getFechaCreacion() {

        return fechaCreacion;

    }

    /**
     * Obtiene la fecha de actualización.
     *
     * @return Fecha de actualización.
     */
    public LocalDateTime getFechaActualizacion() {

        return fechaActualizacion;

    }

}