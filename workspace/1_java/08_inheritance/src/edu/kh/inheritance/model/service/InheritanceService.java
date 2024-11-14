package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Child;
import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Parent;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		// 상속 확인
		// - Person을 상속받은 Student가
		// Person의 필드, 메소드를 사용할 수 있을까? 
		
		Person p = new Person();
		
		p.setName("고윤정");
		p.setAge(29);
		p.setNationality("대한민국");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
		
		
		System.out.println("--------------------------");
		
		
		Student std = new Student();
		
		// Student만의 고유한 메소드
		std.setGrade(1);
		std.setClassroom(7);
		
		// Person 클래스로부터 상속받은 메소드
		std.setName("노윤서");
		std.setAge(34);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassroom());
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		
		System.out.println("--------------------------");
		
		
		Employee emp = new Employee();
		
		emp.setCompany("KH정보교육원");
		
		emp.setName("소화");
		emp.setAge(17);
		emp.setNationality("중국");
		
		System.out.println(emp.getCompany());
		
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		System.out.println("--------------------------");

		// 추가된 breath() 확인하기
		
	}

	
	// super() 생성자 사용 방법
	public void ex2() {
		// Student 매개변수 5개 짜리 생성자
		Student std = new Student("김민석", 32, "대한민국", 2, 7);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		System.out.println(std.getGrade());
		System.out.println(std.getClassroom());
		
	}
	
	// 오버라이딩 확인 예제
	public void ex3() {
		
		Student std = new Student();
		Employee emp = new Employee("ㅇㅇ", 22, "ㅋㄹㅇ", "컴퍼니");
		
		std.move(); // 오버라이딩 X -> 부모 Person의 메소드 수행
		System.out.println(emp.toString()); // 오버라이딩 O -> Employee 메소드 수행
		System.out.println(std.isNull());
		
	}
	
	public void ex4() {
		// 모든 클래스는 Object 클래스의 후손
		// == 모든 클래스의 최상위 부모는 Object
		
		// 1) Object 상속 여부 확인
		Person p = new Person (); // Object를 상속 받은 Person 객체 생성
		
		Student std = new Student(); // Person을 상속 받은 Student 객체 생성
		// Object - Person - Student
		
		Scanner sc = new Scanner(System.in);
		
		String str = "adc";
		
		
		// * Object 상속과 단계적인 상속 확인
		System.out.println(p.hashCode()); // Object 에서 물려 받은 hashCode()
		System.out.println(std.getAge()); // Person 에서 물려 받은 getAge()
		
		System.out.println(std.hashCode()); 
		// Person이 Object에서 물려 받은 hashcode()를
		// Student가 물려 받아서 또 사용
		
		// -> 상속의 상속의 상속의 ... 상속 가능
		// * Object가 모든 클래스의 최상위 부모인지 확인
		System.out.println(sc.hashCode());
		System.out.println(str.hashCode());
		
	}
	
	public void ex5() {
		
		Person p = new Person("박서준", 35, "대한민국");
		
		System.out.println(p.toString());
		System.out.println(p);
		// print 구문 수행 시 참조 변수명을 작성하면
		// 자동으로 toString(") 메소드를 호출해서 출력한다! 
		
		System.out.println("--------------------------");

		Student std = new Student("로제", 26, "호주", 2, 3);
		System.out.println(std.toString());
		// 1) Student 클래스 toString() 오버라이딩 전
		// Person으로부터 상속 받은 오버라이딩된 toString() 수행
		
		// 2) Student 클래스 toString() 오버라이딩 진행 후
		// Student의 toString() 수행
		
		Employee emp = new Employee("홍길동", 34, "한국", "KH");
		System.out.println(emp);
		
		
	}
	
	public void ex6() {
		// 부모 객체 생성
		Parent p1 = new Parent();
		Parent p2 = new Parent(1000000,	"홍");
		
		System.out.println("--------------------------");

		Child c1 = new Child();
		Child c2 = new Child("지바겐");
		
		System.out.println("--------------------------");

		System.out.println(p2.toString());
		System.out.println(p2);
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("--------------------------");
		System.out.println(c2.getMoney());
		// StackOverFlowError 주의
		
	}
	
}
