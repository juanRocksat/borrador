package algoii.tp.db.estudiantes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class EstudiantesDB {
	private static Hashtable<Integer, Estudiante> estudiantes;
	private static int idEstudiante;
	static {
		estudiantes = new Hashtable<>();
		estudiantes.put(1, new Estudiante(1, "Juan", Arrays.asList(new Nota(1, "Seis", 6), new Nota(2, "Dos", 2), new Nota(3, "Siete", 7))));
		estudiantes.put(2, new Estudiante(2, "Pablo", Arrays.asList(new Nota(1, "Cinco", 5), new Nota(2, "Seis", 6), new Nota(3, "Ocho", 8))));
		estudiantes.put(3, new Estudiante(3, "Pedro", Arrays.asList(new Nota(1, "Dos", 2), new Nota(2, "Dos", 2), new Nota(3, "Nueve", 9))));
		idEstudiante = estudiantes.size() + 1;
	}
	public static Estudiante buscarEstudiante(int matricula) {
		return estudiantes.get(matricula);
	}

	public static int addEstudiante(String nombre, List<Nota> notas) {
		Estudiante a = new Estudiante(idEstudiante, nombre, notas);
		estudiantes.put(idEstudiante, a);
		return idEstudiante++;
	}

	public static void updateEstudiante(int id, String nombre, List<Nota> notas) {
		Estudiante a = buscarEstudiante(id);
		a.setNombre(nombre);
		a.setNotas(notas);
	}

	public static void crearEstudiante(int matricula, String nombre, List<Nota> notas) {
		Estudiante a = new Estudiante(matricula, nombre, notas);
		estudiantes.put(matricula, a);
	}

	public static void modificarEstudiante(int matricula, String nombre, List<Nota> notas) {
		Estudiante a = estudiantes.get(matricula);
		a.setNombre(nombre);
		a.setNotas(notas);
	}

	public static void eliminarEstudiante(int matricula) {
		estudiantes.remove(matricula);
	}

	public static List<Estudiante> buscarTodos() {
		ArrayList<Estudiante> lista = new ArrayList<>();
		for (Enumeration<Estudiante> e = estudiantes.elements(); e.hasMoreElements();) {
			lista.add(e.nextElement());
		}

		return lista;
	}
	
	public static List<Nota> obtenerNotas(int legajo) {
		return buscarEstudiante(legajo).getNotas();
	}
	
	public static void modificarNotasEstudiante(int matricula, List<Nota> notas) {
		Estudiante a = estudiantes.get(matricula);
		a.setNotas(notas);
	}

	
	public static void setEstudiantes(Hashtable<Integer,Estudiante> estudiantes)
	{
		EstudiantesDB.estudiantes=estudiantes;
	}

	public static int getIdEstudiante()
	{
		return idEstudiante;
	}

	public static void setIdEstudiante(int idEstudiante)
	{
		EstudiantesDB.idEstudiante=idEstudiante;
	}
	public static Hashtable<Integer,Estudiante> getEstudiantes()
	{
		return estudiantes;
	}

	

}
