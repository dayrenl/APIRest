package ar.com.ada.api.billeteravirtual.models.request;

/**
 * TransferRequest
 */
public class TransferRequest {

    public Double importe;
    public Integer billeteraOrigen;
    public String emailDestino;
    public String conceptoOperacion;
    public String tipoOperacion;
    public int estado;
    public String moneda;
}