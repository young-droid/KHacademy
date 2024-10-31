package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;

public class ClsService {

	public void ex1() {
		// 클래스 접근 제한자 확인하기

		Student std = new Student();
		// public 
		
		System.out.println("다른 패키지");
		
		System.out.println(std.t1);
		// 다른 패키지에서도 접근 가능한 public
		
//		System.out.println(std.t2);
//		System.out.println(std.t3);
//		System.out.println(std.t4);
		
	}
	
	public void ex2() {
		// static 필드 확인 예제
		
		/*
		 Static
		 1) 공유 메모리 영역 (또는 정적 메모리 영역) 이라고 함
		 왜? 프로그램 시작 시 static이 붙은 코드들은 모두 static 영역에 생성되고,
		 	프로그램이 종료될 때 까지 사라지지 않음 (정적)
		 	그리고 static 영역에 생성된 변수는 어디서든지 공유할 수 있다. (공유)
		 
		 2) 사용 방법 : 클래스명.변수명
		 
		 
		 */
		
		
		// 학생 객체 2개 생성
		
		Student std1 = new Student();
		Student std2 = new Student(); 
		Student std3 = new Student(); 
		
		
		// 학생 객체에 이름 세팅 
		std1.setName("이소은");
		std2.setName("장하림");
		
		
		// 정보 출력
		System.out.println(std1.schoolName); // public이기 때문에 직접 접근 가능
		System.out.println(std1.getName());
		
		System.out.println(std2.schoolName); // public이기 때문에 직접 접근 가능
		System.out.println(std2.getName());
		
		System.out.println("std3 name : " + std3.getName());
		
 		 
		// schoolName 변경
		std1.schoolName = "KH초등학교";		
		System.out.println("변경 후 std1의 학교 : " + std1.schoolName); 
		System.out.println("std2의 학교 : " + std2.schoolName);
		
		// The static field Student.schoolName should be accessed in a static way
		// schoolName에 노란줄이 뜨는 이유 -> 제대로 작성하지 않아서
		
		// ** static이 붙은 필드(변수)는 클래스명.변수명으로 사용! 
		Student.schoolName = "KH중학교";
		System.out.println("Student.schoolName : " + Student.schoolName);
	}
	
	
}
