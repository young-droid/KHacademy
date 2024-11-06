package edu.kh.objarray.practice.model.vo;

public class Student {

	private int grade;
	private int classroom;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
//	 학년 
//	 반 
//	 이름 
//	 국어점수 
//	 영어점수 
//	 수학점수 

	public Student() {
		
	}
	
	public Student(int grade, int classroom, String name, int kor, int eng, int math) {
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math= math;
	}

	
	// getter / setter
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("%d학년 %d반 %s >> 국어 : %d, 영어 : %d, 수학 : %d, 평균 : %d ", grade, classroom, name, kor, eng, math, (kor+eng+math)/3);
		
	}
	

	
}
