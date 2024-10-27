package edu.kh.control.branch;

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
            arr[i] = 9 - i;
        }

        // 배열의 모든 요소 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // 줄바꿈

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

        // 1. 사용자로부터 양의 정수 입력 받기
        System.out.print("양의 정수 : ");
        int size = sc.nextInt();

        // 2. 입력받은 정수 크기의 배열 선언 및 할당
        int[] arr = new int[size];

        // 3. 배열에 1부터 입력 받은 값까지 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // 4. 배열 요소 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

public void practice4() {
        Scanner sc = new Scanner(System.in);

        // 1. 크기가 5인 정수 배열 선언
        int[] arr = new int[5];

        // 2. 사용자로부터 배열 요소 입력 받기
        for (int i = 0; i < arr.length; i++) {
            System.out.print("입력 " + i + " : ");
            arr[i] = sc.nextInt();
        }

        // 3. 검색할 값 입력 받기
        System.out.print("검색할 값 : ");
        int searchValue = sc.nextInt();

        // 4. 검색한 값의 인덱스 찾기
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
  
public void practice5() {
        Scanner sc = new Scanner(System.in);

        // 1. 문자열 입력 받기
        System.out.print("문자열 : ");
        String input = sc.nextLine();

        // 2. 검색할 문자 입력 받기
        System.out.print("문자 : ");
        char searchChar = sc.next().charAt(0);

        // 3. 문자열의 문자 하나하나를 탐색하며 개수와 위치 확인
        int count = 0; // 문자 개수 저장
        StringBuilder indices = new StringBuilder(); // 인덱스를 저장할 StringBuilder

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == searchChar) {
                count++;
                indices.append(i).append(" "); // 인덱스를 StringBuilder에 추가
            }
        }

        // 4. 결과 출력
        if (count > 0) {
            System.out.printf("%s에 %c가 존재하는 위치(인덱스) : %s\n", input, searchChar, indices);
            System.out.printf("%c 개수 : %d\n", searchChar, count);
        } else {
            System.out.printf("%s에 %c가 존재하지 않습니다.\n", input, searchChar);
        }
    }

      public void practice6() {
        Scanner sc = new Scanner(System.in);

        // 1. 배열의 길이 입력받기
        System.out.print("정수 : ");
        int size = sc.nextInt();

        // 2. 입력받은 길이만큼 정수형 배열 선언 및 할당
        int[] arr = new int[size];

        // 3. 배열의 각 인덱스에 사용자 입력으로 초기화
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
            arr[i] = sc.nextInt();
        }

        // 4. 배열의 전체 값 나열
        System.out.println("배열에 저장된 값:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 5. 배열의 모든 값의 합 계산
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // 6. 합 출력
        System.out.println("총 합 : " + sum);
    }

   public void practice7() {
        Scanner sc = new Scanner(System.in);

        // 1. 주민등록번호 입력받기
        System.out.print("주민등록번호(-포함) : ");
        String rrn = sc.nextLine(); // 주민등록번호 입력

        // 2. 주민등록번호를 char 배열로 변환
        char[] arr = rrn.toCharArray();

        // 3. 성별 숫자 이후부터 '*'로 마스킹 처리
        for (int i = 8; i < arr.length; i++) { // 인덱스 8부터 *로 변경
            arr[i] = '*';
        }

        // 4. 결과 출력
        System.out.println(arr); // char 배열 출력
    }


  
}




