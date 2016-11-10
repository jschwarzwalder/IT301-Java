package edu.greenriver.it.timeserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer
{
	public static final int PORT = 8000;
	
	public static void main(String[] args)
	{
		try (ServerSocket server = new ServerSocket(PORT))
		{
			System.out.println("Server started...");
			
			//continue to respond to clients...
			while (true)
			{
				Socket client = server.accept();
				
				//start a new thread to handle the request
				new Thread(new Runnable() {
					public void run()
					{
						handleIt(client);
					}
				}).start();
			}
		} 
		catch (IOException e)
		{
			System.out.println("Problem with server: " + e.getMessage());
		}
	}
	
	public static void handleIt(Socket client)
	{
		try
		{
			PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);
			sendToClient.println(System.currentTimeMillis()); //send timestamp
			
			//clean up our resources...
			sendToClient.close();
			client.close();
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
