package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.services.PersonaService;
import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    PersonaService personaService;


    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req) throws Exception {


        RegistrationResponse r = new RegistrationResponse();

       
        usuarioService.altaUsuario(p, req.password);

        

        personaService.save(p);

        r.isOk = true;
        r.message = "Te registraste con exito";

        return r;
        
    }


}