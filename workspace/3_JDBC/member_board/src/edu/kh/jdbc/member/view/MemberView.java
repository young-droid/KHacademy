package edu.kh.jdbc.member.view;

import java.sql.SQLException;
import java.util.List;
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

	public Member login() throws SQLException {
		System.out.println("[로그인]");


		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();

		Member loginMember = service.signIn(memberId,memberPw);
		try {
			if(loginMember != null) {
				System.out.println("로그인 성공");
//				System.out.println(loginMember.toString());
			} else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginMember;

	}

	/**
	 * 로그인 한 회원의 정보 조회
	 * @param loginMember 
	 */
	public void myInfo(Member loginMember) {
		System.out.println("\n[내 정보 조회]");
		System.out.println("회원 번호 : " + loginMember.getMemberNo());
		System.out.println("아이디 : " + loginMember.getMemberId());
		System.out.println("이름 : " + loginMember.getMemberName());
		System.out.println("성별 : " + loginMember.getMemberGen());
		System.out.println("가입일 : " + loginMember.getEnrollDate());
	}

	public void logOut(Member loginMember) {
		loginMember = null;
		System.out.println("로그아웃 되었습니다.");
	}

	/** 전체 회원 리스트 조회
	 * @return memberList
	 * @throws SQLException 
	 */
	public void selectAll() throws SQLException {
		System.out.println("\n[가입된 회원 목록 조회]");
		
//		for(Member mem : service.selectAll()) {
//			System.out.println(mem);
//		};
//		
		List<Member> memberList = service.selectAll();
		
		if(memberList.isEmpty()) { // 비어있음 == 조회 결과 없음
			System.out.println("조회 결과가 없습니다.");
		} else {
			for(Member mem : memberList) {
				System.out.printf("%10s (%s)\t 가입일: %s\n" , mem.getMemberName(), mem.getMemberId(),mem.getEnrollDate().toString());
			}
		}
	}

	/** 내 정보 수정
	 * @param loginMember
	 * @throws SQLException 
	 */
	public void updateMyInfo(Member loginMember) throws SQLException {
		System.out.println("\n[내 정보 수정(이름, 성별)]");
		
		System.out.print("변경할 이름 : ");
		String memberName = sc.next();
		
		System.out.print("변경할 성별(M/F) : ");
		char memberGender = sc.next().toUpperCase().charAt(0);

		int result = service.updateMyInfo(loginMember.getMemberNo(),memberName, memberGender);
		
		if(result != 0) {// 성공했을 경우
			System.out.println("정보 변경 성공!");
			
			// DB의 수정된 내용과 현재 로그인한 회원 정보 일치 시키기
			// 얕은 복사 : 참조 주소만 복사하여 같은 변수
			
			loginMember.setMemberName(memberName);
			loginMember.setMemberGen(memberGender);
		} else {
			System.out.println("정보 변경 실패");
		}
	}

	public void updatePw(Member loginMember) throws SQLException {
		System.out.println("[비밀번호 변경]");
		
		int result = 0;
		
		String currentPw = null;
		while(true) {
			System.out.print("현재 비밀번호 입력 : ");
			currentPw = sc.next();
			System.out.println( loginMember.getMemberPw());
			if(currentPw.equals(loginMember.getMemberPw())) {
				break;
			}else {
				System.out.println("현재 비밀번호가 일치하지 않습니다. 다시 입력해주세요. ");
				continue;
			}
		}
		
		String newPw = null;
		
		// 새 비밀번호, 새 비밀번호 확인이 서로 일치할 때 까지 입력 받기
		while(true) {
			System.out.print("변경할 비밀번호 입력 : ");
			newPw = sc.next();
			System.out.print("비밀번호 확인 : ");
			String newPw2 = sc.next();
			if(!newPw.equals(newPw2)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				continue; 
			} else {
				break;
			}
		}
		
		result = service.updatePw(loginMember.getMemberNo(), newPw, currentPw);
		
		if(result > 0) {
			loginMember.setMemberPw(newPw);
			System.out.println("비밀번호 변경 성공");
		} else {
			System.out.println("비밀번호 변경 실패");
		}
		
	}

	public Member secession(Member loginMember) throws SQLException {
		// 매개변수로 전달 받은 값(주소 복사본)을 저장 할 뿐이다.
		// loginMember = null;
		// -> 복사본이 사라진다고 해도 원본은 사라지지 않는다
		// --> 로그아웃이 안됨


		System.out.println("[회원 탈퇴]");

		int result = 0;
		String currentPw; 
		// 1. 현재 비밀번호 입력 받기
			
		
		
		
		
		// 2. 정말 탈퇴하시겠습니다?(Y/N)
		System.out.print("정말 탈퇴하시겠습니까? (Y/N) : ");
		char confirm = sc.next().toUpperCase().charAt(0);

		if(confirm == 'Y') {
			
			System.out.print("현재 비밀번호 입력 : ");
			currentPw = sc.next();

			result = service.secession(loginMember.getMemberNo(), currentPw);
			if(result > 0) {
				System.out.println("탈퇴 되었습니다.");
				loginMember = null;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} else {

			System.out.println("\n회원 탈퇴 취소\n");
		}

		
		// 3. (Y 입력 시) 탈퇴 Service 수행
		// 4. 성공 : "탈퇴 되었습니다." -> 로그아웃
		//	  실패 : "비밀번호가 일치하지 않습니다.
		// 5. (N 입력 시) "회원 탈퇴 취소"
	
		
		return loginMember;
	}

}
