package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {

	
	// 얕은 복사 (shallow : 얕은) 
	// -> 주소를 복사하여 서로 다른 두 변수가
	// 하나의 배열(또는 객체)을 참조하는 상태를 만드는 복사 방법
	
	
	public void shallowCopy() {
		int[] arr = {1,2,3,4,5}; // 원본 배열
		
		// 얕은 복사 진행
		int[] copyArr = arr;
		
		System.out.println("주소 확인");
		System.out.println("arr : " + arr);
		System.out.println("copyArr : " + copyArr);
		
		
	}
		
	public void deepCopy() {
		
		int[] arr = {1,2,3,4,5}; // 원본 배열
		
		// 1. for문을 이용한 깊은 복사
		int[] copyArr1 = new int [arr.length]; // 5칸짜리 배열 생성
		
		for(int i = 0 ; i < arr.length ; i++) {
			copyArr1[i] = arr[i];
		}
		
		// 값 변경
		copyArr1[4] = 7;
		
		
		System.out.println("arr : " + arr);		
		System.out.println("arr : " + Arrays.toString(arr));		
		System.out.println("copyArr1 : " + copyArr1);		
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));		
		
		// 2. System.arraycopy(원본배열, 원본 복사 시작 인덱스, 복사할 배열명, 복사배열의 삽입 시작 인데스, 복사길이);
		
		int[] copyArr2 = new int[arr.length];
		
		System.arraycopy(arr,0,copyArr2,0,arr.length);
		
		// 값 변경
		copyArr2[4] = 70;

		System.out.println("copyArr2 : " + copyArr2);		
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));		
		
		
		// 3. 복사할 배열 참조 변수 = Arrays.copyOf(원본 배열, 복사할 길이);
		
		int[] copyArr3 = Arrays.copyOf(arr, arr.length);
		
		// 값 변경
		copyArr3[4] = 700;
		
		System.out.println("copyArr3 : " + copyArr3);		
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));		
	}
		
	public void createLotto() {
		// 로또 번호 생성

		// 1. 1 ~ 45 사이 중복되지 않는 난수 6개 생성
		// 2. 생성된 난수를 오름차순 정렬

		// 1) 정수 6개를 저장할 배열 선언 및 할당
		int[] lotto = new int[6];

		// 2) 생성된 배열을 처음부터 끝까지 순차 접근하는 for문 작성
		for(int i = 0 ; i < lotto.length ; i ++) { 

			// 3) 1 ~ 45 사이의 난수 생성 
			int num = (int)(Math.random()*45 + 1);

			// 4) 생성된 난수를 순서대로 배열 요소에 대입
			lotto[i] = num;

			// 5) 중복 검사를 위한 for문 작성
			for(int x = 0 ; x < i ; x++) {
				if(num == lotto[x]) {
					i--;
					// i가 1씩 증가할 때 마다 난수가 하나 생성됨. 
					// -> 중복 값이 있으면 난수를 하나 더 생성해야 된다. 
					// --> i는 기본적으로 0~5까지 6회 반복 되지만
					// 	   i 값을 인위적으로 1씩 감소시켜 7회 반복한다
					break;
				}
			}
		}
		Arrays.sort(lotto); 
		System.out.println(Arrays.toString(lotto));
	}


	
	

}


