package entrega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoii.tp.db.estudiantes.Estudiante;
import algoii.tp.db.estudiantes.EstudiantesDB;
import algoii.tp.db.estudiantes.Nota;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Pantalla_2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Pantalla_1 pantallaAnterior = new Pantalla_1();//seteado para  probar 
	
	public Object[][] data; 
	public  List<Nota> notas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_2 frame = new Pantalla_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotasDe = new JLabel("Notas de : ");
		lblNotasDe.setBounds(35, 11, 200, 14);
		contentPane.add(lblNotasDe);
		
		table =crearTabla();
		table.setBounds(197, 62, 145, 120);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(22, 62, 330, 120);
		contentPane.add(scrollPane);
		
		
		
		JButton botonAnterior = new JButton("Siguiente");
		botonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonAnterior.setBounds(68, 204, 145, 23);
		contentPane.add(botonAnterior);
		
	
	}
	private JTable crearTabla() {
		 data= crearMatrizDeNotas();
	     String[] columnNames = {"Numero de Examen","Nota En Letras","Nota Numerica "};
	    return new JTable(data, columnNames);
	}
	public Object[][] crearMatrizDeNotas(){
		notas = estudiantes().obtenerNotas(legajoSeleccionado());
		Object[][] matriz = {
				{notas.get(0).getNroExamen(),notas.get(0).getDescrLetras(),notas.get(0).getValor()},
				{notas.get(1).getNroExamen(),notas.get(1).getDescrLetras(),notas.get(1).getValor()},
				{notas.get(2).getNroExamen(),notas.get(2).getDescrLetras(),notas.get(2).getValor()}		
		}; // con for(;;) tira error a morir
		
		return matriz;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Pantalla_1 getPantallaAnterior() {
		return pantallaAnterior;
	}

	public void setPantallaAnterior(Pantalla_1 pantallaAnterior) {
		this.pantallaAnterior = pantallaAnterior;
	}
	private EstudiantesDB estudiantes() {
		return pantallaAnterior.getEstudiantes();
	}
	private Estudiante alumnoSeleccionado() {
		return pantallaAnterior.getAlumno();
	}
	private int legajoSeleccionado() {
		return pantallaAnterior.getLegajo();
	}
	
	
	
}
