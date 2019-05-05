package client;

//Le uma linha do teclado e envia o pacote (linha digitada com o nickName) ao servidor

import java.io.*; // Classes para input e output streams
import java.net.*;

class TCPClient {

	static DatagramSocket socketServidor;
	public static void main(String args[]) throws Exception {
		
		// Cria o stream do teclado
		BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(System.in));

		// Declara socket cliente
		DatagramSocket socketCliente = new DatagramSocket();
		TCPClient.socketServidor = socketCliente;
		ouvir();
		
		// Obtem endereco IP do servidor com o DNS
		InetAddress ipServidor = InetAddress.getByName("192.168.25.5");

		byte[] enviarDado = new byte[1024];
		byte[] recebeDado = new byte[1024];

		while (true) {
			// Le uma linha do teclado 
			String nickName = entradaServidor.readLine();
			if (nickName.length() == 0) {
				break;
			}
			enviarDado = nickName.getBytes();
	
			// Cria pacote com o dado, o endereco do server e  porta do servidor
			DatagramPacket enviaPacote = new DatagramPacket(enviarDado, enviarDado.length, ipServidor, 9876);
	
			// Envia o pacote
			socketCliente.send(enviaPacote);

			nickName = "";
		}
		
		// Fecha o cliente
		socketCliente.close();
		
	}
	
	static void ouvir() throws Exception {
		
		MinhaThread thread = new MinhaThread(socketServidor);
		thread.start();
		
	}
}


 class MinhaThread extends Thread {
	 	
	 DatagramSocket socketServidor;
	    
	   MinhaThread(DatagramSocket socketServidor) {
			this.socketServidor = socketServidor;
	   } 
	 

	   public void run () {
				
			byte[] recebeDados = new byte[1024];
			while (true) {
				
				recebeDados = new byte[1024];
				
				DatagramPacket recebePacote = new DatagramPacket(recebeDados, recebeDados.length);
		
				// Recebe o pacote do cliente
				try {
					socketServidor.receive(recebePacote);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		
				// Pega os dados do cliente (IP e porta), para retornar as mensagens
				String nickName = new String(recebePacote.getData());
				InetAddress ip = recebePacote.getAddress();
				int port = recebePacote.getPort();
				
				System.out.println("NickName: " + nickName);
			}
	   }
 }