package edu.kh.poly.ex2.model.service;

// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드, 기능명을 제공하는 접점(interface) 용도
public interface Calculator {
	
	// 인터페이스 : 추상 클래스의 변형체 (추상 클래스 보다 추상도 높음) 
	// - 추상 클래스 : 일부만 추상 메소드(추상 메소드 0개 이상)
	// - 인터페이스 : 모두 추상 메소드 
	
	// 필드 (묵시적으로 public static final)
	// -> 어떻게 작성하든 모두 public static final
	public static final double PI = 3.14;
	static final int MAX_NUM = 2_147_000_000; // 최대값
	public int MIN_NUM = -2_147_000_000; // 최소값;
	int ZERO = 0;
	
	// 메소드 (묵시적으로 public abstract)
	public abstract int plus(int num1, int num2);
	
	abstract int minus(int num1, int num2);
	
	int multiple(int num1, int num2);
	
	public int divide(int num1, int num2);
	
	
}

