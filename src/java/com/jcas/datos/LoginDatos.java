/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.datos;

import com.jcas.beans.LoginBean;
import com.jcas.utilerias.UConexion;
import com.jcas.utilerias.URespuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MBrandle
 */
public class LoginDatos {

    public URespuesta iniciarSesion(int idUsuario, String strPassword) {
        URespuesta respuesta=new URespuesta();
        try {
            Connection conn = UConexion.getConnection();
            String consultaSQL = "select * from acceso where clav_ac=? and pass_ac=? ";
            PreparedStatement pstmtIniciarSesion = conn.prepareStatement(consultaSQL);
            pstmtIniciarSesion.setInt(1, idUsuario);
            pstmtIniciarSesion.setString(2, strPassword);
            ResultSet rsIniciarSesion = pstmtIniciarSesion.executeQuery();
            if (rsIniciarSesion.next()) {
                respuesta=new URespuesta(0, "Ok");
            } else {
                respuesta=new URespuesta(-1, "Datos Incorrectos");
            }
            
            rsIniciarSesion.close();
            pstmtIniciarSesion.close();
            conn.close();
        } catch (Exception ex) {
            respuesta=new URespuesta(1, "Error de Inicio de Sesion: "+ex.getMessage());
        }
        return respuesta;
    }
}
