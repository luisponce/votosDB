package com.personas;


import com.universidad.Carrera;
import java.util.ArrayList;




public class Estudiante extends Persona {
	private int Codigo;
	private ArrayList<Carrera> Carreras;
	private boolean candidato;
    
	public void Votar() {
        //TODO: implementar votar
	}

    public Estudiante(int Codigo, ArrayList<Carrera> Carreras,
            boolean candidato, String nombre, String correo, String clave) {
        this.Codigo = Codigo;
        this.Carreras = Carreras;
        this.candidato = candidato;
        this.Nombre = nombre;
        this.Correo = correo;
        this.Password = clave;
    }
}
