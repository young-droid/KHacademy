package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	
	// 3행 3열짜리 문자열 배열을 선언 및 할당하고
	// 인덱스 0행 0열 부터 2행 2열까지 차례대로 접근하여 "(0,0)"과 같은 형식으로 저장 후 출력하세요. 
	public void practice1() {
		
//		(0, 0)(0, 1)(0, 2)
//		(1, 0)(1, 1)(1, 2)
//		(2, 0)(2, 1)(2, 2)
		
		String [][] arr = new String[3][3];
		
		for(int row = 0 ; row < arr.length ;row++) {
			for(int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = "(" + row + ", " + col + ")";
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}

	// 4행 4열짜리 정수형 배열을 선언 및 할당하고
	// 1) 1~16 까지 값을 차례대로 저장하세요
	// 2) 저장된 값들을 차례대로 출력하세요. 
	public void practice2() {
		
		int[][] arr = new int[4][4];
		
		int sum = 0;
		
		for(int row = 0 ; row < arr.length ; row ++) {
			for(int col = 0 ; col < arr.length ; col ++) {
				arr[row][col] = sum++;
				
				System.out.printf("%4d",arr[row][col]);			
			}
			System.out.println();
		}
	}

	
	// 4행 4열짜리 정수형 배열을 선언 및 할당하고
	// 1) 16~1 까지 값을 거꾸로 저장하세요
	// 2) 저장된 값들을 차례대로 출력하세요. 	
	public void practice3() {
		
		int[][] arr = new int[4][4];

		int sum = 16;

		for(int row=0; row<arr.length ; row++) {
			for(int col=0; col<arr[row].length ; col++) {
				arr[row][col] = sum--;
				System.out.printf("%4d",arr[row][col]);			
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		int[][] arr = new int[4][4];
		
		int sum = 0;
		
		for(int row = 0 ; row < 4 ; row++) {
//			int sumRow = 0;
			int sumCol = 0;
			for(int col = 0 ; col < 4 ; col++) {
				int rand = (int)(Math.random()*10+1);
				
				
//				if(row < 3) {
//					sumRow += arr[col][row];
//				}
				
				// arr[0][0] ~ arr[3][3] 일 때
				if(col < 4) {
					arr[row][col] = rand;
					System.out.printf("%-4d", arr[row][col]);
					sumCol += arr[row][col];
				} else if(col == 4) {
					System.out.printf("%-4d", sumCol);
				}
				
				sum += arr[row][col];
//				arr[3][col] = sumCol;
//				
//				arr[col][3] = sumRow;
				
			}
			System.out.println();
		}
		System.out.println(sum);
		
	}
	
	
	public void practice4_answer() {
		int[][] arr = new int[4][4];
		
		final int ROW_LAST_INDEX = arr.length - 1;
		final int COL_LAST_INDEX = arr[0].length - 1;
		
		for(int row = 0; row<arr.length; row++) { // 행 반복
			for(int col = 0; col<arr[row].length; col++) { // 열 반복
			
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					int random = (int)(Math.random()*10+1);
					
					arr[row][col] = random;
					
					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];
					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					// 마지막 인덱스에 난수를 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				System.out.printf("%4d ", arr[row][col]);
				
			} // 열 반복 끝
			System.out.println();			
		} // 행 반복 끝
		
	}

	// 2차원 배열 크기 입력, 1~10 숫자
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		int inputRow = 0;
		int inputCol= 0;
		
		while(true) {
			System.out.print("행 크기: ");
			inputRow = sc.nextInt();
			System.out.print("열 크기: ");
			inputCol = sc.nextInt();
			
			// 잘못 입력 시
			if(inputRow < 1 || inputRow > 10 || inputCol < 1 || inputCol > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다. 다시 입력하세요.");
			} 
			// 잘 입력 시 
			else {
				// 배열 선언
				char[][] arr = new char[inputRow][inputCol];

				for(int row=0 ; row < arr.length ; row++) { // 행 길이만큼 반복
					for(int col=0 ; col < arr[row].length ; col++) { // 열 길이만큼 반복
						arr[row][col] = (char)(int)(Math.random()*26 + 65);
						System.out.print(arr[row][col] + " ");
					}
					System.out.println();
				}
				break;
			}
		}	
	}
}
