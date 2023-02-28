<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수행된 결과입니다.</h1>
	
	<h2>RequestScope</h2>
	<h3>requestScope.data1 : ${ requestScope.data1 }</h3>
	<h3>requestScope.data2 : ${ requestScope.data2 }</h3>
	<h3>param.msg : ${ param.msg }</h3>
	<h3>requestScope.newStudent : ${ requestScope.newStudent }</h3>
	
	<hr>
	
	<h2>sessionScope</h2>
	<h3>sessionScope.data1 : ${ sessionScope.data1 }</h3>
	<h3>sessionScope.data2 : ${ sessionScope.data2 }</h3>
	<h3>sessionScope.newStudent : ${ sessionScope.newStudent }</h3>
	
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>