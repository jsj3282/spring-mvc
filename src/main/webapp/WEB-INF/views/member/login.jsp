<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login.jsp페이지</h1>
	<% String test = (String)request.getAttribute("login"); %>
	request 결과 값 : <%=test %><br>
	el 표기법 : ${login }
	<br>
	<button name="logout" onclick="location.href='/springmvc01/logout'">로그아웃</button>
	<button name="index" onclick="location.href='/springmvc01/aaa'">기본페이지</button>
</body>
</html>