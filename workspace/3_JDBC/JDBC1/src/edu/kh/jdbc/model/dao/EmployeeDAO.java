package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO (Data Access Object) : 데이터 접근 객체
// DB와 연결되어 SQL을 수행하고 결과를 반환 받는 역할
public class EmployeeDAO {

	// 필드
	// JDBC 객체 저장용 참조 변수 필드 선언
	private Connection conn; // DB 연결 정보를 담은 객체(Java - DB 사이의 통로 역할 )
	private Statement stmt;	// Connection을 통해서 SQL을 실행하고, 결과를 반환받는 객체
	
	private PreparedStatement pstmt;
	// Statement의 자식으로 좀 더 향상된 기능을 제공
	// - ?(위치홀더)를 이용하여 SQL에 작성되어지는 리터럴을 동적으로 제어함
	// -> 오타 위험 감소, 가독성 상승 
	
	
	
	private ResultSet rs;// SELECT 수행 후 반환되는 객체
	
	
	/** 전체 사원 정보 조회 서비스
	 * @return empList
	 */
	public List<Employee> selectAll() {

		// 결과 저장용 변수 선언
		List<Employee> empList = new ArrayList<Employee>();

		try {
			// 1. Oracle JDBC Driver 메모리 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			
			// 2. DB 연결 작업(Connection) 얻어오기
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // DB 서버 컴퓨터 IP
			// localhost == 127.0.0.1
			String port = ":1521";
			String sid = ":XE"; // DB 이름
			String user = "KH_CYJ"; // 사용자명
			String pw = "KH1234";	// 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid, user ,pw);
			
			// 3. 수행할 SQL 작성
			String sql = "SELECT * FROM EMPLOYEE2";
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 6. 결과를 List에 옮겨 담기
			// -> ResultSet을 한 행씩 접근하여 컬럼 값을 얻어와
			// 	  한 행의 정보가 담긴 Employee 객체 생성하고
			// 	  이를 empList에 추가
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE"); 
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS");
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
				// rs.getChar()는 존재하지 않음
				// 왜? 자바에서는 문자하나(char)의 개념이 있지만
				// 	  DB는 오로지 문자열 개념만 존재함
				// -> String.charAt(0) 을 사용
				
				Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
				empList.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 사용한 JDBC 자원 반환 (역순으로 close)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// 8. List 호출부로 반환 
		return empList;
	}


	public Employee selectOne(int input) {
		
		Employee emp = null;

		try {
			// 1. Oracle JDBC Driver 메모리 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			
			// 2. DB 연결 작업(Connection) 얻어오기
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // DB 서버 컴퓨터 IP
			// localhost == 127.0.0.1
			String port = ":1521";
			String sid = ":XE"; // DB 이름
			String user = "KH_CYJ"; // 사용자명
			String pw = "KH1234";	// 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid, user ,pw);
			
			// 3. 수행할 SQL 작성
			String sql = "SELECT * \r\n"
					+ "FROM EMPLOYEE2 \r\n"
					+ "WHERE EMP_ID = " + input + "";
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 6. 결과를 List에 옮겨 담기
			// -> ResultSet을 한 행씩 접근하여 컬럼 값을 얻어와
			// 	  한 행의 정보가 담긴 Employee 객체 생성하고
			// 	  이를 empList에 추가
			
			while(rs.next()) {
			
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE"); 
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS");
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
				// rs.getChar()는 존재하지 않음
				// 왜? 자바에서는 문자하나(char)의 개념이 있지만
				// 	  DB는 오로지 문자열 개념만 존재함
				// -> String.charAt(0) 을 사용
				
				emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYn);;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 사용한 JDBC 자원 반환 (역순으로 close)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// 8. List 호출부로 반환 
		return emp;
		
	}

	
	
	
	

	public List<Employee> selectSalary(int input) {
		
		List<Employee> empList = new ArrayList<Employee>(); 
		
		try {
			// 1. Oracle JDBC Driver 메모리 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			
			// 2. DB 연결 작업(Connection) 얻어오기
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // DB 서버 컴퓨터 IP
			// localhost == 127.0.0.1
			String port = ":1521";
			String sid = ":XE"; // DB 이름
			String user = "KH_CYJ"; // 사용자명
			String pw = "KH1234";	// 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid, user ,pw);
			
			// 3. 수행할 SQL 작성
			String sql = "SELECT * \r\n"
					+ "FROM EMPLOYEE2 \r\n"
					+ "WHERE SALARY >= " + input;
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 6. 결과를 List에 옮겨 담기
			// -> ResultSet을 한 행씩 접근하여 컬럼 값을 얻어와
			// 	  한 행의 정보가 담긴 Employee 객체 생성하고
			// 	  이를 empList에 추가
			
			while(rs.next()) {
			
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String deptCode = rs.getString("DEPT_CODE"); 
				String jobCode = rs.getString("JOB_CODE");
				String salLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS");
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);
				// rs.getChar()는 존재하지 않음
				// 왜? 자바에서는 문자하나(char)의 개념이 있지만
				// 	  DB는 오로지 문자열 개념만 존재함
				// -> String.charAt(0) 을 사용
				
				Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
				empList.add(emp);
				
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 사용한 JDBC 자원 반환 (역순으로 close)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return empList;
	}


	/** 새로운 사원 정보 추가 DAO
	 * @param emp
	 * @return result
	 */
	public int insertEmployee(Employee emp) {
		
		int result = 0; // 결과 저장용 변수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // DB 서버 컴퓨터 IP
			// localhost == 127.0.0.1
			String port = ":1521";
			String sid = ":XE"; // DB 이름
			String user = "KH_CYJ"; // 사용자명
			String pw = "KH1234";	// 비밀번호
			
			conn = DriverManager.getConnection(type + ip + port + sid, user ,pw);
			
			// SQL 작성
			String sql = "INSERT INTO EMPLOYEE2 VALUES(?, ?, ?, ?, ?, ?, ?, 'S1' , ?, ?, 200, SYSDATE, NULL, 'N')";
						// ? 기호 == 위치 홀더
			
			// Statement : 커넥션 생성 - SQL 작성 - Statement 객체 생성 - SQL 수행 후 결과 반환
			
			// PreparedStatement : 커넥션 생성 - SQL 작성 (? 사용) - PreparedStatement 객체 생성 (sql 적재) 
			//					 - 위치홀더에 알맞는 값 대입 - SQL 수행 후 결과 반환
			
			
			// 4. PreparedStatement 객체 생성(sql 적재)
			pstmt = conn.prepareStatement(sql);
			
			// 5. 위치홀더에 알맞은 값 대입
			// pstmt.set[Type](위치홀더 순서, 값)
			
			pstmt.setInt(1, emp.getEmpId()); // 입력 받은 사번을 1번 위치홀더(?)에 세팅
			pstmt.setString(2, emp.getEmpName()); 
			pstmt.setString(3, emp.getEmpNo()); 
			pstmt.setString(4, emp.getEmail()); 
			pstmt.setString(5, emp.getPhone()); 
			pstmt.setString(6, emp.getDeptCode()); 
			pstmt.setString(7, emp.getJobCode()); 
			pstmt.setInt(8, emp.getSalary()); 
			pstmt.setDouble(9, emp.getBonus()); 
			
			// 6. SQL 수행 후 결과 반환
			
			// 1) Statement - SELECT			: stmt.executeQuery(sql);
			// 2) PreparedStatement - SELECT	: pstmt.executeQuery(); <- sql 다시 담지 않음 
			
			// *** DML 수행 시 executeUdate 사용 ***
			// 3) Statement - DML			: stmt.executeUpdate(sql);
			// 4) PreparedStatement - DML 	: pstmt.executeUpdate(); <- sql 다시 담지 않음
			
			result = pstmt.executeUpdate(); // DML(INSERT, UPDATE, DELETE) 수행 후
											// 성공한 행의 개수를 반환 
											// 조건에 맞는 행이 없으면 0 반환 
			
			
			// 트랜잭션 제어
			if(result > 0) conn.commit(); // DML 성공 시 commit 수행
			else		   conn.rollback(); // DML 실패 시 rollback 수행
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 사용한 자원 반환
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

// ===========================================================================================
	public int deleteId(int input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
