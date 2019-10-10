package ar.com.ada.api.billeteravirtual.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 * Billetera
 */
@Entity
@Table(name = "billetera")

public class Billetera {
    @Id
    @Column(name = "idbilletera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBilletera;


    @OneToOne 
    @JoinColumn (name= "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    @OneToMany (mappedBy = "billetera", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
     private List<Cuenta> cuentas = new ArrayList<Cuenta>();

	public void setPersona(Persona p) {
        this.persona = p;
        this.persona.setBilletera(this);
	}

    public void agregarCuenta(Cuenta c) {
        c.setBilletera(this);
        this.cuentas.add(c);
    }

    public int getIdBilletera() {
        return idBilletera;
    }

    public void setIdBilletera(int idBilletera) {
        this.idBilletera = idBilletera;
    }

    public void agregarMovimiento(Movimiento m) {
      
        this.cuentas.get(0).agregarMovimiento(m);
         
    }

        public void movimientoInicial(Movimiento m, double importe, Cuenta c, Usuario u) {
        m.setImporte(importe);
        m.setFechaMovimiento(new Date());   
        m.setConceptoOperacion("Pagos"); 
        m.setEstado(1);
        m.setTipoOperacion("Deposito");
        m.setDetalle("Pago");
        m.setDeUsuario(u.getUsuarioId());
        m.setaUsuario(u.getUsuarioId());
        m.setCuentaDestino(this.cuentas.get(0).getIdcuenta());
        m.setCuentaOrigen(this.cuentas.get(0).getIdcuenta());
               
    }

    public Persona getPersona() {
        return persona;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

	public void movimientoTransferencia(Double importe, Usuario usuarioOrigen, Usuario usuarioDestino) {
        Movimiento m = new Movimiento();
        m.setTipoOperacion("tipoOperacion");
        m.setConceptoOperacion("");
        m.setDetalle("Transferencia");
        m.setEstado(1);
        m.setImporte(importe);
        m.setFechaMovimiento(new Date());
        m.setDeUsuario(usuarioOrigen.getUsuarioId());
        m.setaUsuario(usuarioDestino.getUsuarioId());
        m.setCuentaOrigen(usuarioDestino.getPersona().getPesonaId());
        m.setCuentaDestino(usuarioDestino.getPersona().getPesonaId());
        this.cuentas.get(0).agregarMovimiento(m);


    }

    
}