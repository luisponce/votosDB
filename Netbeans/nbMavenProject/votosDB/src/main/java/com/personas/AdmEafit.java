
package com.personas;

import com.universidad.Escuela;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class AdmEafit extends Admin{

    @Override
    public void IngresarAdmin() throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "Insert into ADMIN (TIPO) values" + "(" + 1 + ");";
        stm = c.prepareStatement(sql);
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
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
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
        
        res.close();
        stm.close();
        c.close();
    }
    
    public void IngresarCarrera(String nombre, Escuela escuela) 
            throws SQLException, Exception{
        
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT * FROM CARRERA "
                + "WHERE NOMBRE = '" +nombre+ "'";
        ResultSet res = stm.executeQuery(sql);
        if(res.next()){//si hay alguna carrera con ese nombre
            c.close();
            stm.close();
            throw new Exception("Ya existe una carrera "
                    + "con el nombre " + nombre);
        }
        
        c.close();
        stm.close();
        
        //obtener el id de la escuela a la que pertenece
        int id = escuela.getDBid();
        
        c = DBOps.getInstance().ConnectDB();
        stm = c.createStatement();
        
        //obtener cuantas carreras hay, para saber si es la primera
        sql = "SELECT COUNT(ID) FROM CARRERA";
        res = stm.executeQuery(sql);
        if(res.getInt(1) == 0){//si es el primer elemento, dele como ID 0
            sql = "INSERT INTO CARRERA (ID, NOMBRE, ESCUELA) "
                    + "VALUES (0, '"+nombre+"', " +id+ ")";
        } else {//si ya hay elementos, siga la numeracion de ID
            sql = "INSERT INTO CARRERA (NOMBRE, ESCUELA) "
                    + "VALUES ('"+nombre+"', " +id+ ")";
        }
        stm.execute(sql);
        
        stm.close();
        c.close();
    }
    
    /**
     * Retirar las carreras, escuelas y estudiantes a la universidad
     */
    public void Retirar(){
        
    }
    
    public void Retirar(Estudiante e) throws SQLException{
        int identificacion = e.getCodigo();
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "DELETE FROM ESTUDIANTE where CODIGO=" +
                identificacion + ";";
        stm.executeUpdate(sql);
        stm.close();
        c.close();
        
    }
    
    public void RetirarEscuela(Escuela e) throws SQLException{
        //Eliminar la escuela de la BDs
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();

        String sql = "DELETE from ESCUELA where NOMBRE='" +e.getNombre()+ "';";

        stm.executeUpdate(sql);

        stm.close();
        c.close();
    }
}
