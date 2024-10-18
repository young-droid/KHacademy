package edu.kh.variable;

import java.util.Scanner;

public class ScannerExample5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("입력 1 : ");
		String input = sc.next() + " ";
					// 오늘	
		
		System.out.print("입력 2 : ");
		input = input + sc.next() + " ";
					//점심

		System.out.print("입력 3 : ");
		input = input + sc.next();
					// 뭐먹지? 
		
		System.out.print(input);
		
		
		
		
		
		
	}
	
}
