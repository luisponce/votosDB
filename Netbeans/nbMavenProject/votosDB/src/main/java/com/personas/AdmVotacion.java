

package com.personas;

import com.universidad.Carrera;
import com.votacion.Votacion;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class AdmVotacion extends Admin{

    @Override
    public void IngresarAdmin() throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "Insert into ADMIN (TIPO) values" + "(" + 0 + ");";
        stm = c.prepareStatement(sql);
    }

    @Override
    public void RetirarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        le da la potestad a un admin de iniciar una votacion.
    */
    public void IniciarVotacion(Date fechaIni, Date fechaFin,
            Estudiante[] postulados, String nombre) throws Exception{
            Date hoy = new Date(); //Se captura la fecha en ese momento.
            int año = hoy.getYear(); 
            int mes = hoy.getMonth();
            int dia = hoy.getDay();
            hoy = new Date(año, mes, dia); //se le cambia el formato para que
                                           //no tenga hora, minutos, segundos.
            if(fechaIni.compareTo(hoy) < 0){ //Se valida que la fecha de incio
                                             //sea mayor que la fecha actual.
                throw new Exception("La fecha de inicio de votacion no"
                        + " es válida.");
            }
            if(fechaIni.compareTo(fechaFin) > 0){ //se valida que la fecha final
                                                  //sea posterior a la final
                throw new Exception("La fecha de inicio de votacion no"
                        + " es válida.");
            }
            Votacion nuevaVotacion = new Votacion(fechaIni, fechaFin,
                    postulados, nombre);
            DBOps ops = DBOps.getInstance();
            Connection con = ops.ConnectDB();
            Statement stmt;
            //Despues de haber creado el objeto, se ingresa la informacion en
            //la BD.
            String sql = "Insert into VOTACION (NOMBRE, FECHA_INICIO, FECHA_FIN)"
                    + " values ("+ "'" + nuevaVotacion.getNombre() + "'" +
                    ", "+ "'" + nuevaVotacion.getFechaInicio() + "'" +
                    ", "+ "'" + nuevaVotacion.getFechaFin()+ "'" + ")";
            stmt = con.createStatement();
            
            stmt.execute(sql);
             
    }
    
    public void RegistrarCandidato(int codigo, ArrayList<Carrera> carreras,
            String nombre, String correo, String clave){
        
        Estudiante candidato = new Estudiante(codigo, carreras, true, nombre,
        correo, clave);
        //Meterlo en la DB.
    }
}
