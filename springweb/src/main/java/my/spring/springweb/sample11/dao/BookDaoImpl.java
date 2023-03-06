package my.spring.springweb.sample11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springweb.sample11.vo.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getBookCount() {
		int count = session.selectOne("myBook.countBooks");
		return count;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = session.selectList("myBook.selectAll");
		return list;
	}

	@Override
	public List<Book> getSearchBook(String keyword) {
		
		List<Book> list = session.selectList("myBook.selectBookByKeyword",keyword);
		
		return list;
	}

	
}
