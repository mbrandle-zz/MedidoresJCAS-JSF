/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcas.utilerias;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author MBrandle
 */
public class UConexion {
    private static Connection con = null;

    public static Connection getConnection() {
        InitialContext ctx;
        DataSource ds;

        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/ComercialNCG");
            con=ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return con;
    }
}
