/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.utilerias;

    

public class URespuesta {
    private int idRespuesta;
    private String strRespuesta;
    
    public URespuesta(){
        
    }
    
    public URespuesta(int idRespuesta, String strRespuesta){
        this.idRespuesta=idRespuesta;
        this.strRespuesta=strRespuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getStrRespuesta() {
        return strRespuesta;
    }

    public void setStrRespuesta(String strRespuesta) {
        this.strRespuesta = strRespuesta;
    }
}
