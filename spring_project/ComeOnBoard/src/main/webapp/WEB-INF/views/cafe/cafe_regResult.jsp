<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${cafeRegResult == 0}">
<script>
	alert('서버의 오류가 생겨 등록에 실패했습니다.'/n'잠시 후 다시 시도해주세요.');
	history.back();
</script>
</c:if>   
<c:if test="${cafeRegResult == 1}">
<script>
	alert('등록되었습니다.');
	location.replace('<c:url value="/cafe/cafe_list"/>'); 
</script>
</c:if>  
