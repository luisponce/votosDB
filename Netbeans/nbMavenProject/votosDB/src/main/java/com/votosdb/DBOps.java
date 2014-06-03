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
    private static DBOps INSTANCE;
    
    private final String nombreDB = "votos";
    
    private DBOps(){
    }
    public static DBOps getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DBOps();
        }
        return INSTANCE;
    }
    
    /**
     * Se crea una conexion con la base de datos que se tiene por defecto.
     * @return El objeto connection.
     */
    public Connection ConnectDB(){
        return ConnectDB(nombreDB);
    }
    
    /**
     * Metodo para establecer coneccion con una Base de datos 
     * en especifico con sqlite.
     * Si no existe la Base de datos, esta se crea con el nombre dado.
     * @param DB_name Nombre de la base de datos.
     * @return Un objeto connection.
     */
    public Connection ConnectDB(String DB_name){
        Connection c = null;
        try {
          Class.forName("org.sqlite.JDBC");
          c = DriverManager.getConnection("jdbc:sqlite:" 
                  + DB_name + ".db");


        } catch ( ClassNotFoundException | SQLException e ) {
          System.err.println(e);
          System.exit(0);
        }
        
        return c;
    }
    
}
