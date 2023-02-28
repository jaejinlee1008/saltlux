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
	<h1>장바구니</h1>
	<ul>
		<li>담은 사과의 수 : ${ myFruit.apple }</li>
		<li>담은 바나나의 수 : ${ myFruit.banana }</li>
		<li>담은 한라봉의 수 : ${ myFruit.halabong }</li>
	</ul>
	
	<a href="resources/buyfruit/buyFruit.html">상품구매페이지로 이동</a>
</body>
</html>