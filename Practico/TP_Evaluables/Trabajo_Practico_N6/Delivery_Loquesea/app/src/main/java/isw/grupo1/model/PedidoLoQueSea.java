package isw.grupo1.model;

import android.net.Uri;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoLoQueSea implements Serializable {

    private boolean entregaAntesPosible;
    private LocalDateTime momentoPedido;
    private LocalDateTime momentoEntrega; //Debería ser LocalDateTime, pero es para mostrar
    private Domicilio domicilioRetiro;
    private Domicilio domicilioEnvio;
    private String descripcionPedido;
    private String uriImagen;
    private float total;
    private float montoAbonar;
    private TarjetaCredito tarjetaCredito;

    public void setDomicilioRetiro(String localidad, String calle, int numero, String referencia) {
        domicilioRetiro = new Domicilio();
        domicilioRetiro.setCalle(calle);
        domicilioRetiro.setLocalidad(localidad);
        domicilioRetiro.setNumero(numero);
        domicilioRetiro.setReferencia(referencia);
    }

    public boolean isEntregaAntesPosible() {
        return entregaAntesPosible;
    }

    public LocalDateTime getMomentoPedido() {
        return momentoPedido;
    }
    public void setEntregaAntesPosible(boolean tipoEntrega){
        entregaAntesPosible = tipoEntrega;
    }

    public LocalDateTime getMomentoEntrega() {
        return momentoEntrega;
    }
    public void setMomentoEntrega(LocalDateTime momentoEntrega){
        this.momentoEntrega = momentoEntrega;
    }

    public Domicilio getDomicilioRetiro() {
        return domicilioRetiro;
    }

    public Domicilio getDomicilioEnvio() {
        return domicilioEnvio;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public String getUriImagen() {
        return uriImagen;
    }

    public float getTotal() {
        return total;
    }

    public float getMontoAbonar() {
        return montoAbonar;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setDescripcionPedido(String descripcionPedido, Uri uriImagen){
        this.descripcionPedido = descripcionPedido;
        this.uriImagen = uriImagen.toString();
    }
}
