package com.universidad;


import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Escuela {
	private String Nombre;

    public Escuela(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    /**
     * Obtiene el ID en la BD de la escuela
     * @return el id de la escuela
     * @throws SQLException 
     */
    public int getDBid() throws SQLException{
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        
        String sql = "SELECT ID FROM ESCUELA "
                + "WHERE NOMBRE = '" + getNombre() +"'";
        ResultSet res = stm.executeQuery(sql);
        int id = res.getInt(1);
        
        stm.close();
        c.close();
        
        return id;
    }

    /**
     * Obtiene las carreras que pertenecen a esta escuela en una lista
     * @return Una lista con las carreras que pertenecen a la escuela
     * @throws SQLException 
     */
    public ArrayList<Carrera> getCarreras() throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        //obtener las carreras que pertenecen a esta escuela
        String sql = "SELECT NOMBRE FROM CARRERA"
                + "WHERE  ESCUELA = " + getDBid();
        ResultSet res = stm.executeQuery(sql);
        
        ArrayList<Carrera> carreras = new ArrayList<>();
        
        while(res.next()){
            Carrera cur = new Carrera(res.getString(1));
            carreras.add(cur);
        }
        
        return carreras;
    }
}
