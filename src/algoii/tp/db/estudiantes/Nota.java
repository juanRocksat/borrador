package algoii.tp.db.estudiantes;

public class Nota {

	private int nroExamen;
	private String descrLetras;
	private int valor;
	
	public Nota(int nroExamen, String descrLetras, int valor) {
		super();
		this.nroExamen = nroExamen;
		this.descrLetras = descrLetras;
		this.valor = valor;
	}
	public int getNroExamen() {
		return nroExamen;
	}
	public void setNroExamen(int nroExamen) {
		this.nroExamen = nroExamen;
	}
	public String getDescrLetras() {
		return descrLetras;
	}
	public void setDescrLetras(String descrLetras) {
		this.descrLetras = descrLetras;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Nota [nroExamen=" + nroExamen + ", descrLetras=" + descrLetras + ", valor=" + valor + "]";
	}
	
}
