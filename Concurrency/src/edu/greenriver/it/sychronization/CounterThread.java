package edu.greenriver.it.sychronization;

public class CounterThread extends Thread {
	
	private SharedData data;
	
	public CounterThread(SharedData data){
		this.data = data;
	}
	
	@Override
	public void run(){
		for (int i = 1; i <= 5; i++){
			data.increment();
		}
	}

}
