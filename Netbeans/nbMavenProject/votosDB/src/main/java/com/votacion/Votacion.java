package com.votacion;


import com.personas.Estudiante;
import java.util.ArrayList;





public class Votacion {
	private Object FechaInicio;
	private Object FechaFin;
	private ArrayList<Voto> Votos;
	private Estudiante[] candidatos;
	private String Nombre;

    public Object getFechaInicio() {
        return FechaInicio;
    }

    public Object getFechaFin() {
        return FechaFin;
    }

    public String getNombre() {
        return Nombre;
    }

    public Votacion(Object FechaInicio, Object FechaFin, Estudiante[] candidatos, String Nombre) {
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.candidatos = candidatos;
        this.Nombre = Nombre;
        this.Votos = new ArrayList<>();
    }
}
