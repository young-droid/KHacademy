package edu.kh.jdbc.member.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;


// DAO(Data Access Object) : 데이터가 저장되어있는 DB, 파일 등에 접근하는 객체
//					-> DB에 접근할 수 있다 == SQL을 수행하고 결과를 반환받을 수 있다. 
	
// Java에서 DB에 접근하고 결과를 반환받기 위한 프로그래밍 API를 제공함
// == JDBC(Connection, Statement, PreparedStatement, ResultSet)

public class MemberDAO {

//	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	private Statement stmt;
	
	public MemberDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 아이디 중복 검사 DAO
	 * @param conn
	 * @param memberId
	 * @return result
	 */
	public int duplicateCheck(Connection conn, String memberId) throws Exception{
		// 1. 결과 저장용 변수
		int result = 0; 

		// 2. SQL 작성
		String sql = prop.getProperty("duplicateCheck");

		// 3. PreparedStatment 객체 생성(Connection, sql 필요
		pstmt = conn.prepareStatement(sql);

		// 4. 위치 홀더에 알맞은 값 세팅
		pstmt.setString(1, memberId);

		// SQL 수행 후 결과 반환 받기
		rs = pstmt.executeQuery(); // SELECT 수행 결과 ResultSet 반환 받음

		// 6. 조회 결과를 한 행씩 접근하여 원하는 컬럼 값 얻어오기

		if(rs.next()) {
			result = rs.getInt(1); // 1은 컬럼 순서  
		}

		// 7.
		close(rs);
		close(pstmt);

		return result;
	}

	public int signUp(Connection conn, Member signUpMember) throws Exception {
		
		int result = 0;
		
		String sql = prop.getProperty("signUp");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, signUpMember.getMemberId());
		pstmt.setString(2, signUpMember.getMemberPw());
		pstmt.setString(3, signUpMember.getMemberName());
		pstmt.setString(4, signUpMember.getMemberGen()+"");
		
		result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	
	
	
	
	/** 회원 로그인 
	 * @param conn
	 * @param signInMember
	 * @return loginMember
	 * @throws SQLException
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws SQLException {
		Member loginMember = null;		
		
		String sql = prop.getProperty("login");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPw);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int memberNo = rs.getInt("MEMBER_NO");
			String memberId2 = rs.getString("MEMBER_ID");
			String memberName = rs.getString("MEMBER_NM");
			char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
			Date enrollDate = rs.getDate("ENROLL_DATE"); 
			
			
			loginMember = new Member();
			loginMember.setMemberNo(memberNo);
			loginMember.setMemberId(memberId2);
			loginMember.setMemberPw(memberPw);
			loginMember.setMemberName(memberName);
			loginMember.setMemberGen(memberGender);
			loginMember.setEnrollDate(enrollDate);
		}
		close(rs);
		close(pstmt);
		
		return loginMember;
	}

	
	
	
	/** 전체 회원 조회
	 * @return
	 * @throws SQLException 
	 */
	public List<Member> selectAll(Connection conn) throws SQLException {
		
		List<Member> memberList = new ArrayList<Member>(); 
		
		String sql = prop.getProperty("selectAll");
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String memberId = rs.getString("MEMBER_ID");
			String memberName = rs.getString("MEMBER_NM");
			Date enrollDate = rs.getDate("ENROLL_DATE"); 
			
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberName(memberName);
			member.setEnrollDate(enrollDate);
			
			// 생성된 Member 객체를 List에 추가
			
			memberList.add(member);
			
		}
		
		close(rs);
		close(pstmt);
		

		return memberList;
		
	}

	public int updateMyInfo(Connection conn, int memberNo, String memberName, char memberGender) throws SQLException {
		int result = 0;
		
		
		String sql = prop.getProperty("updateMyInfo");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memberName);
		pstmt.setString(2, memberGender+"");
		pstmt.setInt(3, memberNo);
		
		result = pstmt.executeUpdate();
		
		
		return result;
	}

	public int updatePw(Connection conn, int memberNo, String newPw, String currentPw) throws SQLException {
		int result = 0 ;
		
		String sql = prop.getProperty("updatePw");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, newPw);
		pstmt.setInt(2, memberNo);
		pstmt.setString(3, currentPw);
		
		result = pstmt.executeUpdate();
		
		return result;
	}

	public int secession(Connection conn, int memberNo, String currentPw) throws SQLException {
		int result = 0;
		
		String sql = prop.getProperty("secession");
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, memberNo);
		pstmt.setString(2, currentPw);
		
		result = pstmt.executeUpdate();
		
		return result;
	}


}
