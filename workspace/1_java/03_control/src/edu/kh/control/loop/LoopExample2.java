package edu.kh.control.loop;

import java.util.Scanner;

public class LoopExample2 {
	
	public void ex1() {
		//구구단 2단 출력하기
		
		for(int i = 1 ; i < 10 ; i ++) {
			System.out.printf("2 x %d = %d\n", i, 2 * i);
		}
	}

	public void ex2() {
		// 입력 받은 단 출력하기
		
		// [실행 화면]
		// 단 입력 : 3

		// [구구단 3단]
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ...
		// 3 x 9 = 27
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		System.out.println("[구구단 " + dan + "단]");

		for(int i = 1 ; i <= 9 ; i ++) {
			System.out.printf("%d x %d = %d\n", dan, i, i * dan);
		}
	
	}
		
	public void ex3() {
		// 입력 받은 단 출력하기
		// 단, 입력 받은 값이 2~9 사이 일때만 구구단 출력
		// 2~9 사이가 아닐 경우 "잘못 입력하셨습니다." 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();

		if(2 <= dan && dan <= 9) {

			System.out.println("[구구단 " + dan + "단]");

			for(int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, i * dan);
			}
			
		} else {
			System.out.println("잘못 입력 하셨습니다.");
		}
		
		
		
	}
	
	public void practice1() {
		
		// 입력 받은 단 출력하기
		
				// [실행 화면]
				// 단 입력 : 3

				// [구구단 3단]
				// 3 x 1 = 3
				// 3 x 2 = 6
				// ...
				// 3 x 9 = 27
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단 입력 : ");
		int dan= sc.nextInt();
		
		for(int i = 1;i <=9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan * i);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
