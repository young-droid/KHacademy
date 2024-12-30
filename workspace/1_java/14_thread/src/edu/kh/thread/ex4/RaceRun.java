package edu.kh.thread.ex4;

import java.util.Scanner;

public class RaceRun {
	
	// 하트, 별이 움직인 거리를 타운트(띄어쓰기 횟수)
	
	// static : 정적 메모리 영역(== 공유 메모리 영역)
	// static에 생성되면 클래스명.필드명 형식으로 불러오면 어디서든 공유 가능! 
	
	public static int heartCount = 0;
	public static int starCount = 0;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new RaceHeart());
		Thread th2 = new Thread(new RaceStar());
		
		// 승패 여부 맞추기
		Scanner sc = new Scanner(System.in);
		System.out.println("<승패 여부를 예상해 보세요>");
		System.out.print("1. ♡ 승 / 2. ★ 승 / 3. 무승부 >> "); 
		int input = sc.nextInt();
		
		System.out.println("<배팅할 포인트를 입력해 주세요>");
		int point = sc.nextInt();
		
		// 승패 여부 저장할 변수
		int win = 0;
		
		try {
			th2.start();
			Thread.sleep(500);
			th1.start();
			
//			System.out.println();
//			System.out.println();
//			if(RaceRun.heartCount > RaceRun.starCount) {
//				System.out.println("♡ 승리!");
//			} else if (RaceRun.starCount > RaceRun.heartCount) {
//				System.out.println("★ 승리!");
//			} else {
//				System.out.println("비겼습니다...");
//			}
//			
			
			// Thread.join();
			// - 지정된 스레드(th1, th2)가 끝날 때 까지
			//   현재 스레드(main)를 대기 시킴
			th1.join();
			th2.join();
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		// 하트, 별 중 누가 더 멀리 이동했는가에 따라
		// 승패 여부 출력

		System.out.println("\n\n=========결과=========");

		String result = null;
		
		if(heartCount > starCount) { // 하트가 더 멀리 간 경우
			win = 1;
			result = "[♡ 승리!!]";

		} else if (starCount > heartCount) { // 별이 더 멀리 간 경우
			win = 2;
			result = "[★ 승리!!]";

		} else {
			win = 3;
			result = "[무승부]";
			
		}
		
		System.out.println(result);
		System.out.println();
		
		// 예측 성공 시
		// 무승부 예측 성공 시 포인트 4배
		// 나머지는 3배
		
		if(input == win) {
			System.out.println("예측 성공!");
			
			if(win == 3) {
				point = point * 4;
			} else {
				point = point * 3;
			}
			System.out.println(point + "포인트 획득!");
		} else {
			System.out.println("\n[포인트를 모두 잃었습니다..]");
		}
	}
	

	
	// 콘솔창 클리어(엔터 많이 하기)
	public static void clear() {
		
		// StringBuffer : String 불변성 문제를 해결한 객체
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<30; i++) {
			sb.append("\n"); // 엔터 30번 누적
							 // sb += "\n"
		}
		
		System.out.println(sb.toString()); // 엔터 30번 + 1번 출
		
	}
	
}
