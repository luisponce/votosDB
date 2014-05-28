

package Personas;

import java.util.Date;
import votacion.*;
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
    
    
    public void IniciarVotacion(Estudiante postulados[], Date fechaInicio, Date fechaFin, String nombre) throws Exception{
        Date fecha = new Date();
        int año = fecha.getYear();
        int mes = fecha.getMonth();
        int dia = fecha.getDay();
        fecha = new Date(año, mes, dia);
        if((fechaInicio.compareTo(fecha)) < 0){
            throw new Exception("La fecha de inicio no es valida.");
        }
        if(fechaFin.compareTo(fechaInicio) <= 0){
            throw new Exception("La fecha final debe ser despues de la inicial"
                    + " (debe durar mas de un día).");
        }
        
        Votacion votacion = new Votacion(fechaInicio, fechaFin, postulados, nombre);
        
        
    }
    
    public void RegistrarCandidato(){
        
    }
}
