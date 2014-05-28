package votacion;


import Personas.Estudiante;
import java.util.ArrayList;




public class Votacion {
	private Object FechaInicio;
	private Object FechaFin;
	private ArrayList<Voto> Votos;
	private Estudiante[] candidatos;
	private String Nombre;

    public Votacion(Object FechaInicio, Object FechaFin, Estudiante[] candidatos, String Nombre) {
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Votos = new ArrayList<>();
        this.candidatos = candidatos;
        this.Nombre = Nombre;
    }

   

    public Object getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Object FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Object getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Object FechaFin) {
        this.FechaFin = FechaFin;
    }

    public ArrayList<Voto> getVotos() {
        return Votos;
    }

    public void setVotos(ArrayList<Voto> Votos) {
        this.Votos = Votos;
    }

    public Estudiante[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Estudiante[] candidatos) {
        this.candidatos = candidatos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
        
}
