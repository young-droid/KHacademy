package edu.kh.jdbc.member.model.service;

import java.sql.Connection;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

// import static 구문 : static 메소드를 import 하여
// 					   클래스명.static메소드() 형태에서
//					   클래스명을 생략할 수 있게 하는 구문

import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;



// Service : 데이터 가공 (요청에 맞는 데이터를 만드는 것)
//			 + 트랜잭션 제어 처리
// 			 -> 하나의 Service 메소드에서 n개의 DAO 메소드를 호출할 수 있음
//			 -> n개의 DAO에서 수행된 SQL을 한 번에 commit/rollback



public class MemberService {

	// 회원 관련 SQL 수행 및 결과를 반환할 DAO 객체 생성 및 참조
	private MemberDAO dao = new MemberDAO();
	
	
	/** 아이디 중복 검사 Service
	 * @param memberId
	 * @return
	 * @throws Exception 
	 */
	public int duplicateCheck(String memberId) throws Exception {
		// 1. Connection 객체 생성
		// -> JDBCTemplate에 작성된 getConnection() 메소드를 이용해
		//    커넥션 생ㅅ어 후 얻어옴
		Connection conn = getConnection();
		
		// 2. DAO 메소드 호출 후 결과 반환 받기
		int result = dao.duplicateCheck(conn, memberId);
		
		// 3. 사용한 Connection 객체 반환
		close(conn);
		
		// 4. 중복 검사 결과 View로 반환
		return result;
	}

	/** 회원 가입 Service
	 * @param signUpMember
	 * @return result
	 * @throws Exception 
	 */
	public int signUp(Member signUpMember) throws Exception {
		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. 회원 가입 DAO 메소드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, signUpMember);
		
		// 3. DAO 수행 결과에 따라 트랜잭션 처리
		commit(conn);
		
		// 4. 사용한 Connection 반환
		close(conn);
		
		// 5. DAO 수행 결과 View로 반환
		return result;
	}
}
