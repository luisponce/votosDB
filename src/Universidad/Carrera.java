package Universidad;


import Personas.Estudiante;
import java.util.ArrayList;




/**
 * clase para representar una carrera de una escuela de la universidad eafit.
 */
public class Carrera {
	private ArrayList<Estudiante> estudiantes;
	private String nombre;

    public Carrera(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public void IngresarEstudiante(Estudiante e){
        estudiantes.add(e);
    }
    
    public void EliminarEstudiante(){
        //TODO: eliminar un estudiante dado el codigo, correo o el objeto mismo
    }
}
