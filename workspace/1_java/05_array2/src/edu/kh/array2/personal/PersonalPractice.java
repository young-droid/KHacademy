package edu.kh.array2.personal;

public class PersonalPractice {

	// 로또 만들기
	// 6자리 숫자 배열, 난수, 중복X
	public void practice1() {
		
		// 로또 배열 선언
		int[] lotto = new int[6];
		// 난수 생성
		int rand = (int)(Math.random()*6 +1);
		
		// 배열에 난수 할당
		for(int i=0 ; i < lotto.length ; i++) {
			lotto[i] = rand;
			
			// 중복 체크
			for(int x=0 ; x<i ; x++) { // i 다음 숫자를 그 전까지의 숫자와 비교
				if(lotto[x] == lotto[i]) {
					
				}
			}
			
		}
		
		
		
	}
	
}
