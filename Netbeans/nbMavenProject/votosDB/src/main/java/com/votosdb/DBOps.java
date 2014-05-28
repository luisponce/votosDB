/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.votosdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisponcedeleon
 */
public class DBOps {
    private static final String nombreDB = "votos";
    
    public static Connection ConnectDB(){
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" 
                  + nombreDB + ".db");


        } catch ( ClassNotFoundException | SQLException e ) {
          System.err.println(e);
          System.exit(0);
        }
        System.out.println("Connected to database votos successfully");
        
        return c;
    }
}
