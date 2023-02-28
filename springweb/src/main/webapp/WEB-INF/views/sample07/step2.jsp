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
	<h1>Step2 - 사용자 세부 정보를 입력하세요</h1>
	<form action="/springweb/memberRegisterStep3" method="post">
		취미 : <input type="text" name = "memberHobby"><br><br>
		자기소개 : <input type="text" name = "memberContent"><br><br>
		<input type="submit" value="저장">
	</form>
	<form action="/springweb/memberRegisterStep1" method="post">
		<input type="submit" value="첫 번째 페이지로 이동">
	</form>
</body>
</html>