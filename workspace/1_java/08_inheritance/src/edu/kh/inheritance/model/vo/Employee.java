package edu.kh.inheritance.model.vo;

public class Employee extends Person {
	// Person을 상속 받음
	private String company = "뫄뫄 컴패니";

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, String nationality, String company) {
		super(name, age, nationality);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// Person으로 부터 상속 받은 메소드 중
	// move() 메소드를 Employee에 맞게 재정의(== 오버라이딩)
	
	// 어노테이션 Annotation : 컴파일러에게 알려주기 위한 코드
	// (컴파일러 인식용 주석)

	// @Override 어노테이션 : 해당 메소드가 오버라이딩 되었음을 알려주는 역할
	@Override
	public void move() {
		// System.out.println("걸을 수 있다.");
		System.out.println("(오버라이딩된 move() 메소드)");
		System.out.println("스트레칭을 한다.");
	}

	@Override
	public String toString() {
		return "Employee : " + super.toString() + " / " + company;
	}

	//	 *** 오버라이딩 성립 조건 ***
	//	 1. 메소드 이름 동일
	//	 2. 반환형 동일
	//	 3. 매개변수 동일
	//	 4. 접근제한자 같거나 더 넓은 범위
	//	 	ex) (부모) protected -> (자식) protected 또는 public
	//	 5. 예외처리 범위는 같거나 더 좁게

	// + 부모의 private 메소드는 오버라이딩 불가
	// 왜? 자식이 접근할 수 없기 때문에
	
	
}
