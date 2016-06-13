package digital.curioso.balada.util;

public class ErrorMessage {

	private int cod;
	private String texto;

	public ErrorMessage(int cod, String texto) {
		super();
		this.cod = cod;
		this.texto = texto;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
