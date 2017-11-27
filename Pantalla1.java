package entrega;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoii.tp.db.estudiantes.EstudiantesDB;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Pantalla1 extends JFrame implements ItemListener
{
	JComboBox comboBox;
	Pantalla2OK pantallaSiguiente;//=new Pantalla2a();
	private JPanel contentPane;
	public Pantalla1 pantallaActual=this;
	int legajoSeleccionado=1;
	
	EstudiantesDB estudiantes = new EstudiantesDB();

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
					Pantalla1 frame=new Pantalla1();
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
	public Pantalla1()
	{
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		comboBox = new JComboBox();
		
		comboBox.addItemListener(this);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pantallaSiguiente==null || pantallaSiguiente.isActive())pantallaSiguiente=new Pantalla2OK(legajoSeleccionado);
//				pantallaSiguiente=new Pantalla2OK();
				if(pantallaSiguiente.getLegajoSeleccionado()!=legajoSeleccionado)pantallaSiguiente.toFront();
				
				pantallaSiguiente.setVisible(true);
				pantallaSiguiente.toFront();//al frente
				pantallaSiguiente.setPantallaSiguiente(pantallaActual);
				pantallaSiguiente.setLegajoSeleccionado(legajoSeleccionado);
				
			}
		});
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.gridx = 2;
		gbc_btnSiguiente.gridy = 3;
		contentPane.add(btnSiguiente, gbc_btnSiguiente);
		agregarDatosAComboBoxPorLegajo();
		setTitle("Pantalla1");
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==comboBox){
//			legajoSeleccionado=Integer.parseUnsignedInt(comboBox.getSelectedItem().toString().charAt(0));
			legajoSeleccionado=Integer.parseInt(comboBox.getSelectedItem().toString());
			
		}
	}
	
	@SuppressWarnings("unused")
	private void agregarDatosAComboBox()
	{
		for(int i=1;i<=3;i++){
			comboBox.addItem(EstudiantesDB.buscarEstudiante(i).getNombre());
		}
	}
	private void agregarDatosAComboBoxPorLegajo()
	{
		for(int i=1;i<=3;i++){
//			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo() +" - "+ estudiantes.buscarEstudiante(i).getNombre());
			comboBox.addItem(estudiantes.buscarEstudiante(i).getLegajo());
			
		}
	}
	public EstudiantesDB getEstudiantes()
	{
		return estudiantes;
	}


}