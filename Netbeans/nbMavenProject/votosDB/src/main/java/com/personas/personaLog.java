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
        String[] ret = new String[5];
        ret[0] = "x"; 
        ret[1] = "x";
        //Consultar en la tabla de adminstradores primero
        String sql = "SELECT * FROM USUARIO WHERE CORREO='"+Usuario+"' AND PASSWORD='"+Clave+"'";
        ResultSet res = stm.executeQuery(sql);//tipo, correo, pass, nombre
        if(res.next()){//1, ret[3], ret[4], ret[2]
            String id = res.getString(1);//id usuario
            String nombre = res.getString(2);//nombre usuario
            String correo = res.getString(3);//email usuario
            String pass = res.getString(4);//pass usuario
            
            ret[2] = nombre;
            ret[3] = correo;
            ret[4] = pass;
            
            String sqladm = "SELECT * FROM ADMIN WHERE ID = '"+id+"'";
            ResultSet resadmin = stm.executeQuery(sqladm);
            if(resadmin.next()){
                String idadmin = resadmin.getString(1);
                String tipoadmin = resadmin.getString(2);
                ret[0] = idadmin; 
                ret[1] = tipoadmin;
                
            }
            String sqlest = "SELECT * FROM ESTUDIANTE WHERE ID = '"+id+"'";
            ResultSet resest = stm.executeQuery(sqlest);
            if(resest.next()){
                String idestudiante = resest.getString(1);
                String codigoestudiante = resest.getString(2);
                ret[0] = idestudiante; 
                ret[1] = codigoestudiante;
            }
        }
        stm.close();
        return ret;
    }
}
