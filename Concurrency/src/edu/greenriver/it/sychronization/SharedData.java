package edu.greenriver.it.sychronization;

public class SharedData {
	private int count;
	
	public SharedData(){
		
	}
	
	public void increment(){
		synchronized (this){
			count++; //alter our data
		}
	}

	public int getCount() {
		return count;
	}
	
	
}
