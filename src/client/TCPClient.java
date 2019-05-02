package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.Tabuleiro;


public class TCPClient {
	private static Tabuleiro tabuleiro;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String informacoesCliente;
		String informacoesModificadas;
		String jogada;
		String opcao;
		String nickName = "Mayara"; // = "Mayara";
		String ip = "192.168.25.5"; // = "192.168.25.5";
		int porta = 1025; // = 1025;
		int jogadaDado = 0;

		try {
			
			System.out.println("Rodando...");
	        System.out.println("Conectando com servidor...");
	        
	        /*
	        System.out.printf("Informe o nome de usuário: \n");
	        nickName = in.nextLine();
	        
	        System.out.printf("\nInforme seu IP:\n");
	        ip = in.nextLine();
	        
	        System.out.printf("\nInforme a porta de acesso: \n");
	        porta = in.nextInt();
	        */
			
			tabuleiro.criarJogador(nickName, ip, porta);
	        
	        Socket socketCliente = new Socket(ip, porta);
	        System.out.println("Conectado...");
	        
	        BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
	        DataOutputStream saidaServidor = new DataOutputStream(socketCliente.getOutputStream());
	        
	        while(true) {
	        	jogada = entradaServidor.readLine();
	        	//tabuleiro.atualizarTabuleiro(jogada);

	            if(tabuleiro.vitoria()) {
	                System.out.println("Você perdeu!!!");
	                break;
	            }
	            
	            /*System.out.printf("\nAperte 's' para jogar o dado: \n");
	            opcao = in.nextLine();
	            
	            if(!opcao.equals("s")) break;
	            */
	            
	            jogadaDado = tabuleiro.jogarDado();
	            tabuleiro.andarCasas(jogadaDado, ip);
	            
	            saidaServidor.writeBytes(jogada+"\n");
	            
	            if(tabuleiro.vitoria()) {
	                System.out.println("Você venceu!!!");
	                break;
	            }
	        }
	        
	        entradaServidor.close();
	        saidaServidor.close();
	        socketCliente.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}