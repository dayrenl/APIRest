package ar.com.ada.api.challenge.empleados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.empleados.entities.Empleado;
import ar.com.ada.api.challenge.empleados.models.request.EmpleadoEliminacion;
import ar.com.ada.api.challenge.empleados.models.request.EmpleadoModificacionRequest;
import ar.com.ada.api.challenge.empleados.models.request.EmpleadoRequest;
import ar.com.ada.api.challenge.empleados.models.request.EmpleadoSaldoRequest;
import ar.com.ada.api.challenge.empleados.models.response.EmpleadoResponse;
import ar.com.ada.api.challenge.empleados.services.EmpleadoService;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/empleados")
    public EmpleadoResponse postEmpleado(@RequestBody EmpleadoRequest req) throws Exception {

      EmpleadoResponse r = new EmpleadoResponse();

       
        empleadoService.altaEmpleado(req.nombre, req.edad, req.sueldo, req.categoriaId);

        r.isOk = true;
        r.message = "Te registraste con exito";

        return r;
    } 

    @GetMapping("/empleados")
    public List<Empleado> getEmpleado()
    {
        List<Empleado> empleados = empleadoService.getEmpleados();
        return empleados;
    }    

    @GetMapping("/empleados/{id}")
    public Empleado GetEmpleadoById (@PathVariable int id) {
        Empleado e = empleadoService.buscarPorId(id);
        return e;
    }
      
    @PutMapping("/empleados")
    public EmpleadoResponse putEmpleado(@RequestBody EmpleadoModificacionRequest req) throws Exception {

      EmpleadoResponse r = new EmpleadoResponse();

      empleadoService.modificaEmpleado(req.empleadoId, req.nombre, req.edad, req.categoriaId);

      r.isOk = true;
      r.message = "Su modificacion se registro con exito";

      return r;
    
    }
    
    @PutMapping("/empleados/{id}/sueldo")
    public EmpleadoResponse putSueldo(@RequestBody EmpleadoSaldoRequest req) throws Exception {

      EmpleadoResponse r = new EmpleadoResponse();

      empleadoService.modificaSueldo(req.empleadoId, req.sueldo);

      r.isOk = true;
      r.message = "El saldo ha sido modificado con exito";
      return r;

    }

    @DeleteMapping("/empleados/{id}")
    public EmpleadoResponse deleteEmpleado(@RequestBody EmpleadoEliminacion req) throws Exception {

      EmpleadoResponse r = new EmpleadoResponse();

      empleadoService.eliminaEmpleado(req.empleadoId);
      r.isOk = true;
      r.message = "Eliminacion exitosa";
      return r;

    }
}