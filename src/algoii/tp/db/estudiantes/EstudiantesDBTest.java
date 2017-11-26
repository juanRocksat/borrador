package algoii.tp.db.estudiantes;

import java.util.Arrays;
import java.util.List;

public class EstudiantesDBTest {
	public static void main(String[] args) {
		List<Estudiante> lst = EstudiantesDB.buscarTodos();
		for (Estudiante a : lst) {
			System.out.println(a.getLegajo() + ", " + a.getNombre() + ", " + a.getNotas());
		}

		System.out.println("---");

		Estudiante x = EstudiantesDB.buscarEstudiante(2);
		if (x != null) {
			System.out.println(x.getLegajo() + ", " + x.getNombre() + ", " + x.getNotas());
		} else {
			System.out.println("Estudiante no encontrado");
		}

		System.out.println("---");
		int id = EstudiantesDB.addEstudiante("Jose", Arrays.asList(new Nota(1, "Seis", 6), new Nota(2, "Dos", 2), new Nota(3, "Siete", 7)));
		System.out.println("Id Asignado: " + id);
		lst = EstudiantesDB.buscarTodos();
		for (Estudiante a : lst) {
			System.out.println(a.getLegajo() + ", " + a.getNombre() + ", " + a.getNotas());
		}
		System.out.println("---");
		Estudiante p = EstudiantesDB.buscarEstudiante(4);
		System.out.println(p.getLegajo() + ", " + p.getNombre() + ", " + p.getNotas());
		EstudiantesDB.updateEstudiante(4, "Jose Alberto", Arrays.asList(new Nota(1, "Dos", 2), new Nota(2, "Dos", 2), new Nota(3, "Nueve", 9)));
		p = EstudiantesDB.buscarEstudiante(4);
		System.out.println(p.getLegajo() + ", " + p.getNombre() + ", " + p.getNotas());

	}
}
