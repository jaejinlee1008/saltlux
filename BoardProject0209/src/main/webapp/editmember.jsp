<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" 
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" 
        crossorigin="anonymous">
</script>
</head>
<body>
	<% Member member = (Member)session.getAttribute("member"); %>
	<h1>회원정보수정</h1>
	<div align="right" style="width:550px"><a href="deletemember?id=<%= member.getMemberId() %>">회원탈퇴</a></div>
	<form action="editmember" method="post">
		아이디: <input type="text" id="id" name="userID" value="<%= member.getMemberId() %>" readonly>
		<br><br>
		이름: <input type="text" name="userName" value="<%= member.getMemberName() %>" readonly>
		<br><br>
		새로운비밀번호: <input type="password" id="pw" name="newPW">
		<br><br>
		비밀번호확인: <input type="password" id="pwcheck" onkeyup="myKeyUp()">
		<br>
		<div id="canUse"></div>
		<div align="center" style="width:280px"><button type="submit">회원정보수정</button></div>
	</form>
	<form action="login"> 
		<button>취소</button>
	</form>
</body>
<script type="text/javascript">

function myKeyUp(){
	if($('#pw').val()!=$('#pwcheck').val())
	{
		console.log($('#pw').val());
		console.log($('#pwcheck').val());
		$('#canUse').text('비밀번호가 일치하지 않습니다');
	}else
	{
		$('#canUse').text('비밀번호가 일치합니다.');
	}
}
</script>
</html>