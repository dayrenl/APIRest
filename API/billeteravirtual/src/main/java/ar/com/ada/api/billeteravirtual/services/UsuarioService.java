package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    PersonaService personaService;
    @Autowired
    BilleteraService billeteraService;
    @Autowired
    CuentaService cuentaService;

    public int altaUsuario(String nombre, String dni, Integer edad, String email, String password, String moneda) throws Exception {
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setUsername(email);
        String passwordEncriptada;
        String passwordEnTextoClaroDesencriptado;
        String passwordEnTextoClaro;
        passwordEnTextoClaro = password;
        passwordEncriptada = Crypto.encrypt(passwordEnTextoClaro, u.getUsername());
        passwordEnTextoClaroDesencriptado = Crypto.decrypt(passwordEncriptada, u.getUsername());

        if (passwordEnTextoClaro.equals(passwordEnTextoClaroDesencriptado)) {
            u.setPassword(passwordEncriptada);
            Persona p = new Persona();
            p.setNombre(nombre);
            p.setDni(dni);
            p.setEdad(edad);
            p.setEmail(email);
            p.setUsuario(u);
            
            personaService.save(p);

            Billetera b = new Billetera();
            b.setPersona(p);
            billeteraService.save(b);

            Cuenta c = new Cuenta();
            c.setBilletera(b);
            c.setMoneda(moneda);
            cuentaService.save(c);

            
            
            
            usuarioRepo.save(u);


        } 

        return u.getUsuarioId();
    }

    public List<Usuario> getUsuarios() {

        return usuarioRepo.findAll();
    }

	public Usuario buscarPorId(int id) {
        
         Optional<Usuario> u = usuarioRepo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
	}

    public Usuario save(Usuario u) {
        return usuarioRepo.save(u);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepo.findByEmail(email);
    }
}