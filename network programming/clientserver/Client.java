package edu.greenriver.it.clientserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
	private static final int PORT = 8000;

	public static void main(String[] args)
	{
		//connect to server
		try (Socket server = new Socket(InetAddress.getByName("10.145.65.59"), PORT))
		{
			//read any message sent from the server...
			BufferedReader readFromServer = new BufferedReader(
					new InputStreamReader(server.getInputStream()));
			
			String line;
			while ((line = readFromServer.readLine()) != null)
			{
				System.out.println(line);
			}
		} 
		catch (Exception e)
		{
			System.out.println("Problem with client: " + e.getMessage());
		}
	}
}
