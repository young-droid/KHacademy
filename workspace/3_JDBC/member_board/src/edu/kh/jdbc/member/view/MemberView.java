package edu.kh.jdbc.member.view;

import java.util.Scanner;

import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	
	// 회원 관련 서비스 제공 객체 생성 및 참조
	private MemberService service = new MemberService();
	
	/**
	 * 회원 가입 화면 출력용 메소드
	 * @throws Exception 
	 */
	public void signUp() throws Exception {
		System.out.println("[회원 가입]");
		
		try {
			String memberId = null;
			String memberPw = null;
			String memberPw2 =null;
			String memberName = null;
			char memberGen = ' '; 
			
			while(true) {
				System.out.print("아이디 : ");
				memberId = sc.next();

				// 아이디 중복 검사 (DB에 일치하는 아이디가 있으면 "중복" -> 다시 아이디 입력 받기)
				int result = service.duplicateCheck(memberId);

				if(result == 0) {
					System.out.println("사용 가능한 아이디 입니다.");
					break;
				} else {
					System.out.println("이미 사용중인 아이디 입니다. 다시 입력해주세요.");
				}
			} // 아이디 중복 검사 while 종료

			// 비밀번호, 비밀번호 확인을 각각 입력 받아서
			// 일치할 때 까지 무한 반복

			while(true) {
				System.out.print("비밀번호 입력 : ");
				memberPw = sc.next();
				System.out.print("비밀번호 확인 : ");
				memberPw2 = sc.next();

				if(memberPw.equals(memberPw2)) {
					System.out.println("비밀번호가 일치합니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}
			}
			// 이름 입력
			System.out.println("이름 : ");
			memberName = sc.next();

			// 성별이 'M' 또는 'F'가 입력될 때 까지 반복
			while(true) {
				System.out.println("성별(M/F) : ");
				memberGen = sc.next().toUpperCase().charAt(0);
				if(memberGen != 'M' && memberGen != 'F') {
					System.out.println("성별은 M 또는 F 만 입력해주세요.");
				} else {
					break;
				}
			}
			
			// 입력 받은 값을 하나의 객체(Member)에 저장
			
			Member signUpMember = new Member(memberId, memberPw, memberName, memberGen);
			
			// 회원 가입 Service 호출 후 결과 반환 받기
			int result = service.signUp(signUpMember);
			
			// service 결과에 따른 화면 처리
			if(result == 0) {
				System.out.println("회원 가입 실패");
			} else {
				System.out.println("회원 가입 성공");
			}
			
			
			
			service.duplicateCheck(memberName);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
