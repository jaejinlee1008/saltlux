<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산시 오류 발생</h1>
	<h3>오류의 원인 : ${ msg }</h3>
	<h3>오류의 원인 : <%= request.getAttribute("msg") %></h3>
	<h3>오류의 원인 : ${ requestScope.msg }</h3>
</body>
</html>