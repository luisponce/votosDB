package com.universidad;


import com.votacion.Votacion;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class UniversidadEafit {
	private ArrayList<String> puestosV;
	private ArrayList<Votacion> votaciones;
    
    private static UniversidadEafit INSTANCE;
    
    private UniversidadEafit(){
        
    }

    public static UniversidadEafit getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new UniversidadEafit();
        }
        return INSTANCE;
    }
    
    /**
     * Obtiene las escuelas almacenadas en la BDs y las retorna en una lista de
     * escuelas.
     * @return La lista de las escuelas en la BDs en un arreglo
     * @throws SQLException 
     */
    public ArrayList<Escuela> getEscuelas() throws SQLException{
        ArrayList<Escuela> listEscuelas = new ArrayList<>();
        
        //Obtener las escuelas de la BDs
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();  
        String sql = "SELECT NOMBRE FROM ESCUELA";
        ResultSet result = stm.executeQuery(sql);
        
        //meter las escuelas en la lista
        while(result.next()){
            String name = result.getString(1); //obtiene el nombre
            Escuela cur = new Escuela(name);
            listEscuelas.add(cur);
        }
        
        result.close();
        stm.close();
        c.close();
        
        return listEscuelas;
    }
}
