package edu.kh.array.practice;

import java.util.Arrays;

import java.util.Scanner;

public class ArrayPractice {

	public void ex1() {
		
		int[] arr = new int[9]; // 변수명 i 라는 참조변수를 정수형 배열 9칸짜리 생성
		
		int sum = 0;
		
		for (int i= 0; i < 9; i++ ) {
			arr[i] += i+1;
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) { // 인덱스의 값 : 0 2 4 6 8
				sum += arr[i];
			}
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d", sum);
	}

	public void ex2() {
		
		int arr[] = new int[9];
		
		int sum = 0;
		
		for (int i= 8; i >= 0; i--) { // 8~0
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if (i % 2 == 1) { // 인덱스의 값 : 7 5 3 1
				sum += arr[i];
			}
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d", sum);
		
	}
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for (int i= 0; i < input; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		
	}

	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		boolean flag = false;
		
		for (int i = 0; i < 5; i++) {
			
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			arr[i] = input;
		}
		System.out.print("검색할 값 : ");
		int x = sc.nextInt();
		
		for (int i =0; i < 5; i++) {
			if (x == arr[i]) {
				System.out.printf("인덱스 : %d", i);
				flag = true;
				break;
			} 
		}
		if (!flag) { // flag == false 
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();

		// 입력받은 문자열 크기만큼 문자형 변수 배열 칸 생성
		char[] ch = new char[input.length()]; 
		
		// 하나씩 값 대입
		for (int i= 0; i < input.length(); i++) {
			ch[i] += input.charAt(i); 
		}
		
		System.out.print("문자 : ");
		char s = sc.nextLine().charAt(0); // 문자열 중 제일 앞 문자 얻어오기
		
		System.out.printf("%s 에 %s가 존재하는 위치(인덱스) : ", input, s);
		int num = 0;
		for (int i= 0; i < ch.length; i++) {
			if (s == ch[i]) {
				System.out.print(i + " ");
				num++;
			}
		}
		System.out.printf("\n%s 개수 : %d", s, num);
	}

	public void ex6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		int sum = 0;
		String value = "";
		
		for (int i =0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt(); // 입력받고 선언을 한번에 하기 ( int num = sc.nextInt();
								   //						arr[i] = num;)
			sum += arr[i];
			value += arr[i] + " ";
		}
		System.out.println(Arrays.toString(arr)); // 요소 출력
		System.out.println(value); // 값만 출력
		System.out.printf("\n총 합 : %d", sum);
		
	}
	
	public void ex7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char[] c = new char[input.length()]; // 입력한 값 크기만큼 문자형 배열 칸 생성 
		
		for (int i= 0; i < c.length; i++) {
			// 7번 인덕세 이하 (생년월일, -, 성별)
			c[i] = input.charAt(i); // 문자열 중 i번째 문자 대입
			if (i > 7 ) {
				c[i] = '*';
			}
			System.out.print(c[i]);
		}
	}
	
	public void ex8() {

		Scanner sc = new Scanner(System.in);

		// 혜선쌤 VER
		while (true) { // 3 이상의 홀수가 입력 될 때까지 무한 반복

			System.out.print("정수 : ");
			int input = sc.nextInt();

			if (input % 2 ==0 || input < 3) { // 3미만 또는 짝수인 경우 -> 반복
				System.out.println("다시 입력하세요.");
			} else {
				int[] arr = new int[input]; // input 값 만큼 정수형 배열 칸 수 생성
				for (int i =0; i < arr.length; i++) {
					if (i <= input /2) { // 0~input/2
						arr[i] = i+1; 	 // 까지 증가하는 값 대입
					} else {
						arr[i] = input-i; // input/2~input 까지 감소하는 값 대입
					}
					// [] 없이 출력 시 , 추가(단, 마지막 제외)
					if (i == input-1) {
						System.out.print(arr[i]); // 마지막 인덱스는 값만 출력
					} else {
						System.out.print(arr[i] + ", "); // 각 인덱스 값 + , 출력
					}
				}   
				break; // while문 반복 종료			
			}
		}
		//		// 내 VER (while문이 없다.)
		//		System.out.print("정수 : ");
		//		int input = sc.nextInt();
		//		
		//		if (input % 2 == 0 || input < 3) { 
		//			System.out.println("다시 입력하세요.");
		//		} else {
		//			int[] arr = new int[input]; // input 값 만큼 정수형 배열 칸 수 생성
		//			for (int i =0; i < input; i++) {
		//				if (i <= input /2) { // 0~input/2
		//					arr[i] = i+1; 	 // 까지 증가하는 값 대입
		//				} else {
		//					arr[i] = input-i; // input/2~input 까지 감소하는 값 대입
		//				}
		//				System.out.print(arr[i] + ", "); // [] 없이 요소들 출력
		//			}
		//		}
	}
	
	public void ex9() {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		for (int i= 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * arr.length + 1); // 1~10
			System.out.print(arr[i] + " ");
		}
	}
	
	public void ex10() {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		
		System.out.print("발생한 난수 : ");


		// 혜선쌤 VER
		for (int i= 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * arr.length + 1); // 1~10
			System.out.print(arr[i] + " ");
		}
		// 최고 / 최저점 구하기
		int min = arr[0]; // 1~10
		int max = arr[0]; // 1~10
		
		// for문을 이용해서 arr 배열에 있는 모든 값과
		// max, min 값 비교
		// 이 때,
		// arr[i] 값이 max 보다 크면 max에 대입
		// arr[i] 값이 min 보다 작으면 min에 대입
		for (int i=0; i < arr.length; i++) {
			if (arr[i] > max) {
				max =  arr[i];
			} 
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.printf("\n최대값 : %d", max);
		System.out.printf("\n최소값 : %d", min);
		
		
//		// 내 VER // 오류 못 고침 모르겠음
//		int max = 0;
//		int min = 0;
//		
//		for (int i= 0; i < arr.length; i++) { // 0~9 까지 반복
//			arr[i] = (int)(Math.random()*10 + 1); // 0~9 인덱스에 난수 대입
//			System.out.print(arr[i] + " "); // arr 배열 요소들 출력
//			
//			for (int x = 0; x < i; x++) {  
//				if (arr[i] > arr[x]) {
//					max = arr[i];
//				}
//				if (arr[i] < arr[x]) {
//					min = arr[i];
//				} 
//			}
//		}
//		System.out.printf("\n최대값 : %d", max);
//		System.out.printf("\n최소값 : %d", min);
	}
	
	public void ex11() {
		
		int[] arr = new int[10];
		
		for (int i =0; i < arr.length; i++) {
			// 난수 생성 -> 대입 (단, 중복 X)
			arr[i] = (int)(Math.random()*10 +1);
			
			// 중복 확인 시 i값 감소 시켜서
			// 다음 반복에서 현재 인덱스에 난수 덮어쓰기
			for (int x=0; x < i; x++) {
				// x의 최대값은 i보다 1 작은 수
				
				// 현재 생성된 난수가 앞서 대입된 난수와 같은 경우 == 중복
				if (arr[x] == arr[i]) {
					i--; // i를 1 감소
					// 바깥쪽 for문 반복 시 다시 i가 1증가
					// -1 + 1 == 0 (제자리)
					break; // 중복되는 값을 찾으면 더이상 검사할 필요X
				}
			}
		}
		for (int i =0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void ex12() { // 로또
		
		
	}
	
	public void ex13() { // 내 VER 미완성

		Scanner sc = new Scanner(System.in); 

		System.out.print("문자열 : "); 
		String input = sc.nextLine(); // String 으로 입력받기
		char[] arr = new char[input.length()]; // char 배열을 입력받은 문자열 크기만큼 선언, 할당

		int num = 0;

		for (int i= 0; i < input.length(); i++) { // 0 <= i < input.length() 인덱스 번호 만큼 반복
			arr[i] = input.charAt(i); // arr[0]~arr[input.length()] 각 문자형 대입
			if (i < input.length()-1) { // 
				System.out.print(arr[i] + ", ");
			}
			if (i == input.length()-1) {
				System.out.print(arr[i]);
			}
			for (int x =0; x < i; x++) { // 같은 문자형을 넣는 횟수 세기
				if (arr[x] == arr[i]) {
					num++;
				}
			}
		}
		System.out.printf("\n문자 개수 : %d", arr.length-num); // 전체 - 같은 문자형 넣은 횟수 = 반복없는 문자 개수
	}

	public void ex13_1() { // GPT VER
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()]; // char 배열로 변환
		boolean[] flag = new boolean[arr.length]; // 방문 여부 체크
		int num = 0; // 유일한 문자 개수

		System.out.print("문자열에 있는 문자 : ");
		for (int i= 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!flag[i]) { // 방문하지 않은 문자일 때
				System.out.print(arr[i]);
				num++; // 유일한 문자 개수 증가
				for (int x = i + 1; x < arr.length; x++) {
					if (arr[i] == arr[x]) {
						flag[x] = true; // 중복 문자 방문 처리
					}
				}
				if (i < arr.length - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.printf("\n문자 개수 : %d", num);
	}
//*****************************************************	
	public void ex13_2() { // 혜선쌤 VER *****
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		/*위치중요*/
		int count =0; // 카운트용 변수
		
		System.out.print("문자열에 있는 문자 : ");
		
		for (int i =0; i < arr.length; i++) {
			arr[i] = input.charAt(i); // 문자열 -> char배열에 옮겨 담기
			
   /*위치중요*/boolean flag = true; // 신호용 변수 
			// flag == true  : 중복 없음
			// flag == false : 중복 있음
			
			for(int x= 0; x < i; x++) { // 중복 검사용 for문
				if (arr[i] == arr[x]) {
					// 현재 대입된 문자가 앞서 대입된 문자와 같다면 중복
					flag = false;
					break; // 효율성 증가
				}
			}
			
			if (flag) { // 중복이 없을 경우 flag == true
				count++; // 1씩증가
				// 중복이 없을때 출력할 조건문
				if (i == 0) {
					System.out.print(arr[i]);
				} else {
					System.out.print(", " + arr[i]);
				}
			} // 바깥쪽 for문 끝
		}
		System.out.println("\n문자 개수 : " + count);
	}
	
	public void ex14() {
		
		// 혜선쌤 VER
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남은 개행 문자 제거
		
		String[] arr = new String[size];
		int start = 0; // while문 내 for문의 초기식에 사용할 변수
		
		while (true) {
			for (int i=start; i< arr.length; i++) {
				System.out.print((i+1) + "번째 문자열 : ");
				arr[i] = sc.nextLine();
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.nextLine().charAt(0);
			// 입력 받은 문자열 중 제일 앞 문자 하나만 얻어옴
			
			if (input == 'Y' || input == 'y') {
				//추가 입력받기 위한 추가 배열 부분의 시작 위치
				start = arr.length;
				
				System.out.print("더 입력하고 싶은 개수 : ");
				int addSize = sc.nextInt();
				sc.nextLine();

				// 증가된 크기의 배열을 생성하여 arr 배열 깊은 복사
				String[] copyArr = new String[arr.length + addSize];

				// 기존 배열 크기 만큼만 반복
				for (int i= 0; i <arr.length; i++) {
					copyArr[i] = arr[i]; // 복사본 배열에 기존 배열 값을 같은 인덱스에 대입
				}
				// 배열 얕은 복사
				arr = copyArr; // arr이 참조하는 주소값을
				// copyArr의 주소 값을 바꿔서
				// arr이 참조하는 배열의 크기가 증가한 것 처럼 보이게 함

			} else {
				System.out.println(Arrays.toString(arr));
				break; // while문 종료
			}
		}
		
		
//		// 내 VER
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("배열의 크기를 입력하세요 : ");
//		int input = sc.nextInt();
//		sc.nextLine();
//		
//		String[] result = new String[input]; // input만큼 칸 생성
////		String[] last = result;
//		
//		for (int i= 0; i < input; i++) { // 1~input 까지 
//			System.out.printf("%d번째 문자열 : ", i+1); // 입력 받고
//			String str = sc.nextLine(); // 문자열로
//			result[i] = str; // 0~input 까지 값 대입
//		}
//		
//		while (true) { // yn 이 N 대입 될때 까지 반복
//			System.out.print("더 값을 입력하시겠습니까?(Y/N) : "); 
//			String yn = sc.nextLine();
//			
//			if (yn.equals("Y")) { // 더 입력 받을 때
//				System.out.print("더 입력하고 싶은 개수 :"); 
//				int addinput = sc.nextInt();
//				sc.nextLine();
//				String[] last = new String[input+addinput]; // input+addinput 만큼 칸 생성
//				for (int i= input; i < addinput+input; i++) { // input+1~addinput+input 까지
//					System.out.printf("%d번째 문자열 : ", i+1); // 입력 받고
//					String stradd = sc.nextLine();
//					last[i] = stradd;
//				}
//			}
//			if (yn.equals("N")) { // 더 입력 안 받을 때
////				System.out.println(Arrays.toString(last));
//				break;
//			}
//		}
//		System.out.println(Arrays.toString(result));
	}
}






