package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {

	Scanner sc = new Scanner(System.in);
	
	public void homework() {

		// 1.
		// 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
		Student[] std = new Student[3];

		// 위의 사용데이터 참고하여 3명의 학생 정보 초기화
		std[0] = new Student("카리나", 20, 168.2, 70.0, 1, "정보시스템공학과");
		std[1] = new Student("정해인", 21, 187.3, 80.0, 2, "경영학과");
		std[2] = new Student("박서준", 23, 179.0, 45.0, 4, "정보통신공학과");

		// 위의 학생 정보 모두 출력 --> 향상된 for문 이용해서
		for (Student s : std) {
			System.out.println(s.toString());
		}

		
		// 2.
		// 최대 10명의 사원 정보를 기록할 수 있게 객체 배열을 할당
		Employee[] emp = new Employee[10];
		
		emp[0] = new Employee("박보검", 26, 180.3, 72.0, 100000000, "영업부");
		// 사원들의 정보를 키보드로 계속 입력 받고   --> while(true) 무한 반복문을 통해 

		int count = 0;
		
		while(count < emp.length) {
			
			System.out.println("===== 사원 정보 추가 =====");
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("신장 : ");
			double height = sc.nextDouble();
			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			System.out.print("부서 : ");
			String dept = sc.next();
			
			count++;

			System.out.println("계속 추가하시겠습니까? (Y / N) : ");
			char confirm = sc.next().toUpperCase().charAt(0);
			if(confirm == 'Y') {

			} else if(confirm == 'N') {
				System.out.println("여기 틀림 다시 확인 ㄱㄱ");
				break;
			} else {
				System.out.println("구현 더해라");
				break;
			}

			// 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가 

			// 한 명씩 추가 될 때마다 카운트함 

			// 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장 
			for(int i = 0; i <= count ; i ++) {
				if (emp[i] == null) {
					emp[i] = new Employee(name, age, height, weight, salary, dept);
				}
			}
		}

		// 현재 기록된 사원들의 정보를 모두 출력 
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				System.out.println(emp[i].toString());
			}
		}

	}

}
