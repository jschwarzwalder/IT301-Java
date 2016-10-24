package edu.greenriver.it.sychronization;

public class AnotherSynchronizationProblem {
	
	public static void main(String[] args){
		//start a few threads
		getPrintingThread(new String[] {"fifth element", "gladior", 
				"kiki's delivery service", "star wars", "ever after", "sharknado"}).start();
		getPrintingThread(new String[] {"star trek", "flash", 
				"stargate", "walking dead", "orphan black", "Doctor Who"}).start();
	}
	
	public static Thread getPrintingThread(String[] things){
		return new Thread(new Runnable(){
			public void run(){
				for (int i = 0; i< things.length; i++){
					synchronized (System.out){
						System.out.print("<<");
						System.out.print(things[i]);
						System.out.println(">>");
					}
				}
			}
		});
	}

}
