
package com.personas;

import com.universidad.Carrera;
import com.universidad.Escuela;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class AdmEafit extends Admin{

    public AdmEafit(int tipo, String correo, String pass, String nombre) {
        super(tipo, correo, pass, nombre);
    }
    
    

    @Override
    public void IngresarAdmin(int id) throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "Insert into ADMIN (TIPO) values" + "(" + id + ", " + 1 + ");";
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
        
    }
    
    public void IngresarCarrera(String nombre, Escuela escuela) 
            throws SQLException, Exception{
        
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT * FROM CARRERA "
                + "WHERE NOMBRE = '" +nombre+ "'";
        ResultSet res = stm.executeQuery(sql);
        if(res.next()){//si hay alguna carrera con ese nombre
            
            stm.close();
            throw new Exception("Ya existe una carrera "
                    + "con el nombre " + nombre);
        }
        
        
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
        
    }
    
    public void IngresarEstudiante(Estudiante estudiante) throws SQLException, Exception{
        String nombre = estudiante.getNombre(); 
        String correo = estudiante.getCorreo();
        String password = estudiante.getPassword();
        String codigo = estudiante.getCodigo();
        Carrera carrera = estudiante.getCarreras().get(0);
        
        
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        //si hay algun estudiante con ese codigo
        String sql = "SELECT * FROM ESTUDIANTE "
                + "WHERE CODIGO = '" +codigo+ "'";
        ResultSet res = stm.executeQuery(sql);
        if(res.next()){
            
            stm.close();
            throw new Exception("Ya existe un estudiante "
                    + "con el codigo " + codigo);
        }
        
        stm.close();
        
        c = DBOps.getInstance().ConnectDB();
        stm = c.createStatement();
        
        //si hay algun Usuario con ese correo
        sql = "SELECT * FROM USUARIO "
                + "WHERE CORREO = '" +correo+ "'";
        res = stm.executeQuery(sql);
        if(res.next()){
            
            stm.close();
            throw new Exception("Ya existe un usuario "
                    + "con el correo " + correo);
        }
        
        stm.close();
        
        
        
        c = DBOps.getInstance().ConnectDB();
        stm = c.createStatement();
        
        //como ya existen usuarios, se deja que sqlite genere el id
        sql = "INSERT INTO USUARIO (NOMBRE, CORREO, PASSWORD) "
                + "VALUES ('"+nombre+"','"+correo+"','"+password+"')";
        stm.execute(sql);
        
//        last_insert_rowid() to get last autogenerated id
        sql = "INSERT INTO ESTUDIANTE (ID, CODIGO) "
                + "VALUES (last_insert_rowid(), '" +codigo+ "')";
        stm.execute(sql);
        
        sql = "INSERT INTO ESTUDIANTECARRERA (ESTUDIANTE, CARRERA)"
                + "VALUES (last_insert_rowid(), "+carrera.getId()+")";
        stm.execute(sql);
        
        stm.close();
        
    }
    
    public void Retirar(Estudiante e) throws SQLException{
        String identificacion = e.getCodigo();
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "DELETE FROM ESTUDIANTE where CODIGO= '" +
                identificacion + "';";
        stm.executeUpdate(sql);
        stm.close();
        
        
    }
    
    public void RetirarEscuela(Escuela e) throws SQLException{
        //Eliminar la escuela de la BDs
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();

        String sql = "DELETE from ESCUELA where NOMBRE='" +e.getNombre()+ "';";

        stm.executeUpdate(sql);

        stm.close();
        
    }
}
