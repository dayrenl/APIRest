package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.repo.CuentaRepository;

/**
 * CuentaService
 */
@Service
public class CuentaService {

    @Autowired
    CuentaRepository cuentaRepo;

    public List<Cuenta> getCuentas() {
        return cuentaRepo.findAll();
    }

    public Cuenta buscarPorId(int id) {
        Optional<Cuenta> c = cuentaRepo.findById(id);

        if(c.isPresent())
            return c.get();
        return null;
    }
}