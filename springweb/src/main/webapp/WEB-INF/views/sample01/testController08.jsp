<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>08 호출됨!!</h1>
	
	<%-- jsp의 주석 --%>
	<h3>EL을 이용해서 데이터를 추출하는 다양한 방법.</h3>
	<ul>
		<li>문자열 출력 1 : ${"test"}</li>
		<li>문자열 출력 2 : ${'test'}</li>  <%-- EL안에 "",''안의 문자열은 변수가 아닌 문자열 그 자체로 출력됨 --%>
		<li>숫자 출력 : ${3.141592}</li>   <%-- 숫자는 그냥 그대로 출력 --%>
		<li>논리값 출력 : ${true} </li>    <%-- 논리값 그대로 출력 --%> 
		<li>null 출력 : ${null} </li>    <%-- null은 출력이 안된다. --%>
		<li>list 출력 : ${myList[0]} </li> <%-- ArrayList index이용해서 access 가능 --%>
		<li>VO 출력 : ${myUser.userName} </li> <%-- ArrayList index이용해서 access 가능 --%>
		<li>Map : ${ myName} </li>
		<li>param 객체 이용 : ${param.userName} </li>
		<li>header객체 이용 : ${header.referer}</li> <%-- 이전 페이지의 주소를 출력, 뒤로가기 버튼을 만들 때 사용 --%>
		<li>산술연산(+,-,*,/,%)할 수 있다 : ${param.userAge + 20}</li>
		<li>논리연산(&&,||,!)할 수 있다 : ${ !false }</li>
		<li>비교연산(==,!=,비교연산자사용가능) : ${param.userAge<20}</li>
		<li>삼항연산( 논리 ? a : b ) : ${ param.userAge<20 ? "미성년자" : "성인" }</li>
		<li>empty 연산 : ${empty "" } - true</li>
		<li>empty 연산 : ${empty "abcd" } - false</li>
		<li>empty 연산 : ${empty null } - true</li>
		<li>empty 연산 : ${empty myList } - false</li>
	</ul>
	
	<a href="${header.referer}">뒤로가기</a>
</body>
</html>