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
	<!-- 변수를 만들고 값을 할당할 수 있다. -->
	<%
		int k=100;
	%>
	<c:set var="num1" value="100" />
	<!-- 제어문 중 대표적인 제어문 if문 -->
	<c:if test="${ num1 + myNum > 100 }">
		100보다 커요
	</c:if>
	
	<!-- 일반적으로 조건이 여러개인 경우는 c:if대신 다른걸 사용 -->
	<c:choose>
		<c:when test="${ num1 + myNum > 50 }">
			50보다 커요
		</c:when>
		<c:when test="${ num1 + myNum > 100 }">
			100보다 커요
		</c:when>
		<c:when test="${ num1 + myNum > 300 }">
			300보다 커요
		</c:when>
		<c:otherwise>
			이도저도아님
		</c:otherwise>
	</c:choose>
	
	<br><br>
	<!-- 반복문 -->
	<!-- 기본적인 형태 - 반복횟수를 알려줘서 반복하는 경우 -->
	<ul>
	<c:forEach var="tmp" begin="1" end="5" step="2">
		<li>${ tmp }</li>
	</c:forEach>
	</ul>
	
	<!-- 일반적으로 집합자료구조를 이용한 반복처리를 많이 한다 -->
	<ul>
	<c:forEach var="name" items="${ myList }">
		<li>${ name }</li>
	</c:forEach>
	</ul>
	
	<!-- fmt를 사용하기 위해 변수를 하나 선언 -->
	<c:set var="number" value="123456789" />
	<br><br>
	
	<!-- 숫자 표현할 때 3마리마다 콤마 표시 -->
	<fmt:formatNumber value="${ number }"/>
	<br><br>
	
	<!-- 화폐단위  -->
	<fmt:formatNumber value="${ number }" type="currency" />
	
	<!-- fmt를 사용하기 위해 변수를 하나 선언 -->
	<c:set var="number" value="0.783" />
	<br><br>
	
	<!-- 화폐단위  -->
	<fmt:formatNumber value="${ number }" type="percent" />
	<br><br>
</body>
</html>