package isw.grupo1.controller;

import android.net.Uri;
import android.os.Build;
import android.widget.ExpandableListView;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import isw.grupo1.model.PedidoLoQueSea;

public class ControladorPedidoLoQueSea implements Serializable {

    private static final int CALLE_MAX = 100;
    private final Map<Integer, String> errores;
    private PedidoLoQueSea pedidoLoQueSea;

    public ControladorPedidoLoQueSea(){
        errores = new Hashtable<>();
        pedidoLoQueSea = new PedidoLoQueSea();
        //Limpiar errores cuando se pasa a una nueva activity
    }

    public boolean validarNumeroCalle(String numero, int idVista){
        if(numero != null && numero.trim().length() > 0 && numero.trim().length() < CALLE_MAX) {
            try{
                Integer.parseInt(numero.trim());
                return true;
            }catch(Exception e){
                errores.put(idVista, "Campo Obligatorio. Numérico");
                return false;
            }
        } else{
            errores.put(idVista, "Campo Obligatorio");
            return false;
        }
    }

    public boolean validarReferenciaDomicilio(String referencia, int idVista){
        if(referencia == null || referencia.trim().isEmpty()) return true;
        if( referencia.trim().length() < 400) {
            return true;
        } else{
            errores.put(idVista, "Máximo 400 caracteres");
            return false;
        }

    }

    public boolean validarCalle(String calle, int idVista){

        if(calle != null && calle.trim().length() > 0 && calle.trim().length() < CALLE_MAX) {
            return true;
        } else{
            errores.put(idVista, "Campo Obligatorio");
            return false;
        }
    }

    public boolean sinErrores(){
        return errores.isEmpty();
    }

    public Map<Integer, String> registrarDomicilioRetiro(String localidad, String calle,
                                                  String numero, String referencia,
                                                  boolean loAntesPosible, LocalDateTime fechaHoraEnvio,
                                                  int idVistaLocalidad, int idVistaCalle,
                                                  int idVistaNumero, int idVistaReferencia,
                                                  int idVistaFechaEnvio){
        errores.clear();
        validarCalle(calle, idVistaCalle);
        validarNumeroCalle(numero, idVistaNumero);
        validarReferenciaDomicilio(referencia, idVistaReferencia);

        if(!loAntesPosible){
            validarFechaEnvio(fechaHoraEnvio, idVistaFechaEnvio);
        }
        if(!errores.isEmpty()){
            return errores;
        }
        pedidoLoQueSea.setDomicilioRetiro(localidad, calle, Integer.parseInt(numero), referencia);
        pedidoLoQueSea.setEntregaAntesPosible(loAntesPosible);
        pedidoLoQueSea.setMomentoEntrega(fechaHoraEnvio);
        return null;

    }

    public boolean validarFechaEnvio(LocalDateTime fechaEnvio, int idVistaFechaEnvio) {

        if(fechaEnvio == null){
            errores.put(idVistaFechaEnvio, "Debe seleccionar Una fecha");
            return false;
        }
        LocalDateTime fechaActual = LocalDateTime.now();
        if(fechaEnvio.isBefore(fechaActual)){
            errores.put(idVistaFechaEnvio, "Fecha anterior a la actual");
            return false;
        }
        LocalDateTime fechaMaxima = fechaActual.plusDays(7);
        if(fechaEnvio.isAfter(fechaMaxima)){
            errores.put(idVistaFechaEnvio, "No puede superar una semana");
            return false;
        }

        return true;

    }

    public String getError(int idVista){
        return errores.getOrDefault(idVista, null);
    }

    public boolean validarDescripcionPedido(String descripcion, int idvista){

        if(descripcion == null || descripcion.trim().isEmpty()){
            errores.put(idvista,"Campo Obligatorio");
            return false;
        }
        if(descripcion.trim().length() > 400){
            errores.put(idvista, "Máximo 400 caracteres");
            return false;
        }
        return true;

    }

    public Map<Integer, String> registrarDescripcionPedido(String descripcionPedido, Uri uriImagen, int idVista) {

        errores.clear();
        if (!validarDescripcionPedido(descripcionPedido, idVista)) {
            return errores;
        }
        pedidoLoQueSea.setDescripcionPedido(descripcionPedido, uriImagen);
        return null;
    }
}
