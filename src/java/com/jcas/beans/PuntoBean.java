/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@RequestScoped
public class PuntoBean {

    private String cuenta;
    private String latitud;
    private String longitud;
    private String periodo;
    private String nomUsuario;
    
    public PuntoBean() {
    }
    
    public PuntoBean(String cuenta, String latitud, String longitud, String periodo, String nomUsuario){
        this.cuenta=cuenta;
        this.latitud=latitud;
        this.longitud=longitud;
        this.periodo=periodo;
        this.nomUsuario=nomUsuario;
                
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
    
}
