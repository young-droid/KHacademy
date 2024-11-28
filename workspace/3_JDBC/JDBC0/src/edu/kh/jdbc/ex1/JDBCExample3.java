package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null; 
		
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
			
			// 입력 받은 최소 급여 보다 많이 받고(이상)
		      // 입력 받은 최고 급여보단 적게 받는(이하)
		      // 사원의  사번, 이름, 급여를 급여 내림차순 조회
		      
		      // [실행화면]
		      // 최소 급여 : 1000000
		      // 최대 급여 : 3000000
		      
		      // (사번) / (이름) / (급여)
		      // (사번) / (이름) / (급여)
		      // (사번) / (이름) / (급여)
			
			Scanner sc = new Scanner(System.in); 
			System.out.print("최소 급여 : ");
			int inputMin = sc.nextInt();
			System.out.print("최대 급여 : ");
			int inputMax = sc.nextInt();
			
			String sql = "SELECT EMP_ID , EMP_NAME , SALARY \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "WHERE SALARY BETWEEN " + inputMin + " AND " + inputMax + "\r\n"
					+ "ORDER BY SALARY DESC";
						// SQL문 띄어쓰기도 항상 유의하기! 
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("%d / %s / %d\n", empId, empName, salary);
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
}
