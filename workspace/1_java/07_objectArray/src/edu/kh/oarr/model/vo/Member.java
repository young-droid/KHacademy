package edu.kh.oarr.model.vo;

public class Member {

	// 필드 (== 멤버 변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;
	
	
	// 생성자
	public Member() {
		
	}
	
	// 매개변수 생성자
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}
	
	
	// 메소드
	// getter / setter
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
		// 원래 모든 메소드는 종료 시 호출한 곳으로 돌아가는 
		// return 구문이 작성되어야 하지만,
		// void일 경우 생략 가능함
		// -> 생략 시 컴파일러가 자동 추가
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberId;
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
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	// OverRiding
	public String toString() {
		return 	  "\n아이디 : " + memberId +
				"\n이름 : " + memberName +
				"\n나이 : " + memberAge + "세" + 
				"\n지역 : " + region +"\n";	
	}
}
