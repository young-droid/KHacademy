package kh.edu.updown.model.service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {

	private Scanner sc = new Scanner(System.in);

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {

		System.out.println("[Game Start...]");

		Random random = new Random(); // 랜덤 객체 생성(자바에서 제공)
		int rand = random.nextInt(101);

		System.out.println("최고 점수 : " + loginMember.getHighScore());

		int count = 0; // 시도 횟수 저장

		while (true) {

			System.out.print("정수를 입력하세요 : ");
			int input = sc.nextInt();
			
			count++;

			if (input > rand) {
				System.out.println("DOWN!");
				continue;
			} else if (input < rand) {
				System.out.println("UP!");
				continue;
			} else {
				System.out.println("정답입니다!");
				break;
			}
		}
		System.out.println("시도 횟수 : " + count);

		if (loginMember.getHighScore() == 0 || count < loginMember.getHighScore()) {
			loginMember.setHighScore(count);
			System.out.println("**New HighScore!**");
		}

	}

	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {

		System.out.println("[내 정보 조회]");

		System.out.println(loginMember);
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출력
	public void selectAllMember(List<Member> members) {

		System.out.println("[전체 회원 조회]");

		Collections.reverse(members);
		
		for (Member member : members) {
			System.out.println(member);
		}
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {

		System.out.println("[비밀번호 변경]");

//		boolean check = true;

		while (true) {
			System.out.print("현재 비밀번호 : ");
			String memberPw = sc.next();

			if (memberPw.equals(loginMember.getMemberPw())) {
				loginMember.setMemberPw(memberPw);
				while (true) {
					System.out.print("* 새로운 비밀번호 : ");
					String inputPw1 = sc.next();
					System.out.print("* 새로운 비밀번호 확인: ");
					String inputPw2 = sc.next();

					if (!(inputPw1.equals(inputPw2))) {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
					} else {
						System.out.println("비밀번호 변경 성공");
						loginMember.setMemberPw(inputPw1);
						break;
					}
				}
				break;
			}
		}

	}
}
