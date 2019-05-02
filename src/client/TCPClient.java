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
		String nickName = "Mayara"; // = "Mayara";
		String ip = "192.168.25.5"; // = "192.168.25.5";
		int porta = 1025; // = 1025;
		

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
	        
	        //while(true) {
	           
	        //}
	        
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