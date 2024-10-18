package edu.kh.operator.ex;

import java.util.Scanner;

public class OpExample3 {

	public static void main(String[] args) {
		/* [배수 확인 프로그램]
		 * 확인할 수 : 15
		 * 배수 : 7
		 * 
		 * 15는 7의 배수 입니까? false
		 * 
		 * */
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("[배수 확인 프로그램]");
		
		System.out.print("확인할 수 : ");
		int input1 = sc.nextInt();
		System.out.print("배수 : ");
		int input2 = sc.nextInt();
		
		System.out.printf("%d는 %d의 배수 입니까? %b", input1, input2, input1 % input2 == 0);
		
		
		
		
		
		
		
		
		
	}
}
