/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.datos;

import com.jcas.beans.RutaBean;
import com.jcas.utilerias.UConexion;
import com.jcas.utilerias.URespuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MBrandle
 */
public class RutaDatos {
    
    public RutaBean getRutas(){
        RutaBean rutabean=new RutaBean();
        URespuesta respuesta = new URespuesta();
        List<String> listaRutas=new ArrayList<>();
        try{
            Connection conn = UConexion.getConnection();
            String consultaSQL="select DISTINCT rutl_us from usuarios order by rutl_us";
            PreparedStatement pstmtRutas=conn.prepareStatement(consultaSQL);
            ResultSet rsRutas=pstmtRutas.executeQuery();
            while(rsRutas.next()){
                String strRuta=rsRutas.getString("rutl_us");
                listaRutas.add(strRuta);
            }
            rsRutas.close();
            pstmtRutas.close();
            conn.close();
            
            respuesta=new URespuesta(0, "Ok");
            rutabean.setListRutas(listaRutas);
            rutabean.setRespuesta(respuesta);
            return rutabean;
        }catch(Exception ex){
            respuesta=new URespuesta(1, ex.getMessage());
            rutabean.setRespuesta(respuesta);
            return rutabean;
        }
    }
}
