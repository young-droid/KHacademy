package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);	

		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if(input >= 1) {
			for(int i=1; i <= input ; i++) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요. ");
		}

	}

	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input >= 1) {
			for(int i=input; i >= 1 ; i--) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();

		int sum = 0;
		
		if(input >= 1) {
			for(int i = 1 ; i <= input ; i++) {
				sum += i;
				System.out.print(i + " ");			
			}
			System.out.printf("= %d", sum);
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
	}

	public void practice3_cs() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");

		int num = sc.nextInt();
		int k = 1;
		if (num < 1) k=-1;

		int sum = 0;

		for (int i = 1; i*k<=num*k; i+=k) {
			System.out.print(i);
			sum += i;
			if (i!=num) System.out.print(" + ");
		}

		System.out.println(" = "+sum);

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int input2 = sc.nextInt();

		// 입력 받은 두 수가 모두 1 이상인가?
		if(input1 >= 1 && input2 >= 1) {
			if(input1 > input2) {
				int temp = input1;
				input1 = input2;
				input2 = temp; 
			}
			for( ; input1 <= input2 ; input1++) {
					System.out.print(input1 + " ");
				
			}
			
		}		
		
		/*
		if(input1 <= 0 || input2 <= 0) {
		System.out.println("1 이상의 숫자를 입력해주세요.");
	} else if (input1 > input2) {
		for( ; input2 <= input1 ; input2++) {
			System.out.print(input2 + " ");
		}
	} else {
		for( ; input1 <= input2 ; input1++) {
			System.out.print(input1 + " ");
		}
	}
	*/
	}
		
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		if(2 <= dan && dan <= 9) {
			System.out.printf("===== %d단 =====\n", dan);
			for(int i = 1 ; i <= 9 ; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
		} else {
			System.out.println("2부터 9 사이 숫자를 입력하세요.");
		}
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();	

		if(2 <= dan && dan <= 9) {

			for(int x = dan ; x <= 9 ; x++) {
				System.out.printf("===== %d단 =====\n", x);
				for(int i = 1 ; i <= 9 ; i++) {
					System.out.printf("%d * %d = %d\n", x, i, x * i);
				}
				System.out.println();
			} 
		}
		else {
			System.out.println("2~9 사이 숫자를 입력하세요.");
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		// 4	*
		// 3 	**
		// 2	***
		// 1	****
		

		System.out.print("정수 입력 : ");
		int x = sc.nextInt();	//4
		
		
		for(int n = 1 ; n <= x ; n++) { // 4번 반복
			for(int i = 1; i <= n; i++) {
				System.out.print("*");
			}
			System.out.println();}
		}
			  
			 
			
//		for( ; x >= 1 ; x--) { // 몇번 반복? 
	
	
	
	
	
	
	
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		// 4	****
		// 3 	***
		// 2	**
		// 1	*

		
		System.out.print("정수 입력 : ");
		int x = sc.nextInt();	//4
		
		
		for( ; x >= 1 ; x--) { // 몇번 반복? 
			for(int i = x ; i >= 1 ; i--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);

		// 4	   *
		// 3 	  **
		// 2	 ***
		// 1	****
		
		System.out.print("9. 정수 입력 : ");
		int input = sc.nextInt();	
		
		for(int x = 1 ; x <= input ; x++) { // 1~x번 반복
//		
//			// * 1개 출력 전에 띄어쓰기 3번
//			// * 2개 출력 전에 띄어쓰기 2번
//			// * 3개 출력 전에 띄어쓰기 1번
//			// * 4개 출력 전에 띄어쓰기 0번
//			
//			 
////			for(int i = input; i >= x; i--)
//			for(int i = 1 ; i <= input-x ; i++)
//			System.out.print(" ");
//			 
//			for(int i = 1 ; i <= x ; i++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		 
		// 2) for + if else
			for(int i=1 ; i<=input; i++) {
				if(i <= input - x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	public void practice10() {

		Scanner sc = new Scanner(System.in);	

		System.out.print("10. 정수 입력 : ");		
		int input = sc.nextInt();	
		
		// 정수입력 : 3
		// 1	*
		// 2 	**
		// 3	***
		// 4	**
		// 5	*
	
		for(int x = 1 ; x <= input ; x++ ) { // 일단 input 만큼 반복 개행
			for(int i = 1 ; i <= x; i++ ) { // 별 갯수
				System.out.print("*");
			}
			System.out.println();
		} 
		for(int y = input-1 ; y >= 1 ; y--) { 
			for(int i = y ; i >= 1; i--) {
				System.out.print("*");
			} 
			System.out.println();
		}
			
	}			
				 
	public void practice11() {
	 	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("홀수 입력 : ");
		int input = sc.nextInt();
		
		// 정수 입력 : 4
		//    *   
		//   ***  
		//  ***** 
		// *******
		

		for(int x = 1 ; x <= input ; x++) { // 일단 input 만큼 출력
			for(int i = 1; i <= input ; i++) {
				
			}
			System.out.println();
		}	 

		 
		for(int x = input ; x >= 1 ; x--) {
			if(x % 2 != 0) {
				for(int i = 1; i <= x ; i++) {
					System.out.print("*");
				}
				System.out.println();
			}	 
		}


		// for문 끝

		
		
	}
	
}

