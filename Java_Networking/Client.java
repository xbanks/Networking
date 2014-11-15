// package org.xavier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
	private static String IP;
	private static String Name;
	private static int port = 3700;
	public static void main (String...strings)
	{

		try
		{
			Name = InetAddress.getLocalHost().getHostName();
			Socket cSocket = new Socket(Name, port);
			System.out.println("Connected to Server");

			// For sending messages to the server
			PrintWriter out = new PrintWriter( cSocket.getOutputStream(), true );
			
			// Getting messages from the server
			BufferedReader in =
					new BufferedReader(
							new InputStreamReader( cSocket.getInputStream()));

			// Reading from the Console
			BufferedReader stdin = 
					new BufferedReader(
							new InputStreamReader(System.in));

			String message_toSend;
			System.out.printf("MSG: ");
			while((message_toSend = stdin.readLine()) != null)
			{
				out.println(message_toSend);
				System.out.printf("MSG: ");
			}

			cSocket.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			System.exit(0);
		}
	}
}