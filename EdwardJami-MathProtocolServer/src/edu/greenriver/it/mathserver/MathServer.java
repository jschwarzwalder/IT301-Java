package edu.greenriver.it.mathserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer extends Thread {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9001)) {
			System.out.println("Server started");

			Socket client = server.accept();

			new Thread(new Runnable() {
				public void run() {
					handleIt(client);
				}
			}).start();
		} catch (IOException exc) {
			System.out.println(exc.getMessage());
		}
	}

	public static void handleIt(Socket client) {
		try {
			// Read from and write to the client
			BufferedReader getFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);

			String line;
			int num1 = 0;
			int num2 = 0;
			int sum = 0;
			int diff = 0;
			int prod = 0;
			int quot = 0;
			int mod = 0;
			
			
			while ((line = getFromClient.readLine()) != null) {
				try{
					String[] lineParts = line.split(" ");
					
					if(lineParts.length != 2){
						sendToClient.println("Math protocol expects: <num1> <num2>");
					}
					
					else{
						num1 = Integer.parseInt(lineParts[0]);
						num2 = Integer.parseInt(lineParts[1]);
						
						sum = num1 + num2;
						diff = num1 - num2;
						prod = num1 * num2;
						quot = num1 / num2;
						mod = num1 % num2;
						
						sendToClient.println(sum + " =  " + num1 + " + " + num2);
						sendToClient.println(diff + " = " + num1 + " - " + num2);
						sendToClient.println(prod + " = " + num1 + " * " + num2);
						sendToClient.println(quot + " = " + num1 + " / " + num2);
						sendToClient.println(mod + " = " + num1 + " % " + num2);
					}
				}
				
				catch(NumberFormatException exc){
					sendToClient.println("Math protocol expects: <num1> <num2>");
				}
				
				catch(NullPointerException exc){
					sendToClient.println("Math protocol expects: <num1> <num2>");
				}
				
				catch(ArrayIndexOutOfBoundsException exc){
					sendToClient.println("Math protocol expects: <num1> <num2>");
				}
			}

			getFromClient.close();
			sendToClient.close();
			client.close();
		}

		catch (IOException exc) {
			System.out.println(exc.getMessage());
		}
	}
}
