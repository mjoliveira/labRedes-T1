package server;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

   public static void main(String[] args) {

       String clientSentence;
       String capitalized;
  
       try {
 
           // Cria um SocketServer (Socket caracteristico de um servidor)
           ServerSocket socket = new ServerSocket(1025);
   
           while(true) {    
    
               /* Cria um objeto Socket, mas passando informacoes caracteristicas de um servidor,
                *no qual somente abre uma porta e aguarda a conexao de um cliente 
                */
               Socket connectionSocket = socket.accept();
    
               // Cria uma buffer que ira armazenar as informacoes enviadas pelo cliente
               BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    
               // Cria uma stream de saida para retorno das informacoes ao cliente
               DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    
               // Faz a leitura das informacoes enviadas pelo cliente as amazenam na variavel "clientSentence"
               clientSentence = inFromClient.readLine();
    
               /* Faz uma modificacao na String enviada pelo cliente, simulando um processamento em "back-end"
                * antes de retorna-la ao cliente
                */
               capitalized = clientSentence.toUpperCase() + "\n";
    
               // Imprime a a String modificada no console do servidor
               System.out.println(capitalized);
    
               // Retorna as informacoes modificadas, ao cliente
               outToClient.writeBytes(capitalized);    
           } 
      
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }  
   }
}