package com.network.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientForBlockingServer {
	
	public static void main(String args[]) throws ConnectException{
		Client client = new Client();
		client.run();
	}
}

class Client{
	
	public void run() throws ConnectException{
		
		try (Socket socket = new Socket("localhost" , 8888)){
			// Set timeout 
//			socket.setSoTimeout(10000);
			
			System.out.println("Request time ["+LocalDateTime.now()+"]");
			
			StringBuilder sb = new StringBuilder();
			sb.append("Response time [");
			try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
				for(int i = br.read(); i != -1 ; i = br.read()){
					sb.append((char)i);
				}
			}; 
			sb.append("]");
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}