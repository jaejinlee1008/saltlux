package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {
	public BookDAO() {
		
	}
	
	private SqlSessionFactory factory;
	
	public BookDAO(SqlSessionFactory factory)
	{
		this.factory=factory;
	}

	public HashMap<String, Object> selectByISBNHashMap(String isbn) {
		HashMap<String, Object> map = null;
		
		
		SqlSession session = factory.openSession();
		
		map = session.selectOne("example.myBook.selectBookByISBNHashMap",isbn);
		
		return map;
	}

	

	public List<HashMap<String, Object>> selectAllHashMap() {
		List<HashMap<String,Object>> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("example.myBook.selectAllHashMap");
		
		return list;
	}

	public BookVO selectByISBNBookVO(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		book = session.selectOne("example.myBook.selectByISBNBookVO",isbn);
		return book;
	}

	public BookVO selectByISBNResultMap(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession();
		try {
			book = session.selectOne("example.myBook.selectByISBNResultMap",isbn);
		} finally {
			session.close();
		}
		return book;
	}

	public int updateByISBN(BookVO book) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.update("example.myBook.update", book);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.commit();
			session.close();
		}
		
		
		return result;
	}
}
