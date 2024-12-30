package edu.kh.inheritance.model.vo;

//상속 키워드 : extends
//public class 자식클래스 extends 부모클래스 {}

public class Child extends Parent {
	
	private String car;
	
	public Child() {
		super();
		System.out.println("child() 기본 생성자로 자식 객체 생성");	
		}

	public Child(String car) {
		super(); // super 생성자 == 부모(Parent) 생성자
		
		this.car = car;
		
		System.out.println("child(String) 매개변수 생성자로 자식 객체 생성");
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + car;
	}
	
	@Override
	public int getMoney() {
		System.out.println("오버라이딩 된 getMoney()");
		return super.getMoney() * 2;
	}
	
	
}
