package edu.greenriver.it.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
	public static void main(String[] args)
	{
		try (ServerSocket server = new ServerSocket(8000))
		{
			System.out.println("Server started on port 8000");
			
			Socket client = server.accept();
			
			new Thread(new Runnable() {
				public void run()
				{
					handleIt(client);
				}
			}).start();
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void handleIt(Socket client)
	{
		try 
		{
			//I need to read from (BufferedReader) and write to (PrintWriter) the client 
			BufferedReader receiveFromClient = new BufferedReader(
					new InputStreamReader(client.getInputStream())); 
			PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);
			
			//receive whatever the client sends and sent it back!
			String line;
			while ((line = receiveFromClient.readLine()) != null)
			{
				sendToClient.println(line);
			}
			
			//close connections
			sendToClient.close();
			receiveFromClient.close();
			client.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
