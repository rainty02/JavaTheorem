<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>  <!-- 문서의 첫행 표시, 웹 브라우저에 HTML5 임을 알림 -->
<html lang="ko"> <!-- 시작, lang 속성 입력(생략가능)-->
<head> <!-- 페이지의 필요한 추가 속성 작성 -->
    <meta charset="UTF-8"> <!-- 출력 포맷 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 페이지 속성 -->
    <title>Cafe list</title> <!-- 문서 제목 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- 카드 선택시 하단 줄 CSS -->
	<link href="<c:url value="/css/hover.css"/>" rel="stylesheet" media="all">

    <style>
         * {
        margin: 0;
        padding: 0;
        }
        header {
            position: relative;
            z-index: 20;
            min-width: 980px;
            width: 100%;
            height: 140px;
            background-color: rgb(66, 133, 244);
            text-align: center;
        }
        ul {
        list-style: none;
        }
        header {
            position: relative;
            z-index: 20;
            min-width: 980px;
            width: 100%;
            height: 140px;
            background-color: rgb(66, 133, 244);
            text-align: center;
        }
        .MultiBar {
            display: inline-block;
            height: 30px;
            width: 100%;
            max-width: 1280px;
            padding: 12px 0px 5px;
        } 
        .area_gnb {
            font-size: 12px;
            width: 500px;
            height: 30px;
            float: right;
            color: white;
        }
        .area_gnb>li {
            float: right;
            width: 75px;
        }
        .container {
            display: inline-block;
            height: 93px;
            width: 100%;
            max-width: 1280px;
            position: relative;
        }
        .logo {
            position: absolute;
            left: 50%;
            width: 180px;
            margin-left: -90px;
        }
        .main_naviwrap {
            display: block;
            margin: 0 auto;
            width: 100%;
            max-width: 1280px;
            height: 80px;
            margin-top: -98px;
            padding-bottom: 10px;
        }
        .main_nav {
            padding-top: 45px;
        }
        .main_nav>.left_ul {
            float: left;
            overflow: hidden;
        }
        .main_nav>.right_ul {
            float: right;
            overflow: hidden;
        }

        .main_nav>ul>li {
            color: white;
            width: 85px;
            float: left;
        }







        .navbar{
            margin: 20px auto;
            max-width: 1280px;
            min-width: 980px;
            border-radius: 5px;
        }
        .nav-button{
            margin: 0;
            list-style: none;
        }
        .nav-button>li{
            float: left;
            margin-right: 15px;
        }
        .form-inline>select{
            margin-right: 8px;
        }

        .card-deck{
            margin: 0 auto;
            padding-bottom: 20px;
            max-width: 1280px;
            min-width: 980px;
            max-height: 800px;
            overflow: hidden;
            overflow-y: scroll;      
        }
        .card{
            min-width: 300px;
            margin: 30px;
            box-shadow: 5px 5px 5px rgb(214, 214, 214);
        }
        .card:hover{
            cursor: pointer;
        }
        .card-title{
          font-weight: bold;
        }

        @-webkit-keyframes fade-in {
          0% {
            opacity: 0;
          }
          100% {
            opacity: 1;
          }
        }
        @keyframes fade-in {
          0% {
            opacity: 0;
          }
          100% {
            opacity: 1;
          }
        }
        
        .fade-in {
        -webkit-animation: fade-in 1.2s cubic-bezier(0.390, 0.575, 0.565, 1.000) both;
                animation: fade-in 1.2s cubic-bezier(0.390, 0.575, 0.565, 1.000) both;
        }

        

    </style>

<script>

/*    $(document).ready(function(){

    // 카페 리스트 출력
    cafe_list();

    $('#btn_cafe_location_search').click(function(){
      // sort 버튼 - 지역순으로 출력하기 위한 값 필수 전달
      cafe_list(this);
    })

    $('#btn_cafe_star_search').click(function(){
      // sort 버튼 - 평점순으로 출력하기 위한 값 필수 전달
      cafe_list(this);
    })

    $('#btn_cafe_review_search').click(function(){
      // sort 버튼 - 리뷰 갯수순으로 출력하기 위한 값 필수 전달
      cafe_list(this);
    })

  });

  // 카페 리스트 출력을 위한 동적 html 생성
  function cafe_list($name){

      // id를 매개변수로 받아 지역, 평점 기준으로 리스트 출력

      // DB에서 받아야할 데이터 - 카페 웹주소, 카페이미지, 카페명, 카페정보1, 카페정보2, 카페 위치
      var cafe_web = 'cafe_info_member.html';
      var cafe_img = 'image/cafe1.jpg';
      var cafe_name = '스타벅스';
      var cafe_info1 = '1시간 : 5,000';
      var cafe_info2 = '추가 10분당 1,000원';
      var cafe_addr = '신촌역 3번출구 도보 5분거리(600m)';

      // 중복생성 방지를 위해 자손 삭제 - 페이징처리시 사용가능
      // **스크롤에 따라 리스트가 추가적으로 생성된다면 다른 방법 필요
      $('.card-deck *').remove();

      // 리스트 html 동적 생성 
      for(var i=0; i<9; i++){
        var html = '<div class="card hvr-underline-from-center fade-in" onclick="location.href=\''+cafe_web+'\';">'+'\n'+
                  '<img class="card-img-top" src="'+cafe_img+'" alt="Card image cap">'+'\n'+
                  '<div class="card-body">'+'\n'+
                  '<h5 class="card-title">'+cafe_name+'</h5>'+'\n'+
                  '<p class="card-text" style="text-align: right;">'+'\n'+
                  cafe_info1+'\n'+
                  '<br>'+'\n'+
                  cafe_info2+'\n'+
                  '</p>'+'\n'+'</div>'+'\n'+'<div class="card-footer" style="text-align: center;">'+'\n'+
                  '<small class="text-primary">'+cafe_addr+'</small>'+'\n'+
                  '</div>'+'\n'+'</div>';
                  $('.card-deck').append(html);
      }
    } */
    
    $(document).ready(function(){
    	
    	
	    $('#btn_cafe_cafeidx_search').click(function(){
			$.ajax({
				url : '<c:url value="/cafe/cafe_list"/>',
				type : 'post',
				data : {
					searchType : $(this).val()
				},
				success : function(data){
					
					
					
					
				// DB에서 받아야할 데이터 - 카페 웹주소, 카페이미지, 카페명, 카페정보1, 카페정보2, 카페 위치
			      var cafe_web = 'cafe_info_member.html';
			      var cafe_img = 'image/cafe1.jpg';
			      var cafe_name = '스타벅스';
			      var cafe_info1 = '1시간 : 5,000';
			      var cafe_info2 = '추가 10분당 1,000원';
			      var cafe_addr = '신촌역 3번출구 도보 5분거리(600m)';

			      // 중복생성 방지를 위해 자손 삭제 - 페이징처리시 사용가능
			      // **스크롤에 따라 리스트가 추가적으로 생성된다면 다른 방법 필요
			      $('.card-deck *').remove();
				      // 리스트 html 동적 생성 
			      for(var i=0; i<9; i++){
			        var html = '<div class="card hvr-underline-from-center fade-in" onclick="location.href=\''+cafe_web+'\';">'+'\n'+
			                  '<img class="card-img-top" src="'+cafe_img+'" alt="Card image cap">'+'\n'+
			                  '<div class="card-body">'+'\n'+
			                  '<h5 class="card-title">'+cafe_name+'</h5>'+'\n'+
			                  '<p class="card-text" style="text-align: right;">'+'\n'+
			                  cafe_info1+'\n'+
			                  '<br>'+'\n'+
			                  cafe_info2+'\n'+
			                  '</p>'+'\n'+'</div>'+'\n'+'<div class="card-footer" style="text-align: center;">'+'\n'+
			                  '<small class="text-primary">'+cafe_addr+'</small>'+'\n'+
			                  '</div>'+'\n'+'</div>';
			                  $('.card-deck').append(html);
				      }	
					
					
				},
				error : function(data){
					alert('실패');
				},
				complete : function(){	
					alert('끝');
				}
			});
	    });
    	
    	
	    $('#btn_cafe_rating_search').click(function(){
			$.ajax({
				url : '<c:url value="/cafe/cafe_list"/>',
				type : 'post',
				data : {
					searchType : $(this).val()
				},
				success : function(data){
					alert('rating 성공');
				},
				error : function(data){
					alert('실패');
				},
				complete : function(){	
					alert('끝');
				}
			});
	    });
    	
    	
	    $('#btn_cafe_address_search').click(function(){
			$.ajax({
				url : '<c:url value="/cafe/cafe_list"/>',
				type : 'post',
				data : {
					searchType : $(this).val()
				},
				success : function(data){
					alert('address 성공');
				},
				error : function(data){
					alert('실패');
				},
				complete : function(){	
					alert('끝');
				}
			});
	    });
    });
</script>



</head>

<body>

    <header>
        <div class="MultiBar">
            <ul class="area_gnb">
                <li>시작페이지로</li>
                <li>다크모드</li>
                <li>마이페이지</li>
                <li>로그인</li>
            </ul>
        </div>

        <div class="container">
            <img src="<c:url value="/images/cob_white.png"/>" class="logo">
            
        </div>
        <div class="main_naviwrap">
            <div class="main_nav">
                <ul class="left_ul">
                    <li>회사소개</li>
                    <li>회사소개</li>
                    <li>회사소개</li>    
                </ul>
            </div>
        </div>

        <div class="main_naviwrap">
            <div class="main_nav">
                <ul class="right_ul">
                    <li>모임</li>
                    <li>게시판</li>
                    <li>카페</li>
                    <li>게임</li>    
                </ul>
            </div>
        </div>
    </header>


    <nav class="navbar navbar-light" style="background-color: #D6E9FF;">
    <ul class="nav-button">
        <li><button type="button" id="btn_cafe_cafeidx_search" class="btn btn-outline-danger" value="cafeIdx">등록순</button></li>
        <li><button type="button" id="btn_cafe_rating_search" class="btn btn-outline-success btn_cafe_star_search" value="cafeRating">평점순</button></li>
        <li><button type="button" id="btn_cafe_address_search" class="btn btn-outline-info btn_cafe_review_search" value="cafeAddress">지역순</button></li>
    </ul>
        <form class="form-inline">
            <select class="btn btn-outline-primary my-2 my-sm-0">
              <option>카페명</option>
              <option>지역</option>
            </select>
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>


    <div class="card-deck">
 		<c:forEach items="${cafelist}" var="cafe">
			<div class="card hvr-underline-from-center fade-in" <%--onclick="${카페 페이지 경로}"--%>>
				<img class="card-img-top" src="<%-- ${이미지 경로} --%>" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">${cafe.cafeName}</h5>
					<p class="card-text" style="text-align: right;">${cafe.stdFee}<br>${cafe.tenPerFee}</p>
				</div>
				<div class="card-footer" style="text-align: center;">
					<small class="text-primary">${cafe.cafeAddress}</small>
				</div>
			</div>
    	</c:forEach>
    </div>

    
    

</body>

<script>


</script>

</html>