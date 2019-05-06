package server;

import java.net.InetAddress;

public class Jogador {
	private String nickName;
	private InetAddress ip;
	private int porta;
	private int casaAtual;
	private boolean estado; // Uma rodada sem jogar - Pode jogar ou não

	public Jogador(String nickName, InetAddress ip, int porta) {
		this.nickName = nickName;
		this.ip = ip;
		this.porta = porta;
		this.casaAtual = 0;
		this.estado = true;

	}

	public String getNickName() {
		return nickName;
	}

	public int getPorta() {
		return porta;
	}

	public InetAddress getIp() {
		return ip;
	}

	public int getCasaAtual() {
		return casaAtual;
	}

	public void setCasaAtual(int casaAtual) {
		this.casaAtual = casaAtual;
	}

}
