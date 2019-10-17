package ar.com.ada.api.challenge.empleados.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.empleados.entities.Categoria;
import ar.com.ada.api.challenge.empleados.models.request.CategoriaRequest;
import ar.com.ada.api.challenge.empleados.models.response.CategoriaResponse;
import ar.com.ada.api.challenge.empleados.services.CategoriaService;

/**
 * CategoriaController
 */
@RestController
public class CategoriaController {

    @Autowired 
    CategoriaService categoriaService;
    
    @PostMapping("/categorias")
    public CategoriaResponse postCategoria(@RequestBody CategoriaRequest req) throws Exception {

      CategoriaResponse r = new CategoriaResponse();

       
        categoriaService.altaCategoria(req.nombre, req.sueldoBase);

        r.isOk = true;
        r.message = "Te registraste con exito";

        return r;
    }   

    @GetMapping("/categorias")
    public List<Categoria> getCategorias()
    {
        List<Categoria> categorias = categoriaService.getCategorias();
        
        return categorias;
    }

    @GetMapping("/categorias/{id}")
    public Categoria getCategoriaById(@PathVariable int id) {
      Categoria c = categoriaService.buscarCategoriaId(id);
      return c;
    }
}