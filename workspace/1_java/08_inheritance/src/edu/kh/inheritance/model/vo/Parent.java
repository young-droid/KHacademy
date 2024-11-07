package edu.kh.inheritance.model.vo;

public class Parent extends Object {
							// 모든 클래스의 최상위 클래스
							// 미작성 시 컴파일러가 추가

	private int money = 100_000_000;
	private String lastName = "전";
	
	public Parent() {
		System.out.println("Parent() 기본 생성자로 부모 객체 생성");
	}

	public Parent(int money, String lastName) {
		System.out.println("Parent(int, String) 매개변수 생성자로 부모 객체 생성");
		this.money = money;
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override  // Object의 toString() 오버라이딩
	public String toString() {
		return money + " / " + lastName;
	}
	
}
