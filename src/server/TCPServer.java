package server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

class TCPServer {
	
	static class User {
		InetAddress ip; 
		int porta;
		
		public User(InetAddress ip, int port) {
			this.ip = ip;
			this.porta = port;
		}
	}
	
	static LinkedList<User> lista = new LinkedList<User>();
	
	static DatagramSocket socketServidor;
	
	public static void main(String args[]) throws Exception {
		
		ouvir();
	}
	
	public static void ouvir() throws Exception {
		
		// Cria socket do servidor com a porta 9876
		DatagramSocket serverSocket = new DatagramSocket(9876);
		TCPServer.socketServidor = serverSocket;
		
		byte[] recebeDado = new byte[1024];
		while (true) {
			
			recebeDado = new byte[1024];
			
			DatagramPacket recebePacote = new DatagramPacket(recebeDado, recebeDado.length);

			// Recebe o pacote do cliente
			serverSocket.receive(recebePacote);

			// Pega os dados, o endereco IP e a porta do cliente, para mandar a mensagem de volta
			String nickName = new String(recebePacote.getData());
			InetAddress ip = recebePacote.getAddress();
			int porta = recebePacote.getPort();
			

			User usuario = new User(ip, porta);
			if (lista.contains(usuario) == false) {
				lista.add(usuario);
			}
			
			atualizaUsuarios(nickName);

			System.out.println("Prota:  " + porta);
			System.out.println("NickName:  " + nickName);
		}
	}
	
	public static void atualizaUsuarios(String NickName) {
		
		lista
			.stream()
			.forEach(usuario -> {
				
				byte[] enviaDados = NickName.getBytes();
				DatagramPacket enviaPacote = new DatagramPacket(enviaDados, enviaDados.length, usuario.ip, usuario.porta);
				try {
					socketServidor.send(enviaPacote);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			});
	}
}
