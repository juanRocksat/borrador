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
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Pantalla1OK extends JFrame implements ItemListener
{

	private JPanel contentPane;
	public JComboBox comboBox ;
	
	public EstudiantesDB estudiantes= new EstudiantesDB();
	public Estudiante alumno =null;
	public int legajo =1;
	/**
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
					Pantalla1OK frame=new Pantalla1OK();
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
	public Pantalla1OK()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(73, 142, 100, 23);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		}
	}
	
	private void agregarDatosAComboBoxPorLegajo()
	{
		for(int i=1;i<=3;i++){
//			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo() +" - "+ estudiantes.buscarEstudiante(i).getNombre());
			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo());
			
		}
	}
}
