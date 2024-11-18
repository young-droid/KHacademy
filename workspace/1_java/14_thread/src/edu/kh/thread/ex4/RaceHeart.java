package edu.kh.thread.ex4;

import java.util.Random;

public class RaceHeart implements Runnable{

	@Override
	public void run() {

		Random rand = new Random();

		try {
			for(int i=0; i<=10; i++) {
				RaceRun.clear();

				if(i==0) { // 첫번째 반복인 경우
					System.out.println("시작! ");
					System.out.println("♡");
					System.out.print("★");
					
					Thread.sleep(1000);
					continue; // 다음 반복으로 이동
				}
				
				// i가 1~10인 경우
				System.out.println(i + "회차");
				
				// temp || tmp == 임시 변수
				int temp = rand.nextInt(5)+1;
				
				// 생성된 난수를 heartCount에 누적
				RaceRun.heartCount += temp;
				
				// "♡ (난수)칸 이동" 출력
				System.out.println("♡ (" + temp + ")칸 이동");
				
				
				// heartCount 누적된 숫자 만큼 - 표시 후 하트
				for(int h=0; h<RaceRun.heartCount ; h++) {
					System.out.print("-");
				}
				System.out.println("♡");
				
				// starCount 만큼 - 표시 후 ★ 출력
				for(int h=0; h<RaceRun.starCount ; h++) {
					System.out.print("-");
				}
				System.out.print("★");

				Thread.sleep(1000);
			}

		}catch(InterruptedException e) {
			Thread.currentThread().interrupt(); // ???????????????? 왜 작성한건지 물어보기
		}

	}



}
