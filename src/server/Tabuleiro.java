package server;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {
	private Random dado;
	
	ArrayList<Mensagem> mensagens = new ArrayList();
	ArrayList<Jogador> listaJogadores = new ArrayList();
	
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
			jogador = listaJogadores.get(i);
			
			if(jogador.getIp().equals(ip)) 
				jogador.setCasaAtual(jogador.getCasaAtual() + valor);
			
		}
	}
	
	public void criarJogador(String nickName, String ip, int porta){
		Jogador jogador = new Jogador(nickName, ip, porta);
		
		listaJogadores.add(jogador);
	}
	
	public String vitoria(){
		
		if(listaJogadores.get(0).getCasaAtual() == 39) 
			return "Vitória do(a) jogador(a) " +  listaJogadores.get(0).getNickName();
		
		if(listaJogadores.get(1).getCasaAtual() == 39) 
			return "Vitória do(a) jogador(a) " +  listaJogadores.get(0).getNickName();
		
		return null;
	}
}
