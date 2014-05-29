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
            Connection c = DBOps.ConnectDB();
            
            Statement stm = c.createStatement();
            
            String sql = "CREATE TABLE CARRERA ("
                    + "ID       INT         PRIMARY KEY NOT NULL"
                    + "NOMBRE   TEXT                    NOT NULL"
                    + "ESCUELA  INT                     NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE ESCUELA ("
                    + "ID       INT         PRIMARY KEY NOT NULL"
                    + "NOMBRE   TEXT                    NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE VOTO ("
                    + "VOTANTE      INT     PRIMARY KEY NOT NULL"
                    + "VOTACION     INT     PRIMARY KEY NOT NULL"
                    + "SELECCION    INT"//null para voto en blanco
                    + "PUESTO_VOT   INT                 NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE PUESTO("
                    + "ID       INT         PRIMARY KEY NOT NULL"
                    + "NOMBRE   TEXT                    NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE VOTACION("
                    + "ID           INT     PRIMARY KEY NOT NULL"
                    + "NOMBRE       TEXT"
                    + "FECHA_INICIO " //TODO: definir un estandar para almacenar la fecha
                    + "FECHA_FIN    "
                    + "); ";
            
            sql += "CREATE TABLE ESTUDIANTE-CARRERA("
                    + "ESTUDIANTE   INT     PRIMARY KEY NOT NULL"
                    + "CARRERA      INT     PRIMARY KEY NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE ESTUDIANTE("
                    + "ID       INT         PRIMARY KEY NOT NULL"
                    + "CODIGO   CHAR(15)                NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE ADMIN("
                    + "ID   INT             PRIMARY KEY NOT NULL"
                    + "TIPO BOOL                        NOT NULL"
                    + "); ";
            
            sql += "CREATE TABLE USUARIO("
                    + "ID       INT         PRIMARY KEY NOT NULL"
                    + "NOMBRE   TEXT                    NOT NULL"
                    + "CORREO   TEXT                    NOT NULL"
                    + "PASSWORD TEXT                    NOT NULL"
                    + ");";
            
            stm.executeQuery(sql);
            System.out.println("Tablas con esquema creadas exitosamente");
            
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
