package edu.greenriver.it.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient
{
	public static void main(String[] args)
	{
		try (Socket server = new Socket(InetAddress.getByName("localhost"), 8000))
		{
			//I need to write (PrintWriter) and read from (BufferedReader) the server
			PrintWriter sendToServer = new PrintWriter(server.getOutputStream(), true);
			BufferedReader receiveFromServer = new BufferedReader(
					new InputStreamReader(server.getInputStream()));
			
			//send text to echo server
			Scanner console = new Scanner(System.in);
			System.out.print("Enter text: ");
			sendToServer.println(console.nextLine());
			
			//get text back from echo server
			String line;
			while ((line = receiveFromServer.readLine()) != null)
			{
				System.out.println(line);
			}
			
			//close connections
			sendToServer.close();
			receiveFromServer.close();
			server.close();
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
