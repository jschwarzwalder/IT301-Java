package edu.greenriver.it.sychronization;

public class SharedData {
	private int count;
	
	public SharedData(){
		
	}
	
	public void increment(){
		count++;
	}

	public int getCount() {
		return count;
	}
	
	
}
