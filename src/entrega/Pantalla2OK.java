package entrega;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import algoii.tp.db.estudiantes.EstudiantesDB;
import algoii.tp.db.estudiantes.Nota;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Pantalla2OK extends JFrame {

	private JPanel contentPane;
	
	public Pantalla1 pantallaSiguiente;
	public int legajoSeleccionado=1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2OK frame = new Pantalla2OK();
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
	public Pantalla2OK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(178, 216, 89, 23);
		getContentPane().add(btnSiguiente);
		
		JLabel lblBaseDeDatos = new JLabel("Base de Datos");
		lblBaseDeDatos.setBounds(100, 11, 89, 14);
		getContentPane().add(lblBaseDeDatos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 39, 295, 150);
		getContentPane().add(scrollPane);
		
		table = crearTabla();
		scrollPane.setViewportView(table);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
	}
}
