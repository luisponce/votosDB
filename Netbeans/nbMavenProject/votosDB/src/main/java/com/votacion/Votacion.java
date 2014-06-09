package com.votacion;


import com.personas.Estudiante;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sun.management.GcInfoCompositeData;





public class Votacion {
	private Object FechaInicio;
	private Object FechaFin;
	private String nombre;

    public Object getFechaInicio() {
        return FechaInicio;
    }

    public Object getFechaFin() {
        return FechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public Votacion(Object FechaInicio, Object FechaFin, String Nombre) {
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        //this.Nombre = Nombre;
        //this.Votos = new ArrayList<>();
        //this.candidatos = new Estudiante[];
        this.nombre = Nombre;
    }
    
    /**
     * retorna los candidatos de la votacion que llama el metodo
     * @return un arreglo con todos los candidatos inscritos a la votacion.
     * @throws SQLException 
     */
    public Estudiante[] getCandidatos() throws SQLException {
        ArrayList<Estudiante> listCandidatos = new ArrayList<>();
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT CODIGO FROM ESTUDIANTE, CANDIDATO"
                + " WHERE CANDIDATO = ID AND VOTACION = "+getId();
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            Estudiante curCandidato = Estudiante.getEstudiante(res.getString(1));
            listCandidatos.add(curCandidato);
        }
        Estudiante[] candidatosRet = new Estudiante[listCandidatos.size()];
        for (int i = 0; i < candidatosRet.length; i++) {
            candidatosRet[i] = listCandidatos.get(i);
        }
        stm.close();
        return candidatosRet;
    }

    /**
     * obtiene el id de la votacion que llama el metodo
     * @return un int con el id de la votacion.
     * @throws SQLException 
     */
    private int getId() throws SQLException {
        return getIntByName(this.nombre);
    }
    
    public static int getIntByName(String nombre) throws SQLException{
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        
        String sql = "SELECT ID FROM VOTACION WHERE NOMBRE = '"+nombre+"'";
        
        ResultSet res = stm.executeQuery(sql);
        
        int id = res.getInt(1);
        
        res.close();
        
        return id;

    }
}
