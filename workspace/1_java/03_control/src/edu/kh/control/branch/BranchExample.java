package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {

	
	// 분기문 
	// break : (가장 가까운) 반복문을 멈춤
	// continue : (가장 가짜운) 반복문의 시작 부분으로 이동(다음 반복 진행)


	public void ex1() {
		for(int i = 1; i <= 10000; i++) {
			// 홀수인 경우 출력 X
			// i가 20인 경우 반복을 멈춤
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
			
			if(i == 20) {
				break;	// i 가 20이 되면 수행하지 않고 멈추기 때문에, 
			}
		}
	}
	
	
	// 1~100까지 1씩 증가하며 출력하는 반복문
	// 단, 5의 배수는 건너뛰고
	// 증가하는 값이 40이 되었을 때 반복을 멈춤
	public void ex2() {

		for(int i = 1 ; i <= 100 ; i++) {
			if(i == 40) { // 40 인지 먼저 확인 하고 
				break;
			}
			if(i % 5 == 0) { // i가 5의 배수면 넘겨라
				continue;
			}
			System.out.println(i);
		}
	}	
	
	
	public void ex3() {
		
		for(int dan = 2 ; dan <= 9 ; dan++) {
			
			for(int i = 1 ; i <= 9 ; i++) {
				
				System.out.printf("%d x %d = %d ", dan, i, dan*i);
				if(i == dan) {
					break;
					// 분기문이 중첩 반복문 내에서 사용되면
					// 현재 반복문 종료하고 그 밖 가장 가까운 반복문에 작용! 
				}
			}
			System.out.println();
		}
	}
	
	// col이 3의 배수인 경우 출력 X
	// row가 3일 때 반복 종료
	public void ex4() {
		for(int row = 1; row <=6; row++) {
//			if(row == 3) { // 이걸 여기 두면 row == 3 일 때 출력도 안함
//				break;
//			}
			for (int col = 1 ; col <= 10; col++) {
				if(col % 3 == 0) {
					continue;
				}
				System.out.printf("(%d, %d) ", row, col);
			}

			System.out.println();
		}
	}
	
	// 0이 입력될 때 까지 모든 정수의 합 구하기
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int input = -1; 
		
		// 방법 1. while : input에 초기값을 0(조건)이 아닌 다른 값을 넣었다. 
		
		// 방법 2. do - while 
		
		
		// 방법 3. while + break 
		while(true) { // 무한 반복(무한 루프)
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			if(input == 0) {
				break; // 0 입력 시 반복문 종료
			}
			
			sum += input;
			
		}
		
		System.out.println("합계 : " + sum);
		
	}
	
	
	// 업다운 게임
	// 입력 받은 수가 정답일 때 까지 다시 입력 시키기
	public void upDownGame() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("===UpDown 게임===");
		int input = 0;
		System.out.println();
		
		int answer = (int)(Math.random() * 100 + 1);
//		System.out.println("답 : " + answer); // 답안 임시 확인
		
		
		int count = 1;
		
		

		
		while(true) {
			System.out.printf("%d번째 입력 : ", count);	
			input = sc.nextInt();
			
			if(1 > input || input > 100) { // 잘못 입력한 경우
				System.out.println("1 ~ 100 사이 수를 입력해주세요");
				continue;
			} 
			
			if (input < answer) { // 입력값이 정답보다 작은 경우
				System.out.println("up");
			} else if (input > answer) { // 입력값이 정답보다 큰 경우 
				System.out.println("down");
			} else {
				System.out.println("[정답!]");
				System.out.printf("입력 횟수 : %d", count );
				break;
			}
			count ++;
			
		}
		
	}
	
	// 입력 받은 모든 문자열을 누적
	// 단, "end!" 입력 시 문자열 누적을 종료하고 결과 출력 
	public void ex6() {
		
		// next(); : 다음 한 단어 (띄어쓰기 포함 X )
		// nextLine(); : 다음 한 줄 (띄어쓰기 포함 O)
		
		
		//** next()로 문장을 작성 시 결과가 이상한 이유 **
		//입력 -> 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
		// * next(), nextIny(), nextDouble() 등
		// 모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어옴

		
		Scanner sc = new Scanner(System.in);
		
		String str = ""; // 빈 문자열
		
		while(true) {
			
			System.out.print("문자열 입력(end! 입력 시 종료) : ");
			String input = sc.nextLine();

			
			
			// 입력 받는 문자열이 "end!"면 반복 종료
//			if(input == "end!") { // 이렇게 쓰는 것 아님
			if("end!".equals(input)) {
		
				// String 자료형은 비교 연산자(==)로 같은 문자열인지 판별 X
				
				// 비교 연산자는 보통 기본 자료형끼리 연산에만 사용 가능
				// -> String은 기본 자료형이 아닌 참조형
				
				// ** [해결 방법] : 문자열1.equals(문자열2) ** 
				break;
			}
			str += input + "\n";
			System.out.println(str);

		}
		System.out.println(str);
		
	}
	
	// 가위바위보 게임 만들기
	// 몇판인지 입력 필요?
	public void RPSGame() {

		Scanner sc = new Scanner(System.in);
		System.out.print("몇판을 진행할까요? : ");
		int rounds = sc.nextInt();

		String input = "";
		String pcInput = "";

		int number = 0;

		int win = 0;
		int lose = 0;
		int draw = 0;

		for(int i = 1 ; i <= rounds ; i++) { // rounds 입력값 만큼 플레이

			System.out.println("\n" + i + "번째 게임");

			while (true) {
				System.out.print("가위/바위/보 중 하나를 입력 해주세요: ");
				input = sc.next();
				if (input.equals("가위") || input.equals("바위") || input.equals("보")) {
					break;
				}
				if (i == rounds) {
					continue;
				}
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}



			int pcNumber = (int)(Math.random() * 3) + 1; // (int)(0.0 <= pc < 1.0) * 3 + 1
			// 1 <= pc < 4 	// 1 부터 4 미만(3 이하) 출력 


			// pc 인풋 int -> string
			switch(pcNumber) {
			case 1 : 
				pcInput = "가위"; break;
			case 2 : 
				pcInput = "바위"; break;
			case 3 : 
				pcInput = "보"; break;
			}
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n",pcInput);


			// 유저 인풋 string -> int
			switch(input) {
			case "가위" : 
				number = 1; break;
			case "바위" :
				number = 2; break;
			case "보" :
				number = 3; break;
			default : 
				System.out.println("다시 입력해주세요.");
			}


			// 승패 판정
			if (number == pcNumber) {
                		draw++;
                	System.out.println("비겼습니다.");
            		} else if ((number == 1 && pcNumber == 3) || 
                       		   (number == 2 && pcNumber == 1) || 
                       		   (number == 3 && pcNumber == 2)) {
                		win++;
                		System.out.println("플레이어 승!");
            		} else {
                		lose++;
                		System.out.println("졌습니다ㅠㅠ");
            		}		
			
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, lose);
		}
		
//		1: 가위
//		2: 바위
//		3: 보
//
//		pc	나	결과
//		---------------	
//		1	1	비김	
//			2	이김	
//			3	짐	
//		2	1	짐	
//			2	비김	
//			3	이김	
//		3	1	이김	
//			2	짐	
//			3	비김	
		
		
		// 1번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
		   // 컴퓨터는 [보]를 선택했습니다.
		   // 플레이어 승!
		   // 현재 기록 : 1승 0무 0패

		   // 2번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  보
		   // 컴퓨터는 [보]를 선택했습니다.
		   // 비겼습니다.
		   // 현재 기록 : 1승 1무 0패

		   // 3번째 게임
		   // 가위/바위/보 중 하나를 입력 해주세요 :  가위
		   // 컴퓨터는 [바위]를 선택했습니다.
		   // 졌습니다ㅠㅠ
		   // 현재 기록 : 1승 1무 1패
		
		
		
	/*
	import java.util.Scanner;

public class RPSGame {

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 판을 진행할까요? : ");
        int rounds = sc.nextInt();

        int won = 0;
        int lost = 0;
        int tied = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.printf("%d번째 게임\n", i);

            String input = "";
            String pcInput = "";
            int number = 0;

            // 유저의 입력 받기
            while (true) {
                System.out.print("가위/바위/보 중 하나를 입력 해주세요: ");
                input = sc.next();
                if (input.equals("가위") || input.equals("바위") || input.equals("보")) {
                    break;
                }
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }

            // 컴퓨터의 선택 (1: 가위, 2: 바위, 3: 보)
            int pcNumber = (int) (Math.random() * 3) + 1;

            switch (pcNumber) {
                case 1:
                    pcInput = "가위";
                    break;
                case 2:
                    pcInput = "바위";
                    break;
                case 3:
                    pcInput = "보";
                    break;
            }

            System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", pcInput);

            // 유저 입력에 따른 숫자 매칭
            switch (input) {
                case "가위":
                    number = 1;
                    break;
                case "바위":
                    number = 2;
                    break;
                case "보":
                    number = 3;
                    break;
            }

            // 승패 판정 로직
            if (number == pcNumber) {
                tied++;
                System.out.println("비겼습니다.");
            } else if ((number == 1 && pcNumber == 3) || 
                       (number == 2 && pcNumber == 1) || 
                       (number == 3 && pcNumber == 2)) {
                won++;
                System.out.println("플레이어 승!");
            } else {
                lost++;
                System.out.println("졌습니다ㅠㅠ");
            }

            // 현재 기록 출력
            System.out.printf("현재 기록: %d승 %d무 %d패\n", won, tied, lost);
        }

        // Scanner 닫기
        sc.close();
    }

    public static void main(String[] args) {
        RPSGame game = new RPSGame();
        game.startGame();
    }
}
*/
		
		
		
		
	}
	
	
}