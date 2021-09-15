<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty loginChk}">
<script>
function makeRedirect(){
	var redirectUri = window.location.href;
	sessionStorage.setItem("redirectUri", redirectUri);
	location.href= '<c:url value="/member/login"/>' ;
}
</script>
<script>
	alert('로그인 후 사용이 가능합니다.');

	makeRedirect();
</script>

</c:if> 

<!DOCTYPE html>  <!-- 문서의 첫행 표시, 웹 브라우저에 HTML5 임을 알림 -->
<html lang="ko"> <!-- 시작, lang 속성 입력(생략가능)-->
<head> <!-- 페이지의 필요한 추가 속성 작성 -->
    <meta charset="UTF-8"> <!-- 출력 포맷 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 모바일 페이지 속성 -->
    <title>Come on, Board : Cafe Registry Img</title> <!-- 문서 제목 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="<c:url value="/css/cafe_regForm.css"/>" type="text/css">
	<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>

<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp" %>

    <div class="cafe_wrap">   
        <div class="info"> 
        
        <h5 class="info_menu">카페 정보 등록</h5>
        <hr class="first_hr">
			<!-- 이미지를 제외한 기본 정보 등록  enctype="multipart/form-data" -->
<%--             <form method="post" enctype="multipart/form-data" id="cafeInfo">
            	<input type="hidden" name="memIdx" value="${loginInfo.memIdx}">
 
				                
				<label for="cafeThumbnail">썸네일 미리보기</label>
				<input type="file" name="cafeThumbnailFile" id="cafeThumbnail">	
				<div id="thumbnail" class="form-control mb-2">
				</div>
				 <!--        				
 				<label for="cafeImg">이미지 미리보기</label>
				<input type="file" multiple="multiple" name="cafeImg" id="cafeImg">
				<div id="preview" class="form-control mb-2">
				</div>
 				 -->
			    <button type="button" id="btn_cafe_info_submit" class="btn btn-primary col text-center mb-2">등록</button>
            </form>
             --%>
             <form method="post" enctype="multipart/form-data" id="cafeInfo2">
            	<input type="hidden" name="memIdx" value="${loginInfo.memIdx}">
 
				                
				<!-- <label for="cafeThumbnail">썸네일 미리보기</label>
				<input type="file" name="cafeThumbnail" id="cafeThumbnail">	
				<div id="thumbnail" class="form-control mb-2">
				</div> -->
				      				
 				<!-- <label for="cafeImg">이미지 미리보기</label> -->
				<input type="file" multiple="multiple" name="cafeImgFile" id="cafeImg">
				<!-- <div id="preview" class="form-control mb-2">
				</div> -->
 				 
			    <button type="button" id="btn_cafe_info_submit2" class="btn btn-primary col text-center mb-2">등록</button>
            </form>
            
            <hr>
        </div>  
    </div>

</body>
	
<script>


// 정보 입력시 빈값 체크
$('#btn_cafe_info_submit2').click(function(){
	
	var cafeThumbnail = $('#cafeImg').val();
	
	// 입력 확인
	if(!cafeThumbnail.trim().length) {   
		alert('이미지를 첨부해주세요.');
		$('#cafeName').focus();
		return;
	}
	// 폼 서밋
	$('#cafeInfo2').submit();	
	
});
/* 
//정보 입력시 빈값 체크
$('#btn_cafe_info_submit').click(function(){
	
	var cafeThumbnail = $('#cafeThumbnail').val();
	
	// 입력 확인
	if(!cafeThumbnail.trim().length) {   
		alert('이미지를 첨부해주세요.');
		$('#cafeName').focus();
		return;
	}
	// 폼 서밋
	$('#cafeInfo').submit();	
	
});
 */

</script>


	

</html>