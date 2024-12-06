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

	
	
	// 중첩 반복문
	// 구구단 모두 출력 하기
	public void ex4() {
		
		for(int dan = 2; dan <= 9 ; dan ++) { // 2단 ~ 9단
			System.out.printf("[%d단]\n",dan);
			
			for(int num = 1 ; num <= 9 ; num++) { // 각 단에 곱해질 수 1~9까지
												  // 차례대로 증가
				System.out.printf("%3d x %d = %2d", dan, num, dan * num);
			}	
			System.out.println();
		}
		
		
		
	}
	
	public void ex5() {
		
		for(int dan = 9; dan >= 2; dan --) {
			System.out.printf("[%d단]\n",dan);
			
			for(int num = 1 ; num <= 9 ; num++ ) {
				System.out.printf("%-2d x %2d = %2d",dan, num, dan*num);
			}
			System.out.println();			
		}
		
	}
	
	public void ex6() {

		for(int i = 1; i <= 5; i ++) {
			for(int n = 1 ; n <=5 ; n++) {
				System.out.printf("%d",n);
			}
			System.out.println();
		}
		
	}
	
	
	public void ex7() {

		for(int i = 1 ; i <= 4 ; i++) {
			for(int n = 4 ; n >= 1 ; n--) {
				System.out.printf("%d",n);
			}
			System.out.println();
		}
	}
	
	public void ex8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		if(input == 2) {
			for(int dan = 9 ; dan >= 2 ; dan --) {
				System.out.printf("\n[%d단]\n",dan);
				
				for(int i = 1 ; i <= 9 ; i ++) {
					System.out.printf("%d x %d = %d\n",dan, i , dan * i);
				}
				System.out.println("----------------");
			}
		} else if (input == 1){
			for(int dan = 2 ; dan <= 9 ; dan ++) {
				System.out.printf("\n[%d단]\n",dan);
				for(int i = 1 ; i <= 9 ; i ++) {
					System.out.printf("%d x %d = %d\n",dan, i , dan * i);
				}
			}
		} else {
			System.out.println("잘못 입력하셨습니다. ");
		}

	}
	

	public void ex8_switch() {

		Scanner sc = new Scanner(System.in);

		System.out.print("입력 : ");
		int input = sc.nextInt();


		switch(input) {
		case 1 : 
			for(int dan = 9 ; dan >= 2 ; dan --) {
				for(int i = 1 ; i <= 9 ; i ++) {
					System.out.printf("%d x %d = %d\n",dan, i , dan * i);
				}
			}
			; break ; 
		case 2 : 
			for(int dan = 2 ; dan <= 9 ; dan ++) {
				for(int i = 1 ; i <= 9 ; i ++) {
					System.out.printf("%d x %d = %d\n",dan, i , dan * i);
				}
			}
			; break ; 
		default : 
			System.out.println("잘못 입력하셨습니다.");
		
		}
		
	}

	public void ex9() {
		// 2중 for문을 이용하여 다음 모양을 출력하시오. 
		
		//1
		//12
		//123
		//1234
		
		
		for(int x = 1 ; x <= 4 ; x++) { // 4번 반복
			for(int i = 1; i <= x; i++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		// x가 1일 때 i == 1
		// x가 2일 때 i == 1,2
		// x가 3일 때 i == 1,2,3
		// x가 4일 때 i == 1,2,3,4
		
	}
	
	public void ex10() {
		//4321
		//321
		//21
		//1
		
		for(int x = 4 ; x >= 1 ; x--) { // x 가 4 부터 1 될 때 까지 4 3 2 1 총 4번 출력 
			for(int i = x ; i >= 1 ; i--) { // i 가 4 
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public void ex11() {
		// 1  2  3  4
		// 5  6  7  8
		// 9 10 11 12 
		
		int count = 1;
		
		for(int x = 1 ; x <= 3 ; x++) { // 줄 갯수 (횟수)
			for(int i = 1 ; i <= 4 ; i ++) { // 숫자 개수
				System.out.printf("%3d", count++); // 후위연산 
			}
			System.out.println();
		}
	}
	
	
	
	// ****************************************************************************//
	public void ex12() {
		// (0,0) (0,1) (0,2)
		// (1,0) (1,1) (1,2)
		
		for(int x=0 ; x<=1 ; x++) {
			for(int i=0 ; i<=2 ; i++) {
				System.out.printf("(%d,%d)",x,i);
			}
			System.out.println();
		}
	}
	// ****************************************************************************//
	
	public void ex13() {
		// 1부터 20까지 1씩 증가하면서
		// 3의 배수의 총 개수와 합계 출력
		
		// 3 6 9 12 15 18 : 6개
		// 3의 배수의 합계 : 63
		
		int count = 0;
		int sum = 0;
		
		for(int i = 1 ; i <= 20 ; i++) {
			if (i % 3 == 0) {
				System.out.printf("%d ",i);
				count++;
				sum += i;
			}
		}
		System.out.printf(": %d개\n", count);
		
		System.out.printf("3의 배수의 합계 : %d", sum);
	}

	
	public void ex14() {
		// 행/열의 크기를 입력 받아 출력하시오
		// 행 : 2
		// 열 : 3

		// 1 2 3
		// 4 5 6
		
	
		// 초기식, 조건식, 증감식은 상황에 따라서 작성하지 않을 수 있다. 		
		// for( ; ; ){} --> 무한루프(조건문 X -> false 안됨 -> 종료 X)
		
		// 초기식 안쓰면 : 
		// for(; row >= 1 ; row--) // 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 입력 : ");
		int col = sc.nextInt();

		int count = 0; // 출력 숫자 row * column
		
//		for(int r = 1 ; r <= row ; r++) { // 행 갯수
			for(; row >= 1 ; row--) { // 행 갯수

			for(int c = 1 ; c <= col ; c++) { // 열 갯수
//				for(; col >= 1 ; col--) { // 열 갯수
				System.out.print(++count + " ");
			}
			System.out.println();
		}
		
	}
	
}