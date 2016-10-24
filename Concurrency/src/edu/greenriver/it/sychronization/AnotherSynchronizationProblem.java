package edu.greenriver.it.sychronization;

public class AnotherSynchronizationProblem {
	
	public static void main(String[] args){
		//start a few threads
		getPrintingThread(new String[] {"fifth element", "gladior", 
				"kiki's delivery service", "star wars", "ever after", "sharknado"}).start();
	}
	
	public static Thread getPrintingThread(String[] things){
		return new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i< things.length; i++){
					System.out.println("<<");
					System.out.println(things[i]);
					System.out.println(">>");
				
				}
			}
		});
	}

}
