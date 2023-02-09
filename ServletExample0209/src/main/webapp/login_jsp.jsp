<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 입력받고
		// 2. 로직처리
		// 	  MyBatis 처리 코드
		// 3. 출력은 HTML에 끼워넣기
	%>
	<% 
		String name = "홍길동";
		for(int i=0;i<5;i++)
		{
			
	%>
		<h1>반복됩니다</h1>
	<% 
		}
	%>
	이것은 소리없는 아우성
	사용자의 이름은 : <%= name %>입니다.
</body>
</html>