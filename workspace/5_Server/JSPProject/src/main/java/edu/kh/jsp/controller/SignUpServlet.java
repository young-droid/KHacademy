package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet : 웹 서비스(요청, 응답)를 위한 자바 클래스

// @WebServlet("요청주소")

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String msg = "님의 가입을 환영합니다!";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUp_result.jsp");
		
		req.setAttribute("msg", msg);
		
		dispatcher.forward(req, resp);
	}
	
}
