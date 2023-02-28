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
	<h1>model안의 데이터 : ${ v1 }</h1>
	<br><br>
	VO안의  데이터 : ${ v2.userName }
	<br><br>
	합은 : ${ sum }
	<br><br>
	<a href="${ header.referer }">뒤로가기</a>
</body>
</html>