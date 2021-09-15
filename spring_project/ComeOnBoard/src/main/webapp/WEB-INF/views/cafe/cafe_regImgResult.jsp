<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${resultThumbnail == 0}">
<script>
	alert('서버의 오류가 생겨 등록에 실패했습니다.'\n'잠시 후 다시 시도해주세요.');
</script>
</c:if>   
<c:if test="${resultThumbnail == 1}">
<script>
	alert('등록되었습니다.');
</script>
</c:if>
<c:if test="${resultImg} != ${requestNum}">
<script>
	alert('서버의 오류가 생겨 등록에 실패했습니다.''잠시 후 다시 시도해주세요.');
	alert('이미지 '+${resultImg}+'개가 등록되었습니다.');
</script>
</c:if>  
<c:if test="${resultImg == requestNum}">
<script>
	alert('등록되었습니다.');
	alert('이미지 '+${resultImg}+'개가 등록되었습니다.') ;
</script>
</c:if>  

