package kh.edu.updown.model.service;

import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class MainService {

	private Scanner sc = new Scanner(System.in);

	// 회원 가입된 회원의 정보를 저장할 배열 선언 및 할당
	private Member[] members = new Member[3];  

	private int memberCount = 0; // 현재 가입한 회원 수 (회원 가입 시 members 인덱스 지정에 사용 가능)

	// 현재 로그인한 회원의 정보를 참조할 변수 선언.
	private Member loginMember = null; // 로그인 X == null,  로그인 O != null

	// LoginService 생성
	// -> 로그인 시 이용할 수 있는 기능만을 모아둔 객체
	private LoginService loginService = new LoginService();



	// 메뉴 출력 메소드
	// * 메뉴 출력 메소드를 분석해보세요!
	public void displayMenu() {

		int menuNum = 0; // 메뉴 선택용 변수

		do {

			System.out.println();
			System.out.println("=== UP/DOWN 게임 ===");


			if(loginMember == null) { // 로그인이 되어있지 않은 경우

				System.out.println("[메인 메뉴]");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("0. 종료");
				System.out.print("메뉴 선택 >> ");

				menuNum = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println(); // 줄바꿈

				switch(menuNum) {
				case 1 : signUp(); break;
				case 2 : login(); break;
				case 0 : System.out.println("[프로그램 종료]"); break;
				default : System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				}


			}else { // 로그인이 되어있는 경우

				System.out.println("[로그인 메뉴]");
				System.out.println("1. 업/다운 게임 start");
				System.out.println("2. 내 정보 조회");
				System.out.println("3. 전체 회원 조회");
				System.out.println("4. 비밀번호 변경");
				System.out.println("9. 로그아웃");
				System.out.println("메뉴 선택 >> ");

				menuNum = sc.nextInt();
				sc.nextLine();
				System.out.println();


				// 선택된 메뉴 번호에 따라 LoginService에서 알맞은 기능을 호출
				switch (menuNum) {
				case 1: loginService.startGame(loginMember); break;
				case 2: loginService.selectMyInfo(loginMember); break;
				case 3: loginService.selectAllMember(members); break;
				case 4: loginService.updatePassword(loginMember); break;

				case 9 : System.out.println("[로그아웃 되었습니다.]"); 
				loginMember = null; // loginMember 필드에 아무것도 참조하고 있지 않음을 의미하는 null을 대입
				break;

				default: System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				}

			}


		}while(menuNum != 0);

	}

	// [회원 가입]
	// 아이디, 비밀번호, 이름을 입력 받고
	// Member객체를 생성하여 members 배열에 추가
	// 단, 이미 중복되는 아이디가 존재하는 경우 가입 불가
	public void signUp() { 

		boolean idDup = false;
		String id = null;
		
		System.out.println("[회원 가입]");
		
		
		while (idDup = true) {

			System.out.println("아이디 : ");
			id = sc.next();
			
			for(int i = 0 ; i < members.length ; i++ ) {
				if(members[i] != null) {
					if(id == members[i].getMemberId()) {
						System.out.println("입력하신 아이디는 이미 존재하는 아이디입니다. 새로운 아이디를 입력해주세요.");
						break;
					} 
				} else {
					idDup = true;
				}
			}

		}
			System.out.println("비밀번호 : ");
			String pw = sc.next();
			System.out.println("이름 : ");
			String name = sc.next();

				
			for (int i = 0; i < members.length; i++) {
				if (members[i] == null) {
					members[i] = new Member(id, pw, name);
					break;
				} 

			}
			
			System.out.println(members[0].toString());
			

			
		
	} 


	// [로그인]
	// 아이디, 비밀번호를 입력 받아 일치하는 회원이 members에 있을 경우 로그인
	// 없으면 "아이디 또는 비밀번호가 일치하지 않습니다." 출력
	public void login() {

		System.out.println("[로그인]");



	}





}
