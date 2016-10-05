/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.controladores;

import com.jcas.beans.RutaBean;
import com.jcas.datos.RutaDatos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@RequestScoped
public class RutaControlador {

    private String Ruta;
    private List<String> listRutas;

    public RutaControlador() {
        listRutas = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        listRutas.clear();
        try{
            RutaDatos rutadatos=new RutaDatos();
            RutaBean rutabean=rutadatos.getRutas();
            if(rutabean.getRespuesta().getIdRespuesta()==0){
                listRutas=rutabean.getListRutas();
            }else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", rutabean.getRespuesta().getStrRespuesta()));
            }
        }catch(Exception ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));

        }
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    public List<String> getListRutas() {
        return listRutas;
    }

    public void setListRutas(List<String> listRutas) {
        this.listRutas = listRutas;
    }

}
