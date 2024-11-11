package edu.kh.exception.model.service;

import java.util.Scanner;


public class ExceptionService {

	// 예외 (Exception) : 소스 코드의 수정으로 해결 가능한 오류
	
	// 예외는 두 종류로 구분됨
	// 1) UnChecked Exception	: 선택적으로 예외 처리
	// 1) Checked Exception	: 필수적으로 예외 처리
	
	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		// try - catch 예외 처리
		
		// try{} : 괄호 내부에 예외가 발생할 가능성이 있는 코드를 작성한 후 시도
		
		// catch(예외){ } : try 구문에서 발생한 예외를 잡아내서 처리하여
		// 				   프로그램이 비정상 종료되지 않도록 함
		
		System.out.println("두 정수를 입력 받아 나누기한 몫을 출력");
		
		System.out.println("정수 1 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.println("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
		try {
			
		System.out.println("결과 : " + input1 / input2);
		//  java.lang.ArithmeticException: / by zero
		// 산술적 예외 : 0으로 나눌 수 없다. 
		
		} catch(ArithmeticException e) {
			//try 에서 던져진 예외를 catch문의 매개변수로 잡음
			System.out.println("infinity");
		}
		
		
	}
	
}
