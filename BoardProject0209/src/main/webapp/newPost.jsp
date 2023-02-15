<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새 글 작성</h1>
	<h3>글쓴이 : <%= ((Member)session.getAttribute("member")).getMemberName() %></h3>
	<h3>글쓴이 id : <%= ((Member)session.getAttribute("member")).getMemberId() %></h3>
	<form action="newboard" method="post">
		<h3>
			제목 <br>
			<input type="text" name="title">
			<br>
			내용<br>
			<textarea name="content" rows="25" cols="100"></textarea>
			<br><br>
			<button>작성완료</button>
		</h3>
	</form>
</body>
</html>