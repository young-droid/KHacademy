package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample4 {
	public static void main(String[] args) {
	
		Connection conn = null;	// DB 연결 정보를 저장한 객체
		Statement stmt = null;	// DB에 SQL 수행 -> 결과를 반환 받는 객체
		ResultSet rs = null; 	// SELECT 결과를 저장하는 객체 
		
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
			
			Scanner sc = new Scanner(System.in);
			System.out.print("부서명 : ");
			String input = sc.next(); 
			
			
			
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE , JOB_NAME \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING (JOB_CODE)\r\n"
					+ "WHERE DEPT_TITLE = '" + input + "' \r\n"
					+ "ORDER BY JOB_CODE";
			
			// Stmt 객체 생성
			stmt = conn.createStatement();
			
			// Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기 
			rs = stmt.executeQuery(sql);

			boolean flag = false; // 조회 결과 있음
						// true; // 조회 결과 없음
			
			while(rs.next()) {
				
				flag = true; // while 문이 한번이라도 수행되면 true 로 변경
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				if(deptTitle != null) {
				System.out.printf("%d / %s / %s / %s\n", empId, empName, deptTitle, jobName);
				} else {
					System.out.println("일치하는 부서가 없습니다.");
					break;
				}
			}
			
			if(!flag) {
				System.out.println("해당 부서가 없습니다.");
			}
			
		} catch (Exception e) { // 업캐스팅 - ClassNotFoundException | SQLException 모두 포함 
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}



