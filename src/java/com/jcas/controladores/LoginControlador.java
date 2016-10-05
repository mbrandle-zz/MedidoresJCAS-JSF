/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.controladores;

import com.jcas.beans.LoginBean;
import com.jcas.datos.LoginDatos;
import com.jcas.utilerias.USesion;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@SessionScoped
public class LoginControlador {

    public LoginControlador() {
    }

    public void getSesion(LoginBean loginActual) {
        try {
            LoginDatos getSesion = new LoginDatos();
            loginActual.setRespuesta(getSesion.iniciarSesion(loginActual.getIdusuario(), loginActual.getStrPassword()));

            if (loginActual.getRespuesta().getIdRespuesta() == 0) {
                //return "frmPrincipal.xhtml";
                HttpSession session = USesion.getSession();
                session.setAttribute("username", loginActual.getIdusuario());
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("frmPrincipal.xhtml");
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", loginActual.getRespuesta().getStrRespuesta()));

                //return null;
            }
        } catch (Exception ex) {
            FacesMessage msjError = new FacesMessage("Error: " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msjError);

            //return null;
        }

    }
}
