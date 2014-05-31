
package com.personas;

import com.votosdb.DBOps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class AdmEafit extends Admin{

    @Override
    public void IngresarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RetirarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Ingresar las carreras, escuelas y estudiantes a la Universidad
     */
    public void Ingresar(){
        
    }
    
    /**
     * Creea e ingresa una escuela a la BDs.
     * @param Nombre Nombre de la escuela a ingresar
     * @throws java.sql.SQLException
     */
    public void IngresarEscuela(String Nombre) throws SQLException{
        Statement stm = DBOps.getInstance().ConnectDB().createStatement();
        
        //obtener cuantas escuelas hay, para saber si es la primera
        String sql = "SELECT COUNT(ID) FROM ESCUELA";
        ResultSet res = stm.executeQuery(sql);
        if(res.getInt(1) == 0){//si es el primer elemento, dele como ID 0
            sql = "INSERT INTO ESCUELA (ID, NOMBRE) "
                    + "VALUES (0, '"+Nombre+"')";
        } else {//si ya hay elementos, siga la numeracion de ID
            sql = "INSERT INTO ESCUELA (NOMBRE) VALUES ('"+Nombre+"')";
        }
        stm.execute(sql);
    }
    
    /**
     * Retirar las carreras, escuelas y estudiantes a la universidad
     */
    public void Retirar(){
        
    }
}
