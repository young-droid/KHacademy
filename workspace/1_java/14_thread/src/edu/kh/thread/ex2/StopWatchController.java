package edu.kh.thread.ex2;

import java.util.Scanner;

public class StopWatchController {

	public void watchStart() {

//	public static void main(String[] args) {

		// 스톱워치 스레드 생성

		Thread stopWatch = new Thread(new StopWatch());

		// 스톱워치 실행
		stopWatch.start();

		// 엔터 입력 시 까지 무한 대기
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		// 스톱워치 스레드 멈추게 하기
		stopWatch.interrupt();	// stopWatch는 중간중간 sleep 하기 때문에 에러가 난다.
								// -> stopWatch의 catch 구문 실행

	}

}
