<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/First-Web/blog/css/myblog.css">l
<!-- http://loaclhost:8080/First-Web/blog/css/myblog.css -->
<style>
</style>
<script>
</script>
</head>
<body>
<div id="main_wrap">
        <!-- header 시작 -->
        <%@ include file = "includeBlog/header.jsp" %>
        <!-- header 끝 -->

        <!-- navigation 시작 -->
        <%@ include file = "includeBlog/nav.jsp" %>
        <!-- navigation 끝 -->

        <!-- 컨텐츠 영역 시작 -->
        <div id="content_wrap">
        	<section>
            	<%@ include file = "includeBlog/content1.jsp" %>
            	<%@ include file = "includeBlog/content2.jsp" %>
            </section>

            <aside>
                <%@ include file = "includeBlog/profile.jsp" %>
                <%@ include file = "includeBlog/category.jsp" %>
            </aside>
        </div>
        <!-- 컨텐츠 영역 끝 -->

        <!-- footer 시작 -->
        <%@ include file = "includeBlog/footer.jsp" %>
        <!-- footer 끝 -->

    </div>
</body>
</html>