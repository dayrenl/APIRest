package ar.com.ada.api.billeteravirtual.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.models.request.TransferRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;
import ar.com.ada.api.billeteravirtual.models.response.SaldoResponse;
import ar.com.ada.api.billeteravirtual.models.response.TransferResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;

    @PostMapping("/transferencia")
    public TransferResponse postTransfer(@RequestBody TransferRequest req) {
      
        TransferResponse t = new TransferResponse();
        billeteraService.crearTranferencia(req.importe, req.billeteraIdOrigen, req.emailDestino);
        
        t.isOk = true;
        t.message = "Transferencia exitosa";
        return t;
    }

    @GetMapping("/billeteras/{id}/saldos")
    public ArrayList<SaldoResponse> getBilleteraById(@PathVariable int id ) {
        Billetera b = billeteraService.buscarPorId(id);
        ArrayList<SaldoResponse> saldos = new ArrayList<>();
        for (Cuenta cta : b.getCuentas()) {
            SaldoResponse s = new SaldoResponse();
            s.idBilletera = id;
            s.moneda = cta.getMoneda();
            s.saldo = cta.getSaldo();
            saldos.add(s);
        }
        return saldos;
    }
}