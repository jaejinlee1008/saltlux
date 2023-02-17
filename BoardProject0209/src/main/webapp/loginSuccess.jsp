<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.showBoard, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP에서는 나에게 할당된 session객체를 그냥 사용 가능 => session -->
	<% Member member = (Member)session.getAttribute("member"); %>
	<h1><%= member.getMemberName() %>님 환영합니다.</h1>
	<div align="right" style="width:550px"><a href="editmember.jsp">회원정보수정</a>&nbsp&nbsp<a href="logout">로그아웃</a></div>
	<h3>게시글 목록
		<div align="right" style="width:550px">
			<form action="newPost.jsp" method="post">
			<button>새글작성</button>
			</form>
		</div>
	</h3> 
	<table border="1" width="550">
		<thead>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>댓글수</th>
			<th>좋아요</th>
		</thead>
		<tbody>
			<%
				List<showBoard> list = (List<showBoard>)session.getAttribute("boardList");
				for(showBoard board:list)
				{
			%>
			
			<tr>
				<td><%= board.getBoardNum() %></td>
				<td><a href="content?num=<%= board.getBoardNum() %>"><%= board.getBoardTitle() %></a></td>
				<td><%= board.getMemberName() %></td>
				<td><%= board.getBoardDate() %></td>
				<td><%= board.getCommentCount() %></td>
				<td><%= board.getBoardLike() %></td>
			</tr>
			
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>