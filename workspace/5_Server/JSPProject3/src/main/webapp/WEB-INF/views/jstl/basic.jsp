<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSTL에서 사용하려는 태그 추가하기 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
	<%@ %> : 지시자 태그(페이지 정의)

	taglib : 태그 라이브러리 추가
	
	prefix 속성 : 태그 앞에 붙을 접두사를 지정
	
	uri(Uniform Resource Identifier, 통합 자원 식별자)
	: 자원을 식별하는 고유 문자열 (ID)
	
	(참고)
	URL(Uniform Resource Locator, 통합 자원 경로)
	: 자원의 위치를 나타내는 문자열 (주소, 경로)
 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 기초</title>
</head>
<body>
	<h1>1. 변수 선언(== 속성 추가) (c:set 태그)</h1>
	
	<pre>
		- 변수 선언(속성 추가 == setAttribute)을 위한 태그
		
		- 작성 가능한 속성: 
		1) var : 변수명 (== 속성 key)
		
		2) value : 대입할 값 (== 속성 value)
		
		3) scope : 범위 지정(page, request, session, application)
				  (기본값 : page)
	</pre>
	
	<% // 스크립틀릿으로 page scope 속성 추가하기 
		pageContext.setAttribute("num1", 5);
	%>

	<%-- JSTL로 page scope 속성 추가하기 --%>
	<c:set var="num2" value="10" scope="page"/>
	<!-- <태그명/> : 태그가 시작 되자마자 종료 == 내용이 없는 요소 -->
	
	<h3>${ num1 }</h3>	
	<h3>${ num2 }</h3>	
	
	<hr>
	<h3>request scope에 세팅</h3>
	<c:set var="num2" value="20" scope="request"/>
	<h3>${ num2 }</h3>
	<h3>request Scope num2 : ${ requestScope.num2 }</h3>
	
	<hr>
	
	<h3>session, application scope에 세팅</h3>
	<c:set var="num2" value="2000" scope="session"/>
	<c:set var="num2" value="12345" scope="application"/>

	<h3>session Scope num2 : ${ sessionScope.num2 }</h3>
	<h3>application Scope num2 : ${ applicationScope.num2 }</h3>

	<h3>scope 미지정 시 좁은 범위부터 탐색(우선순위) : ${ num2 }</h3>

	<hr>
	
	<h1>2. 변수 제거(== 속성 제거) (c:remove 태그)</h1>
	
	<pre>
		- 변수 제거 (== 속성 제거(removeAttribute("key")))
		
		- 속성
		1) var : 제거할 변수명 (== 속성 key)
		
		2) scope : 지정된 scope의 변수만 제거
				  (기본값은 모든 scope 일괄 제거)
	</pre>
	
	<c:set var="test1" value="테스트1"/> 
	<%-- scope 미지정 == page scope --%>
	
	<h4>제거 전 test1 : ${pageScope.test1}</h4>
	
	<!-- test1 제거 -->
	<c:remove var="test1" scope="page"/>
	<h4>제거 후 test1 : ${pageScope.test1}</h4>

	<hr>
	
	<h3>scope 지정해서 제거하기</h3>
	
	<c:set var="test2" value="page" scope="page"/>
	<c:set var="test2" value="request" scope="request"/>
	<c:set var="test2" value="session" scope="session"/>
	<c:set var="test2" value="application" scope="application"/>

	<!-- 특정 scope만 제거 -->
	<p>특정 scope만 제거</p>
	<c:remove var="test2" scope="session"/>

	<ul>
		<li>${ pageScope.test2 }</li>
		<li>${ requestScope.test2 }</li>
		<li>${ sessionScope.test2 }</li>
		<li>${ applicationScope.test2 }</li>
	</ul>

	<!-- 모든 scope 제거 -->
	<p>모든 scope 제거</p>
	<c:remove var="test2"/>

	<ul>
		<li>${ pageScope.test2 }</li>
		<li>${ requestScope.test2 }</li>
		<li>${ sessionScope.test2 }</li>
		<li>${ applicationScope.test2 }</li>
	</ul>
	
	<hr>
	
	<h1>3. 변수 출력 (c:out 태그)</h1>

	<pre>
	    - EL 구문과 유사
	
	    - 단, escapeXml 속성 값에 따라
	      html 태그 해석 여부가 결정됨
	
	      true  : 해석 X  (기본값)
	      false : 해석 O
	</pre>
	
	<c:set var="temp" value="<h1>c:out 테스트 중 입니다.</h1>"/>
	
	HTML 태그 해석 X : <c:out value="${temp}"/>
	
	<br>
	
	HTML 태그 해석 O : <c:out value="${temp}" escapeXml="false"/>
	
	<br>
	EL : EL로 출력 시 escapeXml="false" 상태 적용 (HTML 해석함)
	${ temp }

</body>
</html>