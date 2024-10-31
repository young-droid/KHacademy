package edu.kh.oop.cls.model.vo;

public class Student { // 클래스 선언부
// [접근제한자] [예약어] 
	
	// 1. 필드(field == 멤버 변수) : 객체의 속성
	
	// 인스턴스 변수 : 인스턴스(객체) 생성 시 메모리에 할당되는 변수
	
	// 클래스 변수(== static 변수) : 필드에 static 예약어가 작성된 변수
	// 왜? 같은 클래스로 만들어진 객체가 값을 공유할 수 있기 때문에
	
// [작성법] 
// [접근제한자] [예약어] 자료형 변수명 [= 초기값];
//
// 접근제한자 종류
//
// + public		: 같은 패키지 + 다른 패키지 (모두, 어디서든) 접근 가능
// # protected 	: 같은 패키지 + 다른 패키지 중 상속 관계 클래스에서만 접근 가능
// ~ (default)	: 같은 패키지 내부에서만 접근 가능
// - private 	: 현재 클래스 (정확히는 현재 객체) 내부에서만 접근 가능	
	
	
	public int t1 = 10;
	protected int t2 = 20; 
	int t3 = 30; 
	private int t4 = 40; 
	
	public void ex() {
		System.out.println("같은 클래스 내부");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
	}
		
	//------------------------------------
	
	// static 예약어
	public static String schoolName = "KH유치원";
	
	private String name; // 캡슐화 원칙 때문에 private -> 간접 접근 방법 필요

	{
		name = "홍길동";
	}
	
	
	// getter / setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
