/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.datos;

import com.jcas.beans.MapaBean;
import com.jcas.beans.PuntoBean;
import com.jcas.utilerias.UConexion;
import com.jcas.utilerias.URespuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MapaDatos {

    public MapaBean getPuntosGeograficos(String periodo, String ruta) {
        MapaBean mapabean = new MapaBean();
        List<PuntoBean> listPuntos = new ArrayList<>();
        try {
            listPuntos.clear();
            Connection conn = UConexion.getConnection();
            String consultaSQL = "select lecturas.usua_le AS usua_le,usuarios.rutl_us AS rutl_us,usuarios.secl_us AS secl_us,usuarios.nomb_us AS nomb_us, "
                    + " lecturas.peri_le AS peri_le, lecturas.longitud_le as Longitud, lecturas.latitud_le as Latitud "
                    + " from ((usuarios join lecturas)) "
                    + " where ((usuarios.clav_us = lecturas.usua_le)) "
                    + " and usuarios.rutl_us=? "
                    + " and lecturas.peri_le=? "
                    + " ORDER BY  usuarios.secl_us";
            PreparedStatement pstmtPuntos = conn.prepareStatement(consultaSQL);
            pstmtPuntos.setString(1, ruta);
            pstmtPuntos.setString(2, periodo);
            ResultSet rsPuntos = pstmtPuntos.executeQuery();
            while (rsPuntos.next()) {
                String cuenta = rsPuntos.getString("usua_le");
                String longitud = rsPuntos.getString("Longitud");
                String latitud = rsPuntos.getString("Latitud");
                String nomUsuario = rsPuntos.getString("nomb_us");
                PuntoBean puntoActual = new PuntoBean(cuenta, latitud, longitud, periodo, nomUsuario);
                listPuntos.add(puntoActual);
            }
            rsPuntos.close();
            pstmtPuntos.close();
            conn.close();
            URespuesta respuesta = new URespuesta(0, "Ok");
            mapabean = new MapaBean(respuesta, listPuntos);

            return mapabean;
        } catch (Exception ex) {
            URespuesta respuesta = new URespuesta(1, ex.getMessage());
            mapabean = new MapaBean(respuesta, null);
            return mapabean;
        }
    }

}
