package edu.kh.thread.ex3;

public class MoveHeart implements Runnable{

	@Override
	public void run() {

		try {
			for(int i=0; i<9; i++) {
				
				// 한 페이지에 나오듯 공백 띄워주기 용
				for(int a=0; a<30; a++) System.out.println(); 
				
				// i 이하 만큼 반복하면서 한칸 띄어쓰기
				for(int h=0; h <= i; h++) System.out.print(" ");
				System.out.println("♡");
				
				// i 미만 까지 반복하면서 한 칸 띄어쓰기
				for(int s=0; s<i ; s++) System.out.print(" ");
				System.out.print("★");
				
				Thread.sleep(1000); // 1초 일시정지
				
			}
		}catch(InterruptedException e) {
			
		}
		
	}

	
	
}
