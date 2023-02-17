<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>회원가입</h1>
	<form action="join" method="post">
		아이디: <input type="text" id="id" name="userID" >&nbsp<input type="button" onclick="myClick()" value="중복체크">
		<br><br>
		이름: <input type="text" name="userName">
		<br><br>
		비밀번호: <input type="password" id="pw" name="userPW">
		<br><br>
		비밀번호확인: <input type="password" id="pwcheck" onkeyup="myKeyUp()">
		<div id="canUse"></div>
		<br><br>
		<button type="submit">회원가입</button>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	</form>
	<form action="login.html" method="post"> 
		<button>취소</button>
	</form>
</body>
<script>
function myClick(){
	console.log($('#id').val());
	$.ajax({
		url:"idcheck",
		type:"POST",
		dataType:"json",
		data:{
			userId : $("#id").val()
		},
		success: function(data){
			if(data.canUse)
			{
				alert("사용가능한 ID입니다.");
			}else
			{
				alert("중복된 ID입니다.");
			}
		}
	})
}
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