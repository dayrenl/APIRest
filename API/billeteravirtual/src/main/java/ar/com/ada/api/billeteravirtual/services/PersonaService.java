package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;
import ar.com.ada.api.billeteravirtual.repo.PersonaRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;

/**
 * PersonaService
 */
public class PersonaService {

    
    @Autowired
    static PersonaRepository repo;

    public static void alta(Persona p) {
        repo.save(p);
    }

    public List<Persona> getPersonas() {

        return repo.findAll();
    }

    public Persona buscarPorNombre(String nombre) {

        return repo.findByNombre(nombre);
    }
 
    
    public Persona buscarPorDni(String dni) {

        return repo.findByDni(dni);
    }

    public Persona buscarPorId(int id) {

        Optional<Persona> p = repo.findById(id);
        
        if (p.isPresent())
            return p.get();
        return null;
    }

    public Persona save(Persona p) {
        return repo.save(p);
        
    }


}