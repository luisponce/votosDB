package Universidad;


import java.util.ArrayList;



public class Escuela {
	private ArrayList<Carrera> carreras;
	private int numEst;
	private String nombre;

    public Escuela(String Nombre) {
        this.nombre = Nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }
    
    public void ingresarCarrera(Carrera c){
        carreras.add(c);
    }
}
