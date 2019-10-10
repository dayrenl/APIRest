package ar.com.ada.api.billeteravirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

    @Autowired
    BilleteraRepository billeteraRepo;
    @Autowired
    UsuarioService usuarioService;

    public Billetera buscarPorId(Integer id) {
       
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent())
            return b.get();
        return null;
    }

    public void crearTranferencia(Double importe, Integer billeteraIdOrigen, String emailDestino)
    {
        Billetera b = billeteraRepo.findById(billeteraIdOrigen).get();
        Usuario u = usuarioService.buscarPorEmail(emailDestino);
        u.getPersona().getBilletera();
        b.movimientoTransferencia(importe, b.getPersona().getUsuario(), u);

        billeteraRepo.save(b);
        billeteraRepo.save(u.getPersona().getBilletera());
    }
}