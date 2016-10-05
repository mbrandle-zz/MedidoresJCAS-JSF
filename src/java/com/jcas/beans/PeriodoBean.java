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
public class PeriodoBean {

    private URespuesta respuesta;
    private List<String> listPriodos = new ArrayList<>();
    public PeriodoBean() {
    }

    public URespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(URespuesta respuesta) {
        this.respuesta = respuesta;
    }

    public List<String> getListPriodos() {
        return listPriodos;
    }

    public void setListPriodos(List<String> listPriodos) {
        this.listPriodos = listPriodos;
    }
    
}
