package com.universidad;


import com.personas.Estudiante;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




/**
 * clase para representar una carrera de una escuela de la universidad eafit.
 */
public class Carrera {
	private ArrayList<Estudiante> estudiantes;
	private String nombre;

    public Carrera(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public void IngresarEstudiante(Estudiante e){
        estudiantes.add(e);
    }
    
    public void EliminarEstudiante(){
        //TODO: eliminar un estudiante dado el codigo, correo o el objeto mismo
    }
    
    /**
     * Retorna el id de la carrera en la BDs
     * @return el Id
     * @throws SQLException 
     */
    public int getId() throws SQLException{
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT ID FROM CARRERA "
                + "WHERE NOMBRE = '"+nombre+"'";
        
        ResultSet res = stm.executeQuery(sql);
        
        int id = res.getInt(1);
        
        c.close();
        stm.close();
        
        return id;
    }
}
