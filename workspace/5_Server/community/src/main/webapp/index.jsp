<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>KH 커뮤니티</title>
            <link rel="stylesheet" href="resources/css/main-style.css">
            <script src="https://kit.fontawesome.com/e7c9f5e233.js" crossorigin="anonymous"></script>
        </head>

        <body>
            <main>

                <!-- header -->

                <!-- 내부 접근 절대 경로 -->
                <jsp:include page="/WEB-INF/views/common/header.jsp" />

                <!-- jsp:include 태그
                     -> 다른 jsp 파일의 내용을 해당 위치에 포함시킴
                     
                     * 경로 작성 시 
                       외부 요청 주소 X (인터넷 주소, 최상위 : /community)
                       내부 접근 경로 O (파일 위치 경로, 최상위 : /webapp)
                -->

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
                                            <input type="text" placeholder="아이디" name="inputEmail"
                                                value="${ cookie.saveId.value }">
                                            <input type="password" placeholder="비밀번호" name="inputPw">
                                        </section>
                                        <section>
                                            <button>로그인</button>
                                        </section>
                                    </fieldset>

                                    <!-- 회원가입 / ID/PW 찾기 영역 -->
                                    <article id="signup-find-area">
                                        <!-- <a href="/community/WEB-INF/views/member/signUp.jsp">회원가입</a> -->
                                        <!-- WEB-INF 폴더는 외부로부터 직접적으로 요청할 수 없는 폴더
                                        		 왜? 중요한 코드(자바, sql, 설정관련)가 위치하는 폴더이기 때문에
                                        		 외부로 부터 접근을 차단함
                                        		 
                                        		 -> 대신 Servlet을 이용해 내부 접근(forward)은 가능
                                        	 -->

                                        <a href="/community/member/signUp">회원가입</a>
                                        <span>|</span>
                                        <a href="#">ID/PW 찾기</a>
                                    </article>

                                    <!-- 쿠키에 saveId가 있는 경우 -->
                                    <c:if test="${!empty cookie.saveId.value}">
                                        <!-- chk 변수 생성 (page scope)(변수 생성 시 기본으로 page scope) -->
                                        <c:set var="chk" value="checked" />
                                    </c:if>

                                    <label>
                                        <input type="checkbox" name="saveId" ${chk}>아이디 저장
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

            <!-- footer -->
            <jsp:include page="/WEB-INF/views/common/footer.jsp" />




        </body>

        </html>