package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletEx3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest : 클라이언트 정보 + 요청 시 전달 값 (input)
		// HttpServletResponse : 서버가 클라이언트에게 응답할 때 필요한 도구, 방법을 가지고 있는 객체
		
		String inputId = req.getParameter("inputId");
		String inputPw1 = req.getParameter("inputPw1");
		String inputPw2 = req.getParameter("inputPw2");
		String inputName = req.getParameter("inputName");
		String inputEmail = req.getParameter("inputEmail");
		
		String[] colorArr = req.getParameterValues("color");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>example3</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<ul>");
		if(inputPw1.equals(inputPw2)) {
			out.println("<li color='green'> 아이디 : " + inputId + "</li>" );
			out.println("<li> 닉네임 : " + inputName + "</li>" );
			out.println("<li> 이메일 : " + inputEmail + "</li>" );
			out.println("<li> 좋아하는 색 : ");
			if(colorArr != null) {
				for(String color : colorArr) {
					out.println(color+" ");
				}
			} else {
				out.println("없습니다.");
			}
			out.println("</li>");
			out.println("</ul>");
			out.println("<h4>환영합니다!</h4>");
				
		} else {
			out.println("<h1>비밀번호가 일치하지 않습니다.</h1>");
		}
		out.println("</body>");
		
		
	}

}
