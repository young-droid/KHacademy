package edu.kh.control.loop;

import java.util.Scanner;

public class LoopExample1 {
	
	
	/* for문
	 * - 끝이 정해져 있는(횟수가 지정되어 있는) 반복문
	 * 
	 * [작성법]
	 * for(초기식; 조건식; 증감식) {
	 * 		조건이 true일 경우 반복 수행할 코드;
	 * }
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수 선언
	 *  
	 * - 조건식 : for문의 반복 여부를 지정하는 식
	 *  		 보통 초기식에 사용된 변수를 아용하여 조건식을 작성함 
	 *  
	 * - 증감식 : 초기식에 사용된 변수를 for문이 끝날 때 마다 증가 또는 감소 시켜 조건식의 결과를 변하게 하는 식
	 * 
	 */
	
	// for 예제 1 - 안녕하세요 10번 출력하기
	public void ex1() {
		// 초기식 ; 조건식 ; 증감식
		for (int i = 1; i <= 10; i++) {
			System.out.println("안녕하세요");
		}
		
		// * for문 해석 순서 *
		// 1) 초기식 (반복을 세는 용도의 변수)
		// 2) 조건식 (조건식 = true; 초기식에 사용된 변수의 값에 따라 반복 여부 결정)
		// 3) for문 내부 코드 
		// 4) 증감식 (초기식 변수의 값을 변화) 
		// 2) ~ 4) 반복 (조건식이 false일 때 까지 반복)
		// 5) 조건식 = false -> for문 종료 
	} // ex1 끝
		
	public void ex2() {
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			
		}
		
		
	}
	
	public void ex3() {
		// 3 부터 7 까지 출력
		for(int i = 3; i <= 7; i++) {
			System.out.println(i);
		}
			
	}
	
	public void ex4() {
		// 2 부터 20 까지 2씩 증가하며 출력
		for (int i = 2; i <= 20; i += 2) {
			System.out.println(i);
		}
		
	}
	public void ex5() {
		// 1 부터 5 까지 0.5씩 증가하며 출력
		for (double i = 1; i <= 5; i += 0.5) {
			System.out.println(i);
		}
	}
	
	public void ex6() {
		for (char c = 'A'; c <= 'Z'; c += 1) {
			System.out.print(c);
		}
		System.out.println("\n----------------------------");
		for (char c = 65; c <= 90; c += 1) {
			System.out.print(c);
		}
		System.out.println("\n----------------------------");
		for (int i = 'A'; i <= 'Z'; i += 1) {
			System.out.print((char)i);
		}
	
	}
	
	
	public void ex7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= input; i ++) {
			System.out.println(i);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ex8() {
		// 1 부터 4 까지 정수의 합 구하기
		
		int result = 0; 
		
		for (int i = 1; i <= 4; i++) {
			result += i; 	// 1
							// 3 
							// 6
							// 10
								
		}
		System.out.println("합계 : " + result);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ex9cs() {
	      Scanner sc = new Scanner(System.in);

	      int num = sc.nextInt();
	      
	      int start = 50;
	      
	      if (num<start) {
	         start = num;
	         num = 50;

	      }

	      int ans = 0;
	      
	      for (int i = start; i <= num; i++) {
	         ans += i;
	      }
	      System.out.printf("%d부터 %d까지의 합 : %d", start, num, ans);

	   }
	
	
	public void ex9() { 
		// 50부터 입력받은 수 까지 모든 정수의 합 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		int sum = 0; 
		
		
		if(input >= 50) { 
			for(int i = 50; i <= input ; i ++){
				sum += i; //sum에 i값 누적
			} 
		} 
		else {
			for(int i = 50; i >= input ; i --){
				sum += i;
			}
		}
		
		System.out.println(sum);
		
		}
		
	
	public void ex10() {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1 ; i <= 5 ; i ++ ) {
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			sum += input;
		}

//		System.out.println(input);
		// {} 안에서 생성된 변수는 {} 밖에서 사용 X
		// -> {} 끝나는 시점에 사라지기 때문에 
		
		System.out.printf("합계 : %d", sum);
		
	}
	
	public void ex11() {
		
		System.out.println("[예제 11]");
		// 정수를 몇 번 입력 받을지 먼저 입력 받고
		// 입력된 정수의 합계를 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 받을 횟수 : ");
		int count = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1 ; i <= count ; i++) {
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();			
			sum += input;
		}
		
		System.out.println("합계 : " + sum);
	}
	
	public void ex12() {
		// 시작, 끝, 증가할 수를 입력 받아
		// 지정된 범위까지 모두 출력 후 합계도 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 : ");
		int start = sc.nextInt();
		System.out.print("끝 : ");
		int end = sc.nextInt();
		System.out.print("증가할 수 : ");
		int add = sc.nextInt();
		
		int sum = 0;
		
		for(int i = start ; i <= end ; i += add) {
			
			sum += i;
			
			System.out.print(i + " ");
			
		}
		
		System.out.printf("\n합계 : %d", sum);
	}
	
	public void ex13() {
		// 1부터 10까지 모든 정수 출력
		// 단, 짝수는 [] 감싸서 출력
		
		for(int i = 1; i <= 10 ; i ++) {
			if(i % 2 == 0) {
				System.out.printf("[%d] ", i);
			} else
				System.out.printf("%d ", i);
		}
	}
	
	public void ex14() {
		// 1부터 10까지 모든 정수 출력
		// 단, 홀수는 () 감싸서 출력
		// + 1은 "시작" 10은 "끝" 이라고 출력
		
		System.out.print("시작 ");
		
		for(int i = 2; i <= 9; i++) {
			if (i % 2 != 0) {
				System.out.printf("(%d) ", i);
			} else {
				System.out.printf("%d ", i);
			}
		}
		
		System.out.print("끝");
		
		/*
		for(int i = 1; i <= 10; i++) {
			if(i == 1) {
				System.out.print("시작 ");
			} else if(i == 10) {
				System.out.print("끝");
			} else if (i % 2 != 0) {
				System.out.printf("(%d) ", i);
			} else {
				System.out.printf("%d ", i);
			}
		}
		*/
	} // ex14 end

	public void ex15() {
		// 1~100 사이 수 중 입력 받은 수의 배수를 뺀 나머지 수의 합을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제외할 배수 입력 : ");
		int num = sc.nextInt();
		int n;
		
		int sum1 = 0;
		
		for(n = num ; n < 101 ; n += num) {
			
			sum1 += n;
		}
		
		int sum2 = 0;
		
		for(int i = 1 ; i <= 100 ; i++) {
			if(i != n) {
			}
			
		}
		
		System.out.println(sum2 - sum1);
		
		
	}

	public void ex15_answer() {
		// 1~100 사이 수 중 입력 받은 수의 배수를 뺀 나머지 수의 합을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제외할 배수 입력 : ");
		int num = sc.nextInt();
		
		int sum = 0;

		int c;

		for(int i=1; i<=100; i++) {
			if(i % num != 0) {
				sum += i;
			}
		}
		
		System.out.println("합계 : " + sum);
		
		
	}

	
	
	public void ex15_practice() {
		// 1~100 사이 수 중 입력 받은 수의 배수를 뺀 나머지 수의 합을 출력
		Scanner sc = new Scanner(System.in);

		System.out.println("입력 받을 수 :");
		int input = sc.nextInt();
		int sum = 0;

		for(int i = 1; i<=100; i++) {
			if(i % input != 0) {
				sum += i;
			} 
		}
		System.out.print("합 : " + sum);

	
	
	//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("num 입력 : ");
//		int num = sc.nextInt(); // num 의 배수
//		
//		for(num = 1 ; num <= 100 ; num += num) {
//			System.out.println(num);
//		}
//		
//		
////		
////		
////		for(int i = 1; i <= 100 ; i++) {
////			
////		}
////		
////		
//		
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	





//
//System.out.print("제외할 배수 입력 : ");
//int num = sc.nextInt();
//int n;
//
//int sum1 = 0;
//
//for(n = num ; n < 101 ; n += num) {
//	
//	sum1 += n;
//}
//
//int sum2 = 0;
//
//for(int i = 1 ; i <= 100 ; i++) {
//	if(i != n) {
//	}
//	
//}
//
//System.out.println(sum2 - sum1);
//



