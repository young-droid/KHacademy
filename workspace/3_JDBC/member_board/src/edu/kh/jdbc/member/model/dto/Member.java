package edu.kh.jdbc.member.model.dto;

import java.sql.Date;

public class Member {

	// 필드
	private int memberNo; // MEMBER_NO
	private String memberId; // MEMBER_ID VARCHAR2(20) NOT NULL,
	private String memberPw; // MEMBER_PW VARCHAR2(20) NOT NULL,
	private String memberName; // MEMBER_NM VARCHAR2(30) NOT NULL,
	private char memberGen; // MEMBER_GENDER CHAR(1) CHECK(MEMBER_GENDER IN ('M', 'F')),
	private Date enrollDate; // ENROLL_DATE DATE DEFAULT SYSDATE,
	private char secessionflag; // SECESSION_FL CHAR(1) DEFAULT 'N' CHECK(SECESSION_FL IN ('Y', 'N'))

	public Member() {
	}

	public Member(String memberId, String memberPw, Date enrollDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGen = memberGen;
		this.enrollDate = enrollDate;
		this.secessionflag = secessionflag;
	}

	
	public Member(String memberId, String memberPw, String memberName, char memberGen) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGen = memberGen;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public char getMemberGen() {
		return memberGen;
	}

	public void setMemberGen(char memberGen) {
		this.memberGen = memberGen;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getSecessionflag() {
		return secessionflag;
	}

	public void setSecessionflag(char secessionflag) {
		this.secessionflag = secessionflag;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberGen=" + memberGen + ", enrollDate=" + enrollDate + ", secessionflag="
				+ secessionflag + "]";
	}

}
