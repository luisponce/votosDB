package com.personas;


import com.universidad.Carrera;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class Estudiante extends Persona {

    /**
     * Obtiene las carreas a las que esta vinculado el estudiante con el id dado
     * @param id el id del estudiante
     * @return Una lista de las carreras del estudiante
     */
    public static ArrayList<Carrera> getCarreras(int id) throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT DISTINCT NOMBRE FROM CARRERA, ESTUDIANTECARRERA "
                + "WHERE CARRERA = ID AND ESTUDIANTE = " + id;
        
        ResultSet res = stm.executeQuery(sql);
        
        ArrayList<Carrera> carreras = new ArrayList<>();
        
        while(res.next()){
            Carrera cur = new Carrera(res.getString(1));
            carreras.add(cur);
        }
        
        stm.close();
        
        return carreras;
    }
    
    
	private String codigo;
	private ArrayList<Carrera> carreras;
	private boolean candidato;

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public boolean isCandidato() {
        return candidato;
    }
    
	public void Votar() {
        //TODO: implementar votar
	}

    public Estudiante(String Codigo, Carrera Carrera,
            String nombre, String correo, String clave) {
        this.carreras = new ArrayList<>();
        
        this.codigo = Codigo;
        this.carreras.add(Carrera);
        this.nombre = nombre;
        this.correo = correo;
        this.password = clave;
    }
    
    public Estudiante(String codigo, ArrayList<Carrera> carreras,
            String nombre, String correo, String clave) {
        this.codigo = codigo;
        this.carreras = carreras;
        this.nombre = nombre;
        this.correo = correo;
        this.password = clave;
    }
}
