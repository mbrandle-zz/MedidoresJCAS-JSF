/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.datos;

import com.jcas.beans.PeriodoBean;
import com.jcas.utilerias.UConexion;
import com.jcas.utilerias.URespuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PeriodoDatos {

    public PeriodoBean getPeriodos() {
        PeriodoBean periodobean = new PeriodoBean();
        URespuesta respuesta = new URespuesta();
        List<String> listaPeriodos=new ArrayList<>();
        try {
            Connection conn = UConexion.getConnection();
            String consultaSQL = "select DISTINCT peri_le from lecturas where peri_le>'201506' order by peri_le desc";
            PreparedStatement pstmtPeriodos = conn.prepareStatement(consultaSQL);
            ResultSet rsPeriodos=pstmtPeriodos.executeQuery();
            while(rsPeriodos.next()){
                String strPEriodo=rsPeriodos.getString("peri_le");
                listaPeriodos.add(strPEriodo);
            }
            rsPeriodos.close();
            pstmtPeriodos.close();
            conn.close();
            
            respuesta=new URespuesta(0, "Ok");
            periodobean.setListPriodos(listaPeriodos);
            periodobean.setRespuesta(respuesta);
            
            return periodobean;
        } catch (Exception ex) {
            respuesta=new URespuesta(1, ex.getMessage());
            periodobean.setRespuesta(respuesta);
            return periodobean;
        }
        
    }

}
