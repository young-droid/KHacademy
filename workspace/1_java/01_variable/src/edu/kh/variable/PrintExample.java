package edu.kh.variable;

public class PrintExample {

	public static void main(String[] args) {
		
		// System.out.print() : 단순 출력 (출력 후 줄바꿈 X)
		// System.out.println() : 한 줄 출력 (출력 후 줄바꿈 O)
		// System.out.printf() : 한 줄 출력 (출력 후 줄바꿈 O)
		
		System.out.print("테스트0");
		System.out.println("테스트1");
		System.out.println("테스트2");
		System.out.print("테스트3");
		System.out.println(); // 내용 없는 println -> 줄바꿈 
		System.out.println("테스트4");
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10 + 20 = 30
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1+iNum2));
		

		// 20 + 10 * 10 / 2 = 70
		System.out.println(iNum2 + " + " + iNum1 + " * " + iNum1 + " / 2 = " + (iNum2 + iNum1 * iNum1 / 2));
		
		// System.out.printf("패턴", 패턴에 들어갈 값);
		System.out.printf("%d + %d * %d / %d = %d\n", iNum2, iNum1, iNum1, 2, (iNum2 + iNum1 * iNum1 / 2));
		
		
		// 줄바꿈 (\n)
		int iNum3 = 21;
		System.out.printf("%d\n", iNum3); // 21 -> 출력 후 줄바꿈 (\n)
		System.out.printf("%6d\n", iNum3); // '----21' -> 총 6칸을 확보하고, 오른쪽 정렬 후 줄바꿈
		System.out.printf("%-6d", iNum3); 
		System.out.printf("%d\n", iNum3); // '21----21' -> 먼저 총 6칸을 확보하고, 왼쪽 정렬 후 줄바꿈 없이 다음 라인 출력 
		
		
		// 소수점 자리 제어
		System.out.printf("%f\n", 10 / 3.0); // 3.333333
		System.out.printf("%.2f\n", 10 / 3.0); // 3.33
		System.out.printf("%.0f\n", 10 / 3.0); // 3
		System.out.printf("%.0f\n", 10 / 4.0); // 3 -> 2.5 에서 반올림 처리 됨
	
		
		// 문자, 문자열, boolean
		char ch = 'A';
		String str = "점메추"; // String은 참조형 (기본 자료형을 뺀 나머지)
		boolean isTrue = false; 
		
		System.out.printf("%c / %s / %b \n", ch, str, isTrue);
		
				
		// escape 문자 : 일반 문자가 아닌 특수 문자 표현 시 사용
		// 탈출 문자
		System.out.println("abcd");
		System.out.println("a\tb\tc\td"); // tab 출력
//		System.out.println("\"),("""),("'"); // 오류 
		System.out.println("\\"); // 백슬래시 단순 문자 출력
		System.out.println("\""); // 쌍따옴표 단순 문자 출력
		System.out.println("\' "); // 홑따옴표 단순 문자 출력
		System.out.println('\''); // 홑따옴표 단순 문자 출력
		System.out.println("\u0041"); // 유니코드(16진수)번호로 문자 출력 // A
		
		
		
	}
	
}
