package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;

public class Child extends Parent {

	@Override
//	public void method() throws IOException {
	public void method() throws FileNotFoundException {

		System.out.println("오버라이딩된 자식 메소드");

		// 오버라이딩 시
		// 예외는 같거나 더 좁은 범위
		// * 좁은 범위 == 구체적인 예외

		// FileNotFoundException 은
		// IOException의 자식 예외이므로 오버라이딩 가능!

		// Exception(모든 예외의 부모)은
		// IOException의 부모 예외이므로 오버라이딩 불가
	}

}
