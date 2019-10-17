package ar.com.ada.api.challenge.empleados.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.challenge.empleados.entities.Categoria;

/**
 * CategoriaRepository
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Categoria save(Categoria c);


    
}