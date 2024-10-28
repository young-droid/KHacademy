package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {

          // 길이가 9인 배열 선언 및 할당
        int[] arr = new int[9];
        
          // 1부터 9까지 값을 배열에 대입
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 배열의 모든 요소 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // 줄바꿈

        // 짝수 인덱스(0, 2, 4, ...) 합
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) { // 짝수 인덱스만 접근
            sum += arr[i];
        }

        System.out.println("짝수 번째 인덱스 합 : " + sum);
    }

 public void practice2() {
        // 길이가 9인 배열 선언 및 할당
        int[] arr = new int[9];

        // 반복문을 사용해 9부터 1까지 값을 배열에 대입
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 


        // 홀수 인덱스(1, 3, 5, ...) 값의 합 계산
        int sum = 0;
        for (int i = 1; i < arr.length; i += 2) { // 홀수 인덱스만 접근
            sum += arr[i];
        }

        // 합계 출력
        System.out.println("홀수 번째 인덱스 합 : " + sum);
    }

  public void practice3() {
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 양의 정수 입력 받기
        System.out.print("양의 정수 : ");
        int size = sc.nextInt();

        // 입력받은 정수 크기의 배열 선언 및 할당
        int[] arr = new int[size];

        // 배열에 1부터 입력 받은 값까지 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 배열 요소 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

public void practice4() {
        Scanner sc = new Scanner(System.in);

        // 크기가 5인 정수 배열 선언
        int[] arr = new int[5];

        // 사용자로부터 배열 요소 입력 받기
        for (int i = 0; i < arr.length; i++) {
            System.out.print("입력 " + i + " : ");
            arr[i] = sc.nextInt();
        }

        // 검색할 값 입력 받기
        System.out.print("검색할 값 : ");
        int searchValue = sc.nextInt();

        // 검색한 값의 인덱스 찾기
        boolean flag = false; // 값을 찾았는지 여부 확인
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                System.out.println("인덱스 : " + i);
                flag = true;
                break; // 값을 찾으면 더 이상 반복하지 않음
            }
        }


        if (!flag) {
            System.out.println("일치하는 값이 존재하지 않습니다.");
        }
    }
  

// *******************다시 하자*************
// 문자열을입력받아문자하나하나를배열에넣고검색할문자가문자열에몇개들어가있는지
// 개수와몇번째인덱스에위치하는지인덱스를출력하세요.
// [실행화면]
// 문자열: application
// 문자: i
// application에i가존재하는위치(인덱스) : 4 8 
// i개수: 2

public void practice5() {
       Scanner sc = new Scanner(System.in);
        
       int count = 0;
        
       System.out.print("문자열 : ");
       String input = sc.nextLine();

       char[] arr = new char[input.length()];
       
       for(int i = 0; i < arr.length; i++) {
    	   arr[i] = input.charAt(i);
       }
       
       
       System.out.print("문자 : ");
       char input2 = sc.nextLine().charAt(0);
       
       
       
       System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ", input, input2);
       for(int i = 0; i < arr.length; i++) {
    	   if(arr[i] == input2 ) {
    		   System.out.print(i + " ");
    		   count ++;
    	   }
       }
    
       System.out.println();
       System.out.print("개수 : " + count);
        
	}        
        
    

      public void practice6() {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이
        System.out.print("정수 : ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // 배열의 각 인덱스에 사용자 입력으로 초기화
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
            arr[i] = sc.nextInt();
        }

        // 배열의 전체 값 나열
        System.out.println("배열에 저장된 값:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 배열의 모든 값의 합 계산
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // 합 출력
        System.out.println("총 합 : " + sum);
    }


      public void practice6_answer() {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이
        System.out.print("정수 : ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        
        int sum = 0;
        String value = "";
        
        
        // 배열의 각 인덱스에 사용자 입력으로 초기화
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
            arr[i] = sc.nextInt();
            
            sum += arr[i];
            value += arr[i] + " ";
            
        }
        

        // 배열의 전체 값 나열
        System.out.println("배열에 저장된 값:");
        System.out.print(value);
        System.out.println();

        // 합 출력
        System.out.println("총 합 : " + sum);
    }

      
   public void practice7() {
        Scanner sc = new Scanner(System.in);

        // 주민등록번호 입력받기
        System.out.print("주민등록번호(-포함) : ");
        String rrn = sc.nextLine(); // 주민등록번호 입력

        // 주민등록번호를 char 배열로 변환
        char[] arr = rrn.toCharArray();

        // 성별 숫자 이후부터 '*'로 마스킹 처리
        for (int i = 8; i < arr.length; i++) { // 인덱스 8부터 *로 변경
            arr[i] = '*';
        }

        System.out.println(arr); // char 배열 출력
    }

   public void practice7_answer() {
       Scanner sc = new Scanner(System.in);

       // 주민등록번호 입력받기
       System.out.print("주민등록번호(-포함) : ");
       String input = sc.nextLine(); // 주민등록번호 입력

       // 주민등록번호를 char 배열로 변환
       char[] arr = new char[input.length()];

       // 성별 숫자 이후부터 '*'로 마스킹 처리
       for (int i = 8; i < arr.length; i++) { // 인덱스 8부터 *로 변경
           arr[i] = '*';
       }

       System.out.println(arr); // char 배열 출력
   }
  
   
   public void practice8() {
	
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.print("정수 : ");
	   int input = sc.nextInt();	   

	   while(true) {

		   int[] arr = new int[input];


		   if(input < 3 || input % 2 == 0) {
			   System.out.println("다시 입력하세요.");
		   }


		   int num = 1; 

		   for(int i = 0 ; i < arr.length ; i++) {
			   if(i <= (arr.length/2)) {
				   arr[i] = num++;
			   } 
			   else {
				   arr[i] = arr.length-i;
			   }

			   if(i == 0) {
				   System.out.print(arr[i]);

			   } else {
				   System.out.print(", " + arr[i]);
			   }
		   }
		   break;
	   }
   } 
   
   
   public void practice9() {
	   
	   int[] arr = new int[10];
	   
	   System.out.print("발생한 난수 : ");
	   
	   for(int i = 0 ; i < arr.length ; i++) {
		   int num = (int)(Math.random()*10+1);
		   arr[i] = num;
		   System.out.print(arr[i] + " ");
	   }
   }

   
   
   // 난수 발생시키고 min, max 찾기
   public void practice10() {

	   int[] arr = new int[10];

	   System.out.print("발생한 난수 :");

	   for(int i = 0 ; i < arr.length ; i++ ) {
		   arr[i] = (int)(Math.random()*10+1);
		   
		   System.out.print(" " + arr[i]);
	   }

	   // 최대 최소 찾기
	   int min = arr[0];
	   int max = arr[0];

	   for(int i = 0 ; i < arr.length ; i++) {

		   if(arr[i] > max) {
			   max = arr[i];		   
		   }
		   if(min > arr[i]) {
			   min = arr[i]; 
		   }
	   }
	   System.out.println();
	   System.out.println("최대 : " + max);
	   System.out.println("최소 : " + min);

   }

   
   public void practice11() {
	   
	   int[] arr = new int[10];

	   // 배열에 난수 초기화

	   for(int i = 0 ; i < arr.length; i++ ) {

		   arr[i] = (int)(Math.random()*10 + 1);

		   for(int x = 0 ; x < i ; x++) {
			   if(arr[i] == arr[x]) {
				   i--;
				   break;
			   }

		   }

	   }
	   // 출력용	
	   for(int i = 0 ; i < arr.length ; i++) {
		   System.out.print(arr[i]+ " ");

	   }

	   
   }
   
   // 로또
   public void practice12() {
	   
   }
   

   public void practice13() {
	   
	   Scanner sc = new Scanner(System.in);
	   
	  System.out.print("문자열 : " );
	  String input = sc.nextLine();
	  
	  char[] arr = new char[input.length()];
	  
	  System.out.print("문자열에 있는 문자 : ");
	  
	  
	  // 배열 인덱스에 각 문자 대입
	  for(int i = 0 ; i < arr.length; i++ ) {
		  
		  arr[i] = input.charAt(i);
		  
		  for(int x = 0 ; x < i; x++) {
			  
			  if(arr[x] == arr[i]) {
				  i--;
				  break;
			  }
			  System.out.print(arr[i] + " ");
		  }
		  
	  }
	  
	  
	 
	  
	  
	  
	  
	  
	  
	   
   }
   
}