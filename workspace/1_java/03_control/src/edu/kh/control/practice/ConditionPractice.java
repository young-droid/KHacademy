package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();

		String result;

		// else if문
//		if(num > 0 && num % 2 == 0) {
//			result = "짝수입니다.";
//		} else if(num > 0 && num % 2 != 0) {
//			result = "홀수입니다.";
//		} else {
//			result = "양수만 입력해주세요.";			

		// 중첩 if문
		if (num > 0) { // 양수인것
			if (num % 2 == 0) { // 양수인데 짝수인것
				result = "짝수입니다.";
			} else { // 양수인데 짝수가 아닌것(홀수)
				result = "홀수입니다.";
			}
		} else { // 양수 아닌것
			result = "양수만 입력해주세요.";

		}
		System.out.println(result);
	} // practice1 끝

	public void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();

		int sum = kor + math + eng;
		double avg = sum / 3.0;

		if (kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
//				System.out.println("평균 : " + avg);
			System.out.printf("평균 : %.1f\n", avg);

			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}

	} // practice2 끝

	public void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();

		int days = 0;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 2:
			days = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		}

		if (days != 0) {
			System.out.printf("%d월은 %d일까지 있습니다.", month, days);
		} else {
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}

//		String result;
//
//		switch(month) {
//		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : 
//			result = month + "월은 31일까지 있습니다."; break;
//		case 4 : case 6 : case 9 : case 11 : 
//			result = month + "월은 30일까지 있습니다."; break;
//		case 2 : 
//			result = month + "월은 28일까지 있습니다."; break;
//		default : 
//			result = month + "월은 잘못 입력된 달입니다.";
//		}
//
//		System.out.println(result);

	} // practice3 끝

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		System.out.println("BMI 지수 : " + bmi);

		String result;

		if (bmi < 18.5) { // 18.5 미만
			result = "저체중";
		} else if (bmi < 23) { // 23 미만
			result = "정상체중";
		} else if (bmi < 25) { // 25 미만
			result = "과체중";
		} else if (bmi < 30) { // 30 미만
			result = "비만";
		} else {
			result = "고도비만";
		}

		System.out.println(result + "입니다.");

	} // practice5 끝

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("중간 고사 점수 : ");
		double midTerm = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		double finalTerm = sc.nextInt();
		System.out.print("과제 점수 : ");
		double homework = sc.nextInt();
		System.out.print("출석 횟수 : ");
		double attendance = sc.nextInt();

		// 강의 횟수
		double days = 20;

		// 점수 환산
		double midScore = midTerm * 0.2;
		double finalScore = finalTerm * 0.3;
		double homeworkScore = homework * 0.3;
		double attendanceScore = (attendance / days * 100) * 0.2;

		System.out.println(attendanceScore);

		double scoreTotal = midScore + finalScore + homeworkScore + attendanceScore;

		System.out.println("================= 결과 =================");

		if (attendance <= days * (1 - 0.3)) { // 강의에 30% 이상 결석 시
			System.out.printf("FAIL [출석 횟수 부족 (%.0f/20)]", attendance);

		} else if (scoreTotal >= 70) { // 총점 70 이상

			System.out.printf("중간 고사 점수	(20) : %.1f\n", midScore);
			System.out.printf("기말 고사 점수	(30) : %.1f\n", finalScore);
			System.out.printf("과제 점수		(30) : %.1f\n", homeworkScore);
			System.out.printf("출석 점수		(20) : %.1f\n", attendanceScore);
			System.out.printf("총점 : %.1f\n", scoreTotal);
			System.out.println("PASS");
		} else { // 총점 70 미만

			System.out.printf("중간 고사 점수	(20) : %.1f\n", midScore);
			System.out.printf("기말 고사 점수	(30) : %.1f\n", finalScore);
			System.out.printf("과제 점수		(30) : %.1f\n", homeworkScore);
			System.out.printf("출석 점수		(20) : %.1f\n", attendanceScore);
			System.out.printf("총점 : %.1f\n", scoreTotal);
			System.out.println("FAIL [점수 미달]");
		}

	}
}
