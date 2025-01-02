<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>17_시맨틱 태그</title>
    <link rel="stylesheet" href="resources/css/main-style.css">
    <script src="https://kit.fontawesome.com/e7c9f5e233.js" crossorigin="anonymous"></script>
</head>

<body>
    <main>
        <header>
            <!-- 클릭 시 메인 페이지로 이동하는 로고 -->
            <section>
                <a href="#">
                    <img src="resources/images/kh-logo.jpg" id="main-logo">
                </a>
            </section>

            <!-- 검색창 -->
            <section>
                <section class="search-area">
                    <!-- form 내부 input 태그 값을 서버 또는 페이지로 전달 -->
                    <form action="#" name="search-form">
                        <!-- fieldset: form태그 내부에서 input을 종류별로 묶는 용도로 많이 사용 -->
                        <fieldset>
                            <!-- form태그 내부 input은 name 속성이 존재해야 값 전달 가능함 -->
                            <input type="text" name="query" id="query" autocomplete="off" placeholder="검색어를 입력해주세요">
                            <button id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>
                    </form>
                </section>
            </section>

            <section></section>
        </header>
        <nav>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">자유 게시판</a></li>
                <li><a href="#">질문 게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li>
            </ul>
        </nav>

        <section class="content">

            <section class="content-1">
            
            	loginMember : ${sessionScope.loginMember}
            
            	<hr>
            	
            	message : ${sessionScope.message}
            
            </section>
            
            
            <section class="content-2">
				<c:choose>
					<c:when test="${empty sessionScope.loginMember }">
		            <!-- 현재 위치 : /community/index.jsp -->
		            <!-- 목표 위치 : /community/member/login -->
		                <form action="member/login" name="login-form" method="post">
		                    <!-- 아이디/비밀번호/로그인 버튼 영역 -->
		                    <fieldset id="id-pw-area">
		                        <section>
		                            <input type="text" placeholder="아이디" name="inputEmail">
		                            <input type="password" placeholder="비밀번호" name="inputPw">
		                        </section>
		                        <section>
		                            <button>로그인</button>
		                        </section>
		                    </fieldset>
		
		                    <!-- 회원가입 / ID/PW 찾기 영역 -->
		                    <article id="signup-find-area">
		                        <a href="#">회원가입</a>
		                        <span>|</span>
		                        <a href="#">ID/PW 찾기</a>
		                    </article>
		                    <label>
		                    	<input type="checkbox">아이디 저장
		                    </label>
		                </form>					
					</c:when>
					<c:otherwise>
                        <article class="login-area">
                            <!-- 회원 프로필 이미지 -->
                            <a href="#">
                                <img src="resources/images/user.png" id="member-profile">
                            </a>

                            <!-- 회원 정보 + 로그아웃 버튼 -->
                            <div class="my-info">
                                <div>
                                    <a href="#" id="nickname">${loginMember.memberNickname}</a>
                                    <a href="/community/member/logout" id="logout-btn">로그아웃</a>
                                </div>
                                <p>
                                    ${loginMember.memberEmail}
                                </p>

                            </div>

                        </article>
					</c:otherwise>
				</c:choose>
        	

            </section>
        </section>
    </main>

    <footer>
        <p>Copyright &copy; KH Information Educational Institute G-Class</p>
        <article>
            <a href="#">프로젝트 소개</a>
            <span>|</span>
            <a href="#">이용약관</a>
            <span>|</span>
            <a href="#">개인정보처리방침</a>
            <span>|</span>
            <a href="#">고객센터</a>
        </article>
    </footer>
</body>

</html>