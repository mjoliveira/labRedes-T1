package server;

public class Jogador {
	private String nickName;
	private String ip;
	private int porta;
	private int casaAtual;
	
	public Jogador(String nickName, String ip, int porta) {
		this.nickName = nickName;
		this.ip = ip;
		this.porta = porta;
		this.casaAtual = 0;
	}
	
	public String getNickName() {
		return nickName;
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
