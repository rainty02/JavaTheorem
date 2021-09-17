<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="<c:url value="/css/groupManagement.css"/>">

<!-- 공통 헤더 부분.jsp파일이기 땜에 include사용 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
<%@ include file="/WEB-INF/views/frame/header.jsp"%>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>


<script>
	// 탈퇴 팝업창
	function popUp1() {
		document.getElementById('btn_exit_popUp1').style.display = "block";
	}
	function popUp2() {
		document.getElementById('btn_exit_popUp2').style.display = "block";
	}

	// 탈퇴 - 미완성
	function btn_exit1() {
		alert('모임을 탈퇴하였습니다');
		
	}
	function btn_exit2() {
		alert('모임을 탈퇴하였습니다');
	}

	// 팝업창 닫기
	function btn_close1() {
		document.getElementById('btn_exit_popUp1').style.display = "none";
	}
	function btn_close2() {
		document.getElementById('btn_exit_popUp2').style.display = "none";
	}
</script>

</head>


<body>
	<div id="wrap">
		<div class="main_div">
			
			<div id="div_for_label1"><label for="div1">내가 생성한 모임</label></div>
			<div id="div1" class="div">
				<c:forEach items="${readMyGameGroup}" var="list" varStatus="status">
				<div id="div1_1" class="secondary_div1">
					<a href="<c:url value="/group/readGroup?grpIdx=${list.grpIdx}"/>">${readMyGameGroup[status.index].grpTitle}</a>
					<br>
					<a href="<c:url value="/group/groupEditorMyGroup?grpIdx=${list.grpIdx}"/>">
						<input type="hidden" name="memIdx" value="${loginInfo.memIdx}">
						<input type="button" value="게시물관리" class="button">
					</a>
					<input type="button" value="탈퇴" class="button" onclick="popUp1()">
				</div>
				</c:forEach>
			</div>
			
			<div id="div_for_label2"><label for="div2" >참가한 모임</label></div>
			<div id="div2" class="div">
				<!-- 반복 처리 해주자 -->
				<div id="div2_1" class="secondary_div2">
					참여한 모임(게임명)1 
					<br>
					일시:
					<br>
					<input type="button" value="탈퇴" class="button2" onclick="popUp2()">
				</div>
			</div>
		</div>
	</div>

	<!-- 탈퇴버튼 -->
	<div id="btn_exit_popUp1">
		<h1>정말 탈퇴하시겠습니까?</h1>
		<input type="button" value="예" id="btn_exit" class="btn_shape"
			onclick="btn_exit1()"> <input type="button" value="아니오"
			id="btn_close" class="btn_shape" onclick="btn_close1()">
	</div>
	<div id="btn_exit_popUp2">
		<h1>정말 탈퇴하시겠습니까?</h1>
		<input type="button" value="예" id="btn_exit" class="btn_shape"
			onclick="btn_exit2()"> <input type="button" value="아니오"
			id="btn_close" class="btn_shape" onclick="btn_close2()">
	</div>




</body>

</html>