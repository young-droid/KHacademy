package edu.kh.thread.ex1;

// 스레드 생성 방법 1 : Thread 클래스 상속

// 장점 : 해당 스레드를 생성하는 구문이 조금 짧음
// 단점 : run() 메소드가 추상 메소드가 아니여서 강제 오버라이딩 X 

public class TestThread1 extends Thread {

	@Override
	public void run() {
		// run() 메소드 
		// 스레드가 생성되어 실행(start()) 시 수행될 구문을 작성하는 메소드
		
		System.out.println(Thread.currentThread().getName() + " 실행");
	
		for(int i=0 ; i < 10; i++) {
			System.out.println("0번 스레드" + i);
		}
		
	} 
	
}