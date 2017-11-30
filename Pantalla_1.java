package entrega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoii.tp.db.estudiantes.Estudiante;
import algoii.tp.db.estudiantes.EstudiantesDB;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Pantalla_1 extends JFrame implements ItemListener
{

	private JPanel contentPane;
	public JComboBox comboBox ;
	
	public EstudiantesDB estudiantes= new EstudiantesDB();
	public static Estudiante alumno =EstudiantesDB.buscarEstudiante(3);
	public static int legajo =1; // que esto sea statico quito errores de la nada 
	
	public Pantalla_2 pantallaSiguiente=null;
	public Pantalla_1 pantallaActual=this;
	/**_
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Pantalla_1 frame=new Pantalla_1();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Pantalla_1()
	{setTitle("PANTALLA 1");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(73, 142, 100, 23);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSiguiente){
					
					legajo=Integer.parseInt(comboBox.getSelectedItem().toString());
					alumno=estudiantes.buscarEstudiante(legajo);
					
					
					mostrar("legajo seleccionado es : " + legajo+" - "+alumno.getNombre());
					if(pantallaSiguiente==null )abrirPantallaSiguiente();
					pantallaSiguiente.toFront();
					
					setearAlumno(legajo);
					resolverActualizacionDeDatos();
				}
				
			}
		});
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(73, 41, 246, 20);
		contentPane.add(comboBox);
		contentPane.add(btnSiguiente);
		
		agregarDatosAComboBoxPorLegajo();
		comboBox.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==comboBox){
			legajo=Integer.parseInt(comboBox.getSelectedItem().toString());
			alumno=estudiantes.buscarEstudiante(legajo);
			mostrar("legajo seleccionado es : " + legajo);
			setearAlumno(legajo);
			resolverActualizacionDeDatos();
		}
	}
	private void mostrar(Object s) {
		System.out.println(s);
	}
	private void resolverActualizacionDeDatos() {
		if(pantallaSiguiente!=null){
			pantallaSiguiente.capturarEventoEnTabla();
		}
	}
	
	private void agregarDatosAComboBoxPorLegajo()
	{
		for(int i=1;i<=3;i++){
//			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo() +" - "+ estudiantes.buscarEstudiante(i).getNombre());
			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo());
			
		}
	}
	private void abrirPantallaSiguiente() {
		pantallaSiguiente=new Pantalla_2();
		pantallaSiguiente.setVisible(true);
		 pantallaSiguiente.setPantallaAnterior(pantallaActual);
	}
	private void setearAlumno(int numeroSeleccionado) {
		setAlumno(estudiantes.buscarEstudiante(numeroSeleccionado));
	}
//	private void abrirPantalla2()
//	{
//		if(pantallaSiguiente==null)pantallaSiguiente=new Pantalla2OK(legajo);
//	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	public EstudiantesDB getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(EstudiantesDB estudiantes) {
		this.estudiantes = estudiantes;
	}
	public Estudiante getAlumno() {
		return alumno;
	}
	public void setAlumno(Estudiante alumno) {
		this.alumno = alumno;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public Pantalla_2 getPantallaSiguiente() {
		return pantallaSiguiente;
	}
	public void setPantallaSiguiente(Pantalla_2 pantallaSiguiente) {
		this.pantallaSiguiente = pantallaSiguiente;
	}
	public Pantalla_1 getPantallaActual() {
		return pantallaActual;
	}
	public void setPantallaActual(Pantalla_1 pantallaActual) {
		this.pantallaActual = pantallaActual;
	}
	
}
