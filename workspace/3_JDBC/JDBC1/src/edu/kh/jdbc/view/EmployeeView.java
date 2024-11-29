package edu.kh.jdbc.view;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Employee;
import edu.kh.jdbc.model.service.EmployeeService;

// View : 입,출력 담당 클래스 
// - 사용자 담당 인터페이스 요소로 사용자의 요청과 응답을 모아두는 클래스
/**
 * @author user1
 *
 */
public class EmployeeView {
	
	// 필드 
	private Scanner sc = new Scanner(System.in);
	private EmployeeService service = new EmployeeService();
	
	
	/** alt + shift + j
	 *  메인메뉴
	 */
	public void displayMenu() {
		int menuNum = -1; 
		
		do {
			try {
		
				System.out.println();
				System.out.println("====================================");
				System.out.println("[사원 관리 프로그램]");
				System.out.println("1. 전체 사원 정보 조회");
				System.out.println("2. 사번으로 사원 정보 조회");
				// ******* 3번 수정 필요
				System.out.println("3. 입력 받은 급여 이상으로 받는 모든 직원 조회"); 
				System.out.println("4. 새로운 직원 정보 추가"); 
				System.out.println("5. 직원 정보 삭제(사번 검색)"); 
				System.out.println("6. 직원 정보 수정"); 
				System.out.println("7. 부서 전체 보너스 수정"); 
				System.out.println("0. 프로그램 종료");
				System.out.println("====================================");

				System.out.print("메뉴 선택 : ");
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : selectAll(); break;
				case 2 : selectOne(); break;
				case 3 : selectSalary(); break;
				case 4 : insertEmployee(); break;
				case 5 : deleteEmployee(); break;
				case 6 : updateEmployee(); break;
				case 7 : updateBonus(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
			}
		} while(menuNum != 0);
	}
	

	/**
	 * 전체 사원 정보 조회 view
	 */
	private void selectAll() {
		System.out.println("[전체 사원 정보 조회]");
		
		// DB에서 조회해온 사원 리스트를 출력 
		
		// 1) 전체 사원 정보를 반환하는 서비스 메소드 호출
		List<Employee> empList = service.selectAll(); 
		
		
		// 2) 서비스 호출 결과를 출력 
		printList(empList);
	}
	
	/**
	 * 사번으로 사원 정보 조회 View
	 */
	private void selectOne() {
		System.out.println("[사번으로 사원 정보 조회]");
		
		// 사번 입력 받기
		System.out.print("사번 입력 : ");
		int input = sc.nextInt();
		
		Employee emp = service.selectOne(input);
		
		if(emp != null) {// 조회 결과가 없을 경우
		System.out.println(emp.toString());
		} else { // 조회 결과가 있을 경우
			System.out.println("해당 사번의 사원은 존재하지 않습니다.");
		}
	}	
	
	/**
	 * 입력 받은 급여 이상으로 받는 모든 직원 조회 view
	 */
	private void selectSalary() {

		System.out.println("[입력 받은 급여 이상으로 받는 모든 직원 조회]");
		
		// 모든 직원 출력 후 총 몇명인지도 출력
		
		// 급여 입력 받기
		System.out.print("급여 입력 : ");
		int input = sc.nextInt();

		List<Employee> empList = service.selectSalary(input);
		
		// 2) 서비스 호출 결과를 출력 
		printList(empList);
		
		System.out.println("총 인원 : " + empList.size() + "명");
		
	}

	
	/**
	 * 새로운 사원 정보 추가 view
	 */
	public void insertEmployee() {
		System.out.println("[새로운 사원 정보 추가]");
		
		System.out.print("사번 : ");
	    int empId = sc.nextInt();
	      
	    System.out.print("이름 : ");
	    String empName = sc.next();
	      
	      System.out.print("주민등록번호 : ");
	      String empNo = sc.next();
		      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("전화번호 : ");
	      String phone = sc.next();
	      
	      System.out.print("부서 코드(D1 ~ D9) : ");
	      String deptCode = sc.next();
	      
	      System.out.print("직급 코드(J1 ~ J7) : ");
	      String jobCode = sc.next();
	      
	      System.out.print("급여 : ");
	      int salary = sc.nextInt();
	      
	      System.out.print("보너스율 : ");
	      double bonus = sc.nextDouble();
	      
	      // 입력 받은 값을 Employee 객체에 저장
	      Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salary, bonus);
	      
	      // 사원 정보를 삽입하는 서비스 호출
	      int result = service.insertEmployee(emp);
	      // DML은 성공한 행의 개수를 반환한다
	      
	      if(result != 0) { // 삽입 성공
	    	  System.out.println("사원의 정보가 추가되었습니다.");
	      } else {
	    	  System.out.println("사원 정보 추가 실패");
	      }
	}
	
	
	/** 
	 * 사번으로 사원 정보 삭제
	 */
	public void deleteEmployee() {
		
		// 숙제 
		// EMPLOYEE2 테이블에서
		// 사번을 입력 받고 일치하는 사번을 가진 사원 정보 삭제 (DELETE)
		
		// 조건 1 : PreparedStatement 사용
		// 조건 2 : 삭제 성공 시 --> "삭제되었습니다" 
		// 		   삭제 실패 시 --> "일치하는 사번의 사원이 없습니다" 출력 
		
		
	System.out.println("[사번으로 사원 정보 삭제]");
		
		// 사번 입력 받기
		
		int result = service.deleteId(inputId());
		
	    if(result != 0) { // 삽입 성공
	   	  System.out.println("사원의 정보가 삭제되었습니다.");
	    } else {
	      System.out.println("사원 정보 삭제 실패");
	    }
	
	}
	

	/**
	 * 사번으로 사원 정보 수정
	 */
	private void updateEmployee() {
		System.out.println("[사번으로 사원 정보 수정]");
		
		while(true) {
			
			// 사번 입력 받기
			int input = inputId();
			
			Employee emp = service.selectOne(input);
			
			if(emp != null) {// 조회 결과가 있을 경우
			System.out.println(emp.toString());
			} else { // 조회 결과가 없을 경우
				System.out.println("해당 사번의 사원은 존재하지 않습니다.");
				continue;
			}
			
			// 이메일, 전화번호, 급여 입력 받기
			System.out.print("변경할 이메일 입력 : ");
			String email = sc.next();
			System.out.print("변경할 전화번호 입력 : ");
			String phone = sc.next();
			System.out.print("변경할 급여 입력 : ");
			int salary = sc.nextInt(); 
			
			service.updateEmployee(input,email,phone,salary);
			int result = service.updateEmployee(input,email,phone,salary);
			
		    if(result != 0) { // 삽입 성공
		   	  System.out.println("사원의 정보가 수정되었습니다.");
		   	  break;
		    } else {
		      System.out.println("사원 정보 수정 실패");
		      break;
		    }
		}
	}

	private void updateBonus() {
		System.out.print("부서 코드를 입력하세요 : ");
		String deptCode = sc.next();
		System.out.print("보너스율을 입력하세요: ");
		double bonus = sc.nextDouble();
		
		int result = service.updateBonus(deptCode, bonus);

	    if(result != 0) { // 삽입 성공
		   	  System.out.printf("%s 부서의 보너스율이 %.1f으로 변경되었습니다.", deptCode, bonus);
		    } else {
		      System.out.println("일치하는 부서코드가 존재하지 않습니다.");
		    }
		
	   // 메소드명 : updateBonus()
    // [실행화면]
    // 부서 코드를 입력하세요 : D1
    // 보너스율을 입력하세요 : 0.3
    
    // (성공 시) : D1 부서의 보너스율이 0.3으로 변경되었습니다.
    // (실패 시) : 일치하는 부서코드가 존재하지 않습니다.
    // 출력
    
    // DAO 작성 시 Statement 사용
	}
	
	/** 
	 * 사번 입력 메소드
	 * @return input - 사번
	 */
	private int inputId() {
		
		int input;
		System.out.print("사번 입력 : ");
		input = sc.nextInt();
		return input;
		
	}
	
	/**
	 * Employee List 출력용 view
	 */
	private void printList(List<Employee> empList) {
						// Employee 타입이 제한된 리스트 == Employee만 담긴 List
		
		if(empList.isEmpty()) {// 조회 결과가 없을 경우
			System.out.println("조회 결과가 없습니다.");
		} else { // 조회 결과가 있을 경우
			// 향상된 for문
			for(Employee emp : empList) {
				System.out.println(emp.toString());
			}
		}
		
	}
	
}
