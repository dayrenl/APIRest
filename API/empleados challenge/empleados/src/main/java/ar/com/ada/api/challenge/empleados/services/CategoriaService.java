package ar.com.ada.api.challenge.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.empleados.entities.Categoria;
import ar.com.ada.api.challenge.empleados.repo.CategoriaRepository;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriarepo;

    public void altaCategoria(String nombre, double sueldoBase) {

        Categoria c = new Categoria();
        c.setNombre(nombre);
        c.setSueldoBase(sueldoBase);
        categoriarepo.save(c);
        
    }
    
    public Categoria save(Categoria c) {
        return categoriarepo.save(c);
        
    }

    public Categoria buscarCategoriaId(int id) {
        Optional<Categoria> c = categoriarepo.findById(id);

        if (c.isPresent())
            return c.get();
        return null;
    }

	public List<Categoria> getCategorias() {
		return categoriarepo.findAll();
    }
    
}