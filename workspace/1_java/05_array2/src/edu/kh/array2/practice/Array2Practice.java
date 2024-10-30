package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	
	// 3행 3열짜리 문자열 배열을 선언 및 할당하고
	// 인덱스 0행 0열 부터 2행 2열까지 차례대로 접근하여 "(0,0)"과 같은 형식으로 저장 후 출력하세요. 
	public void practice1() {
		
//		(0, 0)(0, 1)(0, 2)
//		(1, 0)(1, 1)(1, 2)
//		(2, 0)(2, 1)(2, 2)
		
		String [][] arr = new String[3][3];
		
		for(int row = 0 ; row < arr.length ;row++) {
			for(int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = "(" + row + ", " + col + ")";
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}

	// 4행 4열짜리 정수형 배열을 선언 및 할당하고
	// 1) 1~16 까지 값을 차례대로 저장하세요
	// 2) 저장된 값들을 차례대로 출력하세요. 
	public void practice2() {
		
		int[][] arr = new int[4][4];
		
		int sum = 0;
		
		for(int row = 0 ; row < arr.length ; row ++) {
			for(int col = 0 ; col < arr.length ; col ++) {
				arr[row][col] = sum++;
				
				System.out.printf("%4d",arr[row][col]);			
			}
			System.out.println();
		}
	}

	
	// 4행 4열짜리 정수형 배열을 선언 및 할당하고
	// 1) 16~1 까지 값을 거꾸로 저장하세요
	// 2) 저장된 값들을 차례대로 출력하세요. 	
	public void practice3() {
		
		int[][] arr = new int[4][4];

		int sum = 16;

		for(int row=0; row<arr.length ; row++) {
			for(int col=0; col<arr[row].length ; col++) {
				arr[row][col] = sum--;
				System.out.printf("%4d",arr[row][col]);			
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		int[][] arr = new int[4][4];
		
		int sum = 0;
		
		for(int row = 0 ; row < 4 ; row++) {
//			int sumRow = 0;
			int sumCol = 0;
			for(int col = 0 ; col < 4 ; col++) {
				int rand = (int)(Math.random()*10+1);
				
				
//				if(row < 3) {
//					sumRow += arr[col][row];
//				}
				
				// arr[0][0] ~ arr[3][3] 일 때
				if(col < 4) {
					arr[row][col] = rand;
					System.out.printf("%-4d", arr[row][col]);
					sumCol += arr[row][col];
				} else if(col == 4) {
					System.out.printf("%-4d", sumCol);
				}
				
				sum += arr[row][col];
//				arr[3][col] = sumCol;
//				
//				arr[col][3] = sumRow;
				
			}
			System.out.println();
		}
		System.out.println(sum);
		
	}
	
	
	public void practice4_answer() {
		int[][] arr = new int[4][4];
		
		final int ROW_LAST_INDEX = arr.length - 1;
		final int COL_LAST_INDEX = arr[0].length - 1;
		
		for(int row = 0; row<arr.length; row++) { // 행 반복
			for(int col = 0; col<arr[row].length; col++) { // 열 반복
			
				if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX) {
					int random = (int)(Math.random()*10+1);
					
					arr[row][col] = random;
					
					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col];
					// 각 열의 마지막 행에 난수를 누적
					arr[ROW_LAST_INDEX][col] += arr[row][col];
					// 마지막 인덱스에 난수를 누적
					arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
				}
				System.out.printf("%4d ", arr[row][col]);
				
			} // 열 반복 끝
			System.out.println();			
		} // 행 반복 끝
		
	}

	// 2차원 배열 크기 입력, 1~10 숫자
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		int inputRow = 0;
		int inputCol= 0;
		
		while(true) {
			System.out.print("행 크기: ");
			inputRow = sc.nextInt();
			System.out.print("열 크기: ");
			inputCol = sc.nextInt();
			
			// 잘못 입력 시
			if(inputRow < 1 || inputRow > 10 || inputCol < 1 || inputCol > 10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다. 다시 입력하세요.");
			} 
			// 잘 입력 시 
			else {
				// 배열 선언
				char[][] arr = new char[inputRow][inputCol];

				for(int row=0 ; row < arr.length ; row++) { // 행 길이만큼 반복
					for(int col=0 ; col < arr[row].length ; col++) { // 열 길이만큼 반복
						arr[row][col] = (char)(int)(Math.random()*26 + 65);
						System.out.print(arr[row][col] + " ");
					}
					System.out.println();
				}
				break;
			}
		}	
	}
	
	
	// 사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
	// 문자형 가변 배열을 선언 및 할당하세요. 
	// 그리고 각 인덱스에 'a'부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
	
	////////////////////// ***** 수정 필요

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int inputRow = sc.nextInt();

		char ch = 'a';

		char[][] arr = new char[inputRow][];

		// 열의 크기를 정하는 for문
		for(int i = 0; i < arr.length ; i++) {
			System.out.printf("%d열의 크기 : ",i);
			arr[i] = new char[sc.nextInt()];
		}
		// 출력용 for문
		for(int row = 0; row < arr.length ; row++) {
			for(int col = 0 ; col < arr[row].length ; col++) {
				arr[row][col] = ch++;
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}

	
	public void practice6_answer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int inputRow = sc.nextInt();
		
		char[][] arr = new char[inputRow][];
		char ch = 'a'; 
		
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(i + "열의 크기 : ");
			int col = sc.nextInt();
			arr[i] = new char[col];
		}

		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length ; col++) {
				arr[row][col] = ch++;
				
				System.out.print(arr[row][col]);
				
			}
			System.out.println();
			
		}
		
	}
	
	
	// students 배열에서 1분단 2분단 나누기
	public void practice7() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};

		String[][] first = new String[3][2];
		String[][] second = new String[3][2];

		int count = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		// 1분단 대입 및 출력		
		System.out.println("== 1분단 ==");
		for(int r = 0; r < first.length ; r++) {
			// 1분단 열 반복 및 대입
			for(int c = 0 ; c < first[r].length ; c++) {
				first[r][c] = students[count++];
				System.out.print(first[r][c]+" ");
			}
			System.out.println();
		}

		// 2분단 대입 및 출력
		System.out.println("== 2분단 ==");
		for(int r = 0; r < first.length ; r++) {
			// 2분단 열 반복 및 대입
			for(int c = 0 ; c < second[r].length ; c++) {
				second[r][c] = students[count++];
				System.out.print(second[r][c] + " ");
			}
			System.out.println();
		}
	}

	// 학생 나누고, 검색 후 위치 출력
	public void practice8() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};

		String[][] first = new String[3][2];
		String[][] second = new String[3][2];

		int count = 0; // students 배열에서 0부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		// 1분단 대입 및 출력		
		System.out.println("== 1분단 ==");
		for(int r = 0; r < first.length ; r++) {
			// 1분단 열 반복 및 대입
			for(int c = 0 ; c < first[r].length ; c++) {
				first[r][c] = students[count++];
				System.out.print(first[r][c]+" ");
			}
			System.out.println();
		}

		// 2분단 대입 및 출력
		System.out.println("== 2분단 ==");
		for(int r = 0; r < first.length ; r++) {
			// 2분단 열 반복 및 대입
			for(int c = 0 ; c < second[r].length ; c++) {
				second[r][c] = students[count++];
				System.out.print(second[r][c] + " ");
			}
			System.out.println();
		}

		// 학생 검색
		Scanner sc = new Scanner(System.in);

		int group;
		String position;

		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.nextLine();

		for(int r = 0 ; r<first.length ; r++) {
			for(int c=0 ; c<first[r].length ; c++) {
				if(name.equals(first[r][c])) {
					group = 1;
					if(c == 0) {
						position = "왼쪽";
						System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",name, group, r+1, position);
						break;
					} else {
						position = "오른쪽";
						System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",name, group, r+1, position);
						break;
					} 
				}
				else if(name.equals(second[r][c])) {
					group = 2;
					if(c == 0) {
						position = "왼쪽";
						System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",name, group, r+1, position);
						break;
					} else {
						position = "오른쪽";
						System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",name, group, r+1, position);
						break;
					}
				}
			}
		}
	}

	// 2차원 배열 6행 6열 만들고, x 입력 시 해당 위치에만 표시하기
	public void practice9() {
		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		// X 의 위치
		System.out.print("행 인덱스 입력 : ");
		int inputRow = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int inputCol = sc.nextInt();
		
		arr[0][0] = "  ";
		arr[inputRow+1][inputCol+1] = "X ";

		// 행 반복
		for(int r = 0 ; r < arr.length ; r++) {
			
			
		}
	}


	public void practice9_answer() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];
		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int colIndex = sc.nextInt();
		
		int num1 = 0;
		int num2 = 0;
		
		for(int row = 0; row < arr.length; row++ ) {
			for(int col = 0; col < arr.length; col++) {
				
				if(row==0 && col!=0) {
					arr[row][col] = num1++ + " ";
				} 
				else if(row!=0 && col==0) {
					arr[row][col] = num2++ + " ";
				} 
				else {
					arr[row][col] = "  ";
				}
				
				arr[rowIndex+1][colIndex+1] = "X ";
				
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}

	// practice9 랑 같은데, 여러번 반복하면서 이전 값 저장 및 함께 출력
	public void practice10() {
		Scanner sc = new Scanner(System.in);

		String[][] arr = new String[6][6];

		String[][] arr2 = new String[6][6];



		int num1 = 0;
		int num2 = 0;

		for(int row = 0; row < arr.length; row++ ) {
			for(int col = 0; col < arr.length; col++) {
				if(row==0 && col!=0) {
					arr[row][col] = num1++ + " ";
				} 
				else if(row!=0 && col==0) {
					arr[row][col] = num2++ + " ";
				} 
				else {
					arr[row][col] = "  ";
				}
			}
		}

		while(true) {
			System.out.print("행 인덱스 입력 : ");
			int rowIndex = sc.nextInt();
			if(rowIndex == 99) {
				System.out.println("\n프로그램 종료");
				break;
			} 
			System.out.print("열 인덱스 입력 : ");
			int colIndex = sc.nextInt();
			
			if(rowIndex > 4 || colIndex > 4) {
				System.out.println("4 이하의 숫자를 입력하세요\n");
				continue;
			}
			arr[rowIndex+1][colIndex+1] = "X ";

			for(int row = 0; row < arr.length; row++ ) {
				for(int col = 0; col < arr.length; col++) {
					System.out.print(arr[row][col]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public void bingoGame() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();
		
		// 1차원 배열로 빙고판에 입력될 값 생성
		int[] randArr = new int[size*size];
		
		for(int i = 0 ; i < randArr.length ; i++) {
			randArr[i] = (int)(Math.random()*(size*size) + 1);
			// 중복 체크
			for(int j = 0 ; j < i ; j++) {
				if(randArr[i] == randArr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.print(Arrays.toString(randArr));
		
		
		String[][] bingo = new String[size][size];
		
		
		
		
		int answer = sc.nextInt();
		
		
		
	}
		
	
	public void bingo_answer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int size = sc.nextInt();
		
		// 1차원 배열로 빙고판에 입력될 값 생성
		int[] randArr = new int[size*size];
		
		for(int i = 0 ; i < randArr.length ; i++) {
			randArr[i] = (int)(Math.random()*(size*size) + 1);
			// 중복 체크
			for(int j = 0 ; j < i ; j++) {
				if(randArr[i] == randArr[j]) {
					i--;
					break;
				}
			}
		}
//		System.out.print(Arrays.toString(randArr));
		
		// 위에서 만들어진 중복제거한 1차원 배열(randArr)을 2차원 배열에 넣기
		// String 배열로 변경해서 진행
		// 왜? 빙고가 된 부분을 "★"로 변경하기 위해서
		
		String[][] bingo = new String[size][size];
		
		int index = 0; // 1차원 배열 인덱스 지정을 위한 변수
		
		for(int r = 0; r< bingo.length ; r++) {
			for(int c=0; c< bingo.length ; c++) {
				bingo[r][c] = randArr[index++]+"";

	            System.out.printf("%4s", bingo[r][c]);
			}
			System.out.println();
		}

		System.out.println("========= 빙고게임 시작 =========");
		
		
		// 정수 입력받고 "★"로 바꾸기
		while (true) {

		    System.out.print("\n정수를 입력하시오 : ");
		    String input = sc.next();
		    sc.nextLine();

		    // 정수 입력 체크다
		    boolean flag = true; 
		    // flag == true 	: 값 존재 X   정수 입력이 없는 경우 
		    // flag == false 	: 값 존재 O 
		    for (int r = 0; r < bingo.length; r++) {
		        for (int c = 0; c < bingo.length; c++) {
		            if (bingo[r][c].equals(input)) {
		            	flag = false; // 값 존재 O 
		                bingo[r][c] = "★"; // 일치하면 ★로 바꿈
		            } 
// 출력 구문		            
		            System.out.printf("%4s", bingo[r][c]);
		        }
		        System.out.println();
		    }
	
		    // 빙고 검사
		    
		    // 빙고 기준이 되는 문자열 생성
		    // ex) 4*4 크기 빙고 => 한 줄이 "★★★★"면 빙고
		    
		    
		    String bingoLine = "";
		    for(int i = 0; i < size ; i++) {
		    	bingoLine += "★";
		    }
		    
		    // 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
		    // -> 저장된 문자열의 모양이 "★★★★"인 경우 == 빙고
		    // -> bingoCount 증가
		    
		    int bingoCount = 0; // 빙고 수를 저장할 변수
		    
		    for(int r = 0 ; r < size ; r++) {
		    	// 매 반복 시 마다 rowLine, colLine을 빈 문자열로 초기화
		    	// 왜? 바깥쪽 for문이 반복될 때 마다 검사하는 행과 열이 이동하므로
		    	// 	빙고 여부를 검사하기 위한 rowLine, colLine을 빈 문자열("")로 초기화 해야함
		    	String rowLine = "";
		    	String colLine = "";

		    	for(int c = 0 ; c < size ; c++ ) {
		    		rowLine += bingo[r][c]; // 현재 행의 문자를 모두 더함
		    		// r,c(행, 열)를 반대로 하여 열의 모든 문자를 더함
		    		colLine += bingo[c][r]; // 현재 열의 문자를 모두 더함
		    		
		    		// 동시에 두 조건이 true 가 되면, 카운트를 2개 올려줘야 하기 때문에 따로 작성
		    		if(rowLine.equals(bingoLine)) {
		    			bingoCount++;
		    		}
		    		if(colLine.equals(bingoLine)) {
		    			bingoCount++;
		    		}
		    	}
		    }
		    	// 대각선 빙고 여부
		    	// 대각선 : diagonal

		    	// 대각선은 빙고판에서 두 개만 존재
		    	// -> 대각선 문자를 더해 저장할 변수 두개 선언 및 빈 문자열로 초기화

		    String diaLine1= ""; // 좌상 우하
		    String diaLine2= ""; // 좌하 우상

		    for(int i = 0; i < size ; i++) {
		    	diaLine1 += bingo[i][i]; // 좌상 우하
		    	diaLine2 += bingo[i][size-i-1];
		    }

		    if(diaLine1.equals(bingoLine)) {
		    	bingoCount++;
		    }
		    if(diaLine2.equals(bingoLine)) {
		    	bingoCount++;
		    }
		    System.out.println("현재 " + bingoCount + "빙고");
		    
		    if(bingoCount == 3) {
		    	System.out.println("**** Bingo! ****");
		    	break;
    		}
		}
	}


	public void bingoGame_cs() {
	      Scanner sc = new Scanner(System.in);


	      System.out.println("[빙고게임]");


	      System.out.print("빙고판 크기 지정 : ");
	      int n = sc.nextInt();

	      String[][] board = new String[n][n];

	      int[] list = new int[n*n];
	      for (int i=0; i<list.length; i++) {
	         list[i] = (int)(Math.random()*n*n)+1;
	         for (int j=0; j<i; j++) {
	            if (list[i] == list[j]) {
	               i--;
	               break;
	            }
	         }
	      }

	      for (int i=0; i<n; i++) {
	         for (int j=0; j<n; j++) {
	            board[i][j] = ""+list[i*n+j];
	            System.out.printf("%3s",board[i][j]);
	         }
	         System.out.println();
	      }
	      
	      
	      System.out.println("\n============게임 시작!===========\n");

	      while(true) {
	         System.out.print("\n정수를 입력하세요 : ");

	         String input = sc.next();

	         boolean flag = true;
	         
	         for (int i=0; i<n; i++) {
	            for (int j=0; j<n; j++) {
	               if (board[i][j].equals(input)) {
	                  flag = false;
	                  board[i][j] = "★";
	               }
	            }
	         }
	         if (flag) {
	            System.out.println("빙고판에 있는 정수가 아닙니다.");
	            continue;
	         }


	         int countBingGo = 0;

	         boolean cross1 = true;
	         boolean cross2 = true;
	         
	         for (int i=0; i<n; i++) {
	            if (!(cross1 && board[i][i].equals("★"))) cross1 = false;
	            if (!(cross2 && board[i][n-i-1].equals("★"))) cross2 = false;
	            
	            boolean flagRow = true;
	            boolean flagCol = true;
	            
	            for (int j=0; j<n; j++) {
	               if (!(flagRow && board[i][j].equals("★"))) flagRow = false;
	               if (!(flagCol && board[j][i].equals("★"))) flagCol = false;
	               
	               System.out.printf("%3s",board[i][j]);
	            }
	            if (flagRow) countBingGo++;
	            if (flagCol) countBingGo++;
	            
	            System.out.println();
	         }
	         if (cross1) countBingGo++;
	         if (cross2) countBingGo++;

	         
	         
	         System.out.println("현재 빙고 : "+countBingGo);

	         if (countBingGo>=3) {
	            System.out.println("빙고~~~~~\n내가 이겼다~~~~~~");
	            break;
	         }
	      }
	}
}
