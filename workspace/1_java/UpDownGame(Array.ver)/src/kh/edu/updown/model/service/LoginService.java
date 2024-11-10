package kh.edu.updown.model.service;

import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {
		
		System.out.println("[게임 시작!]");
		int targetNumber = (int) (Math.random() * 100) + 1; // 1~100 사이의 난수 생성
        int attempts = 0;

        while (true) {
            System.out.print("정수를 입력하세요 (1-100) : ");
            int guess = sc.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Up!");
            } else if (guess > targetNumber) {
                System.out.println("Down!");
            } else {
                System.out.println("정답입니다! 시도한 횟수 : " + attempts);
                if (loginMember.getHighScore() == 0 || attempts < loginMember.getHighScore()) {
                    loginMember.setHighScore(attempts);  // 최고 기록 
                    System.out.println("최고기록!");
                }
                break;
            }
		}
	}

	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
		System.out.println("ID: " + loginMember.getMemberId());
        System.out.println("Name: " + loginMember.getMemberName());
        System.out.println("High Score: " + loginMember.getHighScore());
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출력
	public void selectAllMember(Member[] members) {
		
		System.out.println("[전체 회원 조회]");
		for (Member member : members) {
            if (member != null) {
                System.out.println("ID: " + member.getMemberId() + ", Name: " + member.getMemberName() + ", High Score: " + member.getHighScore());
            }
        }
		
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {

		while (true) {
		
		System.out.print("현재 비밀번호 : ");
		String currentPassword = sc.next();

			// 현재 비밀번호가 맞는지 확인
			if (loginMember.getMemberPw().equals(currentPassword)) {
				while (true) {
					System.out.print("새 비밀번호 : ");
					String newPassword = sc.next();
			
					System.out.print("새 비밀번호 확인 : ");
					String newPassword2 = sc.next();
			
					// 새 비밀번호와 확인 비밀번호가 일치하는지 확인
					if (newPassword.equals(newPassword2)) {
						loginMember.setMemberPw(newPassword);  // 비밀번호 업데이트
						System.out.println("비밀번호가 변경되었습니다.");
						break;

					} else {
						System.out.println("비밀번호가 맞지 않습니다. 다시 입력해 주세요.");
					}
				}
				break;
			} else {
				System.out.println("비밀번호 입력 오류. 다시 입력해 주세요.");
				continue;
			}
		}

	}

	
	
}
