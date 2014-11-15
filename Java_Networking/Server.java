//package org.xavier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private static int port = 3700;
	
	public static void main (String... args)
	{
		try
		{
			@SuppressWarnings("resource")
			ServerSocket sSocket = new ServerSocket(port);
			System.out.println("Server Up");
			while(true)
			{
				Socket client_Socket = sSocket.accept();
				(new Thread( new HandleClient(client_Socket))).start();
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
