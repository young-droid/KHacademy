package edu.kh.collection.list.model.vo;

import java.util.Objects;

public class Student {

    private int grade;
    private int ban;
    private int number;
    private String name;
    private char gender;
    private int score;
	
    public Student() {};
    
    public Student(int grade, int ban, int number, String name, char gender, int score) {
		super();
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
//	@Override
//	public String toString() {
//		return "Student [grade=" + grade + ", ban=" + ban + ", number=" + number + ", name=" + name + ", gender="
//				+ gender + ", score=" + score + "]";
//	}
	
	@Override
	public String toString() {
		return String.format("%s 학생(%c) : %d학년 %d반 %d번 / 점수: %d", name, gender, grade, ban, number, score);
    
	}

	@Override
	public int hashCode() {
		return Objects.hash(ban, gender, grade, name, number, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return ban == other.ban && gender == other.gender && grade == other.grade && Objects.equals(name, other.name)
				&& number == other.number && score == other.score;
	}
    
	// A.equals(B)
	// A 객체와 B 객체가 가지고 있는 필드의 값이 모두 같으면 true, 아니면 false
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(this == obj) { // 같은 객체 참조
//			return true;
//		}
//		
//		if(obj == null) { // 비교 대상이 null
//			return false;
//		}
//		
//		if( !(obj instanceof Student) ) {
//			return false;
//		}
//		
//		// obj 참조 변수를 Student로 다운캐스팅
//		Student other = (Student)obj;
//		
//		// 현재 객체(this)와 다른 객체(other)의 필드를 비교
//		return this.grade == other.grade 
//				&& this.ban == other.ban
//				&& this.number == other.number
//				&& this.name.equals(other.name)
//				&& this.gender == other.gender
//				&& this.score == other.score ;
//		
//	}
	
}
