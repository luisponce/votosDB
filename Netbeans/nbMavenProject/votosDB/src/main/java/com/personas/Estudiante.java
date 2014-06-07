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

    public static Estudiante getEstudiante(String codigo) throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT DISTINCT NOMBRE, CORREO, PASSWORD, ESTUDIANTE.ID "
                + "FROM ESTUDIANTE, USUARIO "
                + "WHERE ESTUDIANTE.ID = USUARIO.ID "
                + "AND CODIGO = '"+codigo+"' ";
        
        ResultSet res = stm.executeQuery(sql);
        
        String nombre = res.getString(1);
        String correo = res.getString(2);
        String pas = res.getString(3);
        int id = res.getInt(4);
        
        res.close();
        
        //obtener las carreras a las que pertenece el estudiante
        sql = "SELECT NOMBRE FROM CARRERA, ESTUDIANTECARRERA "
                + "WHERE ID = CARRERA AND ESTUDIANTE = "+id;
        
        ArrayList<Carrera> carreras = new ArrayList<>();
        
        ResultSet res2 = stm.executeQuery(sql);
        
        while(res2.next()){
            Carrera carrera = new Carrera(res2.getString(1));
            carreras.add(carrera);
        }
        
        Estudiante estudiante = new Estudiante(codigo, carreras, nombre, correo, pas);
        
        return estudiante;
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

    public int getId() throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT ID FROM ESTUDIANTE WHERE CODIGO = '"+codigo+"'";
        
        ResultSet res = stm.executeQuery(sql);
        
        return res.getInt(1);
    }
}
