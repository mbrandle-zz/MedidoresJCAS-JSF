/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.beans;

import com.jcas.utilerias.URespuesta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private int idusuario;
    private String strPassword;
    private URespuesta respuesta;

    public LoginBean() {

    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public URespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(URespuesta respuesta) {
        this.respuesta = respuesta;
    }

}
