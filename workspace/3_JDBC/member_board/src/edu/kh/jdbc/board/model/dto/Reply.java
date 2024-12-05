package edu.kh.jdbc.board.model.dto;

import java.sql.Date;

public class Reply {
	// field
	// 댓글 목록 조회
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private int boardNo;
	private int memberNo;
	private String memberName;
	
	public Reply() {
	}
	
	/** 전체 필드 생성자
	 */
	public Reply(int replyNo, String replyContent, Date createDate, int boardNo, int memberNo, String memberName) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
	}

	public Reply(int replyNo, Date createDate, String memberName, String replyContent) {
		super();
		this.replyNo = replyNo;
		this.createDate = createDate;
		this.memberName = memberName;
		this.replyContent = replyContent;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", boardNo=" + boardNo + ", memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}

	
	
	// getter/setter
	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
