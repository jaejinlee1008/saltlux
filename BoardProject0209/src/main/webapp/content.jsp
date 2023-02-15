<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.vo.Board, board.vo.showBoard , member.vo.Member, board.vo.Comment, java.util.List, java.util.Date"  %>

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
	<% Board board = ((Board)session.getAttribute("Board")); 
		Member member = (Member)session.getAttribute("member");
		showBoard sboard = ((showBoard)session.getAttribute("showBoard"));
	%>
	<div align="right" style="width:400px">유저 : <%= member.getMemberName() %></div>
	<h1>게시글 보기</h1>
	<div>작성일자 : <%= board.getBoardDate() %></div>
	<div>작성자 : <%= sboard.getMemberName() %>(<%= board.getBoardAuthor() %>)</div>
	<div>좋아요 수 : <span id="like"><%= board.getBoardLike() %></span>
	<button id="likeBtn" onclick="likeUpdate('<%= board.getBoardNum() %>','<%= member.getMemberId() %>','<%= board.getBoardAuthor() %>')">
			👍	
	</button> 
	</div>
	<div>제목 : 
	<input type="text" id = "title" 
	ondblclick="updatePostTitle('<%= board.getBoardNum() %>','<%= member.getMemberId() %>','<%= board.getBoardAuthor() %>')"
	value="<%= board.getBoardTitle() %>" readonly/>
	</div>
	<div>내용</div>
	<div>
	<textarea id = "content" 
	ondblclick="updatePostContent('<%= board.getBoardNum() %>','<%= member.getMemberId() %>','<%= board.getBoardAuthor() %>')"
	rows="5" cols="50" readonly><%= board.getBoardContent() %>
	</textarea>
	</div>
	<div align="center" style="width:380px">
	<button onclick="updateApplyPost('<%=board.getBoardNum()%>','<%= member.getMemberId() %>','<%= board.getBoardAuthor() %>')">수정</button>
	<button onclick="deletePost('<%=board.getBoardNum()%>','<%= member.getMemberId() %>','<%= board.getBoardAuthor() %>')">삭제</button>
	</div>
	<hr>
	
	<div><textarea id="comment" name="comment" rows="5" cols="50"></textarea></div>
	<div align="center" style="width:380px"><button id="commentBtn">댓글작성</button></div>
	
	<hr>
	<div id="showComment">
	<%
		List<Comment> list = (List<Comment>)request.getAttribute("commentList");
		if(list != null)
		{
			for(Comment comment:list)
			{
	%>
	<div><%= comment.getCWName() %>(<%= comment.getCWId() %>) : <%= comment.getCommentDate() %></div>
	<div><textarea id = "cmt<%= comment.getCommentNum() %>" ondblclick="updateCmt2('<%=comment.getCommentNum()%>','<%= member.getMemberId() %>','<%= comment.getCWId() %>')" rows="5" cols="50" readonly><%= comment.getCommentContent() %></textarea></div>
	<div align="center" style="width:380px">
	<button onclick="updateApplyCmt2('<%=comment.getCommentNum()%>','<%= member.getMemberId() %>','<%= comment.getCWId() %>')">수정</button>
	<button onclick="deleteCmt2('<%=comment.getCommentNum()%>','<%= member.getMemberId() %>','<%= comment.getCWId() %>','<%= comment.getPostNum()%>')">삭제</button>
	</div>
	<hr>
	
	<%
			}
		}
	%>
	</div>
	
</body>
<script type="text/javascript">
$("#commentBtn").click(function(){
	$.ajax({
		url:"comment",
		type:"POST",
		dataType:"json",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data:{
			num : '<%=board.getBoardNum()%>',
			comment : $("#comment").val()
		},
		success: function(data){
			$('#comment').val("");
			putComment(data,'<%= member.getMemberId() %>'); 
		}
	})
	
});
function putComment(data,Id){
	let html = "";
	
	$("#showComment").html(html);
	
	const target = $("#showComment");
	$.each(data,function(index,item){
		let name = item.CWName+"("+item.CWId+")"+item.commentDate;
		let num = item.commentNum;
		let id = Id;
		let CWId = item.CWId;
		let postNum = item.postNum;
		let cmtId = 'cmt'+num;
		const divN = $('<div></div>').text(name);
		const divC = $('<div></div>');
		const textarea = $('<textarea></textarea>').attr('id',cmtId).attr('rows','5').attr('cols','50').attr('readonly','readonly').
							text(item.commentContent).dblclick({num:num,id:id,cwid:CWId},updateCmt);
		divC.append(textarea);
		const divB = $('<div></div>').attr('align','center').attr('style','width:380px');
		const editBtn = $('<button>수정</button>').click({num:num,id:id,cwid:CWId},updateApplyCmt);
		const deleteBtn = $('<button>삭제</button>').click({num:num,id:id,cwid:CWId,postNum:postNum},deleteCmt);
		divB.append(editBtn);
		divB.append(deleteBtn);
		target.append(divN);
		target.append(divC);
		target.append(divB);
		
	});
}
function updateCmt(e){
	console.log('댓글 번호'+e.data.num);
	if(e.data.id!=e.data.cwid)
	{
		alert("수정불가!");
	}else
	{
		console.log("수정가능");
		$('#cmt'+e.data.num).attr("readonly",false);
	}
}
function updateApplyCmt(e){
	console.log(e.data.num);
	if(e.data.id!=e.data.cwid)
	{
		alert("수정불가!");
	}else
	{
		
		console.log("수정가능");
		
		alert($('#cmt'+e.data.num).val());
		
		$.ajax({
			url:"updatecomment",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : e.data.num,
				comment : $('#cmt'+e.data.num).val()
			},
			success: function(data){
				$('#cmt'+e.data.num).attr("readonly",true);
				console.log("수정성공~~~~~");
				alert("수정 성공!!!!!!!!!!!!!!!!!!!!!!!!!"); 
			}
		})
	}
}
function updateCmt2(num,id,cwid){
	console.log(num);
	if(id!=cwid)
	{
		alert("수정불가!");
	}else
	{
		console.log(id);
		console.log(cwid);
		console.log("수정가능");
		
		$('#cmt'+num).attr("readonly",false);
	}
}
function updateApplyCmt2(num,id,cwid){
	console.log(num);
	if(id!=cwid)
	{
		alert("수정불가!");
	}else
	{
		
		console.log("수정가능");
		
		alert($('#cmt'+num).val());
		
		$.ajax({
			url:"updatecomment",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : num,
				comment : $('#cmt'+num).val()
			},
			success: function(data){
				$('#cmt'+num).attr("readonly",true);
				console.log("수정성공~~~~~");
				alert("수정 성공!!!!!!!!!!!!!!!!!!!!!!!!!"); 
			}
		})
	}
}
function deleteCmt(e){
	console.log(e.data.num);
	if(e.data.id!=e.data.cwid)
	{
		alert("삭제불가!");
	}else
	{
		console.log(e.data.id);
		console.log(e.data.cwid);
		console.log("삭제가능");
		$.ajax({
			url:"deleteservlet",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : e.data.num,
				postNum : e.data.postNum
			},
			success: function(data){
				putComment(data,'<%= member.getMemberId() %>');
				alert("삭제 성공!!!!!!!!!!!!!!!!!!!!!!!!!"); 
			}
		});
	}
}
function deleteCmt2(num,id,cwid,postNum){
	console.log(num);
	if(id!=cwid)
	{
		alert("삭제불가!");
	}else
	{
		console.log(id);
		console.log(cwid);
		console.log("삭제가능");
		$.ajax({
			url:"deleteservlet",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : num,
				postNum : postNum
			},
			success: function(data){
				putComment(data,'<%= member.getMemberId() %>');
				alert("삭제 성공!!!!!!!!!!!!!!!!!!!!!!!!!"); 
			}
		});
	}
}
function updatePostTitle(num,id,bid){
	
	if(id!=bid)
	{
		alert("게시판 수정불가!");
	}else
	{
		console.log(id);
		console.log(bid);
		console.log("게시판 제목 수정가능");
		$('#title').attr("readonly",false);
	}
}
function updatePostContent(num,id,bid){
	
	if(id!=bid)
	{
		alert("게시판 수정불가!");
	}else
	{
		console.log(id);
		console.log(bid);
		console.log("게시판 내용 수정가능");
		$('#content').attr("readonly",false);
	}
}
function updateApplyPost(num,id,bid){
	
	if(id!=bid)
	{
		alert("게시판 수정불가!");
	}else
	{
		$.ajax({
			url:"updatepost",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : num,
				title : $('#title').val(),
				content : $('#content').val()
			},
			success: function(data){
				$('#title').attr("readonly",true);
				$('#content').attr("readonly",true);
				alert("게시판 수정 성공!!!!!!!!!!!!!!!!!!!!!!!!!"); 
			}
		})
	}
}
function deletePost(num,id,cwid){
	console.log(num);
	if(id!=cwid)
	{
		alert("게시판 삭제불가!");
	}else
	{
		console.log(id);
		console.log(cwid);
		console.log("게시판 삭제가능");
		$.ajax({
			url:"deletepost",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : num,
			},
			success: function(data){
				console.log("삭제가 성공했는데");
				let url='login';
				alert("삭제 성공!!!!!!!!!!!!!!!!!!!!!!!!!");
				location.replace(url);
			}
		});
	}
}
function likeUpdate(num,id,bid){
	if(id==bid)
	{
		alert("자신의 글에는 좋아요를 누를 수 없습니다!");
	}else
	{
		$.ajax({
			url:"updatelike",
			type:"POST",
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			data:{
				num : num,
				id : id
			},
			success: function(data){
				if(data.counti==1)
				{
					$('#likeBtn').css('background-color','red');
					$('#like').text(data.likecount);
				}else if(data.countd==1)
				{
					$('#likeBtn').css('background-color','white');
					$('#like').text(data.likecount);
				}
				alert("좋아요 새로고침 성공");
			}
		});
	}
	
	
	
}
</script>
</html>