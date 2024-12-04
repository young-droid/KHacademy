package edu.kh.jdbc.board.model.dto;

import java.sql.Date;
import java.util.List;

public class Board {
	// * 꼭 테이블과 같은 모양일 필요 X
	// -> 어떤 데이터를 저장하고 옮기고 싶은지에 따라 필드 구성 달라짐

	// 게시글 목록 조회
	private int boardNo;
	private String boardTitle;
	private int readCount;
	private String memberName;
	private int replyCount;
	private Date createDate;

	// 게시글 상세조회
	private String boardContent;
	private List<Reply> replyList;

	public List<Reply> getReplyList() {
		return replyList;
	}

	// 게시글 수정, 삭제
	private int memberNo;

	/**
	 * 게시글 전체 조회 리스트
	 * 
	 * @param boardNo
	 * @param memberName
	 * @param boardTitle
	 * @param createDate
	 * @param replyCount
	 * @param readCount
	 */
	public Board(int boardNo, String memberName, String boardTitle, Date createDate, int replyCount, int readCount) {
		super();
		this.boardNo = boardNo;
		this.memberName = memberName;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.replyCount = replyCount;
		this.readCount = readCount;
	}

	/**
	 * 게시글 상세 조회
	 * 
	 * @param boardNo
	 * @param boardTitle
	 * @param readCount
	 * @param memberName
	 * @param createDate
	 * @param boardContent
	 * @param memberNo
	 */
	public Board(int boardNo, String boardTitle, String boardContent, Date createDate, int readCount, int memberNo,
			String memberName) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.readCount = readCount;
		this.memberNo = memberNo;
		this.createDate = createDate;
		this.boardContent = boardContent;
		this.memberName = memberName;
	}

	public Board() {
	}


	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", readCount=" + readCount + ", memberName="
				+ memberName + ", replyCount=" + replyCount + ", createDate=" + createDate + ", boardContent="
				+ boardContent + ", replyList=" + replyList + ", memberNo=" + memberNo + "]";
	}

	public String toString2() {
	      return String.format("%5d %15s [%d] %10s %17tF %6d", boardNo, boardTitle, replyCount, memberName, createDate, readCount);
	   }
	
}
