package com.network.socket.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BlockingThreadServer {

	public static final int PORT = 8888;
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try {
					Socket socket = server.accept();
					BlokingServer blockingServer = new BlokingServer(socket);
					blockingServer.start();
				} catch (Exception e) {
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}

class BlokingServer extends Thread{
	
	private Socket socket;
	
	public BlokingServer(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		System.out.println();
		System.out.println("["+Thread.currentThread().getName()+"] Server Started!!");
		try {
				
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("Client conected!! ["+isa+"]");
			
			// Create write object
			Writer out = new OutputStreamWriter(socket.getOutputStream());
			// Client 다중 접속 테스트하기 위해 잠깐 쉰다.
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(1000);
			}
			System.out.println();
			
			out.write(LocalDateTime.now().toString());
			out.flush();
				
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
