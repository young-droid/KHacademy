package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService { // 클래스
	
	// 속성(필드)
	private Scanner sc = new Scanner(System.in);
	// System.in : 자바에서 기본적으로 지정해둔 입력 창치(키보드)

	private Member memberInfo = null;	// 가입할 회원의 정보를 저장할 변수
	private Member loginMember = null;
	
	// 기능(생성자, 메서드)

//	public MemberService() { } // 기본생성자
		
	// ** 메소드 작성법 ** 
		
	// [접근제한자]	[예약어]			반환형				메소드명9[매개변수]){}
	// public		static			기본자료형
	// protected	final			참조형(배열, 클래스)
	// default		abstract		void
	// private		static final
		
	public void displayMenu() {	// 메뉴 화면 출력 기능
		
		int menuNum = 0; // 메뉴 선택용 변수
		
		do { // 한번은 무조건 반복함
			System.out.println("==== 회원 정보 관리 프로그램 ====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용
			
			switch(menuNum) {
			case 1 : System.out.println( signUp() ); break;
			case 2 : System.out.println( signIn() ) ; break; 
			case 3 : System.out.println( selectMember() ) ; break;
			case 4 :
				; break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		} while(menuNum != 0); // 0 누르기 전 까지 반복
	}
		
	// 회원가입 기능
	public String signUp() {
		
		// (반환형)
		// 해당 메소드가 실행이 끝나고 호출한 곳으로 돌아갈 때
		// void : 반환할 값이 없다
		
		System.out.println("\n***** 회원 가입 *****");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인: ");
		String memberPw2 = sc.next();
		
		System.out.print("이름: ");
		String memberName = sc.next();
		
		System.out.print("나이: ");
		int memberAge = sc.nextInt();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		if(memberPw.equals(memberPw2)) {
			// 입력받은 정보를 이용해서 Member 객체 생성한 후
			// 생성된 객체의 주소를 필드에 있는 memberInfo에 대입
			memberInfo = new Member(memberId, memberPw, memberName, memberAge);
			
			System.out.println(memberInfo.toString());
			
			return "회원 가입 성공\n"; 
			// 메소드를 호출한 곳으로 "회원 가입 성공" 반환함
			
		} else {
			return "회원 가입 실패\n";
		}
	} //signUp
		
	
	// 로그인 기능(메소드)
	// 회원 가입 정보에서
	// 저장된 아이디, 비밀번호가
	// 입력된 아이디, 비밀번호와 같으면 "로그인 성공"
	// 아니면 "아이디 또는 비밀번호가 일치하지 않습니다."
	public String signIn() {
		
		System.out.println("\n---- 로그인 ----");
		
		if(memberInfo == null) {
			return "\n사용자 정보가 없습니다. 회원가입을 진행해 주세요.\n";
		}
		
		System.out.print("아이디 : ");
		String inputId = sc.next();
		
		System.out.print("비밀번호 : ");
		String inputPw = sc.next();
		
		if(inputId.equals(memberInfo.getMemberId()) && 
		   inputPw.equals(memberInfo.getMemberPw())) {
			// 입력 받은 memberId와
			// 필드에서 memberInfo가 참조 중인 Member 객체의 memberId가 같은지 확인
			
			// 회원 가입한 회원의 정보를 loginMember에 저장
			// -> 어떤 회원이 로그인 했는지 구분 가능
			loginMember = memberInfo;
			// 참조형 	= Member 객체 주소 (얕은 복사)
			
			
			return "\n로그인 성공\n";
		} else {
			return "\n아이디 또는 비밀번호가 일치하지 않습니다.\n";
		}
	} // signIn()
	
	
	
	// 회원 정보 조회 기능
	// 1) 로그인 여부 확인
	// -> 안된 경우 : 로그인 후 이용해주세요.
	
	// 2) 로그인이 되어있는 경우
	//	  회원 정보를 출력할 문자열을 반들어서 반환
	//	  (단, 비밀번호는 제외)
	
	// 이름 : 유저일
	// 아이디 : user01
	// 나이 : 34세
	
	
	public String selectMember() { 
		System.out.println("\n***** 회원 정보 조회 *****");
		
		if(loginMember == null) {
			return "\n사용자 정보가 없습니다. 회원가입을 진행해 주세요.\n";
		} 
		
		return "이름 : " + loginMember.getMemberName() +
				  "\n아이디 : " + loginMember.getMemberId() +
				  "\n나이 : " + loginMember.getMemberAge() + "세";
		
		// int edu.kh.oop.method.model.vo.Member.getMemberAge()
		// 반환형 		메소드 코드 위치
		
//		System.out.printf("이름 : %s\n", loginMember.getMemberName());
//		System.out.printf("아이디 : %s\n", loginMember.getMemberId());
//		System.out.printf("나이 : %d세\n", loginMember.getMemberAge());
		
	} // selectMember() 
		

	/*
	// 회원 정보 수정
	public String changeInfo() {
		
		if(loginMember == null) {
			return "\n사용자 정보가 없습니다. 회원가입을 진행해 주세요.\n";
		} 
		
		String input = null;
		
		do {
		System.out.println("\n***** 회원 정보 조회 *****");
		System.out.println("1. 이름 : " + loginMember.getMemberName() +
				  "2. 나이 : " + loginMember.getMemberAge() + "세"); 
		
		System.out.print("변경하고 싶은 정보를 선택하세요 :");
		
		
		} while (num != 0);
		
		
		
		return "회원 정보가 수정되었습니다.";
	} // 회원 정보 수정
		
	*/	
		

	
}
