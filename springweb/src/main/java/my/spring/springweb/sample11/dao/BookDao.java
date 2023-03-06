package my.spring.springweb.sample11.dao;

import java.util.List;

import my.spring.springweb.sample11.vo.Book;

public interface BookDao {

	int getBookCount();
	
	List<Book> getAllBooks();
	
	List<Book> getSearchBook(String str);
}
