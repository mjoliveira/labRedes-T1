package server;

public class Mensagem {
	private String texto;
	private int valor;
	private int casa;
	
	public Mensagem(String texto, int valor, int casa) {
		this.texto = texto;
		this.valor = valor;
		this.casa = casa;
	}

	public int getCasa() {
		return casa;
	}

	public String getTexto() {
		return texto;
	}

	public int getValor() {
		return valor;
	}
	
}
