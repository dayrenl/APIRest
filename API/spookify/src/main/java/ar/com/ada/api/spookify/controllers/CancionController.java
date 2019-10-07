package ar.com.ada.api.spookify.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.spookify.entities.Cancion;

/**
 * CancionController
 */
@RestController
public class CancionController {

    @GetMapping (value = "/temas")
    public List<Cancion> GetTodas() {
        List<Cancion> lista = new  ArrayList<Cancion>();

        Cancion c = new Cancion();
        c.setTitulo("Zombie");
        c.setDuracion(4.0);

        lista.add(c);

        c = new Cancion();
        c.setTitulo("This is Halloween");
        c.setDuracion(3.5);

        lista.add(c);

        return lista;
    }

}