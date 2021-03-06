<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="naver_login_clone.css">
</head>

<body>
    <!-- 배경 -->
    <div id="bg_color">
        <!-- 전체를 감싸는 블록 -->
        <div id="main_wrap">
            <!-- 네이버 로고 -->
            <a href="#">
                <div id="logo"></div>
            </a>
            <!-- 아이디 비밀번호 로그인 -->
            <form action="login_result.jsp" method="post">
	            <input class="login" type="text" placeholder="아이디" name="userid">
	            <input class="login" type="password" placeholder="비밀번호" name="userpw">
	            <input class="btn" type="submit" value="로그인" >
            </form>
            <!-- 로그인 상태 유지 / ip보안on -->
            <div id="login_stat">
                <input id="chk" type="checkbox">
                <label for="chk">로그인 상태 유지</label>
            </div>
            <!-- 더욱 간편한 로그인 -->
            <div id="simple_login">
                <h1>더욱 간편한 로그인</h1>
                <input class="sub_login" type="submit" value="QR코드 로그인">
                <input class="sub_login" type="submit" value="일회용 번호 로그인">
                <div id="finder">
                    <a href="#">아이디 찾기</a>
                    ㅣ
                    <a href="#">비밀번호 찾기</a>
                    ㅣ
                    <a href="#">회원가입</a>
                </div>
            </div>
            <!-- 하단 배너 -->
            <div id="banner"></div>
            <!-- 푸터 영역 -->
            <footer>
                <a href="#">이용약관</a>
                ㅣ
                <a href="#">개인정보처리방침</a>
                ㅣ
                <a href="#">책임의 한계와 법적고지</a>
                ㅣ
                <a href="#">회원정보 고객센터</a>
                <div id="copyright">NAVER Copyright © NAVER Corp. All Rights Reserved.</div>
            </footer>

        </div>
    </div>
</body>
</html>