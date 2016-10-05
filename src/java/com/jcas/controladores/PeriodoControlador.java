/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.controladores;

import com.jcas.beans.PeriodoBean;
import com.jcas.datos.PeriodoDatos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@SessionScoped
public class PeriodoControlador {

    private String perido;
    private List<String> listPeriodos;

    public PeriodoControlador() throws Exception {
        listPeriodos = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        listPeriodos.clear();
        try {
            PeriodoDatos periododatos = new PeriodoDatos();
            PeriodoBean periodobean = periododatos.getPeriodos();

            if (periodobean.getRespuesta().getIdRespuesta() == 0) {
                setListPeriodos(periodobean.getListPriodos());
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", periodobean.getRespuesta().getStrRespuesta()));
            }

        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
        }
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }

    public List<String> getListPeriodos() {
        return listPeriodos;
    }

    public void setListPeriodos(List<String> listPeriodos) {
        this.listPeriodos = listPeriodos;
    }

}
