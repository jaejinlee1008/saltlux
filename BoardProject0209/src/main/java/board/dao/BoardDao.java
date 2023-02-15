package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import board.vo.Comment;
import board.vo.Like;
import board.vo.showBoard;
import common.mybatis.MyBatisConnectionFactory;

public class BoardDao {

	public List<showBoard> selectAll() {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<showBoard> list = session.selectList("myshowBoard.allBoards");
		session.close();
		return list;
	}

	public int insertPost(Board newpost) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.insert("myBoard.insertPost",newpost);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public Board selectOne(Board content) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Board board = session.selectOne("myBoard.contentboard",content);
		session.close();
		return board;
	}

	public int insertComment(Comment cmt) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.insert("myComment.insertComment",cmt);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public List<Comment> selectList(int num) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Comment> list = session.selectList("myComment.getComments",num);
		session.close();
		return list;
	}

	public Comment selectNum() {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Comment cmt = session.selectOne("myComment.getLastOne");
		session.close();
		return cmt;
	}

	public showBoard getName(showBoard sb) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		showBoard board = session.selectOne("myshowBoard.getName", sb);
		session.close();
		return board;
	}

	public int updateComment(Comment cmt) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.update("myComment.updateComment",cmt);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public Comment selectUpdated(Comment cmt) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Comment newcmt = session.selectOne("myComment.getUpdated",cmt);
		session.close();
		return newcmt;
	}

	public int deleteComment(Comment cmt) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.delete("myComment.deleteComment",cmt);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int updatePost(Board board) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.update("myBoard.updatePost",board);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int deleteBoard(Board board) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.delete("myBoard.deleteBoard",board);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int insertLike(Like like) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.insert("myLike.insertLike",like);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public Like selectCheckLike(Like like) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Like checklike = session.selectOne("myLike.getLike", like);
		session.close();
		return checklike;
	}

	public int deleteLike(Like like) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.delete("myLike.deleteLike",like);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int updatesubLike(Board board) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.delete("myBoard.subLike",board);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int updateplusLike(Board board) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.delete("myBoard.plusLike",board);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int getCountLike(Board board) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int countlike = session.selectOne("myBoard.getLikeCount", board);
		session.close();
		return countlike;
	}



}
