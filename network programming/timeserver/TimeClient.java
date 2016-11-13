package edu.greenriver.it.timeserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class TimeClient
{
	public static void main(String[] args)
	{
		try (Socket server = new Socket(InetAddress.getLocalHost(), TimeServer.PORT))
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
