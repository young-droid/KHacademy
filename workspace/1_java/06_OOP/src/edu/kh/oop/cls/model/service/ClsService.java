package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.User;

public class ClsService {

	// 클래스 접근 제한자 확인하기
	public void ex1() {

		Student std = new Student();
		// public 
		
		System.out.println("다른 패키지");
		
		System.out.println(std.t1);
		// 다른 패키지에서도 접근 가능한 public
		
//		System.out.println(std.t2);
//		System.out.println(std.t3);
//		System.out.println(std.t4);
		
	}
	
	// static 필드 확인 예제
	public void ex2() {
		
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
	
	
	// 생성자 확인 테스트
	public void ex3() {

		
		// Student 객체를 기본 생성자를 이용해서 생성하고 이를 참조하는 참조변수 s1에 대입
		Student s1 = new Student(); 
							//기본생성자
		// 자료형 변수 = new 객체 생성자

		// User 기본 생성자를 이용해서 객체 생성
		User u1 = new User();

		// User 객체 필드 초기화 확인
		System.out.println("UserId : " + u1.getUserId());
		System.out.println("UserPw : " + u1.getUserPw());
		System.out.println("UserName : " + u1.getUserName());
		System.out.println("UserAge : " + u1.getUserAge());
		System.out.println("UserGender : " + u1.getUserGender());
		
		// User 기본 생성자를 이용해서 객체 생성
		User u2 = new User();
		
//		System.out.println("UserId : " + u2.getUserId());
//		System.out.println("UserPw : " + u2.getUserPw());
//		System.out.println("UserName : " + u2.getUserName());
//		System.out.println("UserAge : " + u2.getUserAge());
//		System.out.println("UserGender : " + u2.getUserGender());
		
		// 문제점 : 	u1이 참조하고 있는 User 객체와
		//			u2가 참조하고 있는 User 객체의 필드 값이 모두 동일함
		//		why? 같은 기본 생성자로 User 객체를 생성했기 때문에
		System.out.println("--------------");
		
		// 해결 방법 1 : setter를 이용해서 새로운 값 대입
		
		u2.setUserId("user02");
		u2.setUserPw("pass02");
		u2.setUserName("유저이");
		u2.setUserAge(24);
		u2.setUserGender('여');
		
		System.out.println("UserId : " + u2.getUserId());
		System.out.println("UserPw : " + u2.getUserPw());
		System.out.println("UserName : " + u2.getUserName());
		System.out.println("UserAge : " + u2.getUserAge());
		System.out.println("UserGender : " + u2.getUserGender());
		
		
		// 해결 방법 2 : 	매개변수 생성자를 이용해서
		//				객체가 생성 될 때 부터 다른 값으로 필드를 초기화
		

		
		
		User u3 = new User("user04", "pass04"); // 매개변수 생성자
		
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
	}
	
	// 매개변수 생성자 예제
	public void ex4() {
		
		User u1 = new User(); // 기본 생성자
		User u2 = new User("user02", "pass02"); // 매개변수 2개 생성자
		User u3 = new User("user03", "pass03", "윈터", 27, '남');
		User u4 = new User("user04", "pass04", "제니", 32, '여');
		User u5 = new User("user05", "pass05", "최현석", 45, '남');
		
		System.out.printf("u1 : %s / %s / %s / %d / %c\n",
		        u1.getUserId(), u1.getUserPw(), u1.getUserName(), u1.getUserAge(), u1.getUserGender());
		
		System.out.printf("u2 : %s / %s / %s / %d / %c\n",
				u2.getUserId(), u2.getUserPw(), u2.getUserName(), u2.getUserAge(), u2.getUserGender());
		
		System.out.printf("u3 : %s / %s / %s / %d / %c\n",
				u3.getUserId(), u3.getUserPw(), u3.getUserName(), u3.getUserAge(), u3.getUserGender());
		
		System.out.printf("u4 : %s / %s / %s / %d / %c\n",
				u4.getUserId(), u4.getUserPw(), u4.getUserName(), u4.getUserAge(), u4.getUserGender());
		
		System.out.printf("u5 : %s / %s / %s / %d / %c\n",
				u5.getUserId(), u5.getUserPw(), u5.getUserName(), u5.getUserAge(), u5.getUserGender());
		
		
	}
	
}
