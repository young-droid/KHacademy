package edu.kh.thread.ex3;

public class MoveStar implements Runnable{

	@Override
	public void run() {

		try {
			for(int i=0; i<10; i++) {

				for(int a=0; a<30; a++) System.out.println();

				for(int h=0; h<i ; h++) System.out.print(" ");
					System.out.println("♡");
				

				for(int s=0; s<i ; s++) System.out.print(" ");
					System.out.print("★");
				

				Thread.sleep(1000);
			}
		}catch (InterruptedException e) {
			
		}

	}

}
