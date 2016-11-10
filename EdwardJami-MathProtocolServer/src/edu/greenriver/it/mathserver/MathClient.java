package edu.greenriver.it.mathserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MathClient extends Thread {
	public static void main(String[] args) {
		try (Socket server = new Socket(InetAddress.getByName("localhost"), 9001)) {
			PrintWriter sendToServer = new PrintWriter(server.getOutputStream(), true);
			BufferedReader getFromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));

			String nums = "10 2";
			
			//String[] numParts = nums.split(" ");
			
			sendToServer.println(nums);
			
			String line;
			
			while ((line = getFromServer.readLine()) != null){
				System.out.println(line);
			}
		}

		catch (IOException exc) {
			System.out.println(exc.getMessage());
		}
	}
}
