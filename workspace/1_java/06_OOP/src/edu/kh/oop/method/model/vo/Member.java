package edu.kh.oop.method.model.vo;

public class Member {

	// 1. 속성(필드)
	// 2. 생성자
	// 3. 기능
	
	
	// 속성(필드)
	private String memberId;
	private String memberPw; 
	private String memberName;
	private int memberAge;
	
	// 생성자
	// 기본 생성자
	public Member() {
	}
	
	// 매개변수 생성자 (모든 필드를 초기화 하는 용도)
	public Member(String memberId, String memberPw, 
				  String memberName, int memberAge) {
		// 오버로딩 적용
		
		// 필드 초기화 - 전달 받은 값을 필드로 옮겨 담기
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		
	}
	
	
	
	// 기능
	// **** getter / setter ****
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", memberAge="
				+ memberAge + "]";
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

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	
	
}
