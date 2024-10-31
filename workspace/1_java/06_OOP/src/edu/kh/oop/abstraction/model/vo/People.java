package edu.kh.oop.abstraction.model.vo;

// VO (Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People {	// 국민의 정보를 저장할 객체를 위한 클래스 (설계도)
	
	// 클래스란? 객체의 특성(속성, 기능) 을 정의한 것
	// == 객체를 만들기 위한 설계도
	
	// 캡슐화 (Encapsulation) 
	// - 데이터와 기능을 하나로 묶어서 관리하는 기법
	// - 데이터의 직접적인 접근을 제한하는 것이 원칙
	// -> 직접 접근을 제한하기 때문에 
	
	
	// 속성 == 값== data
	// 값을 저장하기 위한 변수 선언
	
	private String name; 	// 이름
	private char gender; 	// 성별
	private String address; 	// 주소
	private String phone; 	// 전화번호
	private int age; 		// 나이
	private String pNo; 		// 주민등록번호
	private String job;		// 직업
	
	// 기능 == 행동 == method
	public void tax() {
		System.out.println("세금 납부하기");
	}
	
	public void vote() {
		System.out.println("투표하기");
	}
	
	public void introduce() {
		System.out.printf("제 이름은 %s이고, 직업은 %s입니다.\n", name, job);
	}
	
	// 캡슐화에서 사용할 간접 접근 방법 기능(getter / setter)
	
	public void setName(String name) {	// setter
		// 외부로 부터 전달 받은 name을
		// 현재 객체의 속성 중 name(== this.name)에 대입
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getJob() {
		return job;
	}
	
	
	
}
