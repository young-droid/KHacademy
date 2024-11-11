package edu.kh.exception.model.vo;

import java.io.IOException;

public class Parent {

	public void method() throws IOException {
		// 메소드를 호출한 곳으로 IOException 던짐
		// == 해당 메소드는 IOException을 발생시킬 가능성이 있으므로
		// 	  호출하는 곳에서 예외 처리를 해야한다.
		
		System.out.println("부모 메소드");
		
	}
	
}
