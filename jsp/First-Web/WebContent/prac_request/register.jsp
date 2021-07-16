<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="naver_register_clone.css">
</head>
<body>
    <!-- 백그라운드 컬러 -->
    <div id="bg_color">
        <!-- 메인을 감싸는 블럭 -->
        <div id="main_wrap">
            <!-- 로고 -->
            <a href="#">
                <div id="logo"></div>
            </a>
            <form action="register_result.jsp" method="post">
	            <!-- 아이디 -->
	            <label for="id">아이디</label>
	            <input id="id" type="text" name="userid">
	            <div id="com">@naver.com</div>
	            <!-- 비밀번호 -->
	            <label id="clear" for="pw">비밀번호</label>
	            <input id="pw" class="full_length" type="password" name="userpw">
	            <!-- 비밀번호 재확인 -->
	            <label for="pw_chk">비밀번호 재확인</label>
	            <input id="pw_chk" class="full_length" type="password">
	            <!-- 이름 -->
	            <label for="name">이름</label>
	            <input id="name" class="full_length" type="text" name="username">
	            <!-- 생년월일 -->
	            <label for="year">생년월일</label>
	            <input id="year" class="short_length" type="text" placeholder="년(4자)" name="birthyear">
	            <select id="month" class="short_length" name="birthmonth">
	                <option value="13" selected>월</option>
	                <option value="1">1</option>
	                <option value="2">2</option>
	            </select>
	            <input id="day" class="short_length" type="text" placeholder="일" name="birthday">
	            <!-- 성별 -->
	            <label for="gender">성별</label>
	            <select id="gender" class="full_length" name="gender">
	                <option value="4" selected>성별</option>
	                <option value="1">남자</option>
	                <option value="2">여자</option>
	                <option value="3">선택안함</option>
	            </select>
	            <!-- 본인확인 이메일 -->
	            <label for="email">본인 확인 이메일</label>
	            <input id="email" class="full_length" type="text" placeholder="선택입력" name="email">
	            <!-- 휴대전화 -->
	            <label for="cell_phone">휴대전화</label>
	            <select id="cell_phone" class="full_length" name="countrynum">
	                <option value="4" selected>대한민국 +81</option>
	                <option value="대한민국 +82">대한민국 +82</option>
	                <option value="대한민국 +83">대한민국 +83</option>
	            </select>
	            <!-- 전화번호 입력, 인증번호 -->
	            <input type="text" id="tel_text" placeholder="전화번호 입력" name="telnum">
	            <input type="submit" id="tel_btn" value="인증번호 받기">
	            <input id="phone" class="full_length" type="text" value="인증번호 입력하세요" disabled>
	            <input id="submit" class="full_length" type="submit" value="가입하기">
	            </form>
            <!-- 푸터 영역 -->
            <footer>
                <a href="#">이용약관</a>
                ㅣ
                <a href="#">개인정보처리방침</a>
                ㅣ
                <a href="#">책임의 한계와 법적고지</a>
                ㅣ
                <a href="#">회원정보 고객센터</a>
                <div id="copyright">NAVER Corp.</div>
            </footer>           
        </div>
    </div>
</body>
</html>