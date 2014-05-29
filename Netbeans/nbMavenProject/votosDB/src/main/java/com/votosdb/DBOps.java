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
        return ConnectDB(nombreDB);
    }
    
    public static Connection ConnectDB(String DB_name){
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" 
                  + DB_name + ".db");


        } catch ( ClassNotFoundException | SQLException e ) {
          System.err.println(e);
          System.exit(0);
        }
        System.out.println("Coneccion con Base de datos exitosa");
        
        return c;
    }
}
