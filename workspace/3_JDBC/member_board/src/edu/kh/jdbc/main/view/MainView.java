package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.view.MemberView;

public class MainView { // 메인 메뉴 (메뉴 선택용 입력 화면)
	
	private Scanner sc = new Scanner(System.in);

	// 로그인한 회원의 정보가 저장된 객체를 참조할 변수
	private Member loginMember = null;
	
	// 회원 관련 기능 화면을 모아둔 객체를 참조할 변수
	private MemberView memberView = new MemberView();
	
	/**
	 * 메인 메뉴 출력용 메소드
	 * @throws Exception 
	 */
	public void displayMenu() throws Exception {
		int menuNum = -1;
		
		do {
			try {
				System.out.println("\n ========== 회원제 게시판 프로그램 ==========\n");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴를 선택해주세요 >> ");
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1 : break; 
				case 2 : memberView.signUp(); break; 
				case 0 : System.out.println("프로그램을 종료합니다."); break; 
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				
				}
				
				
			}catch(InputMismatchException e) {
				e.printStackTrace();
				sc.nextLine(); // 잘못 입력했을 경우, 입력버퍼 제거용
			}
			
			
		}while(menuNum != 0);
	}
	
}
