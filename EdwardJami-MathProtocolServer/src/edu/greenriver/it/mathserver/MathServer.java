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
				
			while ((line = getFromClient.readLine()) != null) {
				try{
					String[] lineParts = line.split(" ");
					
					if(lineParts.length != 2){
						sendToClient.println("Math protocol expects: <num1> <num2>");
					}
					
					else{
						int num1 = Integer.parseInt(lineParts[0]);
						int num2 = Integer.parseInt(lineParts[1]);
						
						int add = num1 + num2;
						int subtract = num1 - num2;
						int multiply = num1 * num2;
						int divide = 0;
						int remainder = 0;
						if (num2 != 0){
							divide = num1 / num2;
							remainder = num1 % num2;
						} 
							
						
						
						sendToClient.println( num1 + " + " + num2 + " = " + add);							
						sendToClient.println( num1 + " - " + num2 + " = " + subtract);
						sendToClient.println( num1 + " * " + num2 + " = " + multiply);
						if (num2 != 0){
						sendToClient.println( num1 + " / " + num2 + " = " + divide);
						sendToClient.println( num1 + " % " + num2 + " = " + remainder);
						} else {
							sendToClient.println("You cannot divide by 0");
						}
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
