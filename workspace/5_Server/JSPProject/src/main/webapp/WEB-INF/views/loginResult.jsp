<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 자바 코드 작성 영역

   // 여기는 JSP -> Servlet으로 부터 전송받은 req, resp가 있는 상태
   // -> req, resp 사용 가능함! 
   //    대신 이름이 request, response로 바뀜 
   
   String r = (String)request.getAttribute("res");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 화면</title>
</head>
<body>

	<h1><%= r %></h1>

	<h1>LoginServlet의 result 변수 결과값</h1>


</body>
</html>