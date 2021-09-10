<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Come on, Board</title>
    <%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function(){
            
            $('ul.tabs li').click(function(){
                $('.tab_link').removeClass('current');

                var tab_id = $(this).attr('data-tab');
                $(this).addClass('current');
                $('.form_find').removeClass('on');
                $('#'+tab_id).addClass('on');
				return false;
            });
        });
            
    </script>

<style>
    * {
        padding: 0;
        margin: 0;
    }
    fieldset {
        border: none;
    }
    legend {
        visibility: hidden;
    }
    .wrap {
        background-color :rgb(245, 246, 247);
    }
    .area_logo {
        display: block;
        width: 768px;
        margin: 0 auto;
        height: 44px;
        padding: 180px 0 60px;
    }

    .area_logo img {
        display: block;
        height: 60px;
        margin: 0 auto;
    }

    #container {
        display: block;
        width: 768px;
        margin: 0 auto;
        min-height: 700px;
        padding-bottom: 50px;
    }
    .form_find_id_by_phoneNum,
    .form_find_id_by_email {
        width: 462px;
        margin: 0 auto;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #777;
    }

    .input_area {
        margin: 0 auto;
        width: 460px;
        height: 70px;
        margin-bottom: 10px;
    }

    .input_row {
        border: 1px solid #bbb;
        padding: 7px 35px 10px 11px;
        margin-bottom: 10px;
        width: 412px;
        height: 29px;
        background-color: #fff;
        font-size: 16px;
    }

    .input_row:focus,
    .input_num:focus,
    .input_phoneNum:focus {
        outline: rgb(52, 168, 83) 1px solid;
    }

    .find_id_btn{
        display: block;
        margin: 0 auto;
        color: white;
        background-color: rgb(52, 168, 83);
        width: 460px;
        height: 48px;
        font-size: 16px;
        border: none;
        margin-bottom: 10px;
        border-radius: 10px;
    }

    #login_chk {
        width: 15px;

    }
    #login_chk:hover, label:hover {
        cursor: pointer;
    }

    .nav_login {
        margin:0 auto;
        width: 460px;
    }

    .nav_login>ul{
        width: 393px;
        margin: 10px auto;
        list-style: none;
        overflow: hidden;
    }

    .nav_login>ul>li {
        text-align: center;
        width: 130px;
        float: left;
        border-right: 1px solid black;
        color: #777;
    }

    #last_li {
        border: none;
    }

    .input_num {
        border: 1px solid #bbb;
        padding: 7px 1px 10px 11px;
        margin-right: 5px;
        margin-bottom: 10px;
        width: 134px;
        height: 29px;
        background-color: #fff;
        font-size: 16px;
    }

    select {
        width: 460px;
        height: 48px;
        background-color: #fff;
        font-size: 16px;
        padding-left: 8px;
        color: #777;
        border: 1px solid #bbb;
    }

    .input_phoneNum,
    .input_address {
        border: 1px solid #bbb;
        padding: 7px 35px 10px 11px;
        margin-bottom: 5px;
        width: 270px;
        height: 29px;
        background-color: #fff;
        font-size: 16px;
    }

    .input_phoneNum+button,
    .input_address+button {
        float: right;
        display: block;
        height: 48px;
        width: 135px;
        color: white;
        border: none;
        border-radius: 5px;
        background-color: rgb(66, 133, 244);
        font-size: 14px;
    }
    #phoneNum_input {
        height: 120px;
    }

    #input_profile {
        display: none;
    }

    #profile_button {
        display: block;
        margin: 0 auto;
        background-color: rgb(251,188,5);
        width: 460px;
        height: 48px;
        font-size: 16px;
        border: none;
        margin-bottom: 10px;
        border-radius: 10px;
        text-align: center;
        line-height: 48px
       };

    #profile_button:hover {
        cursor: pointer;
    }

    #address_area {
        height: 200px;
    }

    .display_none {
        display: none;
    }

    .color_red {
        color: red;
    }

    .form_find{
        display: none;
    }

    .on {
        display: block;
    }
        
    ul.tabs {
        margin: 0 auto;
        list-style: none;
        line-height: 40px;
        height: 40px;
        width: 470px;
    }
    li.current {
        border-radius: 10px;
        background-color: rgb(52, 168, 83);
        color: white;
    }

    ul.tabs li{
        text-align: center;
        display: inline-block;
        width: 49%;
        height: 40px;
    }


</style>
<body>
    <div class="wrap">
        <div class="area_logo">
	        <a href="<c:url value='/'/>">
	        	<img src="/cob/images/logo_full.png">
	        </a>
   		</div>
        <div id="container">

            <h2> - 아이디 찾기 - </h2>

            <ul class="tabs">
                <li class="tab_link current" data-tab="tab1">휴대전화 인증으로 찾기</li>
                <li class="tab_link" data-tab="tab2">이메일 인증으로 찾기</li>
            </ul>
            <div id="tab1" class="form_find on">
                <form id="form_find_id_by_phoneNum" action="read_findId.html">
    
                        <div class="input_area">
                            <p>이름</p>
                            <input type="text" class="input_row" placeholder="이름">
                        </div>
        
                        <div id="phoneNum_input" class="input_area">
                            <p>휴대전화</p>
                            <input type="text" class="input_phoneNum" placeholder="전화번호 입력">
                            <button>인증번호 받기</button>
                            <input type="text" class="input_row" placeholder="인증번호 6자리 입력">
                        </div>
                        
                        <button class="find_id_btn">아이디 찾기</button>
                </form>
            </div>

            <div id="tab2" class="form_find">
                <form id="form_find_id_by_email" action="read_findId.html">
                          <div class="input_area">
                            <p>이름</p>
                            <input type="text" class="input_row" placeholder="이름">
                        </div>
        
                        <div id="phoneNum_input" class="input_area">
                            <p>이메일 주소</p>
                            <input type="text" class="input_phoneNum" placeholder="메일 주소 입력">
                            <button>인증번호 받기</button>
                            <input type="text" class="input_row" placeholder="인증번호 6자리 입력">
                        </div>
                        
                        <button class="find_id_btn">아이디 찾기</button>
                </form>
            </div>

        </div>
    </div>
</body>
</html>