package edu.it.greenriver.charcount;

import java.lang.Thread;


public class StringAnalysisThread extends Thread {
	
	private String text;
	int stringLength;
	int numCount;
	int letterCount;
	int lowercase;
	int uppercase;
	
	
	public StringAnalysisThread(String text) {
		
		this.text = text;
	}
	
	@Override
	public void run(){
		
	}
	
	

}
