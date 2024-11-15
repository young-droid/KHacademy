package edu.kh.control.loop;

import java.util.Scanner;

public class LoopExample3 {

	/* while문
	 * - 반복 조건만을 설정하는 반복문으로
	 *   별도의 초기식, 증감식이 존재하지 않음
	 *   
	 * - 조건식이 true인 경우에 계속 반복
	 * -> 조건식이 false가 되는 상황을 같이 구현해야 함
	 * 
	 * 
	 * [작성법]
	 * while(조건식) { 
	 * 조건식이 true일 때 수행할 구문;
	 * (+ 조건식이 특정 상황에서 false가 되도록 하는 구문도 같이 작성
	 * 		-> 안하면 무한루프 )
	 * }
	 * 
	 */
	
	 // 숫자 0이 입력될 때 까지 프로그램 종료 X
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = 1;
		
		while(input != 0) {
			System.out.print("숫자를 입력해주세요 : ");
			input = sc.nextInt();
		}
	}
	
	
	public void ex1_practice() {
		Scanner sc = new Scanner(System.in);
		int input = -1;
		
		while(input != 0) {
			System.out.print("숫자 입력 : " );
			input = sc.nextInt();
		}
		System.out.println("프로그램 종료");
		
		
	}
	
	
	
	// 숫자 0이 입력될 때 까지 프로그램 종료 X
	// + 0이 입력되기 전까지 입력된 모든 숫자의 합 출력
	// "정수 입력 : "
	// "입력된 정수의 합 : "
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = 1;
		
		int sum = 0;
		
		while(input != 0) {
			System.out.println("정수 입력 : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println("입력된 정수의 합 : " + sum);
		
	}
	
	
	public void ex2_practice() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1;
		
		int sum = 0;
		
		while(input != 0) {
			
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input;
			
		}
		System.out.print("입력된 정수의 합 : " + sum);
	}
	
	
	public void ex2_practice2() {
		Scanner sc = new Scanner(System.in);
		
		int number = -1;
		
		int sum = 0;
		
		while(number != 0){
			
			System.out.println("정수 입력 : ");
			number = sc.nextInt();
			
			sum += number;
		}
		System.out.println("입력된 정수의 합 : " + sum);
	}
	
	
	
	
	
	//분식집 주문 프로그램
	//String 중첩 
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0; // 입력한 메뉴 번호를 저장할 변수
		
		String menu = ""; // 빈문자열 -> 문자열을 이어쓰기 하더라도 아무런 영향이 없는 문자열
		
		int price = 0;
		
		while(input != 9) { // 9 입력 시 조건이 false가 되어 while문 종료
			
			System.out.println("=== 메뉴 ===");
			System.out.println("1. 벌교꼬막미니김밥(14000)");
			System.out.println("2. 키토삼겹묵은지(12500)");
			System.out.println("3. 왕돈까스(14500)");
			System.out.println("9. 주문 완료");
			
			System.out.println("메뉴 선택 >>>");
			input = sc.nextInt(); // input에 메뉴번호 저장
			
			switch(input) {
			case 1 : 
				price += 14000;
				menu += "별교꼬막미니김밥 ";
				break; 
			case 2 : 
				price += 12500;
				menu += "키토삼겹묵은지 ";
				break;
			case 3 :
				price += 14500;
				menu += "왕돈까스 ";
				break; 
			case 9 : 
				System.out.println("주문 완료!");
				break; 
			default : System.out.println("<<메뉴에 작성된 번호만 눌러주세요.>>");
			}
		}
		System.out.println("주문한 메뉴 : " + menu);
			
		System.out.println("총 가격 : " + price);
	}
		
	// do - while문
	// while문의 조건식 확인 위치를 끝으로 보낸 while
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0; // 합계
		
		int input = 0; // 입력 값을 저장할 변수

		System.out.printf("%d번째 시도 :", input);
		
		// do - while : 최소 한번은 실행 
		do { //~한다 
			System.out.print("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		} while(input != 0); 	// ~ 하는 동안에 	
		
		while(input != 0) {
			System.out.print("숫자 입력 : ");
			input = sc.nextInt();
			sum += input;
		}		
		
		
		System.out.println("합계 : " + sum);
		
	}
	
}