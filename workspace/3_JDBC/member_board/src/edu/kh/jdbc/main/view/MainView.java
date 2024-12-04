package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.view.BoardView;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.view.MemberView;

public class MainView { // 메인 메뉴 (메뉴 선택용 입력 화면)
	
	private Scanner sc = new Scanner(System.in);

	// 로그인한 회원의 정보가 저장된 객체를 참조할 변수
	private Member loginMember = null;
	
	// 회원 관련 기능 화면을 모아둔 객체를 참조할 변수
	private MemberView memberView = new MemberView();
	
	// 게시판 관련 기능 화면을 모아둔 객체를 참조할 변수
	private BoardView boardView = new BoardView();
	
	/**
	 * 메인 메뉴 출력용 메소드
	 * @throws Exception 
	 */
	public void displayMenu() throws Exception {
		int menuNum = -1;
		
		do {
			try {

				if(loginMember == null) { // 로그인 안되어있을 때

					System.out.println("\n ========== 회원제 게시판 프로그램 ==========\n");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 프로그램 종료");

					System.out.print("메뉴를 선택해주세요 >> ");
					menuNum = sc.nextInt();

					switch(menuNum) {
					case 1 : loginMember = memberView.login(); break; 
					case 2 : memberView.signUp(); break; 
					case 0 : System.out.println("프로그램을 종료합니다."); break; 
					default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");

					}
				} else { // 로그인이 되어있는 경우
					System.out.println("\n ************** 회원 메뉴 **************\n");
					System.out.println("1. 내 정보 조회");
					System.out.println("2. 내 정보 수정(이름, 성별)");
					System.out.println("3. 회원 목록 조회");
					System.out.println("4. 비밀번호 변경");
					System.out.println("5. 회원 탈퇴");
					System.out.println("6. * 게시판 메뉴 화면 *");
					System.out.println("9. 로그아웃");

					System.out.print("메뉴를 선택해주세요 >> ");
					menuNum = sc.nextInt();

					switch(menuNum) {
					case 1 : memberView.myInfo(loginMember); break; 
					case 2 : memberView.updateMyInfo(loginMember); break; 
					case 3 : memberView.selectAll(); break; 
					case 4 : memberView.updatePw(loginMember); break; 
					case 5 : 
						loginMember = memberView.secession(loginMember); 
						break; 
						
					case 6 : boardView.boardMenu(loginMember); break; 
					case 9 : loginMember = null; break; 
					default : System.out.println("메뉴에 작성된 번호만 입력해주세요."); break; 
					}
				}
			}catch(InputMismatchException e) {
				e.printStackTrace();
				sc.nextLine(); // 잘못 입력했을 경우, 입력버퍼 제거용
			}
			
			
		}while(menuNum != 0);
	}
	
}
