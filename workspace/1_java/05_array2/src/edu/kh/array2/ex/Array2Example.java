package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {

	/* 2차원 배열
	 - 자료형이 같은 1차원 배열을 묶음으로 다루는 것
	 -> 행, 열 개념 추가
	 
	 */

	public void ex1() {
		// 2차원 배열 선언
		int[][] arr;
		//int 2차원 배열을 참조하는 참조 변수 선언
		//(참조형 == 참조 변수 == 레퍼런스 변수 == 레퍼런스)
		
		// 2차원 배열 선언
		
		arr = new int[2][3];
		
		// 2차원 배열 할당 
		
		/*
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		*/
		
		// Arrays.toString(배열명) 
		// - 참고하고 있는 1차원 배열 값을 문자열로 반환
		System.out.println(Arrays.toString(arr));
		
		// Arrays.deepToString(배열명) 
		// - 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서 모든 값을 문자열로 반환
		System.out.println(Arrays.deepToString(arr));
		
		
		System.out.println(arr.length);
		// arr이 참조하고 있는 2차원 배열의 행의 길이
		
		int[] arr0 = arr[0];
		System.out.println(arr0.length);
		// arr[0]이 참조하고 있는 2차원 배열의 열의 길이
		
		int num = 10;
		
		for(int row = 0 ; row < arr.length ; row++) {
			for(int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = num;
				num += 10;	// num에 10씩 증가
			}
		}
		
		System.out.println(Arrays.deepToString(arr));

		
	}
		
	
	public void ex2() {
		
		// 2차원 배열 선언과 동시에 초기화
		
		// 3행 3열짜리 정수형 2차원 배열 선언과 동시에
		// 1 ~ 9까지 초기화
		
		int[][] arr = { {1,2,3} , 
						{4,5,6} ,
						{7,8,9} };
		// 전체 합 출력
		int sum = 0;
		for (int i= 0; i< arr.length; i++) {
			for (int x=0; x < arr[i].length; x++) { // 열의 크기
				sum +=arr[i][x];
			}
		}
		System.out.println(arr.length);
		System.out.println("열의 크기 : " + arr[0].length);
		System.out.println("전체 합 : " + sum);
		System.out.println("----------------------------------");
		
		// 행 별로 합 출력
		int hap = 0;
		
		for (int i =0; i <arr.length; i++) {
			for (int x= 0; x < arr[i].length; x++) {
				hap += arr[i][x];
			}
			System.out.printf("%d행 합 : %d\n", i, hap);
			hap =0; //hap -= hap;
		}
		System.out.println("---------------------");
		
		// 열 별로 합 출력
		// -> 완전한 사각형의 형태를 지닌 2차원 배열은
		//	  모든 열의 길이가 같다.
		int hip =0;
		
		for (int i =0; i <arr[0].length; i++) {
			for (int x= 0; x < arr.length; x++) {
				hip += arr[x][i];
			}
			System.out.printf("%d행 합 : %d\n", i, hip);
			hip =0; //hap -= hap;
		}
		
	}
	
	
	// 가변 배열
	// - 2차원 배열 생성 시 마지막 배열 차수(열)을 지정하지 않고
	//	 나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열
	public void ex3() {
		
		char[][] arr = new char[4][];
		
		arr[0] = new char[3]; // 0행에 3열짜리 1차원 배열을 생성하여 주소값을 저장(대입)
		arr[1] = new char[4]; // 1행에 4열짜리 1차원 배열을 생성하여 주소값을 저장(대입)
		arr[2] = new char[5]; // 2행에 5열짜리 1차원 배열을 생성하여 주소값을 저장(대입)
		arr[3] = new char[2]; // 3행에 2열짜리 1차원 배열을 생성하여 주소값을 저장(대입)
		
		// 각 배열 요소에 'a'부터 차례대로 대입
		
		int count = 0;
							// 행의 길이(4)
		for(int r = 0 ; r < arr.length ; r++) {	// 행 반복
								// 각 열의 길이
			for(int c = 0 ; c < arr[r].length ; c++) { // 열 반복
				arr[r][c] = (char)((int)'a' + count++);
			}
		}
		System.out.print(Arrays.deepToString(arr));
	}
	
	
	
	
	
}
