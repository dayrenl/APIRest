package ar.com.ada.api.billeteravirtual.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.services.CuentaService;

/**
 * CuentaController
 */
@RestController
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping("/cuentas")
    public List<Cuenta> getCuentas() {
        
        List<Cuenta> cuentas = cuentaService.getCuentas();
        return cuentas;
    }
    
    @GetMapping("/cuentas/{id}") 
    public Cuenta getCuentaById(@PathVariable int id)
    {
        Cuenta c = cuentaService.buscarPorId(id);
        return c;
    }
}