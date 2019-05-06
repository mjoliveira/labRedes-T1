package server;

public class Mensagem {
	private String texto;
	private int valor;
	private boolean onus; 
	
	public Mensagem(String texto, int valor) {
		this.texto = texto;
		this.valor = valor;
		this.onus = false;
	}
	
	public Mensagem(String texto) {
		this.texto = texto;
		this.valor = 0;
		this.onus = true;
	}

	public String getTexto() {
		return texto;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean getOnus() {
		return onus;
	}
	
}
