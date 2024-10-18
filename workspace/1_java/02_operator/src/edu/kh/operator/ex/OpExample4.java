package edu.kh.operator.ex;

public class OpExample4 {

	public static void main(String[] args) {
		
		
		System.out.println("--------AND 연산자--------");
		
		// 논리 연산자 : &&(AND), ||(OR)
		// 부정 연산자 : !
		
		
		/* AND 연산자 (&&)
		 * - 둘 다 true이면 true, 나머진 false
		 * - ~와, 그리고(이고), 이면서(면서), 부터, 까지, 사이
		 * */

		// 104는 50 이상 이면서 짝수인가? 
		boolean result1 = (104 >= 50) && (104 % 2 == 0);
		
		System.out.println("104는 100 이상이면서 짝수인가? " + result1);
		
		// num2는 50 이하이고 2의 배수인가? 
		int num2 = 70;
		boolean result2 = (num2 <= 50) && (num2 % 2 == 0);
		
		System.out.println("num2는 50 이하이고 2의 배수인가? " + result2);
		
		// num3는 1 부터 100 사이의 정수인가? 
		int num3 = 65;
		
		// 1 <= num3 <=100 사용 가능?? NOPE
		boolean result3 = num3 >= 1 && num3 <= 100; 
		System.out.println("num3는 1부터 100사이의 정수인가? " + result3);
		
		System.out.println("--------OR 연산자--------");
		
		/* OR 연산자 (||) : 돌 다 false 명 false, 아니면 true
		 * - 또는, ~이거나(거나)
		 * */
		
		// num4는 10을 초과하거나 홀수인가? true
		int num4 = 37;
		boolean result4 = num4 > 10 || num4 % 2 != 0;
		System.out.println("num4는 10을 초과하거나 홀수인가? " + result4);
		
		int num5 = -89;
		boolean result5 = (num5 >= 0 && num5 <= 50) || num5 < 0;
		System.out.println("num5는 0이상 50이하의 수 또는 음수인가? " + result5);
		
		System.out.println("--------논리 부정(NOT) 연산자 !--------");
		
		// 논리 부정(NOT) 연산자 ! 
		// - 논리 값을 반대로 바꾸는 연산자
		
		System.out.println(!true);
		System.out.println(!false);
		
		int num6 = 13; 
		boolean result6 = num6 % 2 == 0;
		
		System.out.println("num6는 짝수입니까? " + result6);
		System.out.println("num6는 홀수입니까? " + !result6);
		
		int num7 = 31;
		boolean result7 = (num7 >1 && num7 < 50) && !(num7 % 5 == 0);
		
		System.out.println("num7은 1부터 50사이 정수이면서 5의 배수가 아닌 수 입니까? "+ result7);
		
		
		
		
		
		
		
	}
}
