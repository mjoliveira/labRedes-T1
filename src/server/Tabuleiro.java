package server;

import java.util.Map;
import java.util.Random;

public class Tabuleiro {
	private Random dado;

	Map<Integer, Mensagem> mensagens;

	public Tabuleiro() {
		Random dado = new Random();
	}

	// Simula a jogada aleat�ria de um dado
	public int jogarDado() {
		return dado.nextInt(6);
	}

	// Atualiza a casa do jogador
	public void andarCasas(int valor, Jogador jogador) {
		jogador.setCasaAtual(jogador.getCasaAtual() + valor);

	}

	// Verifica se o jogador ganhou
	public boolean vitoria(Jogador jogador) {

		if (jogador.getCasaAtual() == 39)
			return true;

		return false;
	}

	// Verifica se tem mensagem surpresa
	public String mensagemSurpresas(int casa) {
		Mensagem mensagem = null;

		if (mensagens.containsKey(casa)) {
			mensagem = mensagens.get(casa);
			return mensagem.getTexto();
		}

		return null;
	}

	// Cria todas as mensagens de onus e bonus
	public void criaMensagens() {
		mensagens.put(2, new Mensagem("Acabou o caf�! (volte  2 casas)", -2));
		mensagens.put(12, new Mensagem("O bug que voc� corrigido gerou 24 novos bugs. (Volte 4 casas)", -4));
		mensagens.put(17, new Mensagem(
				"O cliente perguntou �Pra que pagar se posso pedir para o meu sobrinho fazer?�. (volte 2 casas)", -2));
		mensagens.put(16, new Mensagem(
				"Depois de dias codando e  madrugadas debugando, algu�m te d� a triste not�cia de que seu c�digo possui erros. (volte 2 casas)",
				-2));
		mensagens.put(4, new Mensagem(
				"Voc� passou quatro horas tentando corrigir um bug no sistema e descobriu que o problema era um ponto e v�rgula faltando (Fique uma rodada sem jogar)"));
		mensagens.put(20, new Mensagem(
				"Seu computador estragou e voc� n�o fez commit do seu c�digo. (Fique uma rodada sem jogar)"));
		mensagens.put(27, new Mensagem(
				"Mudan�as n�o planejadas no decorrer do projeto, pois o cliente quer �s� uma altera��o pequena�. (Fique uma rodada sem jogar)"));
		mensagens.put(38, new Mensagem("Baidu instalado com sucesso! (Fique uma rodada sem jogar)"));
		mensagens.put(9, new Mensagem("Voc� corrigiu um bug no sistema que estava trabalhando. (Avance 3 casas)", 3));
		mensagens.put(24, new Mensagem(
				"Voc� visitou a casa de um parente sem que ningu�m pedisse para voc� formatar um computador. (Avance 2 casas)",
				2));
	}

}
