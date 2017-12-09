package com.network.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class BlockingServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BlockingServer server = new BlockingServer();
		server.run();
	}
	
	public void run() throws IOException{
		// Create server socket
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("Listening...");
		
		while(true){
			
			Socket socket = serverSocket.accept();
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("Client conected!! ["+isa+"]");
			
			// Create write object
			OutputStream out = socket.getOutputStream();
			// Create read object
			InputStream in = socket.getInputStream();
			
			byte[] b = new byte[1024];
			while(in.read(b) != -1){
				int read = in.read(b);
				String output = new String(b , 0 , read , "UTF-8");
				System.out.println(output);
				
			}
			
			
		}
		
	}

}
