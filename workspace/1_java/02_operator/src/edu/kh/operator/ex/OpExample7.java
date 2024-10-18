package edu.kh.operator.ex;

public class OpExample7 {

	public static void main(String[] args) {
		
		/* 복합 대입 연산자 : += -= *= /= %=
		 * - 기존 변수 값에 새로 대입되는 값의 산술 연산 결과를 대입 
		 * == 피연산자가 자신과 연산 후 결과를 다시 자신에게 대입
		 * 
		 * 복합 대입 연산을 사용하는 이유 : 컴퓨터가 처리하는 속도가 조금 더 빠르다 
		 * */

		int a = 10;
		
		a++; // 증감 연산자
		System.out.println("a를 1 증가 : " + a); // 11
				
		a = a + 1; 
		System.out.println("a를 1 증가 : " + a); // 12 

		a += 1; // 복합 대입 연산자
		System.out.println("a를 1 증가 : " + a); // 13

		a += 5; 
		System.out.println("a를 5 증가 : " + a);
		
		a -= 3;
		System.out.println("a를 3 감소 : " + a);
		
		a *= 4;
		System.out.println("a를 4배 증가 : " + a);
		
		a /= 7;
		System.out.println("a를 7로 나눴을 때 몫 : " + a);
		
		a %= 2;
		System.out.println("a를 2로 나눴을 때 나머지 : " + a);
		
	}
}
