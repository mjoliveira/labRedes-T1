package server;

public class Jogador {
	private String nome;
	private String ip;
	private int porta;
	private int casaAtual;
	
	public Jogador(String nome, String ip, int porta) {
		this.nome = nome;
		this.ip = ip;
		this.porta = porta;
		this.casaAtual = 0;
	}
	
	public String getNome() {
		return nome;
	}

	public int getPorta() {
		return porta;
	}

	public String getIp() {
		return ip;
	}
	
	public int getCasaAtual() {
		return casaAtual;
	}

	public void setCasaAtual(int casaAtual) {
		this.casaAtual = casaAtual;
	}
	
}
