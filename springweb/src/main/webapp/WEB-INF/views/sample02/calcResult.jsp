<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산 성공</h1>
	<h3>연산 결과 : ${ msg }</h3>

	<% pageContext.setAttribute("msg", "소리없는 아우성"); %>
	<!-- pageContext의 scope는 이 jsp페이지 안 이다. jsp페이지 내부에서만 사용이 가능하다. -->
	<br>
	<h3>request.getAttribute("msg") - 결과는 : <%= request.getAttribute("msg") %></h3>
	<h3>$ {msg} - 결과는 : ${msg}</h3>
	<h3>${param.firstNum } + ${param.secondNum} = ${msg}</h3>
	<h3>${pageScope.myData}</h3>
	
	<a href="${header.referer }">뒤로가기</a>
	
</body>
</html>