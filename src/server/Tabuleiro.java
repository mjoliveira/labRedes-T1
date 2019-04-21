package server;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
	private Random dado;
	
	ArrayList<Mensagem> mensagens = new ArrayList();
	ArrayList<Jogador> jogadores = new ArrayList();
	
	public Tabuleiro() {
		Random dado = new Random();
	}
	
	public int jogarDado() {
		return dado.nextInt(6);
	}
	
	public String mensagemSurpresas(int casa) {
		Mensagem mensagem = null;
		
		for(int i = 0; i < mensagens.size(); i++) {
			
			mensagem = mensagens.get(i);
			
			if(mensagem.getCasa() == casa) 
				return mensagem.getTexto();
				
		}
		
		return null;
	}	
	
	public void andarCasas(int valor, String ip){
		Jogador jogador = null;
	
		for(int i = 0; i < mensagens.size(); i++) {
			jogador = jogadores.get(i);
			
			if(jogador.getIp().equals(ip)) 
				jogador.setCasaAtual(jogador.getCasaAtual() + valor);
			
		}
	}
}
