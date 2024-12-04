package edu.kh.jdbc.board.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Reply;
import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.member.model.dto.Member;

public class BoardView {

	private Scanner sc = new Scanner(System.in);
	
	private BoardService service = new BoardService();
	
	/** 게시판 전용 메뉴 화면
	 * @param loginMember
	 * @throws SQLException 
	 */
	public void boardMenu(Member loginMember) throws Exception {
		
		int menuNum = -1; 
		
		do {
			
			try {
				System.out.println("\n ********** 게시판 메뉴 ********** \n");
				
			System.out.println("1. 게시글 목록 조회");
			System.out.println("2. 게시글 상세");
			System.out.println("0. 회원 메뉴로 돌아가기");
			
			System.out.print("메뉴를 선택해주세요 >> ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : selectAll(); break;
			case 2 : selectOne(loginMember); break;
			// 상세 조회 시 게시글 수정/삭제
			// 댓글 수정/삭제
			
			case 0 : System.out.println("회원 메뉴로 돌아갑니다.") ; break; 
			default : System.out.println("메뉴의 숫자만 입력해주세요.");
			}
			
				
			}catch(InputMismatchException e) {
				e.printStackTrace();
				sc.nextLine();
			}
			
		} while(menuNum != 0);
		
		
	}
	
	private void selectAll() throws Exception {

		
		// 게시글 목록 조회 Service 호출 후 결과 반환 받기
        List<Board> boardList = service.selectAll();
		// 조회 결과가 없는 경우 : "조회된 게시글이 없습니다."
				
		System.out.println("[게시글 목록 조회]");
		System.out.println("♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡");
        System.out.printf("%5s %13s %16s %12s %11s", "글번호", "제목", "작성자", "작성일", "조회수\n");
        System.out.println("♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡");
        for(Board board : boardList) {
        	System.out.println(board.toString2());
           //System.out.printf("%5d %15s [%d] %10s %17tF %6d\n", board.getBoardNo(), board.getBoardTitle(), board.getReplyCount(), board.getMemberName(), board.getCreateDate(), board.getReadCount());
        }
        System.out.println("♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡");
		
		// 있는 경우 : 글번호, 제목 ,작성자, 작성일, 조회수, 댓글수 향상된 for문 이용해서 출력 
	}
	
	/** 게시글 상세조회
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {
		System.out.println("[게시글 상세 조회]");
		
		System.out.println("조회할 게시글 번호 입력 : ");
		int boardNo = sc.nextInt();
		
		try {
			// 게시글 상세조회 Service 호출 후 결과 반환(게시글 1개의 정보 == Board)
			
			Board board = service.selectOne(boardNo);
		
			if(board != null) { // 조회된 게시글이 있을 경우
				// 상세 조회 출력
	            System.out.println("\n------------------------------------------------------------");
	            System.out.printf("번호 : %d     |  제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("작성자 : %s\n"
	                  + "작성일 : %s\n"
	                  + "조회수 : %d\n", 
	                  board.getMemberName(), board.getCreateDate(), board.getReadCount());
	            System.out.println("------------------------------------------------------------");
	            System.out.printf("\n%s\n\n", board.getBoardContent());
	            System.out.println("------------------------------------------------------------");

	            // 댓글 목록 조회
	            System.out.println("\n[댓글]");
	            for( Reply r : board.getReplyList() ) {
	               System.out.printf("<%d> | %s | %s\n", 
	                     r.getReplyNo(), r.getMemberName(), r.getCreateDate());

	               System.out.println(r.getReplyContent());
	               System.out.println(".............................................................\n");
	            }
	            
	            // ----------------------------------------------------------------------------------
	            // 상세 조회용 메뉴 출력
	            
	            System.out.println("===== 상세 조회 메뉴 =====");
	            
	            System.out.println("1. 댓글 삽입");	// 어떤 회원이든 가능
	            
	            // 댓글을 작성한 회원 번호 == 로그인한 회원 번호
	            System.out.println("2. 댓글 수정");	
	            System.out.println("3. 댓글 삭제");
	            
	            // 상세 조회된 게시글의 회원 번호 == 로그인한 회원 번호 
	            if(board.getMemberNo() == loginMember.getMemberNo()) {
	            	System.out.println("4. 게시글 수정");
	            	System.out.println("5. 게시글 삭제");
	            }
	            
	            
	            System.out.println("0. 게시판 메뉴로 돌아가기");
	            
	            System.out.print("메뉴 선택 >> ");
	            int menuNum = sc.nextInt();
	            sc.nextLine();
	    		
	            switch(menuNum) {
	            case 1 : insertReply(loginMember, boardNo); break;
	            case 2 : case 3 : 
	            	// 수정 혹은 삭제 하고자 하는 댓글 번호 입력 받기
	            	// 입력 받은 댓글의 번호가 댓글 목록에 존재하는 경우 수정/삭제 진행
	            	// 만약 내가 작성한 댓글의 번호가 아닌 경우 "현재 로그인한 회원의 댓글이 아닙니다."
	            	
	            	// 존재하지 않는 경우 "해당 댓글이 존재하지 않습니다"
	            	// 댓글을 작성한 회원 번호 == 로그인한 회원 번호
	            	System.out.println("[수정 / 삭제]");
	            	System.out.print(");
	            	int input = sc.
	            	
	            	if()
	            	
	            	
	            	break;
	            case 4 : case 5 : 
	            	// 게시글 작성자 번호 == 로그인 회원 번호
	            	if(board.getMemberNo() == loginMember.getMemberNo()) {
	            		if(menuNum == 4) { // 4번 게시글 수정
	            			updateBoard(boardNo);
	            		} else { // 5번 게시글 삭제 
	            			deleteBoard(boardNo);
	            			
	            		}
	            		
	            	} else {
	            		System.out.println("메뉴에 표시된 번호만 입력해주세요.\n");
	            	}
	            	
	            	break;
	            case 0 : System.out.println("\n게시판 메뉴로 돌아갑니다.\n"); break;
	            default : System.out.println("메뉴에 표시된 번호만 입력해주세요.\n");
	            }
	            
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**	댓글 추가
	 * @param loginMember
	 * @param boardNo
	 */
	private void insertReply(Member loginMember, int boardNo) {
		System.out.println("[댓글 추가]");
		
		System.out.printf("[%s]님 댓글 : ",loginMember.getMemberName());
		String content = inputContent();
		
		Reply reply = new Reply();
		reply.setBoardNo(boardNo);
		reply.setMemberNo(loginMember.getMemberNo());
		reply.setReplyContent(content);
		
		
		try {
			int result = service.insertReply(reply);
			
			if(result > 0) {
				System.out.println("댓글 추가 성공!");
			} else {
				System.out.println("댓글 추가 실패...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

	/** 게시글 삭제
	 * @param boardNo
	 * @throws Exception 
	 */
	private void deleteBoard(int boardNo) throws Exception {
		System.out.println("[게시글 삭제]");
		
		// "정말 삭제하시겠습니까? (Y/N)" -- 제대로 입력 될 때 까지 무한 반복
		// -> "Y" 입력 시 보안문자 생성
		// -> 보안 문자가 일치하는 경우에 삭제 진행
		char confirm = ' ';
		while(true) {
			System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
			confirm = sc.next().toUpperCase().charAt(0);

//			if(confirm == 'Y') {
//				String captcha = captcha();
//				System.out.println("[보안문자를 정확히 입력해 주세요]");
//				System.out.println("보안문자 : " + captcha);
//				System.out.print("입력 : ");
//				String input = sc.next();
//				if(input.equals(captcha)){
//					service.deleteBoard(boardNo);
//					System.out.println("삭제되었습니다.");
//					break;
//				} else {
//					System.out.println("보안문자가 일치하지 않습니다.");
//					break;
//				}
//				break;
//			} else if (confirm == 'N') { 
//				
//			} else {
//				System.out.println("Y 또는 N을 입력해주세요.");
//			}

			if(confirm == 'Y' || confirm == 'N') {
				break;
			} else {
				System.out.println("Y 또는 N을 입력해주세요.\n");
			}
		}
		if(confirm == 'Y') { // 삭제 하려는 경우
			// 보안 문자 생성
			String cap = captcha();
			System.out.println("다음 보안문자를 입력해주세요 >> " + cap);

			System.out.print("보안 문자 입력 : ");
			String input = sc.next();

			if(input.equals(cap)) { // 입력받은 문자열과 보안 문자가 같을 경우

				try {
					// 삭제 메소드 호출
					int result = service.deleteBoard(boardNo);
					
					if(result > 0) {
						System.out.println(boardNo + "번 게시글이 삭제되었습니다.");
					}else {
						System.out.println("게시글 삭제 실패...");
					}
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else { // 보안 문자 일치하지 않을 경우
				System.out.println("\n보안 문자가 일치하지 않습니다.\n");
				
			}
			
			
			
		}else {
			System.out.println("\n삭제를 취소했습니다.\n");


		}
		
		
		
	}


	/**
	 * 보안 문자 생성 메소드 (랜덤 영어소문자 5개)
	 */
	private String captcha() {
		
		String cap = "";
		
		for(int i = 0 ; i < 5 ; i++) {
			cap += (char)(Math.random()*26 + 'a');
			// int 형변환 : 97~122
			// char 형변환 : 'a' ~ 'z'
		}
		
		return cap; 
	}
	
	
	
	/** 게시글 수정
	 * @param boardNo
	 */
	private void updateBoard(int boardNo) {
		System.out.println("\n[게시글 수정]\n");
		
		System.out.print("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		
		System.out.println("\n수정할 내용 (종료 시 @exit 입력)\n");
		String boardContent = inputContent(); // 내용 입력 메소드 호출 후 결과 반환 받기
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		try {
			int result = service.updateBoard(board);
			
			if (result != 0) {
			} else {
				System.out.println("게시글 수정 실패 ㅠㅠ");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/* String(객체)
	 * - 불변성(immutable) <-> 가변성(mutable)
	 * 
	 * 불변성: 
	 *  -> 한번 생성된 String 객체에 저장된 문자열은 변하지 않는다! 
	 * 
	 * e) String str = "abc"; // Heap 영역에 String 객체가 생성되고
	 *						  // 생성된 객체에 "abc" 문자열 저장
	 *
	 *		str += "123"; // "123"이 저장된 String 객체 생성 후
	 *					  // "abc"와 "123"이 합쳐진 String 객체가 추가로 별도 생성
	 *					  // 그 후 "abc123" 객체의 주소를 str에 저장
	 *
	 *
	 *	** String의 문제점 **
	 * - String 에 저장된 값을 바꾸거나 누적하려고 할 때 마다
	 *   String 객체가 무분별하게 생성됨 --> 메모리 낭비
	 *   
	 *  ** 해결 방법 **
	 *  - StringBuffer / StringBuilder (가변성)
	 *    클래스를 자바에서 제공함 (사용 방법 동일)
	 *    					-> 파이점은 동기/비동기
	 *    
	 *   
	 * 
	 * */
	/** 내용 입력 메소드
	 * @return content
	 */
	private String inputContent() {
		
//		String content = "";
		
		StringBuffer content = new StringBuffer();
		
		while(true) { // @exit이 입력될 때 까지 무한히 문자열을 입력 받아
					  // 하나의 변수에 누적 == 게시글 내용
			String input = sc.nextLine();
			
			if(input.equals("@exit")) {
				break;
			} else {
//				content += input + "\n"; // 줄 바꾸며 누적
				
				content.append(input);
				content.append("\n");
				// StringBuffer에 저장된 문자열의 제일 뒤에 input을 추가(누적)
				// append : (제일 뒤에 덧붙이다, 추가하다)
				
				// -> 하나의 StringBuffer 객체에 문자열이 계속 누적됨 == 가변
				//    (추가적인 String 객체 생성 없음)
			}
		}
		
		System.out.println(content);
		return content.toString(); // StringBuffer에 오버라이딩된 toString()
		// -> 저장된 문자열을 String 형태로 반환
	}
	
	

}
