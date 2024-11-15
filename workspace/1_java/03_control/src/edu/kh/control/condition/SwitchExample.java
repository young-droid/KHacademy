package edu.kh.control.condition;

import java.util.Scanner;

public class SwitchExample { // 기능용 클래스 

	/* switch문
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문 
	 * -> 식의 결과에 맞는 case 구문이 수행됨
	 * 
	 * [작성법]
	 * 
	 * switch(식){
	 * 
	 * case 결과1 : 결과1의 수행 코드; break;
	 * case 결과2 : 결과2의 수행 코드; break;
	 * case 결과3 : 결과3의 수행 코드; break;
	 * ...
	 * 
	 * default : 모든 case가 만족하지 못할 때 수행할 코드; 
	 * 
	 * }
	 */

	public void ex1() {

		Scanner sc = new Scanner(System.in);

		// 키보드로 정수를 입력 받아
		// 1 : RED 
		// 2 : Orange
		// 3 : YELLOW
		// 4 : GREEN
		// 5 : BLUE
		// 1~5가 아니면 : WHITE

		System.out.print("정수 입력 : ");
		int number = sc.nextInt();

		String result; // 선언만 한 상태 
		

		// if문 버전 : 
		//		if(number == 1) {
		//			result = "RED";
		//		} else if(number == 2) {
		//			result = "ORANGE";
		//		} else if(number == 3) {
		//			result = "YELLOW";
		//		} else if(number == 4) {
		//			result = "GREEN";
		//		} else if(number == 5) {
		//			result = "BLUE";
		//		} else {
		//			result = "WHITE";
		//		}

		// switch 버전 : 


		switch(number) {
		case 1 : result = "RED"; break;
		// number에 입력된 값이 1인 경우(case)
		// result 변수에 "RED"를 대입하고 switch문을 몀춤(break)
		case 2 : result = "ORANGE"; break;
		case 3 : result = "YELLOW"; break;
		case 4 : result = "GREEN"; break;
		case 5 : result = "BLUE"; break;

		default : result = "WHITE";
		// default == 기본값
		}

		System.out.println(result);

	} // ex1 끝


	public void ex2() {

		// 음료 결정 프로그램
		// 난수(Math.random() ), switch문

		// 1 부터 5 사이에 난수를 발생시켜 
		//일치하는 수의 메뉴를 출력 

		// Math.random() : 0.0 <= x < 1.0
		// Math.random() * 5 : 0.0 <= x * 5 < 5.0
		// Math.random() * 5 + 1 : 1.0 <= x * 5 + 1 < 6.0
		// (int)Math.random() * 5 + 1 : 1 <= (int)(x * 5 + 1) < 6

		int randomNumber = (int)(Math.random() * 5 + 1);
		//		System.out.print(randomNumber);

		String menu = null;

		switch (randomNumber) {
		case 1 : menu = "아이스 아메리카노"; break;
		case 2 : menu = "바닐라 라떼"; break;
		case 3 : menu = "녹차 라떼"; break;
		case 4 : menu = "아인슈페너"; break;
		case 5 : menu = "쑥 라떼"; break;

		}

		System.out.printf("가위바위보 진사람이 [%s] 사주기", menu);

	} // ex2 끝


	public void ex3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Month 입력 : ");
		int month = sc.nextInt(); 		

		String result = "정확한 달을 입력하세요";

		// break : 멈추다
		// -> 해당 case를 수행한 후 switch문을 멈춰서 빠져 나가라

		// * break가 없는 경우 *
		// - break를 만나거나 switch문이 끝날 때 까지
		//	 다음 case를 연달아서 실행

		switch(month) {
		case 1 : case 2 : case 12 : result = "겨울"; break;
		case 3 : case 4 : case 5 : result = "봄"; break;
		case 6 : case 7 : case 8 : result = "여름"; break;
		case 9 : case 10 : case 11 : result = "가을"; break;
		}

		//		switch(month) {
		//		case 1 : result = "겨울"; break;
		//		case 2 : result = "겨울"; break;
		//		case 3 : result = "봄"; break;
		//		case 4 : result = "봄"; break;
		//		case 5 : result = "봄"; break;
		//		case 6 : result = "여름"; break;
		//		case 7 : result = "여름"; break;
		//		case 8 : result = "여름"; break;
		//		case 9 : result = "가을"; break;
		//		case 10 : result = "가을"; break;
		//		case 11 : result = "가을"; break;
		//		case 12 : result = "겨울"; break;
		//		}


		System.out.println(result);


	} // ex3 끝

	public void ex4() {
		// 문자열로 메뉴를 입력 받아서
		// 해당 메뉴의 가격을 출력 

		// [실행화면]
		// 메뉴를 선택해주세요(치즈케이크, 티라미수, 고구마케이크) : 티라미수
		// 티라미수의 가격은 6000원 입니다. 

		// 메뉴를 선택해주세요(치즈케이크, 티라미수, 고구마케이크) : 딸기케이크
		// 존재하지 않는 메뉴입니다. 

		Scanner sc = new Scanner(System.in);

		System.out.print("메뉴를 선택해주세요(치즈케이크, 티라미수, 고구마케이크) : ");
		String menu = sc.next();

		int price;

//		String result;

		switch(menu) {
		case "치즈케이크" 	: price = 6000; break;
		case "티라미수" 	: price = 7000; break;
		case "고구마케이크"	: price = 5500; break;

		default : price = -1;
		}

//		System.out.printf("%s의 가격은 %d원 입니다.", menu, price);		
		
		if(price == -1) {
			System.out.println("존재하지 않는 메뉴입니다.");
		} else {
			System.out.printf("%s의 가격은 %d원 입니다.", menu, price);
		}



		// * rkqtdp dmlalfmf qndugotj whrjstlrdp tkdydgksms qkdqjqdmf dlgogodi gksek! *
		// * 값에 의
		


	} // ex4 끝

	public void ex5() {
		// 산술 연산 계산기

		// - 두 정수와 1개의 연산자(+-*/%)를 입력 받아 연산 결과를 출력

		// [실행화면]
		// 정수1 입력 : 5
		// 연산자 : +
		// 정수2 입력 : 4
		// 5 + 4 = 9

		// 정수1 입력 : 5
		// 연산자 : /
		// 정수2 입력 : 4
		// 5 / 4 = 1

		// 정수1 입력 : 2
		// 연산자 : @
		// 정수2 입력 : 10
		// 존재하지 않는 연산자 입니다.

		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 입력 : ");
		int input1 = sc.nextInt();

		System.out.print("연산자 입력 : ");
		String op = sc.next();

		System.out.print("정수2 입력 : ");
		int input2 = sc.nextInt();

		int result = 0;

		
		String real = "yes"; // 신호용 변수 
		
		boolean flag = true; // 신호용 변수 
		// 연산자 정상인 상태 -> flag(깃발)이 내려간 상태! 
		// // false 일 때 : 연산자를 정상 입력
		// true 일 때 : 연산자를 잘못 입력 

		switch(op) {
		// case 에 작성되는 값은 switch 식의 결과값 자료형의 리터럴 표기법이다! 
		case "+" : result = input1 + input2; break;
		case "-" : result = input1 - input2; break;
		case "*" : result = input1 * input2; break;
		case "/" : 

			if(input2 == 0) { // 오류가 발생되는 경우
				real = "error";
//				System.out.print("0으로 나눌 수 없습니다.");
			} else {
				result = (input1 / input2); 
			} break;
			
			
		case "%" : result = (input1 % input2); break;
		// 선생님 답 : 
//		default : flag = true; // 연산자를 잘못 입력 -> flag를 true로 변경 - 깃발이 올라간 상태! 
		// 내 답안 : 
				default : real = "no"; 
		}

//		if(flag) {
		
		
		if (real == "no") {
			System.out.println("연산자 틀림");
		} else if (real == "error") {
			System.out.println("나누기 0 에러");
		} else {
			System.out.printf("%d %s %d = %d", input1, op, input2, result);
		}
		
//		
//
//					if(op == null) {
//			System.out.print("존재하지 않는 연산자 입니다.");
//		} else if(op == "error") {
//			System.out.print("0으로 나눌 수 없습니다.");
//		}
//			else {
//			System.out.printf("%d %s %d = %d", input1, op, input2, result);
		}// ex5 끝




	public void ex5mine() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 입력 : ");
		int input1 = sc.nextInt();

		System.out.print("연산자 입력 : ");
		String op = sc.next();

		System.out.print("정수2 입력 : ");
		int input2 = sc.nextInt();

		int result = 0;
	
		switch(op) {
		case "+" : result = input1 + input2; break;
		case "-" : result = input1 - input2; break;
		case "*" : result = input1 * input2; break;
		case "/" : 

			if(input2 == 0) { 
				op = "0error";
			} else {
				result = (input1 / input2); 
			} break;

		case "%" : result = (input1 % input2); break;
		default : op = null;
		}


		if(op == null) {
			System.out.print("존재하지 않는 연산자 입니다.");
		} else if(op == "0error") {
			System.out.print("0으로 나눌 수 없습니다.");
		}
		else {
			System.out.printf("%d %s %d = %d", input1, op, input2, result);
		}

	}

	public void gpt() {
	
		    Scanner sc = new Scanner(System.in);

		    System.out.print("정수1 입력 : ");
		    int input1 = sc.nextInt();

		    System.out.print("연산자 입력 : ");
		    String op = sc.next();

		    System.out.print("정수2 입력 : ");
		    int input2 = sc.nextInt();

		    int result = 0;
		    boolean validOperation = true; // 연산이 유효한지 확인하는 변수

		    switch (op) {
		        case "+":
		            result = input1 + input2;
		            break;
		        case "-":
		            result = input1 - input2;
		            break;
		        case "*":
		            result = input1 * input2;
		            break;
		        case "/":
		            if (input2 == 0) {
		                System.out.print("0으로 나눌 수 없습니다.");
		                validOperation = false; // 유효하지 않은 연산
		            } else {
		                result = input1 / input2;
		            }
		            break;
		        case "%":
		            result = input1 % input2;
		            break;
		        default:
		            System.out.print("존재하지 않는 연산자 입니다.");
		            validOperation = false; // 유효하지 않은 연산
		            break;
		    }

		    if (validOperation) {
		        System.out.printf("%d %s %d = %d%n", input1, op, input2, result);
		    }

	
	}

}