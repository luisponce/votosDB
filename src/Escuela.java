
import java.util.ArrayList;



public class Escuela {
	private ArrayList<Carrera> Carreras;
	private int NumEst;
	private String Nombre;

    public Escuela(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Carrera> getCarreras() {
        return Carreras;
    }
}
