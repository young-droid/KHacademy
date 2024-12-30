package edu.kh.thread.ex2;

// 스레드 생성(Runnable 인터페이스 상속)
public class SleepThread1 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 실행");
		
		for(int i=1; i<=10; i++) {
			// Thread.sleep(long millis)
			// - 현재 스레드를 지정된 시간만큼 일시정지
			// - 시간은 1/1000초 단위(ms)로 지정
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i + "초");
			
			
			
		}
		
		
	}
	
	

	
	
}
