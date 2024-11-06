package edu.kh.oarr.practice.model.service;

import java.util.Scanner;

import edu.kh.oarr.practice.model.vo.Employee;

public class EmployeeService {

	Scanner sc = new Scanner(System.in);
	
	private Employee[] employeeArr = new Employee[3];
	
	public EmployeeService() {
		employeeArr[0] = new Employee(10, "유관순", "마케팅팀", "부장", 5000000);
		employeeArr[1] = new Employee(20, "홍실동", "개발팀", "대리", 3500000);
		employeeArr[2] = new Employee(30, "이순신", "총무팀", "사원", 5000000);
	}
	
	
	public void ServiceSystem () {
		
		int menuNum = 0; 
		
		do {		
		System.out.println("=== 직원 관리 프로그램 === ");
		System.out.println("1. 직원 정보 입력(3명)");
		System.out.println("2. 모든 직원 정보 출력");
		System.out.println("3. 특정 직원 정보 출력(이름 검색)");
		System.out.println("4. 특정 직원 급여/연봉 출력(사번 검색)");
		System.out.println("5. 모든 직원 급여 합/연봉 합 출력");
		System.out.println("6. 모든 직원중 급여가 가장 높은 직원의 이름, 부서, 급여 출력");
		System.out.println("0. 종료");

		System.out.print("메뉴 선택 >> ");
		menuNum = sc.nextInt();
		System.out.println();
		
		switch(menuNum) {
		case 1 : employeeAdd()
			; break;
		case 2 : System.out.println( employeeInfo() )
			; break;
		case 3 : System.out.println( searchName() )
			; break;
		case 4 : searchId()
			; break;
		case 5 : wageSum()
			; break;
		case 6 : highest()
			; break;
		case 0 : System.out.println("프로그램 종료.");
			; break;
		default : System.out.println("다시 입력해 주세요."); break; 
		}
		
		} while (menuNum != 0);
		
	}
	
	// 1. 직원 정보 입력(3명)
	public void employeeAdd() {

		for(int i = 0; i < employeeArr.length ; i++) {
			System.out.printf("===%d번째 사원 정보 입력 ===\n", i+1);
			System.out.print("사번 : ");
			int employeeId = sc.nextInt();
			System.out.print("이름 : ");
			String employeeName = sc.next();
			System.out.print("부서 : ");
			String employeeDepart = sc.next();
			System.out.print("직급 : ");
			String employeePosition = sc.next();
			System.out.print("급여 : ");
			int employeeWage = sc.nextInt();
			
			employeeArr[i] = new Employee(employeeId, employeeName, employeeDepart, employeePosition, employeeWage);

			System.out.println();
		}
	}
	
	
	// 2. 직원 정보 출력
	public String employeeInfo() {
		
		String str = "";
		
		for(int i = 0; i < employeeArr.length ; i++) {
			str += employeeArr[i].toString() + "\n";
//			System.out.println(employeeArr[i].toString());
		}
		return str;
	}
	
	
	// 3. 특정 직원 정보 출력(이름 검색) 
	public String searchName() {
		System.out.println("=== 특정 사원 정보 출력(이름 검색) ===");
		
		System.out.print("\n이름 입력 : ");
		String inputName = sc.next();
		
		for(int i = 0 ; i < employeeArr.length ; i++) {
			if(inputName.equals(employeeArr[i].getEmployeeName())) {
//				System.out.println(employeeArr[i].toString());
				return employeeArr[i].toString() + "\n";
			} 
		}
		return "일치하는 사원이 없습니다.\n";
	}
	
	
	// 4. 특정 직원 급여/연봉 출력(사번 검색) 
	public void searchId() {
		System.out.println("=== 급여/연봉 조회 === ");
		
		System.out.print("\n사번 입력 : ");
		int inputId = sc.nextInt();
		
		for(int i = 0 ; i < employeeArr.length ; i++) {
			if(inputId == employeeArr[i].getEmployeeId()) {
				System.out.println("급여 : " + employeeArr[i].getEmployeeWage() +
								   " / 연봉 : " + employeeArr[i].getEmployeeWage()*12);
			} 
		}
		
//		if(!flag) {
//			System.out.println("사번이 일치하는 직원 없습니다.");
//		} 
		
		System.out.println("=== 직원 관리 프로그램 === \r\n"
				+ "1. 직원 정보 입력(3명) \r\n"
				+ "2. 모든 직원 정보 출력 \r\n"
				+ "3. 특정 직원 정보 출력(이름 검색) \r\n"
				+ "4. 특정 직원 급여/연봉 출력(사번 검색) \r\n"
				+ "5. 모든 직원 급여 합/연봉 합 출력 \r\n"
				+ "6. 모든 직원중 급여가 가장 높은 직원의 이름, 부서, 급여 출력 \r\n"
				+ "0. 종료 ");
		System.out.println();
	}
	
	
	// 5. 모든 직원 급여 합/연봉 합 출력 
	public void wageSum() {
		System.out.println("=== 모든 사원 급여 합/연봉 합 ===");
		
		int monthlyWage = 0;
		
		for(int i = 0; i < employeeArr.length ; i++) {
			if(employeeArr[i] == null) {
				break;
			} else {
				monthlyWage += employeeArr[i].getEmployeeWage();
			}
		}
	
		System.out.println("전 직원 급여 합 : " + monthlyWage + 
						   "\n전 직원 연봉 합 : " + monthlyWage * 12);
		System.out.println();
	}
	
	
	
	// 6. 모든 직원중 급여가 가장 높은 직원의 이름, 부서, 급여 출력 
	public void highest() {
	    int max = employeeArr[0].getEmployeeWage(); // 최고 급여를 저장할 변수

	    // 최고 급여 찾기
	    for (int i = 1; i < employeeArr.length; i++) {
	        if (employeeArr[i].getEmployeeWage() > max) {
	            max = employeeArr[i].getEmployeeWage();
	        }
	    }

	    System.out.println("=== 최고 급여를 가진 직원 목록 ===");
	    
	    // 최고 급여와 동일한 직원 출력
	    for (int i = 0; i < employeeArr.length; i++) {
	        if (employeeArr[i].getEmployeeWage() == max) {
	            System.out.println("이름 : " + employeeArr[i].getEmployeeName() + 
	                               ", 부서 : " + employeeArr[i].getEmployeeDepart() +
	                               ", 급여 : " + employeeArr[i].getEmployeeWage());
	        }
	    }
	    System.out.println();
	}

	public void deleteUser() {
		
	}
	
	
}
