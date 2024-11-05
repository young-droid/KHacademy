package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	private Scanner sc = new Scanner(System.in);
	Member memberInfo = new Member();
	
	int count = 0;

	
	// Member 5칸 짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];
	
	// 현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() { // 기본 생성자
		
		// memberArr 배열 0, 1, 2 인덱스 초기화
		
		memberArr[0] = new Member("user01", "111" , "유저1", 35 , "제주도");
		memberArr[1] = new Member("user02", "222" , "유저2", 25 , "서울");
		memberArr[2] = new Member("user03", "333" , "유저3", 30 , "부산");
		memberArr[3] = new Member("user04", "444" , "유저4", 20 , "부산");
		
	}
	
	
	public void displayMenu() {	// 메뉴 화면 출력 기능

		int menuNum = 0; // 메뉴 선택용 변수

		do { // 한번은 무조건 반복함
			System.out.println("==== 회원 정보 관리 프로그램 v2 ====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("9. 로그아웃");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용

			switch(menuNum) {
			case 1 : System.out.println( signUp() ) ; break;
			case 2 : System.out.println( logIn() ) ; break; 
			case 3 : System.out.println( selectMember() ) ; break;
			case 4 : System.out.println( changeMember() ) ; break;
			case 5 : searchRegion();  break;
			case 9 : System.out.println( logOut() ) ; break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		} while(menuNum != 0); // 0 누르기 전 까지 반복
	}
	
	
	// memberArr의 비어있는 인덱스 번호를 반환하는 메소드
	// 단, 비어있는 인덱스가 없으면 -1 반환 (인덱스 번호와 구분할 숫자)
	public int emptyIndex() {
		for(int i = 0 ; i < memberArr.length ; i++) {
			if(memberArr[i] == null) {
				return i;
			} 
		}
		// 해당 for문을 수행했지만 return 되지 않았다
		// == 배열에 빈칸이 없다. == -1 반환
		return -1;
	}
	
	public int memberNum() {
		
		for(int i = 0 ; i < memberArr.length ; i++) {
			if(memberArr[i] == null) {
				count++;
			} 
		}
		return count;
	}


	public String signUp() {
		System.out.println("\n**** 회원 가입 ****");
		// 객체 배열(memberArr)에 가입한 회원정보를 저장할 예정
		// -> 새로운 회원의 정보를 저장할 공간이 있는지 확인하고
		// 		빈 공간의 인덱스 번호 얻어오기 --> 새로운 메소드 작성
		
		int index = emptyIndex(); // memberArr 배열에서 비어있는 인덱스를 반환 받음
		
		if(index == -1) {	// 비어있는 인덱스가 없을 경우 -> 회원 가입 불가
			return "회원 가입이 불가능 합니다.(인원 수 초과)";
		}
		
		System.out.println("현재 회원 수 : " + index);

		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		System.out.print("지역 : ");
		String region = sc.next();
		
		// 비밀번호, 비밀번호 확인이 일치하면 회원가입
		// 일치하지 않으면 회원가입 실패
		if(memberPw.equals(memberPw2)) {
			// 입력받은 정보를 이용해서 Member 객체 생성한 후
			// 생성된 객체의 주소를 필드에 있는 memberInfo에 대입
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			
			System.out.println(memberArr[index].toString());
			
			return "회원 가입 성공\n"; 
			// 메소드를 호출한 곳으로 "회원 가입 성공" 반환함
			
		} else {
			return "회원 가입 실패\n";
		}
	} // signUp();
	
	
	public String logIn() {
		
		System.out.println("\n---- 로그인 ----");
		
//		if(memberArr[emptyIndex()] == null) {
//			return "\n사용자 정보가 없습니다. 회원가입을 진행해 주세요.\n";
//		}
		
		if(loginMember != null) {
			return loginMember.getMemberName() + "님으로 로그인 된 상태입니다.\n";
		} 
		
		System.out.print("아이디 : ");
		String inputId = sc.next();
		
		System.out.print("비밀번호 : ");
		String inputPw = sc.next();


		for(int i = 0 ; i < memberArr.length ; i++) {
			// 회원 정보가 있을 경우
			if(memberArr[i] != null) {
				// 회원 정보의 아이디, 비밀번호와 
				// 입력받은 아이디, 비밀번호가 같은지 확인

				if(inputId.equals(memberArr[i].getMemberId()) && 
						inputPw.equals(memberArr[i].getMemberPw())) {
					// 입력 받은 memberId와
					// 필드에서 memberInfo가 참조 중인 Member 객체의 memberId가 같은지 확인

					// 로그인 회원 정보를 참조하는 변수 loginMember에 
					// 현재 접근 중인 memberArr[i] 요소에 저장된 주소를 얕은 복사
					loginMember = memberArr[i];
					// 참조형 	= Member 객체 주소 (얕은 복사)
					break;
				} 
			}
		}
		
		// 로그인 성공/실패 여부에 따라서 결과 값 반환
		if(loginMember != null) {
			return loginMember.getMemberName() + "님 환영합니다.\n";
		} else {
			return "\n아이디 또는 비밀번호가 일치하지 않습니다.\n";
		}
		
	} // signIn()
	
	public String logOut() {
		if(loginMember == null) {
			return "로그인 되어 있지 않습니다.";
		} else {
			loginMember = null;
			return "로그아웃 되었습니다.";
		}
	}

	// 회원 정보 조회
	public String selectMember() { 
		System.out.println("\n***** 회원 정보 조회 *****");

		// 1) 로그인 여부 확인
		if(loginMember == null) {
			return "\n로그인 후 이용해주세요.\n";
		} 

		// 2) 로그인이 되어있는 경우
		// 회원 정보를 출력할 문자열을 만들어서 반환
		// (단, 비밀번호는 제외)
		return 	loginMember.toString();

	} // selectMember() 

	// 회원 정보 수정
	public String changeMember() { 
		System.out.println("\n***** 회원 정보 수정 *****\n");

		// 1) 로그인 여부 확인
		if(loginMember == null) {
			return "\n로그인 후 이용해주세요.\n";
		} 

		// 2) 로그인이 되어있는 경우
		// 회원 정보를 출력할 문자열을 만들어서 반환
		// (단, 비밀번호는 제외)
		int menuNum2 = 0;

		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();

		if(loginMember.getMemberPw().equals(inputPw)) {

			do {
				System.out.println("** 현재 정보 **");
				System.out.println("아이디 : " + loginMember.getMemberId());
				System.out.println();
				System.out.println("1. 이름 : " + loginMember.getMemberName());
				System.out.println("2. 나이 : " + loginMember.getMemberAge());
				System.out.println("3. 지역 : " + loginMember.getRegion());
				System.out.println();
				System.out.println("0. 수정 종료");

				System.out.print("변경할 정보 숫자 입력 >> ");
				menuNum2 = sc.nextInt(); // 필드에 작성된 Scanner sc 사용

				switch(menuNum2) {
				case 1 : 
					System.out.print("\n변경할 이름 입력 : ");
					String nameChange = sc.next();
					loginMember.setMemberName(nameChange)
					; break ;
				case 2 : 
					System.out.print("\n변경할 나이 입력 : ");
					int ageChange = sc.nextInt();
					loginMember.setMemberAge(ageChange)
					; break ;
				case 3 : 
					System.out.print("\n변경할 지역 입력 : ");
					String regionChange = sc.next();
					loginMember.setRegion(regionChange);
					; break ; 
				case 0 : 
					; break ;
				default : 
					System.out.println("\n잘못 입력하셨습니다. 다시 입력해주세요.");
				}

			} while (menuNum2 != 0);

			System.out.println("수정되었습니다.");

			return "\n회원 정보가 수정되었습니다.\n";

		} else {
			return "비밀번호를 확인해 주세요.";
		}
	} // changeMember() 
	
	
	// 회원 검색(지역) 메소드
	public void searchRegion() {
		System.out.println("\n***** 회원 검색(지역) *****");

		boolean flag = true;

		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();

		// 1) memberArr 배열의 모든 요소 순차 접근
		for(int i = 0 ; i < memberArr.length ; i++) {
			
			// 2) memberArr[i] 요소가 null인 경우 반복 종료
			if (memberArr[i] == null) {
				break;
			}
			
			// 3) memberArr[i] 요소에 저장된 지역이 
			// 	  입력 받은 지역과 같을 경우 회원의 아이디, 이름 출력
			if(memberArr[i] != null && inputRegion.equals(memberArr[i].getRegion())){
				System.out.println("아이디 : " + memberArr[i].getMemberId() + ", 이름 : " + memberArr[i].getMemberName());
				flag = false;
			} 
		}

		if(flag == true) {
			System.out.println("일치하는 검색 결과가 없습니다.\n");
		}

		
		
		
	}

	
	
	
}

