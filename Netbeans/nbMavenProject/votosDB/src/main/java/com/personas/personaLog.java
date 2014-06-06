/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.personas;

import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jessecogollo
 */
public class personaLog {
    
    public String[] ConsultarUsuario(String Usuario, String Clave) throws SQLException{
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String[] ret = new String[2];
        ret[0] = "x"; 
        ret[1] = "Usuario no valido.";
        //Consultar en la tabla de adminstradores primero
        String sql = "SELECT * FROM USUARIO WHERE CORREO='"+Usuario+"' AND PASSWORD='"+Clave+"'";
        ResultSet res = stm.executeQuery(sql);
        if(res.next()){
            String id = res.getString(1);
            String sqladm = "SELECT * FROM ADMIN WHERE ID = '"+id+"'";
            ResultSet resadmin = stm.executeQuery(sqladm);
            if(resadmin.next()){
                String idadmin = res.getString(1);
                String tipoadmin = res.getString(2);
                ret[0] = idadmin; 
                ret[1] = tipoadmin;
                //return ret;
                //retornar el tipo de administrador para redireccionar a la pantalla a decuada.
            }
            String sqlest = "SELECT * FROM ESTUDIANTE WHERE ID = '"+id+"'";
            ResultSet resest = stm.executeQuery(sqlest);
            if(resest.next()){
                String idestudiante = res.getString(1);
                String codigoestudiante = res.getString(2);
                ret[0] = idestudiante; 
                ret[1] = codigoestudiante;
                //return ret;
                //retornar el codigo del estudiante. para redireccionar a la pantalla sdel estudiante.
            }
            //return ret;
            //retornar un codigo qu avise que hay un error de validación.
        }
        
        /*if(res.getInt(1) == 0){//si es el primer elemento, dele como ID 0
            sql = "INSERT INTO ESCUELA (ID, NOMBRE) "
                    + "VALUES (0, '"+Nombre+"')";
        } else {//si ya hay elementos, siga la numeracion de ID
            sql = "INSERT INTO ESCUELA (NOMBRE) VALUES ('"+Nombre+"')";
        }
        stm.execute(sql);*/
        
        res.close();
        stm.close();
        c.close();
        return ret;
        //return ret;
    }
    
}
