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
                    + "ID INT PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL,"
                    + "ESCUELA INT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESCUELA ("
                    + "ID INT PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE VOTO ("
                    + "VOTANTE INT NOT NULL,"
                    + "VOTACION INT NOT NULL,"
                    + "SELECCION INT,"//null para voto en blanco
                    + "PUESTO_VOT INT NOT NULL,"
                    + "PRIMARY KEY (VOTANTE, VOTACION)"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE PUESTO("
                    + "ID INT PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE VOTACION("
                    + "ID INT PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT,"
                    + "FECHA_INICIO TEXT," //TODO: definir un estandar para almacenar la fecha
                    + "FECHA_FIN TEXT"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESTUDIANTECARRERA("
                    + "ESTUDIANTE INT NOT NULL,"
                    + "CARRERA INT NOT NULL,"
                    + "PRIMARY KEY (ESTUDIANTE, CARRERA)"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ESTUDIANTE("
                    + "ID INT PRIMARY KEY NOT NULL,"
                    + "CODIGO CHAR(15) NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE ADMIN("
                    + "ID   INT PRIMARY KEY NOT NULL,"
                    + "TIPO INT NOT NULL"//0 PARA VOTOS 1 PARA EAFIT
                    + ")";
            
            stm.execute(sql);
            
            sql = "CREATE TABLE USUARIO("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "NOMBRE TEXT NOT NULL,"
                    + "CORREO TEXT NOT NULL,"
                    + "PASSWORD TEXT NOT NULL"
                    + ")";
            
            stm.execute(sql);
            
            System.out.println("Tablas con esquema creadas exitosamente");
            
            String passwordDefault = "eafit123";
            
            //crear admin votos
            //  en usuario
//            int IDvotos = DBOps.getInstance().getNextID();
            String correoAdmVotos = "adminVotos@eafit.edu.co";
            sql = "INSERT INTO USUARIO (ID, NOMBRE, CORREO, PASSWORD) "
                    + "VALUES (0, 'default', 'adminVotos@eafit.edu.co', 'eafit123')";
            
            stm.executeUpdate(sql);
            
            //  en admin
            sql = "INSERT INTO ADMIN (ID, TIPO)"
                    + "VALUES (0, 0)";
            
            stm.executeUpdate(sql);
            
            System.out.println("Se creo adminVotos con correo: " +
                    correoAdmVotos+ " y password: " + passwordDefault);
            
            //crear admin eafit
            //  en usuario
            String correoAdmEafit = "adminEafit@eafit.edu.co";
            sql = "INSERT INTO USUARIO (ID, NOMBRE, CORREO, PASSWORD)"
                    + "VALUES (1, 'default', 'adminEafit@eafit.edu.co', 'eafit123'); ";
            
            stm.executeUpdate(sql);
            
            //  en admin
            sql = "INSERT INTO ADMIN (ID, TIPO)"
                    + "VALUES (1, 1)";
            
            System.out.println("Se creo adminEAFIT con correo: " +
                    correoAdmEafit+ " y password: " + passwordDefault);
            
            stm.executeUpdate(sql);
            
            stm.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
