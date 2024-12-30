package edu.kh.oarr.model.service;

import java.util.Random;
import java.util.Scanner;

import javax.swing.event.ListDataEvent;

import edu.kh.oarr.model.vo.Student;

public class StudentService {
	// private
	public Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10칸짜리 묶음 Student[]을 할당하고
	// 그 주소를 studentArr에 대입
	
	// - 기본 생성자
	// 학생 객체 배열에 들어갈 샘플 학생 데이터 3개 추가
	public StudentService() {
		studentArr[0] = new Student(1, 2, 7, "조아한");
		studentArr[1] = new Student(2, 4, 13, "반휘혈");
		studentArr[2] = new Student(3, 6, 17, "천은재");
		
		Random random = new Random() ; // 랜덤 객체 생성(자바에서 제공)
		
		for(int i=0 ; i < studentArr.length ; i++) {
			// studentArr[3]부터 참조하는 학생 객체가 없음 == null
			if(studentArr[i] == null) {
				break; // 학생 객체가 없으면 반복문 멈춤
			} 
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
			// random.nextInt(101)
			// -> 0 이상 101 미만의 정수형 난수를 반환
			
		}
	}
	
	// 학생 추가 서비스
	public boolean addStudent(int grade, int ban, int number, String name) {
		// TODO Auto-generated method stub
		
		// 	1. 	studentArr의 요소 중
		//		참조하는게 없는 배열 요소를 찾아서 
		//		그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입 후
		// 		true 반환
		
		//	2. 	studentArr의 요소 중
		//		참조하는게 없는 배열 요소가 없을 경우 (꽉찬 경우)
		// 		false 반환
		
		for(int i = 0 ; i < studentArr.length ; i++) {
			if(studentArr[i] == null) {
				// 학생 객체를 생성하여 주소를 대입
				studentArr[i] = new Student(grade,ban,number,name);
				// return : 현재 메소드를 즉시 멈추고 호출한 곳으로 돌아감
				return true;
			} 
		}
		return false;
	}
	
	public Student[] selectAll() {
		
		return studentArr;
		
//		for(int i = 0 ; i < studentArr.length ; i++) {
//			if(studentArr[i] != null) {
//				System.out.println(studentArr[i].toString()); 
//			}
//		}
	}


	public Student selectIndex(int index) {
		
		// studentArr[index] 요소가 저장한 값이 null이거나
		// index가 배열 범위를 초과한 경우
		if(studentArr[index] == null ||
			index >= studentArr.length ||
			index < 0 ) { 
			return null; 
		}
		return studentArr[index];
	}

	
	public String selectIndex_personal(int index) {
		if(index < 0 || index >= studentArr.length) {
			return "정확한 인덱스 번호를 입력하세요.";
		}
		for(int i = 0 ; i < studentArr.length ; i++) {
			if(studentArr[i] != null) {
				if(studentArr[i] == studentArr[index]) {
					return studentArr[i].toString();
				}
			}
		}
		return "학생이 없습니다.";
	}


	public String selectScore(int inputIndex) {
		if(inputIndex < 0 || inputIndex >= studentArr.length || studentArr[inputIndex] == null) {
				return "해당 인덱스에 학생 정보가 존재하지 않습니다.";
		}
		
		Student s = studentArr[inputIndex];
		int sum = (s.getKor() + s.getEng() + s.getMath());
		
		return String.format("[%s] 국어: %d, 영어: %d, 수학: %d, 합계: %d, 평균: %.1f",s.getName(), s.getKor(), s.getEng(), s.getMath(), sum, sum/3.0, studentArr);
		
}


	public void updateStudent(Student std, int korScore, int engScore, int mathScore) {
		std.setKor(korScore);
		std.setEng(engScore);
		std.setMath(mathScore);
	}

		// TODO Auto-generated method stub
		
	

}
