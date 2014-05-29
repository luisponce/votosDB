

package com.personas;

import com.universidad.Carrera;
import com.votacion.Votacion;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class AdmVotacion extends Admin{

    @Override
    public void IngresarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RetirarAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void IniciarVotacion(Date fechaIni, Date fechaFin,
            Estudiante[] postulados, String nombre) throws Exception{
            Date hoy = new Date();
            int año = hoy.getYear();
            int mes = hoy.getMonth();
            int dia = hoy.getDay();
            hoy = new Date(año, mes, dia);
            if(fechaIni.compareTo(hoy) < 0){
                throw new Exception("La fecha de inicio de votacion no"
                        + " es válida.");
            }
            if(fechaIni.compareTo(fechaFin) < 0){
                throw new Exception("La fecha de inicio de votacion no"
                        + " es válida.");
            }
            Votacion nuevaVotacion = new Votacion(fechaIni, fechaFin,
                    postulados, nombre);
            //meterla en la DB y notificar a la universidad (singleton).
    }
    
    public void RegistrarCandidato(int codigo, ArrayList<Carrera> carreras,
            String nombre, String correo, String clave){
        
        Estudiante candidato = new Estudiante(codigo, carreras, true, nombre,
        correo, clave);
        //Meterlo en la DB.
    }
}
