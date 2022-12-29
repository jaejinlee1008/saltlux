package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

public class BookSearchController {

	public ObservableList<BookVO> getResult(String input) {
		
		BookService service = new BookService();
		ObservableList<BookVO> list =  service.getSelectedBykeyword(input);
		
		return list;
	}

}
