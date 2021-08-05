<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>파일 업로드 : report 제출</h1>
	<hr>
	
		<h3>Command 객체 파일 업로드</h3>
	<form action="upload3" method="post" enctype="multipart/form-data">
	
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
	<hr>

		<h3>MultipartHttpServletRequset 파일 업로드</h3>
	<form action="upload2" method="post" enctype="multipart/form-data">
	
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
	<hr>
	
	<h3>@RequeatParam 파일 업로드</h3>
	<form action="upload1" method="post" enctype="multipart/form-data">
	
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="report"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
	<hr>

</body>
</html>