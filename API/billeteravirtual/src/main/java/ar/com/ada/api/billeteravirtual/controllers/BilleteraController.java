package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;


    @GetMapping("/billeteras")
    public List<Movimiento> GetMovimientos()
    {
        List<Movimiento> movimientos = billeteraService.getMovimientos();
        
        return movimientos;
    }
}