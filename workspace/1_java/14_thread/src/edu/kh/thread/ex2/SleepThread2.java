package edu.kh.thread.ex2;

public class SleepThread2 implements Runnable{

	@Override
	public void run() {
		int count = 0;
		
		// Thread.currentThread().inInterrupted()
		// 현재 스레드의 interrupted 필드 값 반환
		// -> 수행 중이면 false, 멈춰야되면 true
		
		// interrupted 필드 값이 false이면 반복
		// true면 멈춰라
		while(!Thread.currentThread().isInterrupted()) {
			
			// 0.5초 마다 count를 1씩 증가하며 출력 
			System.out.println( count++ ); 
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				
				// sleep() 중 interrupt() 메소드가 호출되면
				// InterruptedException이 발생하고
				// interrupted 필드 값이 true로 변하지 못하게 된다! 
				// -> catch 문에서 interrupted 필드 값을 true로 변경
				
				Thread.currentThread().interrupt();
				System.out.println("=== 인터럽트에 의해서 종료 ===");
				
				
			}
			
		}
	}
	
	
	
	
	
}
