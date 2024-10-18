package edu.kh.operator.practice;

import java.util.Scanner;

public class OpPractice2 {

	public static void main(String[] args) {

		/* 키보드로 입력 받은 정수가 양수면 "양수", 양수가 아니면 "양수 아님"을 출력하시오. 
		 * (삼항 연산자를 이용할 것)
		 * 
		 * [실행 화면]
		 * 정수 입력 : -8
		 * 
		 * 양수 아님
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		System.out.println(num > 0 ? "양수" : "양수 아님");
		
		
	}
}
