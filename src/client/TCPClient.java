package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {

		String sentence;
		String modifiedSentence;

		try {

			// Cria um buffer que armazenara as informacoes de entrada do
			// teclado
			BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));

			// Cria um Socket cliente passando como parametro o ip e a porta do
			// servidor
			Socket client = new Socket("10.32.143.65", 1025);

			// Cria um stream de saida
			DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());

			// Cria um buffer que armazenara as informacoes retornadas pelo
			// servidor
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// Atribui as informacoes armazenadas no buffer do teclado
			// variavel "sentence"
			sentence = inFromUSer.readLine();

			// Disponibiliza as informacoes contidas em "sentence" para a stream
			// de saida do cliente
			outToServer.writeBytes(sentence + "\n");

			// Atribui as informacoes modificadas pelo servidor na variavel
			// "modifiedSentence"
			modifiedSentence = inFromServer.readLine();

			// Imprime no console do cliente a informacao retornada pelo
			// servidor
			System.out.println("From Server: " + modifiedSentence);

			// Fecha o Socket
			client.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}