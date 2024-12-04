package edu.kh.jdbc.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Reply;

import static edu.kh.jdbc.common.JDBCTemplate.*;

public class BoardDAO {
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	private Properties prop;
	
	public BoardDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 게시글 전체 목록 조회
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Board> selectAll(Connection conn) throws Exception {
		List<Board> boardList = new ArrayList<>(); 

		try {
		
		String sql = prop.getProperty("selectAll");		

		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
//			글번호, 제목 ,작성자, 작성일, 조회수
			int boardNo = rs.getInt("BOARD_NO");
			String boardTitle = rs.getString("BOARD_TITLE");
			String memberName = rs.getString("MEMBER_NM");
			Date createDate = rs.getDate("CREATE_DATE");
			int readCount = rs.getInt("READ_COUNT");
			int replyCount = rs.getInt("REPLY_COUNT");

			Board board = new Board(boardNo,memberName,boardTitle,createDate,replyCount,readCount);

			boardList.add(board);

		}
		}finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}


	/** 
	 * @param boardNo 
	 * @param conn 
	 * @return board
	 * @throws SQLException 
	 */ 
	public Board selectOne(Connection conn, int boardNo) throws Exception {
		
		Board board = null; 
		
		try {
		String sql = prop.getProperty("selectOne");
		
		pstmt = conn.prepareStatement(sql);
		// 3) ? 위치 홀더에 알맞은 값 세팅
		pstmt.setInt(1, boardNo);
		
		// 4) SQL 수행(SELECT)후 결과 반환 받기(ResultSet)
		rs = pstmt.executeQuery();		
		
		// 5) 조회된 한 행(if)이 있을 경우 조회된 컬럼 값 얻어오기
		if(rs.next()) {
			// int boardNo = rs.getInt("BOARD_NO");
			// -> 입력 받은 boardNo와 조회된 BOARD_NO는 같으므로 
			// 굳이 DB 조회 결과에서 얻어오지 않아도 된다.
			
			String boardTitle = rs.getString("BOARD_TITLE");
			String boardContent = rs.getString("BOARD_CONTENT");
			Date createDate = rs.getDate("CREATE_DATE");
			int readCount = rs.getInt("READ_COUNT");
			int memberNo = rs.getInt("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NM");
			
			board = new Board(boardNo,boardTitle,boardContent,createDate,readCount,memberNo,memberName);
			
		}
		

		}finally {
			rs.close();
			pstmt.close();
		}
		
		return board; // null 또는 Board 객체 주소값 반환
		
		
		
	}


	/** 특정 게시글 댓글 리스트 조회 메소드
	 * @param conn
	 * @param boardNo
	 * @return replyList
	 * @throws Exception 
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception {
		List<Reply> replyList = new ArrayList<>();
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int replyNo = rs.getInt("REPLY_NO");
				Date createDate = rs.getDate("CREATE_DATE");
				String memberName = rs.getString("MEMBER_NM");
				String replyContent = rs.getString("REPLY_CONTENT");
//				int boardNo = rs.getInt("BOARD_NO");
				int memberNo = rs.getInt("MEMBER_NO");
				
				Reply reply = new Reply(replyNo, replyContent, createDate, boardNo, memberNo, memberName);
				
				replyList.add(reply);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return replyList ;
	}


	/** 조회수 증가
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception 
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception {
		int result = 0;
		
		try {
		String sql = prop.getProperty("increaseReadCount");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, boardNo);
		
		result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 게시글 삭제 메소드 sql
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception 
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, Board board) throws SQLException {
		int result = 0;
		
		try {
		String sql = prop.getProperty("updateBoard");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBoardTitle());
		pstmt.setString(2, board.getBoardContent());
		pstmt.setInt(3, board.getBoardNo());
		
		result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		} 
		return result;
	}


	public int insertReply(Connection conn, Reply reply) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertReply");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
	
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}




}
