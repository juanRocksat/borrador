package entrega;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoii.tp.db.estudiantes.Estudiante;
import algoii.tp.db.estudiantes.EstudiantesDB;
import algoii.tp.db.estudiantes.Nota;

import javax.swing.JScrollPane;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Pantalla2OK extends JFrame implements Action {

	private JPanel contentPane;
	
	public Pantalla1 pantallaSiguiente;
	public int legajoSeleccionado=1;
	private JTable table;
	
	Estudiante alumnoSeleccionado;

	JScrollPane scrollPane = new JScrollPane(table);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2OK frame = new Pantalla2OK(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param legajoSeleccionado2 
	 */
	public Pantalla2OK(int legajoSeleccionado2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		setLegajoSeleccionado(legajoSeleccionado2);
		
		
		scrollPane.setBounds(54, 39, 295, 150);
		getContentPane().add(scrollPane);
		
		table = crearTabla();
		scrollPane.setViewportView(table);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		verSeteoDeTabla();
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					pantallaSiguiente.toFront();
					pantallaSiguiente.setVisible(true);
					printDebugData(table);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Primero se debe abrir la pantalla1");
				}
			}
		});
		btnSiguiente.setBounds(178, 216, 89, 23);
		getContentPane().add(btnSiguiente);
		
		JLabel lblBaseDeDatos = new JLabel("Notas de : "+ alumnoSeleccionado.getNombre());
		lblBaseDeDatos.setBounds(100, 11, 110, 14);
		getContentPane().add(lblBaseDeDatos);
	}
	
	private void verSeteoDeTabla() {
		table.setPreferredScrollableViewportSize(new Dimension(500, 75));
        if (true){
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        //Create the scroll pane and add the table to it. 
//        JScrollPane scrollPane1 = new JScrollPane(table);
        //Add the scroll pane to this window.
//        setContentPane(scrollPane);   si lo descomento superpondra otro scrollPane y no se vera el label y el boton 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	private JTable crearTabla() {
		 Object[][] data = this.crearMatrizDeNotas();
	     String[] columnNames = {"Numero de Examen","Nota En Letras","Nota Numerica "};
	    return new JTable(data, columnNames);
	}
	public Object[][] crearMatrizDeNotas(){
		java.util.List<Nota> notas = EstudiantesDB.obtenerNotas(legajoSeleccionado);
		Object[][] matriz = {
				{notas.get(0).getNroExamen(),notas.get(0).getDescrLetras(),notas.get(0).getValor()},
				{notas.get(1).getNroExamen(),notas.get(1).getDescrLetras(),notas.get(1).getValor()},
				{notas.get(2).getNroExamen(),notas.get(2).getDescrLetras(),notas.get(2).getValor()}		
		}; // con for(;;) tira error a morir
		
		return matriz;
	}
	@SuppressWarnings("unused")
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public Pantalla1 getPantallaSiguiente() {
		return pantallaSiguiente;
	}

	public void setPantallaSiguiente(Pantalla1 pantallaSiguiente) {
		this.pantallaSiguiente = pantallaSiguiente;
	}

	public int getLegajoSeleccionado() {
		return legajoSeleccionado;
	}

	public void setLegajoSeleccionado(int legajoSeleccionado) {
		this.legajoSeleccionado = legajoSeleccionado;
		alumnoSeleccionado=EstudiantesDB.buscarEstudiante(legajoSeleccionado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
}
