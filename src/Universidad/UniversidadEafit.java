package Universidad;


import votacion.Votacion;
import java.util.ArrayList;




public class UniversidadEafit {
	private ArrayList<Escuela> escuelas;
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
}
