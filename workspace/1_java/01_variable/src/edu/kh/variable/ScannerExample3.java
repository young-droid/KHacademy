package edu.kh.variable;

import java.util.Scanner; 

public class ScannerExample3 {
	public static void main (String[] args) {
		
		// 사칙 연산 계산기 
		// -> 두 실수를 입력 받아 사칙연산 결과를 모두 출력 (소수점 둘째 자리 까지 출력)
		
		// nextDouble() : 입력 받은 다음 실수를 읽어옴
		
		// 출력 예시
		// 실수 1 입력: 1.23
		// 실수 2 입력: 2.01

		//1.23 + 2.01 = 3.24
		//1.23 - 2.01 = 
		//1.23 * 2.01 = 
		//1.23 / 2.01 = 
		

		Scanner sc = new Scanner(System.in);
		
		System.out.print("실수 1 입력 : ");
		double dNum1 = sc.nextDouble();
		
		System.out.print("실수 2 입력 : ");
		double dNum2 = sc.nextDouble();
		
		System.out.println();
		
		
		System.out.printf("%.2f + %.2f = %.2f\n", dNum1, dNum2, dNum1 + dNum2);
		System.out.printf("%.2f - %.2f = %.2f\n", dNum1, dNum2, dNum1 - dNum2);
		System.out.printf("%.2f * %.2f = %.2f\n", dNum1, dNum2, dNum1 * dNum2);
		System.out.printf("%.2f / %.2f = %.2f", dNum1, dNum2, dNum1 / dNum2);

	
	
	}
	
}
