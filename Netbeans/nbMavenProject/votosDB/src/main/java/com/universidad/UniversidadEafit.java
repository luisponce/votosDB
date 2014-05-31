package com.universidad;


import com.votacion.Votacion;
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
    
    public ArrayList<Escuela> getEscuelas(){
        ArrayList<Escuela> listEscuelas = new ArrayList<>();
        //TODO: query para obtener las escuelas
        
        //TODO: meter las escuelas en la lista
        
        return listEscuelas;
    }
}
