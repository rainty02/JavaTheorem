<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${payResult = 'success'}">
	<script>
	alert('결제되었습니다.');
	window.close();
	</script>
</c:if>

<c:if test="${payResult = 'fail'}">
	<script>
	alert('오류가 발생하여 결제에 실패했습니다.\n잠시 후 다시 시도해주세요.');
	window.close();
	</script>
</c:if>   

<c:if test="${payResult = 'cancel'}">
	<script>
	alert('결제가 취소되었습니다.');
	window.close();
	</script>
</c:if>   
