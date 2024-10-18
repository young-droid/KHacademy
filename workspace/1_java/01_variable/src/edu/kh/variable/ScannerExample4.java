package edu.kh.variable;

import java.util.Scanner;

public class ScannerExample4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ex) 
		// 이름	:  카리나
		// 나이	: 28
		// 성별	: 여자
		// 키	: 168.4 
		// 연봉	: 1000000000
	
		// 카리나님은 28세 여자이고 키는 168.4, 연봉은 1000000000 입니다. 
		
		String result = "";
		
		System.out.print("이름 : ");
		String name = sc.next();
		result = name + "님은 ";

		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		result = result + age + "세 ";

		
		System.out.print("성별 : ");
		String gender = sc.next();
		result = result + gender + "이고 키는 ";

				
		System.out.print("키 : ");
		double height = sc.nextDouble();
		result = result + height + "cm, 연봉은 ";

		
		System.out.print("연봉 : ");
		long salary = sc.nextLong();
		result = result + salary + "입니다.";

		System.out.println(result);
		
		System.out.printf("%s님은 %d세 %s이고 키는 %.1fcm, 연봉은 %d입니다.", name, age, gender, height, salary);
	
		
		
		
		
	}
	
}
