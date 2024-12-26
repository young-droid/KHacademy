package edu.kh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스로 만들기
// /ServletProject/exmaple2.do 로 요청 시
//  ServletEx2가 처리 가능하게 설정하기 -> web.xml



public class ServletEx2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderer = req.getParameter("orderer");
		System.out.println("주문자 : " + orderer);
		
		String[] coffee = req.getParameterValues("coffee");
		
		for(int i=0; i<coffee.length ; i++) {
			System.out.println("주문한 음료: " + coffee[i]);
			System.out.println("주문한 음료: " + coffee[0]);
		}
	}

}
