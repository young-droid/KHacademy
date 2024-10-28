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
		
	
	
	
	
	
	
}
