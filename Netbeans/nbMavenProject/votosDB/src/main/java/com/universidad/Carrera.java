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

    public ArrayList<Estudiante> getEstudiantes() throws SQLException {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT DISTINCT USUARIO.ID, CORREO, PASSWORD, CODIGO, NOMBRE "
                + "FROM USUARIO, ESTUDIANTE, ESTUDIANTECARRERA "
                + "WHERE USUARIO.ID = ESTUDIANTE.ID "
                + "AND ESTUDIANTE = ESTUDIANTE.ID AND CARRERA = "+getId();
        
        ResultSet res = stm.executeQuery(sql);
        
        while(res.next()){
            String codigo = res.getString("CODIGO");
            String nombre = res.getString("NOMBRE");
            String correo = res.getString("CORREO");
            String password = res.getString("PASSWORD");
            int id = res.getInt("ID");
            
            ArrayList<Carrera> carreras = Estudiante.getCarreras(id);
            
            Estudiante cur = new Estudiante(codigo, carreras, nombre, correo, password);
            estudiantes.add(cur);
        }
        
        return estudiantes;
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
        
        
        stm.close();
        
        return id;
    }
}
