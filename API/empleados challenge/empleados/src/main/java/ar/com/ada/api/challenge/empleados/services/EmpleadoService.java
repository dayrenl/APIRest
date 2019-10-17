package ar.com.ada.api.challenge.empleados.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.empleados.entities.Categoria;
import ar.com.ada.api.challenge.empleados.entities.Empleado;
import ar.com.ada.api.challenge.empleados.repo.EmpleadoRepository;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadorepo;

    @Autowired
    CategoriaService categoriaService;
    
    @Autowired
    EmpleadoService empleadoService;

	public void altaEmpleado(String nombre, int edad, double sueldo, int categoriaId) {
        
        Categoria c = categoriaService.buscarCategoriaId(categoriaId);
        Empleado e = new Empleado();
        e.setNombre(nombre);
        e.setEdad(edad);
        e.setSueldo(sueldo);
        e.setEstado("activo");
        e.setFechaAlta(new Date());
        e.setCategoria(c);
        
        empleadorepo.save(e);
        
    }
    
    public List<Empleado> getEmpleados() {

        return empleadorepo.findAll();
    }
    
    public Empleado buscarPorId(int id) {
        
        Optional<Empleado> e = empleadorepo.findById(id);

       if (e.isPresent())
           return e.get();
       return null;
   }

	public void modificaEmpleado(int empleadoId, String nombre, int edad, int categoriaId) {

        Empleado e = empleadoService.buscarPorId(empleadoId);
        e.setNombre(nombre);
        e.setEdad(edad);
        e.setFechaAlta(new Date());
        empleadorepo.save(e);

	}

	public void modificaSueldo(int empleadoId, double sueldo) {
        Empleado e = empleadoService.buscarPorId(empleadoId);
        e.setSueldo(sueldo);
        empleadorepo.save(e);
	}

	public void eliminaEmpleado(int empleadoId) {
        Empleado e = empleadoService.buscarPorId(empleadoId);
        e.setEstado("baja");
        e.setFechaBaja(new Date());
        empleadorepo.save(e);
	}


}