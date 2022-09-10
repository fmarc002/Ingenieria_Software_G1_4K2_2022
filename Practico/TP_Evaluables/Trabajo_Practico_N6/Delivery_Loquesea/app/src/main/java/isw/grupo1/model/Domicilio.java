package isw.grupo1.model;

import java.io.Serializable;

public class Domicilio implements Serializable {

    private String localidad;
    private String calle;
    private int numero;
    private String dpto;
    private Integer piso;
    private String referencia;

    public Domicilio(){

    }

    public Domicilio(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public Domicilio(String calle, int numero, String dpto, Integer piso, String referencia) {
        this.calle = calle;
        this.numero = numero;
        this.dpto = dpto;
        this.piso = piso;
        this.referencia = referencia;
    }

    public Domicilio(String localidad, String calle, int numero, String dpto, Integer piso, String referencia) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.dpto = dpto;
        this.piso = piso;
        this.referencia = referencia;
    }

    public Domicilio(String calle, int numero, String dpto, Integer piso) {
        this.calle = calle;
        this.numero = numero;
        this.dpto = dpto;
        this.piso = piso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
