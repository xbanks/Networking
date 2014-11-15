// package org.xavier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandleClient implements Runnable {

	private Socket client_Socket;
	private String client_name;
	private String client_address;
	private static int client_num = 0;
	private int current_client_num;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try{
			
			// Reading messages from the client
			BufferedReader in = 
					new BufferedReader(
							new InputStreamReader(client_Socket.getInputStream()));
			

			String recieved_message;
			while((recieved_message = in.readLine()) != null)
			{
				System.out.printf("%s:%d > %s\n", 
					client_address, current_client_num, recieved_message);
			}

			
			System.out.printf("[Client %d disconnected]\n", current_client_num);
			client_Socket.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
	}
	
	public HandleClient(Socket client_Socket)
	{
		this.client_Socket = client_Socket;
		this.client_address = client_Socket.getInetAddress().getHostAddress();
		
		client_num++;
		this.current_client_num = this.client_num;
		System.out.printf("[Client #%d connected.]\n", client_num);
	}

}
