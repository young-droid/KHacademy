package edu.kh.collection.list.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.list.model.vo.Student;

public class StudentService {

	// 필드
	private List<Student> studentList = new ArrayList<>();

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentService() {
		studentList.add(new Student(1, 4, 1, "김이이", 'F', 80));
		studentList.add(new Student(1, 2, 2, "이미미", 'F', 90));
		studentList.add(new Student(2, 6, 3, "박삼삼", 'M', 100));
		studentList.add(new Student(2, 5, 4, "심도도", 'F', 70));
		studentList.add(new Student(3, 5, 5, "오강강", 'M', 70));
	}

	// alt + shift + j (메소드명 위에 커서를 둔 뒤)
	// param : parameter (전달 인자 == 전달 받은 값)
	/**
	 * @param grade
	 * @param ban
	 * @param number
	 * @param name
	 * @param gender
	 * @param score
	 * @return
	 */
	public boolean addStudent(int grade, int ban, int number, String name, char gender, int score) {

		// 전달 받은 값을 이용해서 학생 객체를 만들고
		// studentList에 추가 후
		// boolean 반환

		// 중복 검사 후 추가하기(업그레이드)
		
		boolean result
			= duplicateValidation(grade, ban, number, name, gender, score);
		
		if(result) {
			return false;
		} else { // 사실 else 쓰지 않아도 if문 안에서 false가 나왔으면 그 밖에선 무조건 true 인 상태다
			return studentList.add(new Student(grade, ban, number, name, gender, score));
		}
	}

	public List<Student> selectAllStudent() {
		return studentList;
	}

	public Student selectOne(int index) {

		if (index < 0 || index >= studentList.size()) {
			return null;
		}

		return studentList.get(index);
	}

	public Student deleteOne(int index) {
		if (index < 0 || index >= studentList.size()) {
			return null;
		}
		Student target = studentList.remove(index);
		return target;
	}

	public List<Student> selectGender(char gender) {

		// 1. 검색 결과를 저장할 List 추가 생성
		List<Student> searchList = new ArrayList<>();

		// 2. studentList에서 학생을 한명씩 꺼내서
		// 성별이 gender와 일치하는 학생을
		// searchList에 추가

		for (Student std : studentList) {
			if (gender == std.getGender()) {
				searchList.add(std);
			}
		}
		return searchList;
	}


	public List<Student> selectGrade(int grade) {
		List<Student> gradeList = new ArrayList<>();
		for (Student std : studentList) {
			if (grade == std.getGrade()) {
				gradeList.add(std);
			}
		}
		return gradeList;
	}
	
	/**
	 * 이름 검색 service 메소드
	 */
	public List<Student> selectName(String name) {
		
		List<Student> nameList = new ArrayList<>();

		for (Student std : studentList) {
			/* String(객체) 값 비교 시 A.equals(B) 사용
			 * 
			 * s.getName() == name (주소 비교)
			 * s.getName().equals(names) (객체의 값(필드) 비교)
			 * 
			 */
			
			if (name.equals(std.getName())) {
				nameList.add(std);
			}
		}
		return nameList;
	}

	public boolean duplicateValidation(int grade, int ban, int number, String name, char gender, int score) {
		
		Student s = new Student(grade, ban, number, name, gender, score);

		// * contains 사용 전제조건
		// 비교하려는 객체(클라스)에 Object의 equals()가
		// 오버라이딩 되어있어야 한다!! 
		
//		System.out.println(studentList.contains(s)); // true / false 출력 확인용
		
		return studentList.contains(s);
			
		
	}

	/** 
	 * 성적 순서로 정렬 service 메소드
	 * @return sortList
	 */
	public List<Student> sortScore() {
		// Objects / Arrays / Collections : 유용한 기능 모음

		// Collections.sort(List) : 원본 List가 정렬
		// -> 이 기능을 사용하려면
		//	  List의 요소(Student)에 정렬 기준을 정하는 코드가 있어야 함
		
		Collections.sort(studentList);
		// -> 점수 오름차순 (점점 커지는 순서) 정렬
		
		Collections.reverse(studentList);
		
		return studentList;
	}
}
