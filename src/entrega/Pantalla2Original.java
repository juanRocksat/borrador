package entrega;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Pantalla2Original extends JFrame {

	private JPanel contentPane;
	
	public Pantalla1 pantallaSiguiente;
	public int legajoSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2Original frame = new Pantalla2Original();
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
	public Pantalla2Original() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public JPanel getContentPane() {
		return contentPane;
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
