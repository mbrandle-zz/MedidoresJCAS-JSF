/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.beans;

import com.jcas.utilerias.URespuesta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@RequestScoped
public class RutaBean {

    private URespuesta respuesta;
    private List<String> listRutas=new ArrayList<>();
    
    public RutaBean() {
    }

    public URespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(URespuesta respuesta) {
        this.respuesta = respuesta;
    }

    public List<String> getListRutas() {
        return listRutas;
    }

    public void setListRutas(List<String> listRutas) {
        this.listRutas = listRutas;
    }
    
}
