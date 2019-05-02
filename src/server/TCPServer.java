package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TCPServer {
	private static Tabuleiro tabuleiro = new Tabuleiro();
	private static Jogador[] jogador = new Jogador[2];

	public static void main(String[] args) {
		int porta = 1025;
		int jogadaDado = 0;
		String jogada;

		try {

			ServerSocket socketServidor = new ServerSocket(porta);

			System.out.println("Esperando cliente...");
			Socket conexao = socketServidor.accept();
			System.out.println("Cliente Conectado...");

			BufferedReader entradaCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

			DataOutputStream saidaCliente = new DataOutputStream(conexao.getOutputStream());

			while (true) {

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}