package edu.kh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// Servlet 클래스를 만들기 위해서는
// javax.servlet.http.HttpServlet 추상 클래스를
// 반드시 상속 받아야 함!
// -> doGet() / doPost()를 필요한 형태로 오버라이딩 진행

public class ServletEx1 extends HttpServlet {
   // /ServletProject/example1.do 주소로 요청이 왔을 때
   // 해당 클래스가 응답할 수 있도록 연결하는 작업이 필요함

   // -> web.xml 파일에서 연결 작업 수행

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // HttpServletRequest : 클라이언트 + 요청 정보가 담긴 객체
      // HttpServletResponse : 서버가 클라이언트한테 응답하는 방법을 제공하는 객체

      // 요청 시 전달된 input 태그의 값(== Parameter)을 얻어오는 방법
      // req.getParameter("input 태그의 name 속성");

      String inputName = req.getParameter("inputName");
      String inputAge = req.getParameter("inputAge");

      System.out.println(inputName);
      System.out.println(inputAge);

   }

}
