/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.controladores;

import com.jcas.beans.MapaBean;
import com.jcas.beans.PuntoBean;
import com.jcas.datos.MapaDatos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
public class MapaControlador implements Serializable {

    private MapModel simpleModel;
    private String periodo;
    private String ruta;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public MapModel generarRuta() {
        FacesMessage msg;
        simpleModel = new DefaultMapModel();

        if (periodo != null) {
            if (ruta != null) {
                /*//Shared coordinates
                 LatLng coord1 = new LatLng(36.879466, 30.667648);
                 LatLng coord2 = new LatLng(36.883707, 30.689216);
                 LatLng coord3 = new LatLng(36.879703, 30.706707);
                 LatLng coord4 = new LatLng(36.885233, 30.702323);

                 //Basic marker
                 getSimpleModel().addOverlay(new Marker(coord1, "Konyaalti"));
                 getSimpleModel().addOverlay(new Marker(coord2, "Ataturk Parki"));
                 getSimpleModel().addOverlay(new Marker(coord3, "Karaalioglu Parki"));
                 getSimpleModel().addOverlay(new Marker(coord4, "Kaleici"));
                
                 return getSimpleModel();
                 */

                MapaBean mapaActual = new MapaBean();
                MapaDatos mapadatos = new MapaDatos();
                mapaActual = mapadatos.getPuntosGeograficos(periodo, ruta);

                if (mapaActual.getRespuesta().getIdRespuesta() == 0) {
                    List<PuntoBean> listPuntos=mapaActual.getListPuntos();
                    for(PuntoBean punto: listPuntos){
                        int lat=Integer.parseInt(punto.getLatitud());
                        int lng=Integer.parseInt(punto.getLongitud());
                        LatLng coordenada = new LatLng(lat, lng);
                        String strTitulo=punto.getCuenta()+"-"+punto.getNomUsuario();
                        getSimpleModel().addOverlay(new Marker(coordenada, strTitulo));
                    }
                    return getSimpleModel();
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mapaActual.getRespuesta().getStrRespuesta());
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }

                
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Ruta Invalida");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Periodo Invalido");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return null;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
