package edu.kh.thread.ex3;

public class MoveRun {
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new MoveHeart());
		Thread th2 = new Thread(new MoveStar());
		
		try {
			th2.start();
			Thread.sleep(500);
			th1.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// th1, th2의 실행 시간 사이에 0.5 차이를 줌
		
		
	}
}
