<<<<<<< HEAD
package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample { // 예제 작성용

	// ex1 메소드
	// -> ConditionExample이 가지고 있는 기능 중 ex1()이라는 기능
	public void ex1() {
	
		/* 
		 * if 문
		 * - 조건식이 true 일때만 내부 코드 수행
		 * 
		 * [작성법]
		 * if(조건식){
		 * 			조건식이 true 일 때 수행할 코드;
		 * }
		 */
	
		Scanner sc = new Scanner(System.in);
	
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
	
		if(input > 0) {
			System.out.println("양수 입니다.");
			System.out.println("ex1() 종료"); 
		}
	
		if(input <= 0) {
			System.out.println("양수가 아닙니다.");
			System.out.println("ex1() 끝!");
		}
	
		
	} // ex1 끝

	public void ex2() {
	
		/* if - else 문
		 * - 조건식 결과가 true면 if 문,
		 * 	 false면 else 구문이 수행됨
		 * 
		 * [작성법]
		 * if(조건식){
		 * 		조건식이 true일 때 수행할 코드;
		 * } else{
		 * 		조건식이 false일 때 수행할 코드;
		 * }
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 홀짝 검사
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		
		if(input % 2 != 0) {
			System.out.println("홀수입니다.");
		} else {
			
			// ** 중첩 if문 **
			if(input == 0) {
				System.out.println("0 입니다.");
			} else {
			System.out.println("짝수입니다.");
			} 
		}
	} // ex2 끝
	
	public void ex3() {
		// if - else if - else 
		
		// 양수, 음수, 0 판별
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) { // input이 양수일 경우
			System.out.println("양수 입니다. ");
		} else if(input < 0) { // input이 음수일 경우
			System.out.println("음수 입니다. ");
		} else { // 모든 if, else if가 만족되지 않은 경우 수행
			System.out.println("0 입니다.");
		}
		
	} // ex3 끝
	
	public void ex4() { 

		Scanner sc = new Scanner (System.in);
		
		System.out.print("달(월)을 입력해주세요 : ");
		int month = sc.nextInt();
		
		String season; // 아래 조건문 수행 결과를 저장할 변수 선언
					   // 초기화 X -> 아래의 조건문에서 조기화 할 예정
		

		if(month >= 3 && month <= 5) { // 봄(3,4,5)
			season = "봄";
		} else if(month >= 6 && month <= 8) { // 여름(6,7,8)
			season = "여름";
		} else if(month >= 9 && month <= 11) { // 가을(9,10,11)
			season = "가을";
		} else if(month == 1 || month == 2 || month == 12) { // 겨울(12,1,2)
			season = "겨을";
		} else { 
			season = "정확한 숫자를 입력하세요";
		}

		System.out.println(season);
		
	} // ex4 끝
	
	public void ex5() {
		
		// 나이를 입력 받아
		// 13세 이하면 "어린이"
		// 13세 초과, 19세 이하면 "청소년"
		// 19세 초과는 "성인"
		// 0세 미만, 100세 초과는 "잘못 입력하셨습니다." 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력해 주세요 : ");
		int age = sc.nextInt();
		
		String result;


		/*
		if(age >= 0 && age <= 13){
			result = "어린이";
		} else if (age <= 19) {
			result = "청소년";
		} else if (age <= 100){ 
			result = "성인";
		} else {
			result = "잘못 입력하셨습니다.";
		}
		 */

		if(age < 0 || age > 100){
			result = "잘못 입력하셨습니다.";
			
		} else if (age <= 13) {
			result = "어린이";
						
		} else if (age <= 19) {
			result = "청소년";
			
		} else { 
				result = "성인";
		}
		
	
	
		System.out.println(result);
		// The local variable result may have not initialized 
		// ** 선언된 변수(지역 변수)는
		// 반드시 사용되기 전에 초기화가 되어 있어야 한다. 
		
	} //ex5 끝
	
	public void ex6() {
		
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		//

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		String result;
		
//		if (score < 0 && score > 100) {
//			result = "잘못 입력하셨습니다.";			
//			if (score >= 90) {
//				result = "A";
//			} else if (score >= 80) {
//				result = "B";
//			} else if (score >= 70) {
//				result = "C";
//			} else if (score >= 60) {
//				result = "D";
//			} else {
//				result = "F";
//			} 
//		} else {
//				result = "잘못 입력하셨습니다.";
//			}
//			
		
		if (score < 0 || score > 100) {
			result = "잘못 입력하셨습니다.";			
		} else if (score >= 90) {
			result = "A";
		} else if (score >= 80) {
			result = "B";
		} else if (score >= 70) {
			result = "C";
		} else if (score >= 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		
		System.out.println(result);

		
	} // ex6 끝
	
	
	public void ex7() {
		   // 놀이기구 탑승 제한 검사
	      
	      // 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
	      // 나이가 12미만인 경우 : "적정 연령이 아닙니다."
	      // 키가 140.0cm 미만 : "적정 키가 아닙니다."
	      // 나이가 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		
		
		String result;
		
		
		if (age < 0 || age > 100) {
			result = "잘못 입력 하셨습니다."; 
			
		} else {			
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
		
			if (height < 0) {
			result = "잘못 입력 하셨습니다.";

			} else if (age < 12 && height < 140.0) {
			result = "적정 연령과 키가 아닙니다.";
			
			} else if (age < 12) {
			result = "적정 연령이 아닙니다.";
			
			} else if (height < 140.0) {
			result = "적정 키가 아닙니다.";
			
			} else {
			result = "탑승 가능";
			}
		}
		
		System.out.println(result);
		
	} //ex7 끝
	
	
	public void ex8 () {
		  // 놀이기구 탑승 제한 검사 프로그램
	      // 조건 - 나이 : 12세 이상
	      //     -  키 : 140.0cm 이상
	      
	      // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
	      // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
	      // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
	      
	      // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
	      // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
	      // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
	      // 나이 O , 키 O : "탑승 가능"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		//선생님 답안: 
//		if (age < 0 || age > 100) {
//			result = "나이를 잘못 입력 하셨습니다.";
//			
//		} else {
//			System.out.print("키 입력 : ");
//			double height = sc.nextDouble();
//			if (height < 0 || height > 250.0) {
//				result = "키를 잘못 입력 하셨습니다.";
//			} else {
//				 if (age < 12 && height >= 140.0) {
//						result = "키는 적절하나, 나이가 적절치 않음"; 
//				} else if (age >=12 && height < 140.0) {
//						result = "나이는 적절하나, 키가 적절치 않음";
//				} else if (age < 12 && height < 140) {
//						result = "나이와 키 모두 적절치 않음";
//				} else {
//					result = "탑승 가능";
//					}
//			}
//		}
		
		
		// 내 답안 : 
		if (age < 0 || age > 100) {
			result = "나이를 잘못 입력 하셨습니다.";
			
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			if (height < 0 || height > 250.0) {
				result = "키를 잘못 입력 하셨습니다.";
			} else if (age < 12 && height < 140) {
				result = "나이와 키 모두 적절치 않음";
			} else if (age < 12 ) {
				result = "키는 적절하나, 나이가 적절치 않음"; 
			} else if (height < 140) {
				result = "나이는 적절하나, 키가 적절치 않음";
			} else {
			result = "탑승 가능";
			}
		}	
	
	System.out.println(result);
		
		
	} //ex8 끝
	
	}
	
	


=======
package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample { // 예제 작성용

	// ex1 메소드
	// -> ConditionExample이 가지고 있는 기능 중 ex1()이라는 기능
	public void ex1() {
	
		/* 
		 * if 문
		 * - 조건식이 true 일때만 내부 코드 수행
		 * 
		 * [작성법]
		 * if(조건식){
		 * 			조건식이 true 일 때 수행할 코드;
		 * }
		 */
	
		Scanner sc = new Scanner(System.in);
	
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
	
		if(input > 0) {
			System.out.println("양수 입니다.");
			System.out.println("ex1() 종료"); 
		}
	
		if(input <= 0) {
			System.out.println("양수가 아닙니다.");
			System.out.println("ex1() 끝!");
		}
	
		
	} // ex1 끝

	public void ex2() {
	
		/* if - else 문
		 * - 조건식 결과가 true면 if 문,
		 * 	 false면 else 구문이 수행됨
		 * 
		 * [작성법]
		 * if(조건식){
		 * 		조건식이 true일 때 수행할 코드;
		 * } else{
		 * 		조건식이 false일 때 수행할 코드;
		 * }
		 */
		
		Scanner sc = new Scanner(System.in);
		
		// 홀짝 검사
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		
		if(input % 2 != 0) {
			System.out.println("홀수입니다.");
		} else {
			
			// ** 중첩 if문 **
			if(input == 0) {
				System.out.println("0 입니다.");
			} else {
			System.out.println("짝수입니다.");
			} 
		}
	} // ex2 끝
	
	public void ex3() {
		// if - else if - else 
		
		// 양수, 음수, 0 판별
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) { // input이 양수일 경우
			System.out.println("양수 입니다. ");
		} else if(input < 0) { // input이 음수일 경우
			System.out.println("음수 입니다. ");
		} else { // 모든 if, else if가 만족되지 않은 경우 수행
			System.out.println("0 입니다.");
		}
		
	} // ex3 끝
	
	public void ex4() { 

		Scanner sc = new Scanner (System.in);
		
		System.out.print("달(월)을 입력해주세요 : ");
		int month = sc.nextInt();
		
		String season; // 아래 조건문 수행 결과를 저장할 변수 선언
					   // 초기화 X -> 아래의 조건문에서 조기화 할 예정
		

		if(month >= 3 && month <= 5) { // 봄(3,4,5)
			season = "봄";
		} else if(month >= 6 && month <= 8) { // 여름(6,7,8)
			season = "여름";
		} else if(month >= 9 && month <= 11) { // 가을(9,10,11)
			season = "가을";
		} else if(month == 1 || month == 2 || month == 12) { // 겨울(12,1,2)
			season = "겨을";
		} else { 
			season = "정확한 숫자를 입력하세요";
		}

		System.out.println(season);
		
	} // ex4 끝
	
	public void ex5() {
		
		// 나이를 입력 받아
		// 13세 이하면 "어린이"
		// 13세 초과, 19세 이하면 "청소년"
		// 19세 초과는 "성인"
		// 0세 미만, 100세 초과는 "잘못 입력하셨습니다." 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력해 주세요 : ");
		int age = sc.nextInt();
		
		String result;


		/*
		if(age >= 0 && age <= 13){
			result = "어린이";
		} else if (age <= 19) {
			result = "청소년";
		} else if (age <= 100){ 
			result = "성인";
		} else {
			result = "잘못 입력하셨습니다.";
		}
		 */

		if(age < 0 || age > 100){
			result = "잘못 입력하셨습니다.";
			
		} else if (age <= 13) {
			result = "어린이";
						
		} else if (age <= 19) {
			result = "청소년";
			
		} else { 
				result = "성인";
		}
		
	
	
		System.out.println(result);
		// The local variable result may have not initialized 
		// ** 선언된 변수(지역 변수)는
		// 반드시 사용되기 전에 초기화가 되어 있어야 한다. 
		
	} //ex5 끝
	
	public void ex6() {
		
		// 점수(100점 만점)를 입력 받아
		// 90점 이상 : A
		//

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		String result;
		
//		if (score < 0 && score > 100) {
//			result = "잘못 입력하셨습니다.";			
//			if (score >= 90) {
//				result = "A";
//			} else if (score >= 80) {
//				result = "B";
//			} else if (score >= 70) {
//				result = "C";
//			} else if (score >= 60) {
//				result = "D";
//			} else {
//				result = "F";
//			} 
//		} else {
//				result = "잘못 입력하셨습니다.";
//			}
//			
		
		if (score < 0 || score > 100) {
			result = "잘못 입력하셨습니다.";			
		} else if (score >= 90) {
			result = "A";
		} else if (score >= 80) {
			result = "B";
		} else if (score >= 70) {
			result = "C";
		} else if (score >= 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		
		System.out.println(result);

		
	} // ex6 끝
	
	
	public void ex7() {
		   // 놀이기구 탑승 제한 검사
	      
	      // 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
	      // 나이가 12미만인 경우 : "적정 연령이 아닙니다."
	      // 키가 140.0cm 미만 : "적정 키가 아닙니다."
	      // 나이가 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		
		
		String result;
		
		
		if (age < 0 || age > 100) {
			result = "잘못 입력 하셨습니다."; 
			
		} else {			
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
		
			if (height < 0) {
			result = "잘못 입력 하셨습니다.";

			} else if (age < 12 && height < 140.0) {
			result = "적정 연령과 키가 아닙니다.";
			
			} else if (age < 12) {
			result = "적정 연령이 아닙니다.";
			
			} else if (height < 140.0) {
			result = "적정 키가 아닙니다.";
			
			} else {
			result = "탑승 가능";
			}
		}
		
		System.out.println(result);
		
	} //ex7 끝
	
	
	public void ex8 () {
		  // 놀이기구 탑승 제한 검사 프로그램
	      // 조건 - 나이 : 12세 이상
	      //     -  키 : 140.0cm 이상
	      
	      // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
	      // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
	      // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
	      
	      // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
	      // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
	      // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
	      // 나이 O , 키 O : "탑승 가능"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		//선생님 답안: 
//		if (age < 0 || age > 100) {
//			result = "나이를 잘못 입력 하셨습니다.";
//			
//		} else {
//			System.out.print("키 입력 : ");
//			double height = sc.nextDouble();
//			if (height < 0 || height > 250.0) {
//				result = "키를 잘못 입력 하셨습니다.";
//			} else {
//				 if (age < 12 && height >= 140.0) {
//						result = "키는 적절하나, 나이가 적절치 않음"; 
//				} else if (age >=12 && height < 140.0) {
//						result = "나이는 적절하나, 키가 적절치 않음";
//				} else if (age < 12 && height < 140) {
//						result = "나이와 키 모두 적절치 않음";
//				} else {
//					result = "탑승 가능";
//					}
//			}
//		}
		
		
		// 내 답안 : 
		if (age < 0 || age > 100) {
			result = "나이를 잘못 입력 하셨습니다.";
			
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			if (height < 0 || height > 250.0) {
				result = "키를 잘못 입력 하셨습니다.";
			} else if (age < 12 && height < 140) {
				result = "나이와 키 모두 적절치 않음";
			} else if (age < 12 ) {
				result = "키는 적절하나, 나이가 적절치 않음"; 
			} else if (height < 140) {
				result = "나이는 적절하나, 키가 적절치 않음";
			} else {
			result = "탑승 가능";
			}
		}	
	
	System.out.println(result);
		
		
	} //ex8 끝
	
	}
	
	


>>>>>>> fa629db12ad3cbef6729f14311fd45817b469dee
