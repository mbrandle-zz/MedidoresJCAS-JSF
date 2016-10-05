/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.beans;

import com.jcas.utilerias.URespuesta;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@RequestScoped
public class MapaBean {

    private URespuesta respuesta = new URespuesta();
    private List<PuntoBean> listPuntos;
    
    
    public MapaBean() {
    }
    
    public MapaBean(URespuesta respuesta, List<PuntoBean> listPuntos) {
        this.respuesta=respuesta;
        this.listPuntos=listPuntos;
    }

    public URespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(URespuesta respuesta) {
        this.respuesta = respuesta;
    }

    public List<PuntoBean> getListPuntos() {
        return listPuntos;
    }

    public void setListPuntos(List<PuntoBean> listPuntos) {
        this.listPuntos = listPuntos;
    }
    
}
