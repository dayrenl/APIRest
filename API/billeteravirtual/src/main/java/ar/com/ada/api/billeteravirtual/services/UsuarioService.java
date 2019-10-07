package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;

/**
 * UsuarioService
 */
public class UsuarioService {

    @Autowired
    UsuarioRepository usuariorepo;

    public void altaUsuario(String nombre, String dni, Integer edad, String email, String password) throws Exception {
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

                Billetera b = new Billetera();
                usuariorepo.save(u);
            }
            else { 
        }
        
        
        
    }
}