package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {

	/* 배열(Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것 (자료구조)
	 * 
	 * - 묶여진 변수들은 하나의 이름(배열명)으로 불려지고
	 *   각 변수들은 index를 이용해서 구분하게 된다. 
	 *   
	 * - index의 번호는 0부터 시작하는 정수
	*/

	public void ex1() {
		// 변수 vs 배열
		
		// 1-1. 변수 선언
		int num;
		// Stack 영역에 int 자료형을 저장할 수 있는 공간4byte를 생성(할당)하고 
		// 그 공간에 num이라는 이름을 부여
	
	
		// 1-2. 변수 대입
		num = 10;
		// 생성된 num이라는 변수 공간에 10을 대입
	
		// 1-3. 변수 사용
		System.out.println("num에 저장된 값 : " + num);
	
		// 2-1. 배열 선언
		int[] arr;
		// Stack 영역에 int[] (int 배열) 자료형 공간을 8byte 할당하고
		// 그 공간에 arr 이라는 이름을 부여
		// ** 해당 변수는 참조형으로 주소 값만을 저장할 수 있음
		
		// 2-2. 배열 할당
		arr = new int[3];
		
		// new : "new 연산자"라고 하며
		//		 Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당
		
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		
		// new int[3] : heap 영역에 int 3칸 짜리 int[]을 생성(할당)
		//				** 생성된 int[]에는 시작 주소가 지정된다!! **
		
		// heap 영역에 생성된 int[]의 시작 주소를
		// stack 영역에 생성된 arr 변수에 대입
		// -> arr 변수가 int[]을 참조하게 됨! 
		//	  (그래서 arr을 참조형이라고 함)
		
		
		
		// 2-3. 배열 요소 값 대입
		// arr은 int[] 참조형 변수지만
		// arr[0]은 int 자료형 변수이기 때문에 정수 값 대입 가능 
//		arr = 10; //Type mismatch: cannot convert from int to int[]
		 arr[0] = 10;
		 arr[1] = 50;
		 arr[2] = 100;
		 
		
		// 2-4. 배열 요소 값 읽어오기
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
	}
	
	
	public void ex2() {
		
		// 배열 선언 및 할당
		int[] arr = new int[4];
		
		// 1) stack 영역에 int[] 자료형 참조변수 arr 선언
		// 2) heap 영역에 int 자료형 4개를 묶음으로 다루는 int[] 할당
		// 3) 생성된  int[]의 시작 주소를 arr에 대입하여 참조하는 형태를 만든다. 
		
		// 배열 길이(== 몇 칸인가) : 배열.length
		System.out.println("배열 arr 의 길이 : " + arr.length);
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		
		// 배열과 for문
		
		for(int i = 0; i < arr.length ; i++) {
			// 0 이상 arr 배열 길이 미만의 정수
			
			System.out.printf("arr[%d]에 저장된 값 : %d\n",i, arr[i]);

		}
	}
	
	// (참고)
	
	// 비어있다 : stack 영역에 선언된 변수에 값이 대입되지 않음
	
	// null : 참조형 변수가 선언 되었으나 아무곳도 참조하지 않음
	//		  (빈칸 아님!)
	
	// 0 : int 자료형 0

	// "" : String 자료형이지만 내용 없음(빈 문자열)

	
	
	// 5명의 키(cm)를 입력 받고 평균 구하기
	public void ex3() {

		/*
		1번 키 입력 : 
		2번 키 입력 : 
		3번 키 입력 : 
		4번 키 입력 : 
		5번 키 입력 : 
		
		입력 받은 키 : 170.5	165.7	184.3	190.2	174.4
		평균 : 177.02cm
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		double[] height = new double[person];
		
		for(int i = 0 ; i < height.length  ; i++) {
			System.out.printf("%d번 키 입력 : ", i + 1);
			height[i] = sc.nextDouble();
		}
		
		double sum = 0;
		System.out.print("입력 받은 키 : ");
		for(int i = 0; i < height.length ; i++) {
			System.out.printf("%.1f  ", height[i]);
			sum += height[i];
		}
		System.out.printf("\n평균 : %.2fcm", sum/person);
	}

	
	
	// 배열 선언과 동시에 초기화
	public void ex4() {
	
		char[] arr = new char[5];
		
		// char[] arr이 참조하는 배열 요소에 A,B,C,D,E 대입하기
		for(int i=0; i < arr.length ; i++) {
			arr[i] = (char)('A'+i);
			
			System.out.println(arr[i]);
			
		}
		
		
		// ** Arrays 클래스
		// -> Java에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		
		int[] arr2 = new int[4];
		System.out.println(arr2);
		
		// Arrays.toString(배열명) : 모든 요소 값을 출력
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr));
		
		// 배열 선언과 동시에 할당 및 초기화
		char[] arr3 = {'A', 'B', 'C', 'D', 'E'};
		System.out.println(Arrays.toString(arr3));
		
		// char[] 참조 변수 arr3를 선언하고
		// heap 영역에 char 5칸짜리 char[]을 생성하고
		// 각각 'A', 'B', 'C', 'D', 'E'로 초기화 후 주소를 arr3에 대입
		
		// {} (중괄호)는 배열의 리터럴 표기
		
	}
	
	// 점심 메뉴 뽑기 프로그램
	public void ex5() {
		
		String[] menu = {"떡볶이", "제육볶음", "순대", "감자튀김", "햄버거"};
		System.out.println((int)(Math.random()*5));
		System.out.println("오늘의 점심 메뉴는 : " + menu[(int)(Math.random()*4+1)]);
		
	}
	
	
	// input 만큼 * 테두리 그리기
	public void ex6() {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();

		for(int y = 1 ; y <= size ; y++) {
			for(int x = 1 ; x <= size ; x++) {
			}
			System.out.println();
		}


	}

	// 디저트 주문 프로그램
	public void ex7() {
		// 배열 2개 생성 후
		// 같은 인덱스 번호에 메뉴명, 가격을 작성
		
		// ---- 메뉴 ----
		// 1) 치즈케이크 (6400원)
		// 2) 브라우니 (4800원)
		// ...
		// 9) 주문 완료
		
		// 주문한 메뉴 : 치즈케이크 브라우니
		// 합계 : 13200원
		
		Scanner sc = new Scanner(System.in);
		
		String[] menu = {"치즈케이크", "브라우니", "티라미수", "식혜", "크로칸슈"};
		
		int[] price = {6400, 4800, 5500, 3000, 5900};
		
		String menuTotal = "";
		int priceTotal = 0;		
		



		while(true) {
			// 메뉴 출력
			System.out.println("---- 메뉴 ----");
			for(int i = 0; i < menu.length ; i++) { 
				System.out.printf("%d) %s (%d원)\n", i+1, menu[i], price[i]);
			}
			System.out.printf("9) 주문 완료\n");

			// 메뉴 입력 부분
			System.out.print("메뉴 번호를 입력하세요 : ");
			int input = sc.nextInt();

			if(input == 9) { // 주문 완료
				break;
			} else if // 잘못 입력 -> 0 보다 작거나, 배열 수 보다 크다
			(input < 0 || input >= menu.length) {
				System.out.println("메뉴에 있는 번호만 눌러주세요.");
			} else { // 정상 입력
				menuTotal += menu[input-1] + " ";
				priceTotal += price[input-1]; 
			}
		}
		System.out.printf("주문한 메뉴 : %s\n", menuTotal);
		System.out.printf("합계 : %d원", priceTotal);
	}
	
	
	
	// input 만큼의 길이를 가지는 배열 생성, 
	// 각 인덱스에 요소 입력 및 저장 후 출력
	public void ex8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생성할 배열 길이 : ");
		int length = sc.nextInt();
		
		int[] arr = new int[length];
		
		
		// 생성된 배열의 보든 요소에 입력 값을 대입
		for(int i = 0 ; i < arr.length ; i++) { 
			System.out.printf("%d번 인덱스 요소 : ", i);
			arr[i] = sc.nextInt();
		}

		System.out.println();

		while(true) {

			System.out.print("저장된 값을 확인하려는 인덱스(-1 종료) : ");
			int index = sc.nextInt();

			if(index == -1) { // 반복 종료
				break;

			}

			if(index < 0 || index >= arr.length) {
				System.out.println("존재하지 않는 인덱스 번호 입니다.");
				continue; // 아래는 무시하고 다음 반복으로 이동(반복문 처음으로 이동)
				// 정상 입력
			} 

			System.out.printf("%d번 인덱스 : %d\n", index, arr[index]);
			System.out.println();

		} ;

		System.out.println("프로그램 종료");


		//		
//		for(int i = 0 ; i < arr.length ; i ++) {
//			System.out.printf("", arr[i]);
//		}
//		
		
	}

	// 배열 내에서 input 값 찾기
	public void ex9() {
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		
		
		
		// arr 배열 요소 순차 접근(반복 접근)
		for(int i = 0 ; i < arr.length ; i++) {
			
			// 저장된 값과 input이 같을 경우
			if(input == arr[i]) {
				System.out.println("있습니다.");
				System.out.printf("%d번째 인덱스에 있네요.", i);
				flag = true; //일치하는 값이 있으므로 true로 변경
				break;
			 } 
		}
		if (flag == false) {
			System.out.println("없네요. ");
		}
		
	}
	

	// 입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
	// 없으면 "존재하지 않습니다" 출력
	public void ex10() {
		
		String[] coffee = {"딸기라떼", "달고나라떼", "녹차라떼", "흑임자라떼", "밀크티", "바닐라라떼"};
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;
		
		
		
		System.out.println("내가 지금 마시고 싶은 음료를 맞혀봐.");

		

		
		System.out.print("음료 입력 : ");
		String input = sc.next();
		
		
		for(int i = 0 ; i < coffee.length; i ++) {
			
			if(input.equals(coffee[i])) {
				System.out.println("그래 맞아! 이제 사와.");
				System.out.printf("(인덱스 번호 : [%d])\n", i);
				flag = true;
				break; 
			}
		} 
				
		if(!flag) {
		System.out.println("틀렸어!");
		}
	}
		
		
		
		
		
		

}


