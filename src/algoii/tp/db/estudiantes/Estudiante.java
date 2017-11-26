package algoii.tp.db.estudiantes;

import java.util.List;

public class Estudiante {
	private int legajo;
	private String nombre;
	private List<Nota> notas;

	public Estudiante(int le, String no, List<Nota> nots) {
		legajo = le;
		nombre = no;
		notas = nots;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	
}
