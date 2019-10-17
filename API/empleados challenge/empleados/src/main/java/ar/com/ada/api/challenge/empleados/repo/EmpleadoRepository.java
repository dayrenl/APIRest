package ar.com.ada.api.challenge.empleados.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.challenge.empleados.entities.Empleado;

/**
 * EmpleadoRepository
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findById(Integer id);

    List<Empleado> findAll();

}