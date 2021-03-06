package com.personas;

import com.votacion.Votacion;
import com.votosdb.DBOps;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 */
public class AdmVotacion extends Admin{

    public AdmVotacion(int tipo, String correo, String pass, String nombre) {
        super(tipo, correo, pass, nombre);
    }
    
    

    @Override
    public void IngresarAdmin(int id) throws SQLException {
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
        String sql = "Insert into ADMIN (ID, TIPO) values" + "(" + id + ", " + 0 + ");";
        stm.execute(sql);
        stm.close();
        
    }

    @Override
    public void RetirarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
        le da la potestad a un admin de iniciar una votacion.
    */
    public void IniciarVotacion(Date fechaIni, Date fechaFin, String nombre) throws Exception{
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
            Votacion nuevaVotacion = new Votacion(fechaIni, fechaFin, nombre);
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
            
            stmt.executeUpdate(sql);
            stmt.close();
             
    }
    
    public void RegistrarCandidato(int codigo) throws Exception{
        DBOps ops = DBOps.getInstance();
        Connection con = ops.ConnectDB();
        Statement stmt = con.createStatement();
                
        String sql = "SELECT ID FROM USUARIO WHERE CODIGO ='" + codigo +"'";
        
        ResultSet res = stmt.executeQuery(sql);
        res.next();
        int id = Integer.parseInt(res.getString(1));
        stmt.close();
        
        //Meterlo en la DB.
    }
}
