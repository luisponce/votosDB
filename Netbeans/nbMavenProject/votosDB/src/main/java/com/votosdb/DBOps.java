/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.votosdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("Coneccion con Base de datos exitosa");
        
        return c;
    }
    
    /**
     * Metodo para obtener el siguiente ID para los Usuarios
     * 
     * @return El siguiente ID para los usuarios. El maximo ID actual +1
     * @throws SQLException 
     */
    public int getNextID() throws SQLException{
        //establecer coneccion con DB
        Connection c = ConnectDB();
        Statement stm = c.createStatement();

        //obtener el maximo ID
        String sql = "SELECT MAX(ID)"
                   + "FROM USUARIO";

        //resultado del query
        ResultSet res = stm.executeQuery(sql);

        
        int curMaxID;
        if(res != null){//si hay usuarios
            curMaxID = res.getInt(1);//1 porque la primera columna es la 1
            curMaxID++;
            res.close();
        } else { //si no hay usuarios
            curMaxID = 0;
        }
        stm.close(); c.close();

        return curMaxID;
    }
}
