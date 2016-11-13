package edu.greenriver.it.clientserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	private static final int PORT = 8000;
	
	public static void main(String[] args)
	{
		//start a new server with sockets
		try (ServerSocket server = new ServerSocket(PORT))
		{
			System.out.println("The server started...");
			
			//listen to client requests
			Socket client = server.accept();
			
			//to read or write to the client, use PrintWriter, BufferedReader
			//(true here means "auto-flush")
			PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);
			sendToClient.println("Hello world!");
		} 
		catch (IOException e)
		{
			System.out.println("Problem with server: " + e.getMessage());
		}
	}
}
