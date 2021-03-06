/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.votosdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisponcedeleon
 */
public class CreateDB {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection c = DBOps.getInstance().ConnectDB();
            
            Statement stm = c.createStatement();
            
            String sql = "CREATE TABLE CARRERA ("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL,"
                    + "ESCUELA INTEGER NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESCUELA ("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE VOTO ("
                    + "VOTANTE INTEGER NOT NULL,"
                    + "VOTACION INTEGER NOT NULL,"
                    + "SELECCION INTEGER,"//null para voto en blanco
                    + "PUESTO_VOT INTEGER NOT NULL,"
                    + "PRIMARY KEY (VOTANTE, VOTACION)"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE PUESTO("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE VOTACION("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT,"
                    + "FECHA_INICIO TEXT," //TODO: definir un estandar para almacenar la fecha
                    + "FECHA_FIN TEXT"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESTUDIANTECARRERA("
                    + "ESTUDIANTE INTEGER NOT NULL,"
                    + "CARRERA INTEGER NOT NULL,"
                    + "PRIMARY KEY (ESTUDIANTE, CARRERA)"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESTUDIANTE("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "CODIGO CHAR(15) NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ADMIN("
                    + "ID   INTEGER PRIMARY KEY NOT NULL,"
                    + "TIPO INTEGER NOT NULL"//0 PARA VOTOS 1 PARA EAFIT
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE USUARIO("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL,"
                    + "CORREO TEXT NOT NULL,"
                    + "PASSWORD TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE CANDIDATO("
                    + "CANDIDATO INTEGER NOT NULL, "
                    + "VOTACION INTEGER NOT NULL, "
                    + "PRIMARY KEY (CANDIDATO, VOTACION)"
                    + ")";
            
            stm.execute(sql);
            
            System.out.println("Tablas con esquema creadas exitosamente");
            
            String passwordDefault = "eafit123";
            
            //crear admin votos
            //  en usuario
//            int IDvotos = DBOps.getInstance().getNextID();
            sql = "INSERT INTO USUARIO (ID, NOMBRE, CORREO, PASSWORD) "
                    + "VALUES (0, 'default', 'adminvotos@eafit.edu.co', 'eafit123')";
            
            stm.executeUpdate(sql);
            
            //  en admin
            sql = "INSERT INTO ADMIN (ID, TIPO)"
                    + "VALUES (0, 0)";
            
            stm.executeUpdate(sql);
            
            //crear admin eafit
            //  en usuario
            sql = "INSERT INTO USUARIO (ID, NOMBRE, CORREO, PASSWORD)"
                    + "VALUES (1, 'default', 'admineafit@eafit.edu.co', 'eafit123'); ";
            
            stm.executeUpdate(sql);
            
            //  en admin
            sql = "INSERT INTO ADMIN (ID, TIPO)"
                    + "VALUES (1, 1)";
            
            stm.executeUpdate(sql);
            
            stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
