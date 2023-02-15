package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;
import board.vo.Comment;
import board.vo.Like;
import board.vo.showBoard;

public class BoardService {

	public List<showBoard> getAllBoard() {
		BoardDao dao = new BoardDao();
		List<showBoard> list = dao.selectAll();
		
		return list;
	}

	public void createPost(Board newpost) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.insertPost(newpost);
		if(count == 0)
		{
			System.out.println("글 작성 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 새 글작성");
		}
	}

	public Board getContent(Board content) {
		BoardDao dao = new BoardDao();
		Board board = dao.selectOne(content);
		return board;
	}

	public int putComment(Comment cmt) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.insertComment(cmt);
		if(count == 0)
		{
			System.out.println("댓글 작성 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 기입");
		}
		return count;
	}

	public List<Comment> getAllComments(int num) {
		BoardDao dao = new BoardDao();
		List<Comment> list = dao.selectList(num);
		return list;
	}

	public Comment getLastNum() {
		BoardDao dao = new BoardDao();
		Comment cmt = dao.selectNum();
		return cmt;
	}

	public showBoard getName(showBoard sb) {
		BoardDao dao = new BoardDao();
		showBoard board = dao.getName(sb);
		return board;
	}

	public int updateComment(Comment cmt) {
		
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.updateComment(cmt);
		if(count == 0)
		{
			System.out.println("댓글 수정 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 수정");
		}
		return count;
	}

	public Comment getUpdatedComment(Comment cmt) {
		BoardDao dao = new BoardDao();
		Comment newcmt = dao.selectUpdated(cmt);
		return newcmt;
	}

	public int deleteComment(Comment cmt) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.deleteComment(cmt);
		if(count == 0)
		{
			System.out.println("댓글 삭제 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 삭제");
		}
		return count;
	}

	public int updatePost(Board board) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.updatePost(board);
		if(count == 0)
		{
			System.out.println("게시글 수정 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 게시글 수정");
		}
		return count;
	}

	public int deletePost(Board board) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.deleteBoard(board);
		
		if(count==0)
		{
			System.out.println("게시글 삭제 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 게시글 삭제");
		}
		return count;
	}

	public int insertLike(Like like) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.insertLike(like);
		
		if(count==0)
		{
			System.out.println("좋아요 insert 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 좋아요 insert");
		}
		return count;
	}

	public Like getIsExist(Like like) {
		BoardDao dao = new BoardDao();
		Like checklike = dao.selectCheckLike(like);
		return checklike;
	}

	public int deleteLike(Like like) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.deleteLike(like);
		
		if(count==0)
		{
			System.out.println("좋아요 delete 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 좋아요 delete");
		}
		return count;
	}

	public int updatesubLike(Board board) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.updatesubLike(board);
		
		if(count==0)
		{
			System.out.println("좋아요 감소 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 좋아요 감소");
		}
		return count;
	}

	public int updateplusLike(Board board) {
		BoardDao dao = new BoardDao();
		int count = 0;
		count = dao.updateplusLike(board);
		
		if(count==0)
		{
			System.out.println("좋아요 증가 오류");
		}else if(count==1)
		{
			System.out.println("성공적으로 좋아요 증가");
		}
		return count;
	}

	public int getLikeNum(Board board) {
		BoardDao dao = new BoardDao();
		int countlike = dao.getCountLike(board);
		return countlike;
	}

}
